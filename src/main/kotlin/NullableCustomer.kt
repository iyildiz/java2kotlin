class NullableCustomer (val id: Int, var name: String)

fun main() {

    val customerJava = CustomerJava()
    with(customerJava) {
        name = "Java Customer Name"
    }
    validateJavaCustomer(customerJava)
    nullableCustomer()?.let { validateCustomer(it) }

}

fun nullableCustomer(): NullableCustomer? {
    val num = (1..12).shuffled().first()
    return if(num.rem(2) == 0) NullableCustomer(12, "nullable") else null
}

fun validateJavaCustomer(customer: CustomerJava?){
    if(customer?.name?.startsWith("A") == true){
        throw Exception();
    }
}

fun validateCustomer(customer: NullableCustomer){
    if(customer.name.startsWith("A")){
        throw Exception();
    }
}

