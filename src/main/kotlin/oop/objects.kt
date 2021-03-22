package oop

import CustomerAddressSAM

object SingletonCustomer {
    val name = "Singleton Customer"
}

class CompanionOuter {
    val outerField = "Outer Field"
    companion object {
        val name = "Inner Companion"
        @JvmField val postCode = "Xyz"
        @JvmStatic val address = "Inner Companion Jvm Static"
        fun factoryMethod() : CompanionOuter {
            return CompanionOuter()
        }

        fun accessOuterClassFieldsAndMethods() : String {
            val anInstanceOfOuterClass = factoryMethod()
            return anInstanceOfOuterClass.getCustomOuterField() + anInstanceOfOuterClass.outerField
        }
    }

    fun getCustomOuterField() : String {
        return outerField
    }
}

fun main(){
    println("Singleton Customer Name : ${singleton().name}")
    objectExpressions()
    companions()
}

fun companions() {
    println("Access companion object fields : ${CompanionOuter.name} ${CompanionOuter.address}")
    println("Access companion object methods : ${CompanionOuter.factoryMethod().outerField}")
    println("Access companion object methods : ${CompanionOuter.accessOuterClassFieldsAndMethods()}")
}

fun objectExpressions() {
    val customerDelegated = generateCustomerUsingObjectExpressionsAndJavaSAMConversion()
    println(".getName: ${customerDelegated.getName()} .getAddress: ${customerDelegated.getAddress(customerDelegated.getName())}")
}

fun generateCustomerUsingObjectExpressionsAndJavaSAMConversion(): CustomerDelegated {
    return CustomerDelegated(
            object : CustomerNameDelegate {
                override fun getName(): String {
                    return "name"
                }
            },
            CustomerAddressSAM { name -> "$name : address" }
    )
}

fun singleton() : SingletonCustomer {
    return SingletonCustomer
}