# Nginx Http Server Book Notes

Table of Contets:
  - [Downloading and Installing Nginx]()
    - [Setting up the prerequisites]()
    - [Downloading Nginx]()
    - [Configure Options]()
    - [Controlling the Nginx Service]()
    - [Adding Nginx as a system service]()
  - [Basic Nginx Configuration]()
    - [Configuration File syntax]()
    - [Base Module Directives]()
    - [A configuration for your profile]()
    - [Testing your server]()
  - [HTTP Configuration]()
    - [HTTP Core Module]()
    - [Module Directives]()
    - [Module variables]()
    - [The Location block]()
  - [Module Configuration]()
    - [Rewrite module]()
    - [SSI module]()
    - [Additional modules]()
  - [PHP and Python with Nginx]()
    - [Introduction to FastCGI]()
    - [Python and Nginx]()
    
 <br>
 <br>
 
 ---
 
 <br>
 <br>
 
 # Downloading and Installing Nginx
 
 - there are some required libraries and tools for installing the web server
 
 ### Setting up the prerequisites
 
 - As you can see, we have chosen to download the source code of the application and compile it manually, as opposed to installing it using a package manager, such as Yum, Aptitude, or Yast
 
   As a result of this choice, your system will require some tools and libraries for the compilation process
 
   We will guide you through the process of installing the most common ones, such as GCC, PCRE, zlib, and OpenSSL.
   
 - `GCC – GNU Compiler Collection` -- Nginx is a program written in C, so you will first need to install a compiler tool such as the GNU Compiler Collection (GCC) on your system.
 
   GCC can be installed using the default repositories of your package manager. Depending on your distribution, the package manager will vary—yum for a Red Hat-based distribution, apt for Debian and Ubuntu If you use apt-get:
   ```
   [root@example.com ~]# apt-get install build-essentials
   ```
   
 - `The PCRE Library` -- The Perl Compatible Regular Expression (PCRE) library is required for compiling Nginx. The Rewrite and HTTP Core modules of Nginx use PCRE for the syntax of their regular expressions, as we will discover in later chapters. You will need to install two packages—pcre and pcre-devel. The first one provides the compiled version of the library, whereas the second one provides development headers and source for compiling projects
 
   If you use apt-get:
   ```
   [root@example.com ~]# apt-get install libpcre3 libpcre3-dev
   ```
   
 - `The zlib library` -- The zlib library provides developers with compression algorithms it is required for the use of gzip compression in various modules of Nginx.
 
   Similarto PCRE you will need both the library and its source zlib and zlib-devel
   
   Using apt-get
   ```
   root@example.com ~]# apt-get install zlib1g zlib1g-dev
   ```
 
 - `Open SSL` -- The OpenSSL project is a collaborative effort to develop a robust, commercial-grade, full-featured, and open source toolkit implementing the Secure Sockets Layer (SSL v2/v3) and Transport Layer Security (TLS v1) protocols as well as a full-strength general purpose cryptography library. The project is managed by a worldwide community of volunteers 
 
   The OpenSSL library will be used by Nginx to serve secure web pages. We thus need to install the library and its development package. The process remains the same here—you install openssl and openssl-devel:
 
    Using apt-get:
    ```
    root@example.com ~]# apt-get install openssl openssl-dev
    ```
    Please be aware of the laws and regulations in your own country. Some countries do not allow usage of a strong cryptography.
 
 ### Downloading Nginx
 
 - `version branches` -- There are currently three version branches on the project:
  - Stable version: This version is usually recommended, as it is approved by both developers and users, but is usually a little behind the development version.
  - • Development version: This is the latest version available for download. Although it is generally solid enough to be installed on production servers, you may run into the occasional bug. As such, the stable version is recommended, even though you do not get to use the latest features.
  - • Legacy version: If, for some reason, you are interested in looking at the older versions, you will find several of them.
 
 - `Features` -- Here is a list of the main features of the web branch, quoted from the official website www.nginx.org:
  - Handling of static files, index files, and autoindexing; open file descriptor cache.
  - • Accelerated reverse proxying with caching; simple load balancing and fault tolerance.
  - • Accelerated support with caching of remote FastCGI servers; simple load balancing and fault tolerance.
  - • Modular architecture. Filters include Gzipping, byte ranges, chunked responses, XSLT, SSI, and image resizing filter. Multiple SSI inclusions within a single page can be processed in parallel if they are handled by FastCGI or proxied servers.
  - • SSL and TLS SNI support (TLS with Server Name Indication (SNI), required for using TLS on a server doing virtual hosting).
  
    Nginx can also be used as a mail proxy server, although this aspect is not closely documented in the book:
    
    Nginx is compatible with many computer architectures and operating systems such as Windows, Linux, Mac OS, FreeBSD, and Solaris.
    
 - `downloading and extracting` -- Once you have made your choice as to which version you will be using, head over to www.nginx.org and find the URL of the file you wish to download. Position yourself in your home directory, which will contain the source code to be compiled, and download the file using wget:
    ```
    [alex@example.com ~]$ mkdir src && cd src
    [alex@example.com src]$ wget http://nginx.org/download/nginx-1.2.9.tar.gz
    ```
     We will be using version 1.2.9, the latest stable version as of April, 2013. Once downloaded, extract the archive contents in the current folder:
    ```
    [alex@example.com src]$ tar zxf nginx-1.2.9.tar.gz
    ```
    You have successfully downloaded and extracted Nginx. Now, the next step will be to configure the compilation process in order to obtain a binary that perfectly fits your operating system.

 ### Configure Options
 
 - There are usually three steps when building an application from source—the configuration, the compilation, and the installation. The configuration step allows you to select a number of options that will not be editable after the program is built, as it has a direct impact on the project binaries. Consequently, it is a very important stage that you need to follow carefully if you want to avoid surprises later, such as the lack of a specific module or files being located in a random folder.
 
  The process consists of appending certain switches to the configure script that comes with the source code
 
 - `the easy way` -- If, for some reason, you do not want to bother with the configuration step, such as for testing purposes or simply because you will be recompiling the application in the future, you may simply use the configure command with no switches
    ```
    [alex@example.com nginx-1.2.9]# ./configure
    ```
    The make command will compile the application. This step should not cause any errors as long as the configuration went fine:
    ```
    [alex@example.com nginx-1.2.9]# make
    ```
    This last step will copy the compiled files as well as other resources to the installation directory, by default, /usr/local/nginx.
    ```
    [root@example.com nginx-1.2.9]# make install
    ```
    Again, if you build the application without configuring it, you take the risk to miss out on a lot of features, such as the optional modules and others
    
 - `path options` -- When running the configure command, you are offered the possibility to enable some switches that let you specify the directory or file paths for a variety of elements. Please note that the options offered by the configuration switches may change according to the version you downloaded. If you use another version, run the configure --help command to list the available switches for your setup.
 
    Using a switch typically consists of appending some text to the command line. For instance, using the --conf-path switch:
    ```
    [alex@example.com nginx-1.2.9]# ./configure --conf-path=/etc/nginx/nginx.conf
    ```
    
    Here is an exhaustive list of the configuration switches for configuring paths:
    
    |**Switch**|**Usage**|**Default Value**|
    |--|--|--|
    |--prefix=...|The base folder in which Nginx will be installed.|/usr/local/nginx.|
    |--sbin-path=...|The path where the Nginx binary file should be installed.|<prefix>/sbin/nginx.|
    |--conf-path=...|The path of the main configuration file.|<prefix>/conf/nginx.conf.|
    |--error-log-path=...|The location of your error log.|<prefix>/logs/error.log.|
    |--pid-path=...|The path of the Nginx pid file|<prefix>/logs/nginx.pid.|
    |--lock-path=...|The location of the lock file|<prefix>/logs/nginx.lock.|
    |--with-perl_modules_path=...| Defines the path to the Perl modules.| |
    |--with-perl=...|Defines the path to the Perl modules| |
    |--with-perl=...|Path to the Perl binary file; used for executing Perl scripts.| |
    |--http-log-path=...|Defines the location of the access logs|<prefix>/logs/access.log.|
    |--http-client-body-temp-path=...|Directory used for storing temporary files generated by client requests.| <prefix>/client_body_temp|
    |--http-proxy-temp-path=...|Location of the temporary files used by the proxy.|<prefix>/proxy_temp|
    |--http-fastcgi-temp-path=...|Location of the temporary files used by the HTTP|Respectively <prefix>/ fastcgi_temp,|
    |--http-uwsgi-temp-path=...|FastCGI, uWSGI, and SCI modules.|<prefix>/uwsgi_temp, and <prefix>/scgi_temp.|
    |--http-scgi-temp-path=...| | |
    |--builddir=...|Location of the application build.| |
 
 - `preprequisite options` -- Prerequisites come in the form of libraries and binaries. You should by now have them all installed on your system. Yet, even though they are present on your system, there may be occasions where the configuration script cannot locate them.
 
    In order to solve such problems, you are given the option to specify the path of prerequisites using the following switches.
    
    compiler options:
    - `--with-cc=...` -- Specifies an alternate location for the C compiler.
    - `--with-cpp=...` -- Specifies an alternate location for the C preprocessor.
    - `--with-cc-opt=...` -- Defines additional options to be passed to the C compiler command line.
    - `--with-ld-opt=...` -- Defines additional options to be passed to the C linker command line.
    - `--with-cpu-opt=...` -- Specifies a different target processor architecture, among the following values: pentium, pentiumpro, pentium3, pentium4, athlon, opteron, sparc32, sparc64, and ppc64.
    
    PCRE options:
    - `--without-pcre` -- Disables usage of the PCRE library. This setting is not recommended, as it will remove support for regular expressions, consequently disabling the Rewrite module.
    - `--with-pcre` -- Forces usage of the PCRE library.
    - `--with-pcre=...` -- Allows you to specify the path of the PCRE library source code.
    - `--with-pcre-opt=...` -- Additional options for building the PCRE library.
    - `--with-pcre-jit=...` -- Build PCRE with JIT compilation support.

    MD5 options:
    - `--with-md5=...` -- Specifies the path to the MD5 library sources.
    - `--with-md5-opt=...` -- Additional options for building the MD5 library.
    - `--with-md5-asm` -- Uses assembler sources for the MD5 library.
    
    SHA1 options:
    - `--with-sha1=...` -- Specifies the path to the SHA1 library sources.
    - `--with-sha1-opt=...` -- Additional options for building the SHA1 library.
    - `--with-sha1-asm` -- Uses assembler sources for the SHA1 library.
    
    zlib options:
    - `--with-zlib=...` -- Specifies the path to the zlib library sources.
    - `--with-zlib-opt=...` -- Additional options for building the zlib library.
    - `--with-zlib-asm=...` -- Uses assembler optimizations for the following target architectures: pentium, pentiumpro.
    
    OpenSSL options:
    - `--with-openssl=...` -- Specifies the path of the OpenSSL library sources.
    - `--with-openssl-opt=...` -- Additional options for building the OpenSSL library.
    
    Libatomic options:
    - `--with-libatomic=...` -- Forces usage of the libatomic_ops library on systems other than x86, amd64, and sparc. This library allows Nginx to perform atomic operations directly instead of resorting to lock files. Depending on your system, it may result in a decrease in SEGFAULT errors and possibly higher request serving rate.
    - `--with-libatomic=...` -- Specifies the path of the Libatomic library sources.
 
 - `module options` -- Modules, which will be detailed in Chapter 3, HTTP Configuration, and further, need to be selected before compiling the application. Some are enabled by default and some need to be enabled manually, as you will see in the following table. Please note that an exhaustive and more detailed list of modules can be found in Appendix B, Module Reference.
 
  - `modules enabled by defalt` -- The following switches allow you to disable modules that are enabled by default:
    - `--without-http_charset_module` -- Disables the Charset module for re-encoding web pages.
    - `--without-http_gzip_module` -- Disables the Gzip compression module.
    - `--without-http_ssi_module` -- Disables the Server Side Include module
    - `--without-http_userid_module` -- Disables the User ID module providing user identification via cookies.
    - `--without-http_access_module` -- Disables the Access module allowing access configuration for IP address ranges.
    - `--without-http_auth_basic_module` -- Disables the Basic Authentication module.
    - `--without-http_autoindex_module` -- Disables the Automatic Index module.
    - `--without-http_geo_module` -- Disables the Geo module allowing you to define variables depending on IP address ranges.
    - `--without-http_map_module` -- Disables the Map module that allows you to declare map blocks.
    - `--without-http_referer_module` -- Disables the Referer control module.
    - `--without-http_rewrite_module` -- Disables the Rewrite module.
    - `--without-http_proxy_module` -- Disables the Proxy module for transferring requests to other servers.
    - `--without-http_fastcgi_module` -- Disables the FastCGI, uWSGI, or SCGI modules for interacting with respectively FastCGI, uWSGI, or SCGI processes.
    - `--without-http_uwsgi_module` -- Disables the FastCGI, uWSGI, or SCGI modules for interacting with respectively FastCGI, uWSGI, or SCGI processes.
    - `--without-http_scgi_module` -- Disables the FastCGI, uWSGI, or SCGI modules for interacting with respectively FastCGI, uWSGI, or SCGI processes.
    - `--without-http_memcached_module` -- Disables the Memcached module for interacting with the memcache daemon.
    - `--without-http_limit_conn_module` -- Disables the Limit Connections module for restricting resource usage according to defined zones.
    - `--without-http_limit_req_module` -- Disables the Limit Requests module allowing you to limit the amount of requests per user.
    - `--without-http_empty_gif_module` -- Disables the Empty Gif module for serving a blank GIF image from memory.
    - `--without-http_browser_module` -- Disables the Browser module for interpreting the User Agent string.
    - `--without-http_upstream_ip_hash_module` -- Disables the Upstream module for configuring load-balanced architectures.
    - `--without-http_upstream_least_conn_module` -- Disables the Least Connections feature
 
 - `modules disabled by default` -- The following switches allow you to enable modules that are disabled by default:
    - `--with-http_ssl_module` -- Enables the SSL module for serving pages using HTTPS.
    - `--with-http_realip_module` -- Enables the Real IP module for reading the real IP address from the request header data.
    - `--with-http_addition_module` -- Enables the Addition module which lets you append or prepend data to the response body.
    - `--with-http_xslt_module` -- Enables the XSLT module for applying XSL transformations to XML documents.
Note: You will need to install the libxml2 and libxslt libraries on your system if you wish to compile these modules.
    - `--with-http_image_filter_module` -- Enables the Image Filter module that lets you apply modification to images.
Note: You will need to install the libgd library on your system if you wish to compile this module.
    - `--with-http_geoip_module` -- Enables the GeoIP module for achieving geographic localization using MaxMind's GeoIP binary database. Note: You will need to install the libgeoip library on your system if you wish to compile this module.
    - `--with-http_sub_module` -- Enables the Substitution module for replacing text in web pages.
    - `--with-http_dav_module` -- Enables the WebDAV module (Distributed Authoring and Versioning via Web).
    - `--with-http_flv_module` -- Enables the FLV module for special handling of .flv (Flash video) files.
    - `--with-http_mp4_module` -- Enables the MP4 module for special handling of .mp4 video files.
    - `--with-http_gzip_static_module` -- Enables the Gzip Static module for sending pre- compressed files.
    - `--with-http_random_index_module` -- Enables the Random Index module for picking a random file as the directory index.
    - `--with-http_secure_link_module` -- Enables the Secure Link module to check the presence of a keyword in the URL.
    - `--with-http_stub_status_module` -- Enables the Stub Status module, which generates a server statistics and information page.
    - `--with-google_perftools_module` -- Enables the Google Performance Tools module
    - `--with-http_degradation_module` -- Enables the Degradation module that controls the behavior of your server depending on current resource usage.
    - `--with-http_perl_module` -- Enables the Perl module allowing you to insert Perl code directly into your Nginx configuration files, and to make Perl calls from SSI.
 
 - `miscellaneous options` -- Other options are available in the configuration script, for example, regarding the mail server proxy feature or event management.
    - `--with-mail` -- Enables mail server proxy module. Supports POP3, IMAP4, SMTP. It is disabled by default.
    - `--with-mail_ssl_module` -- Enables SSL support for the mail server proxy. It is disabled by default.
    - `--without-mail_pop3_module` -- Disables the POP3 module for the mail server proxy. It is enabled by default when the mail server proxy module is enabled.
    - `--without-mail_imap_module` -- Disables the IMAP4 module for the mail server proxy. It is enabled by default when the mail server proxy module is enabled.
    - `--without-mail_smtp_module` -- Disables the SMTP module for the mail server proxy. It is enabled by default when the mail server proxy module is enabled.
    - `--with-rtsig_module` -- Enables the rtsig module to use rtsig as event notification mechanism.
    - `--with-select_module` -- Enables the select module to use select as event notification mechanism. By default, this module is enabled unless a better method is found on the system—kqueue, epoll, rtsig, or poll.
    - `--without-select_module` -- Disables the select module
    - `--with-poll_module` -- Enables the poll module to use poll as event notification mechanism. By default, this module is enabled if available, unless a better method is found on the system—kqueue, epoll, or rtsig.
    - `--without-poll_module` -- Disables the poll module.
    - `--user=...` -- Default user account for starting the Nginx worker processes. This setting is used only if you omit to specify the user directive in the configuration file.
    - `--group=...` -- Default user group for starting the Nginx worker processes. This setting is used only if you omit to specify the group directive in the configuration file.
    - `--with-ipv6` -- Enables IPv6 support.
    - `--without-http` -- Disables the HTTP server.
    - `--without-http-cache` -- Disables HTTP caching features.
    - `--add-module=PATH` -- Adds a third-party module to the compile process
by specifying its path. This switch can be repeated indefinitely if you wish to compile multiple modules.
    - `--with-debug` -- Enables additional debugging information to be logged.
    - `--with-file-aio` -- Enables support for Asynchronous IO disk operations.
 
 - `configuration examples` -- Here are a few examples of configuration commands that may be used for various cases
 
    During the configuration, you should take particular care over the --prefix switch. Many of the future configuration directives (that we will approach in further chapters) will be based on the path you select at this point. While it is not a definitive problem since absolute paths can still be employed, you should know that the prefix cannot be changed once the binaries have been compiled
    
     The default prefix is /usr/local/nginx.
     
     It is thus recommended to use a different prefix for each version you will be using:
     ```
     ./configure --prefix=/usr/local/nginx-1.2.9
     ```
 
 - `all modules enabled` -- The next situation: the entire package. All modules are enabled and it is up to you whether you want to use them or not at runtime:
    ```
    ./configure --user=www-data --group=www-data --with-http_ssl_module
    --with-http_realip_module --with-http_addition_module --with-http_xslt_
    module --with-http_image_filter_module --with-http_geoip_module --with-
    http_sub_module --with-http_dav_module --with-http_flv_module --with-
    http_mp4_module --with-http_gzip_static_module --with-http_random_index_
    module --with-http_secure_link_module --with-http_stub_status_module
    --with-http_perl_module --with-http_degradation_module
    ```
    With this setup, all optional modules are enabled, thus requiring additional libraries to be installed—libgeoip for the Geo IP module, libgd for the Image Filter module, libxml2, and libxslt for the XSLT module. You may install those prerequisites using your system package manager such as running yum install libxml2 or apt- get install libxml2.
 
 - `mail server proxy` -- This last build configuration is somewhat special as it is dedicated to enabling mail server proxy features—a darker and less documented side of Nginx
    ```
    ./configure --user=www-data --group=www-data --with-mail --with-mail_ssl_module
    ```
 
 - `build configuration issues` -- In some cases, the configure command may fail—after a long list of checks, you may receive a few error messages on your terminal. In most (if not all) cases, these errors are related to missing prerequisites or unspecified paths.
 
 - `direcotires exist and are writable` -- Always remember to check the obvious; everyone makes even the simplest of mistakes sooner or later. Make sure the directory you placed the Nginx files in has read and write permissions for the user running the configuration and compilation scripts. Also ensure that all paths specified in the configure script switches are existing, valid paths.
 
 - `compiling and installing` -- The configuration process is of utmost importance—it generates a makefile for the application depending on the selected switches and performs a long list of requirement checks on your system. Once the configure script is successfully executed, you can proceed with compiling Nginx.
 
    Compiling the project equates to executing the make command in the project source directory:
    ```
    [alex@example.com nginx-1.2.9]$ make
    ```
    A successful build should result in a final message appearing: make[1]: leaving directory followed by the project source path.
    
    If the compilation process was successful, you are ready for the next step: installing the application. The following command must be executed with root privileges:
    ``` 
    [root@example.com nginx-1.2.9]# make install
    ```
    The make install command executes the install section of the makefile. In other words, it performs a few simple operations, such as copying binaries and configuration files to the specified install folder. It also creates directories for storing log and HTML files if these do not already exist. 
    
    > You might require root privileges for installing the application in the /usr/local/ folder, depending on the folder permissions.
 
 ### Controlling the Nginx Service
 
 - At this stage, you should have successfully built and installed Nginx. The default location for the output files is /usr/local/nginx, so we will be basing future examples on this.
 
- `Daemons and services` -- The next step is obviously to execute Nginx. However, before doing so, it's important to understand the nature of this application. There are two types of computer applications—those that require immediate user input, thus running on the foreground, and those that do not, thus running in the background. Nginx is of the latter type, often referred to as `daemon`.

    When started from the command line, a daemon immediately returns the prompt, and in most cases, does not even bother outputting data to the terminal.
    
    Consequently, when starting Nginx you will not see any text appear on the screen and the prompt will return immediately. While this might seem startling, it is
on the contrary a good sign. It means the daemon was started correctly and the configuration did not contain any errors.

- `User and Group` -- It is of utmost importance to understand the process architecture of Nginx and particularly the user and groups its various processes run under. A very common source of troubles when setting up Nginx is invalid file access permissions—due to a user or group misconfiguration, you often end up getting 403 Forbidden HTTP

  There are two levels of processes with possibly different permission sets:
  - The Nginx master process, which should be started as root. In most Unix-like systems, processes started with the root account are allowed to open TCP sockets on any port, whereas other users can only open listening sockets on
a port above 1024. If you do not start Nginx as root, standard ports such as
80 or 443 will not be accessible
  - The Nginx worker processes, which are automatically spawned by the master process under the account you specified in the configuration file with the user directive (detailed in Chapter 2, Basic Nginx Configuration). The configuration setting takes precedence over the configure switch you may have entered at compile time. If you did not specify any of those, the worker processes will be started as user nobody, and group nobody

- `Nginx command-line switches` -- The Nginx binary accepts command-line arguments for performing various operations, among which is controlling the background processes. To get the full list of commands, you may invoke the help screen using the following commands:
  ```
  [alex@example.com ~]$ cd /usr/local/nginx/sbin
  [alex@example.com sbin]$ ./nginx -h
  ```
  The next few sections will describe the purpose of these switches.

- `Starting and stopping the daemon` -- You can start Nginx by running the Nginx binary without any switches. If the daemon is already running, a message will show up indicating that a socket is already listening on the specified port:
  ```
  [emerg]: bind() to 0.0.0.0:80 failed (98: Address already in use) [...]
  [emerg]: still could not bind().
  ```
  Beyond this point, you may control the daemon by stopping it, restarting it, or simply reloading its configuration. Controlling is done by sending signals to the process using the `nginx -s` command:
  - `nginx -s stop` -- Stops the daemon immediately (using the TERM signal)
  - `nginx -s quit` -- Stops the daemon gracefully (using the QUIT signal)
  - `nginx -s reopen` -- Reopens the log files
  - `nginx -s reload` -- Reloads the configuration

- `Testing the configuration` -- As you can imagine, this tiny bit of detail might become an important issue if you constantly tweak your configuration. In consequence, the following command will be useful to you in many occasions. It allows you to check the syntax, validity, and integrity of your configuration:
  ```
  [alex@example.com ~]$ /usr/local/nginx/sbin/nginx –t
  ```
  The –t switch stands for test configuration. Nginx will parse the configuration anew and let you know whether it is valid or not.
  
  Obviously, manipulating your configuration files while your server is in production is a dangerous thing to do and should be avoided at all costs. The best practice, in this case, is to place your new configuration into a separate temporary file and run the test on that file. 
  ```
  [alex@example.com sbin]$ ./nginx –t –c /home/alex/test.conf
  ```

- `Other Swtiches` --
 
 ### Adding Nginx as a system service
 
 <br>
 <br>
 
 ---
 
 <br>
 <Br>
 
 [ part 2](./README2.md)
