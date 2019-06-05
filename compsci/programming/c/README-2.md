### [Part 1](./README.md)

---

## Structures

- Arrays allow to define type of variables that can hold several data items of the same kind. Similarly structure is another user defined data type available in C that allows to combine data items of different kinds. (like `dict` in python)

- Lets see how you can define a structure :
  ```c
  struct Books {
    char title[50];
    char author[50];
    char subject[100];
    int book_id;
  };
  ```
  To access any member of a structure, we use the member access operator (.). The member access operator is coded as a period between the structure variable name and the structure member that we wish to access. Lets try to acsess the structure we defined above:
  ```c
  #include <stdio.h>
  #include <string.h>
  
  struct Books {
    ...
  };
  
  int main() {
    
    struct Book foo;  // <-- book struct decleration
  
    /* Struct 1 specification */
    strcpy(foo.title, "Macbeth");
    strcpy(foo.author, "Shakespeare");
    strcpy(foo.subject, "Novel");
    foo.book_id = 123;
    
    /* Acsessing values */
    printf("%s", foo.title);
  
    return 0;
  }
  ```

- You can pass any structure to any function the same way you pass other variable types:
  ```c
  void function_name (struct Books book) {...}
  ```
  
- You can define pointers to structures in the same way as you define pointer to any other variable −
  ```c
  struct Books *pointer;
  
  pointer = &struct_instance;
  ```
  To access the members of a structure using a pointer to that structure, you must use the `→` operator as follows −
  ```c
  pointer->title;
  ```
  
<br>
<br>
<br>

## Unions

- A union is a special data type available in C that allows to store different data types in the same memory location. You can define a union with many members, but only one member can contain a value at any given time. 

- To define a union, you must use the union statement in the same way as you did while defining a structure. The denifition of unions are very similar to structures:
  ```c
    union Data {
     int i;
     float f;
     char str[20];
  };
  ```
  Now, a variable of `Data` type can store an integer, a floating-point number, or a string of characters. It means a single variable, i.e., same memory location, can be used to store multiple types of data. You can use any built-in or user defined data types inside a union based on your requirement.
  
- To access any member of a union, we use the `member access operator (.)` Lets try to acsess the union defined above:
  ```c
  #include <stdio.h>
  #include <string.h>
  
  union Data { ... }
  
  int main() {
    
    union Data foo;
    
    foo.i = 10;
    data.f = 220.5;
    strcpy( data.str, "C Programming");

    printf( "data.i : %d\n", data.i);
    printf( "data.f : %f\n", data.f);
    printf( "data.str : %s\n", data.str);
    
    return 0;
  }
  ```
  When the above code is compiled and executed, it produces the following result −
  ```
  data.i : 1917853763
  data.f : 4122360580327794860452759994368.000000
  data.str : C Programming
  ```
  Here, we can see that the values of `i` and `f` members of union got corrupted because the final value assigned to the variable has occupied the memory location and this is the reason that the value of `str` member is getting printed very well.
  
<br>
<br>
<br>

## Bit Fields

- I am not going to note too much about bit fields at the moment. IF you want to you can revisit: https://www.tutorialspoint.com/cprogramming/c_bit_fields.htm this link for more information.

- Basically bit fields are used to declare how much bytes are given to a particular variable in order to save some space in the memory. Lets see an example stucture:
  ```c
  struct Foo {
   unsigned int age : 3;  /* the last 3 is the allowed byte size */
  }
  ```
  
<br>
<br>
<br>

## Typedef

- The C programming language provides a keyword called typedef, which you can use to give a type a new name. And after giving it a new name we can declare variabes with its new name. Lets see an exmaple:
  ```c
  typedef int Bool;
  
  Bool true = 1;
  Bool false = 0;
  ```
  its case sensetive so `Bool` and `bool` is not same.
  
### Typedef VS #define

- `#define` is a C-directive which is also used to define the aliases for various data types similar to `typedef` but with the following differences −
  - `typedef` is limited to giving symbolic names to types only where as `#define` can be used to define alias for values as well, q., you can define 1 as ONE etc.
   ```c
   typedef int bool;
   bool true = 1;
   
   // is equal to
   
   #define TRUE 1
   ```

<br>
<br>
<br>

## Input and Output

- There are maany ways to get an input and give an output in C programming language. Lets see each one and their usage.

### fgets() and outs()

- In the standart library you can use `gets()` and `puts()` function to get an input and output one. Note: `gets` function is now deprecated in the standart library, the functions name is `fgets` now:
  ```c
  #include <stdio.h>
  int main() {
    
    char foo[100];
    
    printf("Your input: ");
    fgets( foo );
    
    printf("Your output: ");
    outs( foo );
    
    return 0;
  }
  ```
  
### printf() and scanf()

- These functions are the most used built in input and output functions because there are lots of options for formatiing. The format can be a simple  string, but you can specify %s, %d, %c, %f, etc., to print or read strings, integer, character or float respectively. There are many other formatting options available which can be used based on requirements.

- Scanf uses memory adresess to `&` to assign values its gets from the keyboard to the targeted variables. Lets see an example:
  ```c
  int main() {
    
    int foo, baz;
    
    printf("Enter your values: ");
    scanf("%d %d", &foo, &baz);
    
    pritnf("Your values are %d and %d", foo, baz);
    
    return 0;
  }
  ```
  
<br>
<br>
<br>

## File I/O

- The last chapter explained the standard input and output devices handled by C programming language. This chapter cover how C programmers can create, open, close text or binary files for their data storage. A file represents a sequence of bytes, regardless of it being a text file or a binary file. C programming language provides access on high level functions as well as low level (OS level) calls to handle file on your storage devices. 

### Opening a file

- You can use the `fopen( )` function to create a new file or to open an existing file. This call will initialize an object of the type `FILE`, which contains all the information necessary to control the stream. The prototype of this function call is as follows −
  ```
  FILE *fopen( const char * filename, const char * mode );
  ```
  Here, `filename` is a string literal, which you will use to name your file, and access `mode` can have one of the following values −
  - `r`  : Opens an existing text file for reading purpose.
  - `w`  : Opens a text file for writing. If it does not exist, then a new file is created.
  - `a`  : Opens a text file for writing in appending mode. If it does not exist, then a new file is created. 
  - `r+` : Opens a text file for both reading and writing.
  - `w+` : Opens a text file for both reading and writing. It first truncates the file to zero length if it exists, otherwise creates a file if it does not exist.
  - `a+` : Opens a text file for both reading and writing. It creates the file if it does not exist. The reading will start from the beginning but writing can only be appended.
  
### Closing a file

- To close a file, use the fclose( ) function. The prototype of this function is −
  ```
  int fclose( FILE *fp );
  ```
  The `fclose()` function returns zero on success, or EOF if there is an error in closing the file.

### Writing a file

- Following is the simplest function to write individual characters to a stream −
  ```
  int fputc( int c, FILE *fp );
  ```
  You can use the following functions to write a null-terminated string to a stream −
  ```
  int fputs( const char *s, FILE *fp );
  ```

- Lets see an real example with the code above: (Make sure you have /tmp directory available. If it is not, then before proceeding, you must create this directory on your machine.)
  ```c
  #include <stdio.h>
  
  main() {
     FILE *fp;

     fp = fopen("/tmp/test.txt", "w+");
     fputs("This is testing for fputs...\n", fp);
     fclose(fp);
  }
  ```
  When the above code is compiled and executed, it creates a new file test.txt in /tmp directory and writes two lines using two different functions. Let us read this file in the next section.
  
### Reading a file

- Given below is the simplest function to read a single character from a file −
  ```
  int fgetc( FILE * fp );
  ```
  The following function allows to read a string from a stream −
  ```
  char *fgets( char *buf, int n, FILE *fp );
  ```
  
<br>
<br>
<br>

## Preprocessors

- All preprocessor commands begin with a hash symbol (#). It must be the first nonblank character, and for readability. The following section lists down all the important preprocessor directives −
  - `#define` - Substitutes a preprocessor macro.
  - `#include` - Inserts a particular header from another file.
  - `#undef` - Undefines a preprocessor macro.
  - `#ifdef` - Returns true if this macro is defined.
  - `#ifndef` - Returns true if this macro is not defined.
  - `#if` - Tests if a compile time condition is true.
  - `#else` - The alternative for #if.
  - `#elif` - #else and #if in one statement.
  - `#endif` - Ends preprocessor conditional.
  - `#error` - Prints error message on stderr.
  - `#pragma` -  Issues special commands to the compiler, using a standardized method.
  
- Lets ses some real world examples for the preprecessors above:
  ```c
  #include <stdio.h>
  
  #define FOO 10
  #undef FOO
  
  #ifndef FOO
    #define FOO 200
  #endif
  ```
  
### Pre-defined macros

- ANSI C defines a number of macros. Although each one is available for use in programming, the predefined macros should not be directly modified.
  - `__DATE__` - The current date as a character literal in "MMM DD YYYY" format.
  - `__TIME__` - The current time as a character literal in "HH:MM:SS" format.
  - `__FILE__` - This contains the current filename as a string literal.
  - `__LINE__` - This contains the current line number as a decimal constant.
  - `__STDC__` - Defined as 1 when the compiler complies with the ANSI standard.

- Lets try them in a example:
  ```c
  int main() {
    printf("File :%s\n", __FILE__ );   // <-- prints "foo.c"
  }
  ```
  
- There are MANY more things to learn about preprocessors and macros however the tutorial that I am following is not quite good at explaning it. Self note: study this from a different resoruce:
  - original source: https://www.tutorialspoint.com/cprogramming/c_preprocessors.htm
  
<br>
<br>
<br>

## Header Files

- A header file is a file with extension `.h` which contains C function declarations and macro definitions to be shared between several source files. There are two types of header files: the files that the programmer writes and the files that comes with your compiler.

- You request to use a header file in your program by including it with the C preprocessing directive `#include`, like you have seen inclusion of `stdio.h` header file, which comes along with your compiler.

- Both the user and the system header files are included using the preprocessing directive `#include`. It has the following two forms −
  This form is used for system header files. It searches for a file named 'file' in a standard list of system directories.
  ```c
  #include <file>
  ```
  The form below is used for header files of your own program. It searches for a file named 'file' in the directory containing the current file.
  ```c
  #include "file"
  ```
  
- Lets see an real world example. Our first file is called `foo.h`:
  ```h
  // foo.h
  
  int greeting() {
    printf("Hello\n");
  }
  ```
  And this is our main.c file:
  ```c
  // main.c
  
  #include <stdio.h>
  
  #include "foo.h"
  
  int main() {
    greeting();   // outputs "hello"
  }
  ```
  
<br>
<br>
<br>

## Type Casting

- Type casting is a way to convert a variable from one data type to another data type. For example, if you want to store a 'long' value into a simple integer then you can type cast 'long' to 'int'. You can convert the values from one type to another explicitly using the cast operator as follows −
  ```
  (type_name) expression
  ```
  Lets see a real world example:
  ```c
  int a = 10, b = 20;
  double sum;
  
  sum = (double) a + b;
  ```
  See we convert the two intergers into a one double
  
<br>
<br>
<br>

## Error Handling 

- As such, C programming does not provide direct support for error handling but being a system programming language, it provides you access at lower level in the form of return values. Most of the C or even Unix function calls return -1 or NULL in case of any error and set an error code `errno`. It is set as a global variable and indicates an error occurred during any function call. You can find various error codes defined in `<error.h>` header file.

### errno, perror(), strerror()

- The C programming language provides `perror()` and `strerror()` functions which can be used to display the text message associated with `errno`.
  - `perror()` -  function displays the string you pass to it, followed by a colon, a space, and then the textual representation of the current errno value.
  - `strerror()` -  function, which returns a pointer to the textual representation of the current errno value
  
- There are more to learn about error handling in C the original tutorial that I am following is not that great. Future note: find a better resoruce and study again:
  - original source: https://www.tutorialspoint.com/cprogramming/c_error_handling.htm
  - new source : null
  
<br>
<br>
<br>

## Recursion

- I do not know why recursion a algorithm concept is inside a C tutorial however it is basically a function caling itself in its definition, lets see a more prooper description: Recursion is the process of repeating items in a self-similar way. In programming languages, if a program allows you to call a function inside the same function, then it is called a recursive call of the function.
  ```c
  void foo() {
    foo()   // function calls itself 
  }
  ```
  But while using recursion, programmers need to be careful to define an exit condition from the function, otherwise it will go into an infinite loop.
  Recursive functions are very useful to solve many mathematical problems, such as calculating the factorial of a number, generating Fibonacci series, etc.
  
<br>
<br>
<br>

## Variable Arguments 

- Sometimes, you may come across a situation, when you want to have a function, which can take variable number of arguments, i.e., parameters, instead of predefined number of parameters. The C programming language provides a solution for this. Lets see an example:
  ```c
  int func(int, ... ) {
     .
     .
     .
  }

  int main() {
     func(1, 2, 3);
     func(1, 2, 3, 4);
  }
  ```
  It should be noted that the function `func()` has its last argument as ellipses, i.e. three dotes (...) and the one just before the ellipses is always an `int` which will represent the total number variable arguments passed. To use such functionality, you need to make use of `stdarg.h` header file which provides the functions and macros to implement the functionality of variable arguments and follow the given steps −
    - Define a function with its last parameter as ellipses and the one just before the ellipses is always an `int` which will represent the number of arguments.
    - Create a `va_list` type variable in the function definition. This type is defined in stdarg.h header file.
    - Use `int` parameter and `va_start` macro to initialize the `va_list` variable to an argument list. The macro va_start is defined in stdarg.h header file.
    - Use `va_arg` macro and `va_list` variable to access each item in argument list.
    - Use a macro `va_end` to clean up the memory assigned to `va_list` variable.

- Now lets see a rea world example that shows what we have explained above:
  ```c
  #include <stdio.h>
  #include <stdarg.h>

  double average(int num,...) {

     va_list valist;
     double sum = 0.0;
     int i;

     /* initialize valist for num number of arguments */
     va_start(valist, num);

     /* access all the arguments assigned to valist */
     for (i = 0; i < num; i++) {
        sum += va_arg(valist, int);
     }

     /* clean memory reserved for valist */
     va_end(valist);

     return sum/num;
  }
  
  int main() {
     printf("Average of 2, 3, 4, 5 = %f\n", average(4, 2,3,4,5));  // look it is allowed for 4 arguments
     printf("Average of 5, 10, 15 = %f\n", average(3, 5,10,15));   // look it is allowed for 3 arguments
  }
  ``
  
<br>
<br>
<br>

## Memory Management 

- . The C programming language provides several functions for memory allocation and management. These functions can be found in the `<stdlib.h>` header file.

  - `void *calloc(int num, int size);` - This function allocates an array of `num` elements each of which size in bytes will be `size`.
  
  - `void free(void *address);` - This function releases a block of memory block specified by address.

  - `void *malloc(int num);` - This function allocates an array of num bytes and leave them uninitialized.
  
  - `void *realloc(void *address, int newsize);` - This function re-allocates memory extending it upto newsize.

### Allocating Memory Dynamically

- While programming, if you are aware of the size of an array, then it is easy and you can define it as an array. For example, to store a name of any person, it can go up to a maximum of 100 characters, so you can define something as follows −
  ```c
  char name[100];
  ```
  But now let us consider a situation where you have no idea about the length of the text you need to store, for example, you want to store a detailed description about a topic. Here we need to define a pointer to character without defining how much memory is required and later, based on requirement, we can allocate memory
  
- MEMORY MANAGEMENT IS A VERY IMPORTANT TOPIC IN C. THE TUTORIAL DOES NOT TEACH IT VERY WELL. FUTURE NOTE: FIND A BETTER RESORUCE AND RESTUDY IT

<br>
<br>
<br>

## Command Line Arguments

- It is possible to pass some values from the command line to your C programs when they are executed. These values are called command line arguments and many times they are important for your program especially when you want to control your program from outside instead of hard coding those values inside the code.

- The command line arguments are handled using main() function arguments where argc refers to the number of arguments passed, and argv[] is a pointer array which points to each argument passed to the program. Following is a simple example which checks if there is any argument supplied from the command line and take action accordingly. Lets see an example:
  ```c
  #include <stdio.h>

  int main( int argc, char *argv[] )  {
  
     printf("Program name %s\n", argv[0]);

     if( argc == 2 ) {
        printf("The argument supplied is %s\n", argv[1]);
     }
     else if( argc > 2 ) {
        printf("Too many arguments supplied.\n");
     }
     else {
        printf("One argument expected.\n");
     }
  }
  ```
  It should be noted that argv[0] holds the name of the program itself and argv[1] is a pointer to the first command line argument supplied, and *argv[n] is the last argument. If no arguments are supplied, argc will be one, and if you pass one argument then argc is set at 2.
  
- You pass all the command line arguments separated by a space, but if argument itself has a space then you can pass such arguments by putting them inside double quotes "" or single quotes ''. Let us re-write above example once again where we will print program name and we also pass a command line argument by putting inside double quotes:
  ```
  $ /a.out "this is just one argument"
  ```
  
  
  
  
  

