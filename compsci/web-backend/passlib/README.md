# Passlib

- Passlib is a password hashing library for Python 2 & 3, which provides cross-platform implementations of over 30 password hashing algorithms, as well as a framework for managing existing password hashes. It’s designed to be useful for a wide range of tasks, from verifying a hash found in /etc/shadow, to providing full-strength password hashing for multi-user application.

  As a quick sample, the following code hashes and then verifies a password using the PBKDF2-SHA256 algorithm (this can be bcrpyt... etc. too they are all implemented inside the passlibrary however for a uick guide lets use sha):
  ```python
  >>> # import the hash algorithm
  >>> from passlib.hash import pbkdf2_sha256

  >>> # generate new salt, and hash a password
  >>> hash = pbkdf2_sha256.hash("toomanysecrets")
  >>> hash
  '$pbkdf2-sha256$29000$N2YMIWQsBWBMae09x1jrPQ$1t8iyB2A.WF/Z5JZv.lfCIhXXN33N23OSgQYThBYRfk'

  >>> # verifying the password
  >>> pbkdf2_sha256.verify("toomanysecrets", hash)
  True
  >>> pbkdf2_sha256.verify("joshua", hash)
  False
  ```
  
<br>

---

<br>
  
# Installation
  
- Use pip to intall:
  ```
  pip install passlib
  ```
  
- If you want a particular setup you can use the following:
  - `pip install passlib[bcrypt]` to get the recommended bcrypt setup.
  - `pip install passlib[argon2]` to get the recommended argon2 setup.
  - `pip install passlib[totp]` to get the recommended TOTP setup.
  
<br>

---

<br>
  
# Library Overview

- Passlib’s contents can be roughly grouped into four categories: password hashes, password contexts, two-factor authentication, and other utility functions.

- `Password Hashes` -- All of the hashes supported by Passlib are implemented as “hasher” classes which can be imported from the `passlib.hash` module. A word of warning: Some the hashes in this library are marked as “insecure”, and are provided for historical purposes only. Still others are specialized in ways that are not generally useful.

- `Password Contexts` -- Mature applications frequently have to deal with tables of existing password hashes. Over time, they have to support a number of tasks
  - Add support for new algorithms, and deprecate old ones. ... etc.
  
  In these situations, loading and handling multiple hash algorithms becomes complicated and tedious. The `passlib.context` module provides a single class, `CryptContext`, which attempts to solve all of these problems

- `Application Helpers` -- Passlib also provides a number of pre-configured CryptContext instances in order to get users started quickly:
  - `passlib.apps` – contains pre-configured instances for managing hashes used by Postgres, Mysql, and LDAP, and others.
  - `passlib.hosts` – contains pre-configured instances for managing hashes as found in the /etc/shadow files on Linux and BSD systems.
  
<br>

---

<br>
  
# New Application Quickstart Guide
  
- `Choosing a Hash` -- If you’d like to set up a configuration that’s right for your application, the first thing to do is choose a password hashing scheme There are currently four good choices for secure hashing:
  - 1 - argon2
  - 2 - bcrypt
  - 3 - pbkdf2_sha256 / pbkdf2_sha512
  - 4 - sha256_crypt / sha512_crypt
  
  All four hashes share the following properties:
  - No known vulnerabilities.
  - Based on documented and widely reviewed algorithms.
  - Public-domain or BSD-licensed 
  - At least 96 bits of salt.
  
  The top choices are bcrypt and pbkdf2_sha256. Both have advantages, and their respective rough edges; though currently the balance is in favor of bcrypt (pbkdf2 can be cracked somewhat more efficiently).
  
- `Creating and Using a CryptContext` -- Once you’ve chosen what password hash(es) you want to use, the next step is to define a CryptContext object to manage your hashes and related policy configuration. 
  ```python
  from passlib.context import CryptContext
  
  # create a single global instance for your app...
  pwd_context = CryptContext(
    # Replace this list with the hash(es) you wish to support.
    # this example sets pbkdf2_sha256 as the default,
    # with additional support for reading legacy des_crypt hashes.
    schemes=["pbkdf2_sha256", "des_crypt"],
    
    # Automatically mark all but first hasher in list as deprecated.
    # (this will be the default in Passlib 2.0)
    deprecated="auto",
    )
  ```
  To start using your CryptContext, import the context you created wherever it’s needed:
  ```python
  >>> from myapp.moduleName import pwd_context
  
  >>> # hashing a password...
  >>> hash = pwd_context.hash("somepass")
  >>> hash
  '$pbkdf2-sha256$29000$BSBkLEXIeS9FKMW4F.I85w$SJMzqVU7fw49NDOJZHt2o9vKIfDUVM4cKlAD4MxIgD0'
  
  >>> # verifying a password...
  >>> pwd_context.verify("somepass", hash)
  True
  >>> pwd_context.verify("wrongpass", hash)
  False
  ```

<br>

---

<br>
  
# Password Hash Tutorial

- Passlib supports a large number of hash algorithms, all of which can be imported from the passlib.hash module. While the exact options and behavior will vary between each algorithm, all of the hashes provided by Passlib use the same interface, defined by the `passlib.ifc.PasswordHash` abstract class.

  The PasswordHash class provides a generic interface for interacting individually with the various hashing algorithms
  - Creating & verifying hashes
  - Examining the configuration of a hasher, and customizing the defaults.
  - Assorting supplementary methods.

- `Hashing & Verifying` -- While all the hashers in passlib.hash offer a range of methods and attributes, the main activities applications will need to perform is hashing and verifying passwords.

  First, import the desired hash. The following example uses the pbkdf2_sha256
  ```python
  >>> from passlib.hash import pbkdf2_sha256
  ```
  Use PasswordHash.hash() to hash a password. This call takes care of unicode encoding, picking default rounds values, and generating a random salt:
  ```python
  >>> hash = pbkdf2_sha256.hash("password")
  >>> hash
  '$pbkdf2-sha256$29000$9t7be09prfXee2/NOUeotQ$Y.RDnnq8vsezSZSKy1QNy6xhKPdoBIwc.0XDdRm9sJ8'
  ```
  Note that since each call generates a new salt, the contents of the resulting hash will differ between calls (despite using the same password as input):
  ```python
  >>> hash2 = pbkdf2_sha256.hash("password")
  >>> hash2
  '$pbkdf2-sha256$29000$V0rJeS.FcO4dw/h/D6E0Bg$FyLs7omUppxzXkARJQSl.ozcEOhgp3tNgNsKIAhKmp8'
  ```
  
  Subsequently, you can call PasswordHash.verify() to check user input against an existing hash:
  ```
  >>> pbkdf2_sha256.verify("password", hash)
  True

  >>> pbkdf2_sha256.verify("joshua", hash)
  False
  ```
  > For the majority of hash algorithms and use-cases, passwords should be provided as either unicode (or utf-8-encoded bytes).

- `Customizing the Configuration` -- Each hasher contains a number of informational attributes. many of which can be customized to change the properties of the hashes generated by __PasswordHash.hash()__. When you want to change the defaults, you don’t have to modify the hasher class directly

  Instead, all the hashes offer a __PasswordHash.using()__ method. This is a powerful method which accepts most hash informational attributes, as well as some other hash-specific configuration keywords; and returns a subclass of the original hasher (or a object with an identical interface). The returned object inherits the defaults settings from it’s parent, but integrates any values you choose to override.
  
  As an example, if the hasher you select supports a variable number of iterations (such as pbkdf2_sha256), you can specify a custom value using the __rounds__ keyword:
  ```python
  >>> from passlib.hash import pbkdf2_sha256
  >>> pbkdf2_sha256.default_rounds
  29000
  
  >>> custom_pbkdf2 = pbkdf2_sha256.using(rounds=123456)
  >>> custom_pbkdf2.default_rounds
  123456
  ```
  
  While hashes frequently have additional keywords supported by using, the basic set of settings you can customize can be found by inspecting the __PasswordHash.setting_kwds__ attribute:
  ```python
  >>> pbkdf2_sha256.settings_kwds
  ("salt", "salt_size", "rounds")
  ```

- `Identifying Hashes` -- attempting to call PasswordHash.verify() with another algorithm’s hash will result in a ValueError:
  ```python
  >>> from passlib.hash import pbkdf2_sha256, md5_crypt
  >>> other_hash = md5_crypt.hash("password")
  >>> pbkdf2_sha256.verify("password", other_hash)
  
  Traceback (most recent call last):
      <traceback omitted>
  ValueError: not a valid pbkdf2_sha256 hash
  ```
  This can be prevented by using the identify method, which determines whether a hash belongs to a given algorithm:
  ```python
  >>> hash = pbkdf2_sha256.hash("password")
  >>> pbkdf2_sha256.identify(hash)
  True
  
  >>> pbkdf2_sha256.identify(other_hash)
  False
  ```

- `Choosing the right rounds value` -- The right rounds value for a given hash & server should be the largest possible value that doesn’t cause intolerable delay for your users.

  For most public facing services, you can generally have signin take upwards of 250ms - 400ms before users start getting annoyed. For superuser accounts, it should take as much time as the admin can stand (usually ~4x more delay than a regular account). Since larger values mean increased work for an attacker…

<br>

---

<br>
  
# CryptContext Tutorial

- The passlib.context module contains one main class: `passlib.context.CryptContext`. This class is designed to take care of many of the more frequent coding patterns which occur in applications that need to handle multiple password hashes at once:
  - identifying the algorithm used by a hash, and then verify a password.
  - configure the default algorithm, load in support for new algorithms, deprecate old ones, set defaults for time-cost parameters, etc.
  - migrate hashes / re-hash passwords when an algorithm has been deprecated.
  - load said configuration from a sysadmin configurable file.

- `Basic Usage` -- At its base, the __CryptContext__ class is just a collection of PasswordHash objects, imported by name from the _passlib.hash_ module. The following snippet creates a new context object which supports three hash algorithm:
  ```python
  >>> from passlib.context import CryptContext
  >>> myctx = CryptContext(schemes=["sha256_crypt", "md5_crypt", "des_crypt"])
  ```
  This new object exposes a very similar set of methods to the PasswordHash interface, and hashing and verifying passwords is equally as straightforward: 
  ```python
  >>> # this loads first algorithm in the schemes list (sha256_crypt),
  >>> # generates a new salt, and hashes the password:
  >>> hash1 = myctx.hash("joshua")
  >>> hash1
  '$5$rounds=80000$HFEGd1wnFknpibRl$VZqjyYcTenv7CtOf986hxuE0pRaGXnuLXyfb7m9xL69'
  
  >>> # when verifying a password, the algorithm is identified automatically:
  >>> myctx.verify("gtnw", hash1)
  False
  >>> myctx.verify("joshua", hash1)
  True
  ```
  > (If not told otherwise, the context object will use the first algorithm listed in schemes when creating new hashes. This default can be changed by using the default keyword)
  
- `Using Default Settings` -- The next feature of the CryptContext class is that it can store various customized settings for the different algorithms, instead of hardcoding them into each hash() call. See the offficial docs which is very small: https://passlib.readthedocs.io/en/stable/narr/context-tutorial.html#using-default-settings

- `Loading & Saving a CryptContext` -- The previous example built up a CryptContext instance in two stages, first by calling the constructor, and then the update() method to make some additional changes. The same configuration could of course be done in one step:
  ```python
  >>> from passlib.context import CryptContext
  >>> myctx = CryptContext(schemes=["sha256_crypt", "ldap_salted_md5"],
  ...                      sha256_crypt__default_rounds=91234,
  ...                      ldap_salted_md5__salt_size=16)
  ```

- `Deprecation & Hash Migration` -- The final and possibly most useful feature of the CryptContext class is that it can take care of deprecating and migrating existing hashes, re-hashing them using the current default algorithm and settings. All that is required is that a few settings be added to the configuration, and that the application call one extra method whenever a user logs in.

  - __Deprecating Algorithms__ -- The first setting that enables the hash migration features is the _deprecated_ setting. This should be a list algorithms which are no longer desirable to have around, but are included in _schemes_ to provide legacy support. For example:
    ```python
    >>> myctx = CryptContext(schemes=["sha256_crypt", "md5_crypt", "des_crypt"],
                             deprecated=["md5_crypt", "des_crypt"])
    ```
    All of the basic methods of this object will behave normally, but after an application has verified the user entered the correct password, it can check to see if the hash has been deprecated using the _needs_update()_ method:
    ```python
    >>> #if the user's password was stored as md5_crypt hash,
    >>> # need_update will indicate that it is deprecated,
    >>> # and that the original password needs to be re-hashed...

    >>> hash = '$1$fmWm78VW$uWjT69xZNMHWyEQjq852d1'
    >>> myctx.needs_update(hash)
    True
    ```
  
  - __Integrating Hash Migration__ -- To summarize the process described in the previous section, all the actions an application would usually need to perform can be combined into the following bit of skeleton code:
    ```python
    hash = get_hash_from_user(user)
    if pass_ctx.verify(password, hash):
        if pass_ctx.needs_update(hash):
            new_hash = pass_ctx.hash(password)
            replace_user_hash(user, new_hash)
        do_successful_things()
    else:
        reject_user_login()
    ```
    > Since this is a very common pattern, the CryptContext object provides a shortcut: the verify_and_update() method,
  
  - __Settings Rounds Limitations__ -- In addition to deprecating entire algorithms, the deprecations system also allows you to place limits on algorithms that support the variable time-cost parameter `rounds`:
    
    As an example, take a typical system containing a number of user passwords, all stored using sha256_crypt. As computers get faster, the minimum number of rounds that should be used gets larger, yet the existing passwords will remain in the system hashed using their original value. To solve this, the CryptContext object lets you place minimum bounds on what rounds values are allowed
    
    I couldn't focus so much on this part re-read: https://passlib.readthedocs.io/en/stable/narr/context-tutorial.html#settings-rounds-limitations

<br>

---

<br>
  
# TOTP Tutorial

- TOTP libaray is about two factor authentication, ssl, ... etc. I know what they are but i am not familiar with the technique so I will comeback and edit this section later on. But you can read the tutorial here: https://passlib.readthedocs.io/en/stable/narr/totp-tutorial.html
