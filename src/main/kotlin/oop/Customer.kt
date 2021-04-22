package oop

import CustomerJava

class Customer (val id: Int, var name: String, var email:String)

fun main() {

    val customerJava = CustomerJava()
    with(customerJava) {
        name = "Java Customer Name"
    }
    println("name:${customerJava.name}")
    customerJava.name = "Updated Java Customer Name"
    println("name:${customerJava.name}")

    val customerKotlin = Customer(12, "Kotlin Customer", "email@email123")
    println("name:${customerKotlin.name}")
}
