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
    This allows adding some features that are only applicable to some modules and are hidden from the rest.
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
- **when is stronger than switch** : Its pattern matching stronger. 
- **Kotlin does not support full pattern matching**. A combination of **when + smart casts** solves most of the cases. 
It is a design choice made to keep language simple.
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
### Functional Programming / Lambdas
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

### OO Programming
- Default declarations are : `public/final`
    - `final` makes **smart casts** possible, open fields won't allow that. 
    - `public` improves usability for most applications
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
- **Examples** [OO Examples](src/main/kotlin/oop/objectoriented.kt)
#### Pojo Declarations
- Unlike Java Kotlin Pojos don't require any getter & setters.
- Kotlin members variables can be both val & var
- `with` can be used in Kotlin to decompose and access class members 
- Kotlin `Singletons` can be declared using `object`. 
- **Examples** [Pojo Examples - Java](src/main/java/CustomerJava.java) and [Pojo Examples - Kotlin](src/main/kotlin/oop/Customer.kt)

#### Enums/Data Classes/Type Aliases
- **enums** are similar to Java but declaration is like `enum class ClassName`. Also `;` is used right after constant declaration
- **Kotlin Data Classes** come with equals/hashcode/toString/copy (copies an instance but only changes the specified field)
    - They are **immutable**: You can have only val, encourages immutability
    - **Avoid using `var` variables** with `data classes`. It will cause problem in case of usage inside maps. 
    They can be set as private or excluded from constructor so that they are excluded from equals/hashcode generation
    - ** `--` calls `equals` and `---` can be used for **reference equality check**. 
    It is quite different than Java. For data classes we have equals implementation coming free.
- **typealias** es can be used to create readable code.
- **Examples** [Data Classes and typealiases](src/main/kotlin/oop/modifiers.kt)
#### Inner Classes
- **Nested classes** are by default converted to static (static inner classes in Java)
- **Inner classes** have to be explicitly defined using `inner` keyword. 
And they hold a reference to top level class internally. Be aware of memory leaks. 
- **Examples** [Inner Class examples](src/main/kotlin/oop/modifiers.kt)
#### Sealed Classes
- All the subclasses shall be defined in the same file
- Makes it quite handy to use with pattern matching with when
- Under the hood it creates a default private constructor to prevent instantiations/subclasses from Java 
- **Examples** [Sealed Classes](src/main/kotlin/oop/SealedCustomer.kt) 
#### Class Delegation
- Implementation of the interfaces can be delegated to instances
- Can be helpful especially in case of full delegations
- **Examples** [Class Delegation](src/main/kotlin/oop/classdelegation.kt) 
#### Object Expressions
- Object expressions `object :` replace Java's anonymous classes in order to create classes with no names on the fly
- If you have a Java SAM interface prefer a lambda instead of an object expression. You don't need that for Kotlin interfaces.
- **Examples** [Object Expressions](src/main/kotlin/oop/objects.kt) 
#### Companion Objects
- They are special object inside a class created using `companion` keyword.
- They are introduced to get rid of `static` functions in Java. (Top level functions also help for that)
- Companion objects can implement interfaces which can help a lot.
- Extensions functions can be added to `companion objects`
- From Java `Companion` keyword can be used to access. Another alternative is to use `@JvmStatic` annotation in Kotlin
- Kotlin doesn't use `static` keyword. But that functionality exist via
    - Top level 
    - Inside objects
    - Inside `companion objects`
- Objects can be nested inside objects and classes but `inner object` can't be used inside a class as it won't know which outer reference to store.
- **Examples** [Object Expressions](src/main/kotlin/oop/objects.kt) 
#### Constants
- `const` keyword can be used for primitive types and Strings. 
- It will inline the values at compile time and increase performance
- `JvmField` will tell compiler not to generate the getters/setters for fields and make fields accessible
- `JvmStatic` only makes the properties available without using `INSTANCE`. Access is still via property not field.
- **Examples** [Constants and JvmFields](src/main/kotlin/oop/constants.kt) 
#### Generics
- Generics are quite similar to Java
- They support `nullable` types as well
- Upper bounds (using `:`) can be used to restricted the types, e.g `T : Any` will not allow nullable types. 
- Upper bounds can contain type itself and support nullable types as well e.g `T : Comparable<T>` `T: String?`
- Same names on the extension functions with different generic type receivers don't work. 
`JvmName` can be used to create different names at bytecode level. That is for Java access. On kotlin side same name can be used.
- **Examples** [Generics](src/main/kotlin/oop/generics.kt) 

### Conventions
- They apply to Kotlin but if right naming used on the Java side Kotlin still can benefit from those conventions.
- Extensions can be used to facilitate those conventions for Java classes as well.
- Custom operators are not allowed as that can end up unreadable code.
- Unlike Java Kotlin prefers `conventions` to `interfaces` for the following two reasons
    - `extensions` allow you to add those conventions to classes that are not under your control
    - You can decouple utility functions from your main code and keep it clean with the help of `extensions` + conventions
#### Operator Overloading
- Fixed number operators can be overridden. You can't use custom operators.
    - **Binary** : plus(+)/minus(-)/times(*)/div(/)/mod(%)
    - **Unary** : unaryPlus(+a)/unaryMinus(-a)/not(!a)/inc(++a, a++)/dec(--a,a--)
- Be careful while using `+=` with immutable lists as it will create a new list instead of updating. 
- There is no restriction on the parameter type, it can be custom or built in types or mix
#### Other Conventions 
- Comparisons `</<=/>/>=` operators can be used automatically for any class implementing `Comparable`
- Equality Check
    - `x == y` is converted to `x.equals(y)`. Also `null` check is handled as well 
    - `null == "xyz"` => false
    - `null == null` => true
- Accessing elements by index
    - map[x,y] will call map.get(x,y)
    - map[x,y] = z will call map.set(x,y,z)
    - get & set operator functions should be defined to use indexed `[]` element access
- `x in y` is converted to `y.contains(x)`
- `start..end` is converted to `start.rangeTo(end)`
- `for` loops operates over any `Iterable` e.g Kotlin String
- Destructuring is also done via convention
    - val (x,y) = a is converted to `val x = a.component1()` and `var y = a.component2()`
    - `data classes` generate `component` functions automatically for you using constructor order.
    For other classes you have to add them manually. 
    -  Pairs/Maps/IndexValues can be destructed
    - `pairs` are always wrapped using parenthesis contrary to `lambda` parameters which can be free
    - `withIndex` function results can be also destructed in order to utilize the index
- **Examples** [Conventions/Operator Overloading](src/main/kotlin/conventions.kt)

### Coroutines
- Much faster and cheaper compared to `threads`. 
- 100K/1 million coroutines can finish very quickly whereas similar number of threads will throw `OutOfMemory` error or will be quite slow ( 10+x for our example)
- Following dependency shall be added to projects: 

        <dependency>
            <groupId>org.jetbrains.kotlinx</groupId>
            <artifactId>kotlinx-coroutines-core</artifactId>
            <version>1.3.2</version>
        </dependency>
- **Examples** [coroutine v.s thread examples](src/main/kotlin/coroutines.kt)

### Inline Functions
They look like built in construct but actually they are just library functions
- **run** : runs the lambda and returns back the last expression as result
- **let** : allows to check the argument/receiver for being non-null, also creates a ne variable internally
- **takeIf**: If the given predicate is satisfied returns the receiver object, otherwise returns null.
- **takeUnless**: Opposite of `takeIf`. Both of them can be helpful in chained calls
- **repeat**: repeats an action for a given number of times. Can be used for simple scenarios instead of a `for` loop. 
- All of the functions above are defined as inline : `inline fun <R> run(block: () -> R): R = block()`
    - Inline functions doesn't bring any performance overhead 
    - The code inside lambda is replaced with the inline function call. 
    The final bytecode is same as hardcoding the body without any method usage
    - No extra anonymous classes or variables are created
    - There are some restrictions on the lambdas that can be used inside an inline function. 
    You can't store the lambda anywhere to a variable. You have to call it directly
- **`filter`, `withLock` and `use`** are other examples of inlined functions 
- **`@InlineOnly`** Tells that this function should not be called directly without inlining. 
  Those functions will not be available from Java
- **Examples** [Inline Functions](src/main/kotlin/inlinefunctions.kt)
#### When shall I use inline functions
- By default don't use inline for custom methods as VMs(Hotspot) does this for you.
- Reducing number of stack frames shall not be the reason for using `inline` as this shall be handled by VMs automatically 
- `inline` can be helpful fo reducing the **object allocation for lambdas**
- Only small code portions only shall be set as inline

### Sequences
#### Collections v.s Sequences
- Operations on Collections are great as long as you make a **single function call**. **Lambdas are inlined**.
- **Chain of calls** on collections will end up intermediate collections and performance overheads.
- Collection operations are **eager** and are applied **horizontally** to all collection elements
- Sequences are **like Java 8 streams** and operations on them are **lazy** and are applied **vertically** to only the elements that are required.
- Sequences **don't create intermediate collections**. 
- None of the intermediate operations are applied until a terminal operation is called on sequences
    - **intermediate operations**: map, filter and any other operation returning a sequence. They are **not inlined** as they shall be stored.
    - **terminal operations**: Any other operation returning anything other than a sequence. They **are inlined**
- **Order of the operation** is very important for sequences. It may change the number of operations applied a lot.
#### Sequences
- They have `operator fun iterator` to be usable by a `for` loop
- They don't extend from `Iterable/Collection` inorder to distinguish lazy/eager differentiation
- Extensions on sequences are very similar to ones on collections to make it easy to work on
- `generateSequence` can be used to create sequences from scratch
    - Stops when a `null` is return as an element
    - Overloaded version which takes the first element can be used to generate infinite seq
- `yield` library function als can be used to generate sequences in a wider customized way
    - It works lazily and will not do anything unless required
    - It can return a single value/collection/sequence using `yiled` and `yieldAll`
    - It allows you to do custom operations between the yields
    - Its implementation is based on `coroutines`
    - No elements are yielded until a terminal operation is called
- Lazy functions like `groupingBy` can be used instead of eager ones like `groupBy` 
- **Examples** [Sequences](src/main/kotlin/sequences.kt)

### Lambda with Receiver
- It is a syntactic sugar for the lambda and takes its first parameter as `this`
- It is the lambda version of extension functions. Types are extended to accept lambdas.
- They can be used to create DSLs in Kotlin, e.g HTML, Gradle build scripts 
- Function `with` is implemented using lambda with receiver:
`inline fun <T, R> with(
  receiver: T,
  block: T.() -> R
 ): R = receiver.block()`
#### Functions using Lambda & Lambda with Receiver 
- `run` is like `with` but it is an extension and can be applied to a `nullable` receiver
- `apply` returns the receiver as a result and is helpful in case of chained calls
- `also` is like `apply` but it takes a `regular lambda` not `lambda receiver type`
- **Examples** [Lambda with Receiver](src/main/kotlin/sequences.kt) 

### Types
- There is no primitive type in Kotlin
    - Kotlin Int is converted to `int` primitive type. Int? is converted to `Integer` wrapper type
    - Double/Float/Boolean applies the same rule
    - Generic type arguments are always converted to `Integer` wrapper type. 
    - Kotlin `Array<Int>` is converted to Java `Integer[]`. `IntArray` class will generate `int[]`
- Kotlin String is converted to `java.lang.String`. It modifies the String Api
    - Some of the confusing methods are hidden
    - `replaceAll` in Java accepts regex parameters as String. Kotlin String uses `replace` with String and Regex object parameters
- `Any` is the super type of all nun nullable types and is converted to `java.lang.Object`
- Kotlin `Function types` are replaced with **corresponding interfaces** if they are **not inlined**
    - `() -> T` is converted to `Function0<T>`
    - `(T) -> R` is converted to `Function1<T,R>`
    - `(T,U) -> R` is converted to `Function2<T,U,R>`
    - `f()` is a short version of `f.invoke()` (Function0/1/2.. interfaces declare `invoke()` method)
    - nullable function types can be called using `f?.inovke()`
- Kotlin arrays are converted to Java arrays
    - `Array<Int>` is converted to `Integer[]` 
    - `IntArray` is converted to `int[]` 
    - Kotlin arrays also use reference check for `equals` as they are converted to Java.
    Extension `contentEquals` can be used to compare the content of arrays
    - Kotlin has arrays mainly for `Java interoperability`. 
    Kotlin mutable list uses ArrayList under the hood and shall be preferred to use Arrays. 
    Performance is very similar for ArrayList and Array
- `Nothing` is the subtype of all the classes in Kotlin type hierarchy
    - A function throwing exception can be changed to return `Nothing`
    - `Unit` functions complete normally, `Nothing` functions don't finish but returns (not throw!) an exception
    - Java `void` correspondence in Kotlin is `Unit` not `Nothing`
    - `Nothing` is required to handle the exception returning branches of the code. 
    We can keep the return types as they are as `Nothing` is a subtype for all the other types.
- There is also a **type hierarchy for nullable types**. 
    - Indeed `Any?` is the super type of `Any`
    - `Nothing?` can be expressed with `null` literal 
- **Examples** [Type Examples](src/main/kotlin/types.kt)     
#### Java to Kotlin types 
- `@Nullable` annotations in Java are visible in Kotlin as`Type?` nullable type     
- `@NotNull` annotations in Java are are visible in Kotlin as`Type`  
- Java classes with no (@Nullable/@NotNull) annotations are visible in Kotlin as **`Type!` called platform type**
    - It comes from Java and appears in error messages ans is a type of `unknown nullability`
    - `Type!` us a notation and not a syntax and can't be declared in Kotlin
    - It is solution for Java/Kotlin mix projects as converting Java classes to `Type?` would end up too many `!!` usages
    - Platform types (`Type!`) are allowed to be de-referenced without null check. 
    That means you may end up throwing `NullPointerException` 
- Two ways to prevent NPEs coming from Java Platform types (Type!)
    - Annotate Java classes with `@Nullable/@NotNullable`
    - Specify types on Kotlin side explicitly
- Specifying explicit types may throw runtime IllegalStateException sometimes but it is much clearer than a NPE
- Kotlin Collections are using Java collections under the hood
    - `java.util.List` will be represented by **Kotlin List & MutableList** 
    - Kotlin readonly collections hide some methods not to allow you to add/remove to collections
    - Kotlin readonly collections are not immutable as you can update individual items
    - Mutable versions of the collections can be used
    - Platform types are used to convert between Java (List) to Kotlin multiple classes (MutableList/List)
- **Examples** [Type Examples](src/main/kotlin/types.kt)   
### References
- https://kotlinlang.org/docs/reference/
- [How to Kotlin - from the Lead Kotlin Language Designer (Google I/O '18)](https://www.youtube.com/watch?v=6P20npkvcb8)
- [Kotlin for Java Developers by JetBrains](https://www.coursera.org/learn/kotlin-for-java-developers)
- [Safe calls(?.) vs Null checks(!!) in Kotlin by Suneet Agrawal](https://medium.com/@agrawalsuneet/safe-calls-vs-null-checks-in-kotlin-f7c56623ab30)