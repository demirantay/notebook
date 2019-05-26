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
  
- Even though `$ gcc` can compile c++ code, try to use `$ g++` it is the "right" compiler for c++ even though there is not a important difference
  
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

- A storage class defines the scope (visibility) and life-time of variables and/or functions within a C++ Program. These specifiers precede the type that they modify. There are following storage classes, which can be used in a C++ Program: `auto`, `register`, `static`, `extern`, `mutable` (I will note mutables later on in OOP)

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
  ```
  
### extern
  
- The extern storage class is used to give a reference of a global variable that is visible to ALL the program files. When you use 'extern' the variable cannot be initialized as all it does is point the variable name at a storage location that has been previously defined.
  
  When you have multiple files and you define a global variable or function, which will be used in other files also, then extern will be used in another file to give reference of defined variable or function. Just for understanding extern is used to declare a global variable or function in another file.
  
  The extern modifier is most commonly used when there are two or more files sharing the same global variables or functions as explained below.
  
- First file: Main.cpp
  ```cpp
  #include <iostream>
  int count;
  extern void toString();
  
  int main() {
    count = 5;
    toString();
  }
  ```
  Second File: Foo.cpp
  ```cpp
  #include <iostream>
  
  extern int count;
  
  void toString(void) {
    cout << "Count is" << count << "\n";
  }
  ```
  Here, extern keyword is being used to declare count in another file. Now compile these two files as follows −
  ```
  $ gcc main.cpp foo.cpp -o baz
  ```
  and run these two files with simply:
  ```
  $ ./baz
  ```

- extern is important I will read more on it later on from the books ...
  
<br>
<br>
<br>

## Loops
 
- I am not going to talk too much about loops since I have noted them a lot in other programming language documents. So I am just going to show how to write each one in c++:
  ```cpp
  /* While Loop */
  int i = 10;
  while(i < 20) {
    ...  
  }
  
  /* For loop */
  for (int i = 0; i < 10; i++) {
    ...
  }
  
  /* Do While loop */
  do {
    ...
  }
  while (i < 20);
  ```
  
- As with everyother programming language there are loop control statements for c++:
  ```cpp
  int i = 10;
  
  while (i < 20) {
  
    if (i == 15) {
      continue;
    }
    else if (i == 19) {
      break;
    }
    
    i++;
  }
  ```
  There is also a `goto` control statement however it is not adviced to use it in your program.
  
<br>
<br>
<br>

## Decision Making

- Decision making is where you put conditions in your code and depending on the conditions return value you make a decision. I will not note the logic behind it since I have written it a numerous times in my other programming language note files. Basically, decision making control statemetns are: `if`, `else`, and `switch` however I am not going to note down switch since I do not use it very often in my code:
  ```cpp
  int a = 10;
  
  if (a == 10) {
    ...
  } else if ( a == 20) {
    ...
  } else {
    ...
  }
  ```
  
- The `?:` operator : This operator can be used to replace if ... else statemetns. The general form is-
  ```
  Exp1 ? Exp2 : Exp3;
  ```
  The value of a ‘?’ expression is determined like this: Exp1 is evaluated. If it is true, then Exp2 is evaluated and becomes the value of the entire ‘?’ expression. If Exp1 is false, then Exp3 is evaluated and its value becomes the value of the expression.
  
<br>
<br>
<br>

## Functions

- The general form of a C++ function definition is as follows −
  ```cpp
  int sum (int num1, int num2) {
    int result = num1 + num2;
    
    return result;
  }
  ```
  
- **Note:** It is important that you declare your functions before your `main` function. You do not have to define its body code before main just the "decleration" just like in C. Lets see en exmaple with our function above:
  ```cpp
  #include <iostream>
  using namespace std;
  
  // function declaration
  int sum(int num1, int num2);
  
  int main () {
    int a = 10;
    int b = 20;
    int c = sum(a, b);
    
    cout << "Sum of a , b is : << c << "\n";
    
    retrun 0;
  }
  
  // function definition
  int sum (int num1, int num2) {
    int result = num1 + num2;
    
    return result;
  }
  ```
  
- When you define a function, you can specify a defauly value for each of the paremeters. This value will be used if the corresponding arugment is left blank when callig to the function:
  ```cpp
  int foo (int a = 10, int b) {
    ...
  }
  ```
  
<br>
<br>
<br>

## Arrays

- Arrays are very important so there will be a lot of notes. Just like in C in order to declare an array in C++ the programmer specifies the type and the size of array required:
  ```
  type arrayName [ arraysize ];
  ```
  Lets see an real world example:
  ```cpp
  int numbers[10];
  ```
  
- You can initialize C++ array elements either one by one or using a single statement as follows −
  ```cpp
  double balance[5] = {1000.0, 2.0, 3.4, 17.0, 50.0};
  ```
  The number of values between braces { } can not be larger than the number of elements that we declare for the array between square brackets `[]`
  
  If you omit the size of the array, an array just big enough to hold the initialization is created. Therefore, if you write 
  ```cpp
  double balance[] = {1000.0, 2.0, 3.4, 17.0, 50.0};
  ```
  
  or if you are not lazy you can assign all of them seperatly with the index points:
  ```cpp
  balance[3] = 50.0;
  ```
  
- You can acsess the values of arrays with using array index points:
  ```cpp
  dobule foo = balance[3] // foo has the value of arrays[3] point
  ```
  
### Multi-dimensional Arrays
  
- For example, the following declaration creates a three dimensional 5 . 10 . 4 integer array −
  ```cpp
  int threedimarr[5][10][4];
  ```

- Lets initialize a simple two dimensional array with the length of 5 elements inside of the arrays:
  ```cpp
  int foo[2][5] = {
    {0, 4, 6, 1, 7, 2},     // this is the array of foo[0]
    {10, 1, 5, 3, 9, 5},    // this is the array of foo[1]
    {50, 3, 6, 2, 198, 2},  // this is the array of foo[2]
  };
  ```
  In order to accsess the values of your two dimensinal array you can use this:
  ```cpp
  int val = foo[1][0];  // <-- has the value 10
  ```
  
- **I may have messed it up while writing the syntax of the multi-dimensional arrays. Furue note: Check the multi diensonal arrays later on**
  
### Pointer to an Array

- An array name is a constant pointer to the first element of the array. Therefore, in the declaration:
  ```cpp
  double balance[50];
  ```
  balance is a pointer to `&balance[0]`, which is the address of the first element of the array balance - Thus, the following program fragment assigns p the address of the first element of balance −
  ```cpp
  double *p;
  double balance[10];
  
  p = balance;
  ```
  esentially making `p` the array. It is legal to use array names as constant pointers, and vice versa. Therefore, *(balance + 4) is a legitimate way of accessing the data at balance[4].
  
  Once you store the address of first element in p, you can access array elements using *p, *(p+1), *(p+2) and so on. Lets see an example:
  ```cpp
  ...
  
  int main () {
    int numbers[5] = {4, 1, 19, 2, 52};
    int p*;
    
    p = numbers;
    
    specific_number = *(p + 2);
    
    cout << specific_number << "\n";  // <-- outputs `1`
  
    return 0;
  }
  ```
  
### Passing Arrays to Functions


  
  
  
  
  
  
  
  
  
  
  
  
  
