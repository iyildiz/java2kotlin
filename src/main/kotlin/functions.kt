fun main() {
    methodWithDefaultParameters("abc")
    methodWithDefaultParameters("abc", "z")
    methodWithDefaultParameters("abc", "z", "y")
    println("String ".extensionFunction())
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