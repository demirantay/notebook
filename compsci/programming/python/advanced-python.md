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

<Br>

---

<br>

# Python Generators

<br>

---

<br>

# Advanced python objects and data structures

<br>

---

<br>

# Parallel Processing



