import kotlin.reflect.KClass
import ak.oss.kunitconverter.UnitConverter
import kotlin.reflect.KType
import kotlin.reflect.full.*
import kotlin.reflect.jvm.javaType

class DeclarationFileCreator{
    fun createDeclarationFile() {
        val c = UnitConverter::class

        val stringBuilder = StringBuilder("declare module 'k-unit-converter' {\nexport default UnitConverter\n")

        // Interfaces for category class
        iterateClassesOfMembers(c, stringBuilder, ::printInterfaceDeclaration)

        // UnitConverter class
        printUnitConverterClass(stringBuilder, c)

        // Conversion units
        stringBuilder.appendln("/**\n* All the available units\n*/\nexport declare namespace categories{")
        iterateClassesOfMembers(c, stringBuilder, ::printUnitEnums)
        stringBuilder.appendln("}")

        stringBuilder.append("}")
        println(stringBuilder)
    }

    private fun getTypeName(type: KType): String {
        val kTypeName = type.toString()
        val jTypeName = type.javaType.typeName

        return when {
            jTypeName.contains('$') -> kTypeName.substring(kTypeName.indexOf(".categories.") + 1)
            jTypeName.contains('.') -> kTypeName.substring(kTypeName.lastIndexOf('.') + 1)
            arrayOf("double", "int", "float", "byte", "long", "short").contains(jTypeName) -> "number"
            jTypeName == "char" -> "string"
            else -> jTypeName.toLowerCase()
        }
    }

    private fun printUnitConverterClass(stringBuilder: StringBuilder, c: KClass<UnitConverter>) {
        stringBuilder.appendln("export declare class UnitConverter {\n\tconstructor()")
        c.memberProperties.forEach {
            stringBuilder.appendln("\t" + it.name + ": " + getTypeName(it.returnType))
        }
        stringBuilder.appendln("}")
        stringBuilder.appendln()
    }

    private fun iterateClassesOfMembers(clazz: KClass<UnitConverter>, stringBuilder: StringBuilder, handler: (KClass<out Any>, StringBuilder) -> Unit) {
        clazz.memberProperties.map { it.returnType.classifier as KClass<out Any> }.distinctBy { it.simpleName }.forEach {
            handler(it, stringBuilder)
        }
    }

    private val anyNames = Any::class.memberFunctions.map { it.name }

    private fun printInterfaceDeclaration(clazz: KClass<out Any>, stringBuilder: StringBuilder) {
        stringBuilder.appendln("declare interface ${clazz.simpleName} {")
        clazz.memberFunctions.filter { !anyNames.contains(it.name) }.forEach {
            stringBuilder.appendln("\t" + it.name + "(" +
                    it.parameters.asSequence().filterIndexed { index, _ -> index > 0 }.joinToString(", ") { it.name + ": " + getTypeName(it.type) } +
                    "): " + getTypeName(it.returnType))
        }
        stringBuilder.appendln("}")
        stringBuilder.appendln()
    }

    private fun printUnitEnums(it: KClass<out Any>, stringBuilder: StringBuilder) {
        stringBuilder.appendln("\texport namespace " + it.simpleName + "{")
        it.nestedClasses.filter { it.java.isEnum }.forEach {
            stringBuilder.appendln("\t\texport declare enum "+it.simpleName+" {")
            stringBuilder.appendln(it.java.enumConstants.joinToString(",\n") { "\t\t\t" + it })
            stringBuilder.appendln("\t\t}")
        }
        stringBuilder.appendln("\t}")
        stringBuilder.appendln()
    }
}