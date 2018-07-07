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

- foo

### Expressions

- foo

### Selection Statements

- foo

### Conditional Statements

- foo

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


