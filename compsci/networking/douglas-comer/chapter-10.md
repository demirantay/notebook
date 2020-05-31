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

- __`Understanding Throughput And Delay`__ --

- __`Jitter`__ --

- __`The Relationship Between Delay And Throughput`__ --

- __`Measuring Delay, Throughput, And Jitter`__ --

- __`Passive Measurement, Small Packets, And NetFlow`__ --

- __`Quality Of Service (QoS)`__ --

- __`Fine-Grain And Coarse-Grain QoS`__ --

- __`Implementation Of QoS`__ --

- __`Internet QoS Technologies`__ --

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
