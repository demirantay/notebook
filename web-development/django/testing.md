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

Often you will add a test class for each model/form/view you would like to test, with individual methods for testing specific functionality

Add the test class below to the bottom of the file. The class demonstrates how to construct a test case class by deriving from `TestCase`.

```python
class YourTestClassName(TestCase):
    
    @classmethod
    def setUpTestData(cls):
        print("setUpTestData: Run once to set up non-modified data for all class methods.")
        pass
        
     def setUp(self):
        print("setUp: Run once for every test method to setup clean data.")
        pass
        
     def test_false_is_false(self):
        print("Method: test_false_is_false.")
        self.assertFalse(False)
        
     def test_false_is_true(self):
        print("Method: test_false_is_true.")
        self.assertTrue(False)
        
     def test_one_plus_one_equals_two(self):
        print("Method: test_one_plus_one_equals_two.")
        self.assertEqual(1 + 1, 2)
```

The new class defines two methods that you can use for pre-test configuration (for example to create any models or other objects you will use need for the test methods to use)

- `setUpTestData()`: is called once in the begining of the test run for class level set-up. You would use this for the objects that are not going to be changed or modified in the test methods. (DO NOT USE THIS IF YOU DO NOT HAVE TO)

- `setUp()` : is called before every test function to set up any objects that may be modified by the test (every function will get a fresh new setUp objects

*Note : test classes also have a `tearDown()` method which we havent used. This method isn't particularly useful for database tests, since the TestCase base class takes care of database teardown for you.*

Below those we have number of test methods which use `Assert` functions to test weather conditions are true , false or equal (`AssertTrue`, `AssertFalse`, `AssertEqual`) If the condition does not evaluate as expected it than the test will fail and report the error to your console.

The `AssertTrue`, `AssertFalse`, `AssertEqual` are standart assertions provided by **unittest** There are other specific test [assertions](https://docs.djangoproject.com/en/2.0/topics/testing/tools/#assertions).

*Note: The code above is just for examplary of using nearly everything needed in a `foo` explainatory way below you can see another example which is more down to earth and close to what we do on daily to day basis. Lets assume that we already created a `Animal` model*

```python
from django.test import TestCase
from myapp.models import Animal

class AnimalTestCase(TestCase):
    
    def setUp(self):
        Animal.objects.create(name="lion", sound="roar")
        Animal.objects.create(name="cat", sound="meow")
        
    def test_animals_can_speak(self):
        """ Animals that can speak are correctly identified"""
        lion = Animal.objects.get(name="lion")
        cat = Animal.objects.get(name="cat")
        self.AssertEqual(lion.speak(), 'the lion says "roar" ')
        self.assertEqual(cat.speak(), 'The cat says "meow"')
```

## How To Run Tests

The easiest way to run all the tests is this command: 
```
$ python3 manage.py test
```

This will discover all files names start with `test*.py` under the current directory and run all tests. By default the tests will individually report on failures followed by test summary and nothing more.

*Note: If you get a  ValueError: Missing staticfiles manifest entry ... this may be because testing does not run collectstatic by default and your app is using a storage class that requires it. To overcome this problem simply run: *

```
$ python manage.py collectstatic
```

### Showing more test information

If you want to get mroe information about your tests other than just the fails you can change the default level of verboisty as the following:

```
$ python manage.py test --verbosity 2
```
The allowed verbosity levels are 0, 1, 2, 3 with the default being == 1

### Running specific tests

You can specific tasks by the following method:
```
$ python manage.py test app_name.tests
 
 or
 
 $ python mange.py test app_name.tests.test_models
```
 
 # Testing a View
 
When we tested our application above we fixed the code if there was a error in the test. In fact this was a simple example of Test-Driven-Development. But it doesnt really matter in which order we do the work.

In our first test we focused on the internal parts of our django app such as the models inside it. For this test want to check its behaviour as it would be experienced by a user through a web browser

Lets look at the necessary tools at our disposal :

## Django test Client

Django provides a test [Client](https://docs.djangoproject.com/en/2.0/topics/testing/tools/#django.test.Client) to simulate a user interacting with the code at view level. 

Lets assume that you have a very basic view and we will write a view test for it below:

```python
...
from django.test import TestCase
from django.urls import reverse


class TestFooView(TestCase):

  def setUp(self):
    # create Objects if you want to use them while testing
    test_user = User.objects.craete(username='test_user', password='123
    
  def test_view_exists_at_desired_location(self):
    response = self.client.get('/app_url/view_url')
    self.assertEqual(response.status_code, 200)
    
  def test_view_is_accessible_by_name(self):
    response = self.client.get(reverse("view_name"))
    self.asssertEqual(response.status_code, 200)
    
  def test_view_uses_correct_template(self):
    response = self.client.get(reverse('view_name'))
    self.assertEqual(response.status_code, 200)
    self.assertTemplateUsed(response, 'name.html')  

```
 
 The test itself is self explainatory but you should definetly definetly definetly X 100 check out the .client() package because it consists a lot of great things that goes along with the assert packages. To give an example you can check the context vars and all other stuff :
 
 ```python
 ...
 response = self.get(reverse('view_name'))
 self.assertTrue('var_name' in response.context)
 self.assertTrue(response.context['example_user_list'] == 100)
 ```
 
### Views that are restricted to logged in users

In some cases you will want to test views that is just restricted to logged in users. 

```python
from django.contrib.auth.models import User

class TestViewWithLogginIn(TestCase):
  
  def setUp(self):
    # Create users
    test_user1 = User.objects.create(username='test_user1, password='123')
    
  def test_logged_in_uses_correct_template(self):
    login = self.client.login(username='test_user1, password='123')
    response = self.client.get(reverse('view_name')
    
    # Check our user is logged in
    self.assertEqual(str(response.context['user']), 'test_user1')
    # Check we got a response succsess
    self.assertEqual(response.status_code, 200)
    
```

You can also pass kwarg arguments from urls to views on test cases such as these :

```python 
...

class TestFooView(TestCase):
    
    def setUp(self):
        test_user = User.objects.create(username='test_user', password='123')
        
    def test_foo_kwargs(self):
        response = self.client.get(reverse('view_name', kwargs={'pk': self.test_user.id}))
        self.assertEqual(response.status_code, 200)

```

#### Testing view forms

Forms have alot of checking needs to be done so you should definelty check the `client()` docuemntation for it but lets give some examples

First you would like to hcek the inital values maybe :
```python
...

class TestViewWithForm(TestCase):
  ...
  
  def test_form(self):
    response = self.client.get(reverse('view_name')
    self.assertEqual(response.context['form'].initial['form_input_name'], None)

```
Or you can check the clients `POST` method to test the form submissions, but definetly check the documents the tutorial that i am following does not go in depth.

.... Check other documents for POST


## For further reading

- [Django testing docs](https://docs.djangoproject.com/en/2.0/topics/testing/overview/)
- [A workshop for testing in django](http://test-driven-django-development.readthedocs.io/en/latest/index.html)
- [Blog about testing in django](https://developer.mozilla.org/en-US/docs/Learn/Server-side/Django/Testing)




