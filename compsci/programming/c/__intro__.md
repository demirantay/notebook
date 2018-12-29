# C

## Printing

- This is how you write "Hello World!" :
  ```c
  printf("Hello, World!\n");
  ```

- There are many ways to compile your c programs to exes :
  ```bash
  $ clang filename.c              # creates `a.out` exe

  $ clang -o filename filename.c  # creates `filename` exe

  $ make filename                 # creates `filename` exe
  ```
  *Note: Most of the C programmers use the `gcc` compiler if you want to use it simply change clang to gcc`
  In order to run them you can simply use:
  ```bash
  $ ./filename
  ```

- Every C program should have a `main` function as its entry point to the program you can simpy write it as:
  ```c
  #include <stdio.h>

  int main(void) {
    printf("Hello, World!\n");
    return 0;
  }
  ```

- You can define variables with their types as their prefix. For example if you would like to define a integer you need to define `int` as the prefix:
  ```c
  int foo = 12;
  long int foo = 12;   // has more bits
  float foo = 3.145;
  double foo = 3.145;  // has more bits

  char foo = 'y';      // single chars get single quotes
  char[] foo = "foo";  // multiple chars get multiple quotes
                       // strings are arrays of characters
  ```
  If you want to use your variables in a string while printing you shold use `%*` method for putting variables into strings:
  ```c
  int foo = 12;
  printf("foo is : %d", foo);
  ```
  There are many `%*` signs for many data types most commonly used are the following:
  - %d - int (same as %i)
  - %ld - long int (same as %li)
  - %f - float (you can use %.2f if you want to see 2 the floating points after the decimal)
  - %lf - double[1]
  - %c - char
  - %s - string
  - %x - hexadecimal
  
- You can define constants as follows:
  ```c
  #define PI 3.14
  ```
  `#define` is a preprocessing directive, just as `#include`  so there is no semicolon at the end
  Note: If you are using a "float" type as a constant use like this `#define PI = 3.14f` the `f` at the end is just a better way of writing but you do not have to.

## User Input

- You can get input from the user with `scanf(%*)`. You need to specify what data type you want to get and you will assign them to the variable with the `&*` sign (this is about pointers not covered yet just go along with it) (you can use `fgets(input)` too but I have never tried it):
  ```c
  int foo;

  printf("Type a number: ");
  scanf("%d", &foo);

  printf("Foo: %d \n", foo);  // prints the value of foo
  ```

- Remember you can put more than one input on a single scacnf line look at the following snippet:
  ```c
  int foo, bar, baz;
  printf("Type foo, bar, baz\n");
  
  scanf("%d%d%d", &foo, &bar, &baz); // <-- see this line over here
  ```

## Selection Statements

- While using C's selection statements you cannot expect to use the "true" and "false" structures that comes shipped with other higher languages. In C there is no true or false there is only 1 and 0. If the values you compare are "true" then it is `1` and if the values that you are comparing are false than the final value is `0`. Lets view the following:
  ```c
  if (10 < 5) {
    // this is `false` == `0` thats why it doesnt get executed
  }
  
  if (10 > 5) {
    // this is `true` == `1` thats why the code gets executed
  }
  ```
  You can simply get around this by including `#inlcude <stdbool.h>` which gives you a boolean type like this : `bool foo = true` . Or if you do not want to include a library you can very simply create the same functionality with the `typedef` keyword see the following code:
  ```c
  #define true 1;
  #define false 0;
  typedef int bool;
  
  /* And you can craete boolean values like this */
  
  bool foo = true;
  ```

- The control selection statemetns are written simply like this in the c :
  ```c
  n = 0;
  
  if ( n < 0 ) { 
    printf("n is less than zero \n");
  }
  else if (n == 0 ) {
    printf("n is equal to zero \n");
  }
  else {
    printf("n is greater than zero \n");
  }
  ```
  
- I know that switch statements are not that cool but here is how it can be used ( do not forget to use `break`s in switches beacuse omitting one can cause bugs in your code:
  ```c
  // lets first write the code in normal if satements and then evolve it into switch
  if (grade == 4){ 
    printf("good\n");
  } 
  else if (grade == 3) {
    printf("normal\n");
  }
  else if (grade ==2) {
    printf("failing\n");
  }
  else {
    printf("illegal grade\n");
  }
  ```
  Lets now convert the code above into a switch statement code:
  ```c
  switch (grade) {
    case 4: printf("good\n");
            break;
    case 3: printf("normal\n");
            break;
    case 2: printf("failing\n");
            break;
    default: printf("illegal grade\n");
             break;
  }
  
  // you can also write cases like this
  switch (grade) {
    case 1: case 2: case 3:
            printf("foo");
            break;
    default:
            printf("baz");
            break;
  }
  ```

## Loops

- Writing loops are farily easy in the C like any other language. First lets see how to write a "while" loop. The code snippet below shows 10 "foo" text with a line break:
  ```c
  int i = 10;
  
  while (i > 0) {
    printf("foo\n");
    i--;
  }
  ```

- You can write "do while" loops in the c like this way we will use the snippet bove and convert it to a do while:
  ```c
  int i = 10;
  do {
    printf("foo\n");
    i--;
  } while (i < 10 );
  ```

- And for the last loop that we can write in c is a "for" loop no explanation is needed best loop out there (remember you can use for loops for a lot of things other than iterating. Even before C99 developers used for loops more than while loops in order to create infinte loops. However, it is not the case anymore the rule of thumb is to use for loops for iteration and while for infinte loops):
  ```c
  for (int i = 10; i > 0; i--){
    printf("foo\n");
  }
  ```

- There are 3 ways to exit from a loop in the C and these are the keywords: "break", "goto", "continue", lets view each of them:
  - `break`   : It simply breaks out of the loop and starts reading the next line of code.
  - `continue`: While break terminates the loop, continue does not end the loop it simply skips to the next loop iteration and remain inside the loop. Cannot be used with Switch statments. 
  - `goto`    : You do not need goto for every day C programming check docs for info.
  
- Dont dorget the `None` keyword in python is == to `null` in the C
  
## Basic Types

- Watch out for integer flowss if you try to enter more bits than the integer type can have the output will be undefined and can cause serious problems. For example old boeing 77 planes had a integer overflow problem that nearly crashed the whole plane. Always watch out! For example, **if we add 1 to the unsigned 16-bit number 65.535, the result is guranteed to be 0**

- There are special characters that are built into c that have special uses such as the `\n` new line key word. These keywords are called "Escape Sequences". Most of the common day to day special cases are the following : Alert Bell (\a) , Backspace (\b) , Form feed (\f) , New Line (\n) , Carriage return (\r) , Horizontal tab (\t) , Vertical tab (\v) , Backslash(\\) , Question Mark (\?) , Single quote (\') , Double Quote (\")

- The following example shows the usual arithmetic conversion in action and shows the order of type conversions:
  ```c
  char c;
  sohrt int s;
  int i;
  long int l;
  float f;
  double d;
  long double ld;
  
  i = i + c;     /* c is converted to int           */
  i = i + s;     /* s is converted to int           */
  l = l + i;     /* i is converted to long int      */
  f = f + l;     /* l is converted to float         */
  d = d + f;     /* f is converted to double        */
  ld = d + ld;   /* d is converted to long double   */
  ```
  As you can see the order of types are like this: char < int < long int < float < double < long double
  
- You can also cast (force change) one type to another such as the following way : (This gives you a greater contorl over your types however be catious while using it)
  ```c
  float foo = 10.99;
  float bar = 20.89;
  float sum;
  
  sum = foo - (int) bar;  /* bar is converted to int */
  ```
  
- You can define your own types with `typedef` keyword it is actually very easy. See the following:
  ```c
  typdef int Foo;   
  
  Foo n = 10;     /* n is now a integer */
  ```
  It is a good habit to capitliaze the first letter of your types since it is easier to understand. You may ask why the hell would you use it since you can simply use the normal primitive C types. So, type definitions of your own can make a program more understandable assuming that the programmer has been careful while choosing a meaningful type names. See the following for a better example typedef's:
   ```c
   typedef float Dollars;
   
   Dollars cash_in, cash_out;  // this is not neccessary but a lot more foramative and readale
   ```
   Type definitions can also make a program easier to modify. If we later decide that dollars should really be defined as double all we need to do is chage the type definition to `typedef doble Dollars;`

## Arrays

- To declare an array in c you have to specify its type and number of elements. Lets see:
  ```c
  int foo[10];  // array `foo` has 10 undefined elements in it
  ```
  C compilers do not show a warning message about your arrays it is not like in a high level easy language. You have to be percise about your array lengths.
  
- The most common form of array intialization is a list of constant expressions enclosed in braces such as like this:
  ```c
  int foo[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
  ```
  Also do not forhet that if the initilizaer in the brackets is shorter than the array the reamining elements of the array are given the value 0. See the following:
  ```c
  int foo[3] = {99}   /* the array is {99, 0, 0} */
  ```
  
- You can also go out of the common initlization and make shit like the following: 
  ```c
  int foo[4] = {[2] = 29, [4] = 7};  /* the array is {0, 29, 0, 7} */
  ```
- An array may have any number of dimensions. For example the following declaration creates a two-dimensional array:
  ```c
  int foo[5][10]; /* this array `foo` has 5 arrays that contain 10 elements */
  ```
  Do note that multidimensional arrays play a lesser role in C tha in many other programming languages, primarily because C provides a more flexible way to store multi dimensional data: array of pointers
  
- You can make a "constant" array with the following keyword `const`. An array thats has been declared constant should not be modified:
  ```c
  const int foo[4] = {1, 2, 3, 4}; 
  ```

## Methods / Functions

- This is how you define a function (some languages call functions with return values `procedures` such as lisp but in c you can simply call them functions or methods) :
  ```c
  int average (int a, int b) {
    return (a + b) / 2;
  }
  ```
  As you can see it is kinda the same with java lang you write the `type` that you want the function to return at the begining which is in this case a integer `int` and than you write the name of the function with the following parameters inside the parantheses. If you dont want the function to return a value simply put `void` on the type keyword part and leave out the "return". See the following for writing void funcs:
   ```c
   void foo() {
    // ...
    // no return
   }
   ```
 
- Remember functions **MAY NOT** return arrays, however it is very commonly and easily used to pass an array as a parameter (argument) to a function.

- When you define functions below your main function it causes a lot of errors since the program has no way of knowing what the definition is inside the function. So if you declare a function after the main function you can simply include the header of the function before the main function, so if the function is used in the main it would know where to look:
  ```c
  void foo(int a);   // <-- see how it is declared at top but defined after main
  
  int main(void) {
    int n = foo(); 
  }
  
  int foo(int a) {
    return a;
  }
  ```

- Arrays are often used as arguments. When a function parameter is a one-dimensional array, the length of the paramter array is unspecified. There is just one problem how will the function know how long the array is. Unfortunately C doesnt provide any easy way for a function to determine the length of an array passed to it. Instead we will have to supply the length in a additional argument. See the following:
  ```c
  int foo (int arr[], int length) {
    int arr[length];  // < -- here you have a new array
  }
  
  // Or you can do this if you pass the length before the array in the parameter parantheses:
  
  int foo (int length, int arr[length]) {
    ...
  }
  ```
  Do note that if the array is defined erlier you should not put the bracekts while passing it as a argument: `foo(pre_defined_arr, 10)`
  
- There is a quickway to return values without having to use ifs but this is not very commonly used, see the following:
  ```c
  return n >= 0 ? n : 0;
  ```
  In the exapmle return statement above first the return checks if n is a positive number if it is it returns it, otherwise it returns 0 its that simple but not this convenient every time you are programming.
  
  
- I will not get into recrusion a lot right now because i will note a lot of it in the algorithm notes however the idea behind it is veeeery simple. A function is recursive if it calls itself in it. See the following:
  ```c
  int foo (int number) {
    if (number > 0) { 
      foo(number - 1);   // <--- see it calls itself in it with a different parameter each time
    }
    else {
      return 0;
    }
  }
  ```
  Recrusion is not that handy to use if you are not dealing with complex algorithm stcutrues like quickosrt where the recrusion arises itself from the design of the algortihm. However for the most part using a if block is a better solution than recrusion. Do not make your code unneccesarily complex
  

## Program Organization

- If you want to define global variables in C you can simply define them out of any function blocks. This includes the main function also:
  ```c
  #include <stdio.h>
  
  /* Global Variables */
  int foo = 7;
  
  /* Functions */
  int main(void) {..}
  ```
  External variables (global) are very convenient when many functions need to share a variables. However in most cases it is better for functions to comminucate through parameters and local variables rather than global variables. Because one varible mistake can crush or create a devastating bug in the program and we do not want that.
  
- Plus you can use the `static` keyword while defining either variables or functions. It has two use cases 1st by stacoverflow definition "A static variable inside a function keeps its value between invocations". However we will use the 2nd definition: A static global variable or a function is "seen" only in the file it's declared in. (2) Is used widely as an "access control" feature. If you have a .c file implementing some functionality, it usually exposes only a few "public" functions to users. The rest of its functions should be made static, so that the user won't be able to access them. This is encapsulation, a good practice.
  
- Now that we ve seen the major elements that make up a C program lets develop a strategy for arranging our programs in a file. I will discuss about a multi modular filed program down below in a more advanced part this is just for a tase: The code below represents tg=he most commonly way of ordering your program:
  ```
  /* Comment About the program its intentions, 
     author, links, documentation ...etc. */
  #include directives
  #define directives
  type definitions
  Declerations of external variables
  Prototypes for functions other than main
  Definitions of main
  Definitions of other functions
  ```
  Side Note: Most of the C programmers use a boxed comments before each function to explain what each one does it comes very handy!
  

## Pointers

- Pointers are one of the C's most important topic so we will be discussing them in three different headers over the course of this markdown file.

- In modern day computers main memory is divided into bytes. and each byte contains 8 bits. Each byte has a unique adress to distinguish it from the other bytes in the memory. Heres where pointers come in instead of remembering all that integer numbers in a adress number you can simply store them in a special **pointer number**. For example, when we store the adress of a variable `i` in the pointer variable `p`, we say `p` points to `i`. In other words pointers are nothing more than a variable taht stores an adress of a variable.

- You can define a pointer the same way you define a variable just with an addition of an asterisk:
  ```c
  int *p;
  ```
  Pointer declerations can appear in other definitions alongside normal variables:
  ```c
  int i, j, a[10], *p, *u;
  ```
  
- You need to define what type of adress the pointer will point to so as the same way with other objects you need to have types:
  ```c
  int *p;
  double *q;
  char *r;
  ```
  
- C provides specific operators to use with pointers. To find the adress of a variable we use the `&` (Adress) operator. If "x" is a variable than "&x" is the adress of "x" in memory. And to gain accsess to the object that a pointer points to we use the `*` (indirection) operator. If "p" is a pointer, then `*p` represents the object to which "p" currently ppoints.

- We need to actually point to something so lets view the followin code:
  ```c
  int i = 10;
  
  int p = &i;   // --> now p holds the adress of i
  ```

- If you want to get the object that pointer points to you need to use the indirectio n(`*`) asterisk operator, otherwise you will get the memory adress:
  ```c
  int i = 10;
  int *p = &i;
  
  printf("%d", *p);    /* prints 10  */
  printf("%d", p);     /* prints the adress in memory e.g. 149204 */
  ```
  
- By the way you can have two pointers assigned to the same objects adress such as the following:
  ```c
  int i, *p, *j;
  
  p = &i;  // points to same obj
  
  j = p;   // points to same obj
  ```

## Pointers and Arrays

- foo

## Strings

- foo

## The Preprocessor

- foo

## Writing Large Programs

- foo

## Structures, Unions and Enumarations

-foo

## Advanced uses of Pointers

- foo

## Declaration

- foo

## Program Design

- foo

## Low level programming

- foo
