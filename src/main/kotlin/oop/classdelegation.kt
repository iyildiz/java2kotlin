package oop

import CustomerAddressSAM

interface CustomerNameDelegate {
    fun getName() : String
}

class CustomerDelegated(val customerNameDelegate: CustomerNameDelegate, val customerAddressDelegate: CustomerAddressSAM)
    : CustomerNameDelegate by customerNameDelegate, CustomerAddressSAM by customerAddressDelegate

fun main() {
    val customerDelegated = generateCustomerUsingObjectExpressionsAndJavaSAMConversion()
    println(".getName: ${customerDelegated.getName()} .getAddress: ${customerDelegated.getAddress(customerDelegated.getName())}")
}

