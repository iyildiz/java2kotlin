package java2kotlin

class Customer (val id: Int, var name: String, var email:String)

fun main(args: Array<String>) {

    val customerJava = CustomerJava()
    customerJava.name = "Java Customer Name"
    println("name:" + customerJava.name)

    val customerKotlin = Customer(12, "Kotlin Customer","email@email123")
    println("name:" + customerKotlin.name)
}