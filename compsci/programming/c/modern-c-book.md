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
  short int s;
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

## Methods

- foo


## Program Organization

- foo

## Pointers

- foo

## Pointers and Arrays

- In the previous chapter we introduced pointers and how to write them. In this section we will use its practical approach to objects. **Remember Understanding the Connection Between Pointers and Arrays is Critical for Mastering C lang**.

- We can easily point pointers to arrays or its elements see:
    ```c
    int arr[10], *p;

    // "p" points to "arr" first element
    p = &arr[0];
    ```
    We can now acsess "arr[0]" thorugh "p". For example lets store 5 in "arr[0]" by writing:
    ```c
    *p = 5;    // this makes  a[0] == 5
    ```

- Making the pointer point to an element of an array isnt exiting news however this functionality gives us a chance to perform `Pointer Arithmetic` to an array. In C there are only 3 allowed pointer arithmetics. These are 1) Adding an integer to a pointer, 2) Subtracting an integer from a pointer, 3) Subtracting one pointer from another :
  - `Adding an integer to a pointer`:
    ```c
    int arr[10], *p;

    p = &arr[0];
    p += 6  // now "p" points to "arr[6]"
    ```
  - `Subtracting an integer from a pointer`:
    ```c
    int arr[10], *p;

    p = &arr[10];
    p -= 3  // now "p" points to "arr[7]"
    ```
  - `Subtracting one pointer from another`:
    ```c
    int arr[10];
    int *p = &arr[5];
    int *j = &arr[3];

    i = p - j;  //  i is 4
    i = j - p   //  i is -2
    ```

- You can compare pointers with relational operators (<, >, <=, >=) and the equality operators (==, !=). This comparement operators only work if the both pointers point to the same array:
  ```c
  p = &arr[5];
  q = &arr[3];
  ```
  the value of `p <= q` is 0 (false) and `p > q ` is 1 (true)

- You can point pointers to compund literals (unnamed arrays -- C99 feature) but Im not gonna note it at the moment maybe later on...

- You can combine the * and ++ operators. C programmers actually often combine these two. Lets see :
  ```c
  arr[n++] = 1;

  // if "p" is pointing to an array element, the
  //corresponding statement would be

  *p++ = 1;
  ```

- The name of an array can be used as a pointer to the first element in the array. For example lets view:
  ```c
  int arr[10];

  *a = 5;      /* stores 5 in arr[0] */

  *(a+2) = 8   /* sotres 8 in arr[2] */
  ```






## Strings

- foo

## The Preprocessor

- foo

## Writing Large Programs

- Even though erlier we showed that a C program can easily fit into a single file it is always best to divide your program into modules.

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
