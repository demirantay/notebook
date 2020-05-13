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

- __`Introduction`__ --

- __`Internet Access Technology: Upstream And Downstream`__ --

- __`Narrowband And Broadband Access Technologies`__ --

- __`The Local Loop And ISDN`__ --

- __`Digital Subscriber Line (DSL) Technologies`__ --

- __`Local Loop Characteristics And Adaptation`__ --

- __`The Data Rate Of ADSL`__ --

- __`ADSL Installation And Splitters`__ --

- __`Cable Modem Technologies`__ --

- __`The Data Rate Of Cable Modems`__ --

- __`Cable Modem Installation`__ --

- __`Hybrid Fiber Coax`__ --

- __`Access Technologies That Employ Optical Fiber`__ --

- __`Head-End And Tail-End Modem Terminology`__ --

- __`Wireless Access Technologies`__ --

- __`High-Capacity Connections At The Internet Core`__ --

- __`Circuit Termination, DSU / CSU, and NIU`__ --

- __`Telephone Standards For Digital Circuits`__ --

- __`DS Terminology And Data Rates`__ --

- __`Highest Capacity Circuits (STS Standards)`__ --

- __`Optical Carrier Standards`__ --

- __`The C Suffix`__ --

- __`Synchronous Optical NETwork (SONET)`__ --

<br>
<br>

---

<br>
<br>

# Chapter 13: Local Area Networks:Packets, Frames and Topologies

<br>
<br>

---

<br>
<br>

# Chapter 14: The IEEE MAC Sub-Layer 

<br>
<br>

---

<br>
<br>

# Chapter 15: Wired LAN Techonology (Ethernet And 802.3)

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
