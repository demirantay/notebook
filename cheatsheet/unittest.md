# Unittest cheatsheet

### Quick commands

- `$ python -m unittest discover` -- Searches the current directory for any files named test*.py test them.
- `$ python -m unittest test` -- This can also run all of the test but sometimes regex filtering does not work.
- `$ python manage.py test` -- Executes Django Testing framework that is built on top of Unittest
- `$ python -m unittest discover -s tests/unit` -- runs only your unittest in tests/ directory
- `$ python -m unittest discover -s tests/integration` -- runs only your integration in tests/ directory.

### Skeleton of a Test

- This is the skeleton of a test with unittest:
  ```python
  class TestXxx(unittest.TestCase):

      def setUp(self):
          ...

      def tearDown(self):
          ...

      def test_yyy_description1(self):
          ...

      def test_yyy_description2(self):
          ...
  ```

### Basic Assertions

- `assertEqual(a, b)` -- a == b
- `assertNotEqual(a, b)` -- a != b
- `assertTrue(x)` -- bool(x) is True
- `assertFalse(x)` -- bool(x) is False
- `assertIs(a, b)` -- a is b
- `assertIsNot(a, b)` -- a is not b
- `assertIsNone(x)` -- x is None
- `assertIsNotNone(x)` -- x is not None
- `assertIn(a, b)` -- a in b
- `assertNotIn(a, b)` -- a not in b
- `assertGreater(a, b)` -- a > b
- `assertGreaterEqual(a, b)` -- a >= b
- `assertLess(a, b)` -- a < b
- `assertLessEqual(a, b)` -- a <= b

### Intermediate Assertions

- `assertIsInstance(a, b)` -- isinstance(a, b)
- `assertNotIsInstance(a, b)` -- not isinstnace(a, b)
- `assertRaises(exc, fun, args, *kwds)` -- fun(*args, `**kwds`) raises exc
- `assertRaisesRegexp(exc, r, fun, args, *kwds)` -- round(a-b, 7) == 0
- `assertAlmostEqual(a, b)` -- round(a-b, 7) == 0
- `assertNotAlmostEqual(a, b)` -- round(a-b, 7) != 0
- `assertRegexpMatches(s, r)` -- r.search(s)
- `assertNotRegexpMatches(a, b)` -- not r.search(s)
- `assertItemsEqual(a, b)` -- sorted(a) == sorted(b)
- `assertDictContainsSubset(a, b)` -- All the key/value pairs in a exist in b

### Test for expected exception

- ...

### Skipping Tests

- ...


