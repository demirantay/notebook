## Python Cheatsheet

My cheatsheet on the python language

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

- `len(c)` -- Returns you the count or the length of the container
- `min(c)` -- returnss yout the smallest minimum item of the container
- `max(c)` -- returns you the maximum biggest item of the container
- `sum(c)` -- returns you the sum of all itmes in the container
- `sorted(c)` -- returns you a copy of the container in a sorted fashion
- `enumarate(c)` --  iterator on (index, value)
- `zip(c1, c2, ...)` -- iterator on tuples containing c^i items at same index
- `all(c)` -- True if all c items evaluated to true, else False
- `any(c)` -- True if at least one item of c evaluated true, else False
> Note: For dictionaries and sets, these operations use keys. And you can find more on docs

### Operations on List

- `lst.append(val)` -- add item at end
- `lst.extend(seq)` -- add sequence of items at end
- `lst.insert(idx,val)` -- insert item at index
- `lst.remove(val)` -- remove first item with value val
- `lst.pop([idx])` -- remove & return item at index idx (default last)
- `lst.reverse()` -- reverses the list
- `lst.sort()` -- sorts the list

> There are a lot of methods on lists check them on docs

### Operations on Dictionaries

- `clear()` -- 	Removes all Items
- `copy()` -- Returns Shallow Copy of a Dictionary
- `fromkeys()` -- creates dictionary from given sequence
- `get()` -- Returns Value of The Key
- `items()` -- returns view of dictionary's (key, value) pair
- `keys()` -- Returns View Object of All Keys
- `popitem()` -- 	Returns & Removes Element From Dictionary
- `setdefault()` -- Inserts Key With a Value if Key is not Present
- `pop()` -- removes and returns element having given key
- `values()` -- returns view of all values in dictionary
- `update()` -- Updates the Dictionary

> There are a lot of methods on dictionaries check them on docs

### Operations on Sets 

- `s.update(s2)` -- updates the set with anoter set given as a parameter
- `s.add(key) ` -- adds a key to the set
- `s.discard(key)` -- discardes a key from the set
- `s.pop()` -- deletes the last set or you can give an index to it
- `s.copy()` -- copies the set
- `s.remove(key)` -- removes a key from the set in the given index
- `s.clear()` -- deletes all the keys inside the set

> There are a lot of methods for sets check them on docs

### Operations on Strings 

- `capitalize()` -- Converts first character to Capital Letter
- `center()` -- Pads string with specified character
- `count()` --  returns occurrences of substring in string
- `endswith()` -- Checks if String Ends with the Specified Suffix
- `find()` -- Returns the index of first occurrence of substring
- `format()` -- formats string into nicer output
- `index()` -- Returns Index of Substring
- `join()` -- Returns a Concatenated String
- `lower()` -- returns lowercased string
- `upper()` -- returns uppercased string
- `swapcase()` -- swap uppercase characters to lowercase; vice versa
- `strip()` -- Removes Both Leading and Trailing Characters

> There are a lot of methods for strings check them on docs
