# OSI Model: Presentation Layer

- The primary goal of this layer is to take care of the syntax and semantics of the information exchanged between two communicating systems. Presentation layer takes care that the data is sent in such a way that the receiver will understand the information(data) and will be able to use the data.

  In order to make it possible for computers with different data representations to communicate, the data structures to be exchanged can be defined in an abstract way

### Functions of Presentation Layer

- `Translation` -- Before being transmitted, information in the form of characters and numbers should be changed to bit streams 
- `Encryption` -- It carries out encryption at the transmitter and decryption at the receiver.
- `Compression` -- It carries out data compression to reduce the bandwidth of the data to be transmitted. The primary role of Data compression is to reduce the number of bits to be 0transmitted. It is important in transmitting multimedia such as audio, video, text etc.


<br>
<br>

---

<br>
<Br>

# OSI Mode: Application Layer

- It is the top most layer of OSI Model. Manipulation of data(information) in various ways is done in this layer which enables user or software to get access to the network. Some services provided by this layer includes: E-Mail, transferring files, distributing the results to user, directory services, network resources, etc.

  The Application Layer contains a variety of protocols that are commonly needed by users. One widely-used application protocol is HTTP(HyperText Transfer Protocol), which is the basis for the World Wide Web. When a browser wants a web page, it sends the name of the page it wants to the server using HTTP. The server then sends the page back.

  Other Application protocols that are used are: File Transfer Protocol(FTP), Trivial File Transfer Protocol(TFTP), Simple Mail Transfer Protocol(SMTP), TELNET, Domain Name System(DNS) etc.

### Functions of Application Layer

- `Mail Services` -- This layer provides the basis for E-mail forwarding and storage.
- `Network Virtual Terminal` --  It allows a user to log on to a remote host. The application creates software emulation of a terminal at the remote host. User's computer talks to the software terminal which in turn talks to the host and vice versa
- `Directory Services` -- This layer provides access for global information about various services.
- `File Transfer, Access and Management (FTAM):` -- It is a standard mechanism to access files and manages it. Users can access files in a remote computer and manage it.

<br>
<br>

---

<br>
<br>

# The TCP/IP Reference Model

- TCP/IP means Transmission Control Protocol and Internet Protocol. It is the network model used in the current Internet architecture as well. Protocols are set of rules which govern every possible communication over a network. These protocols describe the movement of data between the source and destination

### Different Layers of TCP/IP Reference Model

- Below we have discussed the 4 layers that form the TCP/IP reference model:

- `Layer 1: Host-to-network Layer` --
  - Lowest layer of the all.
  - Protocol is used to connect to the host, so that the packets can be sent over it.
  - Varies from host to host and network to network.

- `Layer 2: Internet layer` --
  - It is the layer which holds the whole architecture together.
  - It helps the packet to travel independently to the destination
  - Order in which packets are received is different from the way they are sent.
  - IP (Internet Protocol) is used in this layer.

- `Layer 3: Transport Layer` --
  - It decides if data transmission should be on parallel path or single path.
  - Functions such as multiplexing, segmenting or splitting on the data is done by transport layer.
  - Transport layer breaks the message (data) into small units so that they are handled more efficiently by the network layer.
  - Transport layer also arrange the packets to be sent, in sequence.

- `Layer 4: Application Layer` -- The TCP/IP specifications described a lot of applications that were at the top of the protocol stack. Some of them were TELNET, FTP, SMTP, DNS etc.
  - `TELNET` -- is a two-way communication protocol which allows connecting to a remote machine and run applications on it.
  - `FTP` -- File Transfer Protocol) is a protocol, that allows File transfer amongst computer users connected over a network. It is reliable, simple and efficient.
  - `SMTP` -- Simple Mail Transport Protocol) is a protocol, which is used to transport electronic mail between a source and destinatio
  - `DNS` -- Domain Name Server) resolves an IP address into a textual address for Hosts connected over a network.
  - `TCP(Transmission Control Protocol)` -- It is a reliable connection-oriented protocol which handles byte-stream from source to destination without error and flow control.
  - `UDP(User-Datagram Protocol` --  It is an unreliable connection-less protocol that do not want TCPs, sequencing and flow control. Eg: One-shot request-reply kind of service.

<br>
<br>

---

<bR>
<bR>

# Key Terms

- `ISO` -- 	The OSI model is a product of the Open Systems Interconnection project at the International Organization for Standardization. ISO is a voluntary organization.
- `OSI Model` -- 	Open System Interconnection is a model consisting of seven logical layers.
- `TCP/IP Model` -- Transmission Control Protocol and Internet Protocol Model is based on four layer model which is based on Protocols.
- `UTP` -- Unshielded Twisted Pair cable is a Wired/Guided media which consists of two conductors usually copper, each with its own colour plastic insulator
- `STP` -- Shielded Twisted Pair cable is a Wired/Guided media has a metal foil or braided-mesh covering which encases each pair of insulated conductors. Shielding also eliminates crosstalk
- `PPP` -- 	Point-to-Point connection is a protocol which is used as a communication link between two devices.
- `LAN` -- 	Local Area Network is designed for small areas such as an office, group of building or a factory.
- `WAN` -- Wide Area Network is used for the network that covers large distance such as cover states of a country
- `MAN` -- Metropolitan Area Network uses the similar technology as LAN. It is designed to extend over the entire city
- `Crosstalk` -- Undesired effect of one circuit on another circuit. It can occur when one line picks up some signals travelling down another line. Example: telephone conversation when one can hear background conversations. It can be eliminated by shielding each pair of twisted pair cable.
- `PSTN` -- 	Public Switched Telephone Network consists of telephone lines, cellular networks, satellites for communication, fiber optic cables etc. It is the combination of world's (national, local and regional) circuit switched telephone network.
- `File Transfer, Access and Management (FTAM)` -- Standard mechanism to access files and manages it. Users can access files in a remote computer and manage it.
- `Analog Transmission` -- The signal is continuously variable in amplitude and frequency. Power requirement is high when compared with Digital Transmission.
- `Digital Transmission` -- It is a sequence of voltage pulses. It is basically a series of discrete pulses. Security is better than Analog Transmission.
- `Asymmetric digital subscriber line(ADSL)` -- A data communications technology that enables faster data transmission over copper telephone lines than a conventional voice band modem can provide.
- `Access Point` -- Alternatively referred to as a base station and wireless router, an access point is a wireless receiver which enables a user to connect wirelessly to a network or the Internet. This term can refer to both Wi-Fi and Bluetooth devices.
- `Acknowledgement (ACK)` -- Short for acknowledgement, ACK is an answer given by another computer or network device indicating to another computer that it acknowledged the SYN/ACK or other request sent to it.
Note: If the signal is not properly received an NAK is sent.
- `Active Topology` -- The term active topology describes a network topology in which the signal is amplified at each step as it passes from one computer to the next.
- `Aloha` -- 	Protocol for satellite and terrestrial radio transmissions. In pure Aloha, a user can communicate at any time, but risks collisions with other users' messages. Slotted Aloha reduces the chance of collisions by dividing the channel into time slots and requiring that the user send only at the beginning of a time slot.
- `Address Resolution Protocol(ARP)` -- ARP is a used with the IP for mapping a 32-bit Internet Protocol address to a MAC address that is recognized in the local network specified in RFC 826
    
    
    
    
