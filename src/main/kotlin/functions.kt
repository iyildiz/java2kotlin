fun main() {
    methodWithDefaultParameters("abc")
    methodWithDefaultParameters("abc", "z")
    methodWithDefaultParameters("abc", "z", "y")
    println("String ".extensionFunction())
    println(inlineFunction { x, y -> x + y })
}

fun inlineFunction(f:(Int, Int) -> Int) : Int {
    return f(1,2)
}

fun methodWithDefaultParameters(message: String, prefix: String = "", suffix: String ="") {
    println(prefix + ":" + message + ":" + suffix )
}

fun String.extensionFunction() : String {
    fun prefix(message: String, suffix: String) : String {
        return message + suffix
    }

    return prefix(this,": extended")
}