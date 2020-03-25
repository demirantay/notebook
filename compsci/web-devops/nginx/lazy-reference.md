File locations:

- `nginx.conf` to `/usr/local/etc/nginx/`
- `default.conf` and `default-ssl.conf` to `/usr/local/etc/nginx/sites-available`
- `homebrew.mxcl.nginx.plist` to `/Library/LaunchDaemons/`

- `Default Configuration` --
  ```
  server {
      listen       80;
      server_name  localhost;

      #access_log  logs/host.access.log  main;

      location / {
          root   html;
          index  index.html index.htm;
      }

      #error_page  404              /404.html;

      # redirect server error pages to the static page /50x.html
      #
      error_page   500 502 503 504  /50x.html;
      location = /50x.html {
          root   html;
      }
  }
  ```
- Default nginx.conf with the boilerplate code that you usually need:
  ```
  #user  nobody;
  worker_processes  1;

  error_log  /Library/Logs/nginx/error.log;

  events {
      worker_connections  1024;
  }

  http {
      include       mime.types;
      default_type  application/octet-stream;

      log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
                        '$status $body_bytes_sent "$http_referer" '
                        '"$http_user_agent" "$http_x_forwarded_for"';

      access_log  /Library/Logs/nginx/access.log  main;

      sendfile        on;

      keepalive_timeout  65;

      index index.html index.php;

      upstream www-upstream-pool{
          server unix:/tmp/php-fpm.sock;
      }

      include /etc/nginx/conf.d/*.conf;
      include /usr/local/etc/nginx/sites-enabled/*.conf; 
  }
  ```
