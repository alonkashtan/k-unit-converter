package ak.oss.kunitconverter

/**
 * Used to give a name to functions that are public facing. Needed for JS to prevent mangling of function names
 * see [@JsName documentation](https://kotlinlang.org/docs/reference/js-to-kotlin-interop.html#jsname-annotation)
 * and [a disscution about the problem (with a solution)](https://discuss.kotlinlang.org/t/jsname-annotation-in-common-code-for-multiplatform-projects/5913/4)
 * for more information.
 */
expect annotation class Name(val name:String)