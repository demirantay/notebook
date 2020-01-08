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

# Object Oriented Programming

<br>

---

<br>

# Modules and Packages

<Br>

---

<br>

# Errors and Exception Handling

<br>

---

<br>

# Built-in Functions

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

# Advanced Python Modules

<br>

---

<br>

# Advanced python objects and data structures

<br>

---

<br>

# Advanced OOP

<br>

---

<bR>

# Parallel Processing



