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
- **Named & Default Arguments:** Kotlin has default values for parameters. Also arguments can be named as well and that allows you to change the order of the arguments. 
`@JvmOverloads` annotation is required to access default argument methods from Java code. 
 See [functions.kt/methodWithDefaultParameters](src/main/kotlin/functions.kt)
- **Extension functions:** Kotlin allows extensions functions on types e.g [functions.kt/extensionFunction](src/main/kotlin/functions.kt)
- **Local function:** You can scope functions inside functions e.g [functions.kt/extensionFunction/prefix](src/main/kotlin/functions.kt)
- **inline functions:** inline functions don't create a new stack in memory e.g [functions.kt/inlineFunction](src/main/kotlin/functions.kt)
- **Top level functions**: Functions don't require a wrapping class, they can be sitting at the top level alone. 
In order to access them from Java enclosing filename can be used and top level method will be a static method. Or `JvmName` annotation can be used to customize this.
See [Access Kotlin top level functions from Java](src/main/java/FunctionsJava.java)

## Variables
- **val** : read-only reference (`final` in Java). See [variables.kt/variableTypes](src/main/kotlin/variables.kt)
- **var** : mutable reference (default type in Java). See [variables.kt/variableTypes](src/main/kotlin/variables.kt)
- **lazy variables** : their values is assigned when they are accessed first time. See [variables.kt/lazyVal](src/main/kotlin/variables.kt)
- **statical typing**: Kotlin is statically typed but type information/casts can be omitted most of the time as compiler can infer them.

### Idioms
- **String interpolation** "sum of $a and ${b.length} is ${a + b.length}" see [idioms.kt/stringInterpolation](src/main/kotlin/idioms.kt)
- **Expressions** are used a lot even if, when can be expressions. See [idioms.kt/expressions](src/main/kotlin/idioms.kt)
- **Nullability** Once you have `nullable types` using `!` compiler forces you to dereference it under control. See [NullableCustomer](src/main/kotlin/NullableCustomer.kt)
    - **Safe Calls (?.)** : `nullableCustomer?.name` dereferences safely only when customer is not null
    - **Non Safe Calls (!!.)** : `nullableCustomer!!.name` dereference forcefully, make assertion that customer is not null but you may end up with a null pointer exception if your assertion is not true
    - **Elvis Operator (?:)** : `val result = nullableCustomer?.someMethodCall() ?: fallbackIfNullMethodCall()` this can return a custom value if the calling property is null
    - **let** : Executes if not null `nullableCustomer?.let { validateCustomer(it) }`
### Functional programming / lambdas
- **Lambdas** are a part of the language and quite cheap to use. See [Lambdas](src/main/kotlin/functional.kt)
- **Collections**: builder functions can be used for list/map and other collections. See [Collections](src/main/kotlin/functional.kt)

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
- [Kotlin for Java Developers by JetBrains](https://www.coursera.org/learn/kotlin-for-java-developers)
- [Safe calls(?.) vs Null checks(!!) in Kotlin by Suneet Agrawal](https://medium.com/@agrawalsuneet/safe-calls-vs-null-checks-in-kotlin-f7c56623ab30)