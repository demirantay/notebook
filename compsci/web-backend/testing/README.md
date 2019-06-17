# Testing with Python

- Testing in Python is a huge topic and can come with a lot of complexity, but it doesn’t need to be hard. You can get started creating simple tests for your application in a few easy steps and then build on it from there.

<br>
<br>
<br>

## Testing your code
 
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

## Writing Your First Tests

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

## Executing your First Tests


