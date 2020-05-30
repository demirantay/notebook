# Chapter 23: Support Protocols and Technologies

- __`Introduction`__ -- This chapter continues the discussion of internetworking by introducing four key
support technologies: address binding, error reporting, bootstrapping, and address translation. Each technology handles one small problem. When combined with other protocols, each makes a significant contribution to the overall functionality of the Internet

- __`Address Resolution`__ -- IP addresses are abstractions provided by protocol software. Because
physical network hardware does not know how to locate a computer
from its IP address, the next-hop address must be translated to an
equivalent MAC address before a frame can be sent

  Translation from a computer’s IP address to an equivalent hardware address is
known as address resolution, and an IP address is said to be resolved to the correct
MAC address.

   a computer never resolves the address of a computer on a remote network. Address
resolution is always restricted to a single network.

  To sum up: Mapping between a protocol address and a hardware address is
called address resolution. A host or router uses address resolution
when it needs to send a packet to another computer on the same physical network. A computer never attempts to resolve the address of a
computer that attaches to a remote network.

- __`The Address Resolution Protocol (ARP)`__ -- The idea of ARP is straightforward. Suppose computer B needs to resolve the IP
address of computer C. Computer B broadcasts a request that says “I’m looking for the
MAC address of a computer that has IP address C”. The broadcast only travels across
one network. When it receives a copy of the request, computer C sends a directed reply
back to B that says, “I’m the computer with IP address C, and my MAC address is M”.

- __`ARP Message Format`__ -- Rather than restricting ARP to IP and Ethernet, the designers created ARP to be
general. Thus, instead of specifying a fixed message format, the standard describes a
general form for ARP messages, and specifies how the format is adapted for each type
of protocol address and each type of network hardware.

  Although the ARP message format is sufficiently general to allow arbitrary protocol and hardware addresses, ARP is almost always used
to bind an IP address to a 48-bit Ethernet address.

- __`ARP Encapsulation`__ -- When it travels across a physical network, an ARP message is encapsulated in a
hardware frame. As with IP, an ARP message is treated as data being transported —
the underlying network does not parse the ARP message or interpret fields

- __`ARP Caching And Message Processing`__ -- Although ARP is used to bind addresses, sending an ARP request for each datagram is inefficient — three frames traverse the network for each datagram (an ARP
request, ARP response, and the datagram). More important, because most computer
communication involves a sequence of packets, a sender is likely to repeat the exchange
many times.

  To reduce network traffic, ARP software extracts and saves the information from a
response so it can be used for subsequent packets. The software does not keep the information indefinitely. Instead, ARP maintains a small table of bindings in memory.
ARP manages the table as a cache

- __`The Conceptual Address Boundary`__ -- ARP forms a conceptual boundary in the 5 layered protocol stack — layers
above ARP use IP addresses, and layers below ARP use MAC addresses

- __`Internet Control Message Protocol (ICMP)`__ -- Whenever a datagram is received, the checksum is verified to ensure that the header arrived intact. The action taken in response to a checksum error is straightforward: the datagram
must be discarded immediately without further processing. The receiver cannot trust
any fields in the datagram header because the receiver cannot know which bits were altered. In particular, the receiver cannot send an error message back to the computer that
sent the datagram because the receiver cannot trust the source address in the header

  For problems that are less severe than checksum errors, IP includes a companion
protocol, the Internet Control Message Protocol (ICMP), that is used to report errors
back to the original sourc

- __`ICMP Message Format And Encapsulation`__ -- The Internet Control Message Protocol includes both messages about
errors and informational messages. ICMP encapsulates messages in
IP for transmission, and IP uses ICMP to report problems.

- __`Protocol Software, Parameters, And Configuration`__ -- The question arises: how does the protocol software in a host or
router begin operation? For a router, the answer is mundane: a manager must specify
initial values for items such as the IP address for each network connection, the protocol
software to run, and initial values for a forwarding table. The configuration is saved on
disk, and a router loads the values during startup.

  Host configuration is more complex, and usually uses a two-step process known as
bootstrapping†. The first step occurs when a computer boots. The operating system
fills in a basic set of configuration parameters that allow the protocol software to com- municate over a local network. In the second step, the protocol software fills in additional information such as the computer’s IP address, the address mask, and the address
of a local DNS server

- __`Dynamic Host Configuration Protocol (DHCP)`__ -- Various mechanisms have been created to allow a host computer to obtain parameters. An early mechanism known as the Reverse Address Resolution Protocol (RARP)
allowed a computer to obtain an IP address from a server But that static configuration process is not enough in todays modern fast paced networks. 

  DHCP provides a mechanism that allows an arbitrary computer to join a new network and obtain an IP address automatically. The concept has been termed plug-andplay networking. The point can be summarized:
  
  DHCP allows a computer to move to a new network and obtain configuration information without requiring an administrator to make
manual changes to a database.

- __`DHCP Protocol Operation And Optimizations`__ -- Although the protocol is straightforward, DHCP includes several important details
that optimize performance. The three most significant are:
  - Recovery from loss or duplication
  - Caching of a server address
  - Avoidance of synchronized flooding

- __`Network Address Translation (NAT)`__ -- As the Internet grew and addresses became scarce, subnet and classless addressing
(CIDR) were introduced to help conserve addresses†. A third mechanism was invented
that allows multiple computers at a site to share a single, globally valid IP address.
Known as Network Address Translation (NAT), the technology provides transparent
communication in the sense that a host at the site appears to have a normal Internet connection, and a host in the Internet always appears to receive communication from a single computer rather than from one of many computers at the site.

- __`NAT Operation And Private Addresses`__ -- The most basic form of NAT replaces the IP source address in datagrams passing from the site to the Internet, and replaces the IP destination address in datagrams passing from the Internet to the site. Most implementations of NAT use a translation table to store the information
needed to rewrite addresses

<br>
<br>

---

<br>
<br>

# Chapter 24: The Future IP (IPv6)

- __`Introduction`__ -- This chapter concentrates on the future of the Internet Protocol. It begins by assessing the strengths and limitations of the current version of IP, and then considers a
new version of IP that the IETF has developed

- __`The Success Of IP`__ -- The success of the current version of IP is incredible — the protocol
has accommodated changes in hardware technologies, heterogeneous
networks, and extremely large scale.

- __`The Motivation For Change`__ -- If IP works so well, why change? When IP was defined, only a few computer networks existed. The designers decided to use 32 bits for an IP address because doing so
allowed the Internet to include over a million networks. However, the global Internet is
growing exponentially, with the size doubling in less than a year. At the current growth
rate, each of the possible network prefixes will eventually be assigned, and no further
growth will be possible. Thus, the primary motivation for defining a new version of IP
arose from the address space limitation — larger addresses are necessary to accommodate continued growth of the Internet.

- __`The Hourglass Model And Difficulty Of Change`__ -- Because IP is central to all Internet communication, changing IP requires a change to the entire Internet.

- __`A Name And A Version Number`__ -- When a specific protocol was defined, the designers needed to distinguish the protocol from all other proposals. They decided to use an official version number in the
header of the final standardized protocol. The version number that was selected was a
surprise. Because the current IP version number is 4, the networking community expected the next official version to be 5. However, version 5 had been assigned to an
experimental protocol known as ST. Consequently, the new version of IP received 6 as
its official version number, and the protocol became known as IPv6. To distinguish it
from IPv6, the current version of IP became known as IPv4.

- __`IPv6 Features`__ -- IPv6 retains many of the design features that have made IPv4 so successful. Like
IPv4, IPv6 is connectionless — each datagram contains a destination address, and each
datagram is routed independently. Like IPv4, the header in a datagram contains a maximum number of hops the datagram can take before being discarded.

  Despite retaining the basic concepts from the current version, IPv6 changes all the
details. For example, IPv6 uses larger addresses and an entirely new datagram header
format. Furthermore, IPv6 divides header information into a series of fixed-length
headers.

  The new features in IPv6 can be grouped into five broad categories:
  - Address Size. Instead of 32 bits, each IPv6 address contains 128
bits.
  - Header Format. The IPv6 datagram header is completely different
than the IPv4 header
  - Extension Headers. Unlike IPv4, which uses a single header format for all datagrams, IPv6 encodes information into separate
headers. 
  - Support For Real-Time Traffic. IPv6 includes a mechanism that allows a sender and receiver to establish a high-quality path through
the underlying network
  - Extensible Protocol. Unlike IPv4, IPv6 does not specify all possible protocol features.

- __`Fragmentation, Reassembly, And Path MTU`__ -- Although IPv6 fragmentation resembles IPv4 fragmentation, the details differ.
Like IPv4, a prefix of the original datagram is copied into each fragment, and the payload length is modified to be the length of the fragment. Unlike IPv4, however, IPv6
does not include fields for fragmentation information in the base header. Instead, IPv6
places the fragment information in a separate fragment extension header; the presence of
the header identifies the datagram as a fragment.

  In IPv6, fragmentation is performed by the sending host, and not by
routers. If fragmentation is required, the sending host receives an
ICMP error message, and reduces the fragment size until fragments
can be sent to the destination.

- __`The Purpose Of Multiple Headers`__ -- Why does IPv6 use separate extension headers? There are two reasons: `Economy`, `Extensebility`

  Economy is easiest to understand: partitioning the datagram functionality into
separate headers is economical because it saves space.

- __`IPv6 Addressing`__ -- Like IPv4, IPv6 assigns a unique address for each connection between a computer
and a physical network. Thus, if a computer (e.g., a router) connects to three physical
networks, the computer is assigned three IPv6 addresses. Also like IPv4, IPv6 separates
each such address into a prefix that identifies the network and a suffix that identifies a
particular computer on the network.

- __`IPv6 Colon Hexadecimal Notation`__ -- Because an IPv6 address occupies 128 bits, writing such numbers can be unwieldy.
For example, consider a 128-bit number written in the dotted decimal notation that IPv4
uses:
  ```
  105.220.136.100.255.255.255.255.0.0.18.128.140.10.255.255
  ```
  To help reduce the number of characters used to write an address, the designers of IPv6
chose a more compact syntactic form known as colon hexadecimal notation, usually abbreviated colon hex, in which each group of 16 bits is written in hexadecimal with a
colon separating groups. For example, when the above number is written in colon hex,
it becomes:
  ```
  69DC:8864:FFFF:FFFF:0:1280:8C0A:FFFF
  ```

<br>
<br>

---

<br>
<br>

# Chapter 25: UDP: Datagram Transport Service

- __`Introduction`__ -- This chapter considers UDP, one
of the two major transport-layer protocols used in the Internet and the only connectionless transport service. The chapter discusses the UDP packet format and the ways UDP
can be used.

- __`Transport Protocols And End-To-End Communication`__ -- As previous chapters show, the Internet Protocol provides a packet delivery service
that spans the Internet (i.e., a datagram can pass from the sending host, across one or
more physical networks, to the receiving host). Despite its ability to pass traffic across
the Internet, IP lacks an essential feature: IP cannot distinguish among multiple application programs running on a given host. If a user runs an email application and a web
browser at the same time or runs multiple copies of a given application, they must be
able to communicate independently

- __`The User Datagram Protocol`__ -- As we will see, the TCP/IP suite contains two transport protocols, the User Datagram Protocol (UDP) and the Transmission Control Protocol (TCP), that differ
dramatically in the service they offer to applications. UDP is less complex and easiest
to understand. The simplicity and ease of understanding come with a cost — UDP does
not provide the type of service a typical application expects.

  The most important characteristic of UDP, its best-effort semantics, arises because
UDP uses IP for transmission. In fact, UDP is sometimes characterized as a thin protocol layer that provides applications with the ability to send and receive IP datagrams.
We can summarize:

  UDP provides an end-to-end service that allows an application program to send and receive individual messages, each of which travels
in a separate datagram. An application can choose to restrict communication to one other application program or communicate with
multiple applications.

- __`The Connectionless Paradigm`__ -- UDP uses a connectionless communication paradigm, which means that an application using UDP does not need to preestablish communication before sending data, nor
does the application need to inform the network when finished

  UDP is connectionless, which means that an application can send
data at any time and UDP does not transmit any packets other than
the packets that carry user data

- __`Message-Oriented Interface`__ -- UDP offers application programs a message-oriented interface. Each time an application requests that UDP send a block of data, UDP places the data in a single message for transmission. UDP does not divide a message into multiple packets, and does
not combine messages for delivery — each message that an application sends is transported across the Internet and delivered to the receiver.

  Although a programmer’s intuition suggests that using larger messages will increase efficiency, if a UDP message is larger than the
network MTU, IP will fragment the resulting datagram, which reduces
efficiency. Because UDP is designed to not fragment and send it in blocks if it is possible. As a consequence, many programmers who use UDP choose a message size that
produces datagrams that fit in a standard MTU.

- __`UDP Communication Semantics`__ -- UDP’s best-effort delivery semantics have important consequences for applications. An
application must either be immune to the problems or the programmer must take additional steps to detect and correct problems. As an example of an application that can
tolerate packet errors, consider an audio transmission. If the sender places a small
amount of audio in each message, the loss of a single packet produces a small gap in
the playback, which will be heard as a pop or click. Although it is not desirable, the
noise is merely annoying. At the opposite extreme, consider an on-line shopping application. Such applications are not written to use UDP because packet errors can have serious consequences (e.g., duplication of a message that carries a catalog order can
result in two orders, with double charges being made to the buyer’s credit card). So every packet delivery error is not as same as he other. 

- __`Modes Of Interaction And Broadcast Delivery`__ -- UDP allows four styles of interaction:
  - 1-to-1
  - 1-to-many
  - Many-to-1
  - Many-to-many

- __`Endpoint Identification With Protocol Port Numbers`__ -- Exactly how should UDP identify an application program as an endpoint? It might
seem that UDP could use the same mechanism that the operating system uses. Unfortunately, because UDP must span heterogeneous computers, no common mechanism exists

<br>
<br>

---

<br>
<br>

# Chapter 26: TCP: Reliable Transport Service

- __`Introduction`__ -- This chapter considers transport
protocols in general, and examines TCP, the major transport protocol used in the Internet. The chapter explains how the TCP protocol provides reliable delivery.

  TCP achieves a seemingly impossible task: it uses the unreliable datagram service
offered by IP when sending across the Internet, but provides a reliable data delivery service to application programs. TCP must compensate for loss, delay, duplication, and
out-of-order delivery, and it must do so without overloading the underlying networks
and routers

- __`The Transmission Control Protocol`__ -- In the Internet, the Transmission Control Protocol (TCP) is a
transport-layer protocol that provides reliability. In the TCP/IP suite, the Transmission Control Protocol (TCP) provides reliable
transport service. TCP is remarkable because it solves a difficult problem well —
although other protocols have been created, no general-purpose transport protocol has
proved to work better. Consequently, most Internet applications are built to use TCP.

- __`The Service TCP Provides To Applications`__ --  TCP provides a reliable, connection-oriented, full-duplex stream
transport service that allows two application programs to form a connection, send data in either direction, and then terminate the connection. Each TCP connection is started reliably and terminated gracefully.

- __`End-To-End Service And Virtual Connections`__ -- Like UDP, TCP is classified as an end-to-end protocol because it provides communication between an application on one computer to an application on another computer. It is connection oriented because applications must request that TCP form a connection before they can transfer data, and must close the connection when transfer is
complete

  The connections provided by TCP are called virtual connections because they are
achieved in software. I

- __`Techniques That Transport Protocols Use`__ -- In particular, transport protocols use a variety of tools to handle some of the most complicated communication
problems. 

  __Sequencing To Handle Duplicates And Out-Of-Order Delivery__ -- To handle duplicate packets and out-of-order deliveries, transport protocols use
sequencing. The sending side attaches a sequence number to each packet. Sequencing also solves the problem of duplication — a receiver checks for duplicates when it examines the sequence number of an arriving packet.
  
  __Retransmission To Handle Lost Packets__ -- To handle packet loss, transport protocols use positive acknowledgement with retransmission. Whenever a frame arrives intact, the receiving protocol software sends a
small acknowledgement (ACK) message that reports successful reception The action of sending a second copy is known as retransmitting,
and the copy is commonly called a retransmission
  
  __Techniques To Avoid Replay__ -- Extraordinarily long delays can lead to replay errors in which a delayed packet affects later communication. To prevent replay, protocols mark each session with a unique ID (e.g., the time the
session was established), and require the unique ID to be present in each packet. The
protocol software discards any arriving packet that contains an incorrect ID. To avoid
replay, an ID must not be reused until a reasonable time has passed (e.g., hours).
  
  __Flow Control To Prevent Data Overrun__ -- Several techniques are available to prevent a fast computer from sending so much
data that it overruns a slow receiver. We use the term flow control to refer to techniques that handle the problem. The simplest form of flow control is a stop-and-go system in which a sender waits after transmitting each packet When the receiver is ready
for another packet, the receiver sends a control message, usually a form of acknowledgement.

- __`Techniques To Avoid Congestion`__ -- Modern network hardware works well; most delay and loss results
from congestion, not hardware failure. Arrange for intermediate systems (i.e., routers) to inform a sender
when congestion occur Use increased delay or packet loss as an estimate of congestion

- __`The Art Of Protocol Design`__ -- Although the techniques needed to solve specific problems are well-known, protocol design is nontrivial for two reasons. First, to make communication efficient, details
must be chosen carefully — small design errors can result in incorrect operation, unnecessary packets, or delays

  Computer system reboot poses another serious challenge to transport protocol
design. Imagine a situation where two application programs establish a connection, begin sending data, and then the computer receiving data reboots. Although protocol
software on the rebooted computer has no knowledge of a connection, protocol software
on the sending computer considers the connection valid. If a protocol is not designed
carefully, a duplicate packet can cause a computer to incorrectly create a connection and
begin receiving data in midstream

- __`Techniques Used In TCP To Handle Packet Loss`__ -- The delay required for data to reach a destination and an acknowledgement to return depends on traffic in the Internet as well as the
distance to the destination. Because TCP allows multiple application
programs to communicate with multiple destinations concurrently and
traffic conditions affect delay, TCP must handle a variety of delays
that can change rapidly.

- __`Adaptive Retransmission`__ -- Before TCP was invented, transport protocols used a fixed value for retransmission
delay — the protocol designer or network manager chose a value that was large enough
for the expected delay. Designers working on TCP realized that a fixed timeout would
not operate well for the Internet. Thus, they chose to make TCP’s retransmission adaptive. That is, TCP monitors current delay on each connection, and adapts (i.e., changes)
the retransmission timer to accommodate changing conditions

- __`Buffers, Flow Control, And Windows`__ -- When a connection is established, each end of the connection allocates a buffer to hold
incoming data and sends the size of the buffer to the other end. As data arrives, the receiving TCP sends acknowledgements, which specify the remaining buffer size. TCP
uses the term window to refer to the amount of buffer space available at any time; a notification that specifies the size of the window is known as a window advertisement. A
receiver sends a window advertisement with each acknowledgement.

- __`TCP’s Three-Way Handshake`__ -- To guarantee that connections are established or terminated reliably, TCP uses a
3-way handshake in which three messages are exchanged. During the 3-way handshake
to start a connection, each side sends a control message that specifies an initial buffer
size (for flow control) and a sequence number. Scientists have proved that TCP’s 3-
way exchange is necessary and sufficient to ensure unambiguous agreement despite
packet loss, duplication, delay, and replay events Furthermore, the handshake insures
that TCP will not open or close a connection until both ends have agreed.

- __`TCP Congestion Control`__ -- Conceptually, a transport protocol should reduce the rate of transmission when congestion occurs. Because it uses a variable-size window,
TCP can achieve a reduction in data rate by temporarily reducing the
window size. In the extreme case where loss occurs, TCP temporarily
reduces the window to one-half of its current value.

- __`TCP Segment Format`__ -- TCP uses a single format for all messages, including messages that carry data,
those that carry acknowledgements, and messages that are part of the 3-way handshake
used to create or terminate a connection (SYN and FIN). TCP uses the term segment to
refer to a message. 

<br>
<br>

---

<br>
<br>

