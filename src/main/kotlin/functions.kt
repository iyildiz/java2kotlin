@file:JvmName("FunctionUtil")

fun main() {
    println(methodWithDefaultParameters("abc"))
    println(methodWithDefaultParameters("abc", "("))
    println(methodWithDefaultParameters("abc", "(", ")"))
    println(methodWithDefaultParameters("abc", suffix=")"))//named argument used
    println(methodWithDefaultParameters(prefix = "(", message = "abc", suffix=")"))//named arguments in different order
    println("String ".extensionFunction(": extended"))
    println(inlineFunction { x, y -> x + y })
}

fun topLevelFunction() = 50

fun inlineFunction(f:(Int, Int) -> Int) : Int {
    return f(1,2)
}

@JvmOverloads
fun methodWithDefaultParameters(message: String, prefix: String = ":", suffix: String =":"): String {
    return "$prefix$message$suffix"
}

fun String.extensionFunction(extensionSuffix: String) : String {
    fun prefix(message: String, suffix: String) : String {
        return message + suffix
    }

    return prefix(this, extensionSuffix)
}