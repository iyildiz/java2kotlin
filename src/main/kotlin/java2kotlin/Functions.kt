package java2kotlin

fun main(args: Array<String>) {
    methodWithDefaultParameters("123")
    methodWithDefaultParameters("123", "a")
    methodWithDefaultParameters("123", "a", "b")
    println("String ".extensionFunction())
    stringInterpolation(2,"abcdef")
    collections()
}

private fun collections() {

    val list = listOf(1, -1, 3).filter { it > 0 }
    list.forEach {println(it)}

    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    for ((key, value) in map) {
        println("$key -> $value")
    }
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

fun stringInterpolation(a: Int, b: String): Unit {
    println("sum of $a and ${b.length} is ${a + b.length}")
}