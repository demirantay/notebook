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
