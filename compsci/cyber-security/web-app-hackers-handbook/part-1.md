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

###

###

###

###

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

# Chapter 5 Bypassing Client-Side Controls 

### Transmitting Data Via the Client

- Hidden Form Fields ` --

- `HTTP Cookies` --

- `URL Parameters ` --

- `The Referer Header ` --

- `Opaque Data` --

- `The ASP.NET ViewState ` --

### Capturing User Data: HTML Forms 

- `Length Limits ` --

- `Script-Based Validation` --

- `Disabled Elements` --
 
### Capturing User Data: Browser Extensions 

- `Common Browser Extension Technologies` --

- `Approaches to Browser Extensions ` --

- `Intercepting Traffi c from Browser Extensions` --

- `Decompiling Browser Extensions ` --

- `Attaching a Debugger ` --

- `Native Client Components` --

### Handling Client-Side Data Securely 

- `Transmitting Data Via the Client` --

- `Validating Client-Generated Data ` --

- `Logging and Alerting ` --

<br>
<br>

---

<br>
<br>

# Chapter 6 Attacking Authentication 

### Authentication Technologies 

- `Mechanisms` --

### Design Flaws in Authentication 
 
### Implementation Flaws in Authentication
 
### Securing Authentication 

### Summary

<br>
<br>

---

<br>
<br>

# Chapter 7 Attacking Session Management 

### The Need for State 

- `Alternatives to Sessions ` --
 
### Weaknesses in Token Generation 

- `Meaningful Tokens` --

- `Predictable Tokens` --

- `Encrypted Tokens ` --

### Weaknesses in Session Token Handling

- `Disclosure of Tokens on the Network` --

- `Disclosure of Tokens in Logs ` --

- `Vulnerable Mapping of Tokens to Sessions ` --

- `Vulnerable Session Termination ` --

- `Client Exposure to Token Hijacking ` --

- `Liberal Cookie Scope` --

### Securing Session Management 

- `Generate Strong Tokens` --

- `Protect Tokens Throughout Their Life Cycle` --

- `Log, Monitor, and Alert ` --

### Summary


<br>
<br>

---

<br>
<br>

# Chapter 8 Attacking Access Controls 

### Common Vulnerabilities 

- `Completely Unprotected Functionality ` --

- `Identifi er-Based Functions ` --

- `Multistage Functions ` --

- `Static Files` --

- `Platform Misconfi guration ` --

- `Insecure Access Control Methods` --

### Attacking Access Controls 

- `Testing with Different User Accounts ` --

- `Testing Multistage Processes ` --

- `Testing with Limited Access ` --

- `Testing Direct Access to Methods` --

- `Testing Controls Over Static Resources ` --

- `Testing Restrictions on HTTP Methods ` --

### Securing Access Controls 

- `A Multilayered Privilege Model ` --

### Summary

<br>
<br>

---

<br>
<br>

# Chapter 9 Attacking Data Stores

### Injecting into Interpreted Contexts

- `Bypassing a Login` --

### Injecting into SQL 

- `Exploiting a Basic Vulnerability ` --

- `Injecting into Different Statement Types ` --

- `Finding SQL Injection Bugs ` --

- `Fingerprinting the Database ` --

- `The UNION Operator ` --

- `Extracting Useful Data ` --

- `Extracting Data with UNION` --

- `Bypassing Filters ` --

- `Second-Order SQL Injection ` --

- `Advanced Exploitation ` --

- `Beyond SQL Injection: Escalating the ` --

- `Using SQL Exploitation Tools`  --

- `SQL Syntax and Error Reference` --

- `Preventing SQL Injection ` --

### Injecting into NoSQL

- `Injecting into MongoDB ` --

### Injecting into XPath 

- `Subverting Application Logic ` --

- `Informed XPath Injection ` --

- `Blind XPath Injection` --

- `Finding XPath Injection Flaws ` --

- `Preventing XPath Injection ` --

### Injecting into LDAP

- `Exploiting LDAP Injection` --

- `Finding LDAP Injection Flaws` --

- `Preventing LDAP Injection ` --

### Summary

<br>
<br>

---

<br>
<br>

# Chapter 10 Attacking Back-End Components 
 
### Injecting OS Commands

- `Example 1: Injecting Via Perl ` --

- `Example 2: Injecting Via ASP` --

- `Injecting Through Dynamic Execution ` --

- `Finding OS Command Injection Flaws ` --

- `Finding Dynamic Execution Vulnerabilities ` --

- `Preventing OS Command Injection ` --

- `Preventing Script Injection Vulnerabilities ` --

### Manipulating File Paths 

- `Path Traversal Vulnerabilities ` --

- `File Inclusion Vulnerabilities ` --

### Injecting into XML Interpreters

- `Injecting XML External Entities` --

- `Injecting into SOAP Services ` --

- `Finding and Exploiting SOAP Injection ` --

- `Preventing SOAP Injection` --

### Injecting into Back-end HTTP Requests 

- `Server-side HTTP Redirection ` --

- `HTTP Parameter Injection` --

### Injecting into Mail Services 

- `E-mail Header Manipulation ` --

- `SMTP Command Injection` --

- `Finding SMTP Injection Flaws ` --

- `Preventing SMTP Injection` --

### Summary

<br>
<br>

---

<br>
<br>

# Chapter 11 Attacking Application Logic 

### The Nature of Logic Flaws

### Real-World Logic Flaws

- `Example 1: Asking the Oracle` --

- `Example 2: Fooling a Password Change Function ` --

- `Example 3: Proceeding to Checkout ` --

- `Example 4: Rolling Your Own Insurance` --

- `Example 5: Breaking the Bank` --

- `Example 6: Beating a Business Limit ` --

- `Example 7: Cheating on Bulk Discounts ` --

- `Example 8: Escaping from Escaping ` --

- `Example 9: Invalidating Input Validation ` --

- `Example 10: Abusing a Search Function ` --

-` Example 11: Snarfi ng Debug Messages ` --

- `Example 12: Racing Against the Login ` --

### Avoiding Logic Flaws

### Summary

<br>
<br>

---

<br>
<br>

# Chapter 12 Attacking Users: Cross-Site Scripting 

### Varieties of XSS 

- `Refl ected XSS Vulnerabilities ` --

- `Stored XSS Vulnerabilities ` --

- `DOM-Based XSS Vulnerabilities ` --

### XSS Attacks in Action 

- `Real-World XSS Attacks ` --

- `Payloads for XSS Attacks ` --

- `Delivery Mechanisms for XSS Attacks ` --

### Finding and Exploiting XSS Vulnerabilities

- `Finding and Exploiting Refl ected XSS Vulnerabilities` --

- `Finding and Exploiting Stored XSS Vulnerabilities` --

- `Finding and Exploiting DOM-Based XSS Vulnerabilities ` --

### Preventing XSS Attacks 

- `Preventing Refl ected and Stored XSS ` --

- `Preventing DOM-Based XSS` --

### Summary

<br>
<br>

---

<br>
<br>

# Chapter 13 Attacking Users: Other Techniques 

### Inducing User Actions 

- `Request Forgery ` --

- `UI Redress` --

### Capturing Data Cross-Domain

- `Capturing Data by Injecting HTML ` --

- `Capturing Data by Injecting CSS ` --

- `JavaScript Hijacking ` --
 
### The Same-Origin Policy Revisited

- `The Same-Origin Policy and Browser Extensions ` --

- `The Same-Origin Policy and HTML5` --

- `Crossing Domains with Proxy Service Applications` --

### Other Client-Side Injection Attacks

- `HTTP Header Injection ` --

- `Cookie Injection ` --

- `Open Redirection Vulnerabilities ` --

- `Client-Side SQL Injection ` --

- `Client-Side HTTP Parameter Pollution` --

### Local Privacy Attacks 

- `Persistent Cookies` --

- `Cached Web Content` --

- `Browsing History ` --

- `Autocomplete` --

- `Flash Local Shared Objects ` --

- `Silverlight Isolated Storage` --

- `Internet Explorer userData ` --

- `HTML5 Local Storage Mechanisms` --

- `Preventing Local Privacy Attacks ` --

### Attacking ActiveX Controls

- `Finding ActiveX Vulnerabilities` --

- `Preventing ActiveX Vulnerabilities ` --

### Attacking the Browser 

- `Logging Keystrokes` --

- `Stealing Browser History and Search Queries ` --

- `Enumerating Currently Used Applications ` --

- `Port Scanning ` --

- `Attacking Other Network Hosts ` --

- `Exploiting Non-HTTP Services ` --

- `Exploiting Browser Bugs ` --

- `DNS Rebinding` --

- `Browser Exploitation Frameworks ` --

- `Man-in-the-Middle Attacks ` --

### Summary

<br>
<br>

---

<br>
<br>

#

###

###

###

###


<br>
<br>

---

<br>
<br>

#

###

###

###

###

<br>
<br>

---

<br>
<br>

#

###

###

###

###

<br>
<br>

---

<br>
<br>

#

###

###

###

###

<br>
<br>

---

<br>
<br>

#

###

###

###

###

<br>
<br>

---

<br>
<br>

#

###

###

###

###

<br>
<br>

---

<br>
<br>

#

###

###

###

###

<br>
<br>

---

<br>
<br>

#

###

###

###

###
