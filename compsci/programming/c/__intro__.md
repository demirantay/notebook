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
  - %f - float
  - %lf - double[1]
  - %c - char
  - %s - string
  - %x - hexadecimal
 
### User Input

- You can get input from the user with `scanf(%*)`. You need to specify what data type you want to get and you will assign them to the variable with the `&*` sign (this is about pointers not covered yet just go along with it) (you can use `fgets(input)` too but I have never tried it):
  ```c
  int foo;
  
  printf("Type a number: ");
  scanf("%d", &foo);
  
  printf("Foo: %d \n", foo);  // prints the value of foo
  ```

### Expressions

- foo

### Selection Statements

- foo

### Conditional Statements

- Writing conditional statements are the same like everyother c based language ( and : `&&`, or: `||`). However when you compare strings you cannot simply do `==` or `!=` like java you need to use `strcmp` (string compare) that comes shipped with the standart library and **remember** there is no true or false keywords in c, `0` is false and anythin other than `0` is true
  ```c
  char foo[40];
  char bar[40];
  
  if (strcmp(foo, bar) != 0) {
    printf("foo and bar is same\n");
  }
  else if (strcmp(foo, bar) == 0) {
    printf("foo and bar is NOT same\n");
  }
  else {
    printf("something is up\n");
  }
  ```
  

### Loops

- foo

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


