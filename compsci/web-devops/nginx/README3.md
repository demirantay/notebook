[previous: part 2](./README2.md)

<br>
<Br>

# HTTP Configuration

- This module constitutes the essential component of the HTTP configuration—it allows you to set up websites to be served, also referred to as virtual hosts.
 
 ### HTTP Core Module
 
 - The HTTP Core module is the component that contains all of the fundamental blocks, directives, and variables of the HTTP server.
 
 	This module is the largest of all standard Nginx modules—it provides an impressive amount of directives and variables. In order to understand all of these new elements and how they come into play, we first need to understand the logical organization introduced by the three main blocks—http, server, and location.
	
- `Structure Blocks` -- the HTTP module introduces three new logical blocks:
	- • `http`: This block is inserted at the root of the configuration file. It allows you to start defining directives and blocks from all modules related to the HTTP facet of Nginx. Although there is no real purpose in doing so, the block can be inserted multiple times, in which case the directive values inserted in the last block will override the previous ones.
	- • `server`: This block allows you to declare a website. In other words, a specific website (identified by one or more hostnames, for example, www.mywebsite. com) becomes acknowledged by Nginx and receives its own configuration. This block can only be used within the http block.
	- • `location`: Lets you define a group of settings to be applied to a particular location on a website. The next part of this section provides more details about the location block. This block can be used within a server block or nested within another location block.
	
	The HTTP section, defined by the http block, encompasses the entire web-related configuration. It may contain one or more server blocks, defining the domains and sub-domains that you are hosting.
	```
	http {
		# Enable gzip compression at the http block level 
		gzip on;

		server {
			server_name localhost;
			listen 80;

			# At this stage, gzip still set to on

			location /downloads/ { 
					gzip off;
					#    This directive only applies to documents found
					#    in /downloads/
			} 
	  }
	}
	```
 
 ### Module Directives
 
 - At each of the three levels, directives can be inserted in order to affect the behavior of the web server. The following is the list of all directives that are introduced by the main HTTP module
 
 	Some cannot be used at certain levels. For instance, it would make no sense to insert a server_name directive inside a location block.
	
- `listen` -- Context: server
	- Specifies the IP address and/or the port to be used by the listening socket that will serve the website. Sites are generally served on port 80
	- Syntax:listen [address][:port] [additional options];
	- Additional options:
		- • default_server: Specifies that this server block is to be used as the default website for any request received at the specified IP address and port
		- • ssl: Specifies that the website should be served using SSL
		- • Other options are related to the bind and listen system calls: backlog=num, rcvbuf=size, sndbuf=size, accept_filter=filter, deferred, setfib=number, and bind
		```
		listen 192.168.1.1:80;
		listen 127.0.0.1;
		listen [:::a8c9:1234]:80; # IPv6 addresses must be put between square
		```

- `server_name` -- Context: server
	- Assigns one or more hostnames to the server block. When Nginx receives an HTTP request, it matches the Host header of the request against all of the server blocks. The first server block to match this hostname is selected.
	- Note that this directive accepts wildcards as well as regular expressions (in which case, the hostname should start with the ~ character).
	- Syntax:server_name hostname1 [hostname2...];
	```
	server_name www.website.com;
  server_name www.website.com website.com;
  server_name *.website.com;
	server_name *.website.*;
	```
 
 - `server_name_in_redirect` -- Context: http, server, location
 	- This directive applies the case of internal redirects. If set to on, Nginx will use the first hostname specified in the server_name directive. If set to off, Nginx will use the value of the Host header from the HTTP request.
 	- Syntax: on or off
	- Default value: off
	
- `server_names_hash_max_size` -- Context: http
	- Nginx uses hash tables for various data collections in order to speed up the processing of requests. This directive defines the maximum size of the server names hash table. The default value should fit with most configurations.
	- Syntax: Numeric value
	- Default value: 512
	
- `server_names_hash_bucket_size` -- Context: http
	- Sets the bucket size for server names hash tables. Similarly, you should only change
this value if Nginx tells you to.
	- Syntax: Numeric value
	- Default value: 32 (or 64, or 128, depending on your processor cache specifications).
	
- `port_in_redirect` -- Context: http, server, location
	- In the case of a redirect, this directive defines whether or not Nginx should append
the port number to the redirection URL.
	- Syntax: on or off
	- Default value: on
	
- `tcp_nodelay` -- Context: http, server, location
	- Enables or disables the TCP_NODELAY socket option for keep-alive connections only.
	- Syntax: on or off
	- Default value: on
	
- `tcp_nopush` -- Context: http, server, location
	- Enables or disables the TCP_NOPUSH (FreeBSD) or TCP_CORK (Linux) socket option
	- Syntax: on or off
	- Default value: off
	
- `sendfile` -- Context: http, server, location
	- If this directive is enabled, Nginx will use the sendfile kernel call to handle file transmission
	- Syntax: on or off
	- Default value: off
	
- `sendfile_max_chunk` -- Context: http, server
	- This directive defines a maximum size of data to be used for each call to sendfile
(read above).
	- Syntax: Numeric value (size)
	- Default value: 0
	
- `send_lowat` -- Context: http, server
	- An option allowing you to make use of the SO_SNDLOWAT flag for TCP sockets under FreeBSD only. 
	- Syntax: Numeric value (size)
	- Default value: 0
	
- `reset_timedout_connection` -- Context: http, server, location
	- When a client connection times out, its associated information may remain in memory depending on the state it was on. Enabling this directive will erase all memory associated to the connection after it times out.
	- Syntax: on or off
	- Default value: off
	
- `root` -- Context: http, server, location, if. Variables are accepted.
	- Defines the document root, containing the files you wish to serve to your visitors.
	- Syntax: Directory path
	- Default value: html
	```
	root /home/website.com/public_html;
	```
	
- `alias` -- Context: location. Variables are accepted.
	
	alias is a directive that you place in a location block only. It assigns a different path for Nginx to retrieve documents for a specific request
	```
	http {
      server {
          server_name localhost;
          root /var/www/website.com/html;
           location /admin/ {
           alias /var/www/locked/;
         }
	} }
	```
	
- `error_page` -- Context: http, server, location, if. Variables are accepted.

	Allows you to affect URIs to HTTP response code and optionally to substitute the
code with another.

	Syntax:error_page code1 [code2...] [=replacement code] [=@block | URI]
	```
	error_page 404 /not_found.html;
  error_page 500 501 502 503 504 /server_error.html;
  error_page 403 http://website.com/;
	```
	
- `if_modified_since` -- Context: http, server, location

	Defines how Nginx handles the If-Modified-Since HTTP header. This header is mostly used by search engine spiders (such as Google web crawling bots). 
	
	Syntax:if_modified_since off | exact | before
	
	Default value: exact
	
- `index` -- Context: http, server, location. Variables are accepted.

	Defines the default page that Nginx will serve if no filename is specified in the request
	
	Syntax:index file1 [file2...] [absolute_file];
	
	Default value: index.html
	```
	index index.php index.html index.htm;
	```
	
- `recursive_error_pages` -- 

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
