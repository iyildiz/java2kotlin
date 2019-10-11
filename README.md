# Java to Kotlin

### Pojo Declarations
- Java `CustomerJava.java` ==> setters and getters :(
- Kotlin `Customer.kt` ==> no setters & getters :)
- Kotlin : You can have val (immutable) & var (mutable) 

### Data Classes
- CustomerDataClass.kt ==> comes with equals/hashcode/toString
- You can have only val, encourages immutability

### Sealed Classes
- SealedCustomer.kt ==> All the subclasses shall be defined
- Makes it quite handy to use with pattern matching with when

### Functions
- **Default Parameter Values:** Kotlin has default values for parameters e.g Functions.kt/methodWithDefaultParameters
- **Extension functions:** Kotlin allows extensions functions on types e.g Functions.kt/extensionFunction
- **Local function:** YOu can inline functions inside functions e.g Functions.kt/extensionFunction/prefix

###
- String interpolation: "sum of $a and ${b.length} is ${a + b.length}" see  Functions.kt/stringInterpolation
- Builder functions : 