# C

- C is a general-purpose, high-level language that was originally developed by Dennis M. Ritchie to develop the UNIX operating system at Bell Labs. C was originally first implemented on the DEC PDP-11 computer in 1972.

- The UNIX operating system, the C compiler, and essentially all UNIX application programs have been written in C. C has now become a widely used professional language for various reasons −

- C was initially used for system development work, particularly the programs that make-up the operating system. C was adopted as a system development language because it produces code that runs nearly as fast as the code written in assembly language. Some examples of the use of C might be − `operating systems`, `language compilers`, `assemblers`, `text editors`, `network drivers`, `databases` ... etc.


  
<br>
<br>
<br>

## Basics

- Lets see a basic Hello, World program for the start:
  ```c
  #include <stdio.h>
  
  int main() {
    /* first program */
    printf("Hello World");
    
    return 0;
  }
  ```
  - The first line of the program #include <stdio.h> is a preprocessor command, which tells a C compiler to include stdio.h file before going to actual compilation.
  - The next line int main() is the main function where the program execution begins.
  - The next line printf(...) is another function available in C which causes the message "Hello, World!" to be displayed on the screen.
  - The next line return 0; terminates the main() function and returns the value 0.
  
- The source files for C programs are typically named with the extension "`.c`".
  
- To compile your C code you use GNU's gcc compiler:
  ```
  $ gcc foo.c
  ```
  and run the output file with this:
  ```
  $ ./a.out
  ```
  You can use the `-o` for giving a name to your execution file instead of a `a.out`
  ```
  $ gcc foo.c -o newname
  ```
  You can also use the `make` instead of a gcc which will automatically name the exec file with the name of your .c file

<br>
<br>
<br>

## Variables

- I am not going to what variables are or what is the logic behind it since I have written them too many times in differnt programming language files. So here is the variable types and how do you write them in C:
  ```c
  int i,k = 1;
  char c, ch = "foo";
  float f = 1.0;
  double pi = 3.1415;
  ```
  There are many more types such as arrays, pointers, enumarations, bytes ... etc. However the 4 above are enough for the basics right now.
  
- There are no boolean types built in to the C. So esentially you either use `1` for true and `0` for false. However this becomes irritating and unreadable after a while so you either #include booleans from a library or define them with `typedef` and assign constatns to them:
  ```c
  /* option 1 */
  #include <stdbool.h>
  
  /* option 2 */
  typedef int bool;
  #define true 1
  #define false 0
  
  bool foo = true;
  ```
  
### Constants

- Constnats are immutable variables. There are two simple ways in C to define constants −
  - Using #define preprocessor.
  - Using const keyword.
  
- Given below is the form to use #define preprocessor to define a constant 
  ```
  #define identifier value
  ```
  Now lets look at real world examples:
  ```c
  #define PI 3.14
  #define NEWLINE "\n"
  ```
  
- You can use const prefix to declare constants with a specific type as follows −
  ```
  const type variable = value;
  ```
  Now lets see a real world example:
  ```c
  const int PI = 3.14;
  const int HEIGHT = 100;
  ```
  

<br>
<br>
<br>

## Storage Classes

- A storage class defines the scope (visibility) and life-time of variables and/or functions within a C Program. They precede the type that they modify. We have four different storage classes in a C program −
  - auto
  - register
  - static
  - extern
  
### auto

- The auto storage class is the default storage class for all local variables.
  ```c
  {
    int a = 10;
    auto int a = 10; 
  }
  ```
  Both are same. The example above defines two variables with in the same storage class. 'auto' can only be used within functions, i.e., local variables.
  
### register

- The register storage class is used to define local variables that should be stored in a register instead of RAM. This means that the variable has a maximum size equal to the register size (usually one word) and can't have the unary '&' operator applied to it (as it does not have a memory location)
  ```c
  {
   register int  miles;
  }
  ```
  The register should only be used for variables that require quick access such as counters. You shouldnt use this storage class if you do not have a sepcific reason to. 
  
### static

- The static storage class instructs the compiler to keep a local variable in existence during the life-time of the program instead of creating and destroying it each time it comes into and goes out of scope. Therefore, making local variables static allows them to maintain their values between function calls.
  ```c
  void func () {
    static int foo = 10;
  }
  
  int main() {
    /*
      you can accsess into the local `foo`
      variable of the function above in here
    */
  }
  ```

### extern

- The extern storage class is used to give a reference of a global variable that is visible to ALL the program files. When you have multiple files and you define a global variable or function, which will also be used in other files, then extern will be used in another file to provide the reference of defined variable or function. The extern modifier is most commonly used when there are two or more files sharing the same global variables or functions as explained below. -
  main.c
  ```c
  #include <stdio.h>
 
  int count ;
  extern void write_extern();

  main() {
     count = 5;
     write_extern();
  }
  ```
  other_file.c
  ```c
  #include <stdio.h>
 
  extern int count;

  void write_extern(void) {
     printf("count is %d\n", count);
  }
  ```
  **Note: I understand that `extern` is esentialy how you import your classes and funcs from one module to another. However I did not understand the C sytnax part of the tutorial self note: return to extern and study from a different source**
  
<br>
<br>
<br>

## Decision Making 

- I am not going to write what are the decision makers in a programming language because I have written the logic part of it too many times in different programming language files. Im just going to note how to write them in C:
  ```c
  int a = 10;
  
  if (a == 0) {
    ...
  } else if (a == 4) {
    ...
  } else if (a == 10) {
    ...
  } else {
    ...
  }
  ```
  I am not going to note down switch since I do not use it very often
  
- The `?:` Operator - can be used to replace if...else statements. It has the following general form −
  ```
  Exp1 ? Exp2 : Exp3;
  ```
  - Exp1 is evaluated. If it is true, then Exp2 is evaluated and becomes the value of the entire ? expression.
  - If Exp1 is false, then Exp3 is evaluated and its value becomes the value of the expression.

<br>
<br>
<br>

### Loops 

- I am not going to write what are the roles of loops in a programming language because I have written the logic part of it too many times in different programming language files. Im just going to note how to write them in C:
  ```c
  /* while loop */
  int a = 10;
  
  while (a < 20) {
    ...    
  }
  
  /* for loop */
  for (int i = 0; i < 10; i++) {
    ...
  }
  
  /* do while loop */
  do {
    ...
  } while ( a < 20);
  ```

- As like any other programming language C has loop control statemetns:
  ```c
  int i = 0;
  
  while (i < 10) {
    
    if (i == 5) {
      continue;
    } 
    else if (i == 9) {
      break;
    }
    
    i++;
  }
  ```
  There is also `goto` control statement however it is not adviced to use it in your code if you do not know what are you doing.
  
<br>
<br>
<br>

## Functions 

- I am not going to write what is the role of the functions in a programming language because I have written the logic part of it too many times in different programming language files. Im just going to note how to write them in C:
  This is how you write a function
  ```c
  int sum (int num1, int num2) {
    result = num1 + num2;
    return result;
  }
  ```
  You need to remember that you need to declare a function on the top of the file in order to let the `main` function know where to look for when the function is called inside the `main`. You can define it later on that is fine.
  ```c
  #include <stdio.h>
  
  // function decleration
  int sum (int num1, int num2);
  
  int main () {
   int a, b = 5;
   
   // function call
   sum(a, b);
   
   return 0;
  }
  
  // function definition
  int sum(int num1, int num2) {
    return num1 + num2;
  }
  ```
  
<br>
<br>
<br>

## Scope Rules

- A scope in any programming is a region of the program where a defined variable can have its existence and beyond that variable it cannot be accessed. There are three places where variables can be declared in C programming language −
  - Inside a function or a block which is called local variables
  - Outside of all functions which is called global variables.
  - In the definition of function parameters which are called formal parameters.
  
- Lets see an example of where we will use them all:
  ```c
  #include <stdio.h>
  
  // global vars
  int a = 10;
  int b = 20;
  
  int main() {
    // local vars
    int a = 100;
    int b = 200;
  }
  ```
  The local variables always take presedence over the global ones so on the code above a is 100 and b is 200.
  
### Global Variables

- Global variables are defined outside a function, usually on top of the program. Global variables hold their values throughout the lifetime of your program and they can be accessed inside any of the functions defined for the program.

### Local Variables

- Variables that are declared inside a function or block are called local variables. They can be used only by statements that are inside that function or block of code. Local variables are not known to functions outside their own. 

### Formal Parameters

- Formal parameters, are treated as local variables with-in a function and they take precedence over global variables. Following is an example − Here is an example:
  ```c
  int foo(int a, int b) {  // <-- these are the formal parameters and treated as locals vars
    ...
  }
  ```

<br>
<br>
<br>

## Arrays

- Arrays are important to C and should need a lot more attention. So be prepeared for a long read

- You declare an array like this:
  ```
  type arrayName [ arraySize ];
  ```
  Lets declare a real world array with a size of 10 elements:
  ```c
  double balance[10];
  ```
   
- You can initialize an array in C either one by one or using a single statement as follows :
  ```c
  double balance[5] = {1000.0, 2.0, 3.4, 7.0, 50.0};
  ```
  The number of values between braces { } cannot be larger than the number of elements that we declare for the array between square brackets [ ].
  
- If you omit the size of the array, an array just big enough to hold the initialization is created. Therefore, if you write:
  ```c
  double balance[] = {1000.0, 2.0, 3.4, 7.0, 50.0, 1.9};
  ```
  This will create an array with the size of 6
  
- You can accsess and change the elements of the array with the index points such as this:
  ```c
  double foo[] = {4, 6, 1, 2};
  
  arr_element = foo[0];  // gives you `4`
  
  foo[2] = 15;           // changes `1` to `15`
  ```

### Multi-dimensional Arrays

- You can define as many dimensions inan array as you want but for now im just going to stick with 2 for this note file. The way you define is this way:
  ```c
  int foo[2][5] = {
    {5, 1, 6, 2, 1},
    {8, 9, 0, 4, 3}
  };
  ```
  The way you accsess to its elemens are like this:
  ```c
  foo[0][1]   // <-- gives you `1`
  ```
  
- **Self Note: There are more things to note about multi dimensional arrays. Return to this from a differenete resource later on**

### Passing Arrays as Function Arguments

- If you want to pass a single-dimension array as an argument in a function, you would have to declare a formal parameter in one of following three ways and all three declaration methods produce similar results because each tells the compiler that an integer pointer is going to be received

- *There are 3 ways to do this, however I am not going to note it at the moment. Self note for the future restudy this later on from a different source*

### Return Array From a Function

- *This part of the documentation is very poorly documented I need to find a better reosurce to read this*


### Pointer to Array

- An array name is a constant pointer to the first element of the array. Therefore, in the declaration −
  ```c
  double balance[50];
  ```
  balance is a pointer to &balance[0], which is the address of the first element of the array balance. Thus, the following program fragment assigns p as the address of the first element of balance −
  ```c
  double *p;
  double balance[10];
  
  p = balance;
  ```
  So therefore your pointer is esentialy your array (it is not a exact expalanation but take it). It is legal to use array names as constant pointers, and vice versa. Therefore, *(balance + 4) is a legitimate way of accessing the data at balance[4]. Once you store the address of the first element in 'p', you can access the array elements using *p, *(p+1), *(p+2) and so on. Lets see an example:
  ```c
  double balance[3] = {4, 6, 9};
  double *p;
  
  p = balance;
  
  *(p + 1) = 2500;  // <-- changes the `6` to `2500`
  ```
  
<br>
<br>
<br>
<br>

## Pointers 

- Pointers are very important to C and should need a lot more attention. So be prepeared for a long read. Pointers in C are easy and fun to learn. Some C programming tasks are performed more easily with pointers, and other tasks, such as dynamic memory allocation, cannot be performed without using pointers. So it becomes necessary to learn pointers to become a perfect C programmer

- As you know, every variable is a memory location and every memory location has its address defined which can be accessed using ampersand (&) operator, which denotes an address in memory. Consider the following example, which prints the address of the variables defined −
  ```c
  int var1;
  char var2[10];
  
  printf("Var 1 memory adress : %x \n", &var1);
  pirntf("Var 2 memory adress : %x \n", &var2);
  ```
  When the above code is compiled and executed, it produces the following result −
  ```
  Address of var1 variable: bff5a400
  Address of var2 variable: bff5a3f6
  ```

### What are Pointers

- A pointer is a variable whose value is the address of another variable, i.e., direct address of the memory location. Like any variable or constant, you must declare a pointer before using it to store any variable address. The general form of a pointer variable declaration is −
  ```
  type *var-name;
  ``` 
  Here, type is the pointer's base type; it must be a valid C data type and var-name is the name of the pointer variable. The asterisk * used to declare a pointer is the same asterisk used for multiplication. However, in this statement the asterisk is being used to designate a variable as a pointer. Take a look:
  ```c
  int    *ip;    /* pointer to an integer */
  double *dp;    /* pointer to a double */
  float  *fp;    /* pointer to a float */
  char   *ch     /* pointer to a character */
  ```
  
### How to Use Pointers 

- There are a few important operations, which we will do with the help of pointers very frequently. (a) We define a pointer variable, (b) assign the address of a variable to a pointer and (c) finally access the value at the address available in the pointer variable. This is done by using unary operator `*`.  that returns the value of the variable located at the address specified by its operand. Because using `&` this will give you the adress in memory not the object itself. for that we need the asterisk. Lets see an exmaple:
  ```c
  int foo = 10;
  int *p;
  
  p = &foo;
  
  /* Adress */
  printf("This is the adress of foo: %x \n", p);
  
  /* Value */
  printf("This is the value of the adress: %d \n", *p);
  ```
 
### Null Pointers

- It is always a good practice to assign a NULL value to a pointer variable in case you do not have an exact address to be assigned. This is done at the time of variable declaration. A pointer that is assigned NULL is called a null pointer.

- The NULL pointer is a constant with a value of zero defined in several standard libraries. Consider the following program:
  ```c
  int *foo;         // bad practice
  
  int *baz = Null   // good practice
  ```

### Pointer Arithmetic

- A pointer in c is an address, which is a numeric value. Therefore, you can perform arithmetic operations on a pointer just as you can on a numeric value. There are four arithmetic operators that can be used on pointers: ++, --, +, and -
  
- To understand pointer arithmetic, let us consider that ptr is an integer pointer which points to the address 1000. Assuming 32-bit integers, let us perform the following arithmetic operation on the pointer
  ```
  ptr++
  ```
  After the above operation, the ptr will point to the location 1004 because each time ptr is incremented, it will point to the next integer location which is 4 bytes next to the current location. This operation will move the pointer to the next memory location without impacting the actual value at the memory location. If ptr points to a character whose address is 1000, then the above operation will point to the location 1001 because the next character will be available at 1001
  
- As you can see in the explanation above you can also `--` decrement a pointer adress which will reduce 4 points if the var is 32 bytes. You can also `+` add and `-` subtract whatever amount to have an adress from your memory adress. 

- You can also compare pointers with `>=`, `==` ... etc.

- *I need to re-study this part because this part of the tutorial is poorly documented. Self note: study this again with a better resource*. 
  - original source: https://www.tutorialspoint.com/cprogramming/c_pointer_arithmetic.htm
  - new source : NA at the moment
  
### Array of Pointers 

- You can create an array of pointers just like any other variable:
  ```
  int *p_nums[10];
  int foo = 10;
  
  *p_nums[0] = &foo;
  ```
  
- I did not want to note too much about this part of pointers if you want check other resources to learn about creating an array of pointers

### Pointer to Pointer

- A pointer to a pointer is a form of multiple indirection, or a chain of pointers. Normally, a pointer contains the address of a variable. When we define a pointer to a pointer, the first pointer contains the address of the second pointer, which points to the location that contains the actual value 

- A variable that is a pointer to a pointer must be declared as such. This is done by placing an additional asterisk in front of its name. For example, the following declaration declares a pointer to a pointer of type int −
  ```c
  int **p;
  ```
  
- When a target value is indirectly pointed to by a pointer to a pointer, accessing that value requires that the asterisk operator be applied twice, as is shown below in the example −
  ```c
  int foo = 10;
  int *p;
  int **ptp;
  
  p = &foo;
  
  /* assing pointer to pointer */
  ptp = &p;
  
  /* normal pointer value accsess */
  printf("%d", *p);
  
  /* pointer to pointer value acsess */
  printf("&d", **ptp);
  ```
  
### Passing and Returning Pointers to Functions

- You can pass pointers as parameters to a function or return them this is commonly used for using arrays with functions however the original tutorial that I am following is doing a terrible job explaning this concept so: self note - re study this from a different source in the future:
  - original source: [first](https://www.tutorialspoint.com/cprogramming/c_passing_pointers_to_functions.htm), [second](https://www.tutorialspoint.com/cprogramming/c_return_pointer_from_functions.htm)

<br>
<br>
<br>
<br>

## Strings

- Strings are actually one-dimensional array of characters terminated by a null character '\0'. The following declaration and initialization create a string consisting of the word "Hello". To hold the null character at the end of the array, the size of the character array containing the string is one more than the number of characters in the word "Hello." :
  ```
  char greeting[6] = {'h', 'e', 'l', 'l', 'o', '\0'};
  ```
  If you follow the rule of array initialization then you can write the above statement as follows −
  ```
  char greeting[] = "hello";
  ```
  which lets you work easily without having to count every goddamn char in a string while programming. Actually, you do not place the null character at the end of a string constant. The C compiler automatically places the '\0' at the end of the string when it initializes the array.
  
- C supports a wide range of functions that manipulate null-terminated strings-
  - `strycpy(s1, s2);` - Copies string s2 into string s1.
  - `strcat(s1, s2);` - Concatenates string s2 onto the end of string s1.
  - `strlen(s1);` - Returns the length of string s1.
  - `strcmp(s1, s2);` - Returns 0 if s1 and s2 are the same; less than 0 if s1<s2; greater than 0 if s1>s2.
  - `strchr(s1, ch);` - Returns a pointer to the first occurrence of character ch in string s1.
  - `strstr(s1, s2);` - Returns a pointer to the first occurrence of string s2 in string s1.

<br>
<br>
<br>

## Structures







