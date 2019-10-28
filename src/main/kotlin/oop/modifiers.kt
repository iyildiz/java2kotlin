package oop

typealias CustomerName = String

data class CustomerDataClass(val id: Int, val name: CustomerName, val age: Int=0)

enum class Colours(val r : Int, val g : Int, val b : Int) {
    RED(255, 0, 0), BLUE(0, 0, 255), GREEN(0, 255, 0);
    fun rgb() = r + g + b
}

class Outer {
    val outerId = 0
    class InnerNestedStatic
    inner class InnerHoldingRefToOuter {
        fun printId() = println("Accessing outer from inner : ${this@Outer.outerId}")
    }
}

fun main() {

    val firstDataClass = CustomerDataClass(12, "Kotlin Data Class")
    val secondDataClass = CustomerDataClass(12, "Kotlin Data Class")

    val firstNonDataClass = Customer(12, "Kotlin Customer", "email@email123")
    val secondNonDataClass = Customer(12, "Kotlin Customer", "email@email123")

    if(firstDataClass == secondDataClass) println("Equals works for data classes")
    if(firstNonDataClass != secondNonDataClass) println("Equals does not work for non data classes")

    val copiedWithChanges = firstDataClass.copy(name="Copied - Kotlin Data Class")
    println("after copy: $copiedWithChanges")
    println("red: ${Colours.RED} green: ${Colours.GREEN} blue: ${Colours.BLUE} ")

    val copiedNoChanges = firstDataClass.copy()
    println("equals: ${firstDataClass == copiedNoChanges}")
    println("reference check: ${firstDataClass === copiedNoChanges}")

    val innerNestedStaticClass = Outer.InnerNestedStatic()
    println(innerNestedStaticClass)
    val innerHoldingRefToOuter = Outer().InnerHoldingRefToOuter()
    innerHoldingRefToOuter.printId()
}