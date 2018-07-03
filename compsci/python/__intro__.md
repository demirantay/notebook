## Python

- This is how your write the famous "Hello, World!"
  ```python
  print("Hello, World!")
  ```
  
- If you want to run your python programs you do not have to compile the files since python is a interpreted language
  ```bash
  $ python file.py  # Runs the code
  ```

- You do not need to define variables with their type as their prefix like in java, c, c++, and remember while printing vars python does not concetante and convert ints to str's while printing with `+` you must use `,` between. simply put it like this:
  ```python
  name = "foo"
  age = 19
  decimal_num = 3.14159
  is_right = True
  
  print("Name: ", name, " is ", age, " years old")
  ```

- Most of the types are mutable in python there are types that are immutable but it is not as strictly types as java or C, so you can do the following:
  ```python
  name = "foo"
  name = 5
  
  print(name)  # prints `5`
  ```

- You can get the user input with `input()` and you can pass a string argument to it if you want the arguemnt to appear while taking user input, input() gets string so you must use `int(input(..))` for getting integer input.
  ```python
  text = input("Type a text: ")  # Gets `str` type input
  
  number = int(input("Type a number: ))  # Gets `int` type input
  ```
  
- Control Flows are simple no need explanation you have ==, >=, <=, >, <, !=. You can use stuff like `is` do not use them unless you have to they are mostly sticly typed and may cause unexpected results. There is no &&, || instead use simple `and` and `or`:
  ```python
  foo = "foo"
  bar = "foo"
  
  if foo == bar:
    print("They are same!")
  else:
    print("They are NOT same!")
   
  num = 4
  num_2 = 10
  
  if num > num_2:
    print("NUM1 is bigger")
  elif num < num_2:
    print("num 2 is bigger")
  else:
    print("They are equal!")
  ``` 
 
- While, For and For Each loops logic is same and you can write each in the following way
  ```python
  # while loop
  while(True):
    # ...
    
  # For loop
  for i in range(0, 10, 1):
    # ...
    
  # For each
  numbers = [1, 2, 3]
  for number in numbers:
    # ...
  ```
 
- You can write your self defined fucntions very simply in python no need for explanation you can simply write:
  ```python
  # Void function
  def greet():
    print("hi there")
    
   # Return `int` function
   def division(num_1, num_2):
      return num_1 / num_2
  
  ```

- You can use various kind of functions that comes preshipped and loaded with python itself such as getting the length of astring or getting a single char , substringing there are hundreds  more functions you should check the Official Documentation:
  ```python
  text = "foo"
  
  length = len(text)  # Returns `3`
  first_char = text[0]  # Returns `f`
  shorter_text = text[0:1]  # Returns `fo`
  ```

- Once you have too many objects that are in the same context instead of creating too many variables it is more logical to use lists(Arrays in other langs) you can use many self defined functions for lists's too see them all open the official docs there are many more useful methods such as .sort(..), .reverse(..) etc.
  ```python
  names = [] 
  
  names.append("hey")
  names.append("foo")
  
  print(names)  # prints ['hey', 'foo']
  
  names.pop(len(names)) 
  
  print(names)  # prints ['hey']
  ```

- Every type is an object in python and objects instances get created from the same class and it is very easy to define a class in python. Create a normal python file such as foo.py. And start defininy your class init. Your class should have a consturctor which will hold the variables of the object and behaviours(methods) of the object. `self` should be defined in each method as a first argument and it is the same thing as `this` in java. And `__str__` is the toString in java
  ```python
  class Person:

    # Constructor
    def __init__(self, inital_name, initial_age):
      self.name = initial_name
      self.age = initial_age

     # Behaviours
     def __str__(self):
      return "Name: " + str(self.name) + " Age: " + str(age)

     def get_name(self):
      return self.name

     def get_age(self):
      return self.age

     def get_older(self):
      self.age += 1  # There is no var++ in python
  ```
  In order to use our class in our main entry filewe have to import it, never use `import *` this is very bad practice. 
  ```python
  from foo import Person

  demir = Person("Demir", 19)

  print(demir)  # Prints ` Name: Demir, Age: 19 `
  ```  
  P.S. Unlike Java you cannot define classes with multiple constructors
  
- Python doesnt have to be written in a `__main__` function like in java, c, c++ but you can define a main function if you want to have a entry point for your code. I will get back to this later on ... **this is important to understand do not skip*
  
