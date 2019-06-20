[Part 1](./README.md)

---

# Sending Emails

- Django comes with a ready and easy-to-use light engine to send e-mail. Similar to Python you just need an import of smtplib. In Django you just need to import django.core.mail. To start sending e-mail, edit your project settings.py file and set the following options −
  - `EMAIL_HOST` − smtp server.
  - `EMAIL_HOST_USER` − Login credential for the smtp server.
  - `EMAIL_HOST_PASSWORD` − Password credential for the smtp server.
  - `EMAIL_PORT` − smtp server port.
  - `EMAIL_USE_TLS or _SSL` − True if secure connection
  
- Let's create a "sendSimpleEmail" view to send a simple e-mail.
  ```python
  from django.core.mail import send_mail
  from django.http import HttpResponse
  
  def view(request):
    response = send_mail("title", "content", "from", "to" ...)
    return redner(...)
  ```
  Here is the details ofthe parameters of `send_mail()` :
    - `subject` − E-mail subject.
    - `message` − E-mail body.
    - `from_email` − E-mail from.
    - `recipient_list` − List of receivers’ e-mail address.
    - `fail_silently` − Bool, if false send_mail will raise an exception in case of error.
    - `auth_user` − User login if not set in settings.py.
    - `auth_password` − User password if not set in settings.py.
    - `connection` − E-mail backend.
    - `html_message` − (new in Django 1.7) if present, the e-mail will be multipart/alternative.
    
- You can send multiple mails, send html emails, send attachments ... etc. However I am not going to note all of them since I want to keep the README short. If you want to learn more you can read the official docs or other resrouces

<br>
<br>
<br>

# Generic Views

- In some cases, writing views, as we have seen earlier is really heavy. Imagine you need a static page or a listing page. Django offers an easy way to set those simple views that is called generic views.

  Unlike classic views, generic views are classes not functions. Django offers a set of classes for generic views in django.views.generic, and every generic view is one of those classes or a class that inherits from one of them.

- This is a important topic however as I said before I do not want to complicate the README files they are just for entry points for the note files to come. I will explain this more in depth in my views notes

<br>
<br>
<br>

# Form Processing

- Creating forms in Django, is really similar to creating a model. Here again, we just need to inherit from Django class and the class attributes will be the form fields. Let's add a forms.py file in myapp folder to contain our app forms. Lets see an exapmle:
  ```python
  from django import forms
  
  class LoginForm(forms.Form)
    username = forms.CharField(max_length = 100)
    password = forms.CharField(widget = forms.PasswordInput())
  ```
  As seen above, the field type can take "widget" argument for html rendering; in our case, we want the password to be hidden, not displayed. Many others widget are present in Django: DateInput for dates, CheckboxInput for checkboxes, etc.

### Using Form

- Lets create a login view in our app/views.py:
  ```python
  from app.forms import LoginForm
    
  def login(request):
    username = "unnkown"
    
    if request.method == "POST":
      # get your form
      form = LoginForm(request.POST)
      
      if form.is_valid():
        username = form.cleaned_data['username']
        password = form.cleaned_data['password']
        
        new_user = ModelName(username=username, password=password)
        new_user.save()
      
      else:
        form = LoginForm()
        
    return render(...)
  ```
  You need to create your forms inside your tempaltes and give them names so that the values wont get confused on the post. You also need to filter your form submissions like check weather an same named username exist in the database if it does throw an error etc.
  
- This is a important topic however as I said before I do not want to complicate the README files they are just for entry points for the note files in the future to come. I will explain this more in depth in my views notes

<br>
<br>
<br>

# File Uploading















