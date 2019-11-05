Java Application Development
================

_2. Java Application as a White Box: designing, coding, debugging and using._ 50hrs.

# Attendee prerequisites
- [ ] 1. Java Application Building

# Training Objectives
- [ ] Hands-on skill of localizing and fixing deep build-time errors
- [ ] Hands-on skill of run-time JVM parameterization
- [ ] Understanding Java syntax deep details
- [ ] Understanding system design principles and patterns
- [ ] Hands-on skill of developing maintainable application
- [ ] Hands-on skill of developing error-handling applications
- [ ] Understanding Java parallelism and concurrency architecture
- [ ] Hands-on skill of localizing and fixing concurrency issues
- [ ] Understanding Java Collections API
- [ ] Hands-on skill of developing memory-intensive applications
- [ ] Understanding Java networking architecture
- [ ] Hands-on skill of developing distributed applications
- [ ] Understanding Java IO architecture
- [ ] Understanding JDBC architecture
- [ ] Hands-on skill of developing data-persistent applications
- [ ] Understanding Java dynamic class-loading architecture
- [ ] Hands-on skill of developing high-uptime applications
- [ ] Hands-on skill of developing applications with i16n and l18n 
- [ ] Hands-on skill of IDE productive using

# Prerequisites
### Hardware
- [ ] RAM ≥ 8Гб
- [ ] Wi-Fi with Internet access
## Software
- [ ] [git](https://git-scm.com/downloads)
- [ ] [JDK8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [ ] [IDEA (trial Ultimate)](https://www.jetbrains.com/idea/download/)
- [ ] [Maven](https://maven.apache.org/download.cgi)
## Network Access
- [ ] github.org :443 :80
- [ ] repo1.maven.org :443 :80
- [ ] jcenter.bintray.com :443 :80

# Agenda
## Training introducing and focusing (1 hrs)
- [ ] Schedule
- [ ] Trainer
- [ ] Training overview
- [ ] Rules
### Hands-on: teams and their demand
- [ ] Pairs forming and introduction
- [ ] Attendees prerequisites check
- [ ] Topics focus demand from attendees
- [ ] Additional topics demand form attendees

## Sound-check (1)
### Hands-on
- [ ] Training repo fork and clone
- [ ] Open project with IDEA
- [ ] Project JDK set
- [ ] Sourcepath and classpathes
- [ ] Maven full build
### Demo
- [ ] Application requirements overview
- [ ] Application architecture overview
- [ ] DevOps pipeline overview

## Java application documenting (1)
### Java application structure recap
- [ ] Methods: why?
- [ ] Classes: why?
- [ ] Packages: why?
### Documenting
- [ ] Single-line comments
- [ ] Multi-line comments
### JavaDoc comments demo
- [ ] Syntax for documenting methods and classes
- [ ] Documenting packages
- [ ] Maven download dependencies sources and javadocs
- [ ] Using javadocs with IDE
### Maintainability with documentation
- [ ] What entities we should comment?
- [ ] What we should describe with comments?
- [ ] Comments Quality Gate

## Java Syntax for Procedure Style (2)
### Key concepts
- [ ] Package
- [ ] "Class"
- [ ] Class variables
- [ ] Method
- [ ] Method variables
- [ ] Naming things with JCSC
### Package
- [ ] Package: why?
- [ ] Package declaration
- [ ] Import directive
### Class
- [ ] Class: why?
- [ ] Class declaration
- [ ] Class variables declaration
- [ ] Static initialization section
### Method declaration
- [ ] Method: why?
- [ ] Method declaration
- [ ] Method body code block
- [ ] Returning values
### JVM memory structure
- [ ] Methods call stack
- [ ] Perm/Meta space
### Calling methods
- [ ] Dot notation
- [ ] Static import directive
### Parameters passing while calling methods
- [ ] 3 passing styles
- [ ] Formal and factual arguments
### Demo
- [ ] Debug session with primitive value passing and monitoring variables
### Methods overloading
- [ ] Overloading concept
- [ ] Why?
- [ ] Overloading operators and "+" operator
### Hands-on
- [ ] Developing maintainable overloaded Facade API throught TDD with test stubs supplied

## Java primitive types system (2)
### Variable declaration
- [ ] Variable declaration scopes
- [ ] Declaration
- [ ] Initialization
- [ ] Literals
- [ ] Default initialization values for class and method variables
### Memory allocation size
- [ ] JLS vs JVM implementation
### Evens and literals
- [ ] byte
- [ ] int
- [ ] short
- [ ] long
### Fractions and literals
- [ ] float
- [ ] double
### Character and literals
- [ ] char
### Logical and literals
- [ ] boolean
### Wrappers
- [ ] Wrapper types and main features: referenced, constants, string parsing
- [ ] Why?
- [ ] Autoboxing/unboxing and performance issue
### Hands-on
- [ ] Implement application state with class variables

## Java operators for data processing (2)
### Type operators
- [ ] type casting
- [ ] instanceof
### Arithmetics
- [ ] +, -, *, /, %
- [ ] Typed operators: 1/3 vs 1/3.
- [ ] Arithmetic types promotion
- [ ] ArithmeticException
- [ ] Types Overflow and solution with BigInteger
- [ ] FP precision loss and solution with BigDecimal
### Bitwise
- [ ] &, |, ~, ^
- [ ] <<, >>, >>>
### Logical
- [ ] Type-stricted
- [ ] &, |, !
- [ ] Lazy and eager form
- [ ] ==, !=, <, <=, >, >=
- [ ] Reference types issue: absence of === and .equals()
- [ ] Ternary operator
### Hands-on
- [ ] Implement application typed accumulating state 

## Controlling execution flow (2)
### Switching
- [ ] if
- [ ] switch and limitations
### Demo
- [ ] Does switch use == or .equals() for String type?
### Looping
- [ ] for
- [ ] do
- [ ] while
- [ ] "foreach"
### Breaking switches and loops
- [ ] Nested switches and loops
- [ ] break
- [ ] continue
- [ ] labels:
### Design considerations
- [ ] Procedure Metrics: CC
- [ ] Readability and high CC: Extract Method refactoring
### Hands-on
- [ ] Implement application typed accumulating state with Overflow and Presicion loss handling

## Java reference types (2)
### References
- [ ] Reference + referenced object
- [ ] Memory structure revisited: Heap object space
- [ ] Object structure and its defining class
### Demo
- [ ] Where reference can be placed?
- [ ] What is memory consumption for reference?
- [ ] What is default value for reference?
- [ ] Double-referencing and == vs equals()
- [ ] Dereferencing and GC
### Reference argument passing
- [ ] What passing style used?
- [ ] Side effects concept and its scopes
### Demo
- [ ] Reference passing and memory side effect
### Java Array reference type
- [ ] Declaration
- [ ] Initialization
- [ ] API: addressing, length
- [ ] Exceptions
- [ ] "Immutability"
- [ ] "foreach" cycle
- [ ] Milti-dimentional arrays
- [ ] Array literal
### Demo
- [ ] Milti-dimentional literal references array walking
### Varargs
- [ ] Why?
- [ ] Declaration
- [ ] Passing
- [ ] Using
- [ ] Limitations
### Strings
- [ ] Declaration
- [ ] Initialization with literal and constructor
- [ ] "Immutability" vs StringBuffer/StringBuilder
- [ ] API
- [ ] Strings equality: == and .equals()
- [ ] Surprise: Strings interning and pool
### Demo
- [ ] Strings interning
- [ ] Wrappers interning and limitations
### Hands-on
- [ ] Enrich application API with Strings and Varargs

---

## Java Installation
- Installation process demo
- Practice: JDK installation
- JDK structure demo
- JDK tools overview

## Java Application Structure
- App overview and structure
- Class
- Classpath
- Package
- JAR
- Practice: Java App compiling
- Practice: Java App launching
- JVM options and App parameters
- Compiling and Running old version Apps
- Типовые граничные условия (для тестов)

## Java Code
- Build tools: mvn
- Class
- Object
- Method
- Call Stack
- Design
- Simple App demo

## Exceptions in Java
- Call stack recap
- try/catch/finally
- Exceptions hierarchy
- Mostly used exceptions
- Stacktrace in log demo

## Typical Server App Design
- threads
- sockets

## JVM Architecture
- Threads
- Stack
- Heap
- GC overview
- JVM options for heap and stack tuning
- *nix limits for threads per process
- JVisualVM demo
- Типовые граничные условия для тестов

## GC and Heap Architecture
- Garbage
- [Heap architecture](http://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/index.html)
- [Types of GC](http://www.slideshare.net/akirakoyasu/garbage-collection-for-dummies)
- [GC and Heap tuning](http://blog.ragozin.info/2011/12/garbage-collection-in-hotspot-jvm.html)
- [JVM options for GC tuning](http://blog.ragozin.info/2013/11/hotspot-jvm-garbage-collection-options.html)
- GC console demo
- Типовые граничные условия для тестов

## Heap and Stack Monitoring
- *Sampling vs Profiling*
- [CPU Time vs Wall Time](http://stackoverflow.com/questions/14626475/visualvm-and-self-time)
- [Safepoints](http://stackoverflow.com/questions/17839933/what-are-safe-points-and-safe-point-polling-in-context-of-profiling)
- Heap and GC monitoring with JVisualVM demo
- Stack and threads monitoring with JVisualVM demo
- Heap and Stack Dumps with JVisualVM demo

## Java App Troubleshooting
- Main trouble reasons
- *Logging frameworks*
- Exceptions in logs
- JVM crash dumps
- GC collection pauses
- Типовые граничные условия для тестов

## Typical Enterprise App Architecture
- Layers: UI, BL, DAL
- Frameworks overview (Spring, EJB)
- JDBC
- AppServer architecture
- ThreadPools
- ConnectionPools
- Типовые граничные условия enterprise java app для тестов
