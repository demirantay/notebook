# Gunicorn

- My gunciorn docs from the official documentation

<br>

# Installation

- To install the latest released version of Gunicorn:
	```
	$ pip install gunicorn
	```

### From Source

- You can install Gunicorn from source just as you would install any other Python package:
	```
	$ pip install git+https://github.com/benoitc/gunicorn.git
	```

### Ubuntu

- Ubuntu 12.04 (trusty) or later contains the Gunicorn package by default so that you can install it in the usual way:
	```
	$ sudo apt-get update
	$ sudo apt-get install gunicorn
	```

<br>
<br>

---

<br>
<br>

# Running Gunciorn

- You can run Gunicorn by using commands or integrate with popular frameworks like Django, Pyramid, or TurboGears.

### Commands

- After installing Gunicorn you will have access to the command line script `gunicorn`.

- __gunicorn__ -- Basic Usage:
	```
	$ gunicorn [OPTIONS] APP_MODULE
	```
	Where `APP_MODULE` is of the pattern `$(MODULE_NAME):$(VARIABLE_NAME)`. The module name can be a full dotted path. The variable name refers to a WSGI callable that should be found in the specified module.

- __Commonly Used Arguments__ -- Lets see common args:
	- `-c CONFIG, --config=CONFIG` - Specify a config file in the form `$(PATH)`, `file:$(PATH)`, or `python:$(MODULE_NAME)`.
	- `-b BIND`, `--bind=BIND` - Specify a server socket to bind. Server sockets can be any of `$(HOST)`, `$(HOST):$(PORT)`, `fd://$(FD)`, or `unix:$(PATH)`. An IP is a valid `$(HOST)`.
	- `-w WORKERS`, `--workers=WORKERS` - The number of worker processes. This number should generally be between 2-4 workers per core in the server
	- `-k WORKERCLASS, --worker-class=WORKERCLASS` - The type of worker process to run. You’ll definitely want to read the production page for the implications of this parameter.
	- `-n APP_NAME, --name=APP_NAME` - If setproctitle is installed you can adjust the name of Gunicorn process as they appear in the process system table

### Integration

- Gunicorn also provides integration for Django and Paste Deploy applications.

- __Django__ -- Gunicorn will look for a WSGI callable named `application` if not specified. So for a typical Django project, invoking Gunicorn would look like:
	```
	$ gunicorn myproject.wsgi
	```
	This requires that your project be on the Python path; the simplest way to ensure that is to run this command from the same directory as your manage.py file.
	
	You can use the –env option to set the path to load the settings:
	```
	$ gunicorn --env DJANGO_SETTINGS_MODULE=myproject.settings myproject.wsgi
	```

- __Paste Deployment__ -- Frameworks such as Pyramid and Turbogears are typically configured using Paste Deployment configuration files. If you would like to use these files with Gunicorn, [start here](http://docs.gunicorn.org/en/latest/run.html#paste-deployment).

<br>
<br>

---

<br>
<br>

# Configuration Overview

- Gunicorn pulls configuration information from three distinct places.

	The first place that Gunicorn will read configuration from is the framework specific configuration file. Currently this only affects Paster applications. Django does not have one.
	
	The second source of configuration information is a configuration file that is optionally specified on the command line. Anything specified in the Gunicorn config file will override any framework specific settings.
	
	Lastly, the command line arguments used to invoke Gunicorn are the final place considered for configuration settings. If an option is specified on the command line, this is the value that will be used.
	
	in order of least to most authoritative:
	- Framework Settings
	- Configuration File
	- Command Line
	
	> To check your configuration when using the command line or the configuration file you can run the following command:
		```
		$ gunicorn --check-config APP_MODULE
		```

### Command Line

- . Not all Gunicorn settings are available to be set from the command line. To see the full list of command line settings you can do the usual:
	```
	$ gunicorn -h
	```

### Configuration File

- The configuration file should be a valid Python source file with a python extension (e.g. gunicorn.conf.py). It only needs to be readable from the file system. More specifically, it does not have to be on the module path (sys.path, PYTHONPATH). Any Python is valid. Just consider that this will be run every time you start Gunicorn (including when you signal Gunicorn to reload)

	To set a parameter, just assign to it. There’s no special syntax. The values you provide will be used for the configuration values. For instance:
	```python
	import multiprocessing

	bind = "127.0.0.1:8000"
	workers = multiprocessing.cpu_count() * 2 + 1
	```

<br>
<br>

---

<br>
<br>

# Settings

- This is an exhaustive list of settings for Gunicorn. Some settings are only able to be set from a configuration file. The setting name is what should be used in the configuration file. 

- Settings can be specified by using environment variable `GUNICORN_CMD_ARGS`. All available command line arguments can be used. For example, to specify the bind address and number of workers:
	```
	$ GUNICORN_CMD_ARGS="--bind=127.0.0.1 --workers=3" gunicorn app:app
	```

- There are too many config settings you [can view the reference here](http://docs.gunicorn.org/en/latest/settings.html) it is fairly small for an application 

<br>
<br>

---

<br>
<br>

# Instrumentation

- Gunicorn provides an optional instrumentation of the arbiter and workers using the statsD protocol over UDP. Thanks to the `gunicorn.instrument.statsd` module, Gunicorn becomes a statsD client. The use of UDP cleanly isolates Gunicorn from the receiving end of the statsD metrics so that instrumentation does not cause Gunicorn to be held up by a slow statsD consumer.

- To use statsD, just tell Gunicorn where the statsD server is:
	```
	$ gunicorn --statsd-host=localhost:8125 --statsd-prefix=service.app ...
	```
	
	I currently do not know about insturmentation so if you want more info you can start reading it here: http://docs.gunicorn.org/en/latest/instrumentation.html
	
<br>
<br>

---

<br>
<br>

# Deploying Gunicorn

- We strongly recommend to use Gunicorn behind a proxy server, such as nginx, ... etc.

### Nginx Configuration

- Although there are many HTTP proxies available, we strongly advise that you use Nginx. If you choose another proxy server you need to make sure that it buffers slow clients when you use default Gunicorn workers. Without this buffering Gunicorn will be easily susceptible to denial-of-service attacks.

	An example configuration file for fast clients with Nginx:
	
	nginx.conf
	```c
	worker_processes 1;

	user nobody nogroup;
	# 'user nobody nobody;' for systems with 'nobody' as a group instead
	error_log  /var/log/nginx/error.log warn;
	pid /var/run/nginx.pid;

	events {
		worker_connections 1024; # increase if you have lots of clients
		accept_mutex off; # set to 'on' if nginx worker_processes > 1
		# 'use epoll;' to enable for Linux 2.6+
		# 'use kqueue;' to enable for FreeBSD, OSX
	}

	http {
		include mime.types;
		# fallback in case we can't determine a type
		default_type application/octet-stream;
		access_log /var/log/nginx/access.log combined;
		sendfile on;

		upstream app_server {
			# fail_timeout=0 means we always retry an upstream even if it failed
			# to return a good HTTP response

			# for UNIX domain socket setups
			server unix:/tmp/gunicorn.sock fail_timeout=0;

			# for a TCP configuration
			# server 192.168.0.7:8000 fail_timeout=0;
		}

		server {
			# if no Host match, close the connection to prevent host spoofing
			listen 80 default_server;
			return 444;
		}

		server {
			# use 'listen 80 deferred;' for Linux
			# use 'listen 80 accept_filter=httpready;' for FreeBSD
			listen 80;
			client_max_body_size 4G;

			# set the correct host(s) for your site
			server_name example.com www.example.com;

			keepalive_timeout 5;

			# path for static files
			root /path/to/app/current/public;

			location / {
				# checks for static file, if not found proxy to app
				try_files $uri @proxy_to_app;
			}

			location @proxy_to_app {
				proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
				proxy_set_header X-Forwarded-Proto $scheme;
				proxy_set_header Host $http_host;
				# we don't want nginx trying to do something clever with
				# redirects, we set the Host: header above already.
				proxy_redirect off;
				proxy_pass http://app_server;
			}

			error_page 500 502 503 504 /500.html;
			location = /500.html {
				root /path/to/app/current/public;
			}
		}
	}
	```
	If you want to be able to handle streaming request/responses or other fancy features like Comet, Long polling, or Web sockets, you need to turn off the proxy buffering. When you do this you must run with one of the async worker classes.
	
	It is recommended to pass protocol information to Gunicorn. Many web frameworks use this information to generate URLs. Without this information, the application may mistakenly generate ‘http’ URLs in ‘https’ responses, leading to mixed content warnings or broken applications. To configure Nginx to pass an appropriate header, add a `proxy_set_header` directive to your `location` block:
	```
	...
	proxy_set_header X-Forwarded-Proto $scheme;
	...
	```
	If you are running Nginx on a different host than Gunicorn you need to tell Gunicorn to trust the `X-Forwarded-*` headers sent by Nginx. By default, Gunicorn will only trust these headers if the connection comes from localhost.
	```
	$ gunicorn -w 3 --forwarded-allow-ips="10.170.3.217,10.170.3.220" test:app
	```
	
	> I did not understand it come back to it later ...

<br>
<br>

---

<br>
<br>

# Signal Handling 


<br>
<br>

---

<br>
<br>

# Custom Application

<br>
<br>

---

<br>
<br>

# Design


