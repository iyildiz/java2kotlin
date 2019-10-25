import kotlin.random.Random

class Person (var name: String, val age:Int){
    val isChild : Boolean
        get() {
            return age < 16
        }
    var id = Random.nextInt()
    private set

    fun appendCharToName(ch : Char){
        val sb = StringBuilder(name).append("-")
        sb.lastChar = ch
        name = sb.toString()
    }
    var StringBuilder.lastChar: Char
        get() = get(length - 1)
        set(value) {
            this.setCharAt(length - 1, value)
        }
}

enum class MobileOS {
    ANDROID, IOS
}

interface MobilePhone {
    val operatingSystem: MobileOS
}

class Pixel : MobilePhone {
    override val operatingSystem = MobileOS.ANDROID
}

class iPhone : MobilePhone {
    override val operatingSystem = MobileOS.IOS
}

class LateInitClass {
    lateinit var lateinitVar: String
    fun initialize() {
        println(this::lateinitVar.isInitialized) // false
        lateinitVar = "value"
        println(this::lateinitVar.isInitialized) // true
    }
}

fun main() {
    fields()
    openProperties()
    propertyExtensions()
    lateinitProperties()
}


fun lateinitProperties() {
    val lateInitClass = LateInitClass()
    lateInitClass.initialize()
}

fun propertyExtensions() {

    val person = Person("Bob", 30)
    person.appendCharToName('!')
    println("name: ${person.name}")
}

private fun openProperties() {
    val mobilePhones = listOf(Pixel(), iPhone())
    mobilePhones.forEach { print(it.operatingSystem) }
}

private fun fields() {
    val person = Person("Bob", 30)
    println("id: ${person.id} isChild: ${person.isChild}")
}
