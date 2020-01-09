# Methods and Functions

### Lambda and Mapping

- Read this file in order to understand more about `lambda` and `mapping` functionality of python. The reason I am not noting it down is because I do not usually use it. 

  But it is not hard to understand. Read this file if : https://github.com/Pierian-Data/Complete-Python-3-Bootcamp/blob/master/03-Methods%20and%20Functions/05-Lambda-Expressions-Map-and-Filter.ipynb
  
### `*arg`s and `**kwargs` 

- `*args` -- Work with Python long enough, and eventually you will encounter `*args` and `**kwargs`. These strange terms show up as parameters in function definitions. What do they do? Let's review a function:
  ```python
  def myfunc(a=0,b=0,c=0,d=0,e=0):
      return sum((a,b,c,d,e))*.05

  myfunc(40,60,20)
  ```
  Obviously this is not a very efficient solution, and that's where `*args` comes in.
  
  When a function parameter starts with an asterisk, it allows for an arbitrary number of arguments, and the function takes them in as a tuple of values. Rewriting the above function:
  ```python
  def myfunc(*args):
      return sum(args)*.05

  myfunc(40,60,20)
  ```
  It is worth noting that the word "args" is itself arbitrary - any word will do so long as it's preceded by an asterisk. To demonstrate this:
  ```python
  def myfunc(*spam): ...
  ```
  
- `**kwargs` -- Similarly, Python offers a way to handle arbitrary numbers of keyworded arguments. Instead of creating a tuple of values, kwargs builds a dictionary of key/value pairs. For example:
  ```python
  def myfunc(**kwargs):
      if 'fruit' in kwargs:
          print(f"My favorite fruit is {kwargs['fruit']}")  # review String Formatting and f-strings 
                                                            # if this syntax is unfamiliar
      else:
          print("I don't like fruit")

  myfunc(fruit='pineapple')
  ```
  
- You can pass `*args` and `**kwargs` into the same function, but `*args` have to appear before `**kwargs`:
  ```python
  def myfunc(*args, **kwargs):
      if 'fruit' and 'juice' in kwargs:
          print(f"I like {' and '.join(args)} and my favorite fruit is {kwargs['fruit']}")
          print(f"May I have some {kwargs['juice']} juice?")
      else:
          pass

  myfunc('eggs','spam',fruit='cherries',juice='orange')
  ```

<br>

---

<bR>

# Errors and Exception Handling

- In this lecture we will learn about Errors and Exception Handling in Python.

- `try and except` --  The basic terminology and syntax used to handle errors in Python are the try and except statements. The code which can cause an exception to occur is put in the try block and the handling of the exception is then implemented in the except block of code. The syntax follows:
  ```
  try:
     You do your operations here...
     ...
  except ExceptionI:
     If there is ExceptionI, then execute this block.
  except ExceptionII:
     If there is ExceptionII, then execute this block.
     ...
  else:
     If there is no exception then execute this block. 
  ```
  Lets look at a code example:
  ```python
  try:
      f = open('testfile','w')
      f.write('Test write this')
  except IOError:
      # This will only check for an IOError exception and then execute this print statement
      print("Error: Could not find file or read data")
  else:
      print("Content written successfully")
      f.close()
  ```
  We could have also just said except: if we weren't sure what exception would occur. For example:
  ```python
  try:
      f = open('testfile','r')
      f.write('Test write this')
  except:
      # This will check for any exception and then execute this print statement
      print("Error: Could not find file or read data")
  ```
  Great! Now we don't actually need to memorize that list of exception types! Now what if we kept wanting to run code after the exception occurred? This is where finally comes in.

- `finally` -- The finally: block of code will always be run regardless if there was an exception in the try code block. For example:
  ```python
  def askint():
      try:
          val = int(input("Please enter an integer: "))
      except:
          print("Looks like you did not enter an integer!")

      finally:
          print("Finally, I executed!")
      print(val)
  ```


<br>

---

<br>

# Python Decorators

- Decorators can be thought of as functions which modify the functionality of another function. They help to make your code shorter and more "Pythonic".

  Before we dive into python decorators lets remember that we can grab and use functions object instead of calling the function. Remember everything in python are objects. 
  ```python
  def hello():
    print("greetinhs")
    
  f = hello   # <-- this assings the 'hello' functions object to variable f (<function __main__.hello>)
  ```

### Functions within functions

- Great! So we've seen how we can treat functions as objects, now let's see how we can define functions inside of other functions:
  ```python
  def hello(name='Jose'):
      print('The hello() function has been executed')

      def greet():
          return '\t This is inside the greet() function'

      def welcome():
          return "\t This is inside the welcome() function"

      print(greet())
      print(welcome())
      print("Now we are back inside the hello() function")
  ```

### Returning Functions

- Now let's see what function is returned if we set x = hello(), note how the empty parentheses means that name has been defined as Jose.
  ```python
  def hello(name='Jose'):
  
      def greet():
          return '\t This is inside the greet() function'

      def welcome():
          return "\t This is inside the welcome() function"

      if name == 'Jose':
          return greet
      else:
          return welcome
  ```
  In the if/else clause we are returning `greet` and `welcome`, not `greet()` and `welcome()`. We return their objects not functions output.
  
  This is because when you put a pair of parentheses after it, the function gets executed; whereas if you don’t put parentheses after it, then it can be passed around and can be assigned to other variables without executing it.

### Functions as Arguments

- Now let's see how we can pass functions as arguments into other functions:
  ```python
  def hello():
      return 'Hi Jose!'

  def other(func):
      print('Other code would go here')
      print(func())
  ```
  Great! Note how we can pass the functions as objects and then use them within other functions. Now we can get started with writing our first decorator:
  
### Creating a Decorator 

- In the previous example we actually manually created a Decorator. Here we will modify it to make its use case clear:
  ```python
  def new_decorator(func):

      def wrap_func():
          print("Code would be here, before executing the func")

          func()

          print("Code here will execute after the func()")

      return wrap_func

  def func_needs_decorator():
      print("This function is in need of a Decorator")
  ```
  Noew lets use the code above and see what is the output of the code:
  ```python
  func_needs_decorator()
  func_needs_decorator = new_decorator(func_needs_decorator)
  func_needs_decorator()
  ```
  The output would be :
  ```
  This function is in need of a Decorator
  
  Code would be here, before executing the func
  This function is in need of a Decorator
  Code here will execute after the func()
  ```

  So what just happened here? A decorator simply wrapped the function and modified its behavior. Now let's understand how we can rewrite this code using the @ symbol, which is what Python uses for Decorators:
  ```python
  @new_decorator
  def func_needs_decorator():
      print("This function is in need of a Decorator")
  ```
  after that iff we run it again:
  ```python
  func_needs_decorator()
  ```
  we will get the output below
  ```
  Code would be here, before executing the func
  This function is in need of a Decorator
  Code here will execute after the func()
  ```

<Br>

---

<br>

# Python Generators

