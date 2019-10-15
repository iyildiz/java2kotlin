# Java to Kotlin

### Pojo Declarations
- Java [CustomerJava.java](src/main/java/CustomerJava.java) ==> setters and getters :(
- Kotlin [Customer.kt](src/main/kotlin/Customer.kt) ==> no setters & getters :)
- Kotlin You can have val (immutable) & var (mutable) 
- Kotlin `with` can be used to access class members see [Customer.kt](src/main/kotlin/Customer.kt) 
- Kotlin `Singletons` can be declared using `object`. See [Customer.kt/SingletonCustomer](src/main/kotlin/Customer.kt)

### Data Classes
- [CustomerDataClass.kt](src/main/kotlin/CustomerDataClass.kt) comes with equals/hashcode/toString
- You can have only val, encourages immutability

### Sealed Classes
- [SealedCustomer.kt](src/main/kotlin/SealedCustomer.kt) All the subclasses shall be defined
- Makes it quite handy to use with pattern matching with when

### Functions
- **Default Parameter Values:** Kotlin has default values for parameters e.g [functions.kt/methodWithDefaultParameters](src/main/kotlin/functions.kt)
- **Extension functions:** Kotlin allows extensions functions on types e.g [functions.kt/extensionFunction](src/main/kotlin/functions.kt)
- **Local function:** YOu can inline functions inside functions e.g [functions.kt/extensionFunction/prefix](src/main/kotlin/functions.kt)

### Idioms
- String interpolation: "sum of $a and ${b.length} is ${a + b.length}" see [idioms.kt/stringInterpolation](src/main/kotlin/idioms.kt)
- Collections: builder functions can be used for list/map and other collections. See [idioms.kt/collections](src/main/kotlin/idioms.kt)
- Expressions are used a lot even if, when can be expressions. See [idioms.kt/expressions](src/main/kotlin/idioms.kt)
- Nullability examples added under [NullableCustomer](src/main/kotlin/NullableCustomer.kt)