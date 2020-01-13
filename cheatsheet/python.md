## Python Cheatsheet

My cheatsheet on the python language

### Primitive Types

- The base types in python are: `int`, `float`, `bool`, `str`, `bytes`
  ```python
  i = 100
  f = 3.14
  b = True
  s = "hey"
  ```
  
### Variable Assignments

- There are various easy-to-use variable assignments:
  ```python
  a=b=c=0              # assignment to same value
  y, z, r = 10, 3, 1   # multiple assignments
  a, b = b, a          # values swap
  a += 1               # fast increment (-, *, /)
  del foo              # remove name foo
  ```

### Container Types

- __ordered sequences__, fast index access, repeatable values:
  ```python
   [1, 5, 9]   # list  -- modifable
   (1, 5, 9)   # tuple -- not modifable
  ```
  
- __key containers__, no a priori order, fast key access, each key is unique:
  ```python
  dict {"key":"value"}  # dictionary
  set {"key1","key2"}   # collection
  ```

### Conversions

- `int("35")` -- converts the str to an integer
- `int(3.14)` -- converts the float to an integer
- `round(5.76)` -- rounds the num to 5.8
- `bool(x)` -- converts it into a true or false value
- `str(x)` -- converts the x to a string
- `chr(64)` -- converts from character to code
- `bytes(x)` -- converts to bytes
- `list("abc")` -- converts to list ["a", "b", "c"]
- `dict([(3,"three"),(1,"one")])` --  converts to dictinoary -> {1:'one',3:'three'}
- `set(["one","two"])` -- converts to set -> {'one','two'}

### Container Indexing

### Boolean Logic 

### Maths

### Module Imports

### Conditional Statements

### Exeption on Errors

### Conditional Loops

### Iterative Loops 

### Loop Control

### Iniput, Display

### Generic Operations on Containers

### Operations on List

### Integer Sequence 

### Function Definition

### Operations on Dictionaries

### Operations on Sets 

### Operations on Strings 

### Files

