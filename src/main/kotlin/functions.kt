@file:JvmName("FunctionUtil")

fun main() {
    methodWithDefaultParameters("abc")
    methodWithDefaultParameters("abc", "(")
    methodWithDefaultParameters("abc", "(", ")")
    methodWithDefaultParameters("abc", suffix=")")//named argument used
    println("String ".extensionFunction())
    println(inlineFunction { x, y -> x + y })
}

fun topLevelFunction() = 50

fun inlineFunction(f:(Int, Int) -> Int) : Int {
    return f(1,2)
}

@JvmOverloads
fun methodWithDefaultParameters(message: String, prefix: String = "", suffix: String ="") {
    println(prefix + ":" + message + ":" + suffix )
}

fun String.extensionFunction() : String {
    fun prefix(message: String, suffix: String) : String {
        return message + suffix
    }

    return prefix(this,": extended")
}