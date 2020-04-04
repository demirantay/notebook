# Hashing Algorithms Introduction

- Let’s say you have an important file to send and you want to ensure it will get to the addressee without any changes, in one piece. You could use some trivial methods, like sending it multiple times, contact the addressee and verify the file, and so on... but there’s a much better approach and it’s called hashing algorithm.

### Hash

- A hashing algorithm’s goal is to generate a safe hash; but what is a hash? A hash is a value computed from a base input number using a hashing function.

	Shortly, the hash value is a summary of the original data. For instance, think of a paper document that you keep crumpling to a point where you aren’t even able to read its content anymore. It’s almost (in theory) impossible to restore the original input without knowing what the starting data was.

### Hashing Algorithm

- A hashing algorithm is a cryptographic hash function. It is a mathematical algorithm that maps data of arbitrary size to a hash of a fixed size. It’s designed to be a one-way function, infeasible to invert. However, in recent years several hashing algorithms have been compromised. This happened to MD5, for example 

- It’s easy to figure out what the ideal cryptographic hash function should be like:
	- 1 - It should be fast to compute the hash value for any kind of data;
	- 2 - It should be impossible to regenerate a message from its hash value (brute force attack as the only option);
	- 3 - It should avoid hash collisions, each message has its own hash;
	- 4 - Every change to a message, even the smallest one, should change the hash value. It should be completely different. It’s called the avalanche effect

### What do we use it for ?

- Cryptographic hash functions are used notably in IT. We can use them for digital signatures, message authentication codes (MACs), and other forms of authentication 

	We can also use them for indexing data in hash tables, for fingerprinting, identifying files, detecting duplicates or as checksums (we can detect if a sent file didn’t suffer accidental or intentional data corruption).

	A lot of downloading services use checksums to validate the integrity of their files. Thanks to that, you can find out if your downloaded file isn’t corrupted.

### Popoular Hashing Algorithms

- `MD5` -- Before we go any further – MD5 is completely broken!

	If you ever learned any programming language and it was some time ago, you surely know this algorithm. It’s one of the most widely known. It was used for many years and is still widely used — but despite initially being designed to be used as a cryptographic algorithm function, due to extensive vulnerabilities, it has been compromised.
	
	You could think you are secure if your passwords are stored as MD5 hashes, but if somebody gets access to your database, he/she can just type the hash to Google and get its real value!

- `SHA-family` -- Secure Hash Algorithm is a cryptographic hash function designed by the United States’ NSA. SHA-0 (published in 1993) has been compromised many years ago. SHA-1 (1995) produces a 160-bit (20-byte) hash value. It’s typically rendered as a 40 digits long hexadecimal number. It has been compromised in 2005 as theoretical collisions were discovered, but its real “death” occurred in 2010 when many organizations started to recommend its replacement.

	The big three – Microsoft, Google, and Mozilla — have stopped accepting SHA-1 SSL certificates in 2017 on their browsers, after multiple successful attacks. 
	
	Safer, for now, is SHA-2. SHA-2 includes several important changes. Its family has six hash functions with digests: SHA-224, SHA-256 or 512 bits: SHA-224, SHA-256, SHA-384, SHA-512, SHA-512/224, SHA-512/256.
	
	As a bottom line, SHA-2 is a lot more complicated and is still considered safe. However, SHA-2 shares the same structure and mathematical operations as its predecessor (SHA-1) — so it's likely that it will be compromised in the near future. As so, a new option for the future is SHA-3.

- `SHA-3` --  is significantly faster than SHA-2 (from 25% to 80%, depending on implementation). It uses the sponge construction. The data is first “absorbed” into the “sponge” and the result is “squeezed” out. While absorbing, message blocks are XORed into a subset of the state. Then it’s transformed as one element. While squeezing, output blocks are read from this element, but alternated with state transformations.

	A key aspect of SHA-3 is that it was designed to easily replace SHA-2 in applications that currently use that variant. As so, the transition from SHA-2 to SHA-3 should be analyzed in regards to the required security level and the overhead (refactoring/testing) 
	
	> Hashing algorithms can be pretty useful. However, IT is a really fast-changing industry and this entropy also extends to hashing algorithms.
	
	> MD5, once considered really safe, now it’s completely compromised. Then there was SHA-1, which is now unsafe. The same thing will surely happen to the widely used SHA-2 someday.
	
	> A big part of good security standards if you're developing web applications is ensuring that attackers can't reverse engineer or tamper with your JavaScript code
