
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

- __`Network Programming And The Socket API`__ -- The interface an application uses to specify communication is known as an Application Program Interface (API). The socket API is a de facto standard for Internet communication

- __`Sockets, Descriptors, And Network I/O`__ -- When an application creates a socket, the operating system returns a
small integer descriptor that the application uses to reference the
socket.

- __`Parameters And The Socket API`__ -- Socket programming differs from conventional I/O because an application must
specify many details, such as the address of a remote computer, the protocol port
number, and whether the application will act as a client or as a server To avoid having a single socket function with many parameters,
designers of the socket API chose to define many functions. In essence, an application
creates a socket, and then invokes functions to specify details. The advantage of the
socket approach is that most functions have three or fewer parameters

  |Name|Used By|Meaning|
  |--|--|--|
  |accept| server|Accept an incoming connection|
  |bind| server| Specify IP address and protocol port|
  |close| either| Terminate communication|
  |connect| client| Connect to a remote application|
  |getpeername |server| Obtain client’s IP address |
  |getsockopt| server| Obtain current options for a socket|
  |listen| server| Prepare socket for use by a server|
  |recv |either| Receive incoming data or message|
  |recvmsg| either| Receive data (message paradigm)|
  |recvfrom| either| Receive a message and sender’s addr.|
  |send (write)| either| Send outgoing data or message|
  |sendmsg |either| Send an outgoing message|
  |sendto| either| Send a message (variant of sendmsg)|
  |setsockopt| either| Change socket options|
  |shutdown| either| Terminate a connection|
  |socket |either| Create a socket for use by above|

- __`Socket Calls In A Client And Server`__ --
  
  Client Side:
  ```
  socket -> connect -> send -> recieve -> close
  ```
  Server Side:
  ```
  socket -> bind -> listen -> accept --> recv --> send --> close
  ```

- __`Socket Calls In A Client And Server`__ --

  - The socket function creates a socket and returns an integer descriptor:
    ```
    descriptor = socket(protofamily, type, protocol)
    ```
    Argument protofamily specifies the protocol family to be used with the socket. The
  identifier PF_INET specifies the TCP/IP protocol suite used in the Internet. Argument
  type specifies the type of communication the socket will use: stream transfer is specified
  with the value SOCK_STREAM, and connectionless message transfer is specified with
  the value SOCK_DGRAM

  - Both clients and servers use the send function to transmit data. Typically, a client
sends a request, and a server sends a response.
    ```
    send(socket, data, length, flags)
    ```
    Argument socket is the descriptor of a socket to use, argument data is the address in
memory of the data to send, argument length is an integer that specifies the number of
bytes of data, and argument flags contains bits that request special options

  - A client and a server each use recv to obtain data that has been sent by the other.
The function has the form
    ```
    recv(socket, buffer, length, flags)
    ```
    Argument socket is the descriptor of a socket from which data is to be received. Argument buffer specifies the address in memory in which the incoming message should be
placed, and argument length specifies the size of the buffer. Finally, argument flags allows the caller to control detai

  - The close function tells the operating system to terminate use of a socket†. It has
the form:
    ```
    close(socket)
    ```
    where socket is the descriptor for a socket being closed.

- __`The Connection Function Used Only By A Client`__ -- Clients call connect to establish a connection with a specific server. The form is:
  ```
  connect(socket, saddress, saddresslen)
  ```
  Argument socket is the descriptor of a socket to use for the connection. Argument saddress is a sockaddr structure that specifies the server’s address and protocol port
number‡, and argument saddresslen specifies the length of the server address measured
in bytes

- __`Socket Functions Used Only By A Server`__ --

  - When created, a socket contains no information about the local or remote address
and protocol port number. A server calls bind to supply a protocol port number at
which the server will wait for contact. Bind takes three arguments:
    ```
    bind(socket, localaddr, addrlen)
    ```
    Argument socket is the descriptor of a socket to use. Argument localaddr is a structure
that specifies the local address to be assigned to the socket, and argument addrlen is an
integer that specifies the length of the address.

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


