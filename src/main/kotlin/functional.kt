fun main() {
    val numbers = (1..100).shuffled().toList()

    val squares = numbers.filter { it % 8 == 0 }
            .sortedBy { it }
            .also { println("8s: $it") }
            .map { it * it }
    println("8s squares: $squares")
}