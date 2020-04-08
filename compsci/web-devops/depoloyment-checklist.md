## Django Checklist

- [ ] `SECRET_KEY` -- Make sure that the key used in production isn’t used anywhere else and avoid committing it to source control. This reduces the number of vectors from which an attacker may acquire the key.
- [ ] `DEBUG` -- You must never enable debug in production.
- [ ] `ALLOWED_HOSTS` -- When DEBUG = False, Django doesn’t work at all without a suitable value for ALLOWED_HOSTS. You should also configure the Web server that sits in front of Django to validate the host. It should respond with a static error page or ignore requests for incorrect hosts instead of forwarding the request to Django.
- [ ] `CACHES` -- If you’re using a cache, connection parameters may be different in development and in production. Django defaults to per-process local-memory caching which may not be desirable. Cache servers often have weak authentication. Make sure they only accept connections from your application servers.
- [ ] `DATABASES` -- Database connection parameters are probably different in development and in production. Database passwords are very sensitive. You should protect them exactly like SECRET_KEY.
- [ ] `EMAIL_BACKEND` -- and related settings. If your site sends emails, these values need to be set correctly.
- [ ] `STATIC_ROOT and STATIC_URL` -- Static files are automatically served by the development server. In production, you must define a STATIC_ROOT directory where collectstatic will copy them.
- [ ] `MEDIA_ROOT and MEDIA_URL¶` -- Media files are uploaded by your users. They’re untrusted! Make sure your web server never attempts to interpret them. For instance, if a user uploads a .php file, the web server shouldn’t execute it.
- [ ] `CSRF_COOKIE_SECURE` -- Set this to True to avoid transmitting the CSRF cookie over HTTP accidentally.
- [ ] `SESSION_COOKIE_SECURE` -- Set this to True to avoid transmitting the session cookie over HTTP accidentally.
- [ ]  Consider using cached sessions to improve performance. If using database-backed sessions, regularly clear old sessions to avoid storing unnecessary data.
- [ ] `CONN_MAX_AGE` -- This helps a lot on virtualized hosts with limited network performance.
- [ ] `TEMPLATES` -- Enabling the cached template loader often improves performance drastically, as it avoids compiling each template every time it needs to be rendered.
- [ ] `LOGGING` -- Review your logging configuration before putting your website in production, and check that it works as expected as soon as you have received some traffic.
- [ ] `ADMINS` -- should/must be notified of 500 errors by email.
- [ ] Run `manage.py check --deploy` to check if there is something fishy. 
- [ ] Fucking make sure you have your backups. It is your insurance.

## Nginx

- ...

## Gunciorn 

- ...

## ++

more will be added
