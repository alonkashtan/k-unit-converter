package ak.oss.kunitconverter.categories

import ak.oss.kunitconverter.Name

abstract class UnitCategory<T> where T : Enum<T>, T : Unit {
    abstract val mainUnitName: String

    @Name("mainToUnit")
    open fun mainToUnit(value: Double, unit: T): Double = value / unit.inMainUnit

    @Name("unitToMain")
    open fun unitToMain(value: Double, unit: T): Double = value * unit.inMainUnit

    @Name("convert")
    fun convert(value: Double, fromUnit: T, toUnit: T): Double = mainToUnit(unitToMain(value, fromUnit), toUnit)
}

interface Unit {
    val inMainUnit: Double
}