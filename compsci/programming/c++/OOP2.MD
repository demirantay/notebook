[Part 1](./OOP.md)

---

<br>

# Overloading (Opreator and Function)

- C++ allows you to specify more than one definition for a function name or an operator in the same scope, which is called function overloading and operator overloading respectively.
  
  An overloaded declaration is a declaration that is declared with the same name as a previously declared declaration in the same scope, except that both declarations have different arguments and obviously different definition (implementation).
  
  When you call an overloaded function or operator, the compiler determines the most appropriate definition to use, by comparing the argument types you have used to call the function or operator with the parameter types specified in the definitions. The process of selecting the most appropriate overloaded function or operator is called overload "resolution".
  
### Function Overloading 

- You can have multiple definitions for the same function name in the same scope. The definition of the function must differ from each other by the types and/or the number of arguments in the argument list. You cannot overload function declarations that differ only by return type. Lets see :
  ```cpp
  class printData {
     public:
        void print(int i) {
          cout << "Printing int: " << i << endl;
        }
        void print(double  f) {
          cout << "Printing float: " << f << endl;
        }
        void print(char* c) {
          cout << "Printing character: " << c << endl;
        }
  };
  ```
  
### Operators Overloading

- I fucking did not get what is the point of operator overloading so in order to prevent future confusion. I am not going to note it. https://www.tutorialspoint.com/cplusplus/cpp_overloading.htm  --> this is the document that I used today. If you want you canf ind a better resource in the future. 

<br>
<Br>
<br>
<br>

# Polymorpihsm 

- The word polymorphism means having many forms. Typically, polymorphism occurs when there is a hierarchy of classes and they are related by inheritance.
  
