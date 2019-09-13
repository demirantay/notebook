# Network Programming with Python

- Well, the Internet transfers PettaBytes of data every minute across the globe. Do you have any idea how that happens? You click on a link and you download a multi MegaByte(MB) file within seconds, watch your favourite videos, do live video calls and what not. This is not magic! There are people behind the scene, who are working very hard to make all this happen, both efficiently and safely, by making sure that the data reaching you is unsniffed and legitimate.

### What is networking

- Computer Networking aims to study and analyze the communication process among various computing devices or computer systems that are linked, or networked together to exchange information and share resources. So, in order to perform networking you must have a network. It's like to make a telephone call you must have a telephone line. Isn't it obvious! So, there are basically four types of computer networks:

### LAN (Local Area Network)

- Used to serve a small number of people located in a small geographical space like colleges, small organisations etc. It's more of a peer to peer conection.

### WAN (Wide Area Network)

- This network type covers more area than LAN as they allow connectivity across large geographical Area. It basically connects many LANs together to reach beyond just peer to peer sharing. The Internet is an example of WAN.

### MAN (Metropolitan Area Network)

- MAN is a computer network that interconnects users with computer resources in a geographic area or region larger than that covered by a LAN(Local Area Network) but smaller than the area covered by a WAN(Wide Area Network). The term is derived from its usage for the interconnection of networks in a city into a single larger network.

### PAN (Personal Area Network)

- A personal area network (PAN) is a computer network used for data transmission amongst devices such as computers, telephones, tablets and personal digital assistants. PANs can be used for communication amongst the personal devices themselves (interpersonal communication), or for connecting to a higher level network and the Internet (an uplink) where one master device takes up the role as internet router.


<br>
<br>

---

<br>
<br>

# Network Terminologies 

- Let's quickly go through the frequently used terminologies along with their meanings which are very important for network programming

### Internet Protocol (IP)

- These are the set of procedures or rules which govern the flow of data, format of data over the internet.

  Mainly, we will be dealing with two major protocols over the internet:
    - User Datagram Protocol(UDP)
    - Transmission Control Protocol(TCP)

### User Datagram Protocol (UDP)

- UDP is a connectionless protocol. In this protocol data is sent over the internet as `datagrams`.

  Let's have a look at some properties of the UDP protocols.
    - `Unreliable:` When a UDP message is sent, there is no way to know if it will reach its destination or not; it could get lost along the way. In UDP, there is no concept of acknowledgment, retransmission, or timeout (as in TCP).
    - `Not ordered:` If two messages are sent to the same recipient, the order in which they arrive cannot be predicted.
    - `Lightweight:` There is no ordering of messages, no tracking connections, etc. Hence UDP messages are used when the rate of data transmission required is more and relibility is not important.
    - `Datagrams:` Packets are sent individually and are checked for integrity only if they arrive.

### Transmission Control Protocol (TCP)

### IP Adresses and Ports 

### Firewall 


<br>
<br>

---

<br>
<br>

#  Basics of Sockets 
