package oop

open class Vehicle(reg: String, val model: String){
    open val type = "none"
    val reg: String
    init {
        println("init Vehicle: $type")
        this.reg = reg
    }

    constructor(reg: String) :  this(reg, "") {
        println("overriden constructor")
    }
}

class Car : Vehicle {
    override val type = "personal"
    init {
        println("init Car: $type")
    }
    constructor(reg: String, model: String) :  super(reg, model)
}

class Truck(reg: String, model: String) : Vehicle(reg,model) {
    override val type = "commercial"
    init {
        println("init Truck: $type")
    }
}

fun main() {
    B("a")
    Car("XYZ", "Nissan")
    Truck("ABC", "Volvo")
}

open class A(open val value: String) {
    init {
        this.value.length
    }
}

class B(override val value: String) : A(value)