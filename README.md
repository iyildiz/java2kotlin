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
- **Local function:** You can scope functions inside functions e.g [functions.kt/extensionFunction/prefix](src/main/kotlin/functions.kt)
- **inline functions:** inline functions don't create a new stack in memory e.g [functions.kt/inlineFunction](src/main/kotlin/functions.kt)

### Idioms
- **String interpolation** "sum of $a and ${b.length} is ${a + b.length}" see [idioms.kt/stringInterpolation](src/main/kotlin/idioms.kt)
- **Collections**: builder functions can be used for list/map and other collections. See [idioms.kt/collections](src/main/kotlin/idioms.kt)
- **Expressions** are used a lot even if, when can be expressions. See [idioms.kt/expressions](src/main/kotlin/idioms.kt)
- **Nullability** Once you have `nullable types` using `!` compiler forces you to dereference it under control. See [NullableCustomer](src/main/kotlin/NullableCustomer.kt)
    - **Safe Calls (?.)** : `nullableCustomer?.name` dereferences safely only when customer is not null
    - **Non Safe Calls (!!.)** : `nullableCustomer!!.name` dereference forcefully, make assertion that customer is not null but you may end up with a null pointer exception if your assertion is not true
    - **Elvis Operator (?:)** : `val result = nullableCustomer?.someMethodCall() ?: fallbackIfNullMethodCall()` this can return a custom value if the calling property is null
    - **let** : Executes if not null `nullableCustomer?.let { validateCustomer(it) }`
- **lazy variables** : their values is assigned when they are accessed first time. See [idioms.kt/lazyLoading](src/main/kotlin/idioms.kt)

### Functional programming / lambdas
- Lambdas are a part of the language and quite cheap to use. See [Lambdas](src/main/kotlin/functional.kt)
- 

#Coroutines
- Much faster and cheaper compared to `threads`. See [coroutine v.s thread examples](src/main/kotlin/coroutines.kt)
- 100K/1 million coroutines can finish very quickly whereas similar number of threads will throw `OutOfMemory` error or will be quite slow ( 10+x for our example)
- Following dependency shall be added to projects: 

        <dependency>
            <groupId>org.jetbrains.kotlinx</groupId>
            <artifactId>kotlinx-coroutines-core</artifactId>
            <version>1.3.2</version>
        </dependency>

### References
- https://kotlinlang.org/docs/reference/
- [How to Kotlin - from the Lead Kotlin Language Designer (Google I/O '18)](https://www.youtube.com/watch?v=6P20npkvcb8)
- [Safe calls(?.) vs Null checks(!!) in Kotlin by Suneet Agrawal](https://medium.com/@agrawalsuneet/safe-calls-vs-null-checks-in-kotlin-f7c56623ab30)