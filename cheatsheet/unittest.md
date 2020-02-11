# Unittest cheatsheet

### Quick commands

- `$ python -m unittest discover` -- Searches the current directory for any files named test*.py test them.
- `$ python -m unittest test` -- This can also run all of the test but sometimes regex filtering does not work.
- `$ python manage.py test` -- Executes Django Testing framework that is built on top of Unittest
- `$ python -m unittest discover -s tests/unit` -- runs only your unittest in tests/ directory
- `$ python -m unittest discover -s tests/integration` -- runs only your integration in tests/ directory.

### Assertions

- `a`
