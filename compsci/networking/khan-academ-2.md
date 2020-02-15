# TCP/IP: Reliable data transmission

- The postal system tries hard to deliver letters to their destination, but sometimes, things happen along the way: natural disasters, thefts, messy handwriting, hungry dogs.

  The internet is a lot like a postal system: it has to get information from one part of the world to another part of the world. Once again, things can happen along the way, like a fire destroying an ethernet cable.
  
<br>

### Internet Routing Protocol

- In the Internet Protocol (IP), computers split their messages up into packets and those packets hop from router to router on their way to their destination, the data does not transfer between computerss in a straight network line. Let's step through the process of routing a packet from a source to a destination.

  __Step 1: Send packet to router__ == Computers send the first packet to the nearest router. A router is a special computer on the internet that helps the packets move along.
  
  __Step 2: Router receives packet__ == When the router receives a packet, it looks at its IP header. The most important field is the destination IP address, which tells the router where the packet wants to end up.
  
  __Step 3: Router forwards packet__ == The router has multiple paths it could send a packet along, and its goal is to send the packet to a router that's closer to its final destination. Once the router locates the most specific row in the table for the destination IP address, it sends the packet along that path.
  
  __Step 4: Final router forwards message__ == If all goes well, the packet should eventually arrive at a router that knows exactly where to send it. The router can now send the message to the destination IP address, which may be a personal computer or a server.

- `Redundancy in the network` -- What happens if a network path is no longer available, like due to a natural disaster physically destroying it or a cybercriminal hijacking it? Is the packet doomed to never reach its destination? Never fear! There are typically many possible paths a packet can go down to reach the same destination. The redundancy of the paths in the network help the internet be more fault-tolerant and reliable.

<br>
<br>

---

<br>
<br>


# Transmission Control Protocol (TCP)

- In the Internet Protocol (IP), computers send messages to other computers via a network of routers. But there's a limit to how big those messages can be, due to physical limitations of the internet's infrastructure. That's why computers split those messages into multiple small packets.

- Many things could go wrong once a single message is split into packets. Here are some big ones:
  - Packets can be lost, due to problems in the physical layer or in routers' forwarding tables. A message needs every single packet to be put back together.
  - Packets can arrive out of order. That can happen especially if two packets follow different paths to the destination.
  - A computer might send multiple messages to a destination, and the destination needs to identify which packet belongs to which message
  
  TCP to the rescue! The Transmission Control Protocol is always used alongside the IP in order to ensure reliable transmission of packets. Together, the protocols are known as TCP/IP.

- `From start to finish` -- Let's step through the process of sending and receiving packets. Note that this process happens entirely within the IP routing protocol.

  __Step 1: Establish connection__ == When two computers want to send data to each other, they first need to establish a connection with the TCP "3-way handshake". Once the computers are done with the handshake, they know they're both ready to receive actual data.
  
  __Step 2: Send packets of data__ == Either computer can now send packets of data. When either computer receives a packet of data, it always replies back to confirm what it received. Each packet contains the data itself, plus important details that improve the reliability of TCP, like the sequence number.
  
  __Step 3: Close the connection__ == Either computer can close the connection when they no longer want to send or receive data.

- `Reliable transmission` -- TCP includes multiple mechanisms that ensure reliable transmission of packets.
As one example, a sending computer can detect when a packet has been lost by noticing that a packet hasn't been acknowledged within a period of time. Once the sender detects packet loss, it will re-transmit the lost packet

<bR>
<br>
  
---

<br>
<br>

# TLS: Secure data transport

- We send a whole lot of secure information around the internet: emails with details on our private life, passwords that we type into login screens, tax documents that we upload to servers. The TCP/IP protocols send that private data in packets on the same routes as everyone else's data, and unfortunately, cybercriminals figured out ways to look at the data whizzing around the internet.

  That's where encryption comes in: encrypting data means that we scramble the original data to hide the meaning of the text, while still making it possible for the data to be unscrambled using a secret key. Encryption enables two people (or computers!) to share private information over open networks.
  
### Encryption, Decryption, and Cracking

- `Encrypting a message` -- One of the earliest encryption techniques is the Caesar Cipher, invented by Julius Caesar more than two thousand years ago to communicate messages to his allies. The Caesar Cipher is a great introduction to encryption, decryption, and code cracking, thanks to its simplicity.

  The Caesar Cipher is a simple substitution cipher which replaces each original letter with a different letter in the alphabet by shifting the alphabet by a certain amount. Lets shift this `PALACE` word 6 places which makes it `VGRGIK`
  
- `Decrypting a message` -- In order for ceasers cipher to work both parties who receieve and send the message has to agree on a "shift number" that they will use to decrpyt and encrpyt the data. This agreed number is called a `key`. According to historical records, Caesar always used a shift of 3. As long as his message recipient knew the shift amount, it was trivial for them to decode the message.

- `Cracking the cipher` -- There are three main techniques we can use: frequency analysis, known plaintext, and brute force.
  - __Frequency analysis__ == Human languages tend to use some letters more than others. For example, "E" is the most popular letter in the English language. We can analyze the frequency of the characters in the message and identify the most likely "E" and narrow down the possible shift amounts based on that.
  - __Known plain text__ == Messages tend to start with similar beginnings. In WWII, messages always started with a weather report, which ultimately made the messages easier to crack
  - __Brute force__ == There are only 25 possible shifts (not 26 — why not?). The enemy could take some time to try out each of them and find one that yielded a sensible message. They wouldn't even need to try the shifts on the entire message, just the first word or two.
  
- `Encryption, decryption, and cracking` -- Thanks to this exploration of the Caesar Cipher, we now understand the three key aspects of data encryption:
  - Encryption: scrambling the data according to a secret key (in this case, the alphabet shift).
  - Decryption: recovering the original data from scrambled data by using the secret key.
  - Code cracking: uncovering the original data without knowing the secret, by using a variety of clever techniques.
  
### Symmetric encryption techniques

- A symmetric encryption is any technique where the same key is used to both encrypt and decrypt the data. The Caesar Cipher is one of the simplest symmetric encryption techniques, and of course, one of the easiest to crack.

- `Vigenère Cipher` -- French cryptologists invented the Vigenère Cipher in the mid 1500s. The cipher was considered especially strong, and author Lewis Caroll even called it “unbreakable” in 1868. It was indeed much stronger than the Caesar Cipher, but as we’ll see, it can definitely be cracked.

  __Encryption__ == The Vigenère cipher uses an entire word as the shift key, as opposed to the Caesar Cipher’s single shift amount. Imagine that we want to encrypt the phrase VERSAILLES and use a shift key of CHEESE. First, we need to repeat the shift key to line up with each of the letters in the phrase:
    ```
    original:   V E R S A I L L E S
    shift key:  C H E E S E C H E E
    ```
    And you will use the vingenere table to create a encryption. Or if you do not have access to the table you can simply shift such as this, C-3, E-5 you can shifht the amount of places depending on the index location of the key character.
  
  __Decryption__ == If an intercepter had no idea what the shift key was and wanted to brute force their way to a decryption, they would need to try out all the possible shift words in the world, and perhaps even made-up words! For a mere mortal, that could take a lifetime. That's much more work than brute forcing the Caesar Cipher, where we just had to check 26 different shift amounts.
  
  __Cracking the cipher__ == What about frequency analysis? Do messages encrypted with the Vigenere cipher have a special pattern in their distribution of letters? In the 1800s, people finally figured out different ways to use frequency analysis to crack the cipher. For example, in a long message, a short word like "THE" may get translated to the same three encrypted letters multiple times (just not every time), and that reveals possible lengths for the shift key.

- `Modern ciphers` -- In the age of computers, ciphers can't just be hard to crack by an enterprising human; they have to be hard to crack by a computer that can do trillions of calculations per second. Fortunately, cryptologists have invented encryption techniques that are secure in the digital world, and are continuing to improve them every year. One of the most common encryption standards is AES-128, a block cipher approved by the federal government and used often for secure file transfer.

  One reason is that each key is always 128 bits long. That means there are 2^{128} possible keys. That's this many: 340,000,000,000,000,000,000,000,000,000,000,000,000340,000,000,000,000,000,000,000,000,000,000,000,000
  
  The fastest computer would still take 500 trillion years to try every possible 128-bit key! What about frequency analysis? It won't work. The AES cipher does not reveal any information about the original text, thanks to the multi-step sequence of operations on blocks of bits.
  
  The AES ciphers, and other modern ciphers, may not be secure forever. Security researchers spend their time trying to find clever ways to break the cipher, and present findings in blogs and conference talks.

### Public key encryption

- On the internet, two computers often want to exchange secure data with each other. When I type my password into the Khan Academy login screen, I want my computer to send that data safely to the Khan Academy servers. I do not want to worry that a cybercriminal might be monitoring my internet traffic and watching the password go across the wires.

  Symmetric encryption techniques rely on both the sender and receiver using the same key to encrypt and decrypt the data. How can my computer and the Khan Academy server exchange the key securely? If a cybercriminal can see my password go across the wires, then they can also see an encryption key!
  
  Public key encryption to the rescue! It's an asymmetric encryption technique which uses different keys for encryption and decryption, allowing computers over the internet to securely communicate with each other.

- `Step 1: Key generation` -- Each person (or their computer) must generate a pair of keys that identifies them: a private key and a public key.

- `Step 2: Key exchange` -- The sending and receiving computers exchange public keys with each other via a reliable channel, like TCP/IP. The private keys are never exchanged.

- `Step 3: Encryption` -- The sending computer encrypts the secret data using the receiving computer's public key and a mathematical operation. The power of public key encryption is in that mathematical operation. It's a "one-way function", which means it's incredibly difficult for a computer to reverse the operation and discover the original data. Even the public key cannot be used to decrypt the data.

- `Step 4: Sending encrypted data` -- The sender can now safely transmit the encrypted data over the internet without worry of onlookers.

- `Step 5: Decryption` -- Now the receiver can decrypt the message, using their private key. That's the only key that can be used to decrypt the message (in the world!). Once you successfully decrypt the message, try decrypting it with the public key. It won't work; only the private key can decrypt it.

### Transport Layer Security (TLS)

- The Transport Layer Security (TLS) protocol adds a layer of security on top of the TCP/IP transport protocols. It takes advantage of both symmetric encryption and public key encryption for securely sending private data, and adds additional security features like authentication and message tampering detection. (Note that TLS was formerly known as SSL, so the two terms are often used interchangeably.)

  TLS adds more steps on top of TCP/IP, so it increases latency in internet communications. However, the security benefits are often worth the extra latency.

- `From start to finish` -- Let's step through the process of securely sending data with TLS from one computer to another. We'll call the sending computer the "client" and the receiving computer the "server".

  __TCP handshake__ == Since TLS is built on top of TCP/IP, the client must first complete the 3-way TCP handshake with the server.
  
  __TLS initiation__ == The client must notify the server that it desires a TLS connection instead of the standard insecure connection, so it sends along a message describing which TLS protocol version and encryption techniques it'd like to use.
  
  __Server confirmation of protocol__ == If the server doesn't support the client's requested technologies, it will abort the connection. That may happen if a modern client is trying to communicate with an older server. As long as the server does support the requested TLS protocol version and other options, it will respond with a confirmation, plus a digital certificate that contains its public key.
  
  __Certificate verification__ == The server's digital certificate is the server's way of saying "Yes, I really am who you think I am". If the client doesn't believe the certificate is legit, it will abort the connection, since it doesn't want to send private data to an imposter. Otherwise, if the client can verify the certificate, it continues on to the next step.
  
  __Shared key generation__ == The client now knows the public key of the server, so it can theoretically use public key encryption to encrypt data that the server can then decrypt with its corresponding private key. However, public key encryption takes much more time than symmetric encryption due to the more difficult arithmetic operations involved. When possible, computers prefer to use symmetric encryption to save time.Fortunately, they can! The computers can first use public key encryption to privately generate a shared key, and then they can use symmetric encryption with that key in future messages.
  
  __Server confirmation of shared key__ == The server can now compute the shared key based on the pre-master key, and attempt to decrypt the "Finished" message with that key. If it fails, it aborts the connection. As long as the server can successfully decrypt the client's message with the shared key, it sends along a confirmation and its own "Finished" message with encrypted contents.
  
  __Step 3: Send secure data__ == Finally, the client securely sends the private data to the server, using symmetric encryption and the shared key.

- `Certificate verification` -- In the TLS process above, the client does not send any data to the server until it has received and verified its digital certificate. That certificate verification step is a crucial part of what makes TLS so secure. Clients rely on certificate authorities to verify that a certificate (and its public key) belongs to a particular domain.

  Any server that wants to communicate securely over TLS signs up with a certificate authority. The certificate authority verifies their ownership of the domain, signs the certificate with their own name and public key, and provides the signed certificate back to the server.

- `TLS everywhere` -- TLS is used for many forms of secure communication on the internet, like secure email sending and secure file upload. However, it's most well known for its use in secure website browsing (HTTPS), which we'll explore more in the next lesson.

