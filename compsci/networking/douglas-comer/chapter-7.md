# Chapter 15: Wired LAN Techonology (Ethernet And 802.3)

- __`Introduction`__ -- This chapter continues the discussion of Local Area Networks by focusing on
wired LAN technologies. The chapter shows how concepts from previous chapters
form the basis of Ethernet, the wired LAN technology that has proceeded to dominate
all others.

- __`The Venerable Ethernet`__ -- Recall from Chapter 14 that Ethernet is a LAN technology originally invented at
Xerox PARC and later standardized by Digital Equipment Corporation, Intel, and
Xerox. Ethernet has survived for thirty years. Although the hardware devices, cabling,
and media used with Ethernet have changed dramatically, many of the fundamentals
remain constant. One of the most interesting aspects of Ethernet evolution concerns the
way newer versions of Ethernet remain backward compatible

- __`Ethernet Frame Format`__ -- The term frame format refers to the way a packet is organized, including details
such as the size and meaning of individual fields. The main reason that older versions
of Ethernet have remained compatible with newer versions arises from the frame format, which has remained constant since the DIX standard was created in the 1970s.

- __`Ethernet Type Field And Demultiplexing`__ -- The type field in an Ethernet frame provides multiplexing and demultiplexing that
allows a given computer to have multiple protocols operating simultaneously. For example, later chapters explain that the protocols used on the Internet send IP datagrams
and ARP messages over Ethernet. Each is assigned a unique Ethernet type (hexadecimal 0800 for IP datagrams and hexadecimal 0806 for ARP messages). When
transmitting a datagram in an Ethernet frame, the sender assigns a type 0800. When a
frame arrives at its destination, the receiver examines the type field, and uses the value
to determine which software module should process the frame.

- __`LAN Connections And Network Interface Cards`__ -- In terms of computer architecture, a LAN appears to be an I/O device, and connects to the computer in the same manner as a disk or video device. That is, a Network
Interface Card† (NIC) plugs into the computer’s bus. Logically, a NIC handles address
recognition, CRC computation, and frame recognition Physically, a NIC consists of a circuit board with a plug on one
side that matches the computer’s bus and a connector on the other side that accepts a
plug appropriate for a given LAN

- __`Twisted Pair Ethernet Wiring And Hubs`__ -- A third generation of Ethernet wiring made a dramatic shift in two ways:
  - In place of coaxial cable, the third generation uses a central
electronic device separate from the computers attached to the
network.
  - Instead of heavy, shielded cabling, the third generation uses
twisted pair wiring

  Because it does not use coaxial cable, the third-generation technology is informally
known as twisted pair Ethernet, and has replaced other versions. Thus, when someone
now refers to Ethernet, they are referring to twisted pair Ethernet.

  For the original version of twisted pair Ethernet, the electronic device that served
as the central interconnection was known as a hub. Hubs were available in a variety of
sizes, with the cost proportional to size. A small hub had four or eight ports that each
connected to a computer or other device (e.g., a printer). Larger hubs accommodated
hundreds of connections

- __`Physical And Logical Ethernet Topology`__ -- The question arises, “what is the topology of Ethernet?”. Surprisingly, the answer is complex.
Clearly, the original Thicknet version of Ethernet followed a bus topology. Indeed,
the original Ethernet is often cited as a classic example of bus topology. It may appear
that twisted pair Ethernet follows a star topology. In fact, the term hub arose to clarify
the concept of a central interconnection point. However, because a hub emulates a
physical cable, the system appears to perform as if computers attach to a cable. In fact,
professionals joked that a hub really provided a:
“bus in a box”

- __`Twisted Pair Connectors And Cables`__ -- Twisted pair Ethernet uses RJ45 connectors, which are larger versions of the RJ11
connectors used to connect telephones. An RJ45 connector can only be plugged into a
socket one way, and a physical piece holds the connector in place. Thus, connectors
cannot be plugged in incorrectly, and once inserted, the connectors do not fall out.

<br>
<br>

---

<br>
<br>

# Chapter 16: Wireless Networking Technologies

-- __`Introduction`__ -- This chapter describes wireless technologies. The chapter explains that a myriad of
wireless technologies have been proposed, that wireless communication is used across a
wide range of distances, and that many commercial systems exist

-- __`A Taxonomy Of Wireless Networks`__ -- Wireless communication applies across a wide range of network types and sizes.
Part of the motivation for variety arises from government regulations that make specific
ranges of the electromagnetic spectrum available for communication

-- __`Personal Area Networks (PANs)`__ -- In addition to the three network types described in Chapter 13 (LANs, MANs, and
WANs), wireless networking includes Personal Area Networks (PANs). A PAN technology provides communication over a short distance, and is intended for use with devices that are owned and operated by a single user. For example, a PAN can provide
communication between a wireless headset and a cell phone. PAN technologies are
also used between a computer and a nearby wireless mouse or keyboard.

  PAN technologies can be grouped into three broad categories.
  - Bluetooth 
  - InfraRed
  - ISM wireless

-- __`ISM Wireless Bands Used By LANs And PANs`__ -- Governments have reserved three areas of the electromagnetic spectrum for use by
Industrial, Scientific, and Medical groups. Known as ISM wireless, the frequencies are
not licensed to specific carriers, are broadly available for products, and are used for
LANs and PANs

-- __`Wireless LAN Technologies And Wi-Fi`__ -- In 1999, a group of vendors who build wireless equipment
formed the Wi-Fi Alliance, a non-profit organization that tests and certifies wireless
equipment using the 802.11 standards. Because the alliance has received extensive
marketing, most consumers associate wireless LANs with the term Wi-Fi

-- __`Spread Spectrum Techniques`__ -- Spread spectrum techniques can help wireless LANs function in noisy
environments

-- __`Other Wireless LAN Standards`__ -- Many variants of 802.11 have been created or proposed; each offers
some advantage.

-- __`Wireless LAN Architecture`__ -- The three building blocks of a wireless LAN are: access points, which are informally called base stations, an interconnection mechanism, such as a switch or router
used to connect access points, and a set of wireless hosts, also called wireless nodes or
wireless stations. In principle, two types of wireless LANs are possible:
  - Ad hoc — wireless hosts communicate among themselves without
a base station
  - Infrastructure — a wireless host only communicates with an access
point, and the access point relays all packets

  In practice few ad hoc networks exist. Instead, an organization or service provider
deploys a set of access points, and each wireless host communicates through one of the
access points

-- __`Overlap, Association, And 802.11 Frame Format`__ -- In practice, many details complicate an infrastructure architecture. On one hand, if
a pair of access points are too far apart, a dead zone will exist between them (i.e., a
physical location with no wireless connectivity). On the other hand, if a pair of access
points is too close together, an overlap will exist in which a wireless host can reach
both access points.

-- __`Coordination Among Access Points`__ -- Two basic approaches exist: complex access points coordinate to insure smooth handoff or lower cost access points operate independently and rely on wireless computers to change their association from
one access point to another.

-- __`Contention And Contention-Free Access`__ -- The CSMA/CA technique used in Wi-Fi networks includes timing
parameters that specify how long a station waits before sending an initial packet and how long a station waits before sending a reply.

-- __`Wireless MAN Technology and WiMax`__ -- In general, MAN technologies have not been commercially successful. One wireless MAN technology stands out as having the potential for success. The technology is
standardized by IEEE under the category 802.16. A group of companies coined the
term WiMAX, which is interpreted to mean World-wide Interoperability for Microwave
Access, and formed the WiMAX Forum to promote use of the technology

  WiMAX is a wireless LAN technology that can be used for backhaul,
fixed, or mobile access; deployments for access do not require a clear
line-of-sight.

-- __`PAN Technologies And Standards`__ -- PAN Technologies And Standards
  - Wireless replacement for cables (e.g., headphones or mouse)
  - Uses 2.4 GHz frequency band
  - Short distance (up to 5 meters, with variations that extend
the range to 10 or 50 meters)
  - Device is master or slave
  - Master grants permission to slave
  - Data rate is up to 721 Kbps
  
-- __`Other Short-Distance Communication Technologies`__ -- InfraRED. InfraRED technology is often used in remote controls, and may be used
as a cable replacement (e.g., for a wireless mouse).

-- __`Wireless WAN Technologies`__ -- Wireless WAN technologies can be divided into two categories:
  - Cellular communication systems
  - Cellular communication systems

-- __`Generations Of Cellular Technologies`__ -- The telecommunications industry divides cellular technologies into four generations that are labeled 1G, 2G, 3G, and 4G, with intermediate versions labeled 2.5G and
3.5G. The generations can be characterized as follows:
  - 1G. The first generation began in the latter 1970s, and extended
through the 1980s.
  - 2G and 2.5G. The second generation began in the early 1990s and
continues to be used. The main distinction between 1G and 2G
arises because 2G uses digital signals to carry voice.
  - 3G and 3.5G. The third generation began in the 2000s, and focuses
on the addition of higher-speed data services. A 3G system offers
download rates of 400 Kbps to 2 Mbps, and is intended to support
applications such as web browsing and photo sharing. 
  - 4G. The fourth generation began around 2008, and focuses on support for real-time multimedia, such as a television program or
high-speed video download.

-- __`Software Radio And The Future Of Wireless`__ -- The wide variety of wireless technologies described in the chapter each use
special-purpose radio hardware. The antenna, transmitter, and receiver in a given device are designed to operate on predetermined frequencies using specific forms of modulation and multiplexing. A cell phone that can use GSM, Wi-Fi, and CDMA networks
must have three completely separate radio systems, and must choose among them. 

  Emerging wireless systems use software programmable radios that allow software
to control all aspects of radio transmission. Programmable radios are expensive, and are
currently available for military and special uses. But in the future we will see their use in everyday life.


<br>
<br>

---

<br>
<br>

# Chapter 17: LAN Extensions: Fiber Modems, Repeaters, Bridges and Switches

- __`Introduction`__ -- This chapter discusses two important concepts: mechanisms that can extend a LAN
across a longer distance and LAN switching. The chapter introduces repeaters, bridges,
and the spanning tree algorithm used to prevent forwarding loops

- __`Distance Limitation And LAN Design`__ -- A maximum length specification is a fundamental part of LAN technology; LAN hardware will not work correctly over wires that exceed
the bound.

- __`Fiber Modem Extensions`__ -- Engineers have developed a variety of ways to extend LAN connectivity. As a
general rule, extension mechanisms do not increase the strength of signals, nor do they
merely extend cables. Instead, most extension mechanisms use standard interface
hardware, and insert additional hardware components that can relay signals across
longer distances

  A pair of fiber modems and optical fibers can be used to provide a
connection between a computer and a remote LAN such as an Ethernet.

- __`Repeaters`__ -- A repeater is an analog device used to propagate LAN signals over long distances.
A repeater does not understand packets or signal coding. Instead, it merely amplifies
the signal received, and transmits the amplified version as output

- __`Bridges And Bridging`__ -- A bridge is a mechanism that connects two LAN segments (e.g., two hubs) and
transfers packets between them. The bridge listens in promiscuous mode on each segment (i.e., receives all packets sent on the segment). When it receives an intact frame
from one segment, the bridge forwards a copy of the frame to the other segment. Thus,
two LAN segments connected by a bridge appear to behave like a single LAN

- __`Learning Bridges And Frame Filtering`__ -- Bridges do not blindly forward a copy of each frame from one LAN to another.
Instead, a bridge uses MAC addresses to perform filtering. That is, a bridge examines
the destination address in a frame, and does not forward the frame onto the other LAN
segment unless necessary

  An adaptive bridge uses the source MAC address in a packet to
record the location of the sender, and uses the destination MAC address to determine whether to forward the frame

- __`Why Bridging Works Well`__ -- It is important to know that once a bridge learns the locations of all computers, a
bridged network can exhibit higher overall performance than a single LAN.

  Because a bridge permits simultaneous activity on attached segments,
a pair of computers on one segment can communicate at the same
time as a pair computers on another segment.

  DSL and cable modems also use the concept of
bridging — the modem operates as a bridge between a local network on a subscriber’s
premise and a network at an ISP.

- __`Switching And Layer 2 Switches`__ -- The concept of bridging helps explain a mechanism that forms the basis of modern
Ethernets: switching. An Ethernet switch, sometimes called a Layer 2 switch is an electronic device that resembles a hub. Like a hub, a switch provides multiple ports that
each attach to a single computer, and a switch allows computers to send frames to one another. The difference between a hub and a switch arises from the way the devices
operate: a hub operates as an analog device that forwards signals among computers,
while a switch is a digital device that forwards packets

  Physically, switches are available in many sizes. The smallest consist of an inexpensive, stand-alone device that provides four connections, which are sufficient to interconnect a computer, printer, and two other devices such as a scanner. Businesses use
the largest switches to connect tens of thousands of computers and other devices
throughout the company

- __` VLAN Switches`__ -- Switches have been extended by adding virtualization, and the result is known as a
Virtual Local Area Network switch (VLAN switch). The concept is straightforward: allow a manager to configure a single switch to emulate multiple, independent switches.
That is, a manager specifies a set of ports on the switch and designates them to be on
virtual LAN 1, designates another set of ports to be on virtual LAN 2, and so on. When
a computer on virtual LAN 2 broadcasts a packet, only those computers on the same
virtual LAN receive a copy (i.e., once configured, a VLAN switch makes it appear that
there are multiple switches).

- __`Bridging Used With Other Devices`__ -- Although our description characterizes a bridge as a stand-alone device, bridging is
a fundamental concept that has been incorporated into many devices. For example, a
DSL or cable modem provides a form of bridging: the modem provides an Ethernet
connection at a subscriber’s residence, and transfers Ethernet packets between the
subscriber’s location and the provider’s network. Some wireless technologies also use a
form of bridging to transfer frames from a mobile device to a provider’s network

<br>
<br>

---

<br>
<br>

# Chapter 18: WAN Technologies and Dynamic Routing

- __`Introduction`__ -- This chapter
considers the structure of a network that spans an arbitrarily large area. The chapter
describes the basic components used to build a packet switching system, and explains
the fundamental concept of routing. The chapter presents the two basic routing algorithms, and explains the advantages of each

- __`Large Spans And Wide Area Networks`__ -- Consider a company that uses a satellite bridge to connect LANs at two sites.
Should the network be classified as a WAN or as an extended LAN? Does the answer
change if the company only has a PC and a printer at each site? Yes, it does. The key
issue that separates WAN technologies from LAN technologies is scalability — a WAN
must be able to grow as needed to connect many sites spread across large geographic
distances, with many computers at each site. For example, a WAN should be able to
connect all the computers in a large corporation that has offices or factories at dozens of
locations spread across thousands of square miles. Furthermore, a technology is not
classified as a WAN unless it can deliver reasonable performance for a large scale network

- __`Traditional WAN Architecture`__ -- Traditional WAN technologies were developed before Local Area Networks emerged, before personal computers were available, and before the Internet had been created

  Without LAN technologies available, WAN designers chose to create a specialpurpose hardware device that could be placed at each site. Known as a packet switch,
the device provides local connections for computers at the site as well as connections
for data circuits that lead to other sites.

  Since the advent of LAN technology, most WANs separate a packet switch into
two parts: a Layer 2 switch that connects local computers and a router that connects to
other site

- __`Forming A WAN`__ -- Conceptually, a WAN can be formed by interconnecting a set of sites. The exact
details of the interconnections depend on the data rate needed, the distance spanned, and
the delay that can be tolerated

  A traditional WAN is formed by interconnecting packet switches; a
packet switch at each site connects to computers. The topology and
capacity of connections are chosen to accommodate expected traffic
and need for redundancy.

- __`Store And Forward Paradigm`__ -- The goal of a WAN is to allow as many computers as possible to send packets
simultaneously. The fundamental paradigm used to achieve simultaneous transmission
is known as store and forward

  Wide area packet switching systems use the store-and-forward technique in which packets arriving at a packet switch are placed in a
queue until the packet switch can forward them on toward their destination. The technique allows a packet switch to buffer a short burst
of packets that arrive simultaneously.

- __`Addressing In A WAN`__ -- From the view of an attached computer, a traditional WAN network operates similar to a LAN. Each WAN technology defines the exact frame format a computer uses
when sending and receiving data. Furthermore, each computer connected to a WAN is
assigned an address. When sending a frame to another computer, the sender must supply the destination address.

  Although details vary, WANs addresses follow a key concept that is used in the Internet: hierarchical addressing. Conceptually, hierarchical addressing divides each address into two parts: `(site, computer at the site)` 
  
- __`Next-Hop Forwarding`__ -- The importance of hierarchical addressing becomes clear when one considers packet processing. When a packet arrives, a packet switch must choose an outgoing path
over which to forward the packet

  The important idea is that a packet switch does not need to keep complete information about how to reach all possible computers, nor does a switch need to compute the
entire route a packet will follow through the network. Instead, a switch bases forwarding on packet switch IDs, which means that a switch only needs to know which outgoing link to use to reach a given switch.

  We say that a switch only needs to compute the next hop for a packet. The process
is called next-hop forwarding, and is analogous to the way airlines list flights.

  Only the first part of a destination address is used when forwarding a
packet across a WAN. Once the packet reaches the switch to which
the destination computer attaches, the second part of the address is
used to forward the packet to the correct local computer.

- __`Source Independence`__ -- Note that next-hop forwarding does not depend on the packet’s original source or
on the path the packet has taken before it arrives at a particular packet switch. Instead,
the next hop to which a packet is sent depends only on the packet’s destination. The
concept, which is known as source independence, is a fundamental idea in networking,

- __`Dynamic Routing Updates In A WAN`__ -- For a WAN to operate correctly, each switch must have a forwarding table, and
must forward packets. Furthermore, values in the forwarding table must guarantee the
following:
  - Universal communication. The forwarding table in each switch
must contain a valid next-hop route for each possible destination
address
  - Optimal routes. In a switch, the next-hop value in the forwarding
table for a given destination must point to the shortest path to the
destination.

  Network failures further complicate forwarding. For example, if two paths exist to
a given destination and one of the paths becomes unavailable because hardware fails
(e.g., a circuit is disconnected), forwarding should be changed to avoid the unavailable
path. Thus, a manager cannot merely configure a forwarding table to contain static
values that do not change. Instead, software running on the packet switches continually
tests for failures, and reconfigures the forwarding tables automatically. We use the term
routing software to describe software that automatically reconfigures forwarding tables.

- __`Shortest Path Computation In A Graph`__ -- These are a traveling salesman problems so greedy algorithms are needed for optimal solutions in graph algorithms such as djikstras algoriyhm ... etc.

  Because it uses weights on links when computing shortest paths,
Dijkstra’s algorithm can be used with measures other than geographic
distance.

- __`Routing Problems`__ -- Most practical routing mechanisms contain constraints and hueristics to prevent
problems like routing loops. For example, DVR schemes employ split horizon, which
specifies that a switch does not send information back to its origin. Furthermore, most
practical routing systems introduce hysteresis that prevents the software from making
many changes in a short time. However, in a large network where many links fail and
recover frequently, routing problems can occur.

<br>
<br>

---

<br>
<br>

