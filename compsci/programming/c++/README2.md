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

