# Chapter 11: Multiplexing and Demultiplexing (Channelzation)

- __`Introduction`__ -- This chapter continues the discussion of data communications by introducing multiplexing. The chapter describes the motivation, and defines basic types of multiplexing
that are used throughout computer networks and the Internet

- __`The Concept Of Multiplexing`__ -- We use the term multiplexing to refer to the combination of information streams
from multiple sources for transmission over a shared medium, and multiplexor to denote
a mechanism that implements the combination. Similarly, we use the term demultiplexing to refer to the separation of a combination back into separate information streams,
and demultiplexor to refer to a mechanism that implements separation

- __`The Basic Types Of Multiplexing`__ -- There are four basic approaches to multiplexing that each have a set of variations
and implementations:
  - 1 - Frequency Division Multiplexing
  - 2 - Wavelength Division Multiplexing
  - 3 - Time Division Multiplexing
  - 4 - Code Division Multiplexing

- __`Frequency Division Multiplexing (FDM)`__ -- simultaneously sending multiple
carrier waves over a single copper wire or using wavelength division multiplexing to
send multiple frequencies of light over an optical fiber. At the receiving end, a demultiplexor applies a set of filters that each extract a small range of frequencies near one of
the carrier frequencies

  The most significant advantage of FDM arises from the simultaneous use of a
transmission medium by multiple pairs of communicating entities. We imagine FDM
as providing each pair with a private transmission path as if the pair had a separate
physical transmission medium

- __`Hierarchical FDM`__ -- It is possible to build a hierarchy of frequency division multiplexing in
which each stage accepts as inputs the outputs from the previous
stage.

- __`Wavelength Division Multiplexing (WDM)`__ -- When frequency division multiplexing is applied to optical fiber,
prisms are used to combine or separate individual wavelengths of
light, and the result is known as wavelength division multiplexing.

- __`Time Division Multiplexing (TDM)`__ -- The chief alternative to FDM is known as Time Division Multiplexing (TDM).
TDM is less esoteric than FDM and does not rely on special properties of electromagnetic energy. Instead, multiplexing in time simply means transmitting an item from one
source, then transmitting an item from another source, and so on

- __`Synchronous TDM`__ -- When TDM is
applied to synchronous networks, no gap occurs between items. The result is known as
Synchronous Time Division Multiplexing. A synchronous TDM system uses roundrobin order to select items

- __`Framing Used In The Telephone System Version Of TDM`__ -- The synchronous TDM mechanism used for digital telephone calls includes a framing bit at the beginning of each round. The framing sequence of alternating 1s and 0s insures that a demultiplexor either
remains synchronized or detects the error.

- __`Statistical TDM`__ -- How can a multiplexing system make better use of a shared medium? One technique to increase the overall data rate is known as statistical time division multiplexing
or statistical multiplexing†. The terminology is awkward, but the technique is straightforward: select items for transmission in a round-robin fashion, but instead of leaving a
slot unfilled, skip any source that does not have data ready. By eliminating unused
slots, statistical TDM takes less time to send the same amount of data.

- __`Inverse Multiplexing`__ -- An interesting twist on multiplexing arises in cases where the only connection
between two points consists of multiple transmission media, but no single medium has a
bit rate that is sufficient. At the core of the Internet, for example, service providers
need higher bit rates than are available. To solve the problem, multiplexing is used in
reverse: spread a high-speed digital input over multiple lower-speed circuits for
transmission and combine the results at the receiving end

- __`Code Division Multiplexing`__ -- A final form of multiplexing used in parts of the cellular telephone system and for
some satellite communication is known as Code Division Multiplexing (CDM). The
specific version of CDM used in cell phones is known as Code Division Multi-Access
(CDMA).

<br>
<br>

---

<br>
<br>

# Chapter 12: Access and Interconnection Techonologies

- __`Introduction`__ -- This chapter concludes the discussion of data communications by examining two
facilities used in the Internet. First, the chapter discusses access technologies, such as
dialup, DSL, and cable modems, that are used to connect individual residences and
businesses to the Internet. Second, the chapter considers high-capacity digital circuits
used in the core of the Internet. The chapter expands the discussion of the telephone
system multiplexing hierarchy, and gives examples of circuits that common carriers
offer to businesses and Internet Service Providers

- __`Internet Access Technology: Upstream And Downstream`__ -- Internet access technology refers to a data communications system that connects an
Internet subscriber (typically a private residence or business) to an Internet Service Provider (ISP), such as a telephone company or cable company.

  Because a typical residential subscriber receives much more information than the subscriber sends, Internet access technologies are
designed to transfer more data in one direction than the other

  The networking industry uses the term downstream to refer to data traveling from a
service provider in the Internet to a subscriber, and upstream to refer to data traveling
from a subscriber to a service provider.

- __`Narrowband And Broadband Access Technologies`__ -- A variety of technologies are used to provide Internet access. They can be divided
into two broad categories based on the data rate they provide:
  - Narrowband
  - Broadband
  
  __Narrowband Technologies__ -- Narrowband generally refers to technologies that deliver data at up to 128 Kbps.
For example, the maximum data rate that can be achieved over a dialup connection with
the most sophisticated modem technology and the least noisy phone lines is 56 Kbps.
  - Dialup telephone connections
  - Leased circuit using modems
  
  __Broadband Technologies__ -- The term broadband generally refers to technologies that offer high data rates, but
the exact boundary between broadband and narrowband is blurry. Many professionals
suggest that broadband technologies deliver more than 1 Mbps. However, providers
such as telephone companies use the term broadband when they advertise a service that
offers a higher rate than dialup. Thus, phone companies sometimes claim that ISDN
service, which provides 128 Kbps, is broadband
  - DSL technologies
  - Wireless access technologies
  - Cable modem technologies

- __`The Local Loop And ISDN`__ -- The term local subscriber line or local loop describes the physical connection
between a telephone company Central Office (CO) and a subscriber’s location.

  As data networking became important, telephone companies explored ways to use
the local loop to provide higher-speed data communication. One of the first phone
company efforts to provide large-scale digital services to subscribers is offered under
the name Integrated Services Digital Network (ISDN).

- __`Digital Subscriber Line (DSL) Technologies`__ -- Digital Subscriber Line (DSL) is one of the main technologies used to provide
high-speed data communication services over a local loop. Because the names differ only in the first word, the set is collectively referred to
by the acronym xDSL.
  - ADSL - Asymmetric DSL - Residential customers
  - ADSL2 - Asymmetric DSL version 2 - Approximately three times faster
  - SDSL - Symmetric DSL - Businesses that export data
  - HDSL - High bit rate DSL - Businesses up to 3 miles away
  - VDSL - Very-high bit rate DSL - Proposed version for 52-Mbps
  
  ADSL is the most widely deployed variant, and the one that most residential customers use Because it uses frequency division multiplexing, ADSL and traditional
analog phone service (POTS) can use the same wires simultaneously

- __`Local Loop Characteristics And Adaptation`__ -- ADSL technology is complex because no two local loops have identical electrical
characteristics. Instead, the ability to carry signals depends on the distance, the diameter of the wiring used, and the level of electrical interference.  the ADSL designers could not pick a particular set of carrier frequencies or modulation techniques that would work well in all local loops. Because ADSL gets effected by the local radio tower signals ...etc.

  Because the electrical characteristics of local loops vary, ADSL uses
an adaptive technology in which a pair of modems probe many frequencies on the line between them, and select frequencies and modulation techniques that yield optimal results on that line.

- __`The Data Rate Of ADSL`__ -- How fast can ADSL operate? ADSL can achieve a downstream rate of 8.448
Mbps on short local loops, and an upstream rate of 640 Kbps. Because the mandatory
network control channel requires 64 Kbps, the effective upstream rate for user data is
576 Kbps. Under the best conditions, ADSL2 can download at close to 20 Mbps.

  It is important to understand that the ADSL data rate only applies to the local loop
connection between a subscriber and the telephone Central Office. Many other factors
affect the overall data rates that a user experiences

- __`ADSL Installation And Splitters`__ -- Although traditional analog phones operate at frequencies below 4 KHz, lifting a
receiver can generate noise that interferes with DSL signals. To provide complete isolation, ADSL uses an FDM device known as a splitter that divides the bandwidth by
passing low frequencies to one output and high frequencies to another. Interestingly, a
splitter is passive, which means that it does not require power. A splitter is usually installed at the location where the local loop enters a residence or business

- __`Cable Modem Technologies`__ -- Although technologies like ADSL provide data rates that are much higher than originally thought possible, telephone local loop wiring has inherent limitations. The chief
problem lies in the electrical characteristics of twisted pair wiring. As demand for higher bit rates increased, alternative wiring
schemes have become important.

  An alternative access technology that stands out as particularly attractive uses the
wiring already in place for cable television†. The medium used in cable systems is
coaxial cable, which has high bandwidth and is less susceptible to electromagnetic interference than twisted pair

- __`The Data Rate Of Cable Modems`__ -- How fast can a cable modem operate? In theory, a cable system can support data
rates of 52 Mbps downstream and 512 Kbps upstream. In practice, the rate can be
much less

- __`Cable Modem Installation`__ -- Because cable systems use frequency division multiplexing, a cable
modem can be attached directly to existing cable wiring without the
need for a splitter.

- __`Hybrid Fiber Coax`__ -- One of the most promising ideas for technologies that provide high-speed data
communications is known by the general name of Hybrid Fiber Coax (HFC). The cable industry uses the term trunk to refer to the high-capacity connections between
the cable office and each neighborhood area, and the term feeder circuit to refer to the
connection to an individual subscriber.

- __`Access Technologies That Employ Optical Fiber`__ -- Cable companies have proposed a variety of technologies that either employ optical fiber in a hybrid system or deploy optical fiber all the way to each subscriber.
  - FTTC Fiber To The Curb
  - FTTB Fiber To The Building
  - FTTH Fiber To The Home
  - FTTP Fiber To The Premises

- __`Head-End And Tail-End Modem Terminology`__ -- An access technology requires a pair of modems, with one at the subscriber’s site
and one at the provider’s site. The industry uses the term head-end modem to refer to a
modem used at the central office, and the term tail-end modem to refer to a modem
used at the subscriber’s location.

- __`Wireless Access Technologies`__ -- Although technologies such as ADSL or HFC can deliver digital services to most
subscribers, they do not handle all circumstances. The primary problems arise in rural
areas. For example, imagine a farm or remote village many miles from the nearest city.
The twisted pair wiring used to deliver telephone service to such locations exceeds the
maximum distance for technologies like ADSL.

  To handle special cases, a variety of wireless access technologies have been explored. 3g, 4g, satellite

- __`High-Capacity Connections At The Internet Core`__ -- Digital circuits leased from common carriers form the fundamental
building blocks for long-distance data communications. The cost
depends on the circuit capacity and distance.

- __`Circuit Termination, DSU / CSU, and NIU`__ -- A digital circuit needs a device known as a DSU/CSU at each end.
The DSU/CSU translates between the digital representation used by
phone companies and the digital representation used by the computer
industry.

- __`DS Terminology And Data Rates`__ -- telephone companies use a multiplexing hierarchy
that combines multiple voice calls into a single digital circuit. Thus, the data rates of T
standards have been chosen so they can each handle a multiple of voice calls. The important thing to note is that the capacity of circuits does not increase linearly with their
numbers

- __`Highest Capacity Circuits (STS Standards)`__ -- Telephone companies use the term trunk to denote a high-capacity circuit, and have
created a series of standards for digital trunk circuits. Known as the Synchronous
Transport Signal (STS) standards, they specify the details of high-speed connections.

- __`Optical Carrier Standards`__ -- In addition to STS standards, the phone company defines an equivalent set of Optical Carrier (OC) standards To be precise, one should observe a distinction between the
STS and OC terminology: the STS standards refer to the electrical signals used in the
digital circuit interface (i.e., over copper), while the OC standards refer to the optical
signals that propagate across the fiber. As with other network terminology, few professionals make the distinction

- __`Synchronous Optical NETwork (SONET)`__ -- Although the SONET standard defines a technology that can be used
to build a high-capacity ring network with multiple data circuits multiplexed across the fibers that constitute the ring, most data networks
only use SONET to define framing and encoding on a leased circuit.

<br>
<br>

---

<br>
<br>

# Chapter 13: Local Area Networks:Packets, Frames and Topologies

- __`Introduction`__ -- The first part of the text covers Internet applications and network programming.
The second part explores topics in data communications. Each chapter covers a fundamental concept, such as multiplexing, that forms the basis for all of computer networking

  This chapter begins the part of the text that examines packet switching and computer network technologies. After a brief overview, the chapter explains the IEEE standards model, and concentrates on the concepts of hardware addressing and frame identification

- __`Circuit Switching`__ -- The term circuit switching refers to a communication mechanism that establishes a
path between a sender and receiver with guaranteed isolation from paths used by other
pairs of senders and receivers. Circuit switching is usually associated with telephone
technology because a telephone system provides a dedicated connection between two
telephones

  Circuit switching provides the illusion of an isolated physical path
between a pair of communicating entities; a path is created when
needed, and discontinued after use.

- __`Packet Switching`__ -- The main alternative to circuit switching, packet switching, forms the basis for the
Internet. A packet switching system uses statistical multiplexing in which communication from multiple sources competes for the use of shared media.

  The chief difference between packet switching and other forms of statistical multiplexing arises because a packet switching system requires a sender to divide each message into blocks of data that are known as packets. The size of a packet varies
  
  Packet switching, which forms the basis of the Internet, is a form of
statistical multiplexing that permits many-to-many communication. A
sender must divide a message into a set of packets; after transmitting
a packet, a sender allows other senders to transmit before transmitting a successive packet

- __`Local And Wide Area Packet Networks`__ -- Packet switching technologies are commonly classified according to the distance
they span
  - LAN -- Local Area Network -- Least expensive; spans a single
room or a single building
  - MAN -- Metropolitan Area -- Network Medium expense; spans a major
city or a metroplex
  - WAN -- Wide Area Network -- Most expensive; spans sites in
multiple cities

  > In practice, few MAN technologies have been created, and MAN networks have
not been commercially successful. Consequently, networking professionals tend to
group MAN technologies into the WAN category, and use only the terms LAN and
WAN.

- __`Standards For Packet Format And Identification`__ -- Because packet switching systems rely on sharing, each packet sent across such a
network must contain the identification of the intended recipient. Furthermore, to insure
that no ambiguity arises, all senders must agree on the exact details of how to identify a
recipient and where to place the identification in a packet. The most widely used set of standards for LANs has been created by the Institute for Electrical and Electronic Engineers (IEEE).

- __`Point-To-Point And Multi-Access Networks`__ -- Recall that the term point-to-point refers to a communication mechanism that connects exactly two communicating entities. LAN technologies allow multiple computers
to share a medium in such a way that any computer on the LAN can communicate with
any other. To describe such arrangements, we use the term multi-access and say that a
LAN is a multi-access network.

- __`LAN Topologies`__ -- Because many LAN technologies have been invented, it is important to know how
specific technologies are similar and how they differ. To help understand similarities,
each network is classified into a category according to its topology or general shape.
  - Bus
  - Ring
  - Star
  - Mesh
  
  __Bus__ -- A network that uses a bus topology usually consists of a single cable to which
computers attach†. Any computer attached to a bus can send a signal down the cable,
and all computers receive the signal. Because all computers attach directly to the cable,
any computer can send data to any other computer

  __Ring__ -- A network that uses a ring topology arranges for computers to be connected in a
closed loop — a cable connects the first computer to a second computer, another cable
connects the second computer to a third, and so on, until a cable connects the final computer back to the first Its a circle.
  
  __Star__ -- A network uses a star topology when all computers attach to a central point.  the center of a star network is often called a hub. A typical hub consists of an electronic device that accepts
data from a sending computer and delivers it to the appropriate destination
  
  __Mesh__ -- A network that uses a mesh topology provides a direct connection between each
pair of computers. The chief disadvantage of a mesh arises from the cost

  Networks are classified into broad categories according to their general shape. Although a mesh topology is possible, the primary topologies used with LANs are star, ring, and bus; each has advantages and
disadvantages. and they are usually included together inside a network.

- __`Packet Identification, Demultiplexing, MAC Addresses`__ -- In addition to standards that specify the details of various LAN technologies, IEEE
has created a standard for addressing. To understand addressing, consider packets
traversing a shared medium  In the simplest case, each packet that travels across the shared medium is intended for a specific recipient, and only the
intended recipient should process the packet. In packet switching systems, demultiplexing uses an identifier known as an address. Each computer is assigned a unique address, and each packet contains the address of the intended recipient.

   IEEE uses the
term Media Access Control address (MAC address).

- __`Unicast, Broadcast, And Multicast Addresses`__ --  The IEEE addressing scheme supports three types of addresses that correspond to
three types of packet delivery.
  - __unicast__ -- Uniquely identifies a single computer, and specifies that only the identified computer should receive a
copy of the packet
  - __broadcast__ -- Corresponds to all computers, and specifies that each computer on the network should receive a
copy of the packet
  - __multicast__ -- Identifies a subset of the computers on a given network, and specifies that each computer in the
subset should receive a copy of the packet

- __`Frames And Framing`__ -- In a more general sense, we use the term framing to refer to the structure added to a sequence of bits or bytes that allows a sender and receiver to agree on
the exact format of the message. In a packet-switched network, each frame corresponds
to a packet. A frame consists of two conceptual parts:
  - Header that contains metadata, such as an address
  - Payload that contains the data being sent

- __`Byte And Bit Stuffing`__ --  . For a network that transmits characters,
a frame can be formed by using one byte value to indicate the beginning of the frame
and another to indicate the end of the frame.
Byte (bit) stuffing techniques permit bytes (sequences of bits) to be reserved for
use in marking the start and end of a frame. To insure that a payload does not contain
reserved bytes (bit strings), a sender replaces occurrences of reserved values before
transmission, and a receiver reverses the change to obtain the original data.

<br>
<br>

---

<br>
<br>

# Chapter 14: The IEEE MAC Sub-Layer 

- __`Introduction`__ -- This chapter continues the discussion by examining the IEEE’s MAC sublayer.
The chapter explains multi-access protocols, and considers both static and dynamic
channel allocation

- __`A Taxonomy Of Mechanisms For Multi-Access`__ -- How do multiple, independent computers coordinate access to a shared medium?
There are three broad approaches: they can use a modified form of a multiplexing technique, they can engage in a distributed algorithm for controlled access, or they can use a
random access strategy

- __`Static And Dynamic Channel Allocation`__ -- We use the term channelization to refer to a mapping between a given communication and a channel in the underlying transmission system.  For example, consider a frequency division multiplexing (FDM) mechanism. Most FDM systems assign each pair
of communicating entities a unique carrier frequency. That is, each pair is assigned a
unique channel. Furthermore, the mapping between a pair of entities and a carrier frequency does not change. In such situations, we describe the mapping between communicating entities and a channel as "1-to-1" and "static"

  Static channel allocation suffices when the set of communicating entities is known in advance and does not change; most networks require
a form of dynamic channel allocation.

- __`Channelization Protocols`__ -- Channelization protocols extend the multiplexing techniques covered in Chapter
11:
  - FDMA -- Frequency Division Multi-Access
  - TDMA -- Time Division Multi-Access
  - CDMA -- Code Division Multi-Access

- __`Controlled Access Protocols`__ -- Controlled access protocols provide a distributed version of statistical multiplexing.
  - __Polling__ -- Centralized controller repeatedly polls stations
and allows each to transmit one packet
  - __Reservation__ -- Stations submit a request for the next round of
data transmission
  - __Token Passing__ -- Stations circulate a token; each time it receives
the token, a station transmits one packet

- __`Random Access Protocols`__ -- Many networks, especially LANs, do not employ a controlled access mechanism.
Instead, a set of computers attached to a shared medium attempt to access the medium
without coordination. The term random is used because access only occurs when a
given station has a packet to send and randomization is employed to prevent all computers on a LAN from attempting to use the medium at the same time

<br>
<br>

