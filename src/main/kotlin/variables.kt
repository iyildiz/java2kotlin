fun main() {

    variableTypes()
    lazyVal()
}

private fun variableTypes() {
    val readOnlyVal = "read only"
    println("$readOnlyVal?")
    //readOnlyVal = "new val" ==> Compiler error

    var answer = 0
    println(answer)
    answer = 42
    println(answer)
}

fun lazyVal() {
    val lazyVal: String by lazy {
        println("setting lazyVal now :)")
        "loaded lazily when accessed first time"
    }
    println("lazyVal is not set yet :(")
    println("lazyVal: $lazyVal")
}

fun lazyLoadUser(userService : UserService, userName: String) {
    val lazyValUserName: String by lazy {
        userService.initUser()
        userName
    }
    userService.reload()
    userService.save(lazyValUserName)
}

interface UserService {
    fun initUser()
    fun reload()
    fun save(userName: String)
}
