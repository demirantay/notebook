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
  
