# Chapter 19: Networking Technologies Past and Present

- __`Introduction`__ -- Over the years, many networking technologies have been defined for each basic
type. Some that were once of major importance have faded into obscurity, and others
continue to fill a niche. This brief chapter highlights some of the major technologies,
and describes the significant features and characteristics of each

- __`Connection And Access Technologies`__ -- Early chapters describe the most significant access and connection technologies
(DSL and cable modems). A variety of additional technologies have been defined, including a technology that delivers data over power lines and wireless access mechanisms

  __Synchronous Optical Network or Digital Hierarchy (SONET/SDH)__ -- SONET and the associated TDM hierarchy was originally designed as a system to
carry digital voice telephone calls. The technology has become the standard for the digital circuits used throughout the Internet  SONET permits a physical ring to be constructed with the purpose of providing redundancy
  
  __Optical Carrier (OC)__ -- The OC standards specify the signaling used on an optical fiber SONET ring. OC
standards are associated with higher data rates than the T-series standards provided by
SDH. A private company might choose to lease an OC circuit to connect two of the
company sites 
  
  __Digital Subscriber Line (DSL) And Cable Modems__ -- These two technologies have emerged as the principal means of providing broadband Internet access to private residences and small businesses. DSL makes use of existing telephone land lines, and cable modem technology makes use of existing cable
television infrastructure. DSL offers data rates of 1 to 6 Mbps, depending on the distance between a central office and a subscriber; cable modems offer up to 52 Mbps, but
the bandwidth is shared among a set of users

  __WiMAX And Wi-Fi__ --  Wi-Fi comprises a set of wireless technologies that have become widely used to
provide Internet access in homes, cafes, airports, hotels, and other locations. Successive
generations of Wi-Fi technologies have increased overall data rates. WiMAX is an emerging wireless technology that can be used to form a MAN
 
  __Very Small Aperture Satellite (VSAT)__ -- VSAT technologies, which have a dish size of less then 3 meters, have made it
possible to use satellite to provide Internet access to individuals or small businesses.
  
  __Power Line Communication (PLC)__ -- PLC uses high frequencies to send data along power lines. The idea is to use existing infrastructure to deliver Internet access

- __`LAN Technologies`__ -- After LANs were invented, many groups proposed designs or built experimental
prototypes.

  __IBM Token Ring__ -- Some of the early work on LANs explored token passing as an access control
mechanism. IBM chose to create a token passing LAN technology that was known as
IBM Token Ring
  
  __Fiber And Copper Distributed Data Interconnect (FDDI And CDDI)__ -- By the late 1980s, it became apparent that the two chief LAN technologies, Ethernet at 10 Mbps and IBM’s Token Ring at 16 Mbps, had insufficient data rates to meet
growing demand. The FDDI standard was created to increase LAN data rates to 100
Mbps.
  
  __Ethernet__ --  In one sense, Ethernet has won the race and completely dominates the LAN market. Indeed, there are more Ethernets deployed than any other type of LAN. In another
sense, Ethernet has disappeared completely, and has been replaced by new technology
that is still called Ethernet. One can observe, for example, that there is almost no similarity between the heavy coaxial cable and RF signaling used in early Ethernet and the
wiring and signaling used with gigabit Ethernet

- __`WAN Technologies`__ -- Many technologies have been created for experimental and production use in Wide
Area Networks. 

  __ARPANET__ -- Packet switched WANs are less than fifty years old. In the late 1960s, the Advanced Research Projects Agency (ARPA) funded research on networking for the U.S.
Department of Defense. A major ARPA research project developed a Wide Area Network to determine whether packet switching technology would be valuable for the military. Known as the ARPANET, the network was one of the first packet switched
WANs.
  
  __X.25__ -- The organization that sets international telephone standards, the International
Telecommunications Union (ITU), developed an early standard for WAN technology
that became popular among public carriers. At the time, the ITU was known as the
Consultative Committee for International Telephone and Telegraph (CCITT), and the
standard is still known as the CCITT X.25 standard. X.25 networks enjoyed more popularity in Europe than in the United States.
  
  __Frame Relay__ Long-distance carriers have created a series of wide area network technologies that
transport data. One such service, Frame Relay, was designed to accept and deliver
blocks of data, where each block can contain up to 8K octets of data. Part of the
motivation for the large data size (and for the name) arises because the inventors envisioned using Frame Relay service to bridge LAN segments. An organization with offices in two cities could obtain a Frame Relay service for each office, and then use the
Frame Relay to forward packets from a LAN segment at one site to a LAN segment at
the other.
  
  __Switched Multi-megabit Data Service (SMDS)__ -- Like Frame Relay, SMDS is a high-speed wide area data service offered by longdistance carriers. It was based on IEEE standard 802.6DQDB, and is considered a precursor to ATM. Instead of voice traffic, SMDS is designed to carry data
  
  __Asynchronous Transfer Mode (ATM)__ -- The telecommunications industry designed ATM as an alternative to the Internet,
and announced the effort with great fanfare. When the technology emerged in the
1990s, ATM had ambitious goals — designers claimed that it would replace all WAN
and LAN technologies and lead to a completely uniform communication system worldwide.

  When they began to implement ATM, engineers
discovered that the plethora of features meant that the hardware was complex and expensive. Furthermore, the mechanism created to establish label switched paths was so
cumbersome that it was not used. Thus, ATM was not accepted, and virtually disappeared.
  
  __Multi-Protocol Label Switching (MPLS)__ -- Although not a network system, MPLS is a notable result of the ATM effort — engineers adapted label switching for use in Internet routers†. Instead of completely replacing the underlying hardware as ATM attempted to do, MPLS can be implemented
in software as an extra feature. An MPLS router accepts Internet packets, places each
packet in a special wrapper, uses label switching to transport the packet across an
MPLS path, unwraps the packet, and continues normal forwarding. MPLS is used extensively at the center of the Internet
  
  __Integrated Services Digital Network (ISDN)__ -- Telephone companies created ISDN to provide network service at a higher data rate
than could be achieved with a dial-up modem. When it was first proposed, 128 Kbps
seemed fast. By the time it was available, the technology seemed slow for the price. In
most parts of the world, ISDN has been replaced by DSL, cable modems, or 3G cellular
systems

<br>
<br>

---

<br>
<br>

# Chapter 20: Internetworking: Concepts Architecture and Protocols

- __`Introduction`__ -- This chapter begins an examination of another fundamental idea in computer
communication — an internetworking technology that can be used to connect multiple
physical networks into a large, uniform communication system. The chapter discusses
the motivation for internetworking, introduces the hardware components used, describes
the architecture in which the components are connected, and discusses the significance
of the concept.

- __`The Motivation For Internetworking`__ -- No single networking technology is best for all needs. Weather it is WAN, LAN, PAN ... etc. A large organization with diverse networking requirements needs multiple physical
networks.

- __`The Concept Of Universal Service`__ -- The chief problem with multiple networks should be obvious: a computer attached
to a given network can only communicate with other computers attached to the same
network. Users are neither satisfied nor productive when they must use a separate computer
for each network. Consequently, most modern computer communication systems allow
communication between any two computers analogous to the way a telephone system
provides communication between any two telephones. Known as universal service, the
concept is a fundamental part of networking

- __`Universal Service In A Heterogeneous World`__ -- Does universal service mean that everyone needs to adopt a single network technology, or is it possible to have universal service across multiple networks that use multiple technologies? Incompatibilities make it impossible to form a large network merely
by interconnecting the wires among networks. Thus, a frame created for
one network technology cannot be transmitted on a network that uses a different technology

- __`Internetworking`__ -- Despite the incompatibilities among network technologies, researchers have devised a scheme that provides universal service among heterogeneous networks. Called
internetworking, the scheme uses both hardware and software. Additional hardware
systems are used to interconnect a set of physical networks The resulting system of connected physical
networks is known as an internetwork or internet. 

- __`Physical Network Connection With Routers`__ -- The basic hardware component used to connect heterogeneous networks is a
router. Physically, a router is an independent hardware system dedicated to the task of
interconnecting networks. Like a bridge, a router contains a processor and memory as
well as a separate I/O interface for each network to which it connects.

   A router can connect two LANs, a LAN
and a WAN, or two WANs. Furthermore, when a router connects two networks in the
same general category, the networks do not need to use the same technology. For example, a router can connect an Ethernet to a Wi-Fi network

- __`Internet Architecture`__ -- An internet consists of a set of networks interconnected by routers.
The internet scheme allows each organization to choose the number
and type of networks, the number of routers to use to interconnect
them, and the exact interconnection topology.

- __`Achieving Universal Service`__ -- The goal of internetworking is universal service across heterogeneous networks.
To provide universal service among all computers on an internet, routers must agree to
forward information from a source on one network to a specified destination on another.
The task is complex because frame formats and addressing schemes used by the underlying networks can differ. As a result, protocol software is needed on computers and
routers to make universal service possible.

- __`A Virtual Network`__ -- In general, Internet software provides the appearance of a single, seamless communication system to which many computers attach. The system offers universal service: each computer is assigned an address, and any computer can send a packet to any
other computer. Furthermore, Internet protocol software hides the details of physical
network connections, physical addresses, and routing information — neither users nor
application programs are aware of the underlying physical networks or the routers that
connect them. We say that an internet is a virtual network system because the communication
system is an abstraction

- __`Protocols For Internetworking`__ -- Although several protocols have been proposed for use with internets, one suite
stands out as the most widely used. The suite is formally known as the TCP/IP Internet
Protocols; most networking professionals simply refer to the suite as TCP/IP

- __`Review Of TCP/IP Layering`__ -- Recall from Chapter 1 that the Internet protocols use a five-layer reference model
  - layer 5 - Application
  - layer 4 - Transport
  - layer 3 - Internet
  - layer 2 - Network Interface
  - layer 1 - Physical
  
  We have already explored three of the layers. Chapters in part 1 of the text consider applications; chapters in parts 2 and 3 of the text discuss layer 1 and layer 2 protocols. Chapters in this part of the text consider the two remaining layers in detail:
  
  __layer 3__ -- Layer 3 (IP) specifies the format of packets sent across the Internet as well as the
mechanisms used to forward packets from a computer through one or more routers to a
final destination.
  
  __layer 4__ -- Layer 4 (TCP) specifies the messages and procedures that are used to insure reliable transfer

- __`Host Computers, Routers, And Protocol Layers`__ -- We use the term host computer to refer to a computer that connects to the Internet
and runs applications. A host can be as small as a cell phone or as large as a mainframe. TCP/IP protocols make it possible for any pair of hosts to communicate, despite
hardware differences.

  Both hosts and routers need TCP/IP protocol software. However, routers do not
use protocols from all layers. In particular, a router does not need layer 5 protocols for
applications like file transfer because routers do not run conventional applications

<br>
<br>

---

<br>
<br>

# Chapter 21: IP:Internet Adressing

- __`Introduction`__ -- This chapter begins a description of protocol
software that makes the Internet appear to be a single, seamless communication system.
The chapter introduces the addressing scheme used by the Internet Protocol (IPv4), and
discusses the use of address masks for classless and subnet addressing

- __`Addresses For The Virtual Internet`__ -- Recall from Chapter 20 that the goal of internetworking is to provide a seamless
communication system. To achieve the goal, protocol software must hide the details of
physical networks and offer the illusion of a single, large network  The chief difference between the Internet and a physical network is that the Internet is an abstraction imagined by its designers Thus, the designers chose addresses, packet formats, and
delivery techniques independent of the details of the underlying hardware.

  Addressing is a critical component of the Internet abstraction. To give the appearance of a single network, all host computers must use a uniform addressing scheme, and
each address must be unique. Although each computer has a MAC address, such ad- dresses do not suffice because the Internet can include multiple network technologies
and each technology defines its own MAC addresses.

  To guarantee uniform addressing, IP defines an addressing scheme that is independent of the underlying MAC addresses. IP addresses are used as destinations in the Internet analogous to the way MAC addresses are used as destinations on a LAN
  
  To provide uniform addressing in the Internet, IP defines an abstract
addressing scheme that assigns each host a unique protocol address;
applications use IP addresses to communicate.

- __`The IP Addressing Scheme`__ -- An Internet address (IP address) is a unique 32-bit binary number assigned to a host and used for all communication with the host.

- __`The IP Address Hierarchy`__ -- Analogous to the hierarchical addressing using with WANs, each 32-bit IP address
is divided into two parts: a prefix and a suffix. Instead of identifying a packet switch,
an IP prefix identifies the physical network to which the host is attached. An IP suffix
identifies a specific computer on the network. That is, each physical network in the Internet is assigned a unique network number

  The important point is that the IP address scheme guarantees two properties:
  - Each computer is assigned a unique address (i.e., a single address
is never assigned to more than one computer).
  - Although network number assignments must be coordinated globally, suffixes can be assigned locally without global coordination.
  
- __`Original Classes Of IP Addresses`__ -- The original IP addressing scheme divided addresses into classes.
Class D addresses are still used for multicasting, but multicasting
does not work globally

- __`Dotted Decimal Notation`__ -- Although IP addresses are 32-bit numbers, users do not enter or read the values in
binary. Instead, when interacting with a user, software uses a notation that is more convenient for humans to understand. Called dotted decimal notation, the form expresses
each 8-bit section of a 32-bit number as a decimal value and uses periods to separate the
sections
  ```
  10000001 00110100 00000110 00000000  --> 129 . 52 . 6 . 0
  11000000 00000101 00110000 00000011  --> 192 . 5 . 48 . 3
  ```
  
- __`Authority For Addresses`__ -- Each prefix assigned to an individual network in the Internet must be unique.
Therefore a central organization, the Internet Corporation for Assigned Names and
Numbers (ICANN), has been established to handle address assignment and adjudicate
disputes. ICANN does not assign individual prefixes. Instead, ICANN authorizes a set
of registrars to do so. Registrars make blocks of addresses available to ISPs, which
provide addresses to subscribers. Thus, to obtain a prefix, a corporation usually contacts an ISP

- __`Subnet And Classless Addressing`__ --  As the Internet grew, the original classful addressing scheme became a limitation. Two new mechanisms were invented to overcome the limitation:
  - Subnet addressing
  - Classless addressing

- __`Address Masks`__ -- I didn't get this part too much it is not hard i am just fucking tired.

- __`Special IP Addresses`__ -- In addition to assigning an address to each computer, it is convenient to have addresses that can be used to denote networks or sets of computers. IP defines a set of
special address forms that are reserved. That is, special addresses are never assigned to
hosts.

- __`Summary Of Special IP Addresses`__ -- 

  | prefix | suffix | type of address | purpose | 
  | --| --| --| --|
  | all-0s | all-0s |this computer| used during bootstrap|
  |network| all-0s| network| identifies a network|
  |network |all-1s |directed broadcast| broadcast on specified net|
  |all-1s| all-1s| limited broadcast| broadcast on local net|
  |127 / 8| any| loopback testing|
  
  We said that special addresses are reserved and should never be assigned to host
computers. Furthermore, each special address is restricted to certain uses

- __`The Berkeley Broadcast Address Form`__ -- The University of California at Berkeley developed and distributed an early implementation of TCP/IP protocols as part of BSD UNIX†. The BSD implementation contained a nonstandard feature that has affected many subsequent implementations. Instead of using a host suffix of all ones to represent a directed broadcast address, the
Berkeley implementation uses a host suffix that contains all zeroes (i.e., identical to the
network address). The address form is known informally as Berkeley broadcast. Unfortunately, many computer manufacturers derived their early TCP/IP software
from the Berkeley implementation, and a few sites still use Berkeley broadcast.

- __`Routers And The IP Addressing Principle`__ -- In addition to assigning an Internet address to each host, the Internet Protocol
specifies that routers should be assigned IP addresses as well. In fact, each router is assigned two or more IP addresses, one for each network to which the router attaches

- __`Multi-Homed Hosts`__ -- Can a host connect to multiple networks? Yes. A host computer with multiple
network connections is said to be multi-homed. Multi-homing is sometimes used to increase reliability — if one network fails, the host can still reach the Internet through the
second connection

<br>
<br>

---

<br>
<br>

# Chapter 22: Datagram Forwarding

- __`Introduction`__ -- This chapter discusses the fundamental communication service in the Internet. It
describes the format of packets that are sent across the Internet, and discusses the key
concepts of datagram encapsulation, forwarding, and fragmentation and reassembly

- __`Connectionless Service`__ -- The goal of internetworking is to provide a packet communication system that allows a program running on one computer to send data to a program running on another
computer

  One of the fundamental questions that must be considered when designing an internet concerns the services that will be offered. In particular, designers must decide
whether to offer a connection-oriented service, a connectionless service, or both

  TCP/IP designers chose to include protocols for both connectionless and
connection-oriented service. They chose to make the fundamental delivery service connectionless, and to add a reliable connection-oriented service that uses the underlying
connectionless service.

- __`Virtual Packets`__ -- Connectionless service is a straightforward extension of packet switching — the
service allows a sender to transmit individual packets of data across the Internet. Each
packet travels independently, and contains information that identifies the intended recipient

  How does a packet pass across the Internet? In general, the answer is that routers
handle most of the forwarding. A host creates a packet, places the destination address
in the packet header, and then sends the packet to a nearby router. When a router receives a packet, the router uses the destination address to select the next router on the
path to the destination, and then forwards the packet. Eventually, the packet reaches a
router that can deliver the packet to its final destination

  Because it includes incompatible networks, the Internet cannot adopt
a particular hardware packet format. To accommodate heterogeneity,
the Internet Protocol defines a hardware-independent packet format.

- __`The IP Datagram`__ -- TCP/IP protocols use the name IP datagram to refer to an Internet packet.
Surprisingly, an IP datagram has the same general format as a hardware frame: the datagram begins with a header followed by a data (or payload) area

  The size of a datagram is determined by the application that sends
data. Allowing the size of datagrams to vary makes IP adaptable to a
variety of applications.

- __`The IP Datagram Header Format`__ -- What does a datagram header contain? Similar to a frame header, a datagram
header contains information used to forward the datagram. In particular, the header
contains the address of the source (the original sender), the address of the destination
(the ultimate recipient), and a field that specifies the type of data being carried in the
payload area. Each address in the header is an IP address MAC addresses for the
sender and recipient do not appear in the datagram.
Each field in an IP datagram header has a fixed size, which makes header processing efficient. 

- __`Forwarding An IP Datagram`__ -- We said that a datagram traverses the Internet by following a path from its initial
source through routers to the final destination. The Internet uses next-hop forwarding.

  To make the selection of a next hop efficient, an IP router uses a forwarding table.
A forwarding table is initialized when the router boots, and must be updated if the topology changes or hardware fails. Conceptually, the forwarding table contains a set of entries that each specify a destination and the next hop used to reach that destination

  The important point to note is the forwarding table size, which is crucial in the global Internet: Because each destination in a forwarding table corresponds to a network, the number of entries in a forwarding table is proportional to
the number of networks in the Internet, not the number of hosts.

- __`Network Prefix Extraction And Datagram Forwarding`__ -- The process of using a forwarding table to select a next hop for a given datagram
is called forwarding

- __`Longest Prefix Match`__ -- In practice, Internet forwarding tables can
be extremely large, and the forwarding algorithm is complex. For example, analogous
to WAN forwarding described in Chapter 18, Internet forwarding tables can contain a
default entry that provides a path for all destinations that are not explicitly listed. In addition, Internet forwarding allows a manager to specify a host-specific route that directs
traffic destined to a specific host along a different path than traffic for other hosts on the
same network

- __`Destination Address And Next-Hop Address`__ -- What is the relationship between the destination address in a datagram header and
the address of the next hop to which the datagram is forwarded? The DESTINATION
IP ADDRESS field in a datagram contains the address of the ultimate destination; it
does not change as the datagram passes through the Internet

  The destination address in a datagram header always refers to the ultimate destination; at each point, a next hop is computed, but the next
hop address does not appear in the datagram header.

- __`Best-Effort Delivery`__ -- In addition to defining the format of Internet datagrams, the Internet Protocol defines the semantics of communication, and uses the term best-effort to describe the service it offers. In essence, the standard specifies that although IP makes a best-effort to
deliver each datagram, IP does not guarantee that it will handle all problems

  Because IP is designed to operate over all types of network hardware,
including hardware that experiences problems, IP datagrams may be
lost, duplicated, delayed, delivered out of order, or delivered with corrupted data

- __`IP Encapsulation`__ -- How can a datagram be transmitted across a physical network that does not understand the datagram format? The answer lies in a technique known as encapsulation.
When an IP datagram is encapsulated in a frame, the entire datagram is placed in the
payload area of a frame.

  A datagram is encapsulated in a frame for transmission across a
physical network. The destination address in the frame is the MAC
address of the next hop to which the datagram is being sent; the address is obtained by translating the IP address of the next hop to an
equivalent MAC address.

- __`Transmission Across An Internet`__ -- Encapsulation applies to one transmission at a time. After the sender selects a next
hop, the sender encapsulates the datagram in a frame and transmits the result across the
physical network. When the frame reaches the next hop, the receiving software removes the IP datagram and discards the frame. If the datagram must be forwarded
across another network, a new frame is created.

  The point is When a datagram arrives in a network frame, the receiver extracts the
datagram from the frame payload area and discards the frame
header.

- __`MTU And Datagram Fragmentation`__ -- Each hardware technology specifies the maximum amount of data that a frame can
carry. The limit is known as a Maximum Transmission Unit (MTU). There is no exception to the MTU limit — network hardware is not designed to accept or transfer
frames that carry more data than the MTU allows.

  Each network has an MTU that specifies the maximum amount of data
a frame can carry. When a router receives a datagram that is larger
than the MTU of the network over which it is to be sent, the router
divides the datagram into smaller pieces called fragments. Each fragment uses the IP datagram format, but carries only part of the original payload.

- __`Reassembly Of A Datagram From Fragments`__ -- The process of recreating a copy of the original datagram from fragments is called
reassembly. Because each fragment begins with a copy of the original datagram
header†, all fragments have the same destination address as the original datagram from
which they were derived. Interestingly, IP specifies that the ultimate destination should reassemble fragments. 

  By postponing reassembly until the ultimate destination, IP is free to pass some
fragments from a datagram along differents routes than other fragments. That is, the Internet can change routes at any time 

- __`Collecting The Fragments Of A Datagram`__ --

- __`The Consequence Of Fragment Loss`__ --

- __`Fragmenting A Fragment`__ --

<br>
<br>

---

<br>
<br>


