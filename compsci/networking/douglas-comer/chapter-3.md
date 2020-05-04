# Chapter 4: Traditional Internet Applications

- __`Introduction`__ -- The previous chapter introduces the topics of Internet applications and network
programming. The chapter explains that Internet services are defined by application
programs, and characterizes the client-server model that such programs use to interact.
The chapter also covers the socket API

- __`Application-Layer Protocols`__ -- Whenever a programmer creates two applications that communicate over a network, the programmer specifies details, such as:
  - The syntax and semantics of messages that can be exchanged
  - Whether the client or server initiates interaction
  - Actions to be taken if an error arises
  - How the two sides know when to terminate communication
  
  In specifying details of communication, a programmer defines an application-layer protocol. There are two broad types of application-layer protocols that depend on the intended use:
  - Private communication. A programmer creates a pair of applications that communicate over the Internet with the intention that the
pair is for private use. In most cases, the interaction between the
two applications is straightforward, which means a programmer
may choose to write code without writing a formal protocol specification.
  - Standardized service. An Internet service is defined with the expectation that many programmers will create server software to
offer the service or client software to access the service. In such
cases, the application-layer protocol must be documented independent of any implementation, and the specification must be precise
and unambiguous so that all clients and servers can interoperate
correctly.
  
- __`Representation And Transfer`__ -- Application-layer protocols specify two aspects of interaction: representation and
transfer. For a basic service, a single protocol standard can specify both aspects; more complex services use separate protocol standards to specify each aspect.

- __`Web Protocols`__ -- The World Wide Web is one of the most widely used services in the Internet. Because the Web is complex, many protocol standards have been devised to specify various aspects and details. Such as HTML, URL, HTTPS

- __`Document Representation With HTML`__ -- HyperText Markup Language is a representation standard for web
pages. To permit a page to be displayed on an arbitrary device,
HTML gives general guidelines for display and allows a browser to
choose details.

- __`Uniform Resource Locators And Hyperlinks`__ -- The Web uses a syntactic form known as a Uniform Resource Locator (URL) tospecify a web page. The general form of a URL is:
  ```
  protocol:// computer_name:port/ document_name%parameters
  ```
  where protocol is the name of the protocol used to access the document,
computer_name is the domain name of the computer on which the document resides,
:port is an optional protocol port number at which the server is listening,
document_name is the optional name of the document on the specified computer, and
%parameters give optional parameters for the page.
For example, the URL
  ```
  https://netbook.cs.purdue.edu/toc/toc01.htm
  ```

- __`Web Document Transfer With HTTP`__ -- The HyperText Transfer Protocol (HTTP) is the primary transfer protocol that a
browser uses to interact with a web server
  - `GET` -- Requests a document; server responds by sending status
information followed by a copy of the document
  - `HEAD` -- Requests status information; server responds by sending
status information, but does not send a copy of the document
  - `POST` -- Sends data to a server; the server appends the data to a
specified item (e.g., a message is appended to a list)
  - `PUT` -- Sends data to a server; the server uses the data to completely
replace the specified item (i.e., overwrites the previous data)

  The most common form of interaction begins when a browser requests a page from
the server. The browser sends a GET request over the connection, and the server
responds by sending a header, a blank line, and the requested document.

  When using HTTP, a browser sends version information which allows
a server to choose the highest version of the protocol that they both
understand.

  The first line of a response header contains a status code that tells the browser
whether the server handled the request. Status code represent the status of the state such as 200s (OK) 300s (Redirect) 400s (Client Error) 500s (Server Error)

- __`Caching In Browsers`__ -- Caching provides an important optimization for web access because users tend to
visit the same web sites repeatedly. Much of the content at a given site consists of
large images that use the Graphics Image Format (GIF) or Joint Picture Encoding
Group (JPEG) standards. Such images often contain backgrounds or banners that do
not change frequently. The key idea is:

  A browser can reduce download times significantly by saving a copy
of each image in a cache on the user’s disk and using the cached
copy.

- __`Browser Architecture`__ -- Because it provides general services and supports a graphical interface, a browser
is complex. Of course, a browser must understand HTTP, but a browser also provides
support for other protocols. In particular, because a URL can specify a protocol, a
browser must contain client code for each of the protocols used. For each service, the
browser must know how to interact with a server and how to interpret responses. For
example, a browser must know how to access the FTP service discussed in the next section.

- __`File Transfer Protocol (FTP)`__ -- A file is the fundamental storage abstraction. Because a file can hold an arbitrary
object (e.g., a document, spreadsheet, computer program, graphic image, or data), a facility that sends a copy of a file from one computer to another provides a powerful
mechanism for the exchange of data. We use the term file transfer for such a service. The most widely-deployed file transfer service in the Internet uses the File
Transfer Protocol (FTP). 

- __`FTP Communication Paradigm`__ -- One of the most interesting aspects of FTP arises from the way a client and server
interact. Overall, the approach seems straightforward: a client establishes a connection
to an FTP server and sends a series of requests to which the server responds. Unlike
HTTP, an FTP server does not send responses over the same connection on which the
client sends requests. Instead, the original connection the client creates, called a control
connection, is reserved for commands Each time the server needs to download or
upload a file, the server opens a new connection. To distinguish them from the control
connection, the connections used to transfer files are called data connections

- __`Electronic Mail`__ -- Although services such as instant messaging have become popular, email remains
one of the most widely used Internet applications s, even early email software was divided into two conceptually separate pieces:
  - An email interface application
  - A mail transfer program
  
  A user invokes the email interface application directly. The interface provides
mechanisms that allow a user to compose and edit outgoing messages as well as read
and process incoming email. The email interface application does not act as a client or
server, and does not transfer messages to other users. Instead, the interface application
reads messages from the user’s mailbox (i.e., a file on the user’s computer) and deposits
outgoing messages in an outgoing mail queue (typically a folder on the user’s disk).
Separate programs known as a mail transfer program and a mail server handle transfer.
The mail transfer program acts as a client to send a message to the mail server on the
destination computer; the mail server accepts incoming messages and deposits each in
the appropriate user’s mailbox

- __`The Simple Mail Transfer Protocol (SMTP)`__ -- The Simple Mail Transfer Protocol (SMTP) is the standard protocol that a mail transfer program uses to transfer a mail message across the Internet to a server.

  The most unexpected aspect of SMTP arises from its restriction to textual content.
A later section explains the MIME standard that allows email to include attachments
such as graphic images or binary files, but the underlying SMTP mechanism is restricted to text.

- __`ISPs, Mail Servers, And Mail Access`__ -- As the Internet expanded to include consumers, a new paradigm arose for email. Because most users leave their computer running continuously and do not know how to
configure and manage an email server, ISPs began offering email services. In essence,
an ISP runs an email server and provides a mailbox for each subscriber. Email access follows one of two forms:
  - A special-purpose email interface application
  - A web browser that accesses an email web page
  
   The chief advantage
of using a web page for email arises from the ability to read email from any computer
— a user does not need to run a special mail interface application

- __`Mail Access Protocols (POP, IMAP)`__ -- A variety of mechanisms have been proposed for email access. Some ISPs provide
free email access software to their subscribers. In addition, two standard email access
protocols have been created. 
  - `POP3` -- Post Office Protocol version 3
  - `IMAP` -- Internet Mail Access Protocol

  Although they offer the same basic services, the two protocols differ in many details. In particular, each provides its own authentication mechanism that a user follows
to identify themselves

- __`Email Representation Standards (RFC2822, MIME)`__ -- Two important email representation standards exist:
  - RFC2822 Mail Message Format
  - Multi-purpose Internet Mail Extensions (MIME)
  
  Multi-purpose Internet Mail Extensions (MIME). Recall that SMTP only supports
text messages. The MIME standard extends the functionality of email to allow the
transfer of non-text data in a message. MIME specifies how a binary file can be encoded into printable characters, included in a message, and decoded by the receiver.

  The MIME standard inserts extra header lines to allow non-text attachments to be sent within an email message. An attachment is encoded as printable letters, and a separator line appears before each
attachment.

- __`Domain Name System (DNS)`__ -- The Domain Name System (DNS) provides a service that maps human-readable
symbolic names to computer addresses. Browsers, mail software, and most other Internet applications use the DNS. The system provides an interesting example of clientserver interaction because the mapping is not performed by a single server

  For example, a computer in the Computer Science Department at Purdue University has the domain name:  - 
  - `mordred.cs.purdue.edu`
  and a computer at Cisco, Incorporated has the domain name:
  - `anakin.cisco.com`
  Domain names are hierarchical, with the most significant part of the name on the
right. The left-most segment of a name (mordred and anakin in the examples) is the
name of an individual computer. Other segments in a domain name identify the group
that owns the name. For example, the segment purdue gives the name of a university,
and cisco gives the name of a company. DNS does not specify the number of segments
in a name. Instead, each organization can choose how many segments to use for computers inside the organization and what the segments represent

  An organization applies for a name under one of the existing top-level domains.
For example, most U.S. corporations choose to register under the com domain Once the name has been assigned another organization named Foobar can apply for
foobar.biz or foobar.org, but not foobar.com.

- __`Domain Names That Begin With www`__ -- Many organizations assign domain names that reflect the service a computer provides. For example, a computer that runs a server for the File Transfer Protocol might
be named:
  ```
  ftp.foobar.com
  ```
  Similarly, a computer that runs a web server, might be named:
  ```
  www.foobar.com
  ```
  Such names are mnemonic, but are not required. In particular, the use of www to
name computers that run a web server is merely a convention — an arbitrary computer
can run a web server, even if the computer’s domain name does not contain www.
Furthermore, a computer that has a domain name beginning with www is not required to
run a web server is merely a convention to help humans.

- __`The DNS Hierarchy And Server Model`__ -- One of the main features of the Domain Name System is autonomy — the system
is designed to allow each organization to assign names to computers or to change those
names without informing a central authority. To achieve autonomy, each organization
is permitted to operate DNS servers for its part of the hierarchy. Thus, Purdue University operates a server for names ending in purdue.edu, and IBM Corporation operates a
server for names ending in ibm.com.

  For example, a small
organization that only has a few computers can contract with an ISP to run a DNS
server. A large organization that runs its own server can choose to place all names for
the organization in a single physical server, or can choose to divide its names among
multiple server

- __`Name Resolution`__ -- The translation of a domain name into an address is called name resolution, and
the name is said to be resolved to an address. Software to perform the translation is
known as a name resolver (or simply resolver). In the socket API, for example, the
resolver is invoked by calling function gethostbyname. The resolver becomes a client,
contacts a DNS server, and returns an answer to the caller

- __`Caching In DNS Servers`__ -- The locality of reference principle that forms the basis for caching applies to the
Domain Name System in two ways:
  - Spatial: A user tends to look up the names of local computers more
often than the names of remote computers
  - Temporal: A user tends to look up the same set of domain names
repeatedly

- __`Types Of DNS Entries`__ -- Each entry in a DNS database consists of three items: a domain name, a record
type, and a value. The record type specifies how the value is to be interpreted (e.g., that
the value is an IP address). More important, a query sent to a DNS server specifies
both a domain name and a type; the server only returns a binding that matches the type
of the query The principal type maps a domain name to an IP address.

- __`Aliases And CNAME Resource Records`__ -- The DNS offers a CNAME type that is analogous to a symbolic link in a file system — the entry provides an alias for another DNS entry. To understand how aliases
can be useful, suppose Foobar Corporation has two computers named
hobbes.foobar.com and calvin.foobar.com. Further suppose that Foobar decides to
run a web server on computer hobbes, and wants to follow the convention of using the
name www for the computer that runs the organization’s web server. Although the organization could choose to rename computer hobbes, a much easier solution exists: the
organization can create a CNAME entry for www.foobar.com that points to hobbes.

- __`Internationalized Domain Names`__ -- Because it uses the ASCII character set, the DNS cannot store names in alphabets
that are not represented in ASCII. In particular, languages such as Russian, Greek,
Chinese, and Japanese each contain characters for which no ASCII representation exists.
Many European languages use diacritical marks that cannot be represented in ASCII.
For years, the IETF debated modifications and extensions of the DNS to accommodate international domain names. After considering many proposals, the IETF chose an
approach known as Internationalizing Domain Names in Applications (IDNA). Instead
of modifying the underlying DNS, IDNA uses ASCII to store all names. That is, when
given a domain name that contains a non-ASCII character, IDNA translates the name
into a sequence of ASCII characters, and stores the result in the DNS.

- __`Extensible Representations (XML)`__ -- The traditional application protocols covered in this chapter each employ a fixed
representation. That is, the application protocol specifies an exact set of messages that
a client and server can exchange as well as the exact form of data that accompanies the
message.

  The alternative to a fixed representation is an extensible system that allows a
sender to specify the format of data. One standard for extensible representation has become widely accepted: the Extensible Markup Language (XML). XML resembles
HTML in the sense that both languages embed tags into a text document

  Instead, XML describes the structure of data and provides names for each
field. Tags in XML are well-balanced — each occurrence of a tag <X> must be followed by an occurrence of </X>. Furthermore, because XML does not assign any
meaning to tags, tag names can be created as needed. In particular, tag names can be
selected to make data easy to parse or access. For example, if two companies agree to
exchange corporate telephone directories, they can define an XML format that has data
items such as an employee’s name, phone number, and office
  ```xml
  <ADDRESS>
    <NAME>
      <FIRST> John </FIRST>
      <LAST> Public </LAST>
    </NAME>
    <OFFICE> Room 320 </OFFICE>
    <PHONE> 765-555-1234 </PHONE>
  </ADDRESS>
  ```

<br>
<br>

---

<br>
<br>


# Chapter 5: Overview of Data Communications

- __`Introduction`__ -- The first part of the text discusses network programming and reviews Internet applications. The chapter on socket programming explains the API that operating systems
provide to application software, and shows that a programmer can create applications
that use the Internet without understanding the underlying mechanisms. In the
remainder of the text, we will learn about the complex protocols and technologies that
support communication, and see that understanding the complexity can help programmers write better code.

  This part of the text explores the transmission of information across physical
media, such as wires, optical fibers, and radio waves More important, data communications tells us what transfers are theoretically possible
as well as how the reality of the physical world limits practical transmission systems

- __`The Essence Of Data Communications`__ -- Because it involves the transmission of information over physical media, data communications touches on physics. The subject draws on ideas about electric current,
light, and other forms of electro-magnetic radiation. Because information is digitized
and digital data is transmitted, data communications uses mathematics and includes
various forms of analysis. Finally, because the ultimate goal is to develop practical
ways to design and build transmission systems, data communications focuses on
developing techniques that electrical engineers can use. (so basically electrical engineering, physics, mathematics)

- __` The Subtopics Of Data Communications`__ -- To simplify understanding, engineers have devised a conceptual framework for
data communications systems. The framework divides the entire subject into a set of
subtopics.The following paragraphs explain the subtopics. Successive chapters each examine one of the conceptual subtopics:
  - `Information Sources`. The source of information can be either analog or digital. Important concepts include characteristics of signals,
such as amplitude, frequency, and phase, and classification as either periodic or aperiodic.
  - `Source Encoder and Decoder`. Once information has been digitized, digital representations can be transformed and converted.
  - `Encryptor and Decryptor`. To protect information and keep it
private, the information can be encrypted (i.e., scrambled) before
transmission and decrypted upon reception.
  - `Channel Encoder and Decoder`. Channel coding is used to detect
and correct transmission errors. Important topics include methods
to detect and limit errors, and practical techniques like parity
checking, checksums ... etc.
  - `Multiplexor and Demultiplexor`. Multiplexing refers to the way information from multiple sources is combined for transmission across a shared medium
  - `Modulator and Demodulator`. Modulation refers to the way electromagnetic radiation is used to send information. Concepts include both analog and digital modulation schemes
  - `Physical Channel and Transmission`. The subtopic includes
transmission media and transmission modes. Important concepts
include bandwidth, electrical noise and interference, and channel
capacity,

<br>
<br>

---

<br>
<br>


