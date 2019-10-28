interface CustomerNameDelegate {
    fun getName() : String
}

interface CustomerAddressDelegate {
    fun getAddress() : String
}

class CustomerDelegated(val customerNameDelegate: CustomerNameDelegate, val customerAddressDelegate: CustomerAddressDelegate)
    : CustomerNameDelegate by customerNameDelegate, CustomerAddressDelegate by customerAddressDelegate

fun main() {
    val customerDelegated = CustomerDelegated(
            object : CustomerNameDelegate {
                override fun getName(): String {
                    return "name"
                }
            },
            object : CustomerAddressDelegate {
                override fun getAddress(): String {
                    return "address"
                }
            })
    println(".getName: ${customerDelegated.getName()} .getAddress: ${customerDelegated.getAddress()}")
}