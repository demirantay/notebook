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
 
 - `the easy way` -- 
 
 - `path options` -- 
 
 - `preprequisite options` -- 
 
 - `module options` -- 
 
 - `modules enabled by defalt` --
 
 - `modules disabled by default` -- 
 
 - `miscellaneous options` --
 
 - `configuration examples` -- 
 
 - `all modules enabled` -- 
 
 - `mail server proxy` --
 
 - `build configuration issues` --
 
 - `direcotires exist and are writable` --
 
 - `compiling and installing` -- 
 
 ### Controlling the Nginx Service
 
 ### Adding Nginx as a system service
 
 <br>
 <br>
 
 ---
 
 <br>
 <Br>
 
 # Basic Nginx Configuration
 
 ### Configuration File syntax
 
 ### Base Module Directives
 
 ### A configuration for your profile
 
 ### Testing your server
 
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
