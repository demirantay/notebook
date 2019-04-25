# Python

- Python is a general-purpose interpreted, interactive, object-oriented, and high-level programming language. It was created by Guido van Rossum during 1985- 1990. Like Perl, Python source code is also available under the GNU General Public License (GPL).

- Python is a high-level, interpreted, interactive and object-oriented scripting language. Python is designed to be highly readable. It uses English keywords frequently where as other languages use punctuation, and it has fewer syntactical constructions than other languages. Python is Interpreted − Python is processed at runtime by the interpreter. You do not need to compile your program before executing it. This is similar to PERL and PHP.

<br>
<br>

## Basics

- You can run your python scripts or code with the following command (you dont need to compile it since python is a interpreted language):
  ```
  $ python name.py
  ```
 
- You can comment in python with `#` for single line comments and use triple-quoted strings to write multi-line comments
  ```python
  print('Hello, World')  # This is a single line comment
  
  '''
    This is a
    multi line comment
  '''
  ```

- Python doesn't want you to put `;` semicolons at the end of your statemetns however if you want to cram up multiple statements into a one line you can use semicolon like this:
  ```python
  import foo; x = 'bar'; print('maz')
  ```

- Most of the operators are the same e.g. `+`, `-`+ `*` .. `>`, `>=` .. etc. So Im not going to note it if you want to you can check it out in the official documentation However keep in mind that python allws you to say `and`, `or` ..etc. for `&&`, `||`

<br>
<br>

## Control Flow

- You can easily write control statements with eather a single if, nested decision makings and such here  is the way you write control flows in python:
  ```python
  if bar == 1:
      if foo == 1:
          ...
      elif foo == 2: 
          ...
      elif foo == 3:
          ...
      else:
          ...
  else:
    ...
  ```
  
- You can also write switches in python but I am not going to note it at the moment since I dont usually use it.

<br>
<br>

## Loops

- Here the following code will show you how can you write loops with python: 
  ```python
  # while loop 
  while foo < 10:
    ...
    foo += 1
    
  # for loops
  for i in range(0, 10, 1): 
      ...
  
  # or
  
  for item in array:
      print(item)
      
  ```

- There are loops control statements in any programming languages most common ones of course are `continue`, `pass`, `break`.
  Im not gonna note what each of them does since it is easy if you dont know it just open up documentation.
  ```python
  while True:
      if foo == 1:
          continue
      elif foo == 2:
          pass
      else:
          break
  ```
  
<br>
<br>

## Numbers

- Python supports 4 different numerical types:
  - `int (signed integers)` − They are often called just integers or ints, are positive or negative whole numbers with no decimal point.
  - `ong (long integers )` − Also called longs, they are integers of unlimited size, written like integers and followed by an uppercase or lowercase L.
  - `float (floating point real values)` − Also called floats, they represent real numbers and are written with a decimal point 
  - `complex (complex numbers)` − are of the form a + bJ ( they contain like `i` imaginary numbers so im not going to get into it right now)
  ```python
  a = 10; b = -25  # int
  c = 51924361L    # long
  d = 15.20        # float
  
  # You can also delete the objects
  # and your variables with del
  
  del a, b, c, d
  ```

- There are lots of cool stuff you can do with pythons own modules such as `random`, `math` ... etc. Dont forget to check it out

<br>
<br>

## Strings

- Here is how you can write and assign a string to a variable
  ```python
  foo = "this is a string"
  ```
  
- You can acsess a value of a string by this
  ```python
  foo = "this is a string"
  print(foo[0])  # <-- prints "t"
  ```

- Strings are immutable owever, you can update a string by reassaning, adding another piece of string into it or slicing or many other ways that you can lookup in the documentation:
  ```python
  foo = "string before"
  new_string = foo[0:6] + "after"  # prints "string after"
  ```
  
- You can use the string formatting technique that is used in C like this:
  ```python
  foo = "foo"
  
  bar = "this string contains %s " % foo 
  ```
  
- There are many more things that you can do with strings such as `escape characters` like `\n`, `\t` ... etc. and there are many more string special operators like `slicing`, `multipliyng` look up the official documentation for more information. Dont forget to check out the built in string methods of python.

<br>
<br>

## Lists

- Remember while creating lists (arrays) in python yoou dont have to always put same data type into one list. Here is how you write a list:
  ```python
  array = [1, 2, 3, 4, 5, 6, 7, "eight"]
  ```
  You can accsess the index of the list above with this line:
  ```python
  array[1]     # <-- Returns `2`
  array[0:3]   # <-- Returns `1, 2, 3
  ```

- You can update a list by either `.append(item)` which appends an item to the end of the list or use `insert(index, item)` to insert the item to the desired index within the list:
  ```python
  arr = ["foo", "bar"]
  
  arr.append("cat")       # <-- arr is `foo, bar, cat`
  
  arr.insert(0, "first")  # <-- arr is `first, foo, bar, cat`
  ```

- You can delete a element within the list with using `pop()` (which deletes the last item or `pop(index)` deletes the item at index:
  ```python
  arr = [1, 2, 3, 4]
  
  arr.pop()   # <-- arr is `1, 2, 3`
  arr.pop(0)  # <-- arr is `2, 3`
  ```
  
- There are basic list operations such as get the length of a list `len(arr)` or check if a item is in a list and such. Also you can index, slice find matrixes of python lists with the built in list-functions of the language. Dont forget to check them out in the official documentation.

<br>
<br>

## Tuples

- Tuples are basically has the same data structure as the lists however the difference is that they are immutable and written with parantheseses instead of brackets. Here is how you create one:
  ```python 
  foo = (1, 2, 3, 4, "five")
  ```
- You can accsess to the items the same way you do with lists:
  ```python
  foo[0]   # <-- returns you "1"
  ```
  
- As mentioned above you cannot edit a tuple they are immutable such as this:
  ```python
  foo = (1, 2, 3)
  foo[0] = 100  # WRONG! ERROR
  ```
  However if you really want to edit a tuple and for somereason you cannot use a mutable data structure this is how you do it:
  ```python
  tup1 = (1, 2, 3)
  tup2 = (4, 5, 6)
  
  tup3 = tup1 + tup3  # <-- new tuple with 6 items
  ```
  
- But remember if you really want to have a mutable data structure just use dictonaries or lists tuples are for creating constant data that should not be changed 

<br>
<br>

## Dictionary

- Dictionary is a very organised data structure when you compare it to lists or tuples. It has keys and values attached to each key. Here is how you write it:
  ```python
  dict = {
      "Name": "John",
      "Age": 21,
      "Job": "Baker"
  }
  ```

- We accsess the dictonaires with the existing keys such as this:
  ```python
  dict['name']     # <-- Returns 'John'
  # or
  dict[0]          # <-- Returns 'John'
  # or
  dict.get("name") # <-- Returns 'John'
  ```
  
- You can easily update a dictinoary by using the keys:
  ```python
  dict['age'] = 30      # <-- age of dict is now 30
  dict['height'] = 185  # <-- added a new key with a value to the dict
  ```

- You can use the `pop(key)` function to remove an key and its value from a dictionary:
  ```python
  dict.pop("name")  # <-- removes 'john' and 'name' key
  ```
  
- There are tons of different built in methods for dictionaries in python make sure to visit official documentation to get more idea about what dictionaries are capabale of.

<br>
<br>

## Functions

- Writing functions requires no gimmick in python just the syntax can come a bit off wihtout the brackets:
  ```python
  def function_name(parameter1, parameter2):
      return parameter1 + parameter2
      
  function_name(5, 4)  # <-- Returns 9
  ```

- You can put multi lined comments as your firs statemtn inside a function to give it a `__doc__`(documentation) object. See the snippet:
  ```python
  def foo():
      """
      name: foo
      desc: does stuff
      """
      pass
      
  print(foo.__doc__)  # <-- prints the comment (documentation) on the first line 
  ```
  
- While calling a function you can use the definition names to assing values. Look at this:
  ```python
  def foo(name, age):
      ...
      
  foo(age=25, name="James")
  ```
  
- While defining a function you can have default values for a case where the user forgots to input an argument:
  ```python
  def foo(name, age=18):
      ...
      
  # Both of these are exceptable
  foo("john", 30)
  foo("maya")
  ```
  
<br>
<br>

## Modules

- A module is basically a single file that has your code in it. Usually programmers only store classes, functions and variables inside modules in order to be organised and retrieve their code if it is needed on their `main` program.

- Lets say that you have this file:
  ```python
  # File name : module1.py
  
  def foo():
      print("hello, world")
  ```
  Now if we create another file named `main` we can access the `foo` files code with the following way:
  ```python
  from module1 import foo
  
  # or you can get everything in the file with this
  from module1 import *
  ```
  
- The `dir()` built-in function returns a sorted list of strings containing the names defined by a module. The list contains the names of all the modules, variables and functions that are defined in a module. Following is a simple example −
  ```python
  # Import built-in module math
  import math
  
  content = dir(math)
  print content
  ```
  When the above code is executed, it produces the following result −
  ```
  ['__doc__', '__file__', '__name__', 'acos', 'asin', 'atan', 
  'atan2', 'ceil', 'cos', 'cosh', 'degrees', 'e', 'exp', 
  'fabs', 'floor', 'fmod', 'frexp', 'hypot', 'ldexp', 'log',
  'log10', 'modf', 'pi', 'pow', 'radians', 'sin', 'sinh', 
  'sqrt', 'tan', 'tanh']
  ```
  Here, the special string variable __name__ is the module's name, and __file__ is the filename from which the module was loaded.
  
- There are lot more to learn about packaging and modules in python code but it is another topic. So in the root folder of this file you can find notes on the topic in `pacakaging` file
  
<br>
<br>

## Input & Output
  
- To output the most basic one is `print`ing:
  ```python
  print("foo")
  ```
  
  
  
