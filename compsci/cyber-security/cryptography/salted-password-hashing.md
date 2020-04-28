# Salted Password Hashing - Doing it Right

- If you're a web developer, you've probably had to make a user account system. The most important aspect of a user account system is how user passwords are protected. User account databases are hacked frequently, so you absolutely must do something to protect your users' passwords if your website is ever breached. The best way to protect passwords is to employ `salted password hashing`.

  > IMPORTANT WARNING: If you are thinking of writing your own password hashing code, please don't!. It's too easy to screw up. No, that cryptography course you took in university doesn't make you exempt from this warning. This applies to everyone: DO NOT WRITE YOUR OWN CRYPTO! The problem of storing passwords has already been solved. Use either use either bcrypt, scrypt .. etc. and other libraries.

## What is password hashing?

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

## How Hashes are Cracked

- `Dictionary and Brute Force Attacks` -- The simplest way to crack a hash is to try to guess the password, hashing each guess, and checking if the guess's hash equals the hash being cracked. If the hashes are equal, the guess is the password. The two most common ways of guessing passwords are __dictionary attacks__ and __brute-force attacks__.

  A dictionary attack uses a file containing words, phrases, common passwords, and other strings that are likely to be used as a password. Each word in the file is hashed, and its hash is compared to the password hash. If they match, that word is the password.
  
  A brute-force attack tries every possible combination of characters up to a given length. These attacks are very computationally expensive, and are usually the least efficient in terms of hashes cracked per processor time, but they will always eventually find the password. Passwords should be long enough that searching through all possible character strings to find it will take too long to be worthwhile.
  
  There is no way to prevent dictionary attacks or brute force attacks. They can be made less effective, but there isn't a way to prevent them altogether. If your password hashing system is secure, the only way to crack the hashes will be to run a dictionary or brute-force attack on each hash.
  
- `Lookup Tables` -- Lookup tables are an extremely effective method for cracking many hashes of the same type very quickly. The general idea is to pre-compute the hashes of the passwords in a password dictionary and store them, and their corresponding password, in a lookup table data structure. A good implementation of a lookup table can process hundreds of hash lookups per second, even when they contain many billions of hashes.

- `Reverse Lookup Tables` -- This attack allows an attacker to apply a dictionary or brute-force attack to many hashes at the same time, without having to pre-compute a lookup table. This attack is especially effective because it is common for many users to have the same password.

- `Rainbow Tables` -- Rainbow tables are a time-memory trade-off technique. They are like lookup tables, except that they sacrifice hash cracking speed to make the lookup tables smaller. Because they are smaller, the solutions to more hashes can be stored in the same amount of space, making them more effective

## Adding Salt

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

## The `WRONG` Way: Short Salt & Salt Reuse

- The most common salt implementation errors are reusing the same salt in multiple hashes, or using a salt that is too short.

- `Salt Reuse` -- A common mistake is to use the same salt in each hash. Either the salt is hard-coded into the program, or is generated randomly once. This is ineffective because if two users have the same password, they'll still have the same hash. An attacker can still use a reverse lookup table attack to run a dictionary attack on every hash at the same time. They just have to apply the salt to each password guess before they hash it. A new random salt must be generated each time a user creates an account or changes their password.

- `Short Salt` -- If the salt is too short, an attacker can build a lookup table for every possible salt. For example, if the salt is only three ASCII characters, there are only 95x95x95 = 857,375 possible salts. That may seem like a lot, but if each lookup table contains only 1MB of the most common passwords, collectively they will be only 837GB, which is not a lot considering 1000GB hard drives can be bought for under $100 today.

  To make it impossible for an attacker to create a lookup table for every possible salt, the salt must be long. A good rule of thumb is to use a salt that is the same size as the output of the hash function. For example, the output of SHA256 is 256 bits (32 bytes), so the salt should be at least 32 random bytes.

## The `WRONG` Way: Double Hashing & Wacky Hash Functions

- This section covers another common password hashing misconception: wacky combinations of hash algorithms. It's easy to get carried away and try to combine different hash functions, hoping that the result will be more secure. In practice, though, there is very little benefit to doing it. All it does is create interoperability problems, and can sometimes even make the hashes less secure. Never try to invent your own crypto, always use a standard that has been designed by experts
  ```python
  md5(sha1(password))  # <-- useless and actually worse
  ```
  Some may say wacky hashing is actually good but An attacker cannot attack a hash when he doesn't know the algorithm, but note Kerckhoffs's principle, that the attacker will usually have access to the source code (especially if it's free or open source software), and that given a few password-hash pairs from the target system, it is not difficult to reverse engineer the algorithm. It does take longer to compute wacky hash functions, but only by a small constant factor. It's better to use an iterated algorithm that's designed to be extremely hard to parallelize (these are discussed below). And, properly salting the hash solves the rainbow table problem.

## Hash Collisions

- Because hash functions map arbitrary amounts of data to fixed-length strings, there must be some inputs that hash into the same string. Cryptographic hash functions are designed to make these collisions incredibly difficult to find. From time to time, cryptographers find "attacks" on hash functions that make finding collisions easier. A recent example is the MD5 hash function, for which collisions have actually been found.

   However, finding collisions in even a weak hash function like MD5 requires a lot of dedicated computing power, so it is very unlikely that these collisions will happen "by accident" in practice. A password hashed using MD5 and salt is, for all practical purposes, just as secure as if it were hashed with SHA256 and salt. Nevertheless, it is a good idea to use a more secure hash function like SHA256, SHA512, RipeMD, or WHIRLPOOL if possible.

## The `RIGHT` Way: How to Hash Properly

- This section describes exactly how passwords should be hashed. The first subsection covers the basics—everything that is absolutely necessary. The following subsections explain how the basics can be augmented to make the hashes even harder to crack.

- `The Basics: Hashing with Salt` -- Salt should be generated using a Cryptographically Secure Pseudo-Random Number Generator (CSPRNG). CSPRNGs are very different than ordinary pseudo-random number generators, like the "C" language's rand() function. As the name suggests, CSPRNGs are designed to be cryptographically secure, meaning they provide a high level of randomness and are completely unpredictable.

  The following table lists some CSPRNGs that exist for some popular programming platforms.
  - `Python` -- os.urandom
  - `C/C++ (Windows API)` -- CryptGenRandom
  - `Java` -- java.security.SecureRandom
  
  The salt needs to be unique per-user per-password. Every time a user creates an account or changes their password, the password should be hashed using a new random salt. Never reuse a salt. The salt also needs to be long, so that there are many possible salts. The salt should be stored in the user account table alongside the hash.
  
  To Store a Password:
  - 1 - Generate a long random salt using a CSPRNG.
  - 2 - Prepend the salt to the password and hash it with a standard password hashing function like Argon2, bcrypt, scrypt, or PBKDF2.
  - 3 - Save both the salt and the hashed+salted pwd in the user's database record.
  
  To Validate a Password:
  - 1 - Retrieve the user's salt and hash from the database.
  - 2 - Prepend the salt to the given password and hash it using the same hash function
  - 3 - mpare the hash of the given password with the hash from the database. If they match, the password is correct. Otherwise, the password is incorrect.
  
  If you are writing a web application, you might wonder where to hash. Should the password be hashed in the user's browser with JavaScript, or should it be sent to the server "in the clear" and hashed there? Even if you are hashing the user's passwords in JavaScript, you still have to hash the hashes on the server ALWAYS ON THE SERVER.
  
  Don't get spooked you CAN salt and hash on the client too but it is much more of a hussle to do it than on the server. If you are going to do it you must have a good reason to do it. 

- `Making Password Cracking Harder: Slow Hash Functions` -- Salt ensures that attackers can't use specialized attacks like lookup tables and rainbow tables to crack large collections of hashes quickly, but it doesn't prevent them from running dictionary or brute-force attacks on each hash individually. High-end graphics cards (GPUs) and custom hardware can compute billions of hashes per second, so these attacks are still very effective. To make these attacks less effective, we can use a technique known as key stretching.

  The idea is to make the hash function very slow, so that even with a fast GPU or custom hardware, dictionary and brute-force attacks are too slow to be worthwhil Key stretching is implemented using a special type of CPU-intensive hash function. Don't try to invent your own–simply Use a standard algorithm like PBKDF2 or bcrypt.
  
  If you use a key stretching hash in a web application, be aware that you will need extra computational resources to process large volumes of authentication requests, and that key stretching may make it easier to run a Denial of Service (DoS) attack on your website. I still recommend using key stretching, but with a lower iteration count. You should calculate the iteration count based on your computational resources and the expected maximum authentication request rate. The denial of service threat can be eliminated by making the user solve a CAPTCHA every time they log in.
  
  If you are worried about the computational burden, but still want to use key stretching in a web application, consider running the key stretching algorithm in the user's browser with JavaScript.

- `Impossible-to-crack Hashes: Keyed Hashes and Password Hashing Hardware` -- As long as an attacker can use a hash to check whether a password guess is right or wrong, they can run a dictionary or brute-force attack on the hash. The next step is to add a secret key to the hash so that only someone who knows the key can use the hash to validate a password. This can be accomplished two ways. Either the hash can be encrypted using a cipher like AES, or the secret key can be included in the hash using a keyed hash algorithm like HMAC.

  I highly recommend this approach for any large scale (more than 100,000 users) service. I consider it necessary for any service hosting more than 1,000,000 user accounts. Don't hard-code a key into the source code, generate it randomly when the application is installed

## Other Security Measures

- Even experienced developers must be educated in security in order to write secure applications. A great resource for learning about web application vulnerabilities is [The Open Web Application Security Project (OWASP)](https://owasp.org/index.php/Main_Page). A good introduction is the [OWASP Top Ten Vulnerability List](https://owasp.org/www-pdf-archive/OWASP_Top_10-2017_(en).pdf.pdf). Unless you understand all the vulnerabilities on the list, do not attempt to write a web application that deals with sensitive data.

  Having a third party "penetration test" your application is a good idea. It is also important to monitor your website to detect a breach if one does occur. I recommend hiring at least one person whose full time job is detecting and responding to security breaches.

## Frequently Asked Questions

- __`What hash algorithm should I use?`__ -- 
  - DO use: Well-designed key stretching algorithms such as PBKDF2, bcrypt, and scrypt.
  - DO NOT use: Fast cryptographic hash functions such as MD5, SHA1, SHA256, SHA512, RipeMD, WHIRLPOOL, SHA3, etc. Any algorithm that you designed yourself. Only use technology that is in the public domain and has been well-tested by experienced cryptographers.
  
- __`How should I allow users to reset their password when they forget it?`__ -- It is my personal opinion that all password reset mechanisms in widespread use today are insecure. If you have high security requirements, such as an encryption service would, do not let the user reset their password.

  Most websites use an email loop to authenticate users who have forgotten their password. To do this, generate a random single-use token that is strongly tied to the account. Include it in a password reset link sent to the user's email address. When the user clicks a password reset link containing a valid token, prompt them for a new password. Be sure that the token is strongly tied to the user account so that an attacker can't use a token sent to his own email address to reset a different user's password.

  The token must be set to expire in 15 minutes or after it is used

  Attackers will be able to modify the tokens, so don't store the user account information or timeout information in them. They should be an unpredictable random binary blob used only to identify a record in a database table. Never send the user a new password over email. Remember to pick a new random salt when the user resets their password
  
- __`What should I do if my user account database gets leaked/hacked?`__ -- Your first priority is to determine how the system was compromised and patch the vulnerability the attacker used to get in. If you do not have experience responding to breaches, I highly recommend hiring a third-party security firm.

  It may be tempting to cover up the breach and hope nobody notices. However, trying to cover up a breach makes you look worse, because you're putting your users at further risk by not informing them that their passwords and other personal information may be compromised. You must inform your users as soon as possible—even if you don't yet fully understand what happened. Put a notice on the front page of your website that links to a page with more detailed information, and send a notice to each user by email if possible.
  
  Explain to your users exactly how their passwords were protected—hopefully hashed with salt—and that even though they were protected with a salted hash, a malicious hacker can still run dictionary and brute force attacks on the hashes. Malicious hackers will use any passwords they find to try to login to a user's account on a different website, hoping they used the same password on both websites. Inform your users of this risk and recommend that they change their password on any website or service where they used a similar password.
  
  It is likely, even with salted slow hashes, that an attacker will be able to crack some of the weak passwords very quickly. To reduce the attacker's window of opportunity to use these passwords, you should require, in addition to the current password, an email loop for authentication until the user has changed their password. See the previous question, "How should I allow users to reset their password when they forget it?" for tips on implementing email loop authentication.

  Also tell your users what kind of personal information was stored on the website. If your database includes credit card numbers, you should instruct your users to look over their recent and future bills closely and cancel their credit card.
  
- __`What should my password policy be? Should I enforce strong passwords?`__ -- You usually should. But be prepared to lose customers since it is a daunting task. If it is extremly sensetive app reset the passwords always in a timely manner.
