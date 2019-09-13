# Network Programming with Python

- Well, the Internet transfers PettaBytes of data every minute across the globe. Do you have any idea how that happens? You click on a link and you download a multi MegaByte(MB) file within seconds, watch your favourite videos, do live video calls and what not. This is not magic! There are people behind the scene, who are working very hard to make all this happen, both efficiently and safely, by making sure that the data reaching you is unsniffed and legitimate.

### What is networking

- Computer Networking aims to study and analyze the communication process among various computing devices or computer systems that are linked, or networked together to exchange information and share resources. So, in order to perform networking you must have a network. It's like to make a telephone call you must have a telephone line. Isn't it obvious! So, there are basically four types of computer networks:

### LAN (Local Area Network)

- Used to serve a small number of people located in a small geographical space like colleges, small organisations etc. It's more of a peer to peer conection.

### WAN (Wide Area Network)

- This network type covers more area than LAN as they allow connectivity across large geographical Area. It basically connects many LANs together to reach beyond just peer to peer sharing. The Internet is an example of WAN.

### MAN (Metropolitan Area Network)

- MAN is a computer network that interconnects users with computer resources in a geographic area or region larger than that covered by a LAN(Local Area Network) but smaller than the area covered by a WAN(Wide Area Network). The term is derived from its usage for the interconnection of networks in a city into a single larger network.

### PAN (Personal Area Network)

- A personal area network (PAN) is a computer network used for data transmission amongst devices such as computers, telephones, tablets and personal digital assistants. PANs can be used for communication amongst the personal devices themselves (interpersonal communication), or for connecting to a higher level network and the Internet (an uplink) where one master device takes up the role as internet router.


<br>
<br>

---

<br>
<br>

# Network Terminologies 

- Let's quickly go through the frequently used terminologies along with their meanings which are very important for network programming

### Internet Protocol (IP)

- These are the set of procedures or rules which govern the flow of data, format of data over the internet.

  Mainly, we will be dealing with two major protocols over the internet:
    - User Datagram Protocol(UDP)
    - Transmission Control Protocol(TCP)

### User Datagram Protocol (UDP)

- UDP is a connectionless protocol. In this protocol data is sent over the internet as `datagrams`.

  Let's have a look at some properties of the UDP protocols.
    - `Unreliable:` When a UDP message is sent, there is no way to know if it will reach its destination or not; it could get lost along the way. In UDP, there is no concept of acknowledgment, retransmission, or timeout (as in TCP).
    - `Not ordered:` If two messages are sent to the same recipient, the order in which they arrive cannot be predicted.
    - `Lightweight:` There is no ordering of messages, no tracking connections, etc. Hence UDP messages are used when the rate of data transmission required is more and relibility is not important.
    - `Datagrams:` Packets are sent individually and are checked for integrity only if they arrive.

### Transmission Control Protocol (TCP)

- In TCP there is a concept of `handshake`. So, What is a handshake? It's a way to ensure that the connection has been established between interested hosts and therefore data transfer can be initiated.

  In simple terms, when you make a phone call to someone you first say `"Hello"`, and in return the person replies with a `"Hello"`. This ensures that the connection has been established between both the parties and data(voice in this case)transfer can begin now. This is, for sure, the simplest example of handshake.

- On the basis of the above example we can device the properties of TCP:
  - `Reliable:` TCP manages message acknowledgment, retransmission and timeout. Multiple attempts to deliver the message are made. If it gets lost along the way, the server will re-request the lost part.
  - `Ordered:` The messages are delivered in a particular order in which they were meant to be.
  - `Heavyweight:` TCP requires three packets to set up a socket connection, before any user data can be sent. The three packets are: `SYN`, `SYN+ACK` and `ACK`.

### IP Adresses and Ports 

- `IP addressess` are the addressess which helps to uniquely identify a device over the internet and `Port` is an endpoint for the communication in an operating system. Confused! Let's try to make it simple to understand.
  
  Lets imagine a example where `A` sends a letter to `B`. `A` needs to know the postal address of `B` in order to successfully deliver the package. This postal address is unique and hence the mail man delivers the letter successfully. `IP address is like the postal address`. Now, suppose that `B` has a bunglow of 5 rooms and in each room a relative of `B` resides. One of the relative of `B` orders a pizza. Now when the pizza boy arrives to the given address, how will he come to know who ordered pizza amongst the 5 relatives? So in order to uniquely identify the person who ordered the pizza, the delivery boy needs room number. `This room number is Port number` in computer networks
  
- A system might be running thousands of services but to uniquely identify a service on a system the application requires a port number. There are total of `0 – 65535` ports on a system.

  Some common ports are:
    - `22`: Secure Shell(SSH)
    - `23`: Telnet Remote Login Service
    - `25`: Simple Mail Transfer Protocol(SMTP)
    - `53`: Domain Name System(DNS) Service
    - `80`: Hyper Text Transfer Protocol(HTTP) used in the World Wide Web

- Now, coming up is some more detail about the IP addressess. IP address is of two types:
  - `Private IP address`: Ranges from (192.168.0.0 – 192.168.255.255), (172.16.0.0 – 172.31.255.255) or (10.0.0.0 - 10.255.255.255)
  - `Public IP address`: A public IP address is an IP address that your home or business router receives from your ISP(Internet Service Provider).
  

### Firewall 

- The firewall monitors the incoming and outgoing network traffic based on predefined security rules like scanning digital signature, checking for valid file formats etc. It establishes a barrier between a trusted, secure internal network and another outside network, such as the Internet, that is assumed to be not secure or trusted.


<br>
<br>

---

<br>
<br>

#  Basics of Sockets 

- To understand what sockets are, let's start with the Internet Connection. The Internet Connection basically connects two points across the internet for data sharing and other stuff. One process from computer `C1` can communicate to a process from computer `C2`, over an internet connection. It has following properties:
  - `Reliable`: It means until the cables connecting two computers are safe, data will be transfered safely.
  - `Point-to-Point`: Connection is established between 2 points.
  - `Full-Duplex`: It means transfer of information can occur in both ways i.e. from client to server as well as server to client simultaneously(at the same time).
  
  `Sockets` are the endpoints of a bidirectional, point-to-point communication channel. Given an internet connection, say between client(a browser) and the server(say studytonight.com), we will have two sockets. A `Client Socket` and a `Server Socket`.
  
  Socket acts on two parts: **P Address** + **Port Number**
  
- Vaguely speaking, when you clicked on the link that brought you to Studytonight website, your browser did something like the following:
  ```python
  #a socket object is created for communication
  clientsocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
  
  # now connect to the web server on port 80
  # - the normal http port
  clientsocket.connect(("www.studytonight.com", 80))
  ```
  This happened on the client side. When the client tries to connect with the server, a random port is assigned by the operating system for the connection on the client machine. This random port is called `Ephermal Port`. The client socket is short lived, i.e as soon as the data exchange ends it closes. Now what happens on server is a bit different from client. So,let's see:
  ```python
  serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

  #bind the socket to a public host and a well-known port
  serversocket.bind((socket.gethostname(), 80))
  
  become a server socket and listen for connections
  serversocket.listen(5)
  ```
  - Unlike client sockets, server sockets are not short lived. For example: you might need youtube.com for a single request but youtube.com has to be up 24*7 for any request which it might receive from users across the globe.
  - Unlike client socket which uses Ephermal Port for connection, server socket requires a standard or well defined port for connection like: Port 80 for Normal HTTP Connection, Port 23 for Telnet etc.
  
  For now, just focus on `Connect` and `Bind` methods on the above two code snippets. `Connect` is used by the client socket to start a connection with the server. This request is fulfilled by `bind` method of the server socket. If you are having problem with the code, don't worry. Every bit of it will be explained separately in the other sections.

<br>
<br>

---

<br>
<br>

# Socket Methods

- There are two type of sockets: `SOCK_STREAM` and `SOCK_DGRAM.` Below we have a comparison of both types of sockets

  | SOCK_STREAM | SOCK_DGRAM | 
  |--|--|
  | For TCP protocols | For UDP protocols |
  | Reliable delivery | Unrelible delivery |
  | Order Guranteed	| No order guaranteed |
  | Connection-oriented | No notion of connection(UDP) | 
  | Bidirectional	| Not Bidirectional | 
  
### Socket Module in Python

- To create a socket, we must use `socket.socket()` function available in the Python socket module, which has the general syntax as follows:
  ```python
  import socket
  
  S = socket.socket(socket_family, socket_type, protocol=0)
  ```
  - `socket_family:` This is either `AF_UNIX `or `AF_INET`. We are only going to talk about INET sockets in this tutorial, as they account for at least 99% of the sockets in use.
  - `socket_type:` This is either SOCK_STREAM or SOCK_DGRAM.
  - `protocol:` This is usually left out, defaulting to 0.

### Client Socket Methods 

- Following are some client socket methods:
  - `connect()` -- To connect to a remote socket at an address. An address format(host, port) pair is used for **AF_INET** address family.

### Server Socket Methods

- Following are some server socket methods:
  - `bind()` -- This method binds the socket to an address. The format of address depends on socket family mentioned above(AF_INET).
  - `listen(backlog)` -- This method listens for the connection made to the socket. The backlog is the maximum number of queued connections that must be listened before rejecting the connection.
  - `accept()` -- This method is used to accept a connection. The socket must be bound to an address and listening for connections. The return value is a `pair(conn, address)` where **conn** is a new socket object which can be used to send and receive data on that connection, and address is the address bound to the socket on the other end of the connection.

> For detailed view of methods refer documentation: https://docs.python.org/2/library/socket.html


### Few General Socket Methods

- | TCP Socket Methods | 	UDP Socket Methods |
  | -- | -- |
  | `s.recv()` -> Receives TCP messages | `s.recvfrom()` -> Receives UDP messages |
  | `s.send()` -> Transmits TCP messages | `s.sendto()` -> Transmits UDP messages |

### Some Basic Socket Methods

- Some basic socket methods are listed below:
  - `close()` -- This method is used to close the socket connection.
  - `gethostname()` This method returns a string containing the hostname of the machine where the python interpreter is currently executing. For example: localhost.
  - `gethostbyname()` If you want to know the current machine's IP address, you may use `gethostbyname(gethostname())`.
  

<br>
<br>

---

<br>
<br>

# Working with TCP Sockets


### Simple Server Program

### Simple Client Program


<br>
<br>

---

<br>
<br>

# Working with UDP Sockets
