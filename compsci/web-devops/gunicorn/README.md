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
	```
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

### Config File

### Debugging

### Logging 

### Process Naming

### SSL

### Security

### Server Hooks

### Server Mechanics

### Server Scoket 

### Worker Process
