import java.lang.IllegalStateException
import kotlin.random.Random

fun main() {
    kotlinString()
    nullableFunctionCalls()
    arrays()
    javaToKotlinTypesTypeInference()
    javaToKotlinTypesAnnotations()
    nothing()
    javaClass()
}

fun javaToKotlinTypesTypeInference() {
    val javaCustomer = CustomerJava()

    val noAnnotationInferredToNullableString: String? = javaCustomer.returnNull()
    println("No Annotation Type inferred to NullableString : ${noAnnotationInferredToNullableString?.length}")

    val notNullAnnotationInferredToNotNullableString: String = javaCustomer.notNullAnnotation()
    println("Type inferred to not nullable String throws IllegalStateException: ${notNullAnnotationInferredToNotNullableString.length}")
}

fun javaToKotlinTypesAnnotations() {

    val javaCustomer = CustomerJava()

    println("NPE from Java")
    javaCustomer.returnNull().length

    val notNullAnnotation = javaCustomer.notNullAnnotation()
    println("notNullAnnotation in Java : ${notNullAnnotation.length}")

    val nullableAnnotation = javaCustomer.nullableAnnotation()
    println("nullAnnotation in Java requires safe call : ${nullableAnnotation?.length}")
}

fun nothing() {

    fun fail(): Nothing {
        throw IllegalStateException("Failed")
    }

    fun evenWithNothing(number: Int): String {
        return if (number % 2 == 0) "even"
        else fail()
    }

    println("Nothing usage : ${evenWithNothing(Random.nextInt(10) )}")
}

fun nullableFunctionCalls() {

    val sqrt: (Double) -> Double = { x: Double -> Math.sqrt(x) }

    fun findSqrtFunction(number : Double): ((Double) -> Double)? {
        return if(number >= 0) sqrt
        else null
    }

    val invoke = findSqrtFunction(9.0)?.invoke(9.0)
    val nullableInvoke = findSqrtFunction(-5.0)?.invoke(-5.0)

    println("invoke = $invoke nullableInvoke = $nullableInvoke")
}

private fun arrays() {
    val first = initIntArray(1, 2, 3)
    val second = initIntArray(1, 2, 3)
    println("equals calls reference equality for arrays: ${first == second}")
    println("contentEquals can be used for arrays: ${first.contentEquals(second)}")
}

fun initIntArray(vararg elements: Int) : IntArray {
    return intArrayOf(*elements)
}

fun kotlinString() {
    val str = "abcdef.def.thg."
    println("string replace:${str.replace('.','*')}")
    println("Regex replace:${str.replace(".".toRegex(),"*")}")
}

fun javaClass() {

    val hashSetJava = hashSetOf<String>()
    println("Java Class: ${hashSetJava.javaClass}")

    val hashSetKotlin = setOf<String>()
    println("Java Class: ${hashSetKotlin.javaClass}")
}