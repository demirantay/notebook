# Computer Networks and Internets

Written by: Douglas E. Comer

Table of Contents:
- [Chapter 1: Introduction and Overview]()
- [Chapter 2: Internet Trends]()
- [Chapter 3: Internet Applications and Network Programming]()
- [Chapter 4: Traditional Internet Applications]()
- [Chapter 5: Overview of Data Communications]()
- [Chapter 6: Information Sources and Signals]()
- [Chapter 7: Transmission Media]()
- [Chapter 8: Reliablity and Channel Coding]()
- [Chapter 9: Transmission Modes]()
- [Chapter 10: Modulation and Modems]()
- [Chapter 11: Multiplexing and Demultiplexing (Channelzation)]()
- [Chapter 12: Access and Interconnection Techonologies]()
- [Chapter 13: Local Area Netowkrs:Packets, Frames and Topologies]()
- [Chapter 14: The IEEE MAC Sub-Layer]()
- [Chapter 15: Wired LAN Techonology (Ethernet And 802.3)]()
- [Chapter 16: Wireless Networking Technologies]()
- [Chapter 17: LAN Extensions: Fiber Modems, Repeaters, Bridges and Switches]()
- [Chapter 18: WAN Technologies and Dynamic Routing]()
- [Chapter 19: Networking Technologies Past and Present]()
- [Chapter 20: Internetworking: Concepts Architecture and Protocols]()
- [Chapter 21: IP:Internet Adressing]()
- [Chapter 22: Datagram Forwarding ]()
- [Chapter 23: Support Protocols and Technologies]()
- [Chapter 24: The Future IP (IPv6)]()
- [Chapter 25: UDP: Datagram Transport Service]()
- [Chapter 26: TCP: Reliable Transport Service]()
- [Chapter 27: Internet Routing and Routing Protocols]()
- [Chapter 28: Network Performance (QoS and DiffServ)]()
- [Chapter 29: Multimedia and IP Telephony (VoIP)]()
- [Chapter 30: Network Security]()
- [Chapter 31: Network Management (SNMP)]()
- [Chapter 32: Trends in Networking Technologies and Uses]()

<br>
<Br>

---

<Br>
<br>
  
# Chapter 1: Introduction and Overview

- __`Growth of Computer Networking`__ -- Computer networking has grown explosively. Since the 1970s, computer communication has changed from an esoteric research topic to an essential part of the infrastructure. Networking is used in every aspect of business, including advertising, production,
shipping, planning, billing, and accounting. Consequently, most corporations have multiple networks. Schools, at all grade levels from elementary through post-graduate, are
using computer networks to provide students and teachers with instantaneous access to
online information. Federal, state, and local government offices use networks, as do
military organizations. In short, computer networks are everywhere.

  In addition, an entire industry emerged that develops networking technologies, products, and services. The importance of computer networking has produced
a demand in all industries for people with more networking expertise

- __`Why Networking Seems Complex`__ -- Computer networking can be especially confusing to a beginner because no single
underlying theory exists that explains the relationship among all parts. Multiple organizations have created networking standards, but some standards are incompatible with
others

  The lack of consistency in the field has produced another challenge for beginners:
instead of a uniform terminology for networking concepts, multiple groups each attempt
to create their own terminology. Researchers cling to scientifically precise terminology.
Corporate marketing groups often associate a product with a generic technical term or
invent new terms merely to distinguish their products or services from those of competitors. Thus, technical terms are easily confused with the names of popular products

- __`The Five Key Aspects of Networking`__ --To master the complexity in networking, it is important to gain a broad background that includes five key aspects of the subject:
  - 1 - Network Applications And Network Programming
  - 2 - Data Communications
  - 3 - Packet Switching And Networking Technologies
  - 4 - Internetworking With TCP/IP
  - 5 - Additional Networking Concepts And Technologies
  
- __`Network Applications And Network Programming`__ -- The network services and facilities that users invoke are each provided by application software — an application program on one computer communicates across a network with an application program running on another computer. Network application
services span a wide range that includes email, file transfer, web browsing, voice telephone calls, distributed databases, and audio and video teleconferencing

  As we will see, it is possible to understand network applications, and even possible
to write code that communicates over a network, without understanding the hardware
and software technologies that are used to transfer data from one application to another.
It may seem that once a programmer masters the interface, no further knowledge of networking is needed. However, network programming is analogous to conventional programming. Although a conventional programmer can create applications without understanding compilers, operating systems, or computer architecture, knowledge of the
underlying systems can help a programmer create more reliable, correct, and efficient
programs.

- __`Data Comminucations`__ -- The term data communications refers to the study of low-level mechanisms and
technologies used to send information across a physical communication medium, such
as a wire, radio wave, or light beam. Data communications is primarily the domain of
Electrical Engineering, which studies how to design and construct a wide range of communication systems. Data communications focuses on ways to use physical phenomena
to transfer information. Thus, many of the basic ideas are derived from the properties
of matter and energy that have been studied by physicists. Because it deals with physical concepts, data communications may seem somewhat
irrelevant to our understanding of networking

- __`Packet Switching And Networking Technologies`__ -- Packet switching changed networking in a fundamental way, and
provided the basis for the modern Internet: instead of forming a dedicated circuit, packet switching allows multiple senders to transmit data over a shared network. Packet
switching builds on the same fundamental data communications mechanisms as the
phone system, but uses the underlying mechanisms in a new way. Packet switching
divides data into small blocks, called packets, and includes an identification of the intended recipient in each packet.

- __`Internetworking With TCP/IP`__ -- In the 1970s, another revolution in computer networking arose: the concept of an
Internet. Many researchers who investigated packet switching looked for a single packet switching technology that could handle all needs. In 1973, Vinton Cerf and Robert
Kahn observed that no single packet switching technology would ever satisfy all needs

  The solution, they suggested, was to stop trying to find a
single best solution, and instead, explore interconnecting many packet switching technologies into a functioning whole. They proposed that a set of standards be developed for
such an interconnection, and the resulting standards became known as the TCP/IP Internet Protocol Suite (usually abbreviated TCP/IP) The concept, now known as internetworking, is extremely powerful. It provides the basis of the global Internet, and
forms an important part of the study of computer networking.

- __` Public And Private Parts Of The Internet`__ -- Although it functions as a single communication system, the Internet consists of
parts that are owned and operated by individuals or organizations. To help clarify ownership and purpose, the networking industry uses the terms public network and private
network

  - `Public Network` -- A public network is owned by a service provider, and offers service to
any individual or organization that pays the subscription fee. It is important to understand that the term public refers to the general availability
of service, not to the data transferred.
  - `Private Network` -- A network is said to be private if use of the network is restricted to
one group. Networking equipment vendors divide private networks into four categories:
    - Consumer
    - Small Office / Home Office (SOHO)
    - Small-To-Medium Business (SMB)
    - Large Enterprise
    
 - __`Networks, Interoperability, And Standarts`__ -- Communication involves multiple entities that must agree on details
ranging from the electrical voltage used to the format and meaning of
messages. To insure that entities can interoperate correctly, rules for
all aspects of communication are written down.

  Following diplomatic terminology, we use the term communication protocol, network protocol, or protocol to refer to a specification for network communication.
  
  A communication protocol specifies the details for one aspect of computer communication, including actions to be taken when errors or
unexpected situations arise. A given protocol can specify low-level
details, such as the voltage and signals to be used, or high-level items,
such as the format of messages that application programs exchange.

- __`Protocol Suites And Layering Models`__ -- A set of protocols must be constructed carefully to ensure that the resulting communication system is both complete and efficient. How can one guarantee that protocols will work well together? The answer
lies in an overall design plan: instead of creating each protocol in isolation, protocols
are designed in complete, cooperative sets called suites or families

  The fundamental abstraction used to collect protocols into a unified whole is
known as a layering model.
  - `Layer 1: Physical`: Protocols in the Physical layer specify details about the underlying transmission
medium and the associated hardware.
  - `Layer 2: Network Interface`: Protocols in the Network Interface layer specify details about communication
between higher layers of protocols, which are usually implemented in software, and the
underlying network, which is implemented in hardware
  - `Layer 3: Internet`: Protocols in the Internet layer form the fundamental basis for the Internet. Layer 3
protocols specify communication between two computers across the Internet
  - `Layer 4: Transport`: Protocols in the Transport layer provide for communication from an application
program on one computer to an application program on another
  - `Layer 5: Application`: Protocols in the top layer of the TCP/IP stack specify how a pair of applications
interact when they communicate. Specifications for email exchange, file transfer, web
browsing, telephone services, and video teleconferencing all belong in layer 5.

- __`How Data Passes Through Layers`__ -- Layering is not merely an abstract concept that helps one understand protocols. Instead, protocol implementations follow the layering model by passing the output from a
protocol in one layer to the input of a protocol in the next layer. Furthermore, to
achieve efficiency, rather than copy an entire packet, a pair of protocols in adjacent
layers pass a pointer to the packet. Thus, data passes between layers efficiently.

- __`Headers And Layers`__ -- We will learn that each layer of protocol software performs computations that insure the messages arrive as expected. To perform such computation, protocol software
on the two machines must exchange information. To do so, each layer on the sending
computer prepends extra information onto the packet; the corresponding protocol layer
on the receiving computer removes and uses the extra information.
Additional information added by a protocol is known as a _header_

- __`ISO and the OSI Seven Layer Reference Model`__ -- At the same time the Internet protocols were being developed, two large standards
bodies jointly formed an alternative reference model. They also created a set of internetworking protocols. The organizations are:
  - International Organization for Standardization (ISO)
  - International Telecommunications Union, Telecommunication
Standardization Sector (ITU-T)
  
  > The ISO layering model is known as the Open Systems Interconnection Seven-Layer
Reference Model. Confusion arises in terminology because the acronym for the protocols, OSI, and the acronym for the organization, ISO, are similar.

- __`The Inside Scoop`__ -- Like most standards organizations, ISO and the ITU use a process that accommodates as many viewpoints as possible when creating a standard. As a result, some standards can appear to have been designed by a committee making political compromises
rather than by engineers and scientists. The seven-layer reference model is controversial. It did indeed start as a political compromise.

- __`Remainder of the Text`__ -- The text is divided into five major parts. After a brief introduction, chapters in the
first part introduce network applications and network programming. The second part describes data communications and the transmission of information. It explains how electrical and electromagnetic energy can be used
to carry information across wires or through the air, and shows how data is transmitted. The third part of the text focuses on packet switching and packet technologies. It
explains why computer networks use packets, describes the general format of packets,
examines how packets are encoded for transmission, and shows how each packet is forwarded across a network to its destination. The fourth part of the text covers internetworking and the associated TCP/IP Internet Protocol Suite. The text explains the structure of the Internet and the TCP/IP protocols. It explains the IP addressing scheme, and describes the mapping between Internet
addresses and underlying hardware addresses. It also discusses Internet routing and
routing protocols The fifth part of the text covers a variety of remaining topics that pertain to the
network as a whole instead of individual parts.

<br>
<br>

---

<br>
<br>

# Chapter 2: Internet Trends

- __`Introduction`__ -- This chapter considers how data networking and the Internet have changed since
their inception. The chapter begins with a brief history of the Internet that highlights
some of the early motivations. It describes a shift in emphasis from sharing centralized
facilities to fully distributed information systems.

- __`Resource Sharing`__ -- Early computer networks were designed when computers were large and expensive,
and the main motivation was resource sharing. In the 1960s, the Advanced Research Projects Agency (ARPA†), an agency of the
U.S. Department of Defense, was especially interested in finding ways to share
resources.

- __`Growth Of The Internet,`__ -- In less than 30 years, the Internet has grown from an early research prototype connecting a handful of sites to a global communication system that extends to all countries
of the world

- __`From Resource Sharing To Communication`__ -- As it grew, the Internet changed in two significant ways. First, communication
speeds increased dramatically — a backbone link in the Internet can carry 100,000
times as many bits per second as a backbone link in the original Internet. Second, new
applications arose that appealed to a broad cross-section of society. The second point is
obvious — the Internet is no longer dominated by scientists and engineers, scientific applications, or access to computational resources.

  The availability of high-speed computation and communication technologies shifted the focus of the Internet from resource sharing to
general-purpose communication

- __`From Text To Multimedia`__ -- As the figure indicates, Internet communication initially involved textual data. In
particular, email messages were limited to text displayed in fixed-width font. By the 1990s, computers had color screens capable of displaying graphics, and applications
arose that allowed users to transfer images easily. By the late 1990s, users began sending video clips, and full-motion videos became feasible

  We use the term multimedia to characterize data that contains a combination of
text, graphics, audio, and video. Much of the content available on the Internet now consists of multimedia documents

- __`Recent Trends`__ -- One of the most interesting aspects of the Internet arises from the way that Internet
applications change even though the underlying technology essentially remains the
same. For example see the new areas that are arising but the underlying tech is still the same.
  - High-quality teleconferencing -> Business-to-business communication 
  - Navigation systems -> Military, shipping industry, consumers
  - Sensor networks -> Environment, security, fleet tracking
  - Social networking -> Consumers, volunteer organizations

<br>
<br>

---

<br>
<br>
