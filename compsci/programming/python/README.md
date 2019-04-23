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











