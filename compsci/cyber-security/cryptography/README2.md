# Modern Symmetric Key Encryption

- Digital data is represented in strings of binary digits (bits) unlike alphabets. Modern cryptosystems need to process this binary strings to convert in to another binary string. Based on how these binary strings are processed, a symmetric encryption schemes can be classified in to −


### Block Ciphers

- In this scheme, the plain binary text is processed in blocks (groups) of bits at a time; i.e. a block of plaintext bits is selected, a series of operations is performed on this block to generate a block of ciphertext bits. The number of bits in a block is fixed. 

### Stream Ciphers

- In this scheme, the plaintext is processed one bit at a time i.e. one bit of plaintext is taken, and a series of operations is performed on it to generate one bit of ciphertext. Technically, stream ciphers are block ciphers with a block size of one bit.

<br>
<br>

---

<br>
<br>

# Block Cipher

- A block cipher takes a block of plaintext bits and generates a block of ciphertext bits, generally of same size. The size of block is fixed in the given scheme. The choice of block size does not directly affect to the strength of encryption scheme. The strength of cipher depends up on the key length.

### Block Size

- following aspects are borne in mind while selecting a size of a block:
	- Avoid very small block size 
	- Do not have very large block size
	- Multiples of 8 bit
	
### Block Cipher Schemes

- There is a vast number of block ciphers schemes that are in use. Many of them are publically known. Most popular and prominent block ciphers are listed below.
	- `Digital Encryption Standard (DES)` − The popular block cipher of the 1990s. It is now considered as a ‘broken’ block cipher, due primarily to its small key size.
	- `Triple DES` − It is a variant scheme based on repeated DES applications. It is still a respected block ciphers but inefficient compared to the new faster block ciphers available.
	- `Advanced Encryption Standard (AES)` − It is a relatively new block cipher based on the encryption algorithm Rijndael that won the AES design competition.
	- `IDEA` − It is a sufficiently strong block cipher with a block size of 64 and a key size of 128 bits. A number of applications use IDEA encryption, including early versions of Pretty Good Privacy (PGP) protocol. The use of IDEA scheme has a restricted adoption due to patent issues.
	- `Twofish` − This scheme of block cipher uses block size of 128 bits and a key of variable length. It was one of the AES finalists. It is based on the earlier block cipher Blowfish with a block size of 64 bits.
	- `Serpent` − A block cipher with a block size of 128 bits and key lengths of 128, 192, or 256 bits, which was also an AES competition finalist. It is a slower but has more secure design than other block cipher.

<br>
<br>

---

<Br>
<br>

# Feistel Block Cipher

- Feistel Cipher is not a specific scheme of block cipher. It is a design model from which many different block ciphers are derived. DES is just one example of a Feistel Cipher. A cryptographic system based on Feistel cipher structure uses the same algorithm for both encryption and decryption.

### Encryption Process

- The encryption process uses the Feistel structure consisting multiple rounds of processing of the plaintext, each round consisting of a “substitution” step followed by a permutation step.

	The difficult part of designing a Feistel Cipher is selection of round function ‘f’. In order to be unbreakable scheme, this function needs to have several important properties that are beyond the scope of our discussion.

### Decryption Process

- The process of decryption in Feistel cipher is almost similar. Instead of starting with a block of plaintext, the ciphertext block is fed into the start of the Feistel structure and then the process thereafter is exactly the same

	The process is said to be almost similar and not exactly same. In the case of decryption, the only difference is that the subkeys used in encryption are used in the reverse order.

### Number of Rounds

- The number of rounds used in a Feistel Cipher depends on desired security from the system. More number of rounds provide more secure system. But at the same time, more rounds mean the inefficient slow encryption and decryption processes.

<br>
<br>

---

<br>
<br>

# Data Encryption Standart

- DES is an implementation of a Feistel Cipher. It uses 16 round Feistel structure. The block size is 64-bit. Though, key length is 64-bit, DES has an effective key length of 56 bits, since 8 of the 64 bits of the key are not used by the encryption algorithm (function as check bits only).

	Since DES is based on the Feistel Cipher, all that is required to specify DES is −
	- Round function
	- Key schedule
	- Any additional processing − Initial and final permutation

### Round Function

- The heart of this cipher is the DES function, f. The DES function applies a 48-bit key to the rightmost 32 bits to produce a 32-bit output.

	Expansion Permutation Box − Since right input is 32-bit and round key is a 48-bit, we first need to expand right input to 48 bits.

### Key Generation

- The round-key generator creates sixteen 48-bit keys out of a 56-bit cipher key. The process of key generation is depicted in the following illustration −

### DES Analysis

- The DES satisfies both the desired properties of block cipher. These two properties make cipher very strong.
	- `Avalanche effect` − A small change in plaintext results in the very great change in the ciphertext.
	- `Completeness` − Each bit of ciphertext depends on many bits of plaintext.

	During the last few years, cryptanalysis have found some weaknesses in DES when key selected are weak keys. These keys shall be avoided.
	
	DES has proved to be a very well designed block cipher. There have been no significant cryptanalytic attacks on DES other than exhaustive key search.

<br>
<br>

---

<br>
<br>

# Triple DES

- The speed of exhaustive key searches against DES after 1990 began to cause discomfort amongst users of DES. However, users did not want to replace DES as it takes an enormous amount of time and money to change encryption algorithms that are widely adopted and embedded in large security architectures.

	This led to the modified schemes of Triple DES (sometimes known as 3DES).

### 3-KEY Triple DES

- Before using 3TDES, user first generate and distribute a 3TDES key K, which consists of three different DES keys K1, K2 and K3. This means that the actual 3TDES key has length 3×56 = 168 bits. The encryption scheme is illustrated as follows −

	The encryption-decryption process is as follows −
	- Encrypt the plaintext blocks using single DES with key K1.
	- Now decrypt the output of step 1 using single DES with key K2.
	- Finally, encrypt the output of step 2 using single DES with key K3.
	- The output of step 3 is the ciphertext.
	- Decryption of a ciphertext is a reverse process. User first decrypt using K3, then encrypt with K2, and finally decrypt with K1.
	
	Triple DES systems are significantly more secure than single DES, but these are clearly a much slower process than encryption using single DES.
	

<br>
<br>

---

<br>
<br>

# Advanced Encryption Standart

- The more popular and widely adopted symmetric encryption algorithm likely to be encountered nowadays is the Advanced Encryption Standard (AES). It is found at least six time faster than triple DES. A replacement for DES was needed as its key size was too small. With increasing computing power, it was considered vulnerable against exhaustive key search attack.

### Operation of AES

- AES is an iterative rather than Feistel cipher. It is based on ‘substitution–permutation network’. It comprises of a series of linked operations, some of which involve replacing inputs by specific outputs (substitutions) and others involve shuffling bits around (permutations).

	Unlike DES, the number of rounds in AES is variable and depends on the length of the key. AES uses 10 rounds for 128-bit keys, 12 rounds for 192-bit keys and 14 rounds for 256-bit keys. Each of these rounds uses a different 128-bit round key, which is calculated from the original AES key.	
	
### AES Analysis

- In present day cryptography, AES is widely adopted and supported in both hardware and software. Till date, no practical cryptanalytic attacks against AES has been discovered. Additionally, AES has built-in flexibility of key length, which allows a degree of ‘future-proofing’ against progress in the ability to perform exhaustive key searches.

	However, just as for DES, the AES security is assured only if it is correctly implemented and good key management is employed.

<br>
<br>

---

<br>
<br>

# Block Cipher Modes of Operation

- In this chapter, we will discuss the different modes of operation of a block cipher. These are procedural rules for a generic block cipher. Interestingly, the different modes result in different properties being achieved which add to the security of the underlying block cipher.

### Electronic Code Book (ECB) Mode

- This mode is a most straightforward way of processing a series of sequentially listed message blocks.

	operation:
	- The user takes the first block of plaintext and encrypts it with the key to produce the first block of ciphertext.
	- He then takes the second block of plaintext and follows the same process with same key and so on so forth.
	
	analysis:
	- In reality, any application data usually have partial information which can be guessed. For example, the range of salary can be guessed. A ciphertext from ECB can allow an attacker to guess the plaintext by trial-and-error if the plaintext message is within predictable. hence the ECB mode should not be used in most applications.

### Cipher Block Chaining (CBC) Mode

- CBC mode of operation provides message dependence for generating ciphertext and makes the system non-deterministic.
	
	analysis:
	- In CBC mode, the current plaintext block is added to the previous ciphertext block, and then the result is encrypted with the key. Decryption is thus the reverse process, which involves decrypting the current ciphertext and then adding the previous ciphertext block to the result.
  - Advantage of CBC over ECB is that changing IV results in different ciphertext for identical message. On the drawback side, the error in transmission gets propagated to few further block during decryption due to chaining effect.
	- It is worth mentioning that CBC mode forms the basis for a well-known data origin authentication mechanism. Thus, it has an advantage for those applications that require both symmetric encryption and data origin authentication.

### Cipher Feedback (CFB) Mode

- In this mode, each ciphertext block gets ‘fed back’ into the encryption process in order to encrypt the next plaintext block.

	analysis:
	- CFB mode differs significantly from ECB mode, the ciphertext corresponding to a given plaintext block depends not just on that plaintext block and the key, but also on the previous ciphertext block. In other words, the ciphertext block is dependent of message.

### Output Feedback (OFB) Mode

- It involves feeding the successive output blocks from the underlying block cipher back to it. These feedback blocks provide string of bits to feed the encryption algorithm which act as the key-stream generator as in case of CFB mode.

	The key stream generated is XOR-ed with the plaintext blocks. The OFB mode requires an IV as the initial random n-bit input block. The IV need not be secret.

### Counter (CTR) Mode

- It can be considered as a counter-based version of CFB mode without the feedback. In this mode, both the sender and receiver need to access to a reliable counter, which computes a new shared value each time a ciphertext block is exchanged. This shared counter is not necessarily a secret value, but challenge is that both sides must keep the counter synchronized.

	The serious disadvantage of CTR mode is that it requires a synchronous counter at sender and receiver. Loss of synchronization leads to incorrect recovery of plaintext.

<br>
<br>

---

<br>
<br>

# Public Key Encryption

- Unlike symmetric key cryptography, we do not find historical use of public-key cryptography. It is a relatively new concept.

	Symmetric cryptography was well suited for organizations such as governments, military, and big financial corporations were involved in the classified communication.
	
	With the spread of more unsecure computer networks in last few decades, a genuine need was felt to use cryptography at larger scale. The symmetric key was found to be non-practical due to challenges it faced for key management. This gave rise to the public key cryptosystems.
	
- The most important properties of public key encryption scheme are −
	- Different keys are used for encryption and decryption. This is a property which set this scheme different than symmetric encryption scheme.
	- Each receiver possesses a unique decryption key, generally referred to as his private key.
	- Receiver needs to publish an encryption key, referred to as his public key.
	- Some assurance of the authenticity of a public key is needed in this scheme to avoid spoofing by adversary as the receiver. Generally, this type of cryptosystem involves trusted third party which certifies that a particular public key belongs to a specific person or entity only. 
	- Encryption algorithm is complex enough to prohibit attacker from deducing the plaintext from the ciphertext and the encryption (public) key.
	- Though private and public keys are related mathematically, it is not be feasible to calculate the private key from the public key. In fact, intelligent part of any public-key cryptosystem is in designing a relationship between two keys.
	
	There are three types of Public Key Encryption schemes.
	- RSA 
	- ElGamal
	- Elliptic Curve

### RSA Cryptosystem

- This cryptosystem is one the initial system. It remains most employed cryptosystem even today. Each person or a party who desires to participate in communication using encryption needs to generate a pair of keys, namely public key and private key. 

	Once the key pair has been generated, the process of encryption and decryption are relatively straightforward and computationally easy.

	Interestingly, RSA does not directly operate on strings of bits as in case of symmetric key encryption. It operates on numbers modulo n. Hence, it is necessary to represent the plaintext as a series of numbers less than n.
	
- `security analysis` -- The security of RSA depends on the strengths of two separate functions. The RSA cryptosystem is most popular public-key cryptosystem strength of which is based on the practical difficulty of factoring the very large numbers.
	- __Encryption Function__ − It is considered as a one-way function of converting plaintext into ciphertext and it can be reversed only with the knowledge of private key d.
	- __Key Generation__ − The difficulty of determining a private key from an RSA public key is equivalent to factoring the modulus n. An attacker thus cannot use knowledge of an RSA public key to determine an RSA private key unless he can factor n. It is also a one way function, going from p & q values to modulus n is easy but reverse is not possible.
	
	If either of these two functions are proved non one-way, then RSA will be broken

### ElGamal Cryptosystem

- ElGamal cryptosystem, called Elliptic Curve Variant, is based on the Discrete Logarithm Problem. It derives the strength from the assumption that the discrete logarithms cannot be found in practical time frame for a given number, while the inverse operation of the power can be computed efficiently.

	The generation of an ElGamal key pair is comparatively simpler than the equivalent process for RSA. But the encryption and decryption are slightly more complex than RSA.
	
- `sec analysis`: In ElGamal system, each user has a private key x. and has three components of public key − prime modulus p, generator g, and public Y = gx mod p. The strength of the ElGamal is based on the difficulty of discrete logarithm problem.

### RSA and ElGamal Schemes – A Comparison

| RSA | ElGamal |
|--|--|
|It is more efficient for encryption.	| It is more efficient for decryption.|
|It is less efficient for decryption.	| It is more efficient for decryption.|
|For a particular security level, lengthy keys are required in RSA.| For the same level of security, very short keys are required.|
|It is widely accepted and used.|	It is new and not very popular in market.|

<br>
<br>

---

[part 3](./README3.md)
