[part 1](./README)

<br>
<br>

# Basic Nginx Configuration

- In this chapter, we will begin to establish an appropriate configuration for the web server. For this purpose, we first need to approach the topic of syntax used in the configuration files. Then we need to understand the various directives that will let you optimize your web server for different traffic patterns and hardware setups
	
	We will only approach the basic configuration directives here. The following chapters will detail more advanced topics
 
 ### Configuration File syntax
 
 - A configuration file is generally a text file that is edited by the administrator and parsed by a program. By specifying a set of values, you define the behavior of the program
 
 	There is, unfortunately, no well-established standard, and the same applies to Nginx—you will be required to study a new syntax with its own particularities and its own vocabulary.
	
	On the other hand (and this is one of its advantages), configuring Nginx turns out to be rather simple—at least in comparison to Apache or other mainstream web servers. There are only a few mechanisms that need to be mastered—directives, blocks, and the overall logical structure. Most of the actual configuration process will consist of writing values for directives.
	
- `Configuration directives` -- The Nginx configuration file can be described as a list of directives organized in a logical structure. The entire behavior of the application is defined by the values that you give to those directives.

	By default, Nginx makes use of one main configuration file. The path of this file was defined in the steps described in Chapter 1,
	
	If you did not edit the configuration file path and prefix options, it should be located at /usr/local/nginx/conf/nginx.conf
	
	> Directives always end with a semicolon (;).
	
	Each directive has a unique meaning and defines a particular feature of the application. It may also have a particular syntax. For example, the worker_process directive only accepts one numeric value, whereas the user directive lets you specify up to two character strings
	
	Nginx works in a modular way, and as such, each module comes with a specific set of directives.

- `Organization and inclusion` -- In the preceding screenshot, you may have noticed a particular directive—includ
	```
	include mime.types;
	```
	As the name suggests, this directive will perform an inclusion of the specified file. In other words, the contents of the file will be inserted at this exact location. Here is a practical example that will help you understand:
	```
	nginx.conf:
		user nginx nginx; worker_processes 4;
		include other_settings.conf;
	
	other_settings.conf: error_log logs/error.log;
		 pid logs/nginx.pid;
	```
	The final result, as interpreted by Nginx, is as follows:
	```
	user nginx nginx;
	worker_processes 4;
	error_log logs/error.log;
	pid logs/nginx.pid;
	```
	In the initial configuration setup, there are two files at use—nginx.conf and mime. types. However, in the case of a more advanced configuration, there may be five or more files, as described in the following table:
	- `nginx.conf` -- Base configuration of the application.
	- `mime.types` -- A list of file extensions and their associated MIME types.
	- `fastcgi.conf` -- FastCGI-related configuration.
	- `proxy.conf` -- Proxy-related configuration.
	- `sites.conf` -- Configuration of the websites served by Nginx, also known as virtual hosts. It's recommended to create separate files for each domain.
	
	These filenames were defined conventionally, nothing actually prevents you from regrouping your FastCGI and proxy settings into a common file named proxy_and_ fastcgi_config.conf.
	
	Note that the include directive supports filename globbing. In other words, filenames referenced with the * wildcard, where * may match zero, one, or more consecutive characters:
	```
	include sites/*.conf;
	```

- `Directive Blocks` -- Directives are brought in by modules—if you activate a new module, a specific set of directives becomes available. Modules may also enable directive blocks, which allow for a logical construction of the configuration:
	```
	events {
       worker_connections 1024;
	}
	```
	The `events` block that you can find in the default configuration file is brought in by the Events module. The directives that the module enables can only be used within that block—in the preceding example, worker_connections will only make sense in the context of the events block. There is one important exception though—some directives may be placed at the root of the configuration file because they have a global effect on the server. The root of the configuration file is also known as the `main` block.
	
	Note that in some cases, blocks can be nested into each other, following a specific logic:
	```
   http {
					 server {
							 listen 80;
							 server_name example.com;
							 access_log /var/log/nginx/example.com.log;
							 location ^~ /admin/ {
									 index index.php;
							}
				}
	}
	```
	Last but not least, configuration is inherited within children blocks. The access_log directive (defined at the server block level in this example) specifies that all HTTP requests for this server should be logged into a text file. This is still true within the location child block, although you have the possibility of disabling it by reusing the access_log directive:
	```
	[...]
				 location ^~ /admin/ {
						 index index.php;
						 access_log off;
				 }
	[...]
	```
	
- `Advanced Language Rules` -- There are a number of important observations regarding the Nginx configuration file syntax. These will help you understand certain syntax rules that may seem confusing if you have never worked with Nginx before.

- `Directives accept specific syntaxes` -- You may indeed stumble upon complex syntaxes that can be confusing at first sight:
	```
	rewrite ^/(.*)\.(png|jpg|gif)$ /image.php? file=$1&format=$2 last;
	```
	Syntaxes are directive-specific. While the listen directive may only accept a port number to open a listening socket, the location block or the rewrite directive support complex expressions in order to match particular patterns.

- `Diminutives in directive values` -- Finally, you may use the following diminutives for specifying a file size in the context of a directive value:
	- k or K: Kilobytes
	- m or M: Megabytes
	
	This becomes especially useful in the case of directives accepting a period of time as a value:
	```
	client_body_timeout 3m;
  client_body_timeout 180s;
  client_body_timeout 180;
	```

- `Variables` -- Modules also provide variables that can be used in the definition of directive values. Variables in Nginx always start with `"$"`

	Note that some directives do not allow you to use variables:

- `String Values` -- Character strings that you use as directive values can be written in three forms. First, you may enter the value without quotes:
	```
	root /home/example.com/www;
	root '/home/example.com/my web pages';
	```
	Nginx makes no difference whether you use single or double quotes. Note that variables inserted in strings within quotes will be expanded normally, unless you prefix the $ character with a backslash `(\)`.
 
 ### Base Module Directives
 
 - We are particularly interested in answering two questions: what are base modules? and what directives are made available?

- `What are base modules` -- The base modules offer directives that allow you to define parameters of the basic functionality of Nginx. They cannot be disabled at compile time, and as a result, the directives and blocks they offer are always available
	- `Core module`: Essential features and directives such as process management and security
	- `Events module`: Lets you configure the inner mechanisms of the networking capabilities
	- `Configuration module`: Enables the inclusion mechanism

- `nginx process architecture` -- Before we start detailing the basic configuration directives, it's necessary to understand the process architecture, that is, how Nginx works behind the scenes. Although the application comes as a simple binary file (lightweight background process), the way it functions at runtime can be relatively complex.

	At the very moment of starting Nginx, one unique process exists in memory—the `Master Process`. It is launched with the current user and group permissions—usually root/root if the service is launched at boot time by an init script. The master process itself does not process any client request, instead, it spawns processes that do—the `Worker Processes`,
	
	From the configuration file, you are able to define the amount of worker processes, the maximum connections per worker process, the user and group the worker processes are running under, and more:

- `core module directives` -- The following is the list of directives made available by the Core module. Most of these directives must be placed at the root of the configuration file and can only be used once:
	
	|Name and Context|Syntax and Description|
	|--|--|
	|daemon|Accepted values: on or off<br>Syntax:daemon on;<br>Default value: on<br>Enables or disables daemon mode. If you disable it, the program will not be started in the background; it will stay in the foreground when launched from the shell. This may come in handy for debugging, in situations where you need to know what causes Nginx to crash, and when.|
	|debug_points|Accepted values: stop or abort<br>Syntax:debug_points stop;<br>Default value: None<br>Activates debug points in Nginx. Use stop to interrupt the application when a debug point comes about in order to attach a debugger. Use abort to abort the debug point and create a core dump file.To disable this option, simply do not use the directive.|
	|env|Syntax:<br> env MY_VARIABLE;<br> env MY_VARIABLE=my_value;<br>Lets you (re)define environment variables.|
	|error_log|Syntax:<Br>error_log /file/path level;<Br>Default value: logs/error.log error.<br>Where level is one of the following values: debug, info, notice, warn, error, and crit (from most to least detailed: debug provides frequent log entries, crit only reports critical errors).Enables error logging at different levels: Application, HTTP server, virtual host, and virtual host directory.|
	|lock_file|Syntax: File path<br>lock_file logs/nginx.lock;<Br>Default value: Defined at compile time<Br>Use a lock file for mutual exclusion. This is disabled by default, unless you enabled it at compile time. On most operating systems the locks are implemented using atomic operations, so this directive is ignored anyway.|
	| ... | check cheatsheets |

- `events module` -- The Events module comes with directives that allow you to configure network mechanisms. Some of the parameters have an important impact on the application's performance.

	All of the directives listed in the following table must be placed in the events block, which is located at the root of the configuration file:
	```
	user nginx nginx; 
	master_process on; 
	worker_processes 4; 
	events {
		worker_connections 1024;
	use epoll; }
	[...]
	```

- `Configuration Module` -- The Nginx Configuration module is a simple module enabling file inclusions with the include directive, as previously described in the Organization and inclusions section. The directive can be inserted anywhere in the configuration file and accepts a single:
	```
	include /file/path.conf;
  include sites/*.conf;
	```
	> Note that if you do not specify an absolute path, the file path is relative to the configuration directory. By default, include sites/example.conf will include the following file: /usr/ local/nginx/conf/sites/example.conf

 ### A configuration for your profile
 
 - `Understanding the default configuration` -- We will study the default configuration by opening up the main configuration file nginx.conf, although you will find this file to be almost empty. The reason lies in the fact that when a directive does not appear in the configuration file, the default value is employed

- `Necessary adjustments` -- We will review some of the configuration directives that need to be changed immediately and the possible values you may set:
	- `user root root;` -- This directive specifies that the worker processes will be started as root. It is dangerous for security as it grants full permissions over the filesystem. You need to create a new user account on your system and make use of it here.
	- `worker process 1;` -- With this setting, only one worker process will be started, which implies that all requests will be processed by a unique execution flow (the current version of Nginx is not multi-threaded, by choice). This also implies
that the execution is delegated to only one core of your CPU. It is highly recommended to increase this value; you should have at least one process per CPU core. Recommended value (granted your server is powered by a quad-core CPU): worker_processes 4;
	- `worker_priority 0;` -- By default, the worker processes are started with a regular priority. If your system performs other tasks simultaneously, you might want to grant a higher priority to the Nginx worker processes. In this case, you should decrease the value—the smaller the value, the higher the priority. Values range from -20 (highest priority) to 19 (lowest priority). 
	- `log_not_found on;` -- This directive specifies whether Nginx should log 404 errors or not. While these errors may, of course, provide useful information about missing resources, a lot of them may be generated by web browsers trying to reach the favicon (the conventional /favicon.ico of a website) or robots trying to access the indexing instructions (robots.txt). Set this to off if you want to ensure your log files don't get cluttered by "Error 404" entries, 
	- `worker_connections 1024` -- This setting, combined with the amount of worker processes, allows you to define the total amount of connections accepted by the server simultaneously. If you enable four worker processes, each accepting 1,024 connections, your server will treat a total of 4,096 simultaneous connections  RAM and CPU power your server relies on, the more connections you can accept concurrently.
	
- `Adapting to your hardware` -- :
	- __low traffic setup__ -- 
		- CPU: Dual-core
		- RAM: 2 GB
		- Requests: ~ 1/s
		```
		worker_processes 2;
		worker_rlimit_nofile
		1024;
		worker_priority -5;
		worker_cpu_affinity
		01 10;
		events {
			multi_accept on;
			work
		er_connections 128;
		}
		```
	- __standart setup__ --
		- CPU: Quad-core
		- RAM: 4 GB
		- Requests: ~ 50/s
		```
		worker_processes 4;
  	worker_rlimit_nofile
		8192;
		worker_priority 0;
		worker_cpu_affinity
		0001 0010 0100 1000;
		events {
			multi_accept off;
			work
		er_connections
		1024;
		}
		```
	- __high traffic setup__ --
		- CPU: 8-core
		- RAM: 12 GB
		- Requests: ~1000/s
		```
		worker_processes
		8;
		worker_priority 0;
		worker_rlimit_
		nofile 16384;
		events {
			multi_accept
		off;
		worker_connections
		8192;
		}
		```
	
	There are two adjustments that have a critical effect on the performance, namely, the amount of worker processes and the connection limit. The first one, if set improperly, may clutter particular cores of your CPU and leave other ones unused or underused. Make sure the worker_processes match the quantity of cores in your CPU.
 
 	Unfortunately, there is no simple equation to calculate the value of the worker_connections directive; you will need to base it on expected traffic estimations.
 
 ### Testing your server
 
 - `Creating a test server` -- In order to perform simple tests, such as connecting to the server with a web browser, we need to set up a website for Nginx to serve. A test page comes with the default package in the html folder (/usr/local/nginx/html/index.html) and the original nginx.conf is configured to serve this page.
 		```
		http {
       include       mime.types;
       default_type  application/octet-stream;
       sendfile        on;
       keepalive_timeout  65;
			 
			 server {
					listen       80;
					server_name  localhost;
					location / {
					root html;
							index  index.html index.htm;
					}
					
			 error_page   500 502 503 504  /50x.html;
			 location = /50x.html {
				 root html; 
			 }
		}
		```
		For more details about these directives, please refer to Chapter 3

- `Performance tests` -- Having configured the basic functioning and the architecture of your Nginx setup, you may already want to proceed with running some tests. The methodology here is experimental—run the tests, edit the configuration, reload the server, run the tests again, edit the configuration again, and so on. Ideally, you should avoid running the testing tool on the same computer that is used to run Nginx as it may cause the results to be biased.

	We have retained three tools to evaluate the server performance here. All three applications were specifically designed for load tests on web servers and have different approaches due to their origin:
	- httperf
	- autobench
	- OpenWebLoad
	
	The principle behind each of these tools is to generate a massive amount of HTTP requests in order to clutter the server and study the results.

- `Httperf` -- The source comes as a tar.gz archive and needs to be compiled using the standard method: ./configure, make, and make install.

	Once installed, you may execute the following command:
	```
	alex@example ~]$ httperf --server 192.168.1.10 --port 80 --uri /index.
	html --rate 300 --num-conn 30000 --num-call 1 --timeout 5
	```
	Replace the values in the preceding command with your own
	- • --server: The website hostname you wish to test
	- • --uri: The path of the file that will be downloaded
	- • --rate: How many requests should be sent every second
	- • --num-conn: The total amount of connections
	- • --num-call: How many requests should be sent per connection
	- • --timeout: Quantity of seconds elapsed before a request is considered lost

- `Autobench` -- Autobench is a Perl script that makes use of httperf more efficiently—it runs continuous tests and automatically increases request rates until your server gets saturated. One of the interesting features of Autobench is that it generates a .tsv report that you can open with various applications to generate graphs.

	Once again, extract the files from the archive, run makethenmake install.
	```
	[alex@example ~]$ autobench --single_host --host1 192.168.1.10 --uri1 /
	index.html --quiet --low_rate 20 --high_rate 200 --rate_step 20 --num_
	call 10 --num_conn 5000 --timeout 5 --file results.tsv
	```
	- • --host1: The website host name you wish to test
	- • --uri1: The path of the file that will be downloaded
	- • --quiet: Does not display httperf information on the screen
	- • --low_rate: Connections per second at the beginning of the test
	- • --high_rate: Connections per second at the end of the test
	- • --rate_step: The number of connections to increase the rate by after each test
	- • --num_call: How many requests should be sent per connection
	- • --num_conn: Total amount of connections
	- • --timeout: The number of seconds elapsed before a request is considered lost
	- • --file: Export results as specified (.tsv file)
	
- `OpenWebLoad` -- OpenWebLoad is a free open source application. It is available for both Linux and Windows platforms

- `Upgrading Nginx gracefully` --
 
 <br>
 <br>
 
 ---
 
 <br>
 <br>
 
 # HTTP Configuration
 
 ### HTTP Core Module
 
 ### Module Directives
 
 ### Module variables
 
 ### The Location block
 
 <br>
 <br>
 
 ---
 
 <br>
 <br>
 
 # Module Configuration
 
 ### Rewrite module
 
 ### SSI module
 
 ### Additional modules
 
 <br>
 <br>
 
 ---
 
 <br>
 <br>
 
 # PHP and Python with Nginx
 
 ### Introduction to FastCGI
 
 ### Python and Nginx
