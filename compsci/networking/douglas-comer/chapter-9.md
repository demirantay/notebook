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

- __`Introduction`__ --

- __`The Success Of IP`__ --

- __`The Motivation For Change`__ --

- __`The Hourglass Model And Difficulty Of Change`__ --

- __`A Name And A Version Number`__ --

- __`IPv6 Features`__ --

- __`IPv6 Datagram Format`__ --

- __`IPv6 Base Header Format`__ --

- __`Implicit And Explicit Header Size`__ --

- __`Fragmentation, Reassembly, And Path MTU`__ --

- __`The Purpose Of Multiple Headers`__ --

- __`IPv6 Addressing`__ --

- __`IPv6 Colon Hexadecimal Notation`__ --

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
