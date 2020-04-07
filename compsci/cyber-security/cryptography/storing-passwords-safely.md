# How to Store Passwords Safely

- notes from: https://blog.jscrambler.com/how-to-store-passwords-safely/

- The security of users’ passwords is one of the most important aspects of developing your web application. Unfortunately, making a good authentication script, which will safely store your data is not a piece of cake. It’s incredibly easy to get it wrong.

### How does it work?

- How does it work in theory? It seems really simple. When you register, you choose your login and a password. They are saved to the database. Then when you log in, the server compares what you typed in the login box with the data from the database and if it’s equal, it lets you in. Thats the main idea behind a login system.

  It may seem a safe solution, but this approach has its cons. Think about this – What if you get hacked? What if your database gets hacked?
  
  They hacked one password, the one to your DB, and they have got access to all accounts created in your service. “So what?”, you could say if your website has nothing to do with money or any other important data, but… take into account that it’s common for people to use the same password for different services. So the password used on your website could be valid (often with the same login and email!) also emphasized text for Facebook, Youtube… you name it!

### Encrypting

- The first thought, which comes to mind, when you think how to hide passwords in plain text is to encrypt them. It’s a good idea, but it’s still not so perfect.

  Now user passwords get encrypted before they are stored in the database. When your user signs in, the script gets an encrypted password from the database, decrypt it and then compares it with the password you typed. If they’re the same, the script lets you in.
  
  Of course, if somebody has an access to your database, they can set up a new account with his password and then by searching their record in the database, just copy their encrypted passwords and paste it to every account they want. Then, with their password, they can sign in to every account, even yours – the one with admin permissions! It’s bad, but at least they don’t have passwords of users, so they can’t use them in other websites.
  
  It has got other cons though. You see, encrypting is a two-way function. It’s reversible so you can always decrypt the string and get the original one if you have the key.

  So it means that the attacker who gets an access to your database can still get the original passwords. He only needs the key to encrypt them
  
  The other flaw is caused by the incompetence of users. In theory, everybody knows the passwords should be long, safe, original and hard to crack, but there are still individuals who love “123456″, “admin1″ and so on.
  
  Encryption of the same password will be always the same so you could end with a database where encrypted passwords are repeated. (this may be avodided with different hashing algorithms however the underlying issue is the there this doesn not fix the problem)
  
  Just one another digression. If you don’t use salt and the same passwords look the same after encryption, another thing which can reveal them is password hints. So if we store hints alongside the user password, the attacker gets as many help as many passwords there are
  
  We already know that we’d like a safer system for our website. Could you believe that such a weak authentication system was used by, for instance, Adobe?
   
### Hashing

- So encrypting seems quite a good idea, but the encryption key makes it really unsafe. How can we get rid of an encryption key? By making our encryption one-way only. If we encrypt and never decrypt, we don’t need an encryption key.

  You can wonder – “What if one of my users loses a password? Can I send it to her/him?” – No, you can’t, but there are other solutions, like setting new passwords.
  
  So what has changed? We NEVER decrypt, so we forget about our encryption key. The same as before we encrypt the password before storing it in the database. The thing that has changed is the part when we sign in. This time, we don’t decrypt our password from the database (we don’t have any key, so we can’t do it anyway), instead, we encrypt typed password in the same way, with the same algorithm as we had done it while registering. If both encrypted strings (typed password and password from DB) are the same, you’re in.
  
  It’s not really complicated. But now we have a question, what password digesting algorithm should we choose? The most popular ones are MD5 and SHA1, SHA2 (from SHA family).
  
  There are also the things called rainbow tables, which really speed up cracking of password hashes. Rainbow tables are precomputed tables for reversing cryptographic hash functions. They’re used mainly for cracking password hashes and recovering plaintext passwords
  
  And the other flaw is again – common passwords. “123456″ and “123456″ still will give the same results to the database. So what do we have to do? We need to salt them.

### Salting

- Hashing and salting. They have never invented annoying better than this and it seems a really good approach for now. The salt is a random sequence of bytes that is added to the password before being digested. This causes the digest to be different than the normal encryption. It protects us really well against rainbow tables/dictionary attacks. There are two types of salting:

  `fixed salt`, a sequence of bytes used for every password. However, even if we keep our salt hidden, our system is still vulnerable to birthday attacks and doesn’t use perfectly the whole idea of salting. A birthday attack is an attack that exploits the Birthday paradox theory. Shortly, it says that if you have a big amount of user password digests, the probability of generating a password colliding with another one of the digests in the table is higher than you could expect.
  
  `Variable salt` is generated separately for each password. This causes the digest to be different for the same password with every encryption. It’s safer and we get rid of common password flaw, which I mentioned before.
  
  The steps are like this:
  - 1 - You signup with your desired username and password
  - 2 - Its salted, hashed and then stored in your database along with the plain-text salt
  - 3 - When you sign in you type in your password
  - 4 - Server gets salt from the database and hash the newly typed password with the same algorithm and same salt
  - 5 - Server compares both encrypted strings if they are equal you are in.
  
  > Dont forget you don't concatante: hash(password)+salt | you create a hash with : hash(password+salt) so salt gets hashed too, dont concatanete to the end of the hash.
  
  The first option weakens when the attacker gets the fixed salt. He’s getting the key for all passwords then. There are a few ways for an attacker to know the salt. Brute force on his/her or somebody’s password is enough to get it.
  
  The second option is much safer, but if it’s random, we have to store it unencrypted along the hashed password in the database. Why? Because we will need it to regenerate the same algorithm we used for signing up while logging in. However still every password is different, so they have to be attacked separately.
  
  The best option to mix both of them. Then we generate a random string and compute it also with fixed salt. This way we’re much safer. The minimum recommended size of salt is 8 bytes. At least 8 bytes should be random.
  
  Oh! And one other thing – password guessing attempts limit. It’s a simple mechanism to implement and it’s very important against brute-force attacks.

### The iteration count

- We have now a really safe algorithm, but there is another thing we can also do. The iteration count refers to the number of times the hashing function works on its own results. What do I mean? When you generate your salt and compute it with a password, you apply the hash function (SHA-1, MD5 or something else). To make it safer you can again apply the hash function on an already hashed result and then do it again and again… and again. It makes the final string even more complicated.

  The minimum recommended number of iterations is 1,000 and it really should make you feel safer It’s not really demanding work for the server to do it, but for the attacker increasing such complexity would make brute-force attacking even longer process than it would be already anyway.

### External authentication

- But… to be honest. The best way to not to worry about passwords security is to not store them at all. If you can, use Facebook login, Google sign-in in your websites to allow users to log in using their other accounts. You don’t have to worry about it yourself then.

### Password Limits

- Make these restrictions for your users, to not let them choose weak ass passwords:

- 1. Password must include upper and lowercase letters, and at least one numeric character.

- 2. Make password as long as you can

- 3. Use symbols

- 4. Try to be the least predictable

> Remember that you have a duty to protect your users’ privacy. We found out probably the best way to protect it at the moment. But remember that world is changing really fast. Don’t let user data exposed by your incompetence. You owe them privacy.
