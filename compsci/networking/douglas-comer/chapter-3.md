# Chapter 4: Traditional Internet Applications

- __`Introduction`__ -- The previous chapter introduces the topics of Internet applications and network
programming. The chapter explains that Internet services are defined by application
programs, and characterizes the client-server model that such programs use to interact.
The chapter also covers the socket API

- __`Application-Layer Protocols`__ -- Whenever a programmer creates two applications that communicate over a network, the programmer specifies details, such as:
  - The syntax and semantics of messages that can be exchanged
  - Whether the client or server initiates interaction
  - Actions to be taken if an error arises
  - How the two sides know when to terminate communication
  
  In specifying details of communication, a programmer defines an application-layer protocol. There are two broad types of application-layer protocols that depend on the intended use:
  - Private communication. A programmer creates a pair of applications that communicate over the Internet with the intention that the
pair is for private use. In most cases, the interaction between the
two applications is straightforward, which means a programmer
may choose to write code without writing a formal protocol specification.
  - Standardized service. An Internet service is defined with the expectation that many programmers will create server software to
offer the service or client software to access the service. In such
cases, the application-layer protocol must be documented independent of any implementation, and the specification must be precise
and unambiguous so that all clients and servers can interoperate
correctly.
  
- __`Representation And Transfer`__ -- Application-layer protocols specify two aspects of interaction: representation and
transfer. For a basic service, a single protocol standard can specify both aspects; more complex services use separate protocol standards to specify each aspect.

- __`Web Protocols`__ -- The World Wide Web is one of the most widely used services in the Internet. Because the Web is complex, many protocol standards have been devised to specify various aspects and details. Such as HTML, URL, HTTPS

- __`Document Representation With HTML`__ -- HyperText Markup Language is a representation standard for web
pages. To permit a page to be displayed on an arbitrary device,
HTML gives general guidelines for display and allows a browser to
choose details.

- __`Uniform Resource Locators And Hyperlinks`__ -- The Web uses a syntactic form known as a Uniform Resource Locator (URL) tospecify a web page. The general form of a URL is:
  ```
  protocol:// computer_name:port/ document_name%parameters
  ```
  where protocol is the name of the protocol used to access the document,
computer_name is the domain name of the computer on which the document resides,
:port is an optional protocol port number at which the server is listening,
document_name is the optional name of the document on the specified computer, and
%parameters give optional parameters for the page.
For example, the URL
  ```
  https://netbook.cs.purdue.edu/toc/toc01.htm
  ```

- __`Web Document Transfer With HTTP`__ --

- __`Caching In Browsers`__ --

- __`Browser Architecture`__ --

- __`File Transfer Protocol (FTP)`__ --

- __`FTP Communication Paradigm`__ --

- __`Electronic Mail`__ --

- __`The Simple Mail Transfer Protocol (SMTP)`__ --

- __`ISPs, Mail Servers, And Mail Access`__ --

- __`Mail Access Protocols (POP, IMAP)`__ --

- __`Email Representation Standards (RFC2822, MIME)`__ --

- __`Domain Name System (DNS)`__ --

- __`Domain Names That Begin With www`__ --

- __`The DNS Hierarchy And Server Model`__ --

- __`Name Resolution`__ --

- __`Caching In DNS Servers`__ --

- __`Types Of DNS Entries`__ --

- __`Aliases And CNAME Resource Records`__ --

- __`Abbreviations And The DNS`__ --

- __`Internationalized Domain Names`__ --

- __`Extensible Representations (XML)`__ --

<br>
<br>

---

<br>
<br>


# Chapter 5: Overview of Data Communications

<br>
<br>

---

<br>
<br>

# Chapter 6: Information Sources and Signals

<br>
<br>

---

<br>
<br>


# Chapter 7: Transmission Media

<br>
<br>

---

<br>
<br>

# Chapter 8: Reliablity and Channel Coding

<br>
<br>

---

<br>
<br>

# Chapter 9: Transmission Modes

<br>
<br>

---

<br>
<br>

# Chapter 10: Modulation and Modems

<br>
<br>

---

<br>
<br>

# Chapter 11: Multiplexing and Demultiplexing (Channelzation)

<br>
<br>

---

<br>
<br>

# Chapter 12: Access and Interconnection Techonologies

<br>
<br>

---

<br>
<br>

# Chapter 13: Local Area Netowkrs:Packets, Frames and Topologies

<br>
<br>

---

<br>
<br>

# Chapter 14: The IEEE MAC Sub-Layer 

<br>
<br>

---

<br>
<br>

# Chapter 15: Wired LAN Techonology (Ethernet And 802.3)

<br>
<br>

---

<br>
<br>

# Chapter 16: Wireless Networking Technologies

<br>
<br>

---

<br>
<br>

# Chapter 17: LAN Extensions: Fiber Modems, Repeaters, Bridges and Switches

<br>
<br>

---

<br>
<br>

# Chapter 18: WAN Technologies and Dynamic Routing

<br>
<br>

---

<br>
<br>

# Chapter 19: Networking Technologies Past and Present

<br>
<br>

---

<br>
<br>

# Chapter 20: Internetworking: Concepts Architecture and Protocols

<br>
<br>

---

<br>
<br>

# Chapter 21: IP:Internet Adressing

<br>
<br>

---

<br>
<br>

# Chapter 22: Datagram Forwarding

<br>
<br>

---

<br>
<br>

# Chapter 23: Support Protocols and Technologies

<br>
<br>

---

<br>
<br>

# Chapter 24: The Future IP (IPv6)

<br>
<br>

---

<br>
<br>

# Chapter 25: UDP: Datagram Transport Service

<br>
<br>

---

<br>
<br>

# Chapter 26: TCP: Reliable Transport Service

<br>
<br>

---

<br>
<br>

# Chapter 27: Internet Routing and Routing Protocols

<br>
<br>

---

<br>
<br>

# Chapter 28: Network Performance (QoS and DiffServ)

<br>
<br>

---

<br>
<br>

# Chapter 29: Multimedia and IP Telephony (VoIP)

<br>
<br>

---

<br>
<br>

# Chapter 30: Network Security

<br>
<br>

---

<br>
<br>

# Chapter 31: Network Management (SNMP)

<br>
<br>

---

<br>
<br>

# Chapter 32: Trends in Networking Technologies and Uses

<br>
<br>

---

<br>
<br>
