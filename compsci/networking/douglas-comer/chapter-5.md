# Chapter 8: Reliablity and Channel Coding

- __`Introduction`__ -- Chapters in this part of the text each present one aspect of data communications,
the foundation for all computer networking. The previous chapter discusses transmission media, and points out the problem of electromagnetic noise. This chapter continues the discussion by examining errors that can occur during transmission and techniques that can be used to control errors.

- __`The Three Main Sources Of Transmission Errors`__ -- There are three main
categories of transmission errors:
  - Interference. As Chapter 7 explains, electromagnetic radiation
emitted from devices such as electric motors and background cosmic radiation cause noise that can disturb radio transmissions and
signals traveling across wires.
  - Distortion. All physical systems distort signals. As a pulse travels
along an optical fiber, the pulse disperses. Wires have properties
of capacitance and inductance that block signals at some frequencies while admitting signals at other frequencies. Simply placing a
wire near a large metal object can change the set of frequencies
that can pass through the wire
  - Attenuation. As a signal passes across a medium, the signal becomes weaker
  
  Shannon’s Theorem suggests one way to reduce errors: increase the signal-to-noise
ratio (either by increasing the signal or lowering noise).

  Although transmission errors are inevitable, error detection mechanisms add overhead. Therefore, a designer must choose exactly which
error detection and compensation mechanisms will be used.

- __`Effect Of Transmission Errors On Data`__ -- Instead of examining physics and the exact cause of transmission errors, data communications focuses on the effect of errors on data

   For example, extremely short duration interference, called a spike, is often
the cause of a single bit error. Longer duration interference or distortion can produce
burst errors. Sometimes a signal is neither clearly 1 nor clearly 0, but falls in an ambiguous region, which is known as an erasure. ... etc.

- __`Two Strategies For Handling Channel Errors`__ -- A variety of mathematical techniques have been developed that overcome data errors and increase reliability. Known collectively as channel coding, the techniques can
be divided into two broad categories:
  - Forward Error Correction (FEC) mechanisms
  - Automatic Repeat reQuest (ARQ) mechanisms

- __`Block And Convolutional Error Codes`__ -- The two types of forward error correction techniques satisfy separate needs:
  - Block Error Codes. A block code divides the data to be sent into a
set of blocks, and attaches extra information known as redundancy
to each block
  - Convolutional Error Codes. A convolutional code treats data as a
series of bits, and computes a code over a continuous series. Thus,
the code computed for a set of bits depends on the current input
and some of the previous bits in the stream

  > convolutional codes often have a higher
probability of detecting problems.

- __`An Example Block Error Code: Single Parity Checking`__ -- Single parity checking (SPC) is a basic form of channel coding in
which a sender adds an extra bit to each byte to make an even (or
odd) number of 1 bits and a receiver verifies that the incoming data
has the correct number of 1 bits.

  Single parity checking is a weak form of channel coding that can detect errors, but
cannot correct them. 

- __`The Mathematics Of Block Error Codes And (n,k) Notation`__ -- Observe that forward error correction takes as input a set of messages and inserts
additional bits to produce an encoded version. Mathematically, we define the set of all
possible messages to be a set of datawords, and define the set of all possible encoded
versions to be a set of codewords.

  An ideal channel coding scheme is one where any change to bits in a
valid codeword produces an invalid combination.

- __`Hamming Distance: A Measure Of A Code’s Strength`__ -- No channel coding scheme is ideal — changing enough bits will always transform
to a valid codeword. Thus, for a practical scheme, the question becomes, “what is the
minimum number of bits of a valid codeword that must be changed to produce another
valid codeword?”
To answer the question, engineers use a measure known as the Hamming distance,
named after a theorist at Bell Laboratories who was a pioneer in the field of information
theory and channel coding

- __`The Hamming Distance Among Strings In A Codebook`__ -- To find the minimum number of bit changes that can transform a valid
codeword into another valid codeword, compute the minimum Hamming distance between all pairs in the codebook

- __`Error Correction With Row And Column (RAC) Parity`__ -- A Row And Column (RAC) encoding allows a receiver to correct any
single bit error and to detect errors in which two or three bits are
changed.

- __`The 16-Bit Checksum Used In The Internet`__ -- A particular channel coding scheme plays a key role in the Internet. Known as the
Internet checksum, the code consists of a 16-bit 1s complement checksum. The Internet
checksum does not impose a fixed size on a dataword. Instead, the algorithm allows a
message to be arbitrarily long, and computes a checksum over the entire message

  To compute a checksum, a sender adds the numeric values of the 16-bit integers,
and transmits the result. To validate the message, a receiver performs the same computation.

- __`Automatic Repeat reQuest (ARQ) Mechanisms`__ -- Recall that an ARQ approach to error correct requires a sender and receiver to
communicate metainformation. That is, whenever one side sends a message to another,
the receiving side sends a short acknowledgement message back. For example, if A
sends a message to B, B sends an acknowledgement back to A. Once it receives an acknowledgement, A knows that the message arrived correctly. If no acknowledgement is
received after T time units, A assumes the message was lost and retransmits a copy

<br>
<br>

---

<br>
<br>

# Chapter 9: Transmission Modes

- __`Introduction`__ --  This chapter continues the discussion by focusing on the ways data is
transmitted. The chapter introduces common terminology, explains the advantages and
disadvantages of parallelism, and discusses the important concepts of synchronous and
asynchronous communication

- __`A Taxonomy Of Transmission Modes`__ -- We use the term transmission mode to refer to the manner in which data is sent
over the underlying medium. Transmission modes can be divided into two fundamental
categories:
  - Serial — one bit is sent at a time (sync, async)
  - Parallel — multiple bits are sent at the same time

- __`Parallel Transmission`__ -- The term parallel transmission refers to a transmission mechanism that transfers
multiple data bits at the same time over separate media. In general, parallel transmission is used with a wired medium that uses multiple, independent wires. 

  A parallel mode of transmission has two chief advantages:
  - High speed. 
  - Match to underlying hardware (underlying hardware, circuits are parallel too)

- __`Serial Transmission`__ -- 

- __`Transmission Order: Bits And Bytes`__ -- 

- __`Timing Of Serial Transmission`__ -- 

- __`Asynchronous Transmission`__ -- 

- __`RS-232 Asynchronous Character Transmission`__ -- 

- __`Synchronous Transmission`__ -- 

- __`Bytes, Blocks, And Frames`__ -- 

- __`Isochronous Transmission`__ -- 

- __`Simplex, Half-Duplex, and Full-Duplex Transmission`__ -- 

- __`DCE and DTE Equipment`__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 10: Modulation and Modems

<br>
<br>

---

<br>
<br>

# Chapter 11: Multiplexing and Demultiplexing (Channelzation)

<br>
<br>

---

<br>
<br>

# Chapter 12: Access and Interconnection Techonologies

<br>
<br>

---

<br>
<br>

# Chapter 13: Local Area Netowkrs:Packets, Frames and Topologies

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
