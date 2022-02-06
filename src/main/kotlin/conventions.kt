
data class Rational(val numerator : Int, val denominator : Int) : Comparable<Rational>{

    operator fun times(number: Rational): Rational {
        return Rational(this.numerator * number.numerator,this.denominator * number.denominator)
    }

    operator fun times(number: Int): Rational {
        return Rational(this.numerator * number,this.denominator)
    }

    override fun compareTo(other: Rational): Int {
        return (this.numerator * other.denominator).compareTo(other.numerator * this.denominator)
    }

    operator fun get(index: RationalIndex): Int {
        return when(index){
            RationalIndex.NUMERATOR -> numerator
            RationalIndex.DENOMINATOR -> denominator
        }
    }

    operator fun iterator() : Iterator<Int> {
        return intArrayOf(numerator, denominator).iterator()
    }
}

infix fun Rational.customTo(other: Rational) = Pair(this,other)

enum class RationalIndex{
    NUMERATOR,DENOMINATOR
}

fun main() {
    operatorOverloading()
    otherConventions()
}

fun otherConventions() {
    println("<= works for custom types automatically: ${Rational(2,3) > Rational(1,3) }")
    println("== handles null checks: ${null == Rational(1,3) }")
    println("[] indexed access for numerator ${Rational(1,3)[RationalIndex.NUMERATOR] }")
    println("in usage ${Rational(1,3) in listOf(Rational(1,3)) }")
    println(".. usage ${Rational(2,3) in Rational(1,3)..Rational(3,3) }")

    for(rationalNumberPart in Rational(6,7))
        println("rationalNumberPart inside for with custom iterator: $rationalNumberPart")

    val pairWithTo = Rational(1,3) to Rational(3,4)
    val pairWithCustomTo = Rational(1,3) customTo Rational(3,4)
    println("infix operator usage: ${pairWithTo == pairWithCustomTo}")
}

fun operatorOverloading() {
    println("2/3 * 2/5 is: ${Rational(2,3) * Rational(2, 4)}")
    println("2/3 * 5 is: ${Rational(2,3) * 5}")

    var immutableList = listOf(1, 2, 3)
    val immutableListRef = immutableList
    immutableList += 4 //new list is created
    println("immutableList= $immutableList immutableListRef=$immutableListRef")

    val mutableList = mutableListOf(1, 2, 3)
    val mutableListRef = mutableList
    mutableList += 4
    println("mutableList= $mutableList mutableListRef=$mutableListRef")

    val (num, den) = Rational(9,10)
    println("Apply destructing: numerator= $num denominator=$den")

}
