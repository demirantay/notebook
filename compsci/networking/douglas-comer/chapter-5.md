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

- __`Serial Transmission`__ -- The alternative to parallel transmission, known as serial transmission, sends one
bit at a time. With the emphasis on speed, it may seem that anyone designing a data
communications system would choose parallel transmission. However, most communication systems use serial mode. There are two main reasons. First, serial networks can
be extended over long distances at much less cost because fewer physical wires are
needed and intermediate electronic components are less expensive. Second, using only
one physical wire means that there is never a timing problem caused by one wire being
slightly longer than another (a difference of millimeters can be significant in a highspeed communication system).

- __`Transmission Order: Bits And Bytes`__ -- The serial transmission mode introduces an interesting question: when sending bits,
which bit should be sent across the medium first? For example, consider an integer.
Should a sender transmit the Most Significant Bit (MSB) or the Least Significant Bit
(LSB) first?

  Engineers use the term little-endian to describe a system that sends the LSB first,
and the term big-endian to describe a system that sends the MSB first. Either form can
be used, but the sender and receiver must agree.

- __`Timing Of Serial Transmission`__ -- Serial transmission mechanisms can be divided into three broad categories, depending on how transmissions are spaced in time
  - Asynchronous transmission can occur at any time, with an arbitrary
delay between the transmission of two data items
  - Synchronous transmission occurs continuously with no gap
between the transmission of two data items.
  - Isochronous transmission occurs at regular intervals with a fixed
gap between the transmission of two data items
  
- __`Asynchronous Transmission`__ -- Because it permits a sender to remain idle an arbitrarily long time
between transmissions, an asynchronous transmission mechanism
sends extra information before each transmission that allows a receiver to synchronize with the signal. The additional signal usually states if the transmission started or finished.

- __`RS-232 Asynchronous Character Transmission`__ -- The RS-232 standard used for asynchronous, serial communication
over short distances precedes each character with a start bit, sends
each bit of the character, and follows each character with an idle
period at least one bit long (stop bit).

- __`Synchronous Transmission`__ -- The chief alternative to asynchronous transmission is known as synchronous
transmission. At the lowest level, a synchronous mechanism transmits bits of data continually, with no idle time between bits. The chief advantage of a synchronous mechanism arises because the sender and receiver constantly remain synchronized, which means less synchronization overhead.

- __`Bytes, Blocks, And Frames`__ -- Although the underlying mechanism transmits bits continuously, the
use of an idle sequence and framing permits a synchronous transmission mechanism to provide a byte-oriented interface and to allow idle
gaps between blocks of data.

- __`Isochronous Transmission`__ -- The third type of serial transmission system does not provide a new underlying
mechanism. Instead, it can be viewed as an important way to use synchronous
transmission. Known as isochronous transmission†, the system is designed to provide
steady bit flow for multimedia applications that contain voice or video. Delivering such
data at a steady rate is essential because variations in delay, which are known as jitter,
can disrupt reception (i.e., cause pops or clicks in audio or make video freeze for a short
time).

- __`Simplex, Half-Duplex, and Full-Duplex Transmission`__ -- A communications channel is classified as one of three types, depending on the
direction of transfer:
  - Simplex
  - Full-Duplex
  - Half-Duplex
  
  Simplex. A simplex mechanism is the easiest to understand. As the name implies,
a simplex mechanism can only transfer data in a single direction

  Full-Duplex. A full-duplex mechanism is also straightforward: the underlying system allows transmission in two directions simultaneously. Typically a full-duplex
mechanism consists of two simplex mechanisms, one carrying information in each direction

  Half-Duplex. A half-duplex mechanism involves a shared transmission medium.
The shared medium can be used for communication in each direction, but the communication cannot proceed simultaneously

- __`DCE and DTE Equipment`__ -- The terms Data Communications Equipment (DCE) and Data Terminal Equipment
(DTE) were originally created by AT&T to distinguish between the communications
equipment owned by the phone company and the terminal equipment owned by a subscriber

  The terminology persists: if a business leases a data circuit from a phone company,
the phone company installs DCE equipment at the business, and the business purchases
DTE equipment that attaches to the phone company’s equipment.

<br>
<br>

---

<br>
<br>

# Chapter 10: Modulation and Modems

- __`Introduction`__ -- This chapter continues the discussion of data communications by focusing on the
use of high-frequency signals to carry information. The chapter discusses how information is used to change a high-frequency electromagnetic wave, explains why the technique is important, and describes how analog and digital inputs are used.

- __`Carriers, Frequency, And Propagation`__ -- Many long-distance communication systems use a continuously oscillating electromagnetic wave called a carrier. The system makes small changes to the carrier that
represent information being sent. To understand why carriers are important, recall from
Chapter 7 that the frequency of electromagnetic energy determines how the energy
propagates. One motivation for the use of carriers arises from the desire to select a frequency that will propagate well, independent of the rate that data is being sent. 

- __`Analog Modulation Schemes`__ -- We use the term modulation to refer to changes made in a carrier according to the
information being sent.

  In essence, a sender must change one of the fundamental characteristics of the wave.
Thus, there are three primary techniques that modulate an electromagnetic carrier according to a signal:
  - Amplitude modulation
  - Frequency modulation
  - Phase shift modulation

- __`Amplitude Modulation`__ -- A technique known as amplitude modulation varies the amplitude of a carrier in
proportion to the information being sent The carrier continues oscillating at a fixed frequency, but the amplitude of the wave varies.

  Amplitude modulation is easy to understand because only the amplitude (i.e., magnitude) of the sine wave is modified.

- __`Frequency Modulation`__ -- An alternative to amplitude modulation is known as frequency modulation. When
frequency modulation is employed, the amplitude of the carrier remains fixed, but the
frequency changes according to the signal: when the signal is stronger, the carrier frequency increases slightly, and when the signal is weaker, the carrier frequency decreases
slightly.

- __`Phase Shift Modulation`__ -- The third property of a sine wave is its phase, the offset from a reference time at
which the sine wave begins. It is possible to use changes in phase to represent a signal.
We use the term phase shift to characterize such changes. Although modulating phase is possible in theory, the technique is seldom used
with an analog signal. 

- __`Modulation, Digital Input, And Shift Keying`__ -- The description of modulation above shows how an analog information signal is
used to modulate a carrier. The question arises, “how can digital input be used?” The
answer lies in straightforward modifications of the modulation schemes described
above: instead of modulation that is proportional to a continuous signal, digital schemes
use discrete values. Furthermore, to distinguish between analog and digital modulation,
we use the term shift keying rather than modulation

- __`Phase Shift And A Constellation Diagram`__ --  The chief advantage of mechanisms like phase shift keying arises from
the ability to represent more than one data bit at a given change. A
constellation diagram shows the assignment of data bits to phase
changes.

  Although many variations of phase shift keying exist, noise and distortion limit the ability of practical systems to distinguish among arbitrarily small differences in phase changes

- __`Modem Hardware For Modulation And Demodulation`__ -- A hardware mechanism that accepts a sequence of data bits and applies modulation
to a carrier wave according to the bits is called a modulator; a hardware mechanism that
accepts a modulated carrier wave and recreates the sequence of data bits that was used
to modulate the carrier is called a demodulator.

  Thus, transmission of data requires a
modulator at one end of the transmission medium and a demodulator at the other. In
practice, most communication systems are full duplex communication, which means
each location needs both a modulator, which is used to send data, and a demodulator,
which is used to receive data. To keep cost low and make the pair of devices easy to
install and operate, manufacturers combine modulation and demodulation mechanisms
into a single device called a modem

- __`Optical And Radio Frequency Modems`__ -- In addition to dedicated wires, modems are also used with other media, including
RF transmission and optical fibers. For example, a pair of Radio Frequency (RF)
modems can be used to send data via radio, and a pair of optical modems can be used to
send data across a pair of optical fibers. Although such modems use entirely different
media than modems that operate over dedicated wires, the principle remains the same:
at the sending end, a modem modulates a carrier; at the receiving end, data is extracted
from the modulated carrier.

- __`Dialup Modems`__ -- Another interesting application of modems involves the voice telephone system.
Instead of using an electrical signal as a carrier, a dialup modem uses an audio tone. As
with conventional modems, the carrier is modulated at the sending end and demodulated
at the receiving end. Thus, besides the ability to place and receive telephone calls, the
chief difference between dialup and conventional modems arises from the lower
bandwidth of audible tones.

- __`QAM Applied To Dialup`__ -- Quadrature Amplitude Modulation is also used with dialup modems as a way to
maximize the rate at which data can be sent.

- __`V.32 and V.32bis Dialup Modems`__ -- 
 

<br>
<br>

---

<br>
<br>


