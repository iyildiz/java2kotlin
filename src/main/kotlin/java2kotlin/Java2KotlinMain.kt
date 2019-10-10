package java2kotlin

fun main(args: Array<String>) {

    val customerJava = CustomerJava()
    customerJava.name = "Java Customer Name"
    println("name:" + customerJava.name)

    val customerKotlin = Customer(12, "Kotlin Customer","email@email123")
    println("name:" + customerKotlin.name)

    val firstDataClass = CustomerDataClass(12, "Kotlin Data Class")
    val secondDataClass = CustomerDataClass(12, "Kotlin Data Class")
    val secondNonDataClass = Customer(12, "Kotlin Customer","email@email123")

    if(firstDataClass == secondDataClass) println("Equals works for data classes")
    if(customerKotlin != secondNonDataClass) println("Equals does not work for non data classes")
}
