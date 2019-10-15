fun main(args: Array<String>) {
    higherOrder({ x, y -> x + y })
}

fun funcPairAndDecomposition(){
    val pair = Pair("14124", "124124")
    println(pair.first)
    println(pair.second)
    val(a, b) = pair
    println(a)
    println(b)
}




fun higherOrder(f:(Int, Int) -> Int) : Int {
    return f(1,2)
}