# OOP in C++

- The main purpose of C++ programming is to add object orientation to the C programming language and classes are the central feature of C++ that supports object-oriented programming and are often called user-defined types.
 
  A class is used to specify the form of an object and it combines data representation and methods for manipulating that data into one neat package. The data and functions within a class are called members of the class.

<br>
<br>
<br>

# Class and Objects

### Class Definitions

- When you define a class, you define a blueprint for a data type. This doesn't actually define any data, but it does define what the class name means, that is, what an object of the class will consist of and what operations can be performed on such an object.
  ```cpp
  class Box {
     public:
        double length;   // Length of a box
        double breadth;  // Breadth of a box
        double height;   // Height of a box
  };
  ```
  The keyword `public` determines the access attributes of the members of the class that follows it. A public member can be accessed from outside the class anywhere within the scope of the class object. You can also specify the members of a class as `private` or `protected` which we will discuss in a sub-section.
  
### Defining an Object

- A class provides the blueprints for objects, so basically an object is created from a class. We declare objects of a class with exactly the same sort of declaration that we declare variables of basic types. Following statements declare two objects of class Box −
  ```cpp
  Box Box1;          // Declare Box1 of type Box
  Box Box2;          // Declare Box2 of type Box
  ```
  
### Accessing the Data Members

- The public data members of objects of a class can be accessed using the direct member access operator (.)
  ```cpp
  #include <iostream>

  using namespace std;

  class Box {
     public:
        double length;   // Length of a box
        double breadth;  // Breadth of a box
        double height;   // Height of a box
  };
  
  int main() {
     Box Box1;        // Declare Box1 of type Box
     Box Box2;        // Declare Box2 of type Box
     double volume = 0.0;     // Store the volume of a box here

     // box 1 specification
     Box1.height = 5.0; 
     Box1.length = 6.0; 
     Box1.breadth = 7.0;

     // box 2 specification
     Box2.height = 10.0;
     Box2.length = 12.0;
     Box2.breadth = 13.0;

     // volume of box 1
     volume = Box1.height * Box1.length * Box1.breadth;
     cout << "Volume of Box1 : " << volume <<endl;

     // volume of box 2
     volume = Box2.height * Box2.length * Box2.breadth;
     cout << "Volume of Box2 : " << volume <<endl;
     return 0;
  }
  ```
  It is important to note that private and protected members can not be accessed directly using direct member access operator (.), We will learn how private and protected members can be accessed.
  
### Class Member Functions

- A member function of a class is a function that has its definition or its prototype within the class definition like any other variable. It operates on any object of the class of which it is a member, and has access to all the members of a class for that object.

  Let us take previously defined class to access the members of the class using a member function instead of directly accessing them −
  ```cpp
   class Box {
     public:
        double length;      // Length of a box
        double breadth;     // Breadth of a box
        double height;      // Height of a box

        double getVolume(void) {
           return length * breadth * height;
        }
  };
  ```
  If you like, you can define the same function outside the class using the `scope resolution operator (::)` as follows −
  ```cpp
    double Box::getVolume(void) {
     return length * breadth * height;
  }
  ```
  Here, only important point is that you would have to use class name just before :: operator.
  
- A member function will be called using a dot operator (.) on a object where it will manipulate data related to that object only as follows −
  ```cpp
  Box myBox;          // Create an object

  myBox.getVolume();  // Call member function for the object
  ```

### Class Access Modifiers

- Data hiding is one of the important features of Object Oriented Programming which allows preventing the functions of a program to access directly the internal representation of a class type. The access restriction to the class members is specified by the labeled `public`, `private`, and `protected` sections within the class body.
  
  Usually it is adviced to format your class members with comments:
  ```cpp
  class Base {   
     // public members go here
     public:
     
     // protected members go here
     protected:

     // private members go here
     private:
  };
  ```
  
- A `private` member variable or function cannot be accessed, or even viewed from outside the class. Only the class and friend functions can access private members. By default all the members of a class would be private. But it is good to write `private:` like you write `public:` for readabiltiy

- A `protected` member variable or function is very similar to a private member but it provided one additional benefit that they can be accessed in child classes which are called derived classes. You will learn derived classes and inheritance in next chapter.
  
  
### Constructor and Destructor

- A class constructor is a special member function of a class that is executed whenever we create new objects of that class.

  A constructor will have exact same name as the class and it does not have any return type at all, not even void. Constructors can be very useful for setting initial values for certain member variables.
  
  A default constructor does not have any parameter, but if you need, a constructor can have parameters. This helps you to assign initial value to an object at the time of its creation as shown in the following example −
  ```cpp
  class Foo {
     public:
        Foo(double len);  // This is the constructor

     private:
        double bar;
  };
  ```
  and whenever you call this function now your will need to pass on a initial parameter:
  ```
  Foo my_object(56.05);
  ```
  
- In case of parameterized constructor, you can use following syntax to use the paramters passed to the constructor if you are definig functions out of your class blocks −
  ```cpp
  Line::Line( double len) {
     cout << "Object is being created, length = " << len << endl;
     length = len;
  }
  ```
  
- `Class Destructor` - A destructor is a special member function of a class that is executed whenever an object of it's class goes out of scope or whenever the delete expression is applied to a pointer to the object of that class.
  
  A destructor will have exact same name as the class prefixed with a tilde (~) and it can neither return a value nor can it take any parameters. Destructor can be very useful for releasing resources before coming out of the program like closing files, releasing memories etc.
  ```cpp
  class Line {
     public:
        Line();   // This is the constructor declaration
        ~Line();  // This is the destructor: declaration
    ```

<br>
<br>
<br>
<br>

# Inheritance 
