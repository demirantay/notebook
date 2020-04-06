# Data Integrity in Cryptography

- Until now, we discussed the use of symmetric and public key schemes to achieve the confidentiality of information. With this chapter, we begin our discussion on different cryptographic techniques designed to provide other security services.

### Threats to Data Integrity

- When sensitive information is exchanged, the receiver must have the assurance that the message has come intact from the intended sender and is not modified inadvertently or otherwise. There are two different types of data integrity threats, namely passive and active.

- `passive threats` --

- `active threats` -- In this type of threats, an attacker can manipulate the data with malicious intent.

<Br>
<br>

---

<Br>
<br>

# Cryptography Hash functions

- A hash function is a mathematical function that converts a numerical input value into another compressed numerical value. The input to the hash function is of arbitrary length but output is always of fixed length.

### Features of Hash Functions

- The typical features of hash functions are −
	- `Fixed Length Output (Hash Value)` 
		- Hash function coverts data of arbitrary length to a fixed length. This process is often referred to as hashing the data.
		- In general, the hash is much smaller than the input data, hence hash functions are sometimes called compression functions.
		- Since a hash is a smaller representation of a larger data, it is also referred to as a digest.
		- Hash function with n bit output is referred to as an n-bit hash function. Popular hash functions generate values between 160 and 512 bits.
	- `Efficiency of Operation` -
		- Generally for any hash function h with input x, computation of h(x) is a fast operation.
		- Computationally hash functions are much faster than a symmetric encryption.
		
### Properties of Hash Functions

- In order to be an effective cryptographic tool, the hash function is desired to possess following properties −
	- `Pre-Image Resistance` - This property means that it should be computationally hard to reverse a hash function.
	- `Second Pre-Image Resistance` - This property means given an input and its hash, it should be hard to find a different input with the same hash. This property of hash function protects against an attacker who has an input value and its hash, and wants to substitute different value as legitimate value in place of original input value.
	- `Collision Resistance` - This property means it should be hard to find two different inputs of any length that result in the same hash. This property is also referred to as collision free hash function.

### Design of Hashing Algorithms

- At the heart of a hashing is a mathematical function that operates on two fixed-size blocks of data to create a hash code. This hash function forms the part of the hashing algorithm. The size of each data block varies depending on the algorithm. Typically the block sizes are from 128 bits to 512 bits.

	Since, the hash value of first message block becomes an input to the second hash operation, output of which alters the result of the third operation, and so on. This effect, known as an `avalanche effect` of hashing.
	
- Understand the difference between `hash function` and `hash algorithm` correctly. The hash function generates a hash code by operating on two blocks of fixed-length binary data.

	Hashing algorithm is a process for using the hash function, specifying how the message will be broken up and how the results from previous message blocks are chained together.

### Popular Hash Functions

- `Message Digest (MD5)` -- MD5 was most popular and widely used hash function for quite some years. In 2004, collisions were found in MD5. An analytical attack was reported to be successful only in an hour by using computer cluster. This collision attack resulted in compromised MD5 and hence it is no longer recommended for use.

- `Secure Hash Function (SHA)` -- Family of SHA comprise of four SHA algorithms; SHA-0, SHA-1, SHA-2, and SHA-3. Though from same family, there are structurally different.
	- Dont use sha-0 or sha-1 they have been exploited as of right now sha-2 and sha-3 are secure. Plus sha3 is not better than sha-2 they are just different versions one is not better than the other (IRC said it so dont religously believe it may need to ask it again on the channel)
	
- `RIPEMD`, `Whirlpool`, `bcrypt`, `scrypt` ... etc.

### Applications of Hash Functions

- There are two direct applications of hash function based on its cryptographic properties.
	- `Password Storage` -- hash and salt the passwords instead of just storing plain text. Users trust their password with you always secure them.
	- `Data integrity` -- check is a most common application of the hash functions. It is used to generate the checksums on data files. This application provides assurance to the user about correctness of the data.

<br>
<br>

---

<br>
<br>

# Message Authentication

- In the last chapter, we discussed the data integrity threats and the use of hashing technique to detect if any modification attacks have taken place on the data.

	Another type of threat that exist for data is the lack of message authentication. In this threat, the user is not sure about the originator of the message. Message authentication can be provided using the cryptographic techniques that use secret keys as done in case of encryption.

### Message Authentication Code (MAC)

- MAC algorithm is a symmetric key cryptographic technique to provide message authentication. For establishing MAC process, the sender and receiver share a symmetric key K.

	Essentially, a MAC is an encrypted checksum generated on the underlying message that is sent along with a message to ensure message authentication.

### Limitations of MAC

- There are two major limitations of MAC, both due to its symmetric nature of operation −
	- `Establishment of Shared Secret.` --
		-  It can provide message authentication among pre-decided legitimate users who have shared key.
		- This requires establishment of shared secret prior to use of MAC.
	- `Inability to Provide Non-Repudiation` --
		- MAC technique does not provide a non-repudiation service. If the sender and receiver get involved in a dispute over message origination, MACs cannot provide a proof that a message was indeed sent by the sender.
		
	Both these limitations can be overcome by using the public key based digital signatures discussed in following section.

<br>
<br>

---

<br>
<br>

# Cryptograhpy Digital Signatures

### Model of Digital Signature

### Importance of Digital Signature

### Encryption with Digital Signature

<br>
<br>

---

<br>
<br>

# Public Key Infsutrcutre
