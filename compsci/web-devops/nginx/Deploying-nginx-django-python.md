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

-  https://www.youtube.com/watch?v=eEZYDDaDeCs&t=1790    watch this for static files it is easy as fuck

- Nice example is with static files. There are e.g. some CSS styles for django administration page. These needs to be in special folder and we’ll tell nginx that when website asks for file `style.css`, it should looks into `~/test_project/foo/static/style.css`

  But how to find all this static files? Right now they are sourced from django installation directory (probably something like `/test_project/venv/lib/python3.4/django/...`, `manage.py` has a special command for this, but first we need to tell him few details in `settings.py`.
  
  The most common configuration is to has a special directory for static files where you can edit them, past them etc. Then there will be static directory, where you won’t do any changes - this will be for `manage.py` command - it will collects them from your special directory, from django installation directory etc. In templates, when you want to use e.g. some static image on background, you use `{STATIC_URL}/static_images/mybgrnd.png`
  
  To do this we’ll add this to settings.py:
  ```python
  STATIC_URL = '/static/'
  STATIC_ROOT = os.path.join(BASE_DIR, "static")
  STATICFILES_DIRS = (os.path.join(BASE_DIR, "sfiles"), )
  ```
  all your static files used should now be placed inside `/test_project/foo/sfiles`. 

  Now run `./manage.py collectstatic`. It should ask you if you really want to do that (and you want). Process will start and after it’s finish you’ll have collected all static files inside `static` folder. This you need to do every time you change something inside sfiles folder.
  
  Websites also usually has `media` folder, which is used for user files - for example images to blog posts. Usually we use `MEDIA_URL` for calling things from media dir in templates.
  
  Configuration should be same as with django testing server and you don’t need to do any special changes here. My looks like this:
  ```python
  MEDIA_ROOT = os.path.join(BASE_DIR, "media")
  MEDIA_URL = '/media/'
  ADMIN_MEDIA_PREFIX = '/media/admin/'
  ```

### Templates

- Tutorial in this part is not that clear: https://tutos.readthedocs.io/en/latest/source/ndg.html#templates

### SITE_ID

- Tutorial in this part is not that clear: https://tutos.readthedocs.io/en/latest/source/ndg.html#site-id

### ALLOWED_HOSTS

- You need to past all your domains here. If your domain is www.example.com and I guess example.com also, it should looks like this:
  ```python
  ALLOWED_HOSTS = ['example.com', 'www.example.com']
  ```

### DEBUG

- This directive should be set to False. But when you are configuring your server for first time, let True there. It helps you find out bugs on your site.

### nginx server configuration

- Last part is configuring nginx to make him listen on socket created by gunicorn. It’s not hard. After every change in configuration of nginx you need to restart it by running `nginx -s reload`.

  Edit /etc/nginx/nginx.conf and paste this into __`http block`__:
  ```
  worker_processes  1;

  error_log  /Library/Logs/nginx/error.log;

  events {
      worker_connections  1024;
  }

  http {
      upstream test_server {
          server unix:/test_project/run/gunicorn.sock fail_timeout=10s;
      }
      
      # This is not neccessary - it's just commonly used
      # it just redirects example.com -> www.example.com
      # so it isn't treated as two separate websites
      server {
          listen 80;
          server_name example.com;
          return 301 $scheme://www.example.com$request_uri;
      }

      server {
          listen   80;
          server_name www.example.com;

          client_max_body_size 4G;

          access_log /var/www/test/logs/nginx-access.log;
          error_log /var/www/test/logs/nginx-error.log warn;

          location /static/ {
              autoindex on;
              alias   /test_project/foo/static/;
          }

          location /media/ {
              autoindex on;
              alias   /test_project/foo/media/;
          }

          location / {
              proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
              proxy_set_header Host $http_host;
              proxy_redirect off;

              if (!-f $request_filename) {
                  proxy_pass http://test_server;
                  break;
              }
          }

          #For favicon
          location  /favicon.ico {
              alias /var/www/test/test/static/img/favicon.ico;
          }
          #For robots.txt
          location  /robots.txt {
              alias /var/www/test/test/static/robots.txt ;
          }
          # Error pages
          error_page 500 502 503 504 /500.html;
          location = /500.html {
              root /var/www/test/ourcase/static/;
          }
      }
  }
  ```
  First, we tell nginx where is socket file (`gunicorn.sock`) from gunicorn.
  
  Then there is main body of server configuration: * logs are useful for catching bugs and errors - has multiple parameters, like how much should they bother you. Don’t forget to create log directory. * static and media block - these are extremely important - this is why we played all that games with collectstatics etc. It just tells nginx where it should looks when website asks for e.g. `/static/style.css/` or `/media/img/picture_of_my_cat.png`
  
  Block with all that proxy things is also important and is used for technical background around socket communication and redirecting. (reverse proxy the `/` server catches the request and redirects it to the upstream (which is just a block that holds your application servers ... etc. other servers)
  
  Favicon and robots.txt is not necessary, but all browsers and web crawlers are still searching for them. So if you don’t like errors in your logs, add create these two things. * Last block is telling nginx where it should looks for error pages when something doesn’t exists.
  
  Save and exit. Next great future of nginx is it’s ability of checking configuration. Type `nginx -t`
  
  Finally enable nginx to be ran after reboot:
  ```
  systemctl enable nginx
  ```
  
  
  
