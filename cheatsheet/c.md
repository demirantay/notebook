# C Language Cheatsheet

## Compiling

- `gcc foo.c` -- compiles foo.c into a.out run result with __./a.out__
- `gcc -o prog foo.c` --  compiles foo.c into prog; run result with __./prog__
- `gcc -g -o prog foo.c` --  as above, but allows for debugging
- `make foo.c` -- instead of a gcc which will automatically name the exec file with the name of your .c file

## Variables

- Standart Data Types:
  ```c
  int i,k = 1;
  char c, ch = "foo";
  float f = 1.0;
  double pi = 3.1415;
  ```
  
- There is no standart `string` or `bool` instead you can use this:
  ```c
  /* option 1 */
  #include <stdbool.h>

  /* option 2 */
  typedef int bool;
  #define true 1
  #define false 0

  bool foo = true;
  ```
  
- You write constants with #define:
  ```c
  #define PI 3.14
  #define NEWLINE "\n"
  ```
  or
  ```c
  const int PI = 3.14;
  ```

## Desicion Making

- if ... else:
  ```c
  if (a == 0) {
  ...
  } else if (a == 4) {
    ...
  } else {
    ...
  }
  ```
  
- Or : `Exp1 ? Exp2 : Exp3;` -- Exp1 is evaluated. If it is true, then Exp2 If Exp1 is false, then Exp3 is evaluated and its value becomes the value of the expression
  
## Loops

- Cheat:
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

## Functions

- fucntion reference:
  ```c
  int sum (int num1, int num2) {
    result = num1 + num2;
    return result;
  }
  ```

## Arrays

- You must give a size to your array:
  ```c
  double balance[5] = {1000.0, 2.0, 3.4, 7.0, 50.0};
  ``` 
- But you can also not give a size and let the compiler figure it out:
  ```c
  double balance[] = {1000.0, 2.0};
  ```

## Pointers

- Pointers usage with its operators `*` and `&`:
  ```c
  int foo = 10;
  int *p;

  p = &foo;

  /* Adress */
  printf("This is the adress of foo: %x \n", p);

  /* Value */
  printf("This is the value of the adress: %d \n", *p);
  ```

## Strings

- Declaration:
  ```c
  char greeting[] = "hello";
  ```
- `strycpy(s1, s2);` - Copies string s2 into string s1.
- `strcat(s1, s2);` - Concatenates string s2 onto the end of string s1.
- `strlen(s1);` - Returns the length of string s1.
- `strcmp(s1, s2);` - Returns 0 if s1 and s2 are the same; less than 0 if s1<s2; greater than 0 if s1>s2.
- `strchr(s1, ch);` - Returns a pointer to the first occurrence of character ch in string s1.
- `strstr(s1, s2);` - Returns a pointer to the first occurrence of string s2 in string s1.

## Storage Classes

- ...

## Structures

- Refernce and usage of structures:
  ```c
  struct Book {
    char title[50];
    char author[50];
    char subject[100];
    int book_id;
  };
  ```
  Usage:
  ```c
  struct Book foo;  // <-- book struct decleration

  /* Struct 1 specification */
  strcpy(foo.title, "Macbeth");
  strcpy(foo.author, "Shakespeare");
  strcpy(foo.subject, "Novel");
  foo.book_id = 123;
  ```

## Typedef

- Used for creating aliases for they types:
  ```c
  typedef int Bool;

  Bool true = 1;
  Bool false = 0;
  ```

## Input Output

- Quick usage reference for `scanf` and `printf` --
  ```c
  int main() {
    int foo, baz;

    printf("Enter your values: ");
    scanf("%d %d", &foo, &baz);

    pritnf("Your values are %d and %d", foo, baz);

    return 0;
  }
  ```
  
- For Output accessing the variables:
  - `%d` - int (same as %i)
  - `%ld` - long int (same as %li)
  - `%f` - float (you can use %.2f if you want to see 2 the floating points after the decimal)
  - `%lf` - double[1]
  - `%c` - char
  - `%s` - string
  - `%x` - hexadecimal

## Header Files

- `#include <file>` -- (USED FOR STANDART LIBRARIES) 
- `#include "file"` -- (USED FOR LOCAL LIBRARIES)
  
  Usage:
  ```c
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

## Preprocessors

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
- `#pragma` - Issues special commands to the compiler, using a standardized method.

## Pre-defined macros

- `__DATE__` - The current date as a character literal in "MMM DD YYYY" format.
- `__TIME__` - The current time as a character literal in "HH:MM:SS" format.
- `__FILE__` - This contains the current filename as a string literal.
- `__LINE__` - This contains the current line number as a decimal constant.
- `__STDC__` - Defined as 1 when the compiler complies with the ANSI standard.

  Usage:
  ```c
  int main() {
    printf("File :%s\n", __FILE__ );   // <-- prints "foo.c"
  }
  ```

## Type-Casting

- Conversion in C is done like this:
  ```c
  int a = 10, b = 20;
  double sum;

  sum = (double) a + b;
  ```

## Command Line Arguments

- ...

## File I/O

- ...

## Memory Management

- ...



