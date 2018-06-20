## Best Practices and Standarts for Python

- Many projects and languages have their own coding style that you need to adapt. PEP8 is the standart guideline for plain ol' python. PEP 257 is for (Docstring Conventons). In the event of a style conflict the projects coding style always get the preference remember that. You can downlaoad style correcters for each language for exmaple for python use flake8.

- *"Any fool can write code that a computer can understand. Good programmers write code that humans can understand"*. Martin Fowler, 2008

- Sometimes style guidelines are not applicable to your project. In that case use your best judgement. For example while dealing with legacy code and backwards compablity old versions of the language are not as felixable as the new ones so do not try to impelemtn guidelines to that cases you may break the code.

- Remember the `max length` for PEP8 is 80 characters. Here are some examples with explanations:
  ```python
  # Always use `4 Spcases` of indentation

  # A function that has a too long name and many parameters
  def long_function_name(var_one, var_two,
                         var_three, var_four):
                         
  # or when you assign a long func to a var
  foo = long_function_name(
      var_one, var_two,
      var_three, var_four)
  ```
  No, do NOT do the following:
  ```python
  # Do not use parameters on the first line if
  # you are going to use a break
  foo = long_function_name(var_one, var_two,
      var_three, var_four):
  ```
  
- While writing if statements with too long control flows you can write them like this:
    ```python
     if (this_is_one_thing and
      that_is_another_thing):
      do_something()

     # Or you can write it like this

     # Add some extra indentation on the conditional continuation line.
     if (this_is_one_thing
          and that_is_another_thing):
      do_something()
    ```
    
- You can write long lists (arrays) like the following: 
   ```python
   my_list = [
       1, 2, 3,
       4, 5, 6,
       7, 8, 9,
   ]
   ```
   
- TABS VS. SPACES? **Spaces** are preffered in identation. Sure you can use tabs if you set the spaces of it to 4

- Single `import`s should be on different lines not one
  ```python
  # Yes
  import os
  import sys
  
  # No
  import os, sys
  
  # This is okay 
  from foo import bar, blah, meh, grep
  ```
  
- There are many more pep8 conventions it is too long to take notes from the documentation so if you have more questions refer to the [OFFICIAL DOCUMENTATION](https://www.python.org/dev/peps/pep-0008/)
