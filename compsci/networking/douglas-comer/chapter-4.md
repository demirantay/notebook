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

- __`Introduction`__ -- The previous chapter
considers the topic of information sources. The chapter examines analog and digital information, and explains encodings.

- __`Guided And Unguided Transmission`__ -- How should transmission media be divided into classes. There are two broad approaches:
  - By type of path: communication can follow an exact path such as a
wire, or can have no specific path, such as a radio transmission
  - By form of energy: electrical energy is used on wires, radio
transmission is used for wireless, and light is used for optical fiber

  Informally, engineers use
the terms wired and wireless. Note that the informality can be somewhat confusing because one is likely to hear the term wired even when the physical medium is an optical
fiber.

- __`A Taxonomy By Forms Of Energy`__ -- energy types:
  - Electrical
    - Twisted pair
    - Coaxial Cable
  - Light
    - Optical Fiber
    - InfraRed
    - Laser
  - Electromagnetic(Radio)  
    - Terrestrial Radio
    - Satellite
    
- __`Background Radiation And Electrical Noise`__ -- Computer networks use an alternative form of wiring. To understand why, one
must know three facts.
  - 1 - Random electromagnetic radiation, called noise, permeates the environment. In fact, communication systems generate minor amounts of
electrical noise as a side-effect of normal operation.
  - 2 - When it hits metal, electromagnetic radiation induces a small signal,
which means that random noise can interfere with signals used for
communication.
  - 3 - Because it absorbs radiation, metal acts as a shield. Thus, placing
enough metal between a source of noise and a communication medium
can prevent noise from interfering with communication.

  The random electromagnetic radiation generated by devices such as
electric motors can interfere with communication that uses radio
transmission or electrical energy sent over wires.

- __`Twisted Pair Copper Wiring`__ -- The third fact in the previous section explains the wiring used with communication
systems. There are three forms of wiring that help reduce interference from electrical
noise
  - Unshielded Twisted Pair (UTP)
  - Coaxial Cable
  - Shielded Twisted Pair (STP)
  
  To reduce the interference caused by random electromagnetic radiation, communication systems use twisted pair wiring rather than
parallel wires.

- __`Shielding: Coaxial Cable And Shielded Twisted Pair`__ -- Although it is immune to most background radiation, twisted pair wiring does not
solve all problems. Twisted pair tends to have problems with:
  - Especially strong electrical noise
  - Close physical proximity to the source of noise
  - High frequencies used for communication
  
  To handle situations where twisted pair is insufficient, forms of wiring are available that have extra metal shielding. The most familiar form is the wiring used for cable television. Known as coaxial cable (coax), the wiring has a thick metal shield
formed from braided wires that completely surround a center wire that carries the signal.

  The heavy shielding and symmetry makes coaxial cable immune to
noise, capable of carrying high frequencies, and prevents signals on
the cable from emitting noise to surrounding cables.

   One popular variation is known
as shielded twisted pair (STP). The cable has a thinner, more flexible metal shield surrounding one or more twisted pairs of wires. In most versions of STP cable, the shield
consists of metal foil, similar to the aluminum foil used in a kitchen. STP cable has the
advantages of being more flexible than a coaxial cable and less susceptible to electrical
interference than unshielded twisted pair (UTP)

- __`Media Using Light Energy And Optical Fibers`__ -- , three forms of media use light energy to
carry information:
  - Optical fibers
  - InfraRed transmission
  - Point-to-point lasers

  The most important type of media that uses light is an optical fiber. Each fiber
consists of a thin strand of glass or transparent plastic encased in a plastic cover. A
typical optical fiber is used for communication in a single direction — one end of the
fiber connects to a laser or LED used to transmit light, and the other end of the fiber
connects to a photosensitive device used to detect incoming light

- __`Types Of Fiber And Light Transmission`__ -- Although it is not a problem for optical fibers used to connect a computer to a
nearby device, dispersion becomes a serious problem for long optical fibers, such as
those used between two cites or under the Atlantic Ocean. Consequently, three forms
of optical fibers have been invented that provide a choice between performance and
cost:
  - Multimode, Step Index fiber is the least expensive, and is used
when performance is unimportant
  - Multimode, Graded Index fiber is slightly more expensive than the
step index fib
  - Single Mode fiber is the most expensive, and provides the least
dispersion.  Single mode is used for long distances
and higher bit rates. Single mode fiber and the equipment used at each end are designed to focus light.
As a result, a pulse of light can travel thousands of kilometers without becoming
dispersed.

- __`Optical Fiber Compared To Copper Wiring`__ -- Optical fiber has several properties that make it more desirable than copper wiring.
Optical fiber is immune to electrical noise, has higher bandwidth, and light traveling
across a fiber does not attenuate as much as electrical signals traveling across copper.
However, copper wiring is less expensive. Furthermore, because the ends of an optical
fiber must be polished before they can be used, installation of copper wiring does not
require as much special equipment or expertise as optical fiber. Finally, because they
are stronger, copper wires are less likely to break if accidentally pulled or bent.

- __`InfraRed Communication Technologies`__ -- InfraRed (IR) communication technologies use the same type of energy as a typical television remote control: a form of electromagnetic radiation that behaves like visible
light but falls outside the range that is visible to a human eye

  Infrared communication technologies are best suited for use indoors
in situations where the path between sender and receiver is short and
free from obstruction

  The most commonly used infrared technology is intended to connect a computer to
a nearby peripheral, such as a printer

- __`Point-To-Point Laser Communication`__ -- Because they connect a pair of devices with a beam that follows the line-of-sight,
the infrared technologies described above can be classified as providing point-to-point
communication. In addition to infrared, other point-to-point communication technologies exist. One form of point-to-point communication uses a beam of coherent light
produced by a laser

  Like infrared, laser communication follows line-of-sight, and requires a clear,
unobstructed path between the communicating sites. Unlike an infrared transmitter,
however, a laser beam does not cover a broad area. Instead, the beam is only a few centimeters wide

- __`Electromagnetic (Radio) Communication`__ -- Recall that the term unguided is used to characterize communication technologies
that can propagate energy without requiring a medium such as a wire or optical fiber.
The most common form of unguided communication mechanisms consists of wireless
networking technologies that use electromagnetic energy in the Radio Frequency (RF)
range. RF transmission has a distinct advantage over light because RF energy can
traverse long distances and penetrate objects such as the walls of a building.

- __`Signal Propagation`__ -- The frequencies used for wireless networking technologies cannot be
chosen arbitrarily because governments control the use of spectrum
and each frequency has characteristics such as wave propagation,
power requirements, and susceptibility to noise.

  Wireless technologies are classified into two broad categories as follows:
  - Terrestrial. Communication uses equipment such as radio or microwave transmitters that is relatively close to the earth’s surface.
Typical locations for antennas or other equipment include the tops
of hills, man-made towers, and tall buildings.
  - Nonterrestrial. Some of the equipment used in communication is
outside the earth’s atmosphere (e.g., a satellite in orbit around the
earth).

- __`Types Of Satellites`__ -- communication
satellites are classified into three broad categories, depending on their distance from the
earth:
  - Low Earth Orbit (LEO)
  - Medium Earth Orbit (MEO)
  - Geostationary Earth Orbit (GEO)

- __`GEO Communication Satellites`__ --  the main tradeoff in communication satellites is between
height and period. The chief advantage of a satellite in Geostationary Earth Orbit
(GEO) arises because the orbital period is exactly the same as the rate at which the
earth rotates. If positioned above the equator, a GEO satellite remains in exactly the
same location over the earth’s surface at all times.

  Unfortunately, the distance required for a geostationary orbit is 35,785 kilometers
or 22,236 miles, which is approximately one tenth the distance to the moon

  Although it may seem unimportant, a delay of approximately 0.2 seconds can be
significant for some applications. In a telephone call or a video teleconference, a human can notice a 0.2 second delay. For electronic transactions such as a stock exchange
offering a limited set of bonds, delaying an offer by 0.2 seconds may mean the difference between a successful and unsuccessful offer

- __`GEO Coverage Of The Earth`__ -- How many GEO communication satellites are possible? Interestingly, there is a
limited amount of “space” available in the geosynchronous orbit above the equator because communication satellites using a given frequency must be separated from one
another to avoid interference. The minimum separation depends on the power of the
transmitters, but may require an angular separation of between 4 and 8 degrees. Thus,
without further refinements, the entire 360-degree circle above the equator can only
hold 45 to 90 satellites.

- __`Low Earth Orbit (LEO) Satellites And Clusters`__ -- For communication, the primary alternative to GEO is known as Low Earth Orbit
(LEO), which is defined as altitudes up to 2000 Kilometers LEO offers the advantage of short delays (typically 1 to 4 milliseconds), but the disadvantage that the orbit of a satellite does not match the rotation
of the earth.  Tracking is difficult because satellites move rapidly

  The general technique used with LEO satellites is known as clustering or array deployment. A large group of LEO satellites are designed to work together. In addition
to communicating with ground stations, a satellite in the group can also communicate
with other satellites in the group. Members of the group stay in communication, and
agree to forward messages, as needed.  For example, consider what happens when a
user in Europe sends a message to a user in North America. A ground station in Europe transmits the message to the satellite currently overhead. The cluster of satellites
communicate to forward the message to the satellite in the cluster that is currently over
a ground station in North America. Finally, the satellite currently over North America
transmits the message to a ground station

- __`Measuring Transmission Media`__ -- We have already mentioned the two most important measures of performance used
to assess a transmission medium:
  - Propagation delay: the time required for a signal to traverse the
medium
  - Channel capacity: the maximum data rate that the medium can support 
  
  > we will dive deepere in these in the upcoming chapters

<br>
<br>

---

<br>

