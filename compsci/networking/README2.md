# Types of Communication Netoworks

- Communication Networks can be of following 5 types:
  - Local Area Network (LAN)  
  - Metropolitan Area Network (MAN)
  - Wide Area Network (WAN)
  - Wireless
  - Inter Network (Internet)
  
### Local Area Network (LAN)

- It is also called LAN and designed for small physical areas such as an office, group of buildings or a factory. LANs are used widely as it is easy to design and to troubleshoot. Personal computers and workstations are connected to each other through LANs. We can use different types of topologies through LAN, these are Star, Ring, Bus, Tree etc.

- `applications` --
  - One of the computer in a network can become a server serving all the remaining computers called clients. Software can be stored on the server and it can be used by the remaining clients.
  - Sharing common resources like printers etc are some common applications of LAN. ... etc.

- __advantages__ -- `Resource Sharing`, `Software Applications Sharing`, `Easy and Cheap Communication`, `Centralized Data`, `Data Security`, `Internet Sharing`

- __disadvantages__ -- `High Setup Cost`, `Privacy Violations` (by the LAN admin), `Data Security Threat`, `LAN Maintenance Job`, `Covers Limited Area`

### Metropolitan Area Network (MAN)

- It was developed in 1980s.It is basically a bigger version of LAN. It is also called MAN and uses the similar technology as LAN. It is designed to extend over the entire city. It can be means to connecting a number of LANs into a larger network or it can be a single cable. It is mainly hold and operated by single private company or a public company.

- __advantages__ --
  - Extremely efficient and provide fast communication via high-speed carriers, such as fibre optic cables
  - It provides a good back bone for large network and provides greater access to WANs.
  - A MAN usually encompasses several blocks of a city or an entire city.

- __disadvantages__ -- 
  - More cable required for a MAN connection from one place to another.
  - It is difficult to make the system secure from hackers and industrial espionage(spying) graphical regions.

### Wide Area Network (WAN)

-  WAN can be private or it can be public leased network. It is used for the network that covers large distance such as cover states of a country. It is not easy to design and maintain. Communication medium used are satellite, public telephone networks which are connected by routers.

- __advantages__ --
  - Messages can be sent very quickly to anyone else on the network. 
  - Expensive things(such as printers or phone lines to the internet) can be shared by all the computers on the network without having to buy a different peripheral for each computer.
  - Everyone on the network can use the same data

- __disadvantages__ -- 
  - Need a good firewall to restrict outsiders from entering and disrupting the network.
  - Setting up a network can be an expensive, slow and complicated.
  - Once set up, maintaining a network is a full-time job 
  - Security is a real issue when many different people have the ability to use information from other computers. Protection against hackers and viruses adds more complexity and expense

### Wireless Network

- Wireless Networks can be divided into three main categories:
  - System interconnection
  - Wireless LANs
  - Wireless WANs

- `System Interconnection` -- System interconnection is all about interconnecting the components of a computer using short-range radio. Some companies got together to design a short-range wireless network called Bluetooth to connect various components such as monitor, keyboard, mouse and printer, to the main unit, without wires.

  In simplest form, system interconnection networks use the master-slave concept. The system unit is normally the master, talking to the mouse, keyboard, etc. as slaves.

- `Wireless LANs` -- These are the systems in which every computer has a radio modem and antenna with which it can communicate with other systems.

- `Wireless WANs` -- The radio network used for cellular telephones is an example of a low-bandwidth wireless WAN. This system has already gone through three generations.
  - The first generation was analog and for voice only.
  - The second generation was digital and for voice only.
  - The third generation is digital and is for both voice and data.

### Inter Network  

- Inter Network or Internet is a combination of two or more networks. Inter network can be formed by joining two or more individual networks by means of various devices such as routers, gateways and bridges.
  
<br>
<br>

---

<br>
<br>

# Connection Oriented and Connectionless Services

- These are the two services given by the layers to layers above them. These services are:
  - 1 - Connection Oriented Service
  - 2 - Connectionless Services

### Connection Oriented Services

- There is a sequence of operation to be followed by the users of connection oriented service. These are:
  - 1 - Connection is established.
  - 2 - Information is sent. 
  - 3 - Connection is released.
  
  Connection oriented service is more reliable than connectionless service. Example of connection oriented is TCP (Transmission Control Protocol) protocol.

### Connection Less Services

- It is similar to the postal services, as it carries the full address where the message (letter) is to be carried. Each message is routed independently from source to destination. The order of message sent can be different from the order received

  In connectionless the data is transferred in one direction from source to destination without checking that destination is still there or not or if it prepared to accept the message. Authentication is not needed in this. Example of Connectionless service is UDP protocol

### Difference: Connection oriented and Connectionless service

- differences:
  - In connection oriented service authentication is needed
  - Connection oriented protocol makes a connection and checks whether message is received or not and sends again if an error occurs, while connectionless service protocol does not guarantees a message delivery

### Service Primitives

- There are 5 types of primitives for Connection Oriented Service :
  - 1 - `LISTEN` -- Block waiting for an incoming connection
  - 2 - `CONNECTION` -- Establish a connection with a waiting peer
  - 3 - `RECEIVE` -- 	Block waiting for an incoming message
  - 4 - `SEND` -- Sending a message to the peer
  - 5 - `DISCONNECT` -- Terminate a connection

- `What are Services?` -- These are the operations that a layer can provide to the layer above it in the OSI Reference model. It defines the operation and states a layer is ready to perform but it does not specify anything about the implementation of these operations.

- `What are Protocols?` -- These are set of rules that govern the format and meaning of frames, messages or packets that are exchanged between the server and client.

<br>
<br>

---

<br>
<br>

# Introduction to Reference Models

- The most important reference models are:
  - 1 - OSI reference model.
  - 2 - TCP/IP reference model.
  
### Introduction to ISO-OSI Model

- There are many users who use computer network and are located all over the world. To ensure national and worldwide data communication ISO (ISO stands for International Organization of Standardization.) developed this model. This is called a model for open system interconnection (OSI) and is normally called as OSI model.

### Introduction to TCP/IP Reference Model

- TCP/IP is transmission control protocol and internet protocol. Protocols are set of rules which govern every possible communication over the internet. These protocols describe the movement of data between the host computers or internet and offers simple naming and addressing schemes

<br>
<br>

---

<br>
<br>

# ISO/OSI Model

- The ISO-OSI model is a seven layer architecture. It defines seven layers or levels in a complete communication system. They are:
  - 1 - Application Layer
  - 2 - Presentation Layer
  - 3 - Session Layer
  - 4 - Transport Layer
  - 5 - Network Layer
  - 6 - Datalink Layer
  - 7 - Physical Layer
  
- The OSI reference model has 7 layers. The principles that were applied to arrive at the seven layers can be briefly summarized as follows:
  - A layer should be created where a different abstraction is needed.
  - Each layer should perform a well-defined function.
  - The function of each layer should be chosen with an eye toward defining internationally standardized protocols.
  - The layer boundaries should be chosen to minimize the information flow across the interfaces.

- `OSI Model Layer 1: The Physical Layer` -- Physical Layer is the lowest layer of the OSI Model. It activates, maintains and deactivates the physical connection. It converts the digital/analog bits into electrical signal or optical signals.

- `OSI Model Layer 2: Data Link Layer` -- Data link layer synchronizes the information which is to be transmitted over the physical layer. The main function of this layer is to make sure data transfer is error free from one node to another, over the physical layer.

- `OSI Model Layer 3: The Network Layer` -- Network Layer routes the signal through different channels from one node to other. It acts as a network controller. It manages the Subnet traffic. It decides by which route data should take. It divides the outgoing messages into packets and assembles the incoming packets into messages for higher levels.

- `OSI Model Layer 4: Transport Layer` -- Transport Layer decides if data transmission should be on parallel path or single path. Functions such as Multiplexing, Segmenting or Splitting on the data are done by this layer

- `OSI Model Layer 5: The Session Layer` -- Session Layer manages and synchronize the conversation between two different applications.

- `OSI Model Layer 6: The Presentation Layer` -- Presentation Layer takes care that the data is sent in such a way that the receiver will understand the information (data) and will be able to use the data. It perfroms Data compression, Data encryption, Data conversion etc.

- `OSI Model Layer 7: Application Layer` -- Application Layer is the topmost layer. Transferring of files disturbing the results to the user is also done in this layer. Mail services, directory services, network resource etc are services provided by application layer.
  

<br>
<br>

---

<br>
<br>

# OSI Model: Physical Layer

- Physical layer is the lowest layer of the OSI reference model. It is responsible for sending bits from one computer to another. This layer is not concerned with the meaning of the bits and deals with the setup of physical connection to the network and with transmission and reception of signals.

### Functions of Physical Layer

- Following are the various functions performed by the Physical layer of the OSI model:
  - `Representation of Bits` --  It defines the type of encoding i.e. how 0's and 1's are changed to signal.
  - `Data Rate` -- This layer defines the rate of transmission which is the number of bits per second.
  - `Synchronization` -- It deals with the synchronization of the transmitter and receiver
  - `Interface` -- The physical layer defines the transmission interface between devices and transmission medium.
  - `Line Configuration` -- This layer connects devices with the medium: Point to Point configuration and Multipoint configuration
  - `Topologies` -- Devices must be connected using the following topologies: Mesh, Star, Ring and Bus
  - `Transmission Modes` -- Physical Layer defines the direction of transmission between two devices: Simplex, Half Duplex, Full Duplex.

<br>
<br>

---

<br>
<br>

# OSI Model: Data Link Layer

- Data link layer performs the most reliable node to node delivery of data. The main task of the data link layer is to transform a raw transmission facility into a line that appears free of undetected transmission errors to the network layer. It accomplishes this task by having the sender break up the input data into `data frames`(typically a few hundred or few thousand bytes) and transmit the frames sequentially. If the service is reliable, the receiver confirms correct receipt of each frame by send back an `acknowledgement frame`.

### Functions of Data Link Layer

- `Framing` -- Frames are the streams of bits received from the network layer into manageable data units. This division of stream of bits is done by Data Link Layer.
- `Physical Addressing` -- The Data Link layer adds a header to the frame in order to define physical address of the sender or receiver of the frame
- `Flow Control` -- A flow control mechanism to avoid a fast transmitter from running a slow receiver by buffering the extra bit is provided by flow control
- `Error Control` -- Error control is achieved by adding a trailer at the end of the frame. Duplication of frames are also prevented by using this mechanism
- `Access Control` -- Protocols of this layer determine which of the devices has control over the link at any given time, when two or more devices are connected to the same link.

<br>
<br>

---

<br>
<br>
  
# OSI Model: Network Layer

- The network Layer controls the operation of the subnet. The main aim of this layer is to deliver packets from source to destination across multiple links (networks).

  If two computers (system) are connected on the same link, then there is no need for a network layer. It routes the signal through different channels to the other end and acts as a network controller.

### Functions of Network Layer

- 1 - It translates logical network address into physical address. Concerned with circuit, message or packet switching.
- 2 - Routers and gateways operate in the network layer. Mechanism is provided by Network Layer for routing the packets to final destination.
- 3 - Connection services are provided including network layer flow control, network layer error control and packet sequence control.
- 4 - Breaks larger packets into small packets.

<br>
<br>

---

<br>
<br>

# OSI Model: Transport Layer

- The basic function of the Transport layer is to accept data from the layer above, split it up into smaller units, pass these data units to the Network layer, and ensure that all the pieces arrive correctly at the other end. Furthermore, all this must be done efficiently and in a way that isolates the upper layers from the inevitable changes in the hardware technology.

### Functions of Transport Layer

- `Service Point Addressing` -- Transport Layer header includes service point address which is port address
- `Segmentation and Reassembling` -- A message is divided into segments; each segment contains sequence number, which enables this layer in reassembling the message. Message is reassembled correctly upon arrival at the destination and replaces packets which were lost in transmission.
- `Connection Control` -- It includes 2 types:
  - Connectionless Transport Layer : Each segment is considered as an independent packet and delivered to the transport layer at the destination machine.
  - Connection Oriented Transport Layer : Before delivering packets, connection is made with transport layer at the destination machine.
- `Flow Control` -- In this layer, flow control is performed end to end
- `Error Control` -- Error Control is performed end to end in this layer to ensure that the complete message arrives at the receiving transport layer without any error.

<br>
<br>

---

<br>
<br>

# OSI Model: Session Layer

- The Session Layer allows users on different machines to establish active communication sessions between them. It's main aim is to establish, maintain and synchronize the interaction between communicating systems. Session layer manages and synchronize the conversation between two different applications.

### Functions of Session Layer

- `Dialog Control` -- This layer allows two systems to start communication with each other in half-duplex or full-duplex.
- `Token Management` -- This layer prevents two parties from attempting the same critical operation at the same time
- `Synchronization` -- This layer allows a process to add checkpoints which are considered as synchronization points into stream of data. Example: If a system is sending a file of 800 pages, adding checkpoints after every 50 pages is recommended. This ensures that 50 page unit is successfully received and acknowledged. This is beneficial at the time of crash as if a crash happens at page number 110; there is no need to retransmit 1 to100 pages.

<br>
<Br>
  
---

<br>
<br>
