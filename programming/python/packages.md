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

`setup.py` is the build script for [setuptools](https://packaging.python.org/key_projects/#setuptools). It tells the setuptools about your package(such as name and versions).

setup.py
```python
import setuptools

with open("README.md", "r") as fh:
    long_description = fh.read()

setuptools.setup(
    name="example_pkg",
    version="0.0.1",
    author="Example Author",
    author_email="author@example.com",
    description="A small example package",
    long_description=long_description,
    long_description_content_type="text/markdown",
    url="https://github.com/pypa/example-project",
    packages=setuptools.find_packages(),
    classifiers=(
        "Programming Language :: Python :: 3",
        "License :: OSI Approved :: MIT License",
        "Operating System :: OS Independent",
    ),
)
```
Setuptools get lots of setup arguments this is like the most simple way of writing setup. You should definetly check out for official documentation regarding setup arguments. It is important that you write a good setup. For more [see here](https://packaging.python.org/guides/distributing-packages-using-setuptools/)

P.S. the name you define should not be taken in pypi.org

Next step is ...

#### Generating Distibution Archives

The next step is to generate [distrubiton packages](https://packaging.python.org/glossary/#term-distribution-package) for the package. hese are archives that are uploaded to the Package Index and can be installed by pip.

Make sure you have the latest version of `setuptools` and `wheel` installed.
```bash
$ python3 -m pip install --user -upgrade setuptools wheel
```
Now run this command from the same directory where setup.py is located:
```bash
$ python3 setup.py sdist bdist_wheel
```
This command should output a lot of text and once completed should generate two files in the `dist` directory:
```
dist/
  example_package-0.0.1-py3-none-any.whl
  example_package-0.0.1.tar.gz
```
The `tar.gz` file is a [source archive](https://packaging.python.org/glossary/#term-source-archive) whereas the `.wh`l file is a [built distribution](https://packaging.python.org/glossary/#term-built-distribution). Newer pip versions preferentially install built distributions, but will fall back to source archives if needed. You should always upload a source archive and provide built archives for the platforms your project is compatible with. In this case, our example package is compatible with Python on any platform so only one built distribution is needed.

#### Uplodaing the Distrubtion Archives

Finally, it’s time to upload your package to the Python Package Index!

Now that you are registered to PyPi, you can use `twine` to upload the distribution packages. You’ll need to install Twine:
```bash 
pip install twine
```
Once installed, run Twine to upload all of the archives under `dist`:
```bash
$ twine upload dist/*
```
You will be prompted for the username and password you registered with  PyPI.

#### Updating your package

If you want to update or fix some bug in your package you always have to change your version, generate distro archive files with `..setup.py sdist bdist_wheel`, git push, and finally twine upload it. 

There are many more tweaks for upgrading i did not understand it at the moment... go back later on.
