# Salted Password Hashing - Doing it Right

- If you're a web developer, you've probably had to make a user account system. The most important aspect of a user account system is how user passwords are protected. User account databases are hacked frequently, so you absolutely must do something to protect your users' passwords if your website is ever breached. The best way to protect passwords is to employ `salted password hashing`.

> IMPORTANT WARNING: If you are thinking of writing your own password hashing code, please don't!. It's too easy to screw up. No, that cryptography course you took in university doesn't make you exempt from this warning. This applies to everyone: DO NOT WRITE YOUR OWN CRYPTO! The problem of storing passwords has already been solved. Use either use either bcrypt, scrypt .. etc. and other libraries.

### What is password hashing?

- Lets see this:
  ```python
  hash("hello") = 2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824
  hash("hbllo") = 58756879c05c68dfac9866712fad6a93f8146f337a69afe7dd238f3364946366
  hash("waltz") = c0e81794384491161f1777c232bc6bd9ec38f616560b120fda8e90f383853542
  ```
  Hash algorithms are one way functions. They turn any amount of data into a fixed-length "fingerprint" that cannot be reversed. They also have the property that if the input changes by even a tiny bit, the resulting hash is completely different (see the example above)
  
- The general workflow for account registration and authentication in a hash-based account system is as follows:
  - 1 - The user creates an account.
  - 2 - Their password is hashed and stored in the database. At no point is the plain-text (unencrypted) password ever written to the hard drive.
  - 3 - When the user attempts to login, the hash of the password they entered is checked against the hash of their real password (retrieved from the database).
  - 4 - If the hashes match, the user is granted access. If not, the user is told they entered invalid login credentials.
  - 5 - Steps 3 and 4 repeat every time someone tries to login to their account.
  
  > never tell the user if it was the username or password they got wrong. This prevents attackers from enumerating valid usernames without knowing their passwords.
  
  It should be noted that the hash functions used to protect passwords are not the same as the hash functions you may have seen in a data structures course. The hash functions used to implement data structures such as hash tables are designed to be fast, not secure. Only cryptographic hash functions may be used to implement password hashing. Hash functions like SHA256, SHA512, RipeMD, and WHIRLPOOL are cryptographic hash functions.
  
  It is easy to think that all you have to do is run the password through a cryptographic hash function and your users' passwords will be secure. This is far from the truth. There are many ways to recover passwords from plain hashes very quickly

### How Hashes are Cracked

- `Dictionary and Brute Force Attacks` --

### Adding Salt

### The WRONG Way: Short Salt & Salt Reuse

### The WRONG Way: Double Hashing & Wacky Hash Functions

### Hash Collisions

### The RIGHT Way: How to Hash Properly

### Other Security Measures

### Frequently Asked Questions
