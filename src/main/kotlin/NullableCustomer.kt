class NullableCustomer (val id: Int, var name: String){

    fun someMethodCall(): Boolean? {
        val num = (1..12).shuffled().first()
        return if(num %2 == 0) true else null
    }
}

fun main() {

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

