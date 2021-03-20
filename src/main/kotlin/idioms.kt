@file:JvmName("IdiomsUtil")

import java.io.IOException

fun main() {
    stringInterpolation(2, "abcdef")
    nullability()
    safeCasts()
    exceptions("99")
    exceptions("xyz")
}

fun safeCasts() {
    val s = "hello"
    println(s as? Int)    // null
    println(s as? String)    // "hello"
    println(s as String?)    // "hello"

    val result = try {
        println(s as Int?)    // throws class cast exception
    }catch (ex: Exception){
        println(ex.message)
        "return"
    }
    println("result of try: $result")
}

fun exceptions(numberAsString: String) {

    val number = try {
        Integer.parseInt(numberAsString)
    } catch (e: NumberFormatException) {
        "return"
    }
    val percentage =
        try {
            if (number in 0..100)
                number
            else
                throw IllegalArgumentException("A percentage value must be between 0 and 100: $number")
        }catch (ex: java.lang.Exception){
            "exception"
        }
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

data class IdiomsCustomer (val id: Int, var name: String){

    fun someMethodCall(): Boolean? {
        val num = (1..12).shuffled().first()
        return if(num %2 == 0) true else null
    }
}

fun nullableCustomer(): IdiomsCustomer? {
    val num = (1..12).shuffled().first()
    return if(num %2 == 0) IdiomsCustomer(12, "nullable") else null
}

fun validateJavaCustomer(customer: CustomerJava?){
    if(customer?.name?.startsWith("A") == true){
        throw Exception()
    }
}

fun validateCustomer(customer: IdiomsCustomer){
    if(customer.name.startsWith("A")){
        throw Exception()
    }
}