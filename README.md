# Java to Kotlin
### Build
[Kotlin maven plugin 1.3.50 is used](https://kotlinlang.org/docs/reference/using-maven.html)
`mvn clean compile`
- Kotlin allows a `main function` per file. Each of them can be run independently.

### Variables
- **val** : read-only reference (`final` in Java). 
- **var** : mutable reference (default type in Java). 
- **lazy variables** : their values is assigned when they are accessed first time.
- **statical typing**: Kotlin is statically typed but type information/casts can be omitted most of the time as compiler can infer them.
- **Examples** [Variable Examples](src/main/kotlin/variables.kt)
### Functions
- **Named & Default Arguments:** Kotlin has default values for parameters. Also arguments can be named as well and that allows you to change the order of the arguments. 
`@JvmOverloads` annotation is required to access default argument methods from Java code.  
- **Extension functions:** 
    -- Kotlin allows extensions functions on types and that makes types/apis much simpler
    -- Extensions allow you add code to classes in other libraries that you don't have access to
    -- They shall be imported in case of usage out of the package.
    -- They can be used from Java with the extra receiver parameter
    -- Receivers can be `nullable` types as well, like `String?`. 
    But make sure you give a good name telling that the variable calling that method can be null. Other wise users may be confused
    -- They can't access private member of the classes they are extending
    -- There is No Kotlin SDK, it is Java SDK + some extension files
- **Local function:** You can scope functions inside functions 
- **inline functions:** inline functions don't create a new stack in memory 
- **Top level functions**: Functions don't require a wrapping class, they can be sitting at the top level alone. 
In order to access them from Java enclosing filename can be used and top level method will be a static method. Or `JvmName` annotation can be used to customize this.
- **Examples** [Kotlin Functions](src/main/kotlin/functions.kt) and [Java Functions](src/main/java/FunctionsJava.java)

### Controls
- **If & when are expressions** : There is no requirement for a ternary operator.
- **when is stronger than switch** : It pattern matching is very strong. Any expression can be used. 
- **Examples** [Control Examples](src/main/kotlin/controls.kt)

### Properties
- Default getters are created for `val` and getters & setters for `var`
- Custom properties can be created by overriding using `get & set` keywords
- getters & setters can be used from Java to access Kotlin properties
- **Fields** 
    - Can be accessed inside accessors using keyword `field`. Fields are not accessible to other properties.
    - Try not to use fields and always us properties instead form both inside & outside
    - If get/set are customized and `field` keyword is not used in the implementation, no backing field is generated.
    - Changing visibility of a setter/getters is possible using `private set/get`
- Interfaces can have properties as well. They are called `open property`. Subclasses will override them.
- Smart casts don't apply to open properties & mutable variables
- **Property extensions** 
    - Like function extensions can be used to add to existing classes
    - They have to be used inside a class, can't be used at the top level
- **lateinit** 
    - Can be used for the cases where you init a property later in the code
    - You can use a `nullable` property but that will force you to use safe access all the time
    - `lateinit` saves this problem and throws `kotlin.UninitializedPropertyAccessException` if initialization is not done before usage
    - `isInitialized` can be called to make sure if initialization is done yet
    - `lateinit` properties have to be`var` as their value is set later
    - `lateinit` properties can't be primitive types
- **Examples** [Property Examples](src/main/kotlin/properties.kt)

### Idioms
- **String interpolation** "sum of $a and ${b.length} is ${a + b.length}"
- **Nullability** 
    - **Compile time checks** Rather than having runtime `NullPointerException`s compiler forces you with compile time checks.
    - **nullable types** You can assign `null` to only nullable types using `?`.
    - **Safe Calls (?.)** : `nullableCustomer?.name` dereferences safely only when customer is not null
    - **Non Safe Calls (!!.)** : `nullableCustomer!!.name` dereference forcefully, make assertion that customer is not null but you may end up with a null pointer exception if your assertion is not true
    - **Elvis Operator (?:)** : `val result = nullableCustomer?.someMethodCall() ?: fallbackIfNullMethodCall()` this can return a custom value if the calling property is null
    - **let** : Executes if not null `nullableCustomer?.let { validateCustomer(it) }`
    - **Optional** nullable types use annotations (`@Nullable/@NotNull`) under the hood and don't create an extra wrapper object like `Optional`s. 
    That means there is no performance overhead as well.
- **Exceptions** No checked exceptions
    - **throw/try** are expressions that can be assigned to any variable
    - `@Throws(IOException::class)` can be used for forcing Java side explicit checked exception handling
- **Safe Casts `as?`** returns null if the cast can't be done. Non-safe type cast `as` throws ClassCastException, if the cast is unsuccessful.
- **Examples** [Idioms](src/main/kotlin/idioms.kt)
### Functional programming / lambdas
- Kotlin is not purely functional. It combines ides from different paradigms like OO, functional
- **Lambdas** are a part of the language and quite cheap to use. See 
    - Don’t use `it` if it has different types in other lambda lines
    - Prefer explicit parameter names if `it` might be confusing
    - Wrap complex lambdas with a well named variable to make it readable
    - `Lambda`s can be assigned to a variable and passed to other methods. 
    Even they can be nullable and called safely using `f?.invoke()`
    - In Java only SAM (Single abstract method) interfaces can be passed as lambdas.
  **Member References** Can be used to access simple lambdas accessing member varibles/functions
    - Syntax is same as Java : `Customer::name`
    - Lambdas can be assigned to variables but functions can't. Functions are clearly different from variables.
    - Function references `::function` can be assigned to variables. Internally they are converted to lambdas calling that function only.
    - **Non-bound reference** : Can be used with any instance 
    - **Bound reference** : Attached to a specific instance of the class.
    - **::method** syntax can be used to bound to top level or in a class to this instance
- **Collections**: builder functions can be used for list/map and other collections.
- **Ranges**: Any comparable type can be used as a Range. `"Kotlin" in "Java".."Scala"` can be used to built up ranges.
- **Examples** [Lambdas and Collections](src/main/kotlin/functional.kt)

### OO programming
- Default declarations are : `public/final`
- `open` shall be explicitly used to make a class non final
- There is no `package private` concept. It is replaced by `internal` and declaration is visible inside same `module`
  A module is a set of Kotlin files compiled together:  
    - Intellij module
    - maven source set
    - gradle source set
- `override` is **mandatory** (contrary to Java ) to make things clearer
- `protected` is only about subclasses, it doesn't include package (another difference to Java)
- `private` has different meaning for class members and top level declarations. 
    - Top level private declarations are visible in the same file
    - class member private declarations are visible only in same class
- Kotlin to JVM level (byte call) modifiers
    - public/protected => public/protected
    - private -> private (for functions and members)/package private (for classes / there is no private class on that level) 
    - internal -> public + name mangling (inorder to prevent accidental usages from Java)
- In Kotlin you can put several classes/top level functions in one class
- Package name doesn't have to match directory structure.
- `val/var` before constructor parameters creates properties as well. Without parameters are usual parameters
- `constructor` can be used to create secondary constructors but the primary one shall be called before any other code
- Overriding properties in the subclasses shall be taken carefully as `open` properties are called with getters not field values even inside same class.
- **Examples** [OO Examples](src/main/kotlin/objectoriented.kt)
#### Pojo Declarations
- Unlike Java Kotlin Pojos don't require any getter & setters.
- Kotlin members variables can be both val & var
- `with` can be used in Kotlin to decompose and access class members 
- Kotlin `Singletons` can be declared using `object`. 
- **Examples** [Pojo Examples - Java](src/main/java/CustomerJava.java) and [Pojo Examples - Kotlin](src/main/kotlin/Customer.kt)

#### enums/Data Classes/typealiases
- **enums** are similar to Java but declaration is like `enum class ClassName`. Also `;` is used right after constant declaration
- **Kotlin Data Classes** come with equals/hashcode/toString/copy (copies an instance but only changes the specified field)
- **Data classes are immutable**: You can have only val, encourages immutability
- ** `--` calls `equals` and `---` can be used for reference equality check. It is quite different than Java. For data classes we have equals implementation coming free.
- **typealias** es can be used to create readable code.
- **Examples** [Data Classes and typealiases](src/main/kotlin/modifiers.kt)
#### Inner Classes
- **Nested classes** are by default converted to static (static inner classes in Java)
- **Inner classes** have to be explicitly defined using `inner` keyword. 
And they hold a reference to top level class internally. Be aware of memory leaks. 
- **Examples** [Inner Class examples](src/main/kotlin/modifiers.kt)
#### Sealed Classes
- All the subclasses shall be defined in the same file
- Makes it quite handy to use with pattern matching with when
- Under the hood it creates a default private constructor to prevent instantiations/subclasses from Java 
- **Examples** [Sealed Classes](src/main/kotlin/SealedCustomer.kt) 
#### Class Delegation
- Implementation of the interfaces can be delegated to instances
- Can be helpful especially incase of full delegations
- **Examples** [Class Delegation](src/main/kotlin/classdelegation.kt) 
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