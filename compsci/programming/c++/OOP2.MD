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
  
- C++ polymorphism means that a call to a member function will cause a different function to be executed depending on the type of object that invokes the function.

- Note: I am skipping this part of the tutorial at this time. If you want to read again. Pick up (start) from here:
  - https://www.tutorialspoint.com/cplusplus/cpp_polymorphism.htm
  
<br>
<br>
<br>

# Data Abstraction

- Data abstraction refers to providing only essential information to the outside world and hiding their background details, i.e., to represent the needed information in program without presenting the details.

  Data abstraction is a programming (and design) technique that relies on the separation of interface and implementation. Let's take one real life example of a TV, which you can turn on and off, change the channel, adjust the volume, and add external components such as speakers, VCRs, and DVD players, BUT you do not know its internal details, that is, you do not know how it receives signals over the air or through a cable, how it translates them, and finally displays them on the screen.
  
  In C++, classes provides great level of data abstraction. They provide sufficient public methods to the outside world to play with the functionality of the object and to manipulate object data, i.e., state without actually knowing how class has been implemented internally.
  
  For example, your program can make a call to the sort() function without knowing what algorithm the function actually uses to sort the given values. In fact, the underlying implementation of the sorting functionality could change between releases of the library, and as long as the interface stays the same, your function call will still work.

- Personal Note: I do not know what is this about, the explanation above basically states to use `private` members while defining a class that we want to abstract its implementation from the end-user

<br>
<br>
<br>

# Encapsulation

- All C++ programs are composed of the following two fundamental elements −
  - Program statements (code) − This is the part of a program that performs actions and they are called functions.
  - Program data − The data is the information of the program which gets affected by the program functions.
  
  Encapsulation is an Object Oriented Programming concept that binds together the data and functions that manipulate the data, and that keeps both safe from outside interference and misuse. Data encapsulation led to the important OOP concept of `data hiding`.
  
- `Data encapsulation` is a mechanism of bundling the data, and the functions that use them and `data abstraction` is a mechanism of exposing only the interfaces and hiding the implementation details from the user.

- Let's see a real world example:
  ```cpp
  class Box {
     public:
        double getVolume(void) {
           return length * breadth * height;
        }

     private:
        double length;      // Length of a box
        double breadth;     // Breadth of a box
        double height;      // Height of a box
  };
  ```
  The variables length, breadth, and height are private. This means that they can be accessed only by other members of the Box class, and not by any other part of your program. This is one way encapsulation is achieved.
  
  Making one class a friend of another exposes the implementation details and reduces encapsulation. The ideal is to keep as many of the details of each class hidden from all other classes as possible.
  
- Most of us have learnt to make class members private by default unless we really need to expose them. That's just good encapsulation.

<br>
<br>
<br>

# Interfaces 

- An interface describes the behavior or capabilities of a C++ class without committing to a particular implementation of that class. The C++ interfaces are implemented using `abstract classes` and these abstract classes should not be confused with data abstraction which is a concept of keeping implementation details separate from associated data.

  A class is made abstract by declaring at least one of its functions as `pure virtual` function:
  ```cpp
  class Box {
     public:
        // pure virtual function
        virtual double getVolume() = 0;

     private:
        double length;      // Length of a box
        double breadth;     // Breadth of a box
        double height;      // Height of a box
  };
  ```
  The purpose of an abstract class (often referred to as an ABC) is to provide an appropriate base class from which other classes can inherit. Abstract classes cannot be used to instantiate objects and serves only as an interface. Attempting to instantiate an object of an abstract class causes a compilation error
  
- An object-oriented system might use an abstract base class to provide a common and standardized interface appropriate for all the external applications. Then, through inheritance from that abstract base class, derived classes are formed that operate similarly.
