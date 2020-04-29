
# Chapter 3: Internet Applications and Network Programming

- __`Introduction`__ -- The Internet offers users a rich diversity of services that include web browsing,
email, text messaging, and video teleconferences. Surprisingly, none of the services is
part of the underlying communication infrastructure. Instead, the Internet provides a
general purpose communication mechanism on which all services are built, and individual services are supplied by application programs that run on computers attached to the
Internet. In fact, it is possible to devise entirely new services without changing the Internet.

  This chapter covers two key concepts that explain Internet applications. First, the
chapter describes the conceptual paradigm that applications follow when they communicate over the Internet. Second, the chapter presents the details of the socket Application
Programming Interface (socket API) that Internet applications use.

- __`Two Basic Internet Communication Paradigms`__ -- The Internet supports two basic communication paradigms: a `stream paradigm` and a `message paradigm`

  _Stream Transport In The Internet_ -- The term stream denotes a paradigm in which a sequence of bytes flows from one
application program to another For example, a
browser uses the stream service to communicate with a web server: the browser sends a
request and the web server responds by sending the page. The stream mechanism transfers a sequence of bytes without attaching meaning to
the bytes and without inserting boundaries. Although it delivers all bytes in sequence, the stream paradigm does
not guarantee that the chunks of bytes passed to a receiving application correspond to the chunks of bytes transferred by the sending application.
  
  _Message Transport In The Internet_ -- s. Each message delivered to a receiver
corresponds to a message that was transmitted by a sender; the network never delivers
part of a message, nor does it join multiple messages together. Thus, if a sender places
exactly n bytes in an outgoing message, the receiver will find exactly n bytes in the incoming message. There wont be any packet loss. IF it is lost it is being sent again until it reaches not like TCP.

- __`Connection-oriented Communication`__ -- The Internet stream service is connection-oriented, which means before they can communicate, two applications
must request that a connection be created Finally, when they finish communicating, the applications request that the connection be terminated.

- __`The Client-Server Model Of Interaction`__ -- how can a pair of applications
that run on two independent computers coordinate to guarantee that they request a connection at the same time? The answer lies in a form of interaction known as the clientserver model. One application, known as a server, starts first and awaits contact. The
other application, known as a client, start second and initiates the connection.

- __`Server Programs And Server-Class Computers`__ -- Confusion sometimes arises over the term server. Formally, the term refers to a program that waits passively for communication, and not to the computer on which it
executes. However, when a computer is dedicated to running one or more server programs, the computer itself is sometimes called a server. Hardware vendors contribute to
the confusion because they classify computers that have fast CPUs, large memories, and
powerful operating systems as server machines

- __`Requests, Responses, And Direction Of Data Flow`__ --  Information can flow in either or both directions between a client and
server. Although many services arrange for the client to send one or
more requests and the server to return responses, other interactions
are possible.

- __`Multiple Clients And Multiple Servers`__ -- A client or server consists of an application program, and a computer can run multiple applications at the same time. As a consequence, a computer can run:
  - A single client
  - A single server
  - Multiple copies of a client that contact a given server
  - Multiple clients that each contact a particular server
  - Multiple servers, each for a particular service

  A single, powerful computer can offer multiple services at the same
time; a separate server program is needed for each service.

- __`Server Identification And Demultiplexing`__ -- How does a client identify a server? The Internet protocols divide identification
into two pieces:
  - An identifier for the computer on which a server runs
  - An identifier for a particular service on the computer
  
  _Identifying A Computer_. Each computer in the Internet is assigned a unique 32-bit
identifier known as an Internet Protocol address (IP address)†. When it contacts a
server, a client must specify the server’s IP address. To make server identification easy
for humans, each computer is also assigned a name, and the Domain Name System
described in Chapter 4 is used to translate a name into an address. Thus, a user specifies a name such as www.cisco.com rather than an integer address.

  _Identifying A Service_. Each service available in the Internet is assigned a unique
16-bit identifier known as a protocol port number (often abbreviated port number). For
example, email is assigned port number 25, and the web is assigned port number 80.
When a server begins execution, it registers with its local system by specifying the port
number for the service it offers. When a client contacts a remote server to request service, the request contains a port number. Thus, when a request arrives at a server,
software on the server uses the port number in the req

- __`Concurrent Servers`__ -- Although
a serial approach works in a few trivial cases, most servers are concurrent. That is, a
server uses more than one thread of control†, to handle multiple clients at the same
time. But it makes no sense to use a sequenced approach for a high traffic website. 

  The details of concurrent execution depend on the operating system being used, but
the idea is straightforward: concurrent server code is divided into two pieces, a main
program (thread) and a handler. The main thread merely accepts contact from a client,
and creates a thread of control for the client. Each thread of control interacts with a single client, and runs the handler code. After handling one client, the thread terminates.
Meanwhile, the main thread keeps the server alive — after creating a thread to handle a
request, the main thread waits for another request to arrive

- __`Circular Dependencies Among Servers`__ -- Technically, any program that contacts another is acting as a client, and any program that accepts contact from another is acting as a server. In practice, the distinction
blurs because a server for one service can act as a client for another. For example, before it can fill in a web page, a web server may need to become a client of a database

  Of course, programmers must be careful to avoid circular dependencies among
servers. Which means that if x1 server is a client to x2 server. the x2 cannot be a server to x1 again. It can but it wil cause a LOT OF headache.

- __`Peer-To-Peer Interactions`__ -- If a single server provides a given service, the network connection between the
server and the Internet can become a bottleneck.

  The question arises, “can Internet services be provided without creating a central
bottleneck?” One way to avoid a bottleneck forms the basis of file sharing applications.
Known as a peer-to-peer (p2p) architecture, the scheme avoids placing data on a central
server. Conceptually, data is distributed equally among a set of N servers, and each
client request is sent to the appropriate server.

- __`Network Programming And The Socket API`__ -- 

- __`Sockets, Descriptors, And Network I/O`__ --

- __`Parameters And The Socket API`__ --

- __`Socket Calls In A Client And Server`__ --

- __`Socket Calls In A Client And Server`__ --

- __`The Connection Function Used Only By A Client`__ --

- __`Socket Functions Used Only By A Server`__ --

- __`Socket Functions Used With The Message Paradigm`__ --

- __`Other Socket Functions`__ --

- __`Sockets, Threads, And Inheritance`__ --

<br>
<br>

---

<br>
<br>

# Chapter 4: Traditional Internet Applications

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

