import kotlin.random.Random

fun main() {
    collectionToSequence()
    sequenceFromScratch()
    sequenceWithYield()
}

fun sequenceWithYield() {

    fun sequenceUsingYield(): Sequence<Int>  {
        return sequence {
            println("yield one")
            yield(1)
            println("yield range")
            yieldAll(3..5)
            println("yield list")
            yieldAll(listOf(7, 9))

        }
    }
    println("sequence with yield : ${sequenceUsingYield()
            .map { it * it }
            .filter { it > 10 }
            .first()}")
}

fun sequenceFromScratch() {
    val randomPositiveInt = generateSequence {
        Random.nextInt(10).takeIf { it > 0 }
    }
    println("sequenceFromScratch : ${randomPositiveInt.toList()}")

    val infiniteSeq = generateSequence(0) {
        it + 1
    }
    println("first 10 of infinite seq : ${infiniteSeq.take(10).toList()}")
}

private fun collectionToSequence() {
    val firstEvenSquare = listOf(1, 2, 3, 5, 6, 7)
            .asSequence()
            .map { it * it }
            .filter { square -> square % 2 == 0 }
            .first()
    println("First even square: $firstEvenSquare")
}


