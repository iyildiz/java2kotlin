@file:JvmName("GenericsUtil")
package oop

fun <T> List<T>.filterGenerics(predicate: (T) -> Boolean): List<T> = this.filter(predicate)
fun <T> List<T>.firstOrNullGenerics(): T? = this.firstOrNull()
fun <T: Any> List<T>.firstOrNullGenericsNonNullable(): T? = this.firstOrNull()

fun filterIntList(ints: List<Int>) : List<Int> {
    return ints.filterGenerics { it > 0 }
}

fun filterNullableIntList(ints: List<Int?>) : List<Int?> {
    return ints.filterGenerics { it != null && it > 0 }
}

fun filterStringList(strings: List<String>) : List<String> {
    return strings.filterGenerics { it.isNotEmpty() }
}

fun filterNullableStringList(strings: List<String?>) : List<String?> {
    return strings.filterGenerics { !it.isNullOrEmpty() }
}

fun List<Int>.averageGenerics(): Double = this.average()
@JvmName("averageGenericsDouble")
fun List<Double>.averageGenerics(): Double = this.average()

fun main(){
    println(filterIntList(listOf(1,0)))
    println(filterNullableIntList(listOf(1,0,null)))
    println(filterStringList(listOf("abc", "")))
    println(filterNullableStringList(listOf("abc", "", null)))
    println(listOf(1,0).firstOrNullGenerics()?.toInt()?: "firstItemNull")
    println(listOf(null,0).firstOrNullGenerics()?.toInt() ?: "firstItemNull")
    //println(listOf(null,0).firstOrNullGenericsNonNullable()?.toInt() ?: "firstItemNull")//compiler error
    println(listOf(2,0).firstOrNullGenericsNonNullable()?.toInt() ?: "firstItemNull")
    println(emptyList<Int>().firstOrNullGenericsNonNullable()?.toInt() ?: "firstItemNull")
    println(listOf(1,2,3,4,5).averageGenerics())
    println(listOf(1.1,2.2,3.3,4.4,5.5).averageGenerics())


}