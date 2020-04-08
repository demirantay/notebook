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

# Custom Application

- I didnt understand what is being teached here, revisit it once i understand more: http://docs.gunicorn.org/en/latest/custom.html

<br>
<br>

---

<br>
<br>

# Design

### Server Model

- Gunicorn is based on the pre-fork worker model. This means that there is a central master process that manages a set of worker processes. The master never knows anything about individual clients. All requests and responses are handled completely by worker processes.

- `Master` -- The master process is a simple loop that listens for various process signals and reacts accordingly. It manages the list of running workers by listening for signals like TTIN, TTOU, and CHLD. TTIN and TTOU tell the master to increase or decrease the number of running workers. CHLD indicates that a child process has terminated, in this case the master process automatically restarts the failed worker.

- `Sync Workers` -- The most basic and the default worker type is a synchronous worker class that handles a single request at a time. This model is the simplest to reason about as any errors will affect at most a single request.
	
	`sync` worker does not support persistent connections - each connection is closed after response has been sent (even if you manually add `Keep-Alive` or `Connection: keep-alive` header in your application).

- `Async Workers` -- The asynchronous workers available are based on Greenlets (via Eventlet and Gevent). Greenlets are an implementation of cooperative multi-threading for Pytho

- `Tornado Workers` -- There’s also a Tornado worker class. It can be used to write applications using the Tornado framework. Although the Tornado workers are capable of serving a WSGI application, this is not a recommended configuration.

- `AsyncIO Workers` -- The worker gthread is a threaded worker. It accepts connections in the main loop, accepted connections are added to the thread pool as a connection job. On keepalive connections are put back in the loop waiting for an event. If no event happen after the keep alive timeout, the connection is closed.

### Choosing a Worker Type

- The default synchronous workers assume that your application is resource-bound in terms of CPU and network bandwidth. Generally this means that your application shouldn’t do anything that takes an undefined amount of time

	This resource bound assumption is why we require a buffering proxy in front of a default configuration Gunicorn. If you exposed synchronous workers to the internet, a DOS attack would be trivial by creating a load that trickles data to the servers. For the curious, Hey is an example of this type of load.

### How Many Workers?

- DO NOT scale the number of workers to the number of clients you expect to have. Gunicorn should only need 4-12 worker processes to handle hundreds or thousands of requests per second.

	Gunicorn relies on the operating system to provide all of the load balancing when handling requests. Generally we recommend (2 x $num_cores) + 1 as the number of workers to start off with. While not overly scientific, the formula is based on the assumption that for a given core, one worker will be reading or writing from the socket while the other worker is processing a request.
	
	Obviously, your particular hardware and application are going to affect the optimal number of workers. Our recommendation is to start with the above guess and tune using TTIN and TTOU signals while the application is under load.
	
	Always remember, there is such a thing as too many workers. After a point your worker processes will start thrashing system resources decreasing the throughput of the entire system.
	
### How Many Threads?

- Depending on the system, using multiple threads, multiple worker processes, or some mixture, may yield the best results.

<br>

# Signal Handling 

- A brief description of the signals handled by Gunicorn. We also document the signals used internally by Gunicorn to communicate with the workers.

### Master process

- `QUIT`, `INT`: Quick shutdown
- `TERM`: Graceful shutdown. Waits for workers to finish their current requests up to the graceful_timeout.
- `HUP`: Reload the configuration, start the new worker processes with a new configuration and gracefully shutdown older workers. If the application is not preloaded (using the preload_app option), Gunicorn will also load the new version of it.
- `TTIN`: Increment the number of processes by one
- `TTOU`: Decrement the number of processes by one
- `USR1`: Reopen the log files
- `USR2`: Upgrade Gunicorn on the fly. A separate `TERM` signal should be used to kill the old master process. This signal can also be used to use the new versions of pre-loaded applications. See Upgrading to a new binary on the fly for more information.
- `WINCH`: Gracefully shutdown the worker processes when Gunicorn is daemonized.

### Worker process

- Sending signals directly to the worker processes should not normally be needed. If the master process is running, any exited worker will be automatically respawned.
- `QUIT`, `INT`: Quick shutdown
- `TERM`: Graceful shutdown
- `USR1`: Reopen the log files

<br>
<br>

---

<br>
<br>

