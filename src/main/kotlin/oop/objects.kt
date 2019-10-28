package oop

import CustomerAddressSAM

object SingletonCustomer {
    val name = "Singleton Customer"
}

class CompanionOuter{
    companion object {
        val name = "Inner Companion"
        @JvmStatic val address = "Inner Companion Jvm Static"
    }
}

fun main(){
    singleton()
    objectExpressions()
    companions()
}

fun companions() {

    println("Access companion object : ${CompanionOuter.name} ${CompanionOuter.address}")
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

private fun singleton() {
    println("Singleton Customer Name : ${SingletonCustomer.name}")
}