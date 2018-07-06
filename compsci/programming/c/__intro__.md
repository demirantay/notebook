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
