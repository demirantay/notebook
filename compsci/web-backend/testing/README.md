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



<br>
<br>
<br>

## Writing Your First Tests

### Where to Write the tests
