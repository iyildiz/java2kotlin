fun main() {
    val numbers = (1..100).toList()

    val squares = numbers.filter { it % 8 == 0 }
            .also { println("8s: $it") }
            .map { it * it }
    println("8s squares: $squares")
}