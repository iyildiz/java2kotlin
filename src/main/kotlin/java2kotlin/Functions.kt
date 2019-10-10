package java2kotlin

fun main(args: Array<String>) {
    methodWithDefaultParameters("123")
    methodWithDefaultParameters("123", "a")
    methodWithDefaultParameters("123", "a", "b")
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