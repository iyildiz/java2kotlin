# Java to Kotlin
### Build
[Kotlin maven plugin 1.3.50 is used](https://kotlinlang.org/docs/reference/using-maven.html)
`mvn clean compile`
- Kotlin allows a `main function` per file. Each of them can be run independently.
### Pojo Declarations
- Java [CustomerJava.java](src/main/java/CustomerJava.java) ==> setters and getters :(
- Kotlin [Customer.kt](src/main/kotlin/Customer.kt) ==> no setters & getters :)
- Kotlin You can have val (immutable) & var (mutable) 
- Kotlin `with` can be used to access class members see [Customer.kt](src/main/kotlin/Customer.kt) 
- Kotlin `Singletons` can be declared using `object`. See [Customer.kt/SingletonCustomer](src/main/kotlin/Customer.kt)

### Data Classes and typealiases
- [Data Classes](src/main/kotlin/dataClassAndTypealiases.kt) comes with equals/hashcode/toString
- You can have only val, encourages immutability
- `typealias`es can be used to create readable code. See [CustomerName typealias](src/main/kotlin/dataClassAndTypealiases.kt)

### Sealed Classes
- [Sealed Classes](src/main/kotlin/SealedCustomer.kt) all the subclasses shall be defined
- Makes it quite handy to use with pattern matching with when

### Functions
- **Default Parameter Values:** Kotlin has default values for parameters e.g [functions.kt/methodWithDefaultParameters](src/main/kotlin/functions.kt)
- **Extension functions:** Kotlin allows extensions functions on types e.g [functions.kt/extensionFunction](src/main/kotlin/functions.kt)
- **Local function:** YOu can inline functions inside functions e.g [functions.kt/extensionFunction/prefix](src/main/kotlin/functions.kt)

### Idioms
- **String interpolation** "sum of $a and ${b.length} is ${a + b.length}" see [idioms.kt/stringInterpolation](src/main/kotlin/idioms.kt)
- **Collections**: builder functions can be used for list/map and other collections. See [idioms.kt/collections](src/main/kotlin/idioms.kt)
- **Expressions** are used a lot even if, when can be expressions. See [idioms.kt/expressions](src/main/kotlin/idioms.kt)
- **Nullability** examples added under [NullableCustomer](src/main/kotlin/NullableCustomer.kt)
- **lazy variables** : their values is assigned when they are accessed first time. See [idioms.kt/lazyLoading](src/main/kotlin/idioms.kt)