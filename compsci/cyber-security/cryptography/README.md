# Cryptography

- This tutorial covers the basics of the science of cryptography. It explains how programmers and network professionals can use cryptography to maintain the privacy of computer data. Starting with the origins of cryptography, it moves on to explain cryptosystems, various traditional and modern ciphers, public key encryption, data integration, message authentication, and digital signatures.

<br>
<br>

---

<br>
<br>

# Origin of Cryptography

- Human being from ages had two inherent needs − (a) to communicate and share information and (b) to communicate selectively. These two needs gave rise to the art of coding the messages in such a way that only the intended people could have access to the information.

  The word ‘cryptography’ was coined by combining two Greek words, ‘Krypto’ meaning hidden and ‘graphene’ meaning writing.

### History of Cryptography

- human beings got organized in tribes, groups, and kingdoms. This led to the emergence of ideas such as power, battles, supremacy, and politics. These ideas further fueled the natural need of people to communicate secretly with selective recipient which in turn ensured the continuous evolution of cryptography as well.

  The roots of cryptography are found in Roman and Egyptian civilizations.

### Evolution of Cryptography

- It is during and after the European Renaissance, various Italian and Papal states led the rapid proliferation of cryptographic techniques. Various analysis and attack techniques were researched in this era to break the secret codes.
  - Improved coding techniques such as Vigenere Coding came into existence in the 15th century, which offered moving letters in the message with a number of variable places instead of moving them the same number of places.
  - Only after the 19th century, cryptography evolved from the ad hoc approaches to encryption to the more sophisticated art and science of information security.
  - In the early 20th century, the invention of mechanical and electromechanical machines, such as the Enigma rotor machine, provided more advanced and efficient means of coding the information.
  - During the period of World War II, both cryptography and cryptanalysis became excessively mathematical.

<br>
<br>

---

<br>
<br>

# Modern Cryptography

- Modern cryptography is the cornerstone of computer and communications security. Its foundation is based on various concepts of mathematics such as number theory, computational-complexity theory, and probability theory.

### Characteristics of Modern Cryptography

- There are three major characteristics that separate modern cryptography from the classical approach.
  - It operates on binary bit sequences. (traditional: letters, digits 0-9)
  - It relies on publicly known mathematical algorithms for coding the information. Secrecy is obtained through a secrete key which is used as the seed for the algorithms. The computational difficulty of algorithms, absence of secret key, etc., make it impossible for an attacker to obtain the original information even if he knows the algorithm used for coding.
  - Modern cryptography requires parties interested in secure communication to possess the secret key only.

### Context of Cryptography

- Cryptology, the study of cryptosystems, can be subdivided into two branches −
  - Cryptography
  - Cryptanalysis
  
- `Cryptography` -- Cryptography deals with the actual securing of digital data. It refers to the design of mechanisms based on mathematical algorithms that provide fundamental information security services.

- `Cryptanalysis` -- Cryptanalysis is the sister branch of cryptography and they both co-exist. The cryptographic process results in the cipher text for transmission or storage. It involves the study of cryptographic mechanism with the intention to break them. Cryptanalysis is also used during the design of the new cryptographic techniques to test their security strengths.

### Cryptography Primitives

- Cryptography primitives are nothing but the tools and techniques in Cryptography that can be selectively used to provide a set of desired security services −
  - Encryption
  - Hash functions
  - Message Authentication codes (MAC)
  - Digital Signatures

<br>
<br>

---

<br>
<br>

# Cryptosystems

- A cryptosystem is an implementation of cryptographic techniques and their accompanying infrastructure to provide information security services. A cryptosystem is also referred to as a cipher system.

### Components of a Cryptosystem

- The various components of a basic cryptosystem are as follows −
  - `Plaintext`. It is the data to be protected during transmission.
  - `Encryption Algorithm`. It is a mathematical process that produces a ciphertext for any given plaintext and encryption key. It is a cryptographic algorithm that takes plaintext and an encryption key as input and produces a ciphertext.
  - `Ciphertext`. It is the scrambled version of the plaintext produced by the encryption algorithm using a specific the encryption key. The ciphertext is not guarded. It flows on public channel. It can be intercepted or compromised by anyone who has access to the communication channel.
  - `Decryption Algorithm`, It is a mathematical process, that produces a unique plaintext for any given ciphertext and decryption key. It is a cryptographic algorithm that takes a ciphertext and a decryption key as input, and outputs a plaintext. The decryption algorithm essentially reverses the encryption algorithm and is thus closely related to it.
  - `Encryption Key`. It is a value that is known to the sender. The sender inputs the encryption key into the encryption algorithm along with the plaintext in order to compute the ciphertext.
  - `Decryption Key`. It is a value that is known to the receiver. The decryption key is related to the encryption key, but is not always identical to it. The receiver inputs the decryption key into the decryption algorithm along with the ciphertext in order to compute the plaintext.
  
  For a given cryptosystem, a collection of all possible decryption keys is called a `key space`.

### Types of Cryptosystems

- Fundamentally, there are two types of cryptosystems based on the manner in which encryption-decryption is carried out in the system −
  - Symmetric Key Encryption
  - Asymmetric Key Encryption

- `Symmetric Key Encryption` -- The encryption process where same keys are used for encrypting and decrypting the information is known as Symmetric Key Encryption.

- `Asymmetric Key Encryption` -- The encryption process where different keys are used for encrypting and decrypting the information is known as Asymmetric Key Encryption

  It requires to put the public key in public repository and the private key as a well-guarded secret. Hence, this scheme of encryption is also called Public Key Encryption.
  
  Public-key cryptosystems have one significant challenge − the user needs to trust that the public key that he is using in communications with a person really is the public key of that person and has not been spoofed by a malicious third party. This is usually accomplished through a Public Key Infrastructure (PKI) consisting a trusted third party. The third party securely manages and attests to the authenticity of public keys

### Kerckhoff’s Principle for Cryptosystem

- In the 19th century, a Dutch cryptographer A. Kerckhoff furnished the requirements of a good cryptosystem. Kerckhoff stated that a cryptographic system should be secure even if everything about the system, except the key, is public knowledge. The six design principles defined by Kerckhoff for cryptosystem are −
  - The cryptosystem should be unbreakable practically, if not mathematically.
  - Falling of the cryptosystem in the hands of an intruder should not lead to any compromise of the system, preventing any inconvenience to the user.
  - The key should be easily communicable, memorable, and changeable.
  - The ciphertext should be transmissible by telegraph, an unsecure channel.
  - The encryption apparatus and documents should be portable and operable by a single person.
  - Finally, it is necessary that the system be easy to use, requiring neither mental strain nor the knowledge of a long series of rules to observe.

<br>
<Br>
  
---

<br>
<br>

# Attacks on Cryptosystems

- Attacks are typically categorized based on the action performed by the attacker. An attack, thus, can be passive or active.

### Passive Attacks

- For example, actions such as intercepting and eavesdropping on the communication channel can be regarded as passive attack.

  These actions are passive in nature, as they neither affect information nor disrupt the communication channel. A passive attack is often seen as stealing information. The only difference in stealing physical goods and stealing information is that theft of data still leaves the owner in possession of that data

### Active Attacks

- An active attack involves changing the information in some way by conducting some process on the information. For example,
  - Modifying the information in an unauthorized manner.
  - Initiating unintended or unauthorized transmission of information.
  - Alteration of authentication data such as originator name or timestamp associated with information
  - Unauthorized deletion of data.
  - Denial of access to information for legitimate users (denial of service).

### Assumptions of Attacker

- In cryptography, the following three assumptions are made about the security environment and attacker’s capabilities:
  
- `Details of the Encryption Scheme` -- The design of a cryptosystem is based on the following two cryptography algorithms −
  - Public Algorithms − With this option, all the details of the algorithm are in the public domain, known to everyone.
  - Proprietary algorithms − The details of the algorithm are only known by the system designers and users.

  In case of proprietary algorithms, security is ensured through obscurity. Private algorithms may not be the strongest algorithms as they are developed in-house and may not be extensively investigated for weakness. Also, according to Kerckhoff’s principle, the algorithm is preferred to be public with strength of encryption lying in the key. Thus, the first assumption about security environment is that the encryption algorithm is known to the attacker.

- `Availability of Ciphertext` -- We know that once the plaintext is encrypted into ciphertext, it is put on unsecure public channel (say email) for transmission. Thus, the attacker can obviously assume that it has access to the ciphertext generated by the cryptosystem.

- `Availability of Plaintext and Ciphertext` -- This assumption is not as obvious as other. However, there may be situations where an attacker can have access to plaintext and corresponding ciphertext. Some such possible circumstances are −
  - The attacker influences the sender to convert plaintext of his choice and obtains the ciphertext.
  - The receiver may divulge the plaintext to the attacker inadvertently. The attacker has access to corresponding ciphertext gathered from open channel.
  - In a public-key cryptosystem, the encryption key is in open domain and is known to any potential attacker. Using this key, he can generate pairs of corresponding plaintexts and ciphertexts.
  
### Cryptographic Attacks



<br>
<Br>
  
---

<br>
<br>

# Traditional Ciphers
