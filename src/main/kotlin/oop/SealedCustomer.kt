package oop

sealed class SealedCustomer
class PersonalCustomer (val name: String) : SealedCustomer()
class CorporateCustomer (val corporateName: String) : SealedCustomer()

fun main() {

    val customerList = listOf(
            PersonalCustomer("Personal Name"),
            CorporateCustomer("Corporate Name")
    )
    customerList.forEach {
        when(it){
            is PersonalCustomer -> println(it.name) //No casting required
            is CorporateCustomer -> println(it.corporateName)
//            is CorporateCustomer  -> println(it.name) ==> this fails
        }
    }
}