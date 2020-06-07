# Chapter 30: Network Security

- __`Introduction`__ -- This chapter considers the important aspect of network security. The
chapter describes types of crime that have been perpetrated over the Internet, discusses
key aspects of security, and explains technologies used to increase network security.

- __`Criminal Exploits And Attacks`__ -- Whenever a new technology appears, criminals ask how they can use the technology to commit crimes. The Internet is no exception — Although Internet
crimes, such as scams and identity theft, can affect individuals, the most significant
crimes pose a threat to businesses. In addition to outright theft of goods or services,
businesses are especially concerned with threats to the long-term viability of the company. Thus, damage to reputation, loss of customer confidence, stolen intellectual property, and prevention of customer access are all important to a business

  summarizes some of the major security problems that exist on the Internet:
  - Phishing -- Masquerading as a well-known site such as a bank
to obtain a user’s personal information, typically an
account number and access code
  - Misrepresentation -- Making false or exaggerated claims about goods or
services, or delivering fake or inferior products 
  - Scams -- Various forms of trickery intended to deceive naive
users into investing money or abetting a crime
  - Denial of Service -- Intentionally blocking a particular Internet site to
prevent or hinder business activities and commerce
  - Loss of Control -- An intruder gains control of a computer system
and uses the system to perpetrate a crime
  - Loss of Data Loss -- of intellectual property or other valuable
proprietary business information

  Techniques used in security attacks:
  - Wiretapping -- Making a copy of packets as they traverse a
network to obtain information
  - Replay -- Sending packets captured from a previous session
(e.g., a password packet from a previous login)
  - Buffer overflow -- Sending more data than a receiver expects in order
to store values in variables beyond the buffer
  - Address Spoofing -- Faking the IP source address in a packet to trick
a receiver into processing the packet
  - Name Spoofing -- Using a misspelling of a well-known name or
poisoning a name server with an incorrect binding
  - DoS and DDoS -- Flooding a site with packets to prevent the site
from successfully conducting normal business
  - SYN flood -- Sending a stream of random TCP SYN segments
to exhaust a receiver’s set of TCP connections
  - Key Breaking -- Automatically guessing a decryption key or a
password to gain unauthorized access to data
  - Port Scanning -- Attempting to connect to each possible protocol
port on a host to find a vulnerability
  - Packet interception -- Removing a packet from the Internet which allows
substitution and man-in-the middle attacks

- __`Security Policy`__ -- What is a secure network? Although the concept of a secure network is appealing
to most users, networks cannot be classified simply as secure or not secure because the
term is not absolute — each organization defines the level of access that is permitted or
denied. For example, an organization that keeps valuable trade secrets may need to
prevent outsiders from accessing the organization’s computers. An organization that
has a web site which makes information available may define a secure network as one
that allows arbitrary access to data, but includes mechanisms that prevent outsiders from
changing the data

  Because no absolute definition of secure network exists, the first step an organization must take to achieve a secure system is to define the organization’s security policy.
The policy does not specify how to achieve protection. Instead, it states clearly and
unambiguously the items that are to be protected.

- __`Responsibility And Control`__ -- In addition to the items above, an organization must specify exactly how responsibility for information is assigned or controlled. The issue of responsibility for information has two aspects:
  - Accountability. Accountability refers to how an audit trail is kept:
which group is responsible for each item of data? How does the
group keep records of access and change?
  - Authorization. Authorization refers to responsibility for each item
of information and how such responsibility is delegated to others:
who is responsible for where information resides, and how does a
responsible person approve access and change?

- __`Security Technologies`__ -- Many security products exist that perform a variety of functions for both individual
computers and a set of computers in an organization:
  - Hashing -- Data integrity
  - Encryption -- Privacy
  - Digital Signatures -- Message authentication
  - Digital Certificates -- Sender authentication
  - Firewalls -- Site integrity
  - Intrusion Detection Systems -- Site integrity
  - Deep Packet Inspection & Content Scanning -- Site integrity
  - Virtual Private Networks (VPNs) -- Data privacy

- __`Hashing: An Integrity And Authentication Mechanism`__ -- Typical encoding schemes use cryptographic hashing mechanisms.
One hashing scheme relies on a secret key known only to the sender and receiver. The
sender takes a message as input, uses the key to compute a hash, H, and transmits H
along with the message. H is a short string of bits, and the length of H is independent
of the message size. The receiver uses the key to compute a hash of the message, and
compares the hash to H.

- __`Access Control And Passwords`__ -- An access control mechanism controls which users or application programs can access data. For example, some operating systems implement an access control list (ACL)
for each object that specifies who is allowed to access the object.

- __`Encryption: A Fundamental Security Technique`__ -- Cryptography is a fundamental tool in security because encryption can guarantee
data confidentiality (sometimes called privacy), message authenticity, data integrity, and
can prevent replay attacks. In essence, a sender applies encryption to scramble the bits
of the message in such a way that only the intended recipient can unscramble them

- __`Private Key Encryption`__ -- Many encryption technologies exist, and they can be divided into two broad
categories that are defined by the way they use keys: `public key`, `private key`

  In a private key system, each pair of communicating entities share a single key that
serves as both an encryption key and a decryption key. The name arises because the key
must be kept secret — if a third party obtains a copy of the key, the third party will be
able to decrypt messages passing between the pair.

- __`Public Key Encryption`__ -- The chief alternative to private key encryption is known as public key encryption.
A public key system assigns each entity a pair of keys. For purposes of discussion, we
will assume that each entity is a single user. One of the user’s keys, called the private
key, is kept secret, while the other, called the public key, is published along with the
name of the user, so everyone knows the value of the key. The encryption function has
the mathematical property that a plaintext message encrypted with the public key cannot
be decrypted except with the private key, and a plaintext message encrypted with the
private key cannot be decrypted except with the public key.

- __`Authentication With Digital Signatures`__ -- An encryption mechanism can also be used to authenticate the sender of a message. The technique is known as a digital signature. To sign a message, the sender encrypts the message using a key known only to the sender†. The recipient uses the inverse function to decrypt the message. The recipient knows who sent the message because only the sender has the key needed to perform the encryption.

  Consider how a public key system can be used to provide a digital signature. To
sign a message, a sender encrypts the message using his or her private key. To verify
the signature, the recipient looks up the sender’s public key and uses it to decrypt the
message. Because only the sender knows the private key, only the sender can encrypt a
message that can be decoded with the public key.

- __`Key Authorities And Digital Certificates`__ -- One of the fundamental questions surrounding public key technology arises from
the way in which a public key is obtained. Although it is possible to use a conventional
publication (analogous to a telephone book), doing so is cumbersome and prone to error
because humans would need to enter the keys into their computers manually. The question arises: can an automated system be devised to distribute public keys? Of course, the distribution system must be secure The problem is known as
the key distribution problem

  It is possible to create a secure key distribution system that only requires manual configuration of one public key.

- __`Firewalls`__ -- Although encryption technology helps solve many security problems, a second
technology is needed. Known as an Internet firewall†, the technology helps protect an
organization’s computers and networks from unwanted Internet traffic. Like a conventional firewall, an Internet firewall is designed to keep problems in the Internet from
spreading to an organization’s computers.

  If an organization has multiple Internet connections, a firewall must be placed on
each, and all the organization’s firewalls must be configured to enforce the
organization’s security policy.

  Firewalls are the most important security tool used to handle the connection
between two organizations that do not trust each other Furthermore, a firewall can prevent unwanted data export (e.g., a user in the organization inadvertently imports a virus that sends a copy of the user’s disk to someone
outside the organization). A firewall has a key advantage over other security schemes: it centralizes control,
and thereby improves security dramatically.

- __`Firewall Implementation With A Packet Filter`__ -- Although a firewall can consist of a stand-alone device, most firewalls are embedded in a switch or router. In either case, the underlying mechanism used to build a
firewall is known as a packet filter. A filter consists of a configurable mechanism that
examines fields in each packet header and decides whether to allow the packet to pass
through the router or to discard the packet.

  A firewall uses packet filtering to prevent unwanted communication.
Each filter specification gives a combination of header fields, including source and destination IP addresses and port numbers as well as
the transport protocol type

- __`Intrusion Detection Systems`__ -- An Intrusion Detection System (IDS) monitors all packets arriving at a site and notifies the site administrator if a security violation is detected. An IDS provides an extra
layer of security awareness — even if a firewall prevents an attack, an IDS can notify
the site administrator that a problem is occurring.

  Most IDSs can be configured to watch for specific types of attacks. For example,
an IDS can be configured to detect a port scanning attack where an attacker either sends
UDP datagrams to successive UDP protocol ports or attempts to open a TCP connection
on successive TCP protocol ports. Similarly, an IDS can be configured to detect a potential SYN flooding attack by watching for repeated SYNs from a given source.

  For example, if an IDS
detects a SYN flood coming from a given source, the IDS can install a firewall rule that
blocks packets from the source. The reason for using an automated approach is speed

- __`Content Scanning And Deep Packet Inspection`__ -- Although it can handle many security problems, a firewall has a severe limitation:
it only examines fields in a packet header. That is, a firewall cannot test the payload of
a packet. To see why the contents of packets can be important, consider computer
viruses. One of the most common ways a virus is introduced into an organization is
through an email attachment

  How can a site prevent problems such as the installation of a virus? The answer
lies in content analysis. There are two types of content analysis:
  - File scanning
  - Deep Packet Inspection (DPI)
  
  In essence, a file scanner takes a file as input and looks for patterns of bytes that indicate a problem. For example, many virus scanners look for
strings of bytes known as a fingerprint

  Deep Packet Inspection (DPI). The second form of content analysis operates on
packets instead of files. That is, instead of merely examining the headers in packets
that pass into the site, a DPI mechanism also examines the data in the packet payload. Because they examine packet payloads which are much larger than
packet headers and not organized into fixed fields, Deep Packet Inspection mechanisms are limited to lower-speed networks

- __`Virtual Private Networks (VPNs)`__ -- One of the most important and widely-used security technologies uses encryption
to provide secure access to an organization’s intranet from remote sites. Known as a
Virtual Private Network (VPN), the technology was originally designed to provide a
low-cost interconnection among multiple geographic sites of an organization.

- __`The Use of VPN Technology For Telecommuting`__ -- Although originally designed to interconnect sites, VPN technology has become
extremely popular among employees who telecommute (i.e., work from a remote location). There are two forms of VPN: `standalone device`, `VPN software`

- __`Packet Encryption Vs. Tunneling`__ -- The above discussion of VPNs raises an interesting question: how should data be
encrypted for transmission across the Internet? There are three main options:
  - Payload Encryption
  - IP-in-IP Tunneling
  - IP-in-TCP Tunneling 

- __`Security Technologies`__ -- A variety of security technologies have been invented for use in the Internet.
Highlights include:
  - PGP (Pretty Good Privacy). A cryptographic system that applications can use to encrypt data before transmission. PGP was
developed at MIT, and is especially popular among computer
scientists.
  - SSH (Secure Shell). An application-layer protocol for remote login
that guarantees confidentiality by encrypting data before transmission across the Internet.
  - SSL (Secure Socket Layer). A technology originally designed by
Netscape Communications that uses encryption to provide authenti- cation and confidentiality. SSL software fits between an application and the socket API, and encrypts data before transmitting over
the Internet
  - TLS (Transport Layer Security). Designed by the IETF in the late
1990s as a successor to SSL, TLS builds on version 3 of SSL.
Both SSL and TLS are available for use with HTTPS
  - HTTPS (HTTP Security). Not really a separate technology, HTTPS
combines HTTP with either SSL or TLS and a certificate mechanism to provide users with authenticated, confidential communication over the Web. HTTPS uses TCP port 443 instead of port 80.
  - IPsec (IP security). A security standard used with IP datagrams.
IPsec uses cryptographic techniques, and allows the sender to
choose authentication
  - RADIUS (Remote Authentication Dial-In User Service). A protocol
used to provide centralized authentication, authorization, and accounting. RADIUS is popular with ISPs that have dialup users and
with VPN systems
  - WEP (Wired Equivalent Privacy). Originally part of the Wi-Fi
wireless LAN standard† used to keep transmissions confidential

<br>
<br>

---

<br>
<br>

# Chapter 31: Network Management (SNMP)

- __`Introduction`__ --  This chapter expands our study of network applications by considering network
management. The chapter introduces a conceptual model used in industry, and uses the
model to explain the scope of management activities

- __`Managing An Intranet`__ -- A network manager, sometimes called a network administrator, is a person responsible for planning, installing, operating, monitoring, and controlling the hardware and
software systems that constitute a computer network or intranet

  Although network hardware and protocol software contain mechanisms to automatically route around failures or retransmit lost packets, network managers need to detect and correct underlying problems.

- __`FCAPS: The Industry Standard Model`__ -- abbrevations:
  - F -- Fault detection and correction
  - C -- Configuration and operation
  - A -- Accounting and billing
  - P -- Performance assessment and optimization
  - S -- Security assurance and protection
  
  Fault Detection And Correction. Fault detection accounts for a major part of the
operational aspect of network management. A manager monitors network equipment to
detect problems, and takes appropriate steps to correct the problem.

  Configuration And Operation , configuration is complex for three reasons. First,
a network contains many devices and services, and the configurations must be consistent across all devices. Second, as new equipment and services are added or policies
change, a network manager must consider all configurations to insure the entire network
implements the changes correctly

  Accounting And Billing. In many corporate intranets, accounting and billing is
trivial. The corporation charges the cost of running a network to a central account,
much like the cost of electrical power or telephone service. In ISP networks, however,
accounting and billing can consume more of a manager’s time than any other aspect of
management.

  Performance Assessment And Optimization. A manager performs two types of performance assessment: diagnostic assessment to detect problems and inefficiencies and
trend assessment that allows a manager to anticipate the need for increased capacity.

  Security Assurance And Protection. Because it crosses layers of the protocol stack
and spans multiple devices, security is among the most difficult aspects of network management. In particular, security follows the weakest-link analogy: the entire security of a site can be compromised if the configuration is incorrect on one device

- __`Example Network Elements`__ -- Network management systems use the generic term network element to refer to any
network device, system, or mechanism that can be managed. Although many network
elements consist of a physical device, the definition encompasses services such as DNS. for example:
  - Layer 2 Switch
  - DHCP Server
  - Head-End DSL Modem
  - Firewall
  - Web Server
  - IP router
  - ... etc.
  
  Because it only permits a manager to configure, monitor, or control
one network element at a time, an element management system is labor intensive and prone to errors.

- __`Network Management Tools`__ -- Network management tools can be classified into twelve categories that characterize their general purpose:
  - Physical Layer Testing
  - Reachability And Connectivity
  - Packet Analysis
  - Network Discovery
  - Device Interrogation
  - Event Monitoring
  - Performance Monitoring
  - Flow Analysis
  - Routing And Traffic Engineering
  - Configuration
  - Security Enforcement
  - Network Planning

- __`Network Management Applications`__ -- When a manager needs to interact with a specific
hardware device, the manager runs an application program that acts as a client, and an
application program on the network device acts as a server. The client and server use
conventional transport protocols such as UDP or TCP to interact. Furthermore, instead
of building a separate network, most managers send management traffic over the production network.

  To avoid confusion between application programs that users invoke and applications that are reserved for network managers, network management systems avoid the
terms client and server. Instead, the client application that runs on the manager’s computer is called a manager, and a server that runs on a network device is called an
agent†.

- __`Simple Network Management Protocol`__ -- The standard protocol used for network management is known as the Simple Network Management Protocol (SNMP); the current standard is version 3, written SNMPv3.
The SNMP protocol defines exactly how a manager communicates with an agent.

- __`SNMP’s Fetch-Store Paradigm`__ -- SNMP uses the fetch-store paradigm for interaction between a
manager and an agent. A manager fetches values to determine the
device status; operations that control the device are defined as the
side-effects of storing into objects.

- __`The SNMP MIB And Object Names`__ -- Each object to which SNMP has access must be defined and given a unique name.
Furthermore, both the manager and agent programs must agree on the names and the
meanings of fetch and store operations. Collectively, the set of all objects SNMP can
access is known as a Management Information Base (MIB).

- __`The Variety Of MIB Variables`__ -- Because SNMP does not specify a set of MIB variables, the design is flexible.
New MIB variables can be defined and standardized as needed, without changing the
basic protocol

- __` MIB Variables That Correspond To Arrays`__ -- In addition to simple variables such as integers that correspond to counters, a MIB
can include variables that correspond to tables or arrays Although ASN.1 does not provide a mechanism for indexing, MIB
variables can correspond to tables or arrays. To emulate a table or
an array with an ASN.1 variable, the index for an entry is encoded by
appending it to the variable name; when agent software encounters a
name that corresponds to a table, the software extracts and uses the
index information to select the correct table entry

<br>
<br>

---

<br>
<br>



