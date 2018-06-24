## Testing Python Code

- Testing in python can be done writing your own test code however using packages makes this process a lot easier. There arae many option of packages for testing in python however the best one is `unittest` so that is what we will use.

- Basic usage of unittest is in the following code and will explain what each does below the snippet:
  ```python
  # root/test.py
  
  import unittest
  from my_module import foo_function
  
  class TestFoo(unittest.TestCase):
      def setUp(self):
          # Setup run before every test method
          pass
      
      def tearDown(self):
          # Clean up run after every test method
          pass
          
      def test_if_function_returns_hello_world(self):
          self.assertEqual(foo_function(), "Hello, World!")   
  ```
  Firstly we import the unittest package and import the methods(functionality) of  your code that you would like to test.
  
  After that you can see that we define class that inherits `unittest.TestCase`, every test you write should be in a class that has a base of either (TestCase, SimpleTestCase, TransactionTestCase ..etc.) however the best one is TestCase and for starters you do not need any other inheritance. Try to create at least one test class for each module that you have in that way you can be more organised since you will probably define a `setUp` and you dont want different modules databases to be in conflict in one giant test class.
  
  `setUp()` is a function where you will add the necessary background code for the functionality of your feature. For example, Database qureies, lets say that you want to test something on a particular user object in a website built with django in `setUp` you have to create a user `User.objects.creat(username='test' ..)` because every test class creates a new database at each run and `tearDown`s the database after the test run is completed.
  
  After you setup everything you have your testing functions. Every testing function should test something specific and start with `test_...`, Tests use .assert() methods to test that that expression result in True or False values. The test methods are run independetly with common setup or tear down behavior that you define in the class.
  
- You can simply run the test like the following
  ```bash
  $ python test.py
  ```
  
- The amount of your tests can quickly get out of hand and that is why most people have tests for each module in seperate files on a directory called `tests` in order to run the whole directory you can simply $touch a `__init__.py` file to define the directory as a package and put `test` word in front of every test file like `test_forms.py`. There are more to this will add on later ...


*Testing is a lot more and a lot harder topic than this simple introduction please visit the following docs for more info:*
- [The List of Assert Methods](https://docs.python.org/3/library/unittest.html#assert-methods)
- [unittest Docs](https://docs.python.org/3/library/unittest.html)
- ...
  
