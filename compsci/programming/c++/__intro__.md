# C++

- C++ is a middle-level programming language developed by Bjarne Stroustrup starting in 1979 at Bell Labs. C++ runs on a variety of platforms, such as Windows, Mac OS, and the various versions of UNIX.

- C++ is a statically typed, compiled, general-purpose, case-sensitive, free-form programming language that supports procedural, object-oriented, and generic programming.

- C++ is regarded as a middle-level language, as it comprises a combination of both high-level and low-level language features.C++ is a superset of C, and that virtually any legal C program is a legal C++ program.

- Standard C++ consists of three important parts −
  - The core language giving all the building blocks including variables, data types and literals, etc.
  - The C++ Standard Library giving a rich set of functions manipulating files, strings, etc.
  - The Standard Template Library (STL) giving a rich set of methods manipulating data structures, etc.
  
- The ANSI standard is an attempt to ensure that C++ is portable; that code you write for Microsoft's compiler will compile without errors, using a compiler on a Mac, UNIX, a Windows box, or an Alpha. The ANSI standard has been stable for a while, and all the major C++ compiler manufacturers support the ANSI standard.

<br>
<br>
<br>

## Basic Sytax

- First, lets write the notorious Hello, World program:
  ```cpp
  #include <iostream>
  using namepsace std;
  
  int main() {
    cout << "Hello, World!";
    return 0
  }
  ```
  In order to compile and run this program firstly we need to save this into a file and give it a `.cpp` extension at the end. after that you can either use `gcc` compiler or `make` to compile your source code (just like in C)
  ```
  $ gcc foo.cpp 
  ```
  Which will give you a `a.out` file and you can run it with `./a.out` or you can use the `make` and run it with the files name.
  
- Comments are like in javascript etiher with `// ...` or `/* ... */`

<br>
<br>
<br>

## Variables

### Data Types

- I am not really going to note a lot about what data types are because I have already done it many times. I am just going to show how to write them  in c++ (Im gonna cover specific types later on such as Enumaration, Pointers, Arrays, Refereces, Classes, Strings). Lets see the code snippet below:
  ```cpp
  char foo = "a";
  int bar = 10;
  float pi = 3.1415;
  double baz;
  
  /*
    There are many more types such as
    signed char, unsigned int, short int
    ... etc. Check the docs for more info
  */
  ```
  
- Quick Note: Since C++ is very close to C do not use 1 for true and 0 for false. True is `true` and false is `false` in C++

### typedef Declarations

- You can create a new name for an existing type using typedef. Following is the simple syntax to define a new type using typedef −
  ```
  typedef type newname; 
  ```
  For example, the following tells the compiler that feet is another name for int −
  ```cpp
  typedef int feet;
  ```
  Now, the following declaration is perfectly legal and creates an integer variable called distance −
  ```cpp
  feet distance;
  ```
  
### Variable Scopes

- A scope is a region of the program and broadly speaking there are three places, where variables can be declared −
  - Inside a function or a block which is called local variables,
  - In the definition of function parameters which is called formal parameters.
  - Outside of all functions which is called global variables.

- Lets see an example of the scopes:
  ```cpp
  #include <iostream>
  
  // Gloabal Variable
  int g = 200;
  
  int main () {
    // Local Variable
    int g = 10;
    
    cout << g;
    
    return 0;
  }
  ```
  Local variables and global variables can share same names however the local variable will always get the presedence over the global one.
  
### Constants

- Constants refer to fixed values that the program may not alter and they are also called `literals`. There are two simple ways in C++ to define constants −
  - Using #define preprocessor.
  - Using const keyword.

- Following is the form to use #define preprocessor to define a constant (you do not put semicolon at the end) −
  ```
  #define identifier value
  ```
  Lets see it in a real life example:
  ```cpp
  #include <iostream>
  
  #define LENGTH 10
  #define WIDTH 5
  #define NEWLINE "\n"
  
  ...
  ```
  
- The method above is very C-like so lets see a modern way. You can use const prefix to declare constants with a specific type as follows −
  ```cpp
  const type variable = value;
  ```
  Real time example is the following:
  ```cpp
  const int HEIGHT = 15;
  const int WIDTH = 25;
  ```
  Note: You do not have to capitilize but it is good for readablity

### Modifier Types

- C++ allows the char, int, and double data types to have modifiers preceding them. A modifier is used to alter the meaning of the base type so that it more precisely fits the needs of various situations.

- The Data type modifiers are - `signed`, `unsigned`, `long`, `short`

- The modifiers signed, unsigned, long, and short can be applied to integer base types. In addition, signed and unsigned can be applied to char, and long can be applied to double.

- The modifiers signed and unsigned can also be used as prefix to long or short modifiers. For example, `unsigned long int`.

- I DO NOT KNOW WHAT THE TUTORIALS IS TRYING TO TEACH ABOUT MODIFIERS. I WILL RE-VISIT OR LEARN THEM LATER ON FROM BOOKS

<br>
<br>
<br>

## Storage Classes

- A storage class defines the scope (visibility) and life-time of variables and/or functions within a C++ Program. These specifiers precede the type that they modify. There are following storage classes, which can be used in a C++ Program: `auto`, `register`, `static`, `extern`, `mutable`

### auto

- The auto storage class is the default storage class for all local variables.
  ```cpp
  {
   int mount;
   auto int month;
  }
  ```
  The example above defines two variables with the same storage class, auto can only be used within functions, i.e., local variables.
  
### register
  
- The register storage class is used to define local variables that should be stored in a register instead of RAM. This means that the variable has a maximum size equal to the register size (usually one word) and can't have the unary '&' operator applied to it (as it does not have a memory location).
  ```cpp
  {
   register int  miles;
  }
  ```
  Do not use this if you really do not need a specific register or counter usage
  
### static

- The static storage class instructs the compiler to keep a local variable in existence during the life-time of the program instead of creating and destroying it each time it comes into and goes out of scope. Therefore, making local variables static allows them to maintain their values between function calls.
  
  The static modifier may also be applied to global variables. When this is done, it causes that variable's scope to be restricted to the file in which it is declared.
  ```cpp
  static int n = 10;
  
### extern
  ```
  
  
  
<br>
<br>
<br>

## Loops
 
  
  
  
  
  
  
  
