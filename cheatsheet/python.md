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

- There are vaarious ways to access(index) the variables in the list, Lets say that we have this array and we will use it to showcase the various ways to access a list:
  ```python
  arr = [1, 2, 3, 4, 5]
  ```
- `len(arr)` -- get you the item count or the length of the arrray (5)
- `arr[0]` -- accesses the first element from the head (while using positive numbers index starts from 0)
- `arr[-1]` --  accesess the first element from the tail (While using negative numbers index start from -1)
- `arr[:3]` -- prints you [1, 2, 3]
- `arr[:-1]` -- prints you [1, 2, 3, 4]
- `arr[1:-1]` -- prints you [2, 3, 4]
- `arr[::2]` -- prints you [1, 3, 5]
> The main logic behind the slicing is this:  lst[start slice:end slice:step]

### Generic Operations on Containers

### Operations on List

### Operations on Dictionaries

### Operations on Sets 

### Operations on Strings 


