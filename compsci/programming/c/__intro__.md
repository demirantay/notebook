## C

### Printing

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

### User Input

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

### Selection Statements

- While using C's selection statements you cannot expect to use the "true" and "false" structures that comes shipped with other higher languages. In C there is no true or false there is only 1 and 0. If the values you compare are "true" then it is `1` and if the values that you are comparing are false than the final value is `0`. Lets view the following:
  ```c
  if (10 < 5) {
    // this is `false` == `0` thats why it doesnt get executed
  }
  
  if (10 > 5) {
    // this is `true` == `1` thats why the code gets executed
  }
  ```
  You can simply get around this by including `#inlcude <stdbool.h>` which gives you a boolean type like this : `bool foo = true` 

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
  
  // lets now convert this code into a switch statement
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

### Loops

- Writing loops are farily easy in the C like any other language. First lets see how to write a "while" loop. The code snippet below shows 10 "foo" text with a line break:
  ```c
  int i = 10;
  
  while (i > 0) {
    printf("foo\n");
    i--;
  }
  ```

### Basic Types

- foo

### Arrays

- foo

### Methods

- foo


### Program Organization

- foo

### Pointers

- foo

### Pointers and Arrays

- foo

### Strings

- foo

### The Preprocessor

- foo

### Writing Large Programs

- foo

### Structures, Unions and Enumarations

-foo

### Advanced uses of Pointers

- foo

### Declaration

- foo

### Program Design

- foo

### Low level programming

- foo
