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

- Digital signatures are the public-key primitives of message authentication. In the physical world, it is common to use handwritten signatures on handwritten or typed messages. They are used to bind signatory to the message.

	Similarly, a digital signature is a technique that binds a person/entity to the digital data. This binding can be independently verified by receiver as well as any third party.
	
	Digital signature is a cryptographic value that is calculated from the data and a secret key known only by the signer.
	
	In real world, the receiver of message needs assurance that the message belongs to the sender and he should not be able to repudiate the origination of that message. This requirement is very crucial in business applications, since likelihood of a dispute over exchanged data is very high.

### Model of Digital Signature

- The following points explain the entire process in detail −
	- Each person adopting this scheme has a public-private key pair.
	-  Generally, the key pairs used for encryption/decryption and signing/verifying are different. The private key used for signing is referred to as the signature key and the public key as the verification key.
	- Signer feeds data to the hash function and generates hash of data.
	- Hash value and signature key are then fed to the signature algorithm which produces the digital signature on given hash. Signature is appended to the data and then both are sent to the verifier.
	- Verifier feeds the digital signature and the verification key into the verification algorithm. The verification algorithm gives some value as output.
	- Verifier also runs same hash function on received data to generate hash value.
	- For verification, this hash value and output of verification algorithm are compared. Based on the comparison result, verifier decides whether the digital signature is valid.
	- Since digital signature is created by ‘private’ key of signer and no one else can have this key; the signer cannot repudiate signing the data in future.
	
	> signing a hash is more efficient than signing the entire data.

### Importance of Digital Signature

- This makes it essential for users employing PKC for encryption to seek digital signatures along with encrypted data to be assured of message authentication and non-repudiation.

	This can archived by combining digital signatures with encryption scheme. Let us briefly discuss how to achieve this requirement. There are two possibilities, sign-then-encrypt and encrypt-then-sign.
	
	However, the crypto system based on sign-then-encrypt can be exploited by receiver to spoof identity of sender and sent that data to third party. Hence, this method is not preferred. The process of encrypt-then-sign is more reliable and widely adopted. This is depicted in the following illustration −

### Encryption with Digital Signature

<br>
<br>

---

<br>
<br>

# Public Key Infsutrcutre

- The most distinct feature of Public Key Infrastructure (PKI) is that it uses a pair of keys to achieve the underlying security service. The key pair comprises of private key and public key.

	Since the public keys are in open domain, they are likely to be abused. It is, thus, necessary to establish and maintain some kind of trusted infrastructure to manage these keys.

### Key Management

- It goes without saying that the security of any cryptosystem depends upon how securely its keys are managed. Without secure procedures for the handling of cryptographic keys, the benefits of the use of strong cryptographic schemes are potentially lost.
	
	Cryptographic keys are nothing but special pieces of data. Key management refers to the secure administration of cryptographic keys.
	
	Key management deals with entire key lifecycle as depicted in the following illustration −
	```
	key generation -> key establishment -> key storage -> key usage -> key archival -> key destruction
	```
	There are two specific requirements of key management for public key cryptography.
	- `Secrecy of private keys.` -- Throughout the key lifecycle, secret keys must remain secret from all parties
	- `Assurance of public keys.` -- By default there are no assurances of whether a public key is correct, with whom it can be associated, or what it can be used for. Thus key management of public keys needs to focus much more explicitly on assurance of purpose of public keys.
	
### Public Key Infrastructure (PKI)

- PKI provides assurance of public key. It provides the identification of public keys and their distribution. An anatomy of PKI comprises of the following components.
	- Public Key Certificate, commonly referred to as ‘digital certifica
	- Private Key tokens.
	- Certification Authority.
	- Registration Authority.
	- Certificate Management System.

### Digital Certificate

- For analogy, a certificate can be considered as the ID card issued to the person Digital Certificates are not only issued to people but they can be issued to computers, software packages or anything else that need to prove the identity in the electronic world.

	Anyone who needs the assurance about the public key and associated information of client, he carries out the signature validation process using CA’s (certifaction authority) public key. Successful validation assures that the public key given in the certificate belongs to the person whose details are given in the certificate.

### Certifying Authority (CA)

- As discussed above, the CA issues certificate to a client and assist other users to verify the certificate. The CA takes responsibility for identifying correctly the identity of the client asking for a certificate to be issued, and ensures that the information contained within the certificate is correct and digitally signs it.

	The key functions of a CA are as follows −
	- Generating key pairs 
	- Issuing digital certificates 
	- Publishing Certificates
	- Verifying Certificates
	- Revocation of Certificates
	
- There are four typical classes of certificate −
	- Class 1 − These certificates can be easily acquired by supplying an email address.
	- Class 2 − These certificates require additional personal information to be supplied.
	- Class 3 − These certificates can only be purchased after checks have been made about the requestor’s identity.
	- Class 4 − They may be used by governments and financial organizations needing very high levels of trust.
	
- `Registration Authority (RA)` -- CA may use a third-party Registration Authority (RA) to perform the necessary checks on the person or company requesting the certificate to confirm their identity.

- `Certificate Management System (CMS)` -- It is the management system through which certificates are published, temporarily or permanently suspended, renewed, or revoked. 

- `Private Key Tokens` -- While the public key of a client is stored on the certificate, the associated secret private key can be stored on the key owner’s computer. This method is generally not adopted. If an attacker gains access to the computer, he can easily gain access to private key.

### Hierarchy of CA

- With vast networks and requirements of global communications, it is practically not feasible to have only one trusted CA from whom all users obtain their certificates. Secondly, availability of only one CA may lead to difficulties if CA is compromised.

	Certificate authority (CA) hierarchies are reflected in certificate chains. A certificate chain traces a path of certificates from a branch in the hierarchy to the root of the hierarchy.

<br>
<br>

---

<br>
<br>

# Future of Cryptography

- `Elliptic Curve Cryptography (ECC)` --  has already been invented but its advantages and disadvantages are not yet fully understood. ECC allows to perform encryption and decryption in a drastically lesser time, thus allowing a higher amount of data to be passed with equal security. However, as other methods of encryption, ECC must also be tested and proven secure before it is accepted for governmental, commercial, and private use.

- `Quantum computation` -- is the new phenomenon. While modern computers store data using a binary format called a "bit" in which a "1" or a "0" can be stored; a quantum computer stores data using a quantum superposition of multiple states. These multiple valued states are stored in "quantum bits" or "qubits". This allows the computation of numbers to be several orders of magnitude faster than traditional transistor processors.
