# The Web Application Hacker’s Handbook 2nd Edition

Table of Contents:

- [Introduction]()
- [Chapter 1 Web Application (In)security ]()
- [Chapter 2 Core Defense Mechanisms ]()
- [Chapter 3 Web Application Technologies]()
- [Chapter 4 Mapping the Application]()
- [Chapter 5 Bypassing Client-Side Controls]()
- [Chapter 6 Attacking Authentication]()
- [Chapter 7 Attacking Session Management]()
- [Chapter 8 Attacking Access Controls ]()
- [Chapter 9 Attacking Data Stores]()
- [Chapter 10 Attacking Back-End Components]()
- [Chapter 11 Attacking Application Logic ]()
- [Chapter 12 Attacking Users: Cross-Site Scripting]()
- [Chapter 13 Attacking Users: Other Techniques ]()
- [Chapter 14 Automating Customized Attacks]()
- [Chapter 15 Exploiting Information Disclosure]()
- [Chapter 16 Attacking Native Compiled Applications]()
- [Chapter 17 Attacking Application Architecture]()
- [Chapter 18 Attacking the Application Server]()
- [Chapter 19 Finding Vulnerabilities in Source Code]()
- [Chapter 20 A Web Application Hacker’s Toolkit]()
- [Chapter 21 A Web Application Hacker’s Methodology ]()

<br>
<br>

---

<br>
<br>

# Introduction

- This book is a practical guide to discovering and exploiting security fl aws in
web applications. By “web applications” we mean those that are accessed using
a web browser to communicate with a web server. We examine a wide variety
of different technologies, such as databases, fi le systems, and web services, but
only in the context in which these are employed by web applications.

  If you want to learn how to run port scans, attack fi rewalls, or break into servers in other ways, we suggest you look elsewhere. But if you want to know how
to hack into a web application, steal sensitive data, and perform unauthorized
actions, this is the book for you

### Overview of This Book

- The focus of this book is highly practical. Although we include suffi cient background and theory for you to understand the vulnerabilities that web applications
contain, our primary concern is the tasks and techniques that you need to master
to break into them

- Security awareness is usually a double-edged sword. Just as application
developers can benefi t from understanding the methods attackers use, hackers
can gain from knowing how applications can effectively defend themselves

  In addition to describing security vulnerabilities and attack techniques, we
describe in detail the countermeasures that applications can take

### How This Book Is Organized

- We begin with three context-setting chapters describing the current state of
web application security and the trends that indicate how it is likely to evolve
in the near future

  The bulk of the book is concerned with our core topic — the techniques
you can use to break into web applications. This material is organized around
the key tasks you need to perform to carry out a comprehensive attack.

  Chapter 1, “Web Application (In)security,” describes the current state of security in web applications on the Internet today
  
  Chapter 2, “Core Defense Mechanisms,” describes the key security mechanisms
that web applications employ to address the fundamental problem that all user
input is untrusted

  Chapter 3, “Web Application Technologies,” is a short primer on the key
technologies you are likely to encounter when attacking web applications

  Chapter 4, “Mapping the Application,” describes the fi rst exercise you need
to perform when targeting a new application — gathering as much information
as possible to map its attack surface and formulate your plan of attack.

  Chapter 5, “Bypassing Client-Side Controls,” covers the fi rst area of actual
vulnerability, which arises when an application relies on controls implemented
on the client side for its security

  Chapters 6, 7, and 8 cover some of the most important defense mechanisms
implemented within web applications: those responsible for controlling user
access

  Chapters 9 and 10 cover a large category of related vulnerabilities, which
arise when applications embed user input into interpreted code in an unsafe
way. 

  Chapter 11, “Attacking Application Logic,” examines a signifi cant, and frequently overlooked, area of every application’s attack surface: the internal logic
it employs to implement its functionality

  Chapters 12 and 13 cover a large and very topical area of related vulnerabilities that arise when defects within a web application can enable a malicious
user of the application to attack other users and compromise them in various ways

  Chapter 14, “Automating Customized Attacks,” does not introduce any new
categories of vulnerabilities. Instead, it describes a crucial technique you need
to master to attack web applications effectively  

  Chapter 15, “Exploiting Information Disclosure,” examines various ways in
which applications leak information when under active attack

  Chapter 16, “Attacking Native Compiled Applications,” looks at a set of important vulnerabilities that arise in applications written in native code languages
such as C and C++. 

  Chapter 17, “Attacking Application Architecture,” examines an important area
of web application security that is frequently overlooked

  Chapter 18, “Attacking the Application Server,” describes various ways in
which you can target a web application by targeting the web server on which
it is running

  Chapter 19, “Finding Vulnerabilities in Source Code,” describes a completely
different approach to fi nding security fl aws than those described elsewhere
within this book.

  Chapter 20, “A Web Application Hacker’s Toolkit,” pulls together the various
tools described in this book. These are the same tools the authors use when attacking real-world web applications

  Chapter 21, “A Web Application Hacker’s Methodology,” is a comprehensive
and structured collation of all the procedures and techniques described in this
book

### Tools You Will Need

- This book is strongly geared toward hands-on techniques you can use to attack
web applications. After reading the book, you will understand the specifi cs of
each individual task, what it involves technically, and why it helps you detect
and exploit vulnerabilities. The book is emphatically not about downloading
a tool, pointing it at a target application, and believing what the tool’s output
tells you about the state of the application’s security.

  That said, you will fi nd several tools useful, and sometimes indispensable,
when performing the tasks and techniques we describe.

<br>
<br>

---

<br>
<br>

# Chapter 1 Web Application (In)security 

- There is no doubt that web application security is a current and newsworthy
subject. For all concerned, the stakes are high: for businesses that derive increasing revenue from Internet commerce, for users who trust web applications with
sensitive information, and for criminals who can make big money by stealing
payment details or compromising bank accounts.  Reputation plays a critical role.
Few people want to do business with an insecure website.

### The Evolution of Web Applications 

- In the early days of the Internet, the World Wide Web consisted only of web
sites. These were essentially information repositories containing static documents. Web browsers were invented as a means of retrieving and displaying
those documents. The fl ow of interesting information
was one-way, from server to browser. Any security threats arising from hosting a website were related largely to vulnerabilities in web server software. . If an attacker compromised a web server, he usually
would not gain access to any sensitive information, because the information
held on the server was already open to public view

  Today, the World Wide Web is almost unrecognizable from its earlier form.
The majority of sites on the web are in fact application. They support registration and login, fi nancial transactions, search, and the authoring of content by users.  Security,
therefore, is a big issue. No one wants to use a web application if he believes
his information will be disclosed to unauthorized parties Fifteen years ago, if you wanted
to make a funds transfer, you visited your bank, and the teller performed the
transfer for you; today, you can visit a web application and perform the transfer
yourself. An attacker who compromises a web application may be able to steal
personal information,

- `Common Web Application Functions ` -- Here are some web application functions
that have risen to prominence in recent years:
  - Shopping (Amazon)
  - Social networking (Facebook)
  - Banking (Citibank)
  - Web search (Google)
  - Auctions (eBay)
  - Gambling (Betfair)
  - Web logs (Blogger)
  - Web mail (Gamil)
  - Interactive information (Wikipedia)
  
  Most mobile applications employ either a browser or a customized client that uses
HTTP-based APIs to communicate with the server. Application functions and
data typically are shared between the various interfaces that the application
exposes to different user platforms.

  The time is fast approaching when the only client software that most computer users will need is a web browser. A diverse range of functions will have
been implemented using a shared set of protocols and technologies, and in so
doing will have inherited a distinctive range of common security vulnerabilities.
  
- `Benefi ts of Web Applications ` -- 
  - Every web user already has a browser installed on his computer and
mobile device. Web applications deploy their user interface dynamically
to the browser, avoiding the need to distribute and manage separate
client software, as was the case with pre-web applications
  - The core technologies and languages used to develop web applications are
relatively simple. A wide range of platforms and development tools are
available to facilitate the development of powerful applications by relative
beginners

### Web Application Security

- As with any new class of technology, web applications have brought with them
a new range of security vulnerabilities. The most serious attacks against web applications are those that expose
sensitive data or gain unrestricted access to the back-end systems on which
the application is running

  For many organizations, however, any attack that causes
system downtime is a critical event.

- `“This Site Is Secure”` -- In fact, the majority of web applications are insecure, despite the widespread
usage of SSL technology and the adoption of regular PCI scanning. The authors
of this book have tested hundreds of web applications in recent years. Figure 1-3
shows what percentage of applications tested during 2007 and 2011 were found
to be affected by some common categories of vulnerability:
  - Broken authentication (62%) — This category of vulnerability encompasses various defects within the application’s login mechanism, which
may enable an attacker to guess weak passwords, launch a brute-force attack, or bypass the login.
  - Broken access controls (71%) — This involves cases where the application
fails to properly protect access to its data and functionality, potentially
enabling an attacker to view other users’ sensitive data held on the server
or carry out privileged actions.
  - SQL injection (32%) — This vulnerability enables an attacker to submit
crafted input to interfere with the application’s interaction with back-end
databases. An attacker may be able to retrieve arbitrary data from the
application, interfere with its logic, or execute commands on the database
server itself.
  - Cross-site scripting (94%) — This vulnerability enables an attacker to
target other users of the application, potentially gaining access to their
dat
  - Information leakage (78%) — This involves cases where an application
divulges sensitive information that is of use to an attacker in developing
an assault against the application
  - Cross-site request forgery (92%) — This fl aw means that application
users can be induced to perform unintended actions on the application
within their user context and privilege level.
  
- `The Core Security Problem: Users Can Submit` -- As with most distributed applications, web applications face a fundamental
problem they must address to be secure. Because the client is outside of the
application’s control, users can submit arbitrary input to the server-side application. The application must assume that all input is potentially malicious

  The majority of attacks against web applications involve sending input to the
server that is crafted to cause some event that was not expected or desired by
the application’s designer.

  Needless to say, SSL does nothing to stop an attacker from submitting crafted
input to the server. If the application uses SSL, this simply means that other users
on the network cannot view or modify the attacker’s data in transit

- `The New Security Perimeter ` -- Before the rise of web applications, organizations’ efforts to secure themselves
against external attack were largely focused on the network perimeter. Defending
this perimeter entailed hardening and patching the services it needed to expose
and fi rewalling access to others.

  If a vulnerability exists within a web application, an attacker on the public
Internet may be able to compromise the organization’s core back-end systems
solely by submitting crafted data from his web browser. This data sails past all
the organization’s network defenses, in the same way as does ordinary, benign
traffi c to the web application. If a vulnerability exists within a web application, an attacker on the public
Internet may be able to compromise the organization’s core back-end systems
solely by submitting crafted data from his web browser. This data sails past all
the organization’s network defenses, in the same way as does ordinary, benign
traffi c to the web application.

> For example, suppose that an attacker wants to “hack in” to a bank’s systems
and steal money from users’ accounts. In the past, before the bank deployed
a web application, the attacker might have needed to fi nd a vulnerability
in a publicly reachable service, exploit this to gain a toehold on the bank’s
DMZ, penetrate the fi rewall restricting access to its internal systems, map the
network to fi nd the mainframe computer, decipher the arcane protocol used
to access it, and guess some credentials to log in. However, if the bank now
deploys a vulnerable web application, the attacker may be able to achieve the
same outcome simply by modifying an account number in a hidden fi eld of an
HTML form

- `The Future of Web Application Security` -- That said, the details of the web application security landscape are not static.
Even though old and well-understood vulnerabilities such as SQL injection
continue to appear, their prevalence is gradually diminishing. Furthermore,
the instances that remain are becoming more diffi cult to fi nd and exploit. New
research in these areas is generally focused on developing advanced techniques
for attacking more subtle manifestations of vulnerabilities that a few years ago
could be easily detected and exploited using only a browser.

  Despite all the changes that have occurred within web applications, some
categories of “classic” vulnerabilities show no sign of diminishing. They continue
to arise in pretty much the same form as they did in the earliest days of the
web. These include defects in business logic, failures to properly apply access
controls, and other design issues

<br>
<br>

---

<br>
<br>

# Chapter 2 Core Defense Mechanisms 

- The fundamental security problem with web applications — that all user input
is untrusted — gives rise to a number of security mechanisms that applications use to defend themselves against attack. Virtually all applications employ
mechanisms that are conceptually similar

  The defense mechanisms employed by web applications comprise the following
core elements:
  - Handling user access to the application’s data and functionality to prevent
users from gaining unauthorized access
  - Handling user input to the application’s functions to prevent malformed
input from causing undesirable behavior
  - Handling attackers to ensure that the application behaves appropriately
when being directly targeted, taking suitable defensive and offensive
measures to frustrate the attacker
  - Managing the application itself by enabling administrators to monitor its
activities and confi gure its functionality

  Because of their central role in addressing the core security problem, these
mechanisms also make up the vast majority of a typical application’s attack
surface. If knowing your enemy is the fi rst rule of warfare

### Handling User Access

- `Authentication` --

- `Session Management` --

- `Access Control` --

### Handling User Input

- `Varieties of Input ` --

- `Approaches to Input Handling ` --

- `Boundary Validation` --

- `Multistep Validation and Canonicalization` --

### Handling Attackers 

- `Handling Errors` --

- `Maintaining Audit Logs ` --

- `Alerting Administrators` --

- `Reacting to Attacks` --

### Managing the Application

<br>
<br>

---

<br>
<br>

