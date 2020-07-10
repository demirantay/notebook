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

- A central security requirement that virtually any application needs to meet is
controlling users’ access to its data and functionality. A typical situation has
several different categories of user, such as anonymous users, ordinary authenticated users, and administrative users Furthermore, in many situations different
users are permitted to access a different set of data

  Most web applications handle access using a trio of interrelated security
mechanisms:
  - authentication
  - session management
  - access control
 
- `Authentication` -- The authentication mechanism is logically the most basic dependency in an
application’s handling of user access. Authenticating a user involves establishing 
that the user is in fact who he claims to be. Without this facility, the application
would need to treat all users as anonymous. In security-critical applications such as those used by online banks, this basic
model is usually supplemented by additional credentials and a multistage login
process.

  Common problems
may enable an attacker to identify other users’ usernames, guess their passwords, or bypass the login function by exploiting defects in its logic. When
you are attacking a web application, you should invest a signifi cant amount of
attention to the various authentication-related functions it contains

- `Session Management` -- The next logical task in the process of handling user access is to manage the
authenticated user’s session. To enforce effective access control, the application needs a way to
identify and process the series of requests that originate from each unique user.
Virtually all web applications meet this requirement by creating a session for
each user and issuing the user a token that identifi es the session.

  HTTP cookies are the
standard method for transmitting session tokens, although many applications
use hidden form fi elds or the URL query string for this purpose If a user does
not make a request for a certain amount of time, the session is ideally expired

  In terms of attack surface, the session management mechanism is highly
dependent on the security of its tokens. The majority of attacks against it seek to
compromise the tokens issued to other users. If this is possible, an attacker can
masquerade as the victim user and use the application just as if he had actually
authenticated as that user

- `Access Control` -- The fi nal logical step in the process of handling user access is to make and enforce
correct decisions about whether each individual request should be permitted or
denied. If the mechanisms just described are functioning correctly, the application knows the identity of the user from whom each request is received. On this
basis, it needs to decide whether that user is authorized to perform the action,
or access the data, that he is requesting,

  The access control mechanism usually needs to implement some fi ne-grained
logic, with different considerations being relevant to different areas of the
application and different types of functionality

   Developers often make
fl awed assumptions about how users will interact with the application and
frequently make oversights by omitting access control checks from some application functions

### Handling User Input

- Input-based vulnerabilities can arise anywhere within an application’s functionality, and in relation to practically every type of technology in common use.
“Input validation” is often cited as the necessary defense against these attacks. 

- `Varieties of Input ` -- In addition to the various kinds of input that users enter using the browser
interface, a typical application receives numerous items of data that began their
life on the server and that are sent to the client so that the client can transmit
them back to the server on subsequent requests. This includes items such as
cookies and hidden form fi elds, which are not seen by ordinary users of the
application but which an attacker can of course view and modify

- `Approaches to Input Handling ` --

  “Reject Known Bad” -- This approach typically employs a blacklist containing a set of literal strings or
patterns that are known to be used in attacks. The validation mechanism blocks
any data that matches the blacklist and allows everything else. In general, this is regarded as the least effective approach to validating user
input but still a defense mechanism.

  “Accept Known Good” -- This approach employs a whitelist containing a set of literal strings or patterns,
or a set of criteria, that is known to match only benign input. The validation
mechanism allows data that matches the whitelist and blocks everything else. In cases where this approach is feasible, it is regarded as the most effective
way to handle potentially malicious input. But this is hard to implement because some applications have so many input variables such as socaial media, blogs ... etc. It is hard to follow.

  Sanitization  -- This approach recognizes the need to sometimes accept data that cannot be
guaranteed as safe. Instead of rejecting this input, the application sanitizes it
in various ways to prevent it from having any adverse effects. Potentially malicious characters may be removed from the data, leaving only what is known to
be safe Approaches based on data sanitization are often highly effective, and in many
situations they can be relied on as a general solution

  Safe Data Handling -- Many web application vulnerabilities arise because user-supplied data is processed in unsafe ways  In some situations, safe programming methods are available
that avoid common problems. For example, SQL injection attacks can be prevented through the correct use of parameterized queries for database access 

  Semantic Checks -- For example, an attacker might seek to gain access to
another user’s bank account by changing an account number transmitted in a
hidden form fi eld. No amount of syntactic validation will distinguish between
the user’s data and the attacker’s. To prevent unauthorized access, the application needs to validate that the account number submitted belongs to the user
who has submitted it.

- `Boundary Validation` -- A more effective model uses the concept of boundary validation. Here, each
individual component or functional unit of the server-side application treats
its inputs as coming from a potentially malicious source. Data validation is
performed at each of these trust boundaries, in addition to the external frontier
between the client and server
  
  lets see a basic defense senario for a login feature to paint a picture of what we learned:
  - 1 -  The application receives the user’s login details. The form handler validates that each item of input contains only permitted characters, is within
a specifi c length limit, and does not contain any known attack signatures
  - 2 - The application performs a SQL query to verify the user’s credentials.
To prevent SQL injection attacks, any characters within the user input
that may be used to attack the database are escaped before the query is
constructed.
  - 3 - If the login succeeds, the application passes certain data from the user’s
profi le to a api serviceto retrieve further info about her account. Use API/JOSN defensive mechanisms here.
  - 4 - The application displays the user’s account information back to the user’s
browser. To prevent cross-site scripting attacks, the application HTMLencodes any user-supplied data that is embedded into the returned page.

- `Multistep Validation and Canonicalization` -- A common problem encountered by input-handling mechanisms arises when
user-supplied input is manipulated across several steps as part of the validation logic. If this process is not handled carefully, an attacker may be able to
construct crafted input that succeeds in smuggling malicious data through the
validation mechanism.

  A related problem arises in relation to data canonicalization. When input
is sent from the user’s browser, it may be encoded in various ways. These
encoding schemes exist so that unusual characters and binary data may be
transmitted safely over HTTP (see Chapter 3 for more details). Canonicalization
is the process of converting or decoding data into a common character set. 

  Avoiding problems with multistep validation and canonicalization can sometimes be diffi cult, and there is no single solution to the problem. One approach is
to perform sanitization steps recursively, continuing until no further modifi cations
have been made on an item of input.

### Handling Attackers 

- Anyone designing an application for which security is remotely important must
assume that it will be directly targeted by dedicated and skilled attackers. Measures implemented to handle attackers
typically include the following tasks:
  - Handling errors
  - Maintaining audit logs
  - Alerting administrators
  - Reacting to attacks

- `Handling Errors` -- However careful an application’s developers are when validating user input, it
is virtually inevitable that some unanticipated errors will occur. Therefore, they are taken into account before
the application is deployed in a production context. A key defense mechanism is for the application to handle unexpected errors
gracefully, and either recover from them or present a suitable error message
to the user. In a production context, the application should never return any
system-generated messages or other debug information in its responses. Most web development languages provide good error-handling support
through try-catch blocks and checked exceptions

- `Maintaining Audit Logs ` -- Audit logs are valuable primarily when investigating intrusion attempts against
an application. Following such an incident, effective audit logs should enable
the application’s owners to understand exactly what has taken place, which
vulnerabilities (if any) were exploited, whether the attacker gained unauthorized
access to data or performed any unauthorized actions, and, as far as possible,
provide evidence of the intruder’s identity

  In any application for which security is important, key events should be logged
as a matter of course. At a minimum, these typically include the following:
  - All events relating to the authentication functionality, such as successful
and failed login, and change of password
  - Key transactions, such as credit card payments and funds transfers
  - Access attempts that are blocked by the access control mechanisms
  - Any requests containing known attack strings that indicate overtly malicious intentions
  
  In many security-critical applications, such as those used by online banks,
every client request is logged in full, providing a complete forensic record that
can be used to investigate any incidents.

  Effective audit logs typically record the time of each event, the IP address
from which the request was received, and the user’s account (if authenticated).
Such logs need to be strongly protected against unauthorized read or write
access.

  In terms of attack surface, poorly protected audit logs can provide a gold mine
of information to an attacker, disclosing a host of sensitive information such as
session tokens and request parameters. This information may enable the attacker
to immediately compromise the entire application

- `Alerting Administrators` -- Audit logs enable an application’s owners to retrospectively investigate intrusion
attempts and, if possible, take legal action against the perpetrator. However, in
many situations it is desirable to take much more immediate action, in real time,
in response to attempted attacks. For example, administrators may block the IP
address

  A well-designed alerting mechanism can
use a combination of factors to diagnose that a determined attack is under way
and can aggregate related events into a single alert where possible

  Web application fi rewalls usually are good at identifying the
most obvious attacks, where an attacker submits standard attack strings in
each request parameter

- `Reacting to Attacks` -- In addition to alerting administrators, many security-critical applications contain built-in mechanisms to react defensively to users who are identifi ed as
potentially malicious

   At some point, an
attacker working systematically is likely to discover these defects.
For this reason, some applications take automatic reactive measures to frustrate the activities of an attacker who is working in this way. For example, they
might respond increasingly slowly to the attacker’s requests or terminate the
attacker’s session, requiring him to log in or perform other steps before continuing the attack. Although these measures will not defeat the most patient
and determined attacker, they will deter many more casual attackers and will
buy additional time for administrators

### Managing the Application

- Any useful application needs to be managed and administered. This facility
often forms a key part of the application’s security mechanisms, providing a
way for administrators to manage user accounts and roles, access monitoring
and audit functions, perform diagnostic tasks, and confi gure aspects of the
application’s functionality.

  In many applications, administrative functions are implemented within
the application itself, accessible through the same web interface as its core
nonsecurity functionality. Where this is the case, the
administrative mechanism represents a critical part of the application’s attack
surface. ALWAYS SECURE YOUR ADMIN PANEL AS MUCH AS POSSIBLE.

<br>
<br>


