package java2kotlin

data class CustomerDataClass(val id: Int, val name: String)


fun main(args: Array<String>) {

    val firstDataClass = CustomerDataClass(12, "Kotlin Data Class")
    val secondDataClass = CustomerDataClass(12, "Kotlin Data Class")

    val firstNonDataClass = Customer(12, "Kotlin Customer","email@email123")
    val secondNonDataClass = Customer(12, "Kotlin Customer","email@email123")

    if(firstDataClass == secondDataClass) println("Equals works for data classes")
    if(firstNonDataClass != secondNonDataClass) println("Equals does not work for non data classes")
}