fun main() {
    inlineRun()
    inlineLet()
    inlineTakeIfAndUnless()
    inlineRepeat()
    libraryFunctions()
}

fun libraryFunctions() {
    val ages = listOf(12, 2, 23, 65, 16, 37)
    val agesUnder20UsingSize = ages.filter { it < 20 }.size
    val agesUnder20UsingCount = ages.count { it < 20 }
    println("count : ${agesUnder20UsingSize == agesUnder20UsingCount}")

    val agesSortedReverse = ages.sortedBy { it }.reversed()
    val agesSortedReverseUsingDescending = ages.sortedByDescending { it }
    println("sort descending : ${agesSortedReverse == agesSortedReverseUsingDescending}")

    val agesMappedFilteredNotNulls = ages.map { if(it > 15) "16+:$it" else null}.filterNotNull()
    val agesMappedNotNulls = ages.mapNotNull { if(it > 15) "16+:$it" else null}
    println("map not null : ${agesMappedFilteredNotNulls == agesMappedNotNulls}")
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
