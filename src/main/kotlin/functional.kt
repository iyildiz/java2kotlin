fun main() {
    lamdas()
    collections()
}

private fun lamdas() {
    val numbers = (1..100).shuffled().toList()

    val squares = numbers.filter { it % 8 == 0 }
            .sortedBy { it }
            .also { println("8s: $it") }
            .map { it * it }
    println("8s squares: $squares")
}

private fun collections() {

    val list = listOf(1, -1, 3).filter { it > 0 }
    list.forEach {println(it)}

    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    for ((key, value) in map) {
        println("$key -> $value")
    }

    val evenNumbers = (1..10).filter { it.rem( 2) == 0}
    evenNumbers.forEach {println(it)}
}
