import oop.Customer

fun main() {
    whenExp()
    ifExp()
}

fun whenExp() {
    val customer = Customer(12, "Kotlin Customer", "email@email123")

    val whenResult = when(customer.id){
        1 -> { println("one"); 1}
        2 -> 2
        3,4 -> 3
        else -> 0
    }
    println("whenResult=$whenResult")
}

fun ifExp() {
    val customer = Customer(12, "Kotlin Customer", "email@email123")

    val ifResult = if(customer.id == 12) 1 else 0

    println("ifResult=$ifResult")
}