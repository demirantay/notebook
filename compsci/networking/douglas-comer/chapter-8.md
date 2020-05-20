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

- __`Introduction`__ -- 

- __`The Motivation For Internetworking`__ -- 

- __`The Concept Of Universal Service`__ -- 

- __`Universal Service In A Heterogeneous World`__ -- 

- __`Internetworking`__ -- 

- __`Physical Network Connection With Routers`__ -- 

- __`Internet Architecture`__ -- 

- __`Achieving Universal Service`__ -- 

- __`A Virtual Network`__ -- 

- __`Protocols For Internetworking`__ -- 

- __`Review Of TCP/IP Layering`__ -- 

- __`Host Computers, Routers, And Protocol Layers`__ -- 

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
