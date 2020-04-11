# Deploying nginx + django + python 3

> Notes taken from: https://tutos.readthedocs.io/en/latest/source/ndg.html

- We’ll deploy (that means making website available to the world) `django` project with server engine `nginx` using `gunicorn` for that. We’ll also use virtual environment of python and installation will be static - it will not depend on your system-wide python installation.

  You do not need any special knowledge. But keep in mind that this is not guide how django, nginx or gunicorn work! This is about how it should be brought together to work.

<br>
<br>

# How the hell all that works

- Here is a little model I’ve made for myself and I think it’s not too bad to be a starting point for you ;) . We have five terms: `nginx`, `python`, `virtualenv`, `gunicorn` and `django`.

- `First layer (nginx)` -- nginx is what cares about requests from the world. It’s what catches your request (e.g. Google) and redirects it to according folder (in case of static HTML page with index.html, not our case), or to some application.

- `Second layer (gunicorn)` -- This application in our case is gunicorn. It’s powered by python and it basically makes a magical communication channel __nginx``~``django app__. This tunnel is represented by __socket__ (we’ll get to it). Why can’t do this nginx? It’s just not clever enough (better - it just hasn’t do that and that’s absolutely OK in Unix philosophy). Gunicorn can make server similar to django test server. But it can also serve django app content to nginx and hence solving nginx’s limitation.

- `Third layer (django)` -- Then there is just django - your project with your pages - this is what your website is about.

- `Wrapper for second and third layer` -- It's just virtualenv for handling all of the dependicies and configuration. No need to explain much.

<Br>
<br>

# Wrapper for second and third layer

- `nginx configuration` -- Before we start you must be able to make it to the point that you are able to see nginx welcome page.

### Installing python and virtualenv

- I am not going to note down what virtualenv is. So instead lets see what we have to do in  this project:
  ```
  $ pip install virtualenv
  ```
  Than create your virtualenv in a dir:
  ```
  cd ~/desktop
  mkdir test_project
  cd test_project
  # now create the virtual env
  virtualenv venv
  ```
  
### pip installing django and gunicorn

- Im not gonna explain this step neither:
  ```
  venv/bin/pip install django
  venv/bin/pip install gunicorn
  ```

### Sample django project

- Im not gonna explain django go to that techs note file in this repo:
  ```
  venv/bin/django-admin startproject foo 
  ```
  Folder structure:
  ```
  foo/
  |-- manage.py
  `-- foo/
      |-- __init__.py
      |-- settings.py
      |-- urls.py
      `-- wsgi.py
  ```

### gunicorn and daemonizing it

- Now we’ll replace django testing server, which is just for kids (it’s just great future :) ), with fully mature nginx for adults.
  
  As was previously stated, for that we’ll need gunicorn. Gunicorn will have to be running to enable communication between nginx and django project.
  
  First, we’ll use just `gunicorn` to display our django test project on `127.0.0.1:8000`. It’s incredibly easy. Again - assure yourself you are working in current virtualenv.
  ```
  gunicorn foo.wsgi:application
  ```
  it will start something like gunicorn server - you should be able to see your django welcome page on 127.0.0.1:8000.

- This is just the most stupid configuration, which is enough for this test, but not for deploying on server. For that we’ll want to add much more. Create starting script `/test_project/gunicorn_start.sh`:
  ```sh
  #!/bin/bash
  
  NAME="foo"                                  # Name of the application (*)
  DJANGODIR=/test_project/foo                 # Django project directory (*)
  SOCKFILE=/test_project/run/gunicorn.sock    # we will communicate using this unix socket (*)
  USER=nginx                                  # the user to run as (*)
  GROUP=webdata                               # the group to run as (*)
  NUM_WORKERS=1                               # how many worker processes should Gunicorn spawn (*)
  DJANGO_SETTINGS_MODULE=foo.settings         # which settings file should Django use (*)
  DJANGO_WSGI_MODULE=foo.wsgi                 # WSGI module name (*)
  
  echo "Starting $NAME as `whoami`"

  # Activate the virtual environment
  cd $DJANGODIR
  source /test_project/venv/bin/activate
  export DJANGO_SETTINGS_MODULE=$DJANGO_SETTINGS_MODULE
  export PYTHONPATH=$DJANGODIR:$PYTHONPATH

  # Create the run directory if it doesn't exist
  RUNDIR=$(dirname $SOCKFILE)
  test -d $RUNDIR || mkdir -p $RUNDIR
  
  # Start your Django Unicorn
  # Programs meant to be run under supervisor should not daemonize themselves (do not use --daemon)
  exec /test_project/venv/bin/gunicorn ${DJANGO_WSGI_MODULE}:application \
    --name $NAME \
    --workers $NUM_WORKERS \
    --user $USER \
    --bind=unix:$SOCKFILE
  ```
  Wow! A lot happened here compared to our stupid variant. Everything marked with `(*)` in comments can be changed (or must be changed if your paths differs).
  
  The most important change here is that we added `SOCKFILE` - socket. This is the magic thingie which will enable `nginx` to server django project (app). Gunicorn will somehow run server as in previous stupid variant and transfer this into socket file in language which nginx understands. nginx is looking to this socket file and is happy to serve everything there is.
  
  It’s common practice (and I strongly encouraged it) to run server as some specific user. It’s for security reasons.
  
  If you are not working as a user which is in script set to `USER` variable, you won’t be able to run this script (you’ll get some errors). That’s because of permissions reasons. If you’d like to check or debug this script (and it’s recommended), uncomment `--user $USER` line 
  
- If it is working, it’s great! Now we’ll daemonize it by using `systemd`. Of course you can use another init system (like Ubuntu `upstart`. Just search for “how to run script after boot”.

  Create new service file `/usr/lib/systemd/system/gunicorn_foo.service` and insert this:
  ```
    [Unit]
  Description=Foo gunicorn daemon

  [Service]
  Type=simple
  User=nginx
  ExecStart=/test_project/gunicorn_start.sh

  [Install]
  WantedBy=multi-user.target
  ```
  now enable it as with other units:
  ```
  systemctl enable gunicorn_foo
  ```
  now this script should be run after boot. Try if it’s working (reboot and use `systemctl status gunicorn_foo`).

### Django project deployment

- If you’ve just developed django project with test server, it makes a tons of things for you without any notices. In reality it’s not as easy - everything isn’t done automatically and django is prepared for that - but you need to activate this futures, since it’s not by default.

### Directories

### Templates

### SITE_ID

### ALLOWED_HOSTS

### DEBUG

### nginx server configuration

### Debugging
