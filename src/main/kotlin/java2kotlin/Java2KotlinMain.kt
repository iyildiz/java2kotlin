package java2kotlin

fun main(args: Array<String>) {

    val customerJava = CustomerJava()
    customerJava.name = "Java Customer Name"
    println("name:" + customerJava.name)

    val customerKotlin = Customer(12, "Kotlin Customer","email@email123")
    println("name:" + customerKotlin.name)
}
