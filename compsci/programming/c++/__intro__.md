# C++

- C++ is a middle-level programming language developed by Bjarne Stroustrup starting in 1979 at Bell Labs. C++ runs on a variety of platforms, such as Windows, Mac OS, and the various versions of UNIX.

- C++ is a statically typed, compiled, general-purpose, case-sensitive, free-form programming language that supports procedural, object-oriented, and generic programming.

- C++ is regarded as a middle-level language, as it comprises a combination of both high-level and low-level language features.C++ is a superset of C, and that virtually any legal C program is a legal C++ program.

- Standard C++ consists of three important parts −
  - The core language giving all the building blocks including variables, data types and literals, etc.
  - The C++ Standard Library giving a rich set of functions manipulating files, strings, etc.
  - The Standard Template Library (STL) giving a rich set of methods manipulating data structures, etc.
  
- The ANSI standard is an attempt to ensure that C++ is portable; that code you write for Microsoft's compiler will compile without errors, using a compiler on a Mac, UNIX, a Windows box, or an Alpha. The ANSI standard has been stable for a while, and all the major C++ compiler manufacturers support the ANSI standard.

<br>
<br>
<br>

## Basic Sytax

- First, lets write the notorious Hello, World program:
  ```cpp
  #include <iostream>
  using namepsace std;
  
  int main() {
    cout << "Hello, World!";
    return 0
  }
  ```
  In order to compile and run this program firstly we need to save this into a file and give it a `.cpp` extension at the end. after that you can either use `gcc` compiler or `make` to compile your source code (just like in C)
  ```
  $ gcc foo.cpp 
  ```
  Which will give you a `a.out` file and you can run it with `./a.out` or you can use the `make` and run it with the files name.
  
- Comments are like in javascript etiher with `// ...` or `/* ... */`

<br>
<br>
<br>

## Variables

### Data Types

- I am not really going to note a lot about what data types are because I have already done it many times. I am just going to show how to write them  in c++ (Im gonna cover specific types later on such as Enumaration, Pointers, Arrays, Refereces, Classes, Strings). Lets see the code snippet below:
  ```cpp
  char foo = "a";
  int bar = 10;
  float pi = 3.1415;
  double baz;
  
  /*
    There are many more types such as
    signed char, unsigned int, short int
    ... etc. Check the docs for more info
  */
  ```

### typedef Declarations

- You can create a new name for an existing type using typedef. Following is the simple syntax to define a new type using typedef −
  ```
  typedef type newname; 
  ```
  For example, the following tells the compiler that feet is another name for int −
  ```cpp
  typedef int feet;
  ```
  Now, the following declaration is perfectly legal and creates an integer variable called distance −
  ```cpp
  feet distance;
  ```
  
  
  
  
  
  
  
