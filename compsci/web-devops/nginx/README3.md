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
	
- `recursive_error_pages` -- Context: http, server, location

	Sometimes an error page itself served by the error_page directive may trigger an error, in this case the error_page directive is used again (recursively). This directive enables or disables recursive error pages.
	
	Syntax: on or off
	
	Default value: off
	
- `try_files` -- Context: server, location. Variables are accepted.

	Attempts to serve the specified files (arguments 1 to N-1), if none of these files exist, jumps to the respective named location block (last argument) or serves the specified URI.
	```
   location / {
       try_files $uri $uri.html $uri.php $uri.xml @proxy;
   }
   # the following is a "named location block"
   location @proxy {
       proxy_pass 127.0.0.1:8080;
   }
	```
	
- `keepalive_timeout` -- Context: http, server, location
	
	This directive defines the amount of seconds the server will wait before closing a keep-alive connection. 
	
	Syntax:keepalive_timeout time1 [time2];
	
	Default value: 75;
	```
	keepalive_timeout 75;
  keepalive_timeout 75 60;
	```
	
- `keepalive_disable` -- Context: http, server, location

	This option allows you to disable the keepalive functionality for the browser
families of your choice.

	Syntax:keepalive_disable browser1 browser2;
	
	Default value: msie6
	
- send_timeout` -- Context: http, server, location
	
	The amount of time after which Nginx closes an inactive connection. A connection
becomes inactive the moment a client stops transmitting data. 

	Syntax: Time value (in seconds)
	
	Default value: 60
	
- `client_body_in_file_only` -- Context: http, server, location

	If this directive is enabled, the body of incoming HTTP requests will be stored into actual files on the disk (in other words, the content transmitted in POST requests). Files are stored as plain text documents.
	
	Syntax:client_body_in_file_only on | clean | off 
	
	Default value: off
	
- `client_body_in_single_buffer` -- Context: http, server, location

	Defines whether or not Nginx should store the request body in a single buffer
in memory. 

	Syntax: on or off 
	
	Default value: off
	
- `client_body_buffer_size` -- Context: http, server, location

	Specifies the size of the buffer holding the body of client requests. 
	
	Syntax: Size value
	
	Default value: 8k or 16k (2 memory pages) depending on your computer architecture
	
- `client_body_temp_path` -- Context: http, server, location

	Allows you to define the path of the directory that will store the client request body files. An additional option lets you separate those files into a folder hierarchy over up to three levels.
	
	Syntax:client_body_temp_path path [level1] [level2] [level3]
	
- `client_body_timeout` -- Context: http, server, location

	Defines the inactivity timeout while reading a client request body. A connection becomes inactive the moment the client stops transmitting data. If the delay is reached, Nginx returns a 408 Request timeout HTTP error.
	
	Syntax: Time value (in seconds) 
	
	Default value: 60
	
- `client_header_buffer_size` -- Context: http, server, location

	This directive allows you to define the size of the buffer that Nginx allocates to request headers. Usually, 1k is enough.
	
	Syntax: Size value 
	
	Default value: 1k
	
- `client_header_timeout` -- Context: http, server, location

	Defines the inactivity timeout while reading a client request header. A connection becomes inactive the moment the client stops transmitting data. If the delay is reached, Nginx returns a 408 Request timeout HTTP error.
	
	Syntax: Time value (in seconds)
	
	Default value: 60
	
- `client_max_body_size` -- Context: http, server, location

	It is the maximum size of a client request body. If this size is exceeded, Nginx returns a 413 Request entity too large HTTP error
	
	Syntax: Size value 
	
	Default value: 1m
	
- `large_client_header_buffers` -- Context: http, server, location

	Defines the amount and size of larger buffers to be used for storing client requests, in case the default buffer (client_header_buffer_size) was insufficient. Nginx returns the 414 Request URI too large error.
	
	Syntax:large_client_header_buffers amount size 
	
	Default value: 4*8 kilobytes

- `lingering_time` -- Context: http, server, location

	This directive applies to client requests with a request body. As soon as the amount of uploaded data exceeds max_client_body_size, Nginx immediately sends a 413 Request entity too large HTTP error response. However, most browsers continue uploading data regardless of that notification. This directive defines the amount of time Nginx should wait after sending this error response before closing the connection.
	
	Syntax: Numeric value (time) 
	
	Default value: 30 seconds
	
- `lingering_timeout` -- Context: http, server, location

	This directive defines the amount of time that Nginx should wait between two read
operations before closing the client connection. 

	Syntax: Numeric value (time)

	Default value: 5 seconds

- `lingering_close` -- Context: http, server, location

	Controls the way Nginx closes client connections. Set this to off to immediately close connections after all of the request data has been received.
	
	Syntax: on, off, or always 
	
	Default value: on

- `ignore_invalid_headers` -- Context: http, server

	If this directive is disabled, Nginx returns a 400 Bad Request HTTP error in case request headers are malformed.
	
	Syntax: on or off 
	
	Default value: on
	
- `chunked_transfer_encoding` --Context: http, server, location

	Enables or disables chunked transfer encoding for HTTP 1.1 requests. 
	
	Syntax: on or off

	Default value: on
	
- `max_ranges` --Context: http, server, location

	Defines how many byte ranges Nginx will accept to serve when a client requests partial content from a file. If you do not specify a value, there is no limit. If you set this to 0, the byte range functionality is disabled.

- `types` -- Context: http, server, location

	This directive allows you to establish correlations between MIME types and file
extensions. It's actually a block accepting a particular syntax:
	```
	types {
     mimetype1  extension1;
     mimetype2  extension2 [extension3...];
     [...]
	}
	```
	When Nginx serves a file, it checks the file extension in order to determine the MIME type. 
	
	Nginx includes a basic set of MIME types as a standalone file (mime.types) to be included with the include directive:
	```
	include mime.types;
	```
	
	The default values, if the mime.types file is not included, are:
	```
	types {
		text/html html;
		image/gif gif;
		image/jpeg jpg;
	}
	```
	
- `default_type` -- Context: http, server, location
	
	Defines the default MIME type. When Nginx serves a file, the file extension is matched against the known types declared within the types block in order to return the proper MIME type as value of the Content-Type HTTP response header. If the extension doesn't match any of the known MIME types, the value of the default_ type directive is used.

	Syntax: MIME type 
	
	Default value: text/plain
	
- `types_hash_max_size` -- Context: http, server, location
	
	Defines the maximum size of an entry in the MIME types hash table. 
	
	Syntax: Numeric value.

	Default value: 4 k or 8 k (1 line of CPU cache)
	
- `limit_except` -- Context: location

	This directive allows you to prevent the use of all HTTP methods, except the ones that you explicitly allow. Within a location block, you may want to restrict the use of some HTTP methods, such as forbidding clients from sending POST requests.
	```
	location /admin/ {
				 limit_except GET {
					 allow 192.168.1.0/24;
					 deny all; 
	   }
	}
	```
	The syntax is particular:
	```
	limit_except METHOD1 [METHOD2...] {
     allow | deny | auth_basic | auth_basic_user_file | proxy_pass | perl; 
	}
	```
	
- > I am not going to note worn the rest of the directives because there are too many here are notable important ones that you will use daily:
		- limit_rate
		- limit_rate_after
		- satisfy
		- internal
		- disable_symlinks
		- directio
		- directio_alignment
		- open_file_cache
		- open_file_cache_errors
		- open_file_cache_min_uses
		- open_file_cache_valid
		- read_ahead
		- log_not_found
		- log_subrequest
		- merge_slashes
		- msie_padding
		- msie_refresh
		- resolver
		- resolver_timeout
		- server_tokens
		- underscores_in_headers
		- variables_hash_max_size
		- variables_hash_bucket_size
		- post_action
	
 ### Module variables
 
 - The HTTP Core module introduces a large set of variables that you can use within the value of directives. Be careful though, as only a handful of directives accept variables in the definition of their value.
 
 - `Request headers` -- Nginx lets you access the client request headers under the form of variables
 	- `$http_host` -- Value of the Host HTTP header, a string indicating the hostname that the client is trying to reach.
	- `$http_user_agent` -- Value of the User-Agent HTTP header, a string indicating the web browser of the client.
	- `$http_referer` -- Value of the Referer HTTP header, a string indicating the URL of the previous page from which the client comes.
	- `$http_via` -- Value of the Via HTTP header, which informs us about possible proxies used by the client.
	- `$http_x_forwarded_for` -- Value of the X-Forwarded-For HTTP header, which shows the actual IP address of the client if the client is behind a proxy.
	- `$http_cookie` -- Value of the Cookie HTTP header, which contains the cookie data sent by the client.
	- `$http_...` -- Additional headers sent by the client can be retrieved using $http_ followed by the header name in lowercase and with dashes (-) replaced by underscores (_).
 
 - `Response headers` -- In a similar fashion, you are allowed to access the HTTP headers of the response that was sent to the client. 
 	- `$sent_http_content_type` -- Value of the Content-Type HTTP header, indicating the MIME type of the resource being transmitted.
	- `$sent_http_content_length` -- Value of the Content-Length HTTP header informing the client of the response body length.
	- `$sent_http_location` -- Value of the Location HTTP header, which indicates that the location of the desired resource is different than the one specified in the original request.
	- `$sent_http_last_modified` -- Value of the Last-Modified HTTP header corresponding to the modification date of the requested resource.
	- `$sent_http_connection` -- Value of the Connection HTTP header, defining whether
the connection will be kept alive or closed.
	- `$sent_http_keep_alive` -- Value of the Keep-Alive HTTP header that defines the amount of time a connection will be kept alive.
	- `$sent_http_transfer_encoding` -- Value of the Transfer-Encoding HTTP header, giving information about the response body encoding method (such as compress, gzip).
	- `$sent_http_cache_control` -- Value of the Cache-Control HTTP header, telling us whether the client browser should cache the resource or not.
	- `$sent_http_...` -- Additional headers sent to the client can be retrieved using $sent_http_ followed by the header name, in lowercase and with dashes (-) replaced by underscores (_).
 
 - `Nginx generated` -- Apart from the HTTP headers, Nginx provides a large amount of variables concerning the request, the way it was and will be handled,
 	- `$arg_XXX
	- ... etc there are much more ... check the official docs
 
 ### The Location block
 
 - Nginx allows you to define location blocks by specifying a pattern that will be matched against the requested document URI.
 	```
	server {
       server_name website.com;
       location /admin/ {
       # The configuration you place here only applies to
       # http://website.com/admin/
       }
  }
	```
	Instead of a simple folder name, you can indeed insert complex patterns. The syntax of the location block is:
	```
	location [=|~|~*|^~|@] pattern { ... }
	```
 
  - `The = modifier` -- The requested document URI must match the specified pattern exactly. The pattern here is limited to a simple literal string; you cannot use a regular expression:
	```
	server {
       server_name website.com;
       location = /abcd {
       [...]
       }
	}
	```
 	- Applies to http://website.com/abcd (exact match)
	- Applies to http://website.com/abcd?param1&param2 (regardless of query string arguments)
	- Does not apply to http://website.com/abcd/ (trailing slash)
 
 - `No modifier` -- The requested document URI must begin with the specified pattern. You may not use regular expressions:
 	```
	server {
       server_name website.com;
       location /abcd {
       [...]
       }
 	}
	```
	- Applies to http://website.com/abcd (exact match)
	- Applies to http://website.com/abcd/ (trailing slash)
 
 - `The ~ modifier` -- The requested URI must be a case-sensitive match to the specified regular expression:
 	```
	server {
       server_name website.com;
       location ~ ^/abcd$ {
       [...]
       }
	}
	```
	The ^/abcd$ regular expression used in this example specifies that the pattern must begin (^) with /, be followed by abc, and finish ($) with d.
	- Applies to http://website.com/abcd (exact match)
	- Does not apply to http://website.com/abcd/ (trailing slash) due to the specified regular expression
 
 - `The ~* modifier` -- 
 	```
	server {
       server_name website.com;
       location ~* ^/abcd$ {
       [...]
       }
	}
	```
	The regular expression used in the example is similar to the previous one.
	- Applies to http://website.com/abcd (exact match)
	- Applies to http://website.com/ABCD (case-insensitive)
	- Does not apply to http://website.com/abcd/ (trailing slash) due to the specified regular expression
 
 - `The @ modifier` -- Defines a named location block. These blocks cannot be accessed by the client, but only by internal requests generated by other directives, such as try_files or error_page.
 
 - `Search order and priority` -- Since it's possible to define multiple location blocks with different patterns, you need to understand that when Nginx receives a request, it searches for the location block that best matches the requested URI:
 	- 1 - location blocks with the = modifier: If the specified string exactly matches the requested URI, Nginx retains the location block.
	- 2 - location blocks with no modifier: If the specified string exactly matches the requested URI, Nginx retains the location block.
	- 3 - location blocks with the ^~ modifier: If the specified string matches the beginning of the requested URI, Nginx retains the location block.
	- 4 - location blocks with ~ or ~* modifier: If the regular expression matches the requested URI, Nginx retains the location block.
	- 5 - location blocks with no modifier: If the specified string matches the beginning of the requested URI, Nginx retains the location block.
 
 - `case` -- 
 	```
	server {
       server_name website.com;
       location ^~ /doc {
       [...] # requests beginning with "/doc"
       }
       location ~* ^/document$ {
       [...] # requests exactly matching "/document"
       }
	}
	```
 	Which block applies when a client visits http://website.com/document? The answer is the first block. The reason being that ^~ has priority over ~*. As a result, any request with a URI beginning with / doc will be affected to the first block, even if the request URI matches the regular expression defined in the second block.
	
 ### Summary
 
 - All along this chapter we studied key concepts of the Nginx HTTP configuration. First, we learned about creating virtual hosts by declaring server blocks. Then
we discovered the directives and variables of the HTTP Core module that can be inserted within those blocks and eventually understood the mechanisms governing the location block.
 
 <br>
 <br>
 
 ---
 
 <br>
 <br>
 
 [part 4](./README4.md)
 

