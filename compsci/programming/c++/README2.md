[Part 1](./README.md)

---

<br>

# Pointers

- Some C++ tasks are performed more easily with pointers, and other C++ tasks, such as dynamic memory allocation, cannot be performed without them. 

  As you know every variable is a memory location and every memory location has its address defined which can be accessed using ampersand (&) operator which denotes an address in memory. Consider the following which will print the address of the variables defined −
  ```cpp
  #include <iostream>

  using namespace std;
  int main () {
     int  var1;
     char var2[10];

     cout << "Address of var1 variable: ";
     cout << &var1 << endl;

     cout << "Address of var2 variable: ";
     cout << &var2 << endl;

     return 0;
  }
  ```
  When the above code is compiled and executed, it produces the following result 
  ```
  Address of var1 variable: 0xbfebd5c0
  Address of var2 variable: 0xbfebd5b6
  ```
  
### What are pointers 

- A pointer is a variable whose value is the address of another variable. Like any variable or constant, you must declare a pointer before you can work with it.
  ```
  type *var-name;
  ```
  Here, type is the pointer's base type; it must be a valid C++ type and var-name is the name of the pointer variable
  ```cpp
  int    *ip;    // pointer to an integer
  double *dp;    // pointer to a double
  float  *fp;    // pointer to a float
  char   *ch     // pointer to character
  ```
  The actual data type of the value of all pointers, whether integer, float, character, or otherwise, is the same, a long hexadecimal number that represents a memory address. The only difference between pointers of different data types is the data type of the variable or constant that the pointer points to.
  
### Using Pointers in C++

- There are few important operations, which we will do with the pointers very frequently. (a) We define a pointer variable. (b) Assign the address of a variable to a pointer. (c) Finally access the value at the address available in the pointer variable. This is done by using unary operator * that returns the value of the variable located at the address specified by its operand. Following example makes use of these operations −
  ```cpp
  #include <iostream>

  using namespace std;

  int main () {
     int  var = 20;   // actual variable declaration.
     int  *ip;        // pointer variable 

     ip = &var;       // store address of var in pointer variable

     cout << "Value of var variable: ";
     cout << var << endl;

     // print the address stored in ip pointer variable
     cout << "Address stored in ip variable: ";
     cout << ip << endl;

     // access the value at the address available in pointer
     cout << "Value of *ip variable: ";
     cout << *ip << endl;

     return 0;
  }
  ```
  The code above produces the following result
  ```
  Value of var variable: 20
  Address stored in ip variable: 0xbfc601ac
  Value of *ip variable: 20
  ```
  
  ...
  
<br>
<br>
<br>
<br>

# References

- A reference variable is an alias, that is, another name for an already existing variable. Once a reference is initialized with a variable, either the variable name or the reference name may be used to refer to the variable.

- References are often confused with pointers but three major differences between references and pointers are −
  - You cannot have NULL references. You must always be able to assume that a reference is connected to a legitimate piece of storage.
  - Once a reference is initialized to an object, it cannot be changed to refer to another object. Pointers can be pointed to another object at any time.
  - A reference must be initialized when it is created. Pointers can be initialized at any time.
  
- Think of a variable name as a label attached to the variable's location in memory. You can then think of a reference as a second label attached to that memory location. Therefore, you can access the contents of the variable through either the original variable name or the reference. Lets see:
  ```cpp
  int foo = 42;
  
  int& bar = foo;  // <-- this is your reference 
  ```
  Read the & in these declarations as reference.
  
- References are usually used for function argument lists and function return values. So following are two important subjects related to C++ references which should be clear to a C++ programmer −

### References as Parameters

- You can read about it from here. This document is just a starting point. Dig deeper if you want to understand more:
  - https://www.tutorialspoint.com/cplusplus/passing_parameters_by_references.htm
  
### References as Return Values

- You can read about it from here. This document is just a starting point. Dig deeper if you want to understand more:
  - https://www.tutorialspoint.com/cplusplus/returning_values_by_reference.htm

<Br>
<br>
<br>
 
# Date and Time

- There are too much info to note down on a single file read it fully from here and research for other resources if you want more info because this is just a simple tutorial:
  - https://www.tutorialspoint.com/cplusplus/cpp_date_time.htm
  
<br>
<br>
<br>

# Basic Input/Output

- The C++ standard libraries provide an extensive set of input/output capabilities which we will see in subsequent chapters. This chapter will discuss very basic and most common I/O operations required for C++ programming.

- There are following header files important to C++ programs −
  - `<iostream>` - This file defines the cin, cout, cerr and clog objects, which correspond to the standard input stream, the standard output stream, the un-buffered standard error stream and the buffered standard error stream, respectively.
  - `<iomanip>` - This file declares services useful for performing formatted I/O with so-called parameterized stream manipulators, such as "setw" and "setprecision".
  - `<fstream>` - This file declares services for user-controlled file processing. We will discuss about it in detail in File and Stream related chapter.
  
### The Standard Output Stream (cout)

- The predefined object cout is an instance of ostream class. The cout object is said to be "connected to" the standard output device, which usually is the display screen. The cout is used in conjunction with the stream insertion operator, which is written as <<
  ```cpp
  cout << "Value of foo is : " << foo << endl;
  ```

### The Standard Input Stream (cin)

- The predefined object cin is an instance of iostream class. The cin object is said to be attached to the standard input device, which usually is the keyboard. The cin is used in conjunction with the stream extraction operator, which is written as >>
  ```cpp
  char name[50];
 
  cout << "Please enter your name: ";
  cin >> name;
  cout << "Your name is: " << name << endl;
  ```
  
- The stream extraction operator >> may be used more than once in a single statement. To request more than one datum you can use the following −
  ```cpp
  cin >> name >> age;
  ```
  This will be equivalent to the following two statements −
  ```cpp
  cin >> name;
  cin >> age;
  ```
  
### The Standard Error Stream (cerr)

- The predefined object cerr is an instance of ostream class. The cerr object is said to be attached to the standard error device, which is also a display screen but the object cerr is un-buffered and each stream insertion to cerr causes its output to appear immediately.
  ```cpp
  #include <iostream>
 
  using namespace std;

  int main() {
     char str[] = "Unable to read....";

     cerr << "Error message : " << str << endl;
  }
  ```

### The Standard Log Stream (clog)

- The predefined object clog is an instance of ostream class. The clog object is said to be attached to the standard error device, which is also a display screen but the object clog is buffered. This means that each insertion to clog could cause its output to be held in a buffer until the buffer is filled or until the buffer is flushed.

- I do not have an example to give at the moment you should research this from another soruce tutorialspoint's explanation of clog is pretty bad.

<br>
<br>
<br>

# Data Structures 
  
- C/C++ arrays allow you to define variables that combine several data items of the same kind, but structure is another user defined data type which allows you to combine data items of different kinds.
  
  Structures are used to represent a record, suppose you want to keep track of your books in a library. You might want to track the following attributes about each book −
  - Title
  - Author
  - Subject
  - Book ID
  
### Defining a Strucutre 

- To define a structure, you must use the struct statement. The struct statement defines a new data type, with more than one member, for your program. The format of the struct statement is this −
  ```
  struct [structure tag] {
     member definition;
     member definition;
     ...
     member definition;
  } [one or more structure variables];  
  ```
  The structure tag is optional and each member definition is a normal variable definition, such as int i; or float f; or any other valid variable definition. At the end of the structure's definition, before the final semicolon, you can specify one or more structure variables but it is optional. Here is the way you would declare the Book structure −
  ```cpp
  struct Books {
     char  title[50];
     char  author[50];
     char  subject[100];
     int   book_id;
  } book; //<- optional var  
  ```
  
### Accessing Structure Members

- To access any member of a structure, we use the member access operator (.). The member access operator is coded as a period between the structure variable name and the structure member that we wish to access. You would use struct keyword to define variables of structure type.
  ```cpp
  #include <iostream>
  #include <cstring>

  using namespace std;

  struct Books {
     char  title[50];
     char  author[50];
     char  subject[100];
     int   book_id;
  };

  int main() {
     struct Books Book1;        // Declare Book1 of type Book
     
     // book 1 specification
     strcpy( Book1.title, "Learn C++ Programming");
     strcpy( Book1.author, "Chand Miyan"); 
     strcpy( Book1.subject, "C++ Programming");
     Book1.book_id = 6495407;
     
     // Print Book1 info
     cout << "Book 1 title : " << Book1.title <<endl;
     cout << "Book 1 author : " << Book1.author <<endl;
     cout << "Book 1 subject : " << Book1.subject <<endl;
     cout << "Book 1 id : " << Book1.book_id <<endl;
     
     return 0;
  }
  ```
  
### Structures as Function Arguments 

- You can pass a structure as a function argument in very similar way as you pass any other variable or pointer. You would access structure variables in the similar way as you have accessed in the above example −
  ```cppp
  // ...
  
  void printBook( struct Books book );
  
  int main() {
    // ...
    
    // Print Book1 info
     printBook( Book1 );
  }
  
  void printBook( struct Books book ) {
     cout << "Book title : " << book.title <<endl;
     cout << "Book author : " << book.author <<endl;
     cout << "Book subject : " << book.subject <<endl;
     cout << "Book id : " << book.book_id <<endl;
  }
  ```
 
### Pointers to Structures 

- You can define pointers to structures in very similar way as you define pointer to any other variable as follows −
  ```cpp
  struct Books *struct_pointer;
  ```
  Now, you can store the address of a structure variable in the above defined pointer variable. To find the address of a structure variable, place the & operator before the structure's name as follows −
  ```cpp
  struct_pointer = &Book1;
  ```
  To access the members of a structure using a pointer to that structure, you must use the `->` operator instead of the `*` as follows 
  ```cpp
  struct_pointer->title;
  ```
  
