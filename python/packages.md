## Packaging Python Projects

- Modules are files that contain classes and functions that can be reused in your main code.

<br>

- Packages are a way of structuring Python's module namespace by using 'dotted module names'. For example module `A.B` designates a submodule named `B` in a package named `A`. The use of the dotted module names saves the authors of multi-module packages like NumPy and Pillow from having to worry about each others module names. Look at the example file tree below:
  ```
  example_package/                   # Top-level pacakage
          __init__.py                # initialize the exmaple_package
          sub_package_1/             # Sub package that contains different modules
              __init__.py
              module_1.py
              module_2.py
              module_3.py
              ...
          sub_package_2/             # Sub package that contains different modules
              __init__.py
              module_1.py
              module_2.py
              module_3.py
              ... 
          sub_package_3/              # Sub package that contains different modules
              __init__.py
              module_2.py
              ...
  ```
  The `__init__.py` files are required to make Python treat the directories as containing packages. In the simplest case `__init__.py` file can be a empty file. But it can also execute initilazation code for the package and much more it is beyond the scope for now I will take laters about that later on.
  
  Users of the package can import individual modules from the package above like this:
  ```python
  from example_package.sub_package_1 import module_3
  ```
  OR
  ```python  
  import example_package.sub_package_1.module_3
  ```
  
  You cannot `from sub_package import *` because in order to do that you have to define a `__all__` in `__init__.py`. In order to give variables or function names to `__all__` you must do the following in` __init__.py` file:
  ```python
  __all__ = ['func_name', 'foo_func', bar_func']
  ```
  
<br>

### A Simple Example Project

I will code a very simple example package so that it will give you an idea what to expect from it. First lets initlize our top-level directory :
  ```
  example_package/
      __init__.py
      sub_package/
          __init__.py 
  ```
also do not forget to add a name `name="example_package` in your `__init__.py` file. After completing that you will need to create handful of files to to package up this project and prepare it for distrubition. Craete the files listed below:
  ```
  example_package/
      __init__.py
      sub_package/
         ...
       setup.py
       LICENSE
       README.md
  ``` 
Lets break down what each file means.

#### Setup.py

