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

- It is generally useful for a web app to be able to upload files (profile picture, songs, pdf, words.....). Let's discuss how to upload files in this chapter.

- You can use the PIL ajdnuse a `ImageField` on your forms and models. Now let's create a "Profile" model to save our uploaded profile. This is done in myapp/models.py −
  ```python
  class Profile(models.Model):
   name = models.CharField(max_length = 50)
   picture = models.ImageField(upload_to = 'pictures')
  ```
  As you can see for the model, the ImageField takes a compulsory argument: `upload_to`. This represents the place on the hard drive where your images will be saved. Note that the parameter will be added to the MEDIA_ROOT option defined in your settings.py file.

<br>
<br>

# Cookies Handling

- Sometimes you might want to store some data on a per-site-visitor basis as per the requirements of your web application. Always keep in mind, that cookies are saved on the client side and depending on your client browser security level, setting cookies can at times work and at times might not.

  Cookies are set thorugh `.set_cookie()` functionality, and it is called on the response and not on the request object:
  ```python 
  def login(request):
   username = "not logged in"
   
   if request.method == "POST":
      #Get the posted form
      MyLoginForm = LoginForm(request.POST)
   
   if MyLoginForm.is_valid():
      username = MyLoginForm.cleaned_data['username']
   else:
      MyLoginForm = LoginForm()
   
   response = render_to_response(request, 'loggedin.html', {"username" : username}, 
      context_instance = RequestContext(request))
   
   response.set_cookie('last_connection', datetime.datetime.now())
   response.set_cookie('username', datetime.datetime.now())
	
   return response
  ```

<br>
<br>

# Sessions

- As discussed earlier, we can use client side cookies to store a lot of useful data for the web app. We have seen before that we can use client side cookies to store various data useful for our web app. This leads to lot of security holes depending on the importance of the data you want to save.

  For security reasons, Django has a session framework for cookies handling. Sessions are used to abstract the receiving and sending of cookies, data is saved on server side (like in database), and the client side cookie just has a session ID for identification. Sessions are also useful to avoid cases where the user browser is set to ‘not accept’ cookies.
  
  In Django, enabling session is done in your project settings.py, by adding some lines to the MIDDLEWARE_CLASSES and the INSTALLED_APPS options:
  ```python
  # middle ware
  'django.contrib.sessions.middleware.SessionMiddleware'
  ```
  and add this to installed_apps:
  ```python
  'django.contrib.sessions'
  ```
  By default, Django saves session information in database (django_session table or collection), but you can configure the engine to store information using other ways like: in `file` or in `cache`
  
  When session is enabled, every request (first argument of any view in Django) has a session (dict) attribute.
  
  Let's create a simple sample to see how to create and save sessions:
  ```python
  def login(request):
   username = 'not logged in'
   
   if request.method == 'POST':
      MyLoginForm = LoginForm(request.POST)
      
      if MyLoginForm.is_valid():
         username = MyLoginForm.cleaned_data['username']
         request.session['username'] = username
      else:
         MyLoginForm = LoginForm()
			
   return render(request, 'loggedin.html', {"username" : username}
  ```
  Then let us create formView view for the login form, where we won’t display the form if cookie is set −
  ```python
  def formView(request):
   if request.session.has_key('username'):
      username = request.session['username']
      return render(request, 'loggedin.html', {"username" : username})
   else:
      return render(request, 'login.html', {})
  ```
  Now finally lets create a logout system. Let's create a simple logout view that erases our cookie.:
  ```python
  def logout(request):
   try:
      del request.session['username']
   except:
      pass
   return HttpResponse("<strong>You are logged out.</strong>")
  ```
  or you can check the dictionary:
  ```python
  if "username" in request.session:
    del request.session["username"]
  ```
  
- We have seen how to store and access a session, but it's good to know that the session attribute of the request have some other useful actions like −
  - `set_expiry (value)` − Sets the expiration time for the session.
  - `get_expiry_age()` − Returns the number of seconds until this session expires.
  - `get_expiry_date()` − Returns the date this session will expire.
  - `clear_expired()` − Removes expired sessions from the session store.
  - `get_expire_at_browser_close()` − Returns either True or False, depending on whether the user’s session cookies have expired when the user’s web browser is closed.

<br>
<br>

# Caching


<br>
<br>

# Comments


<br>
<br>

# RSS

<br>
<br>

# AJAX







