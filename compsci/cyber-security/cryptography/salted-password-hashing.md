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

- `Dictionary and Brute Force Attacks` -- The simplest way to crack a hash is to try to guess the password, hashing each guess, and checking if the guess's hash equals the hash being cracked. If the hashes are equal, the guess is the password. The two most common ways of guessing passwords are __dictionary attacks__ and __brute-force attacks__.

  A dictionary attack uses a file containing words, phrases, common passwords, and other strings that are likely to be used as a password. Each word in the file is hashed, and its hash is compared to the password hash. If they match, that word is the password.
  
  A brute-force attack tries every possible combination of characters up to a given length. These attacks are very computationally expensive, and are usually the least efficient in terms of hashes cracked per processor time, but they will always eventually find the password. Passwords should be long enough that searching through all possible character strings to find it will take too long to be worthwhile.
  
  There is no way to prevent dictionary attacks or brute force attacks. They can be made less effective, but there isn't a way to prevent them altogether. If your password hashing system is secure, the only way to crack the hashes will be to run a dictionary or brute-force attack on each hash.
  
- `Lookup Tables` -- Lookup tables are an extremely effective method for cracking many hashes of the same type very quickly. The general idea is to pre-compute the hashes of the passwords in a password dictionary and store them, and their corresponding password, in a lookup table data structure. A good implementation of a lookup table can process hundreds of hash lookups per second, even when they contain many billions of hashes.

- `Reverse Lookup Tables` -- This attack allows an attacker to apply a dictionary or brute-force attack to many hashes at the same time, without having to pre-compute a lookup table. This attack is especially effective because it is common for many users to have the same password.

- `Rainbow Tables` -- Rainbow tables are a time-memory trade-off technique. They are like lookup tables, except that they sacrifice hash cracking speed to make the lookup tables smaller. Because they are smaller, the solutions to more hashes can be stored in the same amount of space, making them more effective

### Adding Salt

- Here is the general idea how salting works:
  ```python
  hash("hello")                    = 2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824
  hash("hello" + "QxLUF1bgIAdeQX") = 9e209040c863f84a31e719795b2577523954739fe5ed3b58a75cff2127075ed1
  hash("hello" + "bv5PehSMfV11Cd") = d1d3ec2e6f20fd420d50e2642992841d8338a314b8ea157c9e18477aaef226ab
  hash("hello" + "YYLmfY6IehjZMQ") = a49670c3c18b9e079b9cfaf51634f563dc8ae3070db2c4a8544305df1b60f007
  ```
  Lookup tables and rainbow tables only work because each password is hashed the exact same way. If two users have the same password, they'll have the same password hashes. We can prevent these attacks by randomizing each hash, so that when the same password is hashed twice, the hashes are not the same.
  
  We can randomize the hashes by appending or prepending a random string, called a `salt`, to the password before hashing. As shown in the example above, this makes the same password hash into a completely different string every time. To check if a password is correct, we need the salt, so it is usually stored in the user account database along with the hash, or as part of the hash string itself.
  
  The salt does not need to be secret. Just by randomizing the hashes, lookup tables, reverse lookup tables, and rainbow tables become ineffective. An attacker won't know in advance what the salt will be, so they can't pre-compute a lookup table or rainbow table. If each user's password is hashed with a different salt, the reverse lookup table attack won't work either.

### The `WRONG` Way: Short Salt & Salt Reuse

### The `WRONG` Way: Double Hashing & Wacky Hash Functions

### Hash Collisions

### The `RIGHT` Way: How to Hash Properly

### Other Security Measures

### Frequently Asked Questions
