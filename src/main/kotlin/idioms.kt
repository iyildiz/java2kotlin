fun main() {
    stringInterpolation(2, "abcdef")
    nullability()
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