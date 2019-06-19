# Testing with Python

- Testing in Python is a huge topic and can come with a lot of complexity, but it doesn’t need to be hard. You can get started creating simple tests for your application in a few easy steps and then build on it from there.

<br>
<br>
<br>

# Testing your code
 
- There are many ways to test your code. In this tutorial, you’ll learn the techniques from the most basic steps and work towards advanced methods.

### Automated vs. Manual testing 

- Did you check the features and experiment using them? That’s known as `exploratory testing` and is a form of manual testing. Exploratory testing is a form of testing that is done without a plan. In an exploratory test, you’re just exploring the application.

- To have a complete set of manual tests, all you need to do is make a list of all the features your application has, the different types of input it can accept, and the expected results. Now, every time you make a change to your code, you need to go through every single item on that list and check it.

- This is where automated testing comes in. Automated testing is the execution of your test plan (the parts of your application you want to test, the order in which you want to test them, and the expected responses) by a script instead of a human. Python already comes with a set of tools and libraries to help you create automated tests for your application. e.g. unittest, integration test

### Unit tests vs. Integration tests

- A major challenge with `integration testing` is when an integration test doesn’t give the right result. It’s very hard to diagnose the issue without being able to isolate which part of the system is failing. If the lights didn’t turn on, then maybe the bulbs are broken. Is the battery dead? What about the alternator? Is the car’s computer failing? If you have a fancy modern car, it will tell you when your light bulbs have gone. It does this using a form of `unit test`.

- A unit test is a smaller test, one that checks that a single component operates in the right way. A unit test helps you to isolate what is broken in your application and fix it faster.

- Lets write a very basic `test case` for our imaginary `sum()` function first we will need to create a file wtih the `test_filename` in the prefix:
  ```python
  def test_sum():
    assert sum(1, 5) == 6, "should be 6"
    
  if __name__ == "__main__":
    test_sum()
    print("everything passed")
  ```
  Writing tests in this way is okay for a simple check, but what if more than one fails? This is where test runners come in. The test runner is a special application designed for running tests, checking the output, and giving you tools for debugging and diagnosing tests and applications.
  
### Choosing a Test runner

- There are many test runners available for Python. The one built into the Python standard library is called `unittest`. In this tutorial, you will be using `unittest test cases` and the `unittest test runner`. The principles of unittest are easily portable to other frameworks

- `unittest` contains both a testing framework and a test runner. `unittest` has some important requirements for writing and executing tests. `unittest` requires:
  - You put your tests into classes as methods
  - You use a series of special assertion methods in the unittest.TestCase class instead of the built-in assert statement

- Do you remember the `sum()` function test we have written above without using any test runners ? lets convert the code into a `unittest`. (remember while writing unittest your test function names needs to descriptive in order to know where to look if there is an error:
  ```python
  import unittest
  
  class TestSum(unittest.TestCase):
    
    def test_sum_if_it_is_equal_to_six(self):
      self.assertEqual(sum(1, 5), 6)
      
  if __name__ == "__main__":
    unittest.main()
  ```
  
- In order to run unittest there are many path ways to discover however the most easiest way for python is with this go to your base/root/parent folder of the project and run:
  ```
  $ python -m unittest discover
  ```
  
- There are other test runners too like `nose`, `pytest` ... however do not use them if you do not feel that comfortable with testing, unittest is tailored for basic and advanced work. Most of the commercial or open source software uses it. 

<br>
<br>
<br>

# Writing Your First Tests

- It is usually common practice to establish a folder called `tests/` in the parent directory and place all of your test files in there. It is ordered to ensure each file starts with `test_<name>` so all test runners will assume that Python file contains tests to be executed. Some very large projects split tests into more subdirectories based on their purpose or usage.

### How to structure a simple test

- Before you dive into writing tests, you’ll want to first make a couple of decisions:
  - What do you want to test?
  - Are you writing a unit test or an integration test?
  Remember while tsting do not test third party apps since those pacakges or the languages you use are already tested many times before reaching your hands
  
### How to write assertions

- The last step of writing a test is to validate the output against a known response. This is known as an `assertion`. There are some general best practices around how to write assertion. Make sure tests are repeatable and run your test multiple times to make sure it gives the same result every time

- unittest comes with lots of methods to assert on the values, types, and existence of variables. Here are some of the most commonly used methods:
  - `.assertEqual(a, b)` is equivelent to `a == b`
  - `.assertTrue(x)` is equivalent to `bool(x) is True`
  - `.assertFalse(x)` is equivalent to `bool(x) is False`
  - `.assertIs(a, b)` is equivalent to `a is b`
  - `.assertIsNone(x)` is equivalent to `	x is None`
  - `.assertIn(a, b)` is equivalent to `	a in b`
  - `.assertIsInstance(a, b)` is equivalent to `	isinstance(a, b)`
  
  .assertIs(), .assertIsNone(), .assertIn(), and .assertIsInstance() all have opposite methods, named .assertIsNot(), and so forth.

<br>
<br>
<br>

# Executing your First Tests

- Now that you’ve created the first test, you want to execute it. Sure, you know it’s going to pass, but before you create more complex tests, you should check that you can execute the tests successfully.

- The Python application that executes your test code, checks the assertions, and gives you test results in your console is called the `test runner`.

- At the bottom of test.py, you added this small snippet of code:
  ```python
  if __name__ == '__main__':
     unittest.main()
  ``` 
  This is a command line entry point. It means that if you execute the script alone by running python test.py at the command line, it will call unittest.main(). This executes the test runner by discovering all classes in this file that inherit from unittest.TestCase.
  
- This is one of many ways to execute the unittest test runner. When you have a single test file named `test.py`, calling `$ python test.py` is a great way to get started.

  Another way is using the unittest command line. Try this:
  ```
  $ python -m unittest test
  ```
  You can provide additional options to change the output. One of those is -v for verbose for making the test output more elegant ... etc. check the docs for more info on unittest command line arguments 
  
- Instead of providing the name of a module containing tests, you can request an auto-discovery using the following:
  ```
  $ python -m unittest discover
  ```
  This will search the current directory for any files named `test*.py` and attempt to test them. **This is one of the most commonly used ones since it j=discovers the tests without you needing to lift your finger**. There are much more to learn about `discover` cmd argument, however since I want to keep the readme.md short you should check out the official documentation for more information.
  
  
<br>
<br>
<br>

# Testing for Web Frameworks like Django

- If you’re writing tests for a web application using one of the popular frameworks like Django or Flask, there are some important differences in the way you write and run the tests.

- Think of all the code you’re going to be testing in a web application. The routes, views, and models all require lots of imports and knowledge about the frameworks being used. This is similar to the car test at the beginning of the tutorial: you have to start up the car’s computer before you can run a simple test like checking the lights. Django and Flask both make this easy for you by providing a test framework based on unittest.

### How to use it in Django

- The Django startapp template will have created a tests.py file inside your application directory. If you don’t have that already, you can create it with the following contents:
  ```python
  from django.test import TestCase

  class MyTestCase(TestCase):
      # Your test methods
  ```
  The major difference with the examples so far is that you need to inherit from the django.test.TestCase instead of unittest.TestCase. These classes have the same API, but the Django TestCase class sets up all the required state to test.
  
  To execute your test suite, instead of using unittest at the command line, you use manage.py test:
  ```
  $ python manage.py test
  ```
  
- If you want multiple test files, replace tests.py with a folder called tests, insert an empty file inside called __init__.py, and create your test_*.py files. Django will discover and execute these.

- More information:
  - https://docs.djangoproject.com/en/2.1/topics/testing/overview/
  - or just go to my django folder on this digital noteboo. Therea re notes on how to test django apps.

<br>
<br>
<br>

# More Advanced Testing Senarios

- Before you step into creating tests for your application, remember the three basic steps of every test:
  - Create your inputs
  - Execute the code, capturing the output
  - Compare the output with an expected result

- It’s not always as easy as creating a static value for the input like a string or a number. Sometimes, your application will require an instance of a class or a context. What do you do then?

- The data that you create as an input is known as a fixture. It’s common practice to create `fixtures` and reuse them.

- If you’re running the same test and passing different values each time and expecting the same result, this is known as `parameterization`.

### Isolating behaviors in your application

- Earlier in the tutorial, you learned what a side effect is. Side effects make unit testing harder since, each time a test is run, it might give a different result, or even worse, one test could impact the state of the application and cause another test to fail!

- There are some simple techniques you can use to test parts of your application that have many side effects:
  - Mocking out any method or function calls to remove side effects (mocking is long to write find other resoruce to learn it)
  - Using integration testing instead of unit testing for this piece of the application

### Integration tests

- So far, you’ve been learning mainly about unit testing. Unit testing is a great way to build predictable and stable code. But at the end of the day, your application needs to work when it starts!

- Integration testing is the testing of multiple components of the application to check that they work together. Integration testing might require acting like a consumer or user of the application by:
  - Calling an HTTP REST API
  - Calling a Python API
  - Calling a web service
  - Running a command line
  
- Each of these types of integration tests can be written in the same way as a unit test, following the Input, Execute, and Assert pattern. The most significant difference is that integration tests are checking more components at once and therefore will have more side effects than a unit test. Also, integration tests will require more fixtures to be in place, like a database, a network socket, or a configuration file.

- This is why it’s good practice to separate your unit tests and your integration tests. The creation of fixtures required for an integration like a test database and the test cases themselves often take a lot longer to execute than unit tests, so you may only want to run integration tests before you push to production instead of once on every commit.

- A simple way to separate unit and integration tests is simply to put them in different folders:
  ```
  tests/
    |_ unit/
    |     __init__.py
    |
    |_ integration/
    |     __init__.py
  ```
  There are many ways to execute only a select group of tests. The specify source directory flag, -s, can be added to unittest discover with the path containing the tests:
  ```
  $ python -m unittest discover -s tests/integration
  ```
  
### Testing data driven applications
 
- Many integration tests will require backend data like a database to exist with certain values. For example, you might want to have a test that checks that the application displays correctly with more than 100 customers in the database, or the order page works even if the product names are displayed in Japanese.

- A good technique to use is to store the test data in a folder within your integration testing folder called fixtures to indicate that it contains test data. Then, within your tests, you can load the data and run the test. Within your test case, you can use the .setUp() method to load the test data from a fixture file in a known path and execute many tests against that test data.

---

- I cannot simply tell all of the advanced parts of testing. You should chechk books, documentation, turorials TDD principles and all of that ...

<br>
<br>
<br>

# Testing in Multiple Environments

- So far, you’ve been testing against a single version of Python using a virtual environment with a specific set of dependencies. You might want to check that your application works on multiple versions of Python, or multiple versions of a package. Tox is an application that automates testing in multiple environments.

- Tox is available on PyPI as a package to install via pip:
  ```
  $ pip install tox
  ```
  
- After you install `tox` you need to configure it write it and then run it.I am not going to note about tox at the moment since it would take too much space. I just wanted to note that `tox` is the dependecny that tests weather your app works in every version. Check its documentation for more info.

<br>
<br>
<br>

# Automating the Execution of Your Tests

- So far, you have been executing the tests manually by running a command. There are some tools for executing tests automatically when you make changes and commit them to a source-control repository like Git. Automated testing tools are often known as CI/CD tools, which stands for “Continuous Integration/Continuous Deployment.” They can run your tests, compile and publish any applications, and even deploy them into production.

- There are many ci/cd tools so I am not going to note about each one of them in this file. You should check their own documentation and learn about ci/cd here.



