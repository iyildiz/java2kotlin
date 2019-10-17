fun main() {
    stringInterpolation(2, "abcdef")
    expressions()
}

fun stringInterpolation(a: Int, b: String) {
    println("sum of $a and ${b.length} is ${a + b.length}")
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