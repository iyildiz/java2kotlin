import kotlin.random.Random

fun main() {
    lambdaWithReceiver()
    withVsRun()
    applyVsAlso()
}

fun applyVsAlso() {
    val number = Random.nextInt(5)
    number.apply {
        println("even with apply: ${rem(2) == 0}")
    }.also {
        num -> println("even with also: ${num % 2 == 0}")
    }
}

fun withVsRun() {
    val number = Random.nextInt(5)
    val evenOrNull = with(number) {
        if(rem(2) == 0) "even" else null
    }
    evenOrNull?.let { println("Usage of with: $evenOrNull")}

    val evenOrOddWithRun = evenOrNull?.run {
        println("Inside run: $this")
        startsWith("even")
    }

    println("Result of run: $evenOrOddWithRun")
}

private fun lambdaWithReceiver() {
    val isEvenUsingRegularLambda: (Int) -> Boolean = { it % 2 == 0 }
    val isEvenUsingLambdaWithReceiver: Int.() -> Boolean = { this % 2 == 1 }

    println("Regular Lambda Usage: ${isEvenUsingRegularLambda(5)}")
    println("Lambda With Receiver Usage : ${5.isEvenUsingLambdaWithReceiver()}")
}
