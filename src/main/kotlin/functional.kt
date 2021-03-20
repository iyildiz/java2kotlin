import oop.CustomerDataClass

fun main() {
    lambdas()
    functionTypes()
    memberReferences()
    collections()
    ranges()
}

fun memberReferences() {
    val listOfCustomers = buildListOfCustomers()
    val maxAgeCustomer = listOfCustomers.maxBy(CustomerDataClass::age)
    println("Oldest customer: $maxAgeCustomer")

    val isEvenLambda: (Int) -> Boolean = { i: Int -> i % 2 == 0 } //Store lambda in a variable

    fun isEvenFunction(i: Int): Boolean = i % 2 == 0
    //val predicate = isEven //this gives compile error
    val predicate = ::isEvenFunction //That is using function reference
    //val predicate = { i: Int -> isEvenFunction(i) } //A function reference is converted to a lambda internally

    class Person(val name: String, val age: Int) {
        fun isOlder(ageLimit: Int) = age > ageLimit
    }
    //non-bound method reference
    val agePredicate = Person::isOlder
    val alice = Person("Alice", 29)
    agePredicate(alice, 21) //uses one parameter

    //bound method reference
    val agePredicateForAliceOnly = alice::isOlder
    agePredicateForAliceOnly(21) //uses 2 parameters

    //bound to a top level method
    fun isEvenAgedCustomer(customer: CustomerDataClass): Boolean = customer.age % 2 == 0
    println("Even aged customers:" + listOfCustomers.filter(::isEvenAgedCustomer))
}

fun functionTypes() {
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    println("sum using function type: ${sum(3, 4)}")

    val isEven: (Int) -> Boolean = { i: Int -> i % 2 == 0 }
    println("isEven using function type: ${isEven(4)}")

}

private fun lambdas() {
    val randomNumbers = (1..100).shuffled().toList()
    val squares = orderedSquaresForFactorsOf(randomNumbers, 8)
    println("8s squares: $squares")
}

fun orderedSquaresForFactorsOf(numbers: List<Int>, factorsOf: Int): List<Int> {
    return numbers.filter { it % factorsOf == 0 }
        .sortedBy { it }
        .also { println("{$factorsOf`s: $it}") }
        .map { it * it }
}

private fun collections() {

    val list = listOf(1, -1, 3).filter { it > 0 }
    list.forEach { println(it) }

    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    for ((key, value) in map) {
        println("$key -> $value")
    }
    val valForC: Int? = map.get("c") //returns value or null
    val valForA: Int? = map["a"] //returns value or null
    val valForB: Int = map.getValue("b") //throws NoSuchElementException if key not found
    val valForNonExistingKey: Int = map.getOrElse("non_existing_key") { 0 }
    println("a: $valForA b: $valForB c: $valForC valForNonExistingKey:$valForNonExistingKey")


    val evenNumbers = (1..10).filter { it.rem(2) == 0 }
    evenNumbers.forEach { println(it) }

    val allGreaterThanZero = (1..10).all { it > 0 }
    val anySmallerThanZero = (1..10).any { it < 0 }
    println("all: $allGreaterThanZero any: $anySmallerThanZero")

    val zippedList = (1..10).zip(-1 downTo -10)
    println("zip: $zippedList")
    val listOfCustomers = buildListOfCustomers()
    val maxItem = listOfCustomers.maxBy { it.id }
    val firstItem: CustomerDataClass = listOfCustomers.first()
    val lastItem: CustomerDataClass = listOfCustomers.last()
    val firstItemOrNull: CustomerDataClass? = listOfCustomers.firstOrNull()
    val lastItemOrNull: CustomerDataClass? = listOfCustomers.lastOrNull()
    println("max: $maxItem firstItem: $firstItem lastItem: $lastItem")
    println("firstItemOrNull: $firstItemOrNull lastItemOrNull: $lastItemOrNull")

    val (even, odd) = (1..10).partition { it % 2 == 0 }
    println("even: $even")
    println("odd: $odd")

    println(listOfCustomers.groupBy { it.age }.maxBy { (_, list) -> list.size })
    println(listOfCustomers.associate { it.name to it.age })
    println(listOfCustomers.associateBy { it.name })

    val (custMaxAge, custMinAge) = listOfCustomers
        .flatMap { first ->
            listOfCustomers.map { second -> first to second }
        }
        .maxBy { it.first.age - it.second.age }!!
    println("custMaxAge: $custMaxAge custMinAge: $custMinAge")


    println("10 factorialWithFold: ${factorialWithFold(10)}")
    println("10 factorialWithFoldRight: ${factorialWithFoldRight(10)}")

    val sumOfNumbers = addNumbersUpToWithReduce(10)
    println("addNumbersUpToWithReduce up to 10: $sumOfNumbers")

}

fun factorialWithFoldRight(number: Int) =
    (1 until number).toList().foldRight(number, { num, acc -> num * acc })

fun factorialWithFold(number: Int) =
    (1..number).toList().fold(1, { acc, num -> acc * num })

fun addNumbersUpToWithReduce(number: Int) =
    (0..number).toList().reduce { acc, num -> acc + num }

fun factorialWithReduceRight(number: Int) =
    (1..number).toList().reduceRight { num, acc -> num * acc }

fun buildListOfCustomers(): List<CustomerDataClass> {
    return listOf(
        CustomerDataClass(12, "Kotlin Data Class", 25),
        CustomerDataClass(13, "Kotlin Data Class", 25),
        CustomerDataClass(14, "Kotlin Data Class", 50),
        CustomerDataClass(15, "Kotlin Data Class", 35),
        CustomerDataClass(16, "Kotlin Data Class", 25)
    )
}

fun ranges() {
    fun isLetterOrUnderScores(ch: Char): Boolean {
        return when (ch) {
            '_' -> true
            in 'a'..'z' -> true
            in 'A'..'Z' -> true
            else -> false
        }
    }
    println(isLetterOrUnderScores('_'))
    println(isLetterOrUnderScores('.'))
}


