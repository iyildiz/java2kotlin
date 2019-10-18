@file:JvmName("IdiomsUtil")

import java.io.IOException

fun main() {
    stringInterpolation(2, "abcdef")
    nullability()
    exceptions("123")
    exceptions("xyz")
}

fun exceptions(numberAsString: String) {

    val number = try {
        Integer.parseInt(numberAsString)
    } catch (e: NumberFormatException) {
        "return"
    }
    val percentage =
            if (number in 0..100)
                number
            else
                throw IllegalArgumentException("A percentage value must be between 0 and 100: $number")
    println("percentage: $percentage")
}

@Throws(IOException::class)
fun throwsAnExplicitException() {
    throw IOException("Explicit exception from Kotlin method")
}

fun stringInterpolation(a: Int, b: String) {
    println("sum of $a and ${b.length} is ${a + b.length}")
}

fun nullability() {

    val customerJava = CustomerJava()
    with(customerJava) {
        name = "Java Customer Name"
    }
    validateJavaCustomer(customerJava)
    val nullableCustomer = nullableCustomer()
    nullableCustomer?.let { validateCustomer(it) }
    val result = nullableCustomer?.someMethodCall() ?: false
    println("result:$result")
}

class NullableCustomer (val id: Int, var name: String){

    fun someMethodCall(): Boolean? {
        val num = (1..12).shuffled().first()
        return if(num %2 == 0) true else null
    }
}

fun nullableCustomer(): NullableCustomer? {
    val num = (1..12).shuffled().first()
    return if(num %2 == 0) NullableCustomer(12, "nullable") else null
}

fun validateJavaCustomer(customer: CustomerJava?){
    if(customer?.name?.startsWith("A") == true){
        throw Exception()
    }
}

fun validateCustomer(customer: NullableCustomer){
    if(customer.name.startsWith("A")){
        throw Exception()
    }
}