fun main() {

    stringInterpolation(2, "abcdef")
    collections()
    expressions()
    lazyLoading()
}

fun lazyLoading() {
    val lazyVal: String by lazy {
        println("setting lazyVal now :)")
        "loaded lazily when accessed first time"
    }
    println("lazyVal is not set yet :(")
    println("lazyVal: $lazyVal")
}

fun stringInterpolation(a: Int, b: String) {
    println("sum of $a and ${b.length} is ${a + b.length}")
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

fun expressions() {
    val customer = Customer(12, "Kotlin Customer", "email@email123")

    val whenResult = when(customer.id){
        1 -> { println("one"); 1}
        2 -> 2
        3,4 -> 3
        else -> 0
    }
    val ifResult = if(customer.id == 12) 1 else 0

    println("whenResult=$whenResult ifResult=$ifResult")
}