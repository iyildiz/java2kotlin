package java2kotlin

fun main(args: Array<String>) {
    var testVar = "a"
    println(SingletonKotlion.property)

    val returnTest = if(testVar.equals("a")){
        SingletonKotlion
    }else{
        SingletonKotlion
    }

    returnTest.property

    higherOrder({x,y -> x + y} )
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

object SingletonKotlion {
    val property = "Something"
}

typealias CustomerName = String

data class CustomerPojo(val name:CustomerName, val email:String)

fun validateJavaCustomer(customer: CustomerJava?){
    if(customer?.name?.startsWith("A") == true){
        throw Exception();
    }
}

fun validateKotlinCustomer(customer: CustomerKotlin){
    if(customer.name.startsWith("A")){
        throw Exception();
    }
}

data class CustomerKotlin(val name: String)

fun higherOrder(f:(Int, Int) -> Int) : Int {
    return f(1,2)
}