# Deploying Django Apps

Once your site is finished up or finished enough for public testing you re going to need to host it somewhere more accssesible than your personal computer. 

Up to now you have been working in a development enviroemnt before you can push your site to production you need to make these:

- Make a few changes to project settings
- Choose an envioremnet for hosting the django app.
- Choose an enviroement for hosting static files.
- Set up a production level infustructre for serving your website.

## Things to consider while choosing a host

- How busy the site is likely to be and the cost of data and computing resources required to meet the demand.
- Level of support for scaling horizontally (adding more machines) and vertically (upgrading to more powerful machines) and the costs of doing so.
- Where the supplier has data centres, and hence where access is likely to be fastest.
- The host's historical uptime and downtime performance.
- Tools provided for managing the site — are they easy to use and are they secure (e.g. SFTP vs FTP).
- Inbuilt frameworks for monitoring your server.
- Known limitations. Some hosts will deliberately block certain services (e.g. email) . Others offer only a certain number of hours of "live time" in some price tiers, or only offer a small amount of storage.
- Additional benefits. Some providers will offer free domain names and support for SSL certificates that you would otherwise have to pay for.
- Whether the "free" tier you're relying on expires over time, and whether the cost of migrating to a more expensive tier means you would have been better off using some other service in the first place!

---

## Changing projects settings.py file

*Tip: t is common to have a separate settings.py file for production, and to import sensitive settings from a separate file or an environment variable. This file should then be protected, even if the rest of the source code is available on a public repository.* 

The critical settings you must check are : 
- `DEBUG` : this should be set to `False` in production .
- `SECRET_KEY` : I didnt understand how to secure my secret_key at the moment so im skipping it for now .....

A full checklist of settings you might want to change is provided in [deployment checklist django docs](https://docs.djangoproject.com/en/2.0/howto/deployment/checklist/). You can also list a number of these using the terminal command below:

```
$ python manage.py check --deploy
```

You should definelty check securing settings.py because i didnt get what the turoial is doing....


---

## Installing django app on Heroku

Why heroku? Heroku is one of the longest runing and popular cloud-based PaaS service. We are choosing heroku for few reasons:

- Heroku has a [real free tier](https://www.heroku.com/pricing) that is really free. (of course it has lmitations)
- As a PaaS, Heroku takes care of a lot of the web infrastructure for us. This makes it much easier to get started, because you don't worry about servers, load balancers, reverse proxies, or any of the other web infrastructure that Heroku provides for us under the hood.
- While it does have some limitations these will not affect this particular application. For example:
  - Heroku provides only short-lived storage so user-uploaded files cannot safely be stored on Heroku itself.
  - The free tier will sleep an inactive web app if there are no requests within a half hour period. The site may then take several seconds to respond when it is woken up.
  - The free tier limits the time that your site is running to a certain amount of hours every month (not including the time that the site is "asleep"). This is fine for a low use/demonstration site, but will not be suitable if 100% uptime is required.
  - Other limitations are listed in [Limits](https://devcenter.heroku.com/articles/limits) (Heroku docs).

### How does heroku work 

In order to execute your application Heroku needs to be able to set up the appropriate environment and dependencies, and also understand how it is launched. For Django apps we provide this information in a number of text files:

- `runtime.txt` : the programming language and version to use
- `requirements.txt` : the python component dependices, eg. django, pillow
- `Procfile` :  A list of processes to be executed to start the web application. For Django this will usually be the Gunicorn web application server (with a .wsgi script).
- `wsgi.py` : [WSGI](http://wsgi.readthedocs.io/en/latest/what.html) configuration to call our Django application in the Heroku environment.

Developers interact with Heroku using a special client app/terminal, which is much like a Unix bash script. This allows you to upload code that is stored in a git repository, inspect the running processes, see logs, set configuration variables and much more!

In order to get our application to work on Heroku we'll need to put our Django web application into a git repository, add the files above, integrate with a database add-on, and make changes to properly handle static files.

Once we've done all that we can set up a Heroku account, get the Heroku client, and use it to install our website.(This tutorial may be outdated in the future so be sure to check herokus official documentation)

### Procfile 

Create the file Procfile (no extension) in the root of your GitHub repository to declare the application's process types and entry points. Copy the following text into it:

```
 web: gunicorn entry_project_folder.wsgi --log-file -
```

The `"web:"` tells Heroku that this is a web dyno and can be sent HTTP traffic. The process to start in this dyno is gunicorn, which is a popular web application server that Heruko recommends. We start Gunicorn using the configuration information in the module `entry_project_folder.wsgi` (created with our application skeleton: /entry_project_folder/wsgi.py).

### Gunicorn 

[Gunicorn](http://gunicorn.org/) is the recommended HTTP use with Django on Heroku (as referenced in the Procfile above).
While we won't need Gunicorn to serve our Django application during development, we'll install it so that it becomes part of our requirements for Heroku to set up on the remote server.

```
$ pip install gunicorn 
```

### Database configuration

We can't use the default SQLite database on Heroku because it is file-based, and it would be deleted from the ephemeral file system every time the application restarts (typically once a day, and every time the application or its configuration variables are changed).

We will use postgresql which is a common sql for django applications deployed on heroku with free tier. Heroku recommends we use the `dj-database-url` package to parse the `DATABASE_URL`. In addition to dj-databse-url we need to isntall [psycopg2](http://initd.org/psycopg/) as django needs this to intearct with Postgres database

Install dj-database-url locally so that it becomes part of our requirements for Heroku to set up on the remote server:
```
$ pip install dj-database-url
```

Open /project-folder/settings.py and copy the following configuration into the bottom of the file:

```python
# Heroku: Update database configuration from $DATABASE_URL.
import dj_database_url
db_from_env = dj_database_url.config(conn_max_age=500)
DATABASES['default'].update(db_from_env)
```

*Note:  We'll still be using SQLite during development because the DATABASE_URL environment variable will not be set on our development computer.*
*The value conn_max_age=500 makes the connection persistent, which is far more efficient than recreating the connection on every request cycle. However, this is optional and can be removed if needed.*


