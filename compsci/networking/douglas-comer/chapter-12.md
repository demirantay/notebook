# Chapter 32: Trends in Networking Technologies and Uses

- __`Introduction`__ -- This chapter summarizes some of the trends in networking technologies, applications, and services. The chapter considers recent developments as well as longer-term
research.

- __`The Need For Scalable Internet Services`__ -- The disadvantage of a centralized server arises from the resulting performance: as the
number of clients increases, the server (or the access network leading to the server)
quickly become a bottleneck, especially if each client downloads many bytes of content. The server bottleneck problem is considered one of the most important limitations
on Internet services.

- __`Content Caching (Akamai)`__ -- One of the first scaling technologies focused on caching web content. For example, ISPs often have a cache that keeps a copy of each static web page (i.e., a page for
which the content does not change rapidly). Companies like Akamai, Amazon have extended the caching idea by offering a distributed
caching service

- __`Web Load Balancers`__ --  One of
the interesting mechanisms used to construct a large web site is known as a load
balancer. A load balancer allows a site to have multiple computers each running an
identical web server, and distributes incoming requests among the physical servers

  A load balancer examines each incoming HTTP request and sends the request to
one of the servers. The load balancer remembers recent requests, and directs all requests from a given source to the same physical server. To insure that all servers return
the same answer to a request, the servers use a common, shared database system.

- __`Server Virtualization`__ -- Another twist on scalability arises from server virtualization. The motivation begins with an observation: many sites runs multiple servers (e.g., an email server, web
server, and a database server). In a conventional architecture, each server must be
placed on a physical computer.  A performance problem can occur because the servers
running on computer A are all busy, but the servers running on computer B are idle

  Server virtualization solves the problem by allowing a manager to move a server
from one computer to another at any time. Of course, there are many technical details
to be handled, including changes in forwarding. However, the idea is straightforward:
run the server under a Virtual Machine (VM) system that support process migration

- __`Peer-To-Peer Communication`__ -- In the 1990s, several groups experimented with a general technique to increase the
speed of file download. Instead of fetching a complete file from a central server, a
client fetches individual pieces of a file. Furthermore, pieces of the file are placed on
servers throughout the Internet. Whenever a client needs a piece of a file, the client
chooses to fetch a copy from a server that is nearby. To increase the number of locations where a piece can be found, each client that obtains a piece of the file agrees to
act as a server that allows other clients to obtain the piece. The approach is known as a
peer-to-peer architecture (p2p).

- __`Distributed Data Centers And Replication`__ -- , some sites have so much traffic that another solution is needed: replication of an entire site. We use the term distributed data
centers to characterize the approach.

  As an example, consider the Google search engine. Google receives billions of
contacts daily. To handle the load, Google has created multiple data centers, placed in
various geographic locations. When a user enters the domain name www.google.com,
the user is directed to the closest Google data center; the approach can be considered a
form of load balancing among sites

- __`Universal Representation (XML)`__ -- One of the most interesting trends in networking arises from the widespread adoption of the Extensible Markup Language (XML). Initially, XML was designed to incorporate structure into web documents so the document could be understood by multiple
applications.

  XML has become a de facto standard for representation, and is being used in a
variety of new ways that were unanticipated in early designs. But newly we use json. Buttheere are still who cling to the old ways of xml

- __`Social Networking`__ -- In the early 2000s, Internet use shifted from a consumer model to one of social interaction among peers. Initially, most information on the Internet was supplied by producers, organizations such as media companies. . By the 2000s, sites like Facebook, Myspace, and YouTube
arose that allow any user to create content, which means that a typical user is uploading
more data.

- __`Mobility And Wireless Networking`__ -- Mobile communication is among the most significant trends, and users expect to be
connected to the Internet continuously. Most hotels offer Internet connections to their
guests, and airlines are offering Internet service on planes. The most significant change, however,
has occurred in the cellular telephone industry: cellular phones will soon be converted
away from other protocols to IP

- __`Digital Video`__ -- Cable providers are replacing analog transmission facilities with digital, and will
soon be delivering content in digital form over packet networks. In fact, many providers are using IP as the packet protocol, and the term IPTV is used for the technology.

- __`Multicast Delivery`__ -- With IP multicasting, only one copy of a television program needs to
be sent across a logical LAN segment; multicasting of a program
ceases once no more subscribers are watching the program.

- __`Higher-Speed Access And Switching`__ -- The Ethernet switches used in enterprise data centers provide 1 Gbps to the desktop. Higher capacity links operate at 10 Gbps, and it seems likely that speeds will increase to 40 Gbps, they are trying to keep pushing it to its limits.

- __`Use Of Networking In Business`__ -- Most large companies rely on computer networks for all aspects of business. However, networks are changing business in three ways. First, the availability of RFID
technology is changing production, shipping, and inventory. Second, the availability of
high-speed Layer 2 switches and packet technologies for voice and video are making it
possible to replace travel with high-quality video teleconferencing systems. Third,
many businesses are moving away from a strict command-and-control culture to a more
collaborative style of management in which a team works together to make decisions

- __`Sensors At Large And In The Home`__ -- Low-cost wired and wireless networking and low-power sensor devices have made
it possible to build large sensor networks and connect such networks to the Internet.
Sensors are being used to measure the environment (e.g., monitor air and water quality
or gather weather information), track the movements of wild animals, help farmers
monitor crops, monitor people in office buildings, and assess traffic on highways.

- __`Ad Hoc Networks`__ -- Since the early days of packet networking, the US military has funded research on
ad hoc networks that are self-organizing. That is, a set of wireless stations find neighbors, choose a topology, and establish routing that allows any station to reach any other.
The military’s motivation arises from an imagined operation where soldiers each carry a
wireless network station, and the stations form a communication system automatically.

- __`Multi-Core CPUs And Network Processors`__ -- High data rates pose a problem for networking equipment manufacturers: how to
build system chips that can process packets quickly. High-end routers must handle packets
arriving over an interface at 10 Gbps.

- __`IPv6`__ -- No list of networking trends would be complete without a mention of IPv6. The
original work began in 1993, and the design has been in place for many years. Originally, proponents claimed that IPv6 was needed because IPv4 could not handle audio or
video, was not secure, and would run out of addresses. Each year since the creation of
IPv6, various groups from academia and industry have predicted the doom of IPv4 and
the rise of IPv6. Meanwhile, IPv4 has adapted, runs multimedia applications, and has
as much security as IPv6. NAT and CIDR addressing have extended the IPv4 addressing capabilities. IPv4 continues as the fundamental protocol of the Internet.

<br>
<br>
