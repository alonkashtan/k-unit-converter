@file:JvmName("Runner")

package ak.oss
fun main(args: Array<String>) {
    if (args.count() != 1) System.err.println("Usage: pass destination path as only commandline argument")
    else DeclarationFileCreator().createDeclarationFile(args[0])
}