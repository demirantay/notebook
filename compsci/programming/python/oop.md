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

- We've learned that while functions can take in different arguments, methods belong to the objects they act on. In Python, polymorphism refers to the way in which different object classes can share the same method name, and those methods can be called from the same place even though a variety of different objects might be passed in.
  ```python
  class Dog:
      def __init__(self, name):
          self.name = name

      def speak(self):
          return self.name+' says Woof!'

  class Cat:
      def __init__(self, name):
          self.name = name

      def speak(self):
          return self.name+' says Meow!' 

  niko = Dog('Niko')
  felix = Cat('Felix')

  print(niko.speak())   # says woof
  print(felix.speak())  # says meow
  ```
  Here we have a Dog class and a Cat class, and each has a .speak() method. When called, each object's .speak() method returns a result unique to the object.
  
### Special Methods

- Classes in Python can implement certain operations with special method names. These methods are not actually called directly but by Python specific language syntax. For example let's create a Book class:
  ```python
  class Book:
    def __init__(self, title, author, pages):
        print("A book is created")
        self.title = title
        self.author = author
        self.pages = pages

    def __str__(self):
        return "Title: %s, author: %s, pages: %s" %(self.title, self.author, self.pages)

    def __len__(self):
        return self.pages

    def __del__(self):
        print("A book is destroyed")
  ```
  And now you do not have to call these methods off the class with the `className.methodName()` statements you can simply do:
  ```python
  book = Book("Python Rocks!", "Jose Portilla", 159)
  #Special Methods
  print(book)       # uses __str__
  print(len(book))  # uses __len__
  del book          # uses __del__
  ```
  
  The `__init__()`, `__str__()`, `__len__()` and `__del__()` methods these special methods are defined by their use of underscores. They allow us to use Python specific functions on objects created through our class. There are lots of other special methods check out the documentation for more information on all of them.


<br>
<br>
<br>

---

<br>
<br>
<Br>
  
# Advanced Object Oriented Programming

- In this section we'll dive deeper into
  - Multiple Inheritance
  - The self keyword
  - Method Resolution Order (MRO)
  - Python's built-in super() function
  
### Inheritance Revisited

- Recall that with Inheritance, one or more derived classes can inherit attributes and methods from a base class. This reduces duplication, and means that any changes made to the base class will automatically translate to derived classes. As a review:
  ```python
  class Animal:
      def __init__(self, name):    # Constructor of the class
          self.name = name

      def speak(self):              # Abstract method, defined by convention only
          raise NotImplementedError("Subclass must implement abstract method")


  class Dog(Animal):
      def speak(self):
          return self.name+' says Woof!'

  class Cat(Animal):
      def speak(self):
          return self.name+' says Meow!'

  fido = Dog('Fido')
  isis = Cat('Isis')

  print(fido.speak())
  print(isis.speak())
  ```
  In this example, the derived classes did not need their own `__init__` methods because the base class __init__ gets called automatically. However, if you do define an `__init__ `in the derived class, this will override the base:
  
  Well this may seem inefficent. And most of the it is is inefficient - why inherit from Animal if we can't use its constructor? The answer is to call the Animal `__init__` inside our own `__init__` so that we can use multiple inhertincases when we need to.
  
### Multiple Inheritance

- Sometimes it makes sense for a derived class to inherit qualities from two or more base classes. Python allows for this with multiple inheritance.
  ```python
  class Car:
      def __init__(self,wheels=4):
          self.wheels = wheels
          # We'll say that all cars, no matter their engine, have four wheels by default.

  class Gasoline(Car):
      def __init__(self,engine='Gasoline',tank_cap=20):
          Car.__init__(self)
          self.engine = engine
          self.tank_cap = tank_cap # represents fuel tank capacity in gallons
          self.tank = 0

      def refuel(self):
          self.tank = self.tank_cap


  class Electric(Car):
      def __init__(self,engine='Electric',kWh_cap=60):
          Car.__init__(self)
          self.engine = engine
          self.kWh_cap = kWh_cap # represents battery capacity in kilowatt-hours
          self.kWh = 0

      def recharge(self):
          self.kWh = self.kWh_cap
  ```
  So what happens if we have an object that shares properties of both Gasolines and Electrics? We can create a derived class that inherits from both!
  ```python
  lass Hybrid(Gasoline, Electric):
    def __init__(self,engine='Hybrid',tank_cap=11,kWh_cap=5):
        Gasoline.__init__(self,engine,tank_cap)
        Electric.__init__(self,engine,kWh_cap)
        
        
  prius = Hybrid()
  print(prius.tank)  # 0
  print(prius.kWh)   # 0
  ```
  
### Method Resolution Order (MRO)

- Things get complicated when you have several base classes and levels of inheritance. This is resolved using Method Resolution Order - a formal plan that Python follows when running object methods.

  To illustrate, if classes B and C each derive from A, and class D derives from both B and C, which class is "first in line" when a method is called on D? Consider the following:
  ```python
  class A:
    num = 4
    
  class B(A):
      pass

  class C(A):
      num = 5

  class D(B,C):
      pass
  ```
  Schematically, the relationship looks like this:
  ```
       A
     num=4
    /     \
   /       \
   B       C
  pass   num=5
   \       /
    \     /
       D
      pass
  ```
  Here num is a class attribute belonging to all four classes. So what happens if we call `D.num`?
  ```
  D.num
  ```
  You would think that D.num would follow B up to A and return 4. Instead, Python obeys the first method in the chain that defines num. The order followed is `[D, B, C, A, object]` where object is Python's base object class.
  
  There is a built-in funciton of python to better mange Method resolution orders and it is called `super()` you can read the documentation about it if you would like to.

