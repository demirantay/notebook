# Object Oriented Programming in Python

- Python has been an object-oriented language since it existed. Because of this, creating and using classes and objects are downright easy.

<br>
<br>

## Overview of OOP Terminology

- `Class` - A user-defined prototype for an object that defines a set of attributes that characterize any object of the class. The attributes are data members (class variables and instance variables) and methods, accessed via dot notation.
- `Class variable` − A variable that is shared by all instances of a class. Class variables are defined within a class but outside any of the class's methods. Class variables are not used as frequently as instance variables are.
- `Data member` − A class variable or instance variable that holds data associated with a class and its objects.
- `Function overloading` − The assignment of more than one behavior to a particular function. The operation performed varies by the types of objects or arguments involved.
- `Instance variable` − A variable that is defined inside a method and belongs only to the current instance of a class.
- `Inheritance` − The transfer of the characteristics of a class to other classes that are derived from it.
- `Instance` − An individual object of a certain class. An object obj that belongs to a class Circle, for example, is an instance of the class Circle.
- `Instantiation` − The creation of an instance of a class.
- `Method` − A special kind of function that is defined in a class definition.
- `Object` − A unique instance of a data structure that's defined by its class. An object comprises both data members (class variables and instance variables) and methods.
- `Operator overloading` − The assignment of more than one function to a particular operator.

<br>
<br>

## Creating Classes

- The class statement creates a new class definition. The name of the class immediately follows the keyword class followed by a colon as follows −
  ```python
  class class_name:
      ''' Optional __doc__ (documentation) '''
      # code
  ```
  
- Lets build an dummy class to learn what are the core concepts - 
  ```python
  class Person:
      '''
        This is a persons class
      '''
      
      def __init__(self, input_name, input_age):
          self.name = input_name
          self.age = input_age
          Person.person_count += 1
      
      def __str__(self):
          return "Name: " + self.name + "Age: " + self.age
          
      def get_name(self):
          return self.name
          
      get_age(self):
          return self.age
          
      print_person_count(self):
          print("Person count: %s" % Person.person_count)
  ```
  - Lets review the code snippet above. First, The variable `person_count` is a class variable whose value is shared among all instances of a this class. This can be accessed as Employee.empCount from inside the class or outside the class.
  - The first method `__init__()` is a special method, which is called class constructor or initialization method that Python calls when you create a new instance of this class.
  - You declare other class methods like normal functions with the exception that the first argument to each method is `self`. Python adds the self argument to the list for you; you do not need to include it when you call the methods. The `self` is like the `this` keyword in Java it points to the parent object which is the Class definition in this case.
  - `__str__` is to string method of the python classes. You do not have to put this, it is just convenient. There are many more built in class functions that we will se below
  
<br>
<br>

## Creating Instance Objects

- To create instances of a class, you call the class using class name and pass in whatever arguments its __init__ method accepts. -
  ```python
  # First object of Person class
  john = Person("John", 29)
  
  # Second object of Person class
  vanessa = Person("Vanessa", 37)
  ```

### Accsessing Attributes

- To create instances of a class, you call the class using class name and pass in whatever arguments its __init__ method accepts. -
  ```python
  print(john.get_name)
  print(vanessa)
  
  # Prints
  # "john"
  # "Name: vanessa, Age: 37"
  ```
  You can also get the objects in a number of different ways, you need to check out the documentation for more information. one of the other common ones are these -
  ```python
  hasattr(john, 'age')    # Returns true if 'age' attribute exists
  getattr(john, 'age')    # Returns value of 'age' attribute
  setattr(john, 'age', 8) # Set attribute 'age' at 8
  delattr(john, 'age')    # Delete attribute 'age'
  ```
  
- You can add, remove, or modify attributes of classes and objects at any time −
  ```python
  john.last_name = "smith"   # adds an last name var
  john.last_name = "donald"  # modifys the last name var
  del john.last_name         # deletes the last name var
  ```

<br>
<br>

## Built-In Class Attributes

...
  

