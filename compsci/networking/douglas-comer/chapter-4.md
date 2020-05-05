# Chapter 6: Information Sources and Signals

- __`Introduction`__ -- The previous chapter begins the study of data communications, the foundation of
all networking. The chapter introduces the topic, gives a conceptual framework for data
communications, identifies the important aspects, and explains how the aspects fit together.

- __`Information Sources`__ -- Recall that a communication system accepts input from one or more sources and
delivers the information from a given source to a specified destination. For a network,
such as the global Internet, the source and destination of information are a pair of application programs that generate and consume data. However, data communications theory
concentrates on low-level communications systems, and applies to arbitrary sources of
information. 

  Throughout the study of data communications, it is important to
remember that the source of information can be arbitrary and includes devices other than computers.

- __`Analog And Digital Signals`__ -- Data communications deals with two types of information: analog and digital. An
analog signal is characterized by a continuous mathematical function — when the input
changes from one value to the next, it does so by moving through all possible intermediate values. In contrast, a digital signal has a fixed set of valid levels, and each
change consists of an instantaneous move from one valid level to another.

- __`Periodic And Aperiodic Signals`__ -- Signals are broadly classified as periodic or aperiodic (sometimes called nonperiodic), depending on whether they repeat

- __`Sine Waves And Signal Characteristics,`__ -- We will see that much of the analysis in data communications involves the use of
sinusoidal trigonometric functions, especially sine, which is usually abbreviated sin.
Sine waves are especially important in information sources because natural phenomena
produce sine waves  For example, when a microphone picks up an audible tone, the
output is a sine wave.

  There are four important characteristics of signals that relate to sine waves:
  - Frequency: the number of oscillations per unit time (usually seconds)
  - Amplitude: the difference between the maximum and minimum signal heights
  - Phase: how far the start of the sine wave is shifted from a reference time
  - Wavelength: the length of a cycle as a signal propagates across a medium
  
  To clarify high frequencies, engineers express time in fractions of a second or express frequency in units such as megahertz
  
  |Time Unit|Value|Frequency Unit|Value|
  |--|--|--|--|
  |Seconds (s) |10^0 seconds |Hertz (Hz) |100 Hz|
  |Milliseconds (ms)| 10^-3 seconds| Kilohertz (KHz) |103 Hz|
  |Microseconds (μs) |10^-6 seconds| Megahertz (MHz)| 106 Hz|
  |Nanoseconds (ns)| 10^-9 seconds| Gigahertz (GHz)| 109 Hz|
  |Picoseconds (ps)| 10-12 seconds| Terahertz (THz)| 1012 Hz|

- __`Composite Signals`__ -- Usually signals are not simple sine functions in a graph, you usaully add all of the simple sines together and get a one big compsite signals.

- __`The Importance Of Composite Signals And Sine Functions`__ -- Why does data communications seem obsessed with sine functions and composite
signals? The analysis by Fourier shows that if the composite signal is periodic, the constituent parts will also be periodic. Thus, we will see that most data communications systems use composite signals to carry information: a composite signal is created at the
sending end, and the receiver decomposes the signal into the original simple components. The point is:

  A mathematical method discovered by Fourier allows a receiver to
decompose a composite signal into constituent parts

- __`Time And Frequency Domain Representations`__ -- Because they are fundamental, composite signals have been studied extensively,
and several methods have been invented to represent them (dot graph, set graph ... etc)

- __`Bandwidth Of An Analog Signal`__ -- Almost everyone has heard of “network bandwidth”, and understands that a network with high bandwidth is desirable. We will discuss the definition of network
bandwidth later. For now, we will explore a related concept, analog bandwidth.

  We define the bandwidth of an analog signal to be the difference between the
highest and lowest frequencies of the constituent parts (i.e., the highest and lowest frequencies obtained by Fourier analysis). In the trivial example of Figure 6.5c, Fourier
analysis produces signals of 1 and 2 Hertz, which means the bandwidth is the difference, or 1 Hertz.

- __`Digital Signals And Signal Levels`__ -- We said in addition to being represented by an analog signal, information can also
be represented by a digital signal. We further defined a signal to be digital if a fixed
set of valid levels has been chosen and at any time, the signal is at one of the valid levels. Some systems use voltage to represent digital values by making a positive voltage
correspond to a logical one, and zero voltage correspond to a logical zero. For example,
+5 volts can be used for a logical one and 0 volts for a logical zero.

  If only two levels of voltage are used, each level corresponds to one data bit (0 or
1). However, some physical transmission mechanisms can support more than two signal levels. When multiple digital levels are available, each level can represent multiple
bits. For example, consider a system that uses four levels of voltage: -5 volts, -2 volts,
+2 volts, and +5 volts. Each level can correspond to two bits of data

  the chief advantage of using multiple signal levels arises
from the ability to represent more than one bit at a time. In Figure 6.8b, for example,
-5 volts represents the two-bit sequence 00, -2 volts represents 01, +2 volts represents
10, and +5 volts represents 11.

- __`Baud And Bits Per Second`__ -- How much data can be sent in a given time? The answer depends on two aspects
of the communication system. As we have seen, the rate at which data can be sent
depends on the number of signal levels. Second aspect is that increasing the data that is being sent at a given time.

  As with signal levels, the hardware in a practical system places limits on how short
the time can be — Interestingly, the accepted measure of a communication system does not specify a length of time. Instead, engineers measure the inverse: how many times the signal can change per second, which is defined as the baud.
For example, if a system requires the signal to remain at a given level for .001 seconds,
we say that the system operates at 1000 baud.

  The key idea is that both baud and the number of signal levels control the bit rate.
If a system with two signal levels operates at 1000 baud, the system can transfer exactly
1000 bits per second. However, if a system that operates at 1000 baud has four signal
levels, the system can transfer 2000 bits per second (because four signal levels can
represent two bits)

- __`Converting A Digital Signal To Analog`__ -- Engineers adopt a compromise: conversion of a signal from digital to analog is approximate. That is, engineers build equipment to generate analog waves that closely approximate the digital signal. Approximation involves building a composite signal from
only a few sine waves. By choosing sine waves that are the correct multiples of the
digital signal frequency, as few as three can be used. The exact details are beyond the
scope of this text

- __`The Bandwidth Of A Digital Signal`__ -- According to the definition of bandwidth, a digital signal has infinite
bandwidth because Fourier analysis of a digital signal produces an
infinite set of sine waves with frequencies that grow to infinity. But in a analog signal it is the difference between highest and lowest.

- __`Synchronization And Agreement About Signals`__ -- Our examples leave out many of the subtle details involved in creating a viable
communication system. For example, to guarantee that the sender and receiver agree on
the amount of time allocated to each element of a signal, the electronics at both ends of
a physical medium must have circuitry to measure time precisely. That is, if one end
transmits a signal with 109 elements per second, the other end must expect exactly 109
elements per second. At slow speeds, making both ends agree is trivial. However,
building electronic systems that agree at the high speeds used in modern networks is extremely difficult

- __`Line Coding`__ -- Several techniques have been invented that can help avoid synchronization errors.
In general, there are two broad approaches. In one approach, before it transmits data,
the sender transmits a known pattern of bits, typically a set of alternating 0s and 1s, that
allows the receiver to synchronize. In the other approach, data is represented by the
signal in such a way that there can be no confusion about the meaning. We use the
term line coding to describe the way data is encoded in a signal.

  A variety of line coding techniques are available that differ in how
they handle synchronization as well as other properties such as the
bandwidth used.

- __`Manchester Encoding Used In Computer Networks`__ -- To understand Manchester Encoding, it is important to know that detecting a transition in signal level is easier than measuring the signal level. The fact, which arises
from the way hardware works, explains why the Manchester Encoding uses transitions
rather than levels to define bits

- __`Converting An Analog Signal To Digital`__ -- Many sources of information are analog, which means they must be converted to
digital form for further processing (e.g., before they can be encrypted). There are two
basic approaches:
  - Pulse code modulation
  - Delta modulation
  
  Pulse code modulation (PCM†) refers to a technique where the level of an analog
signal is measured repeatedly at fixed time intervals and converted to digital form

  Each measurement is known as a sample, which explains why the first stage is
known as sampling. After it has been recorded, a sample is quantized by converting it
into a small integer value which is then encoded into a specific format

  The chief alternative to pulse code modulation is known as delta modulation. Delta modulation also takes samples. However, instead of sending a quantization for each
sample, delta modulation sends one quantization value followed by a string of values
that give the difference between the previous value and the current value. The idea is
that transmitting differences requires fewer bits than transmitting full values, especially
if the signal does not vary rapidly. The main tradeoff with delta modulation arises from
the effect of an error — if any item in the sequence is lost or damaged, all successive
values will be misinterpreted. Thus, communication systems that expect data values to
be lost or changed during transmission usually use pulse code modulation (PCM).

- __`The Nyquist Theorem And Sampling Rate`__ -- Whether pulse code or delta modulation is used, the analog signal must be sampled. How frequently should an analog signal be sampled? A mathematician named Nyquist discovered the answer to the question of how
much sampling is required
  ```
  sampling rate = 2 × f max
  ```
  where f max is the highest frequency in the composite signal. so bsically  sample a
signal at least twice as fast as the highest frequency that must be preserved.

- __`Encoding And Data Compression`__ -- We use the term data compression to refer to a technique that reduces the number
of bits required to represent data. Data compression is especially relevant to a communication system because reducing the number of bits used to represent data reduces the
time required for transmission. That is, a communication system can be optimized by
compressing data before transmission. 

  Compression is lossy or lossless. Lossy compression is most appropriate for images, audio, or video that will be viewed by humans because loss can be controlled to
keep changes below the threshold of human perception. Lossless compression is most
appropriate for documents or data that must be preserved exactlyWe will see this in later chapters. But it is good to mention it here.

<br>
<br>

---

<br>
<br>


# Chapter 7: Transmission Media

- __`Introduction`__ --

- __`Guided And Unguided Transmission`__ --

- __`A Taxonomy By Forms Of Energy`__ --

- __`Background Radiation And Electrical Noise`__ --

- __`Twisted Pair Copper Wiring`__ --

- __`Shielding: Coaxial Cable And Shielded Twisted Pair`__ --

- __`Categories Of Twisted Pair Cable`__ --

- __`Media Using Light Energy And Optical Fibers`__ --

- __`Types Of Fiber And Light Transmission`__ --

- __`Optical Fiber Compared To Copper Wiring`__ --

- __`InfraRed Communication Technologies`__ --

- __`Point-To-Point Laser Communication`__ --

- __`Electromagnetic (Radio) Communication`__ --

- __`Signal Propagation`__ --

- __`Types Of Satellites`__ --

- __`GEO Communication Satellites`__ --

- __`GEO Coverage Of The Earth`__ --

- __`Low Earth Orbit (LEO) Satellites And Clusters`__ --

- __`Tradeoffs Among Media Types`__ --

- __`Measuring Transmission Media`__ --

- __`The Effect Of Noise On Communication`__ --

- __`The Significance Of Channel Capacity,`__ --

<br>
<br>

---

<br>
<br>

# Chapter 8: Reliablity and Channel Coding

<br>
<br>

---

<br>
<br>

# Chapter 9: Transmission Modes

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
