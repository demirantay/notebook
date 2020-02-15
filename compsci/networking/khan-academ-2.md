# TCP/IP: Reliable data transmission

- The postal system tries hard to deliver letters to their destination, but sometimes, things happen along the way: natural disasters, thefts, messy handwriting, hungry dogs.

  The internet is a lot like a postal system: it has to get information from one part of the world to another part of the world. Once again, things can happen along the way, like a fire destroying an ethernet cable.
  
<br>

### Internet Routing Protocol

- In the Internet Protocol (IP), computers split their messages up into packets and those packets hop from router to router on their way to their destination, the data does not transfer between computerss in a straight network line. Let's step through the process of routing a packet from a source to a destination.

  __Step 1: Send packet to router__ == Computers send the first packet to the nearest router. A router is a special computer on the internet that helps the packets move along.
  
  __Step 2: Router receives packet__ == When the router receives a packet, it looks at its IP header. The most important field is the destination IP address, which tells the router where the packet wants to end up.
  
  __Step 3: Router forwards packet__ == The router has multiple paths it could send a packet along, and its goal is to send the packet to a router that's closer to its final destination. Once the router locates the most specific row in the table for the destination IP address, it sends the packet along that path.
  
  __Step 4: Final router forwards message__ == If all goes well, the packet should eventually arrive at a router that knows exactly where to send it. The router can now send the message to the destination IP address, which may be a personal computer or a server.

- `Redundancy in the network` -- What happens if a network path is no longer available, like due to a natural disaster physically destroying it or a cybercriminal hijacking it? Is the packet doomed to never reach its destination? Never fear! There are typically many possible paths a packet can go down to reach the same destination. The redundancy of the paths in the network help the internet be more fault-tolerant and reliable.

<br>
<br>

---

<br>
<br>


# Transmission Control Protocol (TCP)

- In the Internet Protocol (IP), computers send messages to other computers via a network of routers. But there's a limit to how big those messages can be, due to physical limitations of the internet's infrastructure. That's why computers split those messages into multiple small packets.

- Many things could go wrong once a single message is split into packets. Here are some big ones:
  - Packets can be lost, due to problems in the physical layer or in routers' forwarding tables. A message needs every single packet to be put back together.
  - Packets can arrive out of order. That can happen especially if two packets follow different paths to the destination.
  - A computer might send multiple messages to a destination, and the destination needs to identify which packet belongs to which message
  
  TCP to the rescue! The Transmission Control Protocol is always used alongside the IP in order to ensure reliable transmission of packets. Together, the protocols are known as TCP/IP.

- `From start to finish` -- Let's step through the process of sending and receiving packets. Note that this process happens entirely within the IP routing protocol.

  __Step 1: Establish connection__ == When two computers want to send data to each other, they first need to establish a connection with the TCP "3-way handshake". Once the computers are done with the handshake, they know they're both ready to receive actual data.
  
  __Step 2: Send packets of data__ == Either computer can now send packets of data. When either computer receives a packet of data, it always replies back to confirm what it received. Each packet contains the data itself, plus important details that improve the reliability of TCP, like the sequence number.
  
  __Step 3: Close the connection__ == Either computer can close the connection when they no longer want to send or receive data.

- `Reliable transmission` -- TCP includes multiple mechanisms that ensure reliable transmission of packets.
As one example, a sending computer can detect when a packet has been lost by noticing that a packet hasn't been acknowledged within a period of time. Once the sender detects packet loss, it will re-transmit the lost packet

<bR>
<br>
  
---

<br>
<br>

# TLS: Secure data transport
