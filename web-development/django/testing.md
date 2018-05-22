# Testing in Django

Testing can be a time consuming task. Weather it is automated or manual when your site grows the code you have written will be connected and each addition, update, deletion to your codebase will effect some parts you didnt even think about. In order to eliminate that we run tests and as you can imageine it is really time consuming to test everything by hand so thats why we need to learn automated testing.

## Types of testing

There ar enumerous ways of approaching testing but thgese are the most important three:

- `Unit tests` : Verify functional behavior of individual components, often to class and function level

- `Regression tests` : Tests that reproduce historic bugs. Each test is intially run to verify that the bug has been fixed,
and the re-run to ensure that it has not been reintroudced following later changes to the code.

- `Integration tests` : Verify how grouping of compononents work together. Integration tests are aware of the required interactions between compononents, but not necessarily of the internal operations of each component. They may cover the simple groupings of comoponents through the whole website.

*Note: Other common types of tests include black box, white box, manual, automated, canary, smoke, conformance, acceptance, functional, system, performance, load, and stress tests. Look them up for more information.*

## What does django provide for testing ?

Testing a website is a complex task, because it is made of several layers of logic - from HTTP-level request handling, queries, models, to form validation and processing and template rendering. 

Luckily django provides us a testing framework that build on to the [unittest](https://docs.python.org/3/library/unittest.html#module-unittest) python module despite the name the module can do nearly every testing type, such as unit, integration, regression ... etc.

To write a test you choose from any of the django test base classes ([SimpleTestCase](https://docs.djangoproject.com/en/2.0/topics/testing/tools/#simpletestcase), [TransactionTestCase](https://docs.djangoproject.com/en/2.0/topics/testing/tools/#transactiontestcase), [TestCase](https://docs.djangoproject.com/en/2.0/topics/testing/tools/#testcase), [LiveServerTestCase](https://docs.djangoproject.com/en/2.0/topics/testing/tools/#liveservertestcase)) and then write seperate methods to check that specific functionality works as expected.

Tests use `.assert()` methods to test that that expression result in True or False values. The test methods are run independetly with common setup or tear down behavior that you define in the class.

You dont have to understand it fully it is just an exmaple below:
```python
class YourTestClass(TestCase):

    def setUp(self):
      # Setup run before every test method
      pass
      
    def tearDown(self):
      # Clean up run after every test method
      pass
      
    def test_something_that_will_pass(self):
      self.assertFalse(False)
      
    def test_something_that_will_fail(self):
      self.assertTrue(False)
```

*Note: The django.test.TestCase class if very convetional and probably the best test case class for most of the tests*

## What should you test ?

You should code all aspects of your code but not the functinality that is provided by django , python or other 3rd party libraries they are tested on their own code base.

lets take this model class as an exmaple:
```python
# app/models.py

class Author(models.Model):
    first_name = models.CharField(max_length=100)
    last_name = models.CharField(max_length=100)
    date_of_birth = models.DateField(null=True, blank=True)
    date_of_death = models.DateField('Died', null=True, blank=True)
    
    def get_absolute_url(self):
        return reverse('author-detail', args=[str(self.id)])
    
    def __str__(self):
        return '%s, %s' % (self.last_name, self.first_name)
```

So lets examine this code, you do not need to expicitly test if the `first_name` cointains a `.CharField()` because char field is a method that is provided to us by django.

However we can test if our own defined functions such as `get_Absolute_url` or `__str__` becuase we define what will be the optput of the code.

## Test Structure Overview

Before we go into detail of "what to test" lets first briefly look where and how tests are defined.

Django uses the unittests which  will discover tests under the current working directory in any file named with the pattern `test*.py`

We recommend that you create a module for your test code, and have separate files for models, views, forms, and any other types of code you need to test. For example:

```
app_name/
  /tests/
    __init__.py
    test_models.py
    test_forms.py
    test_views.py
```
The __init__.py should be an empty file (this tells Python that the directory is a package). You can create the three test files by copying and renaming the skeleton test file /app_name/tests.py.

*Note: When you create a skeleton app you will have an already includede tests.py file you can write all of your tests in it there is nothing wrong with that but soon your tests will get out of hand so it is better to delete the file and include a tests directory.*

Open `app_name/tests/test_models.py`, all of your test files should import `django.test.TestCase` as shown:
```python
from django.test import TestCase

# Create your tests here
```

