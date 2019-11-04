fun main() {
    inlineRun()
    inlineLet()
    inlineTakeIfAndUnless()
    inlineRepeat()
}

fun inlineRepeat() {
    repeat(5){
        print("Hello ")
    }
}

fun inlineTakeIfAndUnless() {
    println("Capital first letter: ${"Any string".takeIf { it.first().isUpperCase() }}")
    println("Lowercase first letter: ${"any string".takeIf { it.first().isUpperCase() }}")
    println("Capital first letter: ${"Any string".takeUnless { it.first().isLowerCase() }}")
}

fun inlineLet() {

    fun printCustomer(customer: NullableCustomer) = println("customer= $customer")
    val nullableCustomer : NullableCustomer? = nullableCustomer()
    nullableCustomer?.let { printCustomer(it) }
}

fun inlineRun() {

    val result = run {
        println("Inside run...")
        "run"
    }

    println("result is : $result")
}
