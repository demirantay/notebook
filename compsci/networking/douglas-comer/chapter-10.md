# Chapter 27: Internet Routing and Routing Protocols

- __`Introduction`__ -- Previous chapters describe the fundamental concept of datagram forwarding, and
explain how IP uses a forwarding table to select a next-hop for each datagram. This
chapter explores an important aspect of internetworking technology: the propagation of
routing information that is used to create and update forwarding tables. The chapter
discusses how forwarding tables are built, and explains how routing software updates
the tables, as needed.

- __`Static Vs. Dynamic Routing`__ -- IP routing can be partitioned into two broad categories: `Static routing` or `Dynamic routing`

  The term static routing characterizes an approach that creates a forwarding table when
the system starts and does not change entries unless an administrator manually alters
them. In contrast, the term dynamic routing characterizes an approach in which route propagation software runs on the system and continuously updates the forwarding table to insure that each datagram follows an optimum route.

- __`Static Routing In Hosts And A Default Route`__ -- Static routing is straightforward, easy to specify, and does not require extra routing
software. It does not consume bandwidth, and no CPU cycles are required to propagate
routing information. However, static routing is relatively inflexible; it cannot accommodate network failures or changes in topology.

  Where is static routing used? Most hosts use static routing, especially in cases
where the host has one network connection and a single router connects the network to
the rest of the Internet

- __`Dynamic Routing And Routers`__ -- Can a router in the Internet use static routing the same way a host does? Although
cases exist where a router uses static routing, most routers use dynamic routing

  Each router runs routing software that learns about destinations other
routers can reach, and informs other routers about destinations that it
can reach. The routing software uses incoming information to update
the local forwarding table continuously

- __`Routing In The Global Internet`__ -- So far, we have described routing for the most trivial connectivity (i.e., situations
that involve only a few routers). This section looks at a broader issue: routing in the
global Internet. 

  We said that a route propagation protocol allows one router to exchange routing information with another. However, such a scheme cannot scale to the entire Internet —
if a router in the Internet attempted to exchange routing information with all other
routers, the resulting traffic would overwhelm the core of the Internet. To limit routing
traffic, the Internet uses a routing hierarchy. Routers and networks in the Internet are
divided into groups. All routers within a group exchange routing information. Then, at
least one router (possibly more) in each group summarizes the information before passing it to other groups

- __`Autonomous System Concept`__ -- To capture the concept of groups of routers, we use the term Autonomous System
(AS) The choice of autonomous system size can be made for economic, technical, or administrative reasons.

  to sum up: The Internet is divided into a set of autonomous systems; routers
within an autonomous system exchange routing information, which is
then summarized before being passed to another group.

- __`The Two Types Of Internet Routing Protocols`__ -- Now that we understand the autonomous system concept, Internet routing can be
defined more precisely. All Internet routing protocols fall into one of two categories:
  - Interior Gateway Protocols (IGPs)
  - Exterior Gateway Protocols (EGPs)
  
  _interior gateway protocol_: The routers within an autonomous system use an Interior Gateway Protocol (IGP)
to exchange routing information. Several IGPs are available; each autonomous system
is free to choose its own IGP

  _exterior gateway protocol_: A router in one autonomous system uses an Exterior Gateway Protocol (EGP) to
exchange routing information with a router in another autonomous system. EGPs are
usually more complex to install and operate than IGPs, but EGPs offer more flexibility
and lower overhead (i.e., less traffic).

  Within an autonomous system, IGP software uses a routing metric to
choose an optimal path to each destination. EGP software finds a
path to each destination, but cannot find an optimal path because it
cannot compare routing metrics from multiple autonomous systems.

- __`The Border Gateway Protocol (BGP)`__ -- One particular protocol has emerged as the most widely used Exterior Gateway
Protocol in the Internet. Known as the Border Gateway Protocol (BGP), the protocol
has survived three major revisions. Version 4 is the current standard, and is officially
abbreviated BGP-4.

  The Border Gateway Protocol (BGP) is the Exterior Gateway Protocol that Tier-1 ISPs use to exchange routing information among autonomous systems at the center of the Internet

- __`The Routing Information Protocol (RIP)`__ -- The Routing Information Protocol (RIP) was among the first Interior Gateway Protocols used in the Internet. The chief advantage of RIP is simplicity. RIP requires little configuration — a
manager merely starts RIP running on each router in the organization and allows the
routers to broadcast messages to one anothe

- __`RIP Packet Format`__ -- RIP is an Interior Gateway Protocol that uses a distance vector algorithm to propagate routing information

- __`The Open Shortest Path First Protocol (OSPF)`__ -- The RIP message format illustrates a disadvantage of distance-vector protocols: the
size of a message is proportional to the number of networks that can be reached. Sending RIP messages introduces delay, and processing RIP messages consumes many CPU
cycles. The delay means that route changes propagate slowly, one router at a time.
Thus, although RIP works well among a few routers, it does not scale well.

  To satisfy demand for a routing protocol that can scale to large organizations, the
IETF devised an IGP known as the Open Shortest Path First Protocol (OSPF). The
name is derived from the use of Dijkstra’s SPF algorithm which computes shortest
paths.

- __`OSPF Areas`__ -- One particular feature that makes OSPF more complex than other routing protocols
also makes it more powerful: hierarchical routing. To achieve a hierarchy, OSPF allows
an autonomous system to be partitioned for routing purposes. That is, a manager can
divide routers and networks in an autonomous system into subsets that OSPF calls
areas. When OSPF runs, routers within a given area exchange linkstate messages periodically

- __`Intermediate System - Intermediate System (IS-IS)`__ -- Originally designed by Digital Equipment Corporation to be part of DECNET V,
the IS-IS (Intermediate System to Intermediate System†) is an IGP. IS-IS was created
around the same time as OSPF, and the two protocols are similar in many ways. Both
use the link-state approach and employ Dijkstra’s algorithm to compute shortest paths.

  When the protocols were initially invented, OSPF’s openness and dedication to IP
made it much more popular than IS-IS. In fact, IS-IS was almost completely forgotten.
As the years progressed, OSPF’s popularity encouraged the IETF to add additional
features. Ironically, in the early 2000’s, ten years after the protocols were designed,
several things changed to give IS-IS a second chance.

- __`Multicast Routing`__ -- Membership in an IP multicast group is dynamic: a computer can join
or leave a group at any time. Group membership defines a set of receivers; an arbitrary application can send a datagram to the group,
even if the application is not a group member.

  The dynamic characteristics of Internet multicast make the problem of
multicast route propagation difficult. Although many protocols have
been proposed, the Internet does not currently have an Internet-wide
multicast routing facility.

<br>
<br>

---

<br>
<br>

# Chapter 28: Network Performance (QoS and DiffServ)

- __`Introduction`__ -- This chapter continues the discussion by considering the topic of network performance. The chapter discusses quantitative measures of networks, and explains how protocols and packet forwarding technologies can implement mechanisms that provide
priority for some traffic.

- __`Measures Of Performance`__ -- Informally, we use the term speed to describe network performance, and refer to
low-speed or high-speed networks. However, such definitions are inadequate because
network technologies change so rapidly that a network classified as “high speed” can
become medium or low speed in as little as three or four years

  Lets see some terminology:
  - _Latency (delay)_ -- The time required to transfer data across
a network
  - _Throughput (capacity)_ -- The amount of data that can be transferred
per unit time
  - _Jitter (variability)_ -- The changes in delay that occur and the
duration of the changes

- __`Latency Or Delay`__ -- The first property of networks that can be measured quantitatively is latency or delay. Latency specifies how long it takes for data to travel across a network from one
computer to another; it is measured in fractions of seconds.

  Thus, engineers usually report both the
maximum and average delays, and divide a delay into several constituent parts.
  - Propagation Delay -- The time required for a signal to travel across
a transmission medium
  - Access Delay -- The time needed to obtain access to a
transmission medium (e.g., a cable)
  - Switching Delay -- The time required to forward a packet 
  - Queuing Delay -- The time a packet spends in the memory of a
switch or router waiting to be selected for
transmission
  - Server Delay -- The time required for a server to respond to a
request and send a response

- __`Throughput, Capacity, And Goodput`__ -- A second fundamental property of networks that can be measured quantitatively is
the capacity of a network, which is often expressed as the maximum throughput that the
network can sustain. Throughput is a measure of the rate at which data can be sent
through the network, specified in bits per second (bps). Most data communication networks offer a throughput rate of more than 1 Mbps, and the highest-speed networks
operate faster than 1 Gbps.

  Users do not care about the capacity of the underlying hardware — they are only
interested in the rate at which data can be transferred. Users typically assess the effective data rate that an application achieves by measuring the amount of data transferred
per unit time; the term goodput is sometimes used to describe the measure.

- __`Understanding Throughput And Delay`__ -- In fact, throughput is a measure of capacity, not speed. To understand the relationship, imagine a network to be a road between two locations and packets traveling across
the network to be cars traveling down the road. The throughput determines how many
cars can enter the road each second, and the propagation delay determines how long it
takes a single car to travel the road from one town to another.

  The analogy to a road helps explain the aphorism: adding more lanes to a road will
increase the number of cars that can enter the road per unit of time, but will not decrease the total time required to traverse the road. Networks follow the same pattern:
adding more parallel transmission paths will increase the throughput of the network, but
the propagation delay, which depends on the distance spanned, will not decrease.

- __`Jitter`__ -- A third measure of networks is becoming important as networks are used for the
transmission of real-time voice and video. The measure, which is known as a network’s
jitter, assesses the variance in delay. Two networks can have the same average delay,
but different values of jitter.

  Transmission of voice or video over the Internet takes the second approach:
although the underlying network may have substantial jitter, voice and video applications rely on real-time protocols to compensate for jitter

- __`The Relationship Between Delay And Throughput`__ -- In theory, the delay and throughput of a network are independent. In practice,
however, they can be related. To understand why, think of the road analogy discussed
above. If cars enter the road at even time intervals, cars traveling along the road at uniform speed are spaced at uniform intervals. If a car slows down for any reason (e.g., at
an intersection), others behind it will slow down as well, causing temporary traffic
congestion. Cars that enter the road when congestion is occurring will experience
longer delays than cars traveling on an uncongested road

  Throughput and delay are not completely independent. As traffic in a
computer network increases, delays increase; a network that operates
at close to 100% of its throughput capacity experiences severe delay

- __`Measuring Delay, Throughput, And Jitter`__ -- The techniques used to measure throughput and jitter are relatively straightforward.
To assess throughput, a sender transfers a large volume of data. A receiver records the
time from the start of data arriving until all data has arrived, and calculates the
throughput as the amount of data sent per unit of time. The technique for measuring
jitter is known as a packet train: a sender emits a series of packets with a small, fixed
delay between packets. Typically, packets in the train are sent back-to-back. A receiver records the time at which each packet arrives, and uses the sequence of times to
compute the differences in delay.

  The second point explains why an accurate measure of network performance can
be difficult to obtain: conditions change rapidly. For example, consider a shared network. If only one host is sending data, the host will enjoy low delay, high throughput,
and low jitter. As other hosts begin to use the network, utilization increases, which will
increase delay and jitter and decrease throughput. Furthermore, because conditions
change rapidly, delays can vary widely in as little as a second

  Unlike voice telephone traffic, data traffic is bursty. Data traffic is
said to be self-similar because aggregates of data traffic exhibit the
same pattern of burstiness

- __`Quality Of Service (QoS)`__ -- The counterpart of network measurement is network provisioning: designing a network to provide a specific level of service. The remainder of the chapter considers
mechanisms that can be used to implement service guarantees. Broadly, the topic is
known as Quality of Service (QoS).

- __`Fine-Grain And Coarse-Grain QoS`__ -- How can a provider specify QoS guarantees, and what technologies does a provider
use to enforce QoS?
  - Fine-Grain -- A provider allows a customer to state specific QoS
requirements for a given instance of communication
  - Coarse-Grain --  A provider specifies a few broad classes of service
that are each suitable for one type of traffic

  Both fine-grain and coarse-grain QoS have been studied; fine-grain efforts have
generally been abandoned. ATM defined categories of service, and the acronyms are
still used: Constant, Variable, Available, and Unspecified Bit Rate (CBR, VBR, ABR,
and UBR).

- __`Internet QoS Technologies`__ -- The IETF has designed a series of technologies and protocols related to QoS.
Three significant efforts are:
  - RSVP and COPS
  - DiffServ
  - MPLS
  
  The IETF defined RSVP and COPS as part of the IntServ effort; when emphasis
shifted away from fine-grain QoS, the IETF defined DiffServ. The IETF also defined
MPLS as a traffic engineering technology. QoS parameters can be associated with each
MPLS tunnel, meaning that once a datagram has been classified, its MPLS association
defines its QoS parameters.

<br>
<br>

---

<br>
<br>

# Chapter 29: Multimedia and IP Telephony (VoIP)

- __`Introduction`__ -- This chapter continues the discussion by examining the transfer of multimedia over
the Internet. The chapter examines how multimedia can be sent over a best-effort communication mechanism, describes a general-purpose protocol for real-time traffic, and
considers the transmission of voice telephone calls in detail.

- __`Real-Time Data Transmission And Best Effort Delivery`__ -- We use the term multimedia to refer to data that contains audio or video, and may
include text. The phrase real-time multimedia refers to multimedia data that must be
reproduced at exactly the same rate that it was captured (e.g., a television news program
that includes audio and video of an actual event).

  Instead of requiring the underlying networks to handle real-time transmission, the
Internet uses additional protocol support. Interestingly, the most significant problem to
be handled is jitter, not packet loss

  The important point is: Unlike conventional transport protocols, a protocol that transfers
real-time data only handles the problem of jitter, and does not retransmit lost packets. If they did the video and voice would not match because of the jitter one ofthe would fall behind.

- __`Delayed Playback And Jitter Buffers`__ -- To overcome jitter and achieve smooth playback of real-time data, two chief techniques are employed:
  - Timestamps. A sender provides a timestamp for each piece of data.
A receiver uses the timestamps to handle out-of-order packets and
to display the data in the correct time sequence.
  - Jitter Buffer. To accommodate jitter (i.e., small variances in delay), a receiver buffers data and delays playback

- __`Real-time Transport Protocol (RTP)`__ -- In the Internet protocol suite, the Real-time Transport Protocol (RTP) provides the
mechanism used to transmit real-time data across the Internet. The term Transport is a
misnomer because RTP sits above the transport layer. Thus, despite the name, one
should think of RTP as a transfer protocol.

  RTP does not ensure timely delivery of data, and it does not include a jitter buffer
or playback mechanism. Instead, it provides three items in each packet that permit a receiver to implement a jitter buffer:
  - A sequence number that allows a receiver to place incoming packets in the correct order and to detect missing packet
  - A timestamp that allows a receiver to play the data in the packet at
the correct time in the multimedia stream
  - A series of source identifiers that allow a receiver to know the
source(s) of the data

- __`RTP Encapsulation`__ -- RTP uses UDP for message transport. Thus, each RTP message is encapsulated in
a UDP datagram for transmission over the Internet. Because RTP uses UDP encapsulation, the resulting messages can be sent via
broadcast or multicast. Multicast is especially useful for delivery of entertainment programming that appeals to a large audience.

- __`IP Telephony`__ -- The term IP telephony† or Voice over IP (VoIP) is used to describe one of the
most widespread multimedia applications. Telephone companies around the world are
replacing traditional telephone switches with IP routers. The motivation is economic:
routers cost much less than traditional telephone switches. Enterprises have also begun
to use IP telehones for economic reasons: sending both data and voice in IP datagrams
lowers cost because the underlying network infrastructure is shared — a single set of
equipment, wiring, and network connections suffices for all communication, including
telephone calls.

  The basic idea behind IP telephony is straightforward: continuously sample audio,
convert each sample to digital form, send the resulting digitized stream across an IP network in packets, and convert the stream back to analog for playback.

- __`Signaling And VoIP Signaling Standards`__ -- Two groups have created standards for IP telephony: the International Telecommunications Union (ITU), which controls telephone standards, and the Internet Engineering Task Force (IETF), which controls TCP/IP standards. Fortunately, both groups agree on the basics for the encoding and transmission of
audio:
  - Audio is encoded using Pulse Code Modulation (PCM)
  - RTP is used to transfer the digitized audio
  
  The main complexity of IP telephony (and the reason that multiple standards have
been proposed) lies in call setup and call management. In telephone terminology, the
process of establishing and terminating a call is known as signaling, and includes mapping a phone number to a location, finding a route to the called party, and handling other details such as call forwarding. The mechanism used in the traditional telephone system to handle call management is known as Signaling System 7 (SS7).

- __`Components Of An IP Telephone System`__ -- 
  - IP telephone -- Operates like a conventional telephone, but
uses IP to send digitized voice
  - Media Gateway Controller -- Provides control and coordination between IP telephones for services such as call setupcall termination, and call forwarding
  - Media Gateway -- Provides a connection between two networks that use different encodings, and translates as a call passes between them
  - Signaling Gateway -- Connects to two networks that use different signaling mechanisms, and translates call management requests and responses
  
  An IP telephone connects to a network, uses IP for all communication, and offers a
traditional telephone interface that allows a user to place or receive telephone calls. An
IP phone can be a stand-alone hardware unit (i.e., a conventional telephone), or can consist of a computer with a microphone, speaker, and IP telephony software. The connection between an IP telephone and the rest of the world can consist of a wired or wireless
network (e.g., Ethernet or 802.11b).

  A Media Gateway Controller, which is also known as a Gatekeeper or Softswitch,
provides overall control and coordination between a pair of IP telephones, allowing a
caller to locate a callee or access services such as call forwarding.

  A Media Gateway provides translation of audio as a call passes across the boundary between an IP network and the PSTN or the boundary between two IP networks
that use different encodings. For example, a media gateway on the boundary between
the PSTN and the Internet moves digitized audio between the TDM encoding used on a
conventional voice circuit and the packet encoding used on the Internet.

  A Signaling Gateway also spans the boundary between a pair of disparate networks, and provides translation of signaling operations, allowing either side to initiate a
call (e.g., to allow an IP telephone on the Internet to place a call to a phone on the
PSTN). A media gateway controller coordinates the operation of the media and signaling gateways.

- __`Telephone Number Mapping And Routing`__ --  How should IP telephone users be named and located? The PSTN follows ITU
standard E.164 for telephone numbers, and SIP uses IP addresses. The problem of locating users is complicated because multiple types of networks may be involved The IETF has proposed two
protocols that correspond to the mappings needed for the two subproblems:
  - ENUM — converts a telephone number to a URI
  - TRIP — finds a user in an integrated network
  
  Two additional IETF protocols provide support functions. ENUM uses the
Domain Name System to map an E.164 telephone number into a Uniform Resource
Identifier (usually a SIP URI). TRIP provides routing among IP telephone administrative domains; a SIP location server can use TRIP to inform other location servers about
gateways that form network egress points.

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
