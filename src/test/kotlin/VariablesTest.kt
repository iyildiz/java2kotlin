import org.junit.jupiter.api.Test

class VariablesTest {

    @Test
    fun variableTypes() {
        val readOnlyVal = "read only"
        println("$readOnlyVal?")
        //readOnlyVal = "new val" ==> Compiler error

        var answer = 0
        println(answer)
        answer = 42
        println(answer)
    }


    @Test
    fun lazyVal() {
        val lazyVal: String by lazy {
            println("setting lazyVal now :)")
            "loaded lazily when accessed first time"
        }
        println("lazyVal is not set yet :(")
        println("lazyVal: $lazyVal")
    }
}