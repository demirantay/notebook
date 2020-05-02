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

- __`Web Document Transfer With HTTP`__ -- The HyperText Transfer Protocol (HTTP) is the primary transfer protocol that a
browser uses to interact with a web server
  - `GET` -- Requests a document; server responds by sending status
information followed by a copy of the document
  - `HEAD` -- Requests status information; server responds by sending
status information, but does not send a copy of the document
  - `POST` -- Sends data to a server; the server appends the data to a
specified item (e.g., a message is appended to a list)
  - `PUT` -- Sends data to a server; the server uses the data to completely
replace the specified item (i.e., overwrites the previous data)

  The most common form of interaction begins when a browser requests a page from
the server. The browser sends a GET request over the connection, and the server
responds by sending a header, a blank line, and the requested document.

  When using HTTP, a browser sends version information which allows
a server to choose the highest version of the protocol that they both
understand.

  The first line of a response header contains a status code that tells the browser
whether the server handled the request. Status code represent the status of the state such as 200s (OK) 300s (Redirect) 400s (Client Error) 500s (Server Error)

- __`Caching In Browsers`__ -- Caching provides an important optimization for web access because users tend to
visit the same web sites repeatedly. Much of the content at a given site consists of
large images that use the Graphics Image Format (GIF) or Joint Picture Encoding
Group (JPEG) standards. Such images often contain backgrounds or banners that do
not change frequently. The key idea is:

  A browser can reduce download times significantly by saving a copy
of each image in a cache on the user’s disk and using the cached
copy.

- __`Browser Architecture`__ -- Because it provides general services and supports a graphical interface, a browser
is complex. Of course, a browser must understand HTTP, but a browser also provides
support for other protocols. In particular, because a URL can specify a protocol, a
browser must contain client code for each of the protocols used. For each service, the
browser must know how to interact with a server and how to interpret responses. For
example, a browser must know how to access the FTP service discussed in the next section.

- __`File Transfer Protocol (FTP)`__ -- A file is the fundamental storage abstraction. Because a file can hold an arbitrary
object (e.g., a document, spreadsheet, computer program, graphic image, or data), a facility that sends a copy of a file from one computer to another provides a powerful
mechanism for the exchange of data. We use the term file transfer for such a service. The most widely-deployed file transfer service in the Internet uses the File
Transfer Protocol (FTP). 

- __`FTP Communication Paradigm`__ -- One of the most interesting aspects of FTP arises from the way a client and server
interact. Overall, the approach seems straightforward: a client establishes a connection
to an FTP server and sends a series of requests to which the server responds. Unlike
HTTP, an FTP server does not send responses over the same connection on which the
client sends requests. Instead, the original connection the client creates, called a control
connection, is reserved for commands Each time the server needs to download or
upload a file, the server opens a new connection. To distinguish them from the control
connection, the connections used to transfer files are called data connections

- __`Electronic Mail`__ -- Although services such as instant messaging have become popular, email remains
one of the most widely used Internet applications s, even early email software was divided into two conceptually separate pieces:
  - An email interface application
  - A mail transfer program
  
  A user invokes the email interface application directly. The interface provides
mechanisms that allow a user to compose and edit outgoing messages as well as read
and process incoming email. The email interface application does not act as a client or
server, and does not transfer messages to other users. Instead, the interface application
reads messages from the user’s mailbox (i.e., a file on the user’s computer) and deposits
outgoing messages in an outgoing mail queue (typically a folder on the user’s disk).
Separate programs known as a mail transfer program and a mail server handle transfer.
The mail transfer program acts as a client to send a message to the mail server on the
destination computer; the mail server accepts incoming messages and deposits each in
the appropriate user’s mailbox

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
