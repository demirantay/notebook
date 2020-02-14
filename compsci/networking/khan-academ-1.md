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

- In 1973, there were only 45 computers on the internet, located at 36 labs around the US. Nowadays, there are more than 4 billion devices connected to the internet, in a world with a population of 7.5 billion. When one computer sends a message to another computer, it needs to somehow identify that computer amongst the billions of other computers.

  How is that possible? It's all thanks to IP and DNS, two protocols for addressing computers in a network.
  
### IP addresses (Internet Protocol)

- The Internet Protocol (IP) describes how two computers can communicate with each other, and it's used by every computer on the internet. Each computer has an IP address, just like homes and companies have mail addresses. When a computer sends a message to another computer, it specifies the recipient's address and also makes sure to include its own address, so that the second computer can reply.

  In the IP v4 protocol, IP addresses look like this: __74.125.20.113__
  
  Each IP address is split into 4 numbers, and each number can range from 0 to 255, We write those numbers in decimal, but to the computer, they're represented with bits, like so:
  
  01010101 01010101 01010101 01010101
  
  Overall, that's 2^{32}, that gives us: 4,294,967,2964,294,967,2964,possible IPv4 addresses. That's a lot! But remember, in the beginning, we said there are more than 4 billion devices connected to the internet? Well, we're reaching the limit of possible IP addresses. It's time for plan B.

- `IP v6 addresses` -- Back when they invented the internet, they didn't anticipate how popular it'd become and they thought that 4 billion would be plenty. That's what led to the IPv6 protocol, a new addressing scheme. Here's an IPv6 address:
  
  2001:0db8:0000:0042:0000:8a2e:0370:7334
  
  Notice the letters in those numbers, like d and b in 0db8? Those are hexadecimal numbers, which means that the IPv6 address is much longer than it looks.

- `Hierarchical addressing` -- Many addressing schemes are hierarchical, like phone numbers:

  +1 (541) 754-3010
  
  We can break that into 4 parts: 1-Country code  2-Area code	 3-Local exchange	 4-Specific phone

  IP addresses are also hierarchical. The first sequence of bits identifies the network, and the final bits identify the individual node in the network. Consider this IP address: `24.147.242.217` -- We can break that into 2 parts: -- `24.147` (Comcast network) `242.217` (My home network)
  
- `What's your IP address?` -- One way to find out your computer's IP address is by searching Google for "IP address". Google knows your IP address, since your computer sends a message to the Google computers as soon as it loads google.com.
  
  Your IP address might be different tomorrow than it is today. Each ISP has a range of addresses they can assign, and they might give you a different one of those addresses each time they see your computer pop up on the network. That's called a "dynamic" IP address.
  
  Computers that act as servers, like the computers that power Google.com, often have "static" IP addresses. That makes it easier for computers to quickly send search requests to the Google servers.

### DNS systems (Domain name systems)

- As we just learned, IP addresses are how computers identify other computers on the internet. IP addresses aren't particularly human-friendly, though. Who wants to memorize an address like 74.125.20.113? Or the even harder IP v6 addresses?

  The domain name system (DNS) gives us humans an easy way to identify where we want to go on the internet. We simply type in a domain name like "www.wikipedia.org", and our computer connects us to the computers powering Wikipedia: A domain name is a human-friendly address for a website, something that's easy for us to remember and type in.
  
- Each domain name is made up of parts:
  
  `third-level-domain.second-level-domain.top-level-domain`
  
  There are a limited set of top level domains (TLDs), and many websites use the most common TLDs,".com", ".org", and ".edu".
  
  The second level domain is unique to the company or organization that registers it, like "wikipedia" or "khanacademy".
  
  The third level domain is also called a subdomain, because it's owned by the same group and that URL often directs you to a subset of the website, like "m.wikipedia.org" (mobile-optimized Wikipedia) or "es.khanacademy.org" (Spanish-language Khan Academy).
  
- `Domains <--> IP addresses` -- Behind the scenes, each domain name maps to an IP address. When we type a URL in the address bar of our browser, the computer has to figure out its IP address. The computer can't store a database of more than 300 million domain names locally, so it goes through a multi-step process to find out the IP address

  __Step 1: Check the local cache__ If you've visited a website once, there's a fairly good chance you'll visit it again. That's why computers keep their own local cache of domain name to IP mappings. The cache stays small, because it kicks out domains you haven't visited in a while or domains that send down expiration dates.
  
  __Step 2: Ask the ISP cache__ Every ISP provides a domain name resolving service and keeps its own cache. Perhaps you haven't visited a particular website, but your neighbor just did, so the ISP can lookup the IP from their visit. If it's not in the ISP's cache, then it's off to the next step.
  
  __Step 3: Ask the name servers__ There are domain name servers scattered around the globe that are responsible for keeping track of a subset of the millions of domain names. The servers are ordered in a hierarchy: `Root name servers → TLD name servers → Host name servers.`
  
    The ISP starts by asking the root name servers: "hey, which name server knows about .org domains?" The root name server responds with the IP address of a TLD name server that tracks ".org" domains. Next, the ISP asks the TLD name server: "so, who knows about wikipedia domains?" The TLD name server responds with the IP address of a host name server that contains the "wikipedia" records. Finally, the ISP asks the host name server: "okay, so where's www.wikipedia.org?" The host name server responds with an exact IP address.
    
    The ISP sends the IP address back to the requesting computer, and now our computer can successfully connect with the computer powering that domain.
    
 ### DNS Spoofing 
 
 - The domain name system is scalable, but it is not always secure. Cyber criminals figured out a way to exploit flaws in DNS name servers, in an attack known as DNS spoofing or DNS cache poisoning.
 
  As we saw above, a domain resolver service must ask name servers when it doesn't already know the mapping of a domain to an IP. If a cyber criminal manages to take control of a name server or redirect requests to its own server, then it can reply with any IP address it wants: The IP address often redirects users to a page that will download computer viruses or ask for their secure information.
  
  There is good news, however: DNS spoofing can be prevented. The DNSSEC protocol extends the original DNS protocol and specifies the best way for DNS resolvers to authenticate the information sent to them. Upgrading old systems takes time, so it may be years or decades before all DNS systems are using DNSSEC.
