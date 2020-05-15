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

<br>
<br>

---

<br>
<br>

# Chapter 17: LAN Extensions: Fiber Modems, Repeaters, Bridges and Switches

<br>
<br>

---

<br>
<br>

# Chapter 18: WAN Technologies and Dynamic Routing

<br>
<br>

---

<br>
<br>

# Chapter 19: Networking Technologies Past and Present

<br>
<br>

---

<br>
<br>

# Chapter 20: Internetworking: Concepts Architecture and Protocols

<br>
<br>

---

<br>
<br>

# Chapter 21: IP:Internet Adressing

<br>
<br>

---

<br>
<br>

# Chapter 22: Datagram Forwarding

<br>
<br>

---

<br>
<br>

# Chapter 23: Support Protocols and Technologies

<br>
<br>

---

<br>
<br>

# Chapter 24: The Future IP (IPv6)

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
