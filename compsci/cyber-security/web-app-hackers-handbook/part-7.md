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

# Chapter 14 Automating Customized Attacks 

### Uses for Customized Automation 

- `The Basic Approach ` --

- `Detecting Hits ` --

- `Scripting the Attack ` --

- `JAttack` --

### Enumerating Valid Identifi ers 

### Harvesting Useful Data

### Fuzzing for Common Vulnerabilities 

### Putting It All Together: Burp Intruder

### Barriers to Automation 

- `Session-Handling Mechanisms` --

- `CAPTCHA Controls ` --

### Summary


<br>
<br>

---

<br>
<br>

# Chapter 15 Exploiting Information Disclosure 

### Exploiting Error Messages 

- `Script Error Messages ` --

- `Stack Traces ` --

- `Informative Debug Messages ` --

- `Server and Database Messages` --

- `Using Public Information ` --

- `Engineering Informative Error Messages ` --

### Gathering Published Information 

### Using Inference

### Preventing Information Leakage 

- `Use Generic Error Messages` --

- `Protect Sensitive Information ` --

- `Minimize Client-Side Information Leakage` --

### Summary

<br>
<br>

---

<br>
<br>
 
# Chapter 16 Attacking Native Compiled Applications

### Buffer Overfl ow Vulnerabilities

- `Stack Overflows ` --

- `Heap Overflows` --

- `“Off-by-One” Vulnerabilities ` --

- `Detecting Buffer Overfl ow Vulnerabilities ` --

### Integer Vulnerabilities 

- `Integer Overfl ows ` --

- `Signedness Errors ` --

- `Detecting Integer Vulnerabilities` --
 
### Format String Vulnerabilities

- `Detecting Format String Vulnerabilities` --

### Summary

<br>
<br>

---

<br>
<br>

# Chapter 17 Attacking Application Architecture 

### Tiered Architectures 

- `Attacking Tiered Architectures` --

- `Securing Tiered Architectures ` --

### Shared Hosting and Application Service Providers

- `Virtual Hosting` --

- `Shared Application Services` --

- `Attacking Shared Environments ` --

- `Securing Shared Environments ` --

### Summary


<br>
<br>

---

<br>
<br>

# Chapter 18 Attacking the Application Server

### Vulnerable Server Configuration 

- `Default Credentials` --

- `Default Content ` --

- `Directory Listings ` --

- `WebDAV Methods` --

- `Misconfi gured Virtual Hosting` --

- `Securing Web Server Confi guration` --

### Vulnerable Server Software 

- `Application Framework Flaws ` --

- `Memory Management Vulnerabilities ` --

- `Encoding and Canonicalization` --

- `Finding Web Server Flaws ` --

- `Securing Web Server Software ` --

### Web Application Firewalls 

### Summary

<br>
<br>

---

<br>
<br>

# Chapter 19 Finding Vulnerabilities in Source Code

### Approaches to Code Review

- `Black-Box Versus White-Box Testing ` -- 

- `Code Review Methodology` --

### Signatures of Common Vulnerabilities

- `Cross-Site Scripting` --

- `SQL Injection` --

- `Path Traversal ` --

- `Arbitrary Redirection ` --

- `OS Command Injection ` --

- `Backdoor Passwords ` --

- `Native Software Bugs` --

- `Source Code Comments ` -- 

### The Java Platform

- `Identifying User-Supplied Data ` --

- `Session Interaction ` --

- `Potentially Dangerous APIs` --

- `Confi guring the Java Environment ` --

### ASP.NET

- `Identifying User-Supplied Data ` --

- `Session Interaction ` --

- `Potentially Dangerous APIs`  --

- `Confi guring the ASP.NET Environment ` --

### PHP

- `Identifying User-Supplied Data ` -- 

- `Session Interaction` --

- `Potentially Dangerous APIs ` --

- `Confi guring the PHP Environmen` --

### Perl

- `Identifying User-Supplied Data` -- 

- `Session Interaction ` --

- `Potentially Dangerous APIs ` --

- `Confi guring the Perl Environment` --

### JavaScript

### Database Code Components

- `SQL Injection` --

- `Calls to Dangerous Functions ` --

### Tools for Code Browsing 

### Summary

<br>
<br>

---

<br>
<br>

# Chapter 20 A Web Application Hacker’s Toolkit

### Web Browsers 

- `Internet Explorer ` --

- `Firefox` --

- `Chrome` --

### Integrated Testing Suites 

- `How the Tools Work` --

- `Testing Work Flow` --

- `Alternatives to the Intercepting Proxy` --

### Standalone Vulnerability Scanners 

- `Vulnerabilities Detected by Scanners ` -- 

- `Inherent Limitations of Scanners ` --

- `Technical Challenges Faced by Scanners` --

- `Current Products ` --

- `Using a Vulnerability Scanner ` --

### Other Tools 

- `Wikto/Nikto ` --

- `Firebug` --

- `Hydra` --

- `Custom Scripts ` --

### Summary

<br>
<br>

---

<br>
<br>

# Chapter 21 A Web Application Hacker’s Methodology

### 1 Map the Application’s Content 

- `Explore Visible Content ` --

- `Consult Public Resources ` --

- `Discover Hidden Content` --

- `Discover Default Content ` --

- `Enumerate Identifi er-Specifi ed Functions ` --

- `Test for Debug Parameters` --
 
### 2 Analyze the Application 

- `Identify Functionality ` --

- `Identify Data Entry Points ` --

- ` Identify the Technologies Used` --

- ` Map the Attack Surface` -- 

### 3 Test Client-Side Controls

- `Test Transmission of Data Via the Client ` --

- `Test Client-Side Controls Over User Input` --

- `Test Browser Extension Components` --

### 4 Test the Authentication Mechanism 

- `Understand the Mechanism ` --

- `Test Password Qualit` --

- `Test for Username Enumeration ` --

- `Test Resilience to Password Guessing` --

- `Test Any Account Recovery Function` --

- `Test Any Remember Me Function ` --

- `Test Any Impersonation Function ` --

- `Test Username Uniqueness ` --

- `Test Predictability of Autogenerated Credentials ` --

- `Check for Unsafe Transmission of Credentials` --

- ` Check for Unsafe Distribution of Credentials ` --

- `Test for Insecure Storage ` --

- `Test for Logic Flaws` --

- `Exploit Any Vulnerabilities to Gain Unauthorized Access ` --

### 5 Test the Session Management Mechanism

- `Understand the Mechanism ` --

- `Test Tokens for Meaning` --

- `Test Tokens for Predictability` --

- `Check for Insecure Transmission of Tokens` --

- `Check for Disclosure of Tokens in Logs ` --

- `Check Mapping of Tokens to Sessions` --

- `Test Session Termination ` --

- `Check for Session Fixation ` --

- `Check for CSRF ` --

- `Check Cookie Scope` --

### 6 Test Access Controls

- `Understand the Access Control Requirements` --

- `Test with Multiple Accounts ` --

- ` Test with Limited Access` --

- `Test for Insecure Access Control Methods` --

### 7 Test for Input-Based Vulnerabilities

- `Fuzz All Request Parameters ` --

- `Test for SQL Injection` -- 

- `Test for XSS and Other Response Injection ` --

- ` Test for OS Command Injection ` --

- `Test for Path Traversal ` --

- `Test for Script Injection ` --

- `Test for File Inclusion` --

### 8 Test for Function-Specifi c Input Vulnerabilities 

- `Test for SMTP Injection ` --

- `Test for Native Software Vulnerabilities ` --

- `Test for SOAP Injection` --

- `Test for LDAP Injection ` --

- `Test for XPath Injection ` --

- ` Test for Back-End Request Injection` --

- `Test for XXE Injection` --

### 9 Test for Logic Flaws

- `Identify the Key Attack Surface ` --

- `Test Multistage Processes ` --

- `Test Handling of Incomplete Input` --

- `Test Trust Boundaries ` --

- `Test Transaction Logic` --

### 10 Test for Shared Hosting Vulnerabilities 

- `Test Segregation in Shared Infrastructures ` --

- `Test Segregation Between ASP-Hosted Applications ` --

### 11 Test for Application Server Vulnerabilities

- `Test for Default Credentials` --

- `Test for Default Content` --

- `Test for Dangerous HTTP Methods` --

- `Test for Proxy Functionality` --

- `Test for Virtual Hosting Misconfi guration` --

- `Test for Web Server Software Bugs` --

- `Test for Web Server Software Bugs` --

### 12 Miscellaneous Checks 

- `Check for DOM-Based Attacks ` --

- `Check for Local Privacy Vulnerabilities` --

- `Check for Weak SSL Ciphers` --

- `Check for Weak SSL Ciphers` -- 

### 13 Follow Up Any Information Leakage 
