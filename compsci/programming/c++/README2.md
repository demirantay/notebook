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
