fun main(args: Array<String>) {
    var testVar = "a"
    higherOrder({ x, y -> x + y })
}

fun funcUnit() : String = "retunnValue"

fun funcWithMethods(a:String, b:String) : String = a + b

class Pojo(val id: Int, var name: String, var email:String)

fun funcPairAndDecomposition(){
    val pair = Pair("14124", "124124")
    println(pair.first)
    println(pair.second)
    val(a, b) = pair
    println(a)
    println(b)
}


typealias CustomerName = String

data class CustomerPojo(val name: CustomerName, val email:String)


data class CustomerKotlin(val name: String)

fun higherOrder(f:(Int, Int) -> Int) : Int {
    return f(1,2)
}