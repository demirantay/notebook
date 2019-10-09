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

### Styling of Import Statements

<br>
<br>

---

<br>
<bR>

# Absolute Imports

### Sytnax and Practical Examples 

### Pros and Cons of Absolute Imports


<br>
<br>

---

<br>
<br>

# Relative Imports

### Syntax and Practical Examples

### Pros and Cons of Relative Imports

