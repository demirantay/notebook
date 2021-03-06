# How To Set Up Django with Postgres, Nginx, and Gunicorn on Ubuntu 16.04

- Django is a powerful web framework that can help you get your Python application or website off the ground. Django includes a simplified development server for testing your code locally, but for anything even slightly production related, a more secure and powerful web server is required.

  In this guide, we will demonstrate how to install and configure some components on Ubuntu 16.04 to support and serve Django applications. We will be setting up a PostgreSQL database instead of using the default SQLite database. We will configure the Gunicorn application server to interface with our applications. We will then set up Nginx to reverse proxy to Gunicorn, giving us access to its security and performance features to serve our apps.

<br>
<br>

# Pre-requisites and Goals

- In order to complete this guide, you should have a fresh Ubuntu 16.04 server instance with a non-root user with sudo privileges configured.

  We will be installing Django within a virtual environment. Installing Django into an environment specific to your project will allow your projects and their requirements to be handled separately.

  Once we have our database and application up and running, we will install and configure the Gunicorn application server. This will serve as an interface to our application, translating client requests in HTTP to Python calls that our application can process. We will then set up Nginx in front of Gunicorn to take advantage of its high performance connection handling mechanisms and its easy-to-implement security features.

<br>
<br>

# Create the PostgreSQL database and user

- Log into an interactive Postgres session by typing:
  ```
  $ sudo -u postgres psql
  ```
  First, create a database for your project:
  ```
  postgres=# CREATE DATABASE myproject;
  ```
  Next, create a database user for our project. Make sure to select a secure password:
  ```
  postgres=# CREATE USER myprojectuser WITH PASSWORD 'password';
  ```
  We are setting the default encoding to UTF-8, which Django expects. We are also setting the default transaction isolation scheme to “read committed”, which blocks reads from uncommitted transactions. Lastly, we are setting the timezone. By default, our Django projects will be set to use UTC. These are all recommendations from the Django project itself:
  ```
  postgres=# ALTER ROLE myprojectuser SET client_encoding TO 'utf8';
  postgres=# ALTER ROLE myprojectuser SET default_transaction_isolation TO 'read committed';
  postgres=# ALTER ROLE myprojectuser SET timezone TO 'UTC';
  ```
  Now, we can give our new user access to administer our new database:
  ```
  postgres=# GRANT ALL PRIVILEGES ON DATABASE myproject TO myprojectuser;
  ```

<br>
<br>

# Create Python Virtual Environment

- If you are using Python 3, upgrade pip and install the package by typing:
  ```
  $ sudo -H pip3 install virtualenv
  ```
  With virtualenv installed, we can start forming our project. 
  ```
  mkdir ~/myproject
  cd ~/myproject
  ```
  Within the project directory, create a Python virtual environment by typing:
  ```
  virtualenv venv
  ```
  than activate it to work with it
  ```
  source venv/bin/activate
  ```
  With your virtual environment active, install Django, Gunicorn, and the psycopg2 PostgreSQL adaptor with the local instance of pip:
  ```
  $ pip install django gunicorn psycopg2
  ```

<br>
<Br>
 
# Create and Configure a New Django Project

- The first thing we should do with our newly created project files is adjust the `settings.py`:
  
  Start by locating the ALLOWED_HOSTS directive. This defines a list of the server’s addresses or domain names may be used to connect to the Django instance. In the snippet below, there are a few commented out examples used to demonstrate:
  ```python
  ALLOWED_HOSTS = ['your_server_domain_or_IP', 'second_domain_or_IP', . . .]
  ALLOWED_HOSTS = [ 'example.com', '203.0.113.5']
  ```
  Next, find the section that configures database access. It will start with `DATABASES`. The configuration in the file is for a SQLite database. We already created a PostgreSQL database for our project, so we need to adjust the settings. Change the settings with your PostgreSQL database information. 
  
  We tell Django to use the psycopg2 adaptor we installed with pip. We need to give the database name, the database username, the database user’s password, and then specify that the database is located on the local computer. You can leave the PORT setting as an empty string:
  ```python
  ...

  DATABASES = {
      'default': {
          'ENGINE': 'django.db.backends.postgresql_psycopg2',
          'NAME': 'myproject',
          'USER': 'myprojectuser',
          'PASSWORD': 'password',
          'HOST': 'localhost',
          'PORT': '',
      }
  }
  ```
  Next, move down to the bottom of the file and add a setting indicating where the static files should be placed. This is necessary so that Nginx can handle requests for these items. The following line tells Django to place them in a directory called static in the base project directory:
  ```python
  ...

  STATIC_URL = '/static/'
  STATIC_ROOT = os.path.join(BASE_DIR, 'static/')
  ```
  Now, we can migrate the initial database schema to our PostgreSQL database using the management script:
  ```
  $ ~/myproject/manage.py makemigrations
  $ ~/myproject/manage.py migrate
  $ ~/myproject/manage.py createsuperuser
  $ ~/myproject/manage.py collectstatic
  ```
   Finally, you can test our your project by starting up the Django development server with this command:
  ```
  $ ~/myproject/manage.py runserver 0.0.0.0:8000
  ```
  
### Testing Gunicorn’s Ability to Serve the Project

- The last thing we want to do before leaving our virtual environment is test Gunicorn to make sure that it can serve the application. We can do this by entering our project directory and using gunicorn to load the project’s WSGI module:
  ```
  (venv) cd ~/myproject
  (venv) gunicorn --bind 0.0.0.0:8000 myproject.wsgi
  ```
  This will start Gunicorn on the same interface that the Django development server was running on. You can go back and test the app again.
  
  > Note: The admin interface will not have any of the styling applied since Gunicorn does not know about the static CSS content responsible for this.
  
  We passed Gunicorn a module by specifying the relative directory path to Django’s `wsgi.py` file, which is the entry point to our `application`, using Python’s module syntax. Inside of this file, a function called application is defined, which is used to communicate with the application. For more info read upon wsgi and gunicorn official docs.

<br>
<Br>

# Create a Gunicorn systemd Service File

- We have tested that Gunicorn can interact with our Django application, but we should implement a more robust way of starting and stopping the application server. To accomplish this, we’ll make a `systemd` service file.

  Create and open a systemd service file for Gunicorn with sudo privileges in your text editor:
  ```
  sudo vim /etc/systemd/system/gunicorn.service
  ```
  Start with the `[Unit]` section, which is used to specify metadata and dependencies.
  ```
  [Unit]
  Description=gunicorn daemon
  After=network.target
  ```
  Next, we’ll open up the `[Service]` section. We’ll specify the user and group that we want to process to run under. We will give our regular user account ownership of the process since it owns all of the relevant files. We’ll give group ownership to the www-data group so that Nginx can communicate easily with Gunicorn.
  
  We’ll then map out the working directory and specify the command to use to start the service. In this case, we’ll have to specify the full path to the Gunicorn executable, which is installed within our virtual environment. For example, we specified 3 worker processes in this case:
  ```
  [Unit]
  Description=gunicorn daemon
  After=network.target

  [Service]
  User=sammy
  Group=www-data
  WorkingDirectory=/home/sammy/myproject
  ExecStart=/home/sammy/myproject/venv/bin/gunicorn --access-logfile - --workers 3 --bind unix:/home/sammy/myproject/myproject.sock myproject.wsgi:application
  ```
  Finally, we’ll add an [Install] section. This will tell systemd what to link this service to if we enable it to start at boot. We want this service to start when the regular multi-user system is up and running:
  ```
  [Unit]
  ...

  [Service]
  ...

  [Install]
  WantedBy=multi-user.target
  ```
  We can now start the Gunicorn service we created and enable it so that it starts at boot:
  ```
  sudo systemctl start gunicorn
  sudo systemctl enable gunicorn
  ```
  > most of the commands that does not work are only avalibale to linux, you can find equievelent commands for them in different OSes
  
  

<br>
<Br>
 

# Check for the Gunicorn Socket File

- Next, check for the existence of the myproject.sock file within your project directory:
  ```
  ls /home/sammy/myproject
  
  # output
  manage.py  myproject  venv  myproject.sock  static
  ```
  If the `systemctl status` command indicated that an error occurred or if you do not find the `myproject.sock` file in the directory, it’s an indication that Gunicorn was not able to start correctly. Check the Gunicorn process logs by typing:
  ```
  sudo journalctl -u gunicorn
  ```
  
- If you make changes to the /etc/systemd/system/gunicorn.service file, reload the daemon to reread the service definition and restart the Gunicorn process by typing:
  ```
  sudo systemctl daemon-reload
  sudo systemctl restart gunicorn
  ```

<br>
<Br>
 

# Configure Nginx to Proxy Pass to Gunicorn

- Now that Gunicorn is set up, we need to configure Nginx to pass traffic to the process. Start by creating and opening a new server block in Nginx’s sites-available directory:
  ```
  sudo vim /etc/nginx/sites-available/myproject
  ```
  Inside, open up a new server block. We will start by specifying that this block should listen on the normal port 80 and that it should respond to our server’s domain name or IP address:
  ```
  server {
    listen 80;
      server_name server_domain_or_IP;
  }
  ```
  Next, we will tell Nginx to ignore any problems with finding a favicon. We will also tell it where to find the static assets that we collected in our`~/myproject/static` directory. All of these files have a standard URI prefix of “/static”, so we can create a location block to match those requests:
  ```
  server {
      listen 80;
      server_name server_domain_or_IP;

      location = /favicon.ico { access_log off; log_not_found off; }
      location /static/ {
          root /home/sammy/myproject;
      }
  }
  ```
  Finally, we’ll create a `location / {} `block to match all other requests. Inside of this location, we’ll include the standard `proxy_params` file included with the Nginx installation and then we will pass the traffic to the socket that our Gunicorn process created:
  ```
  server {
      listen 80;
      server_name server_domain_or_IP;

      location = /favicon.ico { access_log off; log_not_found off; }
      location /static/ {
          root /home/sammy/myproject;
      }

      location / {
          include proxy_params;
          proxy_pass http://unix:/home/sammy/myproject/myproject.sock;
      }
  }
  ```
  Test your Nginx configuration for syntax errors by typing:
  ```
  sudo nginx -t
  ```
  
  > After configuring Nginx, the next step should be securing traffic to the server using SSL/TLS. This is important because without it, all information, including passwords are sent over the network in plain text.

  > If you have a domain name, the easiest way get an SSL certificate to secure your traffic is using Let’s Encrypt
  

<br>
<br>

