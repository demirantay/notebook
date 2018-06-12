## pip

- It is very easy to use pip pacakage manager to install python packages
  ```bash
  $ pip install PackageName         # Latest Version
  $ pip install PackageName==1.0.4  # Specific version
  ```
<br>

- You can define requirements.txt files in your projects so that the users will know what dependencies are needed for the particular project. Lets assume you have a project that uses django and pillow you should put them in your requriement folder as this:
  ```txt
  Django==2.0.1
  pillow==5.0.0
  ```
  And instead of pip installing everything manually you can simply install every dependacny like this:
  ```bash
  $ pip install -r requirements.txt
  ```
<br>

- You can view all of your installed python pacakages with the following line:
  ```bash
  $ pip list
  Jinja (2.5)
  Django (2.0.0)
  ```
  To list your outdated packages and show the latest version aviable use :
  ```bash
  pip list --outdated
  Jinja2 (current:0.9.1 Latest: 2.0.0)
  ```
  To show the details of a package use :
  ```bash
  $ pip show Django
  ---
  Name: Django
  Version: 2.0.1
  Location: ..
  Requires: Jinja2 ..etc.
  ...
  ```
<br>

- After a while you will realise tht you have downloaded too many packages and they started to cause conflict between one another. To fix this python uses virtualenvs which are python copies for each project. You create a virtual env for each project install dependincies finish your job delete the python and your original python will not get effected as if nothing has happened
  ```bash
  $ virtualenv venv  # creates a virtualenv named venv
  ```
  To use everything we have learned above simply use this 
  ```bash
  $ venv/bin/pip install Django
  $ venv/bin/pip list
  ...
  ```
<br>

- Will add later on ...
