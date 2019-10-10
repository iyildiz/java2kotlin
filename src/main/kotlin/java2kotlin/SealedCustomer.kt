package java2kotlin

sealed class SealedCustomer
class PersonalCustomer (val name: String)
class CorporateCustomer (val corporateName: String)

fun main(args: Array<String>) {

    val customerList = listOf(
            PersonalCustomer("Personal Name"),
            CorporateCustomer("Corporate Name")
    )
    customerList.forEach {
        when(it){
            is PersonalCustomer  -> println(it.name) //No casting required
            is CorporateCustomer  -> println(it.corporateName)
//            is CorporateCustomer  -> println(it.name) ==> this fails

        }
    }
}