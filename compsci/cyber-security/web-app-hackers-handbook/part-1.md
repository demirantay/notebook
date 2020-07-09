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

### The Evolution of Web Applications 

- `Common Web Application Functions ` -- 

- `Benefi ts of Web Applications ` --

### Web Application Security

- `“This Site Is Secure”` --

- `The Core Security Problem: Users Can Submit` --

- `Key Problem Factors` --

- `The New Security Perimeter ` --

- `The Future of Web Application Security` --

### Summary 

<br>
<br>

---

<br>
<br>

# Chapter 2 Core Defense Mechanisms 

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

### Summary

<br>
<br>

---

<br>
<br>

# Chapter 3 Web Application Technologies

### The HTTP Protocol 

- `HTTP Requests ` --

- `HTTP Responses` --

- `HTTP Methods` --

- `URLs` --

- `REST` --

- `HTTP Headers` --

- `Cookies` --

- `Status Codes` --

- `HTTPS` --

- `HTTP Proxies` --

- `HTTP Authentication` --

### Web Functionality 

- `Server-Side Functionality ` --

- `Client-Side Functionality ` --

- `State and Sessions ` --

### Encoding Schemes 

- `URL Encoding` --

- `Unicode Encoding` --

- `HTML Encoding ` --

- `Base64 Encoding ` --

- `Hex Encoding ` --

- `Remoting and Serialization` --

### Next Steps 

<br>
<br>

---

<br>
<br>

# Chapter 4 Mapping the Application 

### Enumerating Content and Functionality 

- `Web Spidering` --

- `User-Directed Spidering ` --

- `Discovering Hidden Content ` --

- `Application Pages Versus ` --

- `Discovering Hidden Parameters` --

### Analyzing the Application

- `Identifying Entry Points for User Input ` --

- `Identifying Server-Side Technologies ` --

- `Identifying Server-Side Functionality ` --

- `Mapping the Attack Surface ` --

### Summary

<br>
<br>

---

<br>
<br>
