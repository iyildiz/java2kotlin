package oo

object Constants {
    @JvmStatic val jvmStatic = "JVMSTATIC"
    @JvmField val jvmField = "JVMFIELD"
}

fun main(){
    println(Constants.jvmStatic)
    println(Constants.jvmField)
}