# Bcrypt

- Python bcrypt tutorial shows how to hash passwords in Python with the bcrypt library. It defines basic terms including encryption, hashing, and salt. [Source](http://zetcode.com/python/bcrypt/)

  Python bcrypt module is a library for generating strong hashing values in Python. It is installed with
  ```
  $ pip install bcrypt
  ```
  
- `Encryption` -- Encryption is the process of encoding a message or information in such a way that only authorized people can read it with a corresponding key and those who are not authorized cannot. The intended information or message, referred to as plaintext, is encrypted using an encryption algorithm – a cipher – generating ciphertext that can be read only if decrypted

- `Hashing` -- Hashing is the process of using an algorithm to map data of any size to a fixed length. This is called a hash value. Whereas encryption is a two-way function, hashing is a one-way function. While it's technically possible to reverse-hash a value, the computing power required makes it unfeasible. While encryption is meant to protect data in transmit, hashing is meant to verify that data hasn't been altered and it is authentic.

- `Salt` -- Salt is a fixed-length cryptographically-strong random value that is added to the input of hash functions to create unique hashes for every input

### The bcrypt hashing function

- The bcrypt is a password hashing function designed by Niels Provos and David Mazières, based on the Blowfish cipher. The bcrypt function is the default password hash algorithm for OpenBSD. There are implementations of bcrypt for C, C++, C#, Java, JavaScript, PHP, Python and other languages.

  The bcrypt algorithm creates hash and salt the password for us using strong cryptography. The computation cost of the algorithm is parametised, so it can be increased as computers get faster. The computation cost is called work factor or cost factor. It slows down the hashing, making brute force attempts harder and slower  The downside of a high cost factor is increased load on system resources and affecting user experience.
  
### Python bcrypt create hashed password

- In the next example, we create a hashed password:
  ```python
  #!/usr/bin/env python3

  import bcrypt

  passwd = b's$cret12'

  salt = bcrypt.gensalt()
  hashed = bcrypt.hashpw(passwd, salt)
  ```
  A salt is generated with the `gensalt()` function. A hashed value is created wiht `hashpw()` function, which takes the cleartext value and a salt as parameters.
  

