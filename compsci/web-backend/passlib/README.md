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
  
## Installation
  
- Use pip to intall:
  ```
  pip install passlib
  ```
  
- If you want a particular setup you can use the following:
  - `pip install passlib[bcrypt]` to get the recommended bcrypt setup.
  - `pip install passlib[argon2]` to get the recommended argon2 setup.
  - `pip install passlib[totp]` to get the recommended TOTP setup.
  
  
## Library Overview
  
## New Application Quickstart Guide
  
## Password Hash Tutorial
  
## CryptContext Tutorial
  
## TOTP Tutorial
