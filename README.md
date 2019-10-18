# Java to Kotlin
### Build
[Kotlin maven plugin 1.3.50 is used](https://kotlinlang.org/docs/reference/using-maven.html)
`mvn clean compile`
- Kotlin allows a `main function` per file. Each of them can be run independently.

## Variables
- **val** : read-only reference (`final` in Java). 
- **var** : mutable reference (default type in Java). 
- **lazy variables** : their values is assigned when they are accessed first time.
- **statical typing**: Kotlin is statically typed but type information/casts can be omitted most of the time as compiler can infer them.
- **Examples** [Variable Examples](src/main/kotlin/variables.kt)
### Functions
- **Named & Default Arguments:** Kotlin has default values for parameters. Also arguments can be named as well and that allows you to change the order of the arguments. 
`@JvmOverloads` annotation is required to access default argument methods from Java code.  
- **Extension functions:** Kotlin allows extensions functions on types
- **Local function:** You can scope functions inside functions 
- **inline functions:** inline functions don't create a new stack in memory 
- **Top level functions**: Functions don't require a wrapping class, they can be sitting at the top level alone. 
In order to access them from Java enclosing filename can be used and top level method will be a static method. Or `JvmName` annotation can be used to customize this.
- **Examples** [Kotlin Functions](src/main/kotlin/functions.kt) and [Java Functions](src/main/java/FunctionsJava.java)

### Controls
- **If & when are expressions** : There is no requirement for a ternary operator.
- **when is stronger than switch** : It pattern matching is very strong. Any expression can be used. 
- **Examples** [Control Examples](src/main/kotlin/controls.kt)

### Pojo Declarations
- Unlike Java Kotlin Pojos don't require any getter & setters.
- Kotlin members variables can be both val & var
- `with` can be used in Kotlin to decompose and access class members 
- Kotlin `Singletons` can be declared using `object`. 
- **Examples** [Pojo Examples - Java](src/main/java/CustomerJava.java) and [Pojo Examples - Kotlin](src/main/kotlin/Customer.kt)
### Data Classes and typealiases
- **Kotlin Data Classes** come with equals/hashcode/toString
- **Data classes are immutable**: You can have only val, encourages immutability
- **typealias** es can be used to create readable code.
- **Examples** [Data Classes and typealiases](src/main/kotlin/dataClassAndTypealiases.kt)

### Sealed Classes
- All the subclasses shall be defined
- Makes it quite handy to use with pattern matching with when
- **Examples** [Sealed Classes](src/main/kotlin/SealedCustomer.kt) 

### Idioms
- **String interpolation** "sum of $a and ${b.length} is ${a + b.length}"
- **Nullability** Once you have `nullable types` using `!` compiler forces you to dereference it under control.
    - **Safe Calls (?.)** : `nullableCustomer?.name` dereferences safely only when customer is not null
    - **Non Safe Calls (!!.)** : `nullableCustomer!!.name` dereference forcefully, make assertion that customer is not null but you may end up with a null pointer exception if your assertion is not true
    - **Elvis Operator (?:)** : `val result = nullableCustomer?.someMethodCall() ?: fallbackIfNullMethodCall()` this can return a custom value if the calling property is null
    - **let** : Executes if not null `nullableCustomer?.let { validateCustomer(it) }`
- **Examples** [Idioms](src/main/kotlin/idioms.kt)
### Functional programming / lambdas
- **Lambdas** are a part of the language and quite cheap to use. See 
- **Collections**: builder functions can be used for list/map and other collections.
- **Examples** [Lambdas and Collections](src/main/kotlin/functional.kt)

### Coroutines
- Much faster and cheaper compared to `threads`. 
- 100K/1 million coroutines can finish very quickly whereas similar number of threads will throw `OutOfMemory` error or will be quite slow ( 10+x for our example)
- Following dependency shall be added to projects: 

        <dependency>
            <groupId>org.jetbrains.kotlinx</groupId>
            <artifactId>kotlinx-coroutines-core</artifactId>
            <version>1.3.2</version>
        </dependency>
- - **Examples** [coroutine v.s thread examples](src/main/kotlin/coroutines.kt)
### References
- https://kotlinlang.org/docs/reference/
- [How to Kotlin - from the Lead Kotlin Language Designer (Google I/O '18)](https://www.youtube.com/watch?v=6P20npkvcb8)
- [Kotlin for Java Developers by JetBrains](https://www.coursera.org/learn/kotlin-for-java-developers)
- [Safe calls(?.) vs Null checks(!!) in Kotlin by Suneet Agrawal](https://medium.com/@agrawalsuneet/safe-calls-vs-null-checks-in-kotlin-f7c56623ab30)