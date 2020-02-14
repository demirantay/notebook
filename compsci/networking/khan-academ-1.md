# Introducing the Internet 

- The internet is a global network of computers communicating with each other in some way, whether they're sending emails, downloading files, or sharing websites.

- To create a global network of computers, we need:
  - `Wires & wireless`: Physical connections between computers.
  - `IP & DNS`: Addressing schemes to uniquely identify all the computers on the internet.
  - `TCP/IP`: A path-finding strategy for data to get from one computer to a destination computer.
  - `TLS`: Secure mechanisms for sending data without letting everyone else on the internet read it.
  - `HTTP & HTML`: Common protocols and formats for sharing documents and viewing them across any type of computer

<br>
<br>

---

<bR>
<br>

# Wires & Wifi: Physical network connections

- To make an internet, we need a way for two computers to communicate with each other, and it needs to work quickly across very long distances. The very first internet connections re-used the copper cables of telephone lines, communicating binary data via pulses of electricity.

  Engineers soon discovered how to send data in fiber optic cables as pulses of light and how to send data wirelessly via radio waves. The internet still uses all of these types of connections, because they each have their own benefits and drawbacks, like faster speed or higher cost.
  
### Transporting bits over wires

- The internet is a network of computers communicating with each other. When humans communicate with each other, we use words and body language. When computers communicate with each other, they use 1s and 0s. That's easy for computers since they already represent all their data in binary.

- `Sending streams of 1s and 0s` -- When computers need to internally represent the number 5 (101 in binary), they can use three wires to represent the 3 bits: one wire on, one wire off, one wire on.

  If a computer wants to send the number 5 to another computer, they can't use as many wires as they want. In fact, they may only have a single wire to send information over. Instead, they can send the number 5 over three time periods: first sending an on pulse (and waiting), then sending nothing (and waiting), then sending an on pulse.
  
  As long as the two computers agree on the time period, then they can transfer information to each other, turning binary data into pulses and turning the pulses back to binary data.
  
- `Bit rate` -- Computer networks can send bits very fast. We measure that speed using the bit rate, the number of bits of data that are sent each second. The earliest internet connections were just 75 bps (bits per second). These days, connections are more often measured in Mbps (megabits per second).

  A megabit is huge: 1 million bits! A 10 Mbps connection transfers data at 10 million bits per second. That's one bit every 100 nanoseconds (0.0000001 seconds).

  We also measure bit rate in smaller units like kilobits (1 thousand bits) or much bigger units like gigabits (1 billion bits) and even petabits (1 quadrillion bits).
  
  | unit | # | of its |
  | ---- | -- | --- |
  | kilobit | 1000 | 1 thousand |
  | megabit | 1000^2 | 1 million |
  | gigabit | 1000^3 | 1 billion |
  | terabit | 1000^4 | 1 trillion |
  | petabit | 1000^5 | 1 quadrillion | 

- `Bandwidth` -- We use the term bandwidth to describe the maximum bit rate of a system. If a network connection has a bandwidth of 100 Mbps, that means it can't transfer more than 100 megabits per second. Fortunately, that's still a lot!

- `Latency` -- (also called the ping rate) Another way to measure the speed of a computer network is latency. You might guess what that means from the word itself: latency measures how late the bits arrive. To put it in more formal terms: latency is the time between the sending of a data message and the receiving of that message, measured in milliseconds.

  My computer sends a message to the Google server. 30 milliseconds later, Google receives the message. 40 milliseconds later, my computer gets an acknowledgement from Google that it received the message. That's a total round-trip latency of 70ms. The latency depends on a number of physical factors: the type of connection from my computer to Google, the distance from my computer to the Google servers, and the congestion in the network (which may mean my request has to wait in line).
  
  There's a major limiting factor to latency: the speed of light. Nothing can move faster than light, not even our very important internet requests. The speed of light is 1 foot per nanosecond, which means a trip length of at least 30 ms from Los Angeles to Tokyo. We can't do much about the speed of light, but we can decrease latency by reducing congestion and improving our physical connections.

- `Physical connections: Ethernet, Fiber, and WiFi` -- The internet is a series of computers connected to each other. But what does that physical connection look like? It depends on the needs of the connection and the size of the network.

  __Ethernet cables__ are a common type of connection made up of twisted copper wires. Electricity pulses through them at a bit rate up to 400 Gbps. Ethernet cables are used in networks as small as LANs (local area networks) like a company's office or as large as WANs (wide area networks) like an entire country.

  __Fiber optic cables__ send pulses of light instead of electricity, and they can send terabits per second. They connect computers across the oceans, so that we can quickly send data across the world. As they become less expensive, they're becoming increasingly common in city-wide networks as well
  
  __Wireless__ connections don't involve any wiring at all—at least at first. A wireless card in the computer turns binary data into radio waves and transmits them through the air. Those radio waves can't travel very far: 75-100 feet in a place like an office building that's filled with all sorts of obstacles, or up to 1000 feet in a wide open field. The waves are hopefully picked up by a wireless router, also called an access point, which converts them from radio waves back into binary data
  
  At any given time, our internet connection might be using a combination of those technologies. Maybe we're using WiFi to connect to our home router, our home router is using ethernet copper cables to connect to the metropolitan network, and those cables are hopping over fiber to communicate with overseas data centers.
  
  | Types | Sends | Distance | Bandwitdth | Issues | 
  |--|--|--|--|--|
  | Wireless | Radio | 100 ft | 1.3 Gbps | Slower in reality |
  | Ethernet copper cables | Electricty | 330 ft | 1 Gbps | Can lose data | 
  | Fiber optic cable | Light | 50 miles | 26 Tbps | Expensive |  

- `Internet speed` -- Speed is a combination of bandwidth and latency. Computers split up messages into packets, and they can't send another message until the first packet is received. Even if a computer is on a connection with high bandwidth, its speed of sending and receiving messages will still be limited by the latency of the connection.

<br>
<br>

---

<br>
<br>

# IP & DNS: Scalable internet addressing 
