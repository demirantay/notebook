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

### Operation of AES

### Encryption Process

### Decryption Process

### AES Analysis

<br>
<br>

---

<br>
<br>

