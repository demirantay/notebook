# Nginx

- Nginx, pronounced "engine X", is a fast and lightweight web server, that can be used to serve static files, but is often used as a reverse proxy. It has some very nice features like load balancing and rate limiting. We'll cover some common use cases like serving files, creating a directory listing, reverse proxying to pass incoming traffic to a local web server, adding SSL encryption, and how to require https and www on your site. This guide is for someone who needs a quick reference to setting up a simple nginx server. For the latest documentation always check out the official website https://www.nginx.com/ and the source mirror at https://github.com/nginx/nginx.

### Why use nginx?

- Use nginx if you need to reverse proxy, load balance, and rate limit network services. Reverse proxying useful if you have multiple web services listening on various ports and you need a single public endpoint to reroute requests internally.

  By setting up nginx to listen on port 80 and 443, you can set up your other web services on low-privilege ports that listen locally only. Nginx can handle the logging, load balancing, blacklisting, and serving static files while the web services focus on what they need to do.

<br>
<br>

---

<br>
<br>

# Installing Nginx

### Building from the Source

- If possible, this is a great option to get the latest version. Linux distribution package managers often lag behind and don't have the latest version

  The first step is to download and extract the nginx source zip or tar.gz. Find a release from the read-only GitHub repo (https://github.com/nginx/nginx/releases) or the upstream Nginx.org Mercurial repo. Find the latest release tag, like http://hg.nginx.org/nginx/rev/release-1.15.5.
  ```bash 
  # Download & extract
  wget https://github.com/nginx/nginx/archive/release-1.15.5.tar.gz
  tar xzfv release-1.15.5.tar.gz
  cd nginx-release-1.15.5
  
  # Build
  sudo apt-get install build-essential # If you need gcc and make
  auto/configure
  make
  ```
    - Executable in objs/
    - Executable file: objs/nginx
    - Sample configs in conf/
    - Default config: conf/nginx.conf
    
  To run nginx after building it from source, you'll want to create a directory for nginx to use as it's working directory. This is where temporary directories will be created, log files will be stored relative to this location, config files will be relative to here.
  ```bash
  # Create a workspace (prefix) for nginx
  mkdir /path/to/nginx_workspace
  mkdir /path/to/nginx_workspace/logs
  vim /path/to/nginx_workspace/my.conf
  ```
  To start and stop nginx use -s flag with a "stop" or "start" command.
  ```bash
  # Start nginx
  # -p is the workspace directory
  # -c is the config file
  ./nginx -p /home/dano/nginx_workspace -c my.conf

  # Stop nginx with `-s stop` flag
  # Must specify the prefix/workspace dir so it knows
  # which nginx instance to start/stop
  ./nginx -p /home/dano/nginx_workspace -c my.conf -s stop
  ```

### Ubuntu 

- The easiest way to get nginx on Ubuntu is to install using apt-get.
  ```bash
  # See what version is available in the repos
  apt-cache show nginx

  # Install with apt-get package manager
  sudo apt-get install nginx

  # It will be started by default. Control it with:
  sudo systemctl stop nginx
  sudo systemctl start nginx
  sudo systemctl restart nginx

  # View logs with:
  journalctl -u nginx

  # Get the status with:
  sudo systemctl status nginx
  ```
  Important locations:
  - Base config file: /etc/nginx/nginx.conf
  - Default config: /etc/nginx/sites-available/default
  - Logs will be in /var/log/nginx/
  - Custom configs will go in /etc/nginx/conf.d/ or /etc/nginx/sites-available and then symlinked to /etc/nginx/sites-enabled
  - Default webroot: /var/www/html

### Fedora

- The easiest way to get nginx on Fedora is to install using dnf.
  ```bash
  # Install with dnf package manager
  sudo dnf install nginx

  # Control it with:
  sudo systemctl stop nginx
  sudo systemctl start nginx
  sudo systemctl restart nginx

  # View logs with:
  journalctl -u nginx

  # Get the status with:
  sudo systemctl status nginx
  ```
  Important locations:
  - Base config file: /etc/nginx/nginx.conf
  - Directory for custom configs: /etc/nginx/conf.d/
  - Logs directory: /var/log/nginx/
  - Default webroot: /usr/share/nginx/html/

### Mac

- On a Mac computer, use Homebrew or follow the build nginx from source instructions.
  ```bash
  # Install with Homebrew
  brew install nginx

  # Start and stop nginx, sudo needed for low number ports
  nginx  
  nginx -s stop

  # or control it using brew services
  brew services start nginx
  brew services stop nginx
  ```
  Important locations:
  - Default listen address: http://localhost:8080
  - Default web root: /usr/local/var/www/
  - Default config file: /usr/local/etc/nginx/nginx.conf
  - Add custom configs in: /usr/local/etc/nginx/servers/
  - Logs will be in in: /usr/local/var/log/nginx/
    

<br>
<br>

---

<br>
<br>

# Serve Static Files 

