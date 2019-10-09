# Absolute vs Relative Imports in Python

- Even for Pythonistas with a couple of projects under their belt, imports can be confusing! That is why i taught I should note this topic. Resource: https://realpython.com/absolute-vs-relative-python-imports/

<br>
<br>

# Quick Recap on Imports

- You need to have a good understanding of Python modules and packages to know how imports work. A Python module is a file that has a .py extension, and a Python package is any folder that has modules inside it (or, in Python 2, a folder that contains an __init__.py file). What happens when you have code in one module that needs to access code in another module or package? You `import` it!

### How Imports Work

- But how exactly do imports work? Let’s say you import a module abc like so:
  ```python
  import abc
  ```
  The first thing Python will do is look up the name abc in `sys.modules`. This is a cache of all modules that have been previously imported.
  
  If the name isn’t found in the module cache, Python will proceed to search through a list of built-in modules. These are modules that come pre-installed with Python and can be found in the __Python Standard Library__. If the name still isn’t found in the built-in modules, Python then searches for it in a list of directories defined by `sys.path`. This list usually includes the current directory, which is searched first. If the name is never found, you’ll get a ModuleNotFoundError.

### Syntax of Import Statements 

- Now that you know how import statements work, let’s explore their syntax. You can import both packages and modules. (Note that importing a package essentially imports the package’s `__init__.py` file as a module.) You can also import specific objects from a package or module.

  There are two types of inporting syntax:
  ```python
  import foo                         # imports every code in the module
  from foo import barClass, barFunc  # imports only two objects from the module
  ```
  You can also choose to rename an imported resource, like so:
  ```python
  import foo as other_name
  ```

### Styling of Import Statements

- There are few points from PEP8 to make your imporst look beatiful and readable:
  - 1 - Imports should always be written at the top of the file, after any module comments and docstrings.
  - 2 - Imports should be divided according to what is being imported. There are generally three groups:
    - standard library imports (Python’s built-in modules)
    - related third party imports (modules that are installed and do not belong to the current application)
    - local application imports (modules that belong to the current application)
  - 3 - Each group of imports should be separated by a blank space.
  
- Lets illustrate a good import structure:
  ```python
  """Illustration of good import statement styling.

  Note that the imports come after the docstring.

  """

  # Standard library imports
  import datetime
  import os

  # Third party imports
  from flask import Flask
  from flask_restful import Api
  from flask_sqlalchemy import SQLAlchemy

  # Local application imports
  from local_module import local_class
  from local_package import local_function
  ```
  
<br>
<br>

---

<br>
<bR>

# Absolute Imports

- An absolute import specifies the resource to be imported using its full path from the project’s root folder.

### Sytnax and Practical Examples 

- Let’s say you have the following directory structure:
  ```
  └── project
    ├── package1
    │   ├── module1.py
    │   └── module2.py
    └── package2
        ├── __init__.py
        ├── module3.py
        ├── module4.py
        └── subpackage1
            └── module5.py
  ```
  Let’s assume the following:
  - 1 - package1/module2.py contains a function, function1.
  - 2 - package2/__init__.py contains a class, class1.
  - 3 - package2/subpackage1/module5.py contains a function, function2.
  
  The following are practical examples of absolute imports:
  ```python
  from package1 import module1
  from package1.module2 import function1
  from package2 import class1
  from package2.subpackage1.module5 import function2
  ```
  
### Pros and Cons of Absolute Imports

- Absolute imports are preferred because they are quite clear and straightforward. It is easy to tell exactly where the imported resource is, just by looking at the statement. Additionally, absolute imports remain valid even if the current location of the import statement changes. In fact, PEP 8 explicitly recommends absolute imports.

<br>
<br>

---

<br>
<br>

# Relative Imports

- A relative import specifies the resource to be imported relative to the current location—that is, the location where the import statement is. There are two types of relative imports: implicit and explicit. Implicit relative imports have been deprecated in Python 3, so I won’t be covering them here.

### Syntax and Practical Examples

- The syntax of a relative import depends on the current location as well as the location of the module, package, or object to be imported. Here are a few examples of relative imports:
  ```python
  from .some_module import some_class
  from ..some_package import some_function
  from . import some_class
  ```
  You can see that there is at least one dot in each import statement above. Relative imports make use of dot notation to specify location.
  
  A single dot means that the module or package referenced is in the same directory as the current location. Two dots mean that it is in the parent directory of the current location—that is, the directory above. Three dots mean that it is in the grandparent directory, and so on. This will probably be familiar to you if you use a Unix-like operating system!

### Pros and Cons of Relative Imports

- One clear advantage of relative imports is that they are quite succinct. Depending on the current location, they can turn the ridiculously long import statement to a simple usage, and plus they can climb out of directories. 

  Unfortunately, relative imports can be messy, particularly for shared projects where directory structure is likely to change. Relative imports are also not as readable as absolute ones, and it’s not easy to tell the location of the imported resources.



