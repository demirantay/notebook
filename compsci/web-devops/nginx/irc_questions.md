#### do you reccomend gunicorn, FastCGI or uWSGI to make the connection between python and nginx ? and why it is your choice ?

- `answer`: it's typically a choice between gunicorn and uwsgi

<br>

#### is a cgi (common gateway interface) is the same thing as an application server ?  I know that I will have a connection between my nginx process and django application and I will use the cgi to make a connection between them but what is the techonology that turns my django app into a application server ?

- `answer`: "an application server" is just a general idea that just means that a tech is serving your applciation, the tech that serves the application can be anything, nginx, gunciron your own wsgi app ... etc. 

  The 'normal' setup you see quite often is something like (client) -> (loadbalancer(s)) -> (web server(s)) -> (application server(s)).

<br>

#### is it a good practice to enable all of the nginx modules in the initial configuration because i can always turn them off or not include or use them. Or is it better to ?

- `answer`: 

<br>

#### is it better to have the html files in the default usr/local/www or does configuring a path that makes them located inside the /usr/local/etc/nginx/ make more sense since all the project files will be in a single directory ?

- `answer`:

<br>


#### how long does making an server architecture usually take ?

- As with any setup it takes a bit to stabilize on a setup and then it usually lasts until things break or new features are needed. (or someone read a blog post about something hip and decides to redo it all)

  oh okay dont change it unless you want to add features or if it breaks
