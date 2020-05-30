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

- __`Routes And Data Traffic`__ --

- __`The Border Gateway Protocol (BGP)`__ --

- __`The Routing Information Protocol (RIP)`__ --

- __`RIP Packet Format`__ --

- __`The Open Shortest Path First Protocol (OSPF)`__ --

- __`An Example OSPF Graph`__ --

- __`OSPF Areas`__ --

- __`Intermediate System - Intermediate System (IS-IS)`__ --

- __`Multicast Routing`__ -- 

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
