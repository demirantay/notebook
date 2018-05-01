# Settings & Requirements Files

## Using Multiple Settings Files

Instead of having `settings.py` file have a `settings/` directory containing your settings files. The directory will contain something like this:

```
settings/
    __init__.py
    base.py
    local.py
    staging.py
    test.py
    production.py
```

- `base.py` == Settings common to all instances of the project
- `local.py` == This settings is when you use locally developing your web app. Local development specific settings include DEBUG mode , log level, activation of developer tools 
- ` staging.py` == Staging version for running a semi-private version of the site on a production server. This is where managers and clients should be looking before your work is moved to production.
- `test.py` == Settings for running tests inlcuding test runners, in-memory database definitions and log settings.
- `production.py` == This is the settings file used by our live production servers 

*Note: You will also want to have a `ci.py` module containing that servers integration settings.*

### A development settings example 

As mentioned erlier we need settings file solely for development purpose
