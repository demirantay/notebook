# Object Oriented Programming in Python

- In the first part  this lesson we will construct our knowledge of OOP in Python by building on the following topics:
  - Objects
  - Using the class keyword
  - Creating class attributes
  - Creating methods in a class
  - Learning about Inheritance
  - Learning about Polymorphism
  - Learning about Special Methods for classes
  
  Lets start the lesson by remembering about the Basic Python Objects. For example:
  ```python
  lst = [1,2,3]
  ```
  Remember how we could call methods on a list?
  ```python
  lst.count(2)
  ```
  
### Objects 

- In Python, everything is an object.
  ```python
  f = 1  # objecet  
  []     # object
  {}     # object
  ```
  So we know all these things are objects, so how can we create our own Object types? That is where the `class` keyword comes in.

### Class 

- User defined objects are created using the class keyword. The `class` is a blueprint that defines the nature of a future object. From classes we can construct instances. An instance is a specific object created from a particular class. For example, above we created the object lst which was an instance of a list object.
  ```python
  # Create a new object type called Sample
  class Sample:
      pass

  # Instance of Sample
  x = Sample()
  ```
  By convention we give classes a name that starts with a capital letter. Note how x is now the reference to our new instance of a Sample class. In other words, we instantiate the Sample class.
  
  An attribute is a characteristic of an object. A method is an operation we can perform with the object. For example, we can create a class called Dog. An attribute of a dog may be its breed or its name, while a method of a dog may be defined by a .bark() method which returns a sound.
  
### Attributes

- The syntax for creating an attribute is:
  ```python
  self.attribute = something
  ```
  There is a special method called (this is the constructor):
  ```python
  __init__()
  ```
  This method is used to initialize the attributes of an object. For example:
  ```python
  class Dog:
      def __init__(self,breed):
          self.breed = breed

  sam = Dog(breed='Lab')
  frank = Dog(breed='Huskie')
  ```
  Now we have created two instances of the Dog class. With two breed types, we can then access these attributes like this:
  ```python
  sam.breed
  frank.breed
  ```
  
  In Python there are also class object attributes. These Class Object Attributes are the same for any instance of the class. For example, we could create the attribute species for the Dog class. Dogs, regardless of their breed, name, or other attributes, will always be mammals. We apply this logic in the following manner. The class object atrbiutes are global meaning that they are sharede with all of the insatances of that class:
  ```python
  class Dog:
  
    # Class Object Attribute
    species = 'mammal'
    
    def __init__(self,breed,name):
        self.breed = breed
        self.name = name 
  ```
  Note that the Class Object Attribute is defined outside of any methods in the class. Also by convention, we place them first before the init.
  
### Methods

- Methods are functions defined inside the body of a class. They are used to perform operations with the attributes of our objects. Methods are a key concept of the OOP paradigm. They are essential to dividing responsibilities in programming, especially in large applications. Let's go through an example of creating a Circle class:
  ```python
  class Circle:
      pi = 3.14

      # Circle gets instantiated with a radius (default is 1)
      def __init__(self, radius=1):
          self.radius = radius 
          self.area = radius * radius * Circle.pi

      # Method for resetting Radius
      def setRadius(self, new_radius):
          self.radius = new_radius
          self.area = new_radius * new_radius * self.pi

      # Method for getting Circumference
      def getCircumference(self):
          return self.radius * self.pi * 2
  ```
  Great! Notice how we used self. notation to reference attributes of the class within the method calls.
  
### Inheritance

- Inheritance is a way to form new classes using classes that have already been defined. The newly formed classes are called derived classes, the classes that we derive from are called base classes. Important benefits of inheritance are code reuse and reduction of complexity of a program. The derived classes (descendants) override or extend the functionality of base classes (ancestors).

  Let's see an example by incorporating our previous work on the Dog class:
  ```python
  class Animal:
      def __init__(self):
          print("Animal created")

      def whoAmI(self):
          print("Animal")

      def eat(self):
          print("Eating")


  class Dog(Animal):
      def __init__(self):
          Animal.__init__(self)
          print("Dog created")

      def whoAmI(self):
          print("Dog")

      def bark(self):
          print("Woof!")
  ```
  Now lets see how to use the parents attributes from a child class instance:
  ```python
  d = Dog() 
  d.whoAmI(self)  # child class method because it overwrites
  d.eat()         # parent class method
  d.bark()        # child class method
  ```

### Polymorphism




<br>
<br>
<br>

---

<br>
<br>
<Br>
  
# Advanced Object Oriented Programming
