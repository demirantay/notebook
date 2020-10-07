# Chapter 5: Cascading Style Sheets

### Basic CSS Syntax

- __`Property Definitions `__ -- 

- __`@ Directives and XBL Bindings`__ -- 

- __`Interactions with HTML`__ -- 

### Parser Resynchronization Risks

### Character Encoding

### Security Engineering Cheat Sheet

- __`When Loading Remote Stylesheets`__ -- 

- __`When Putting Attacker-Controlled Values into CSS`__ -- 

- __`When Filtering User-Supplied CSS.`__ -- 

- __`When Allowing User-Specified Class Values on HTML Markup `__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 6: Browser-Side Scripts

### Basic Characteristics of JavaScript

- __`Script Processing Model`__ -- 

- __`Execution Ordering Control `__ -- 

- __`Code and Object Inspection Capabilities`__ -- 

- __`Modifying the Runtime Environment`__ -- 

- __`JavaScript Object Notation and Other Data Serializations`__ -- 

- __`E4X and Other Syntax Extensions`__ -- 

### Standard Object Hierarchy

- __`The Document Object Model`__ -- 

- __`Access to Other Documents`__ -- 

### Script Character Encoding

### Code Inclusion Modes and Nesting Risks 

### The Living Dead: Visual Basic

### Security Engineering Cheat Sheet

- __`When Loading Remote Scripts`__ -- 

- __`When Parsing JSON Received from the Server `__ -- 

- __`When Putting User-Supplied Data Inside JavaScript Blocks`__ -- 

- __`When Interacting with Browser Objects on the Client Side`__ -- 

- __`If You Want to Allow User-Controlled Scripts on Your Page`__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 7: Non-HTML Document Types

### Plaintext Files

### Bitmap Images

### Audio and Video

### XML-Based Documents

- __`Generic XML View`__ -- 

- __`Scalable Vector Graphics.`__ -- 

- __`Mathematical Markup Language`__ -- 

- __`XML User Interface Language`__ -- 

- __`Wireless Markup Language`__ -- 

- __`RSS and Atom Feeds`__ -- 

### A Note on Nonrenderable File Types

### Security Engineering Cheat Sheet.

- __`When Hosting XML-Based Document Formats`__ -- 

- __`On All Non-HTML Document Types`__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 8: Content Rendering with Browser Plug-ins

### Invoking a Plug-in

- __`The Perils of Plug-in Content-Type Handling `__ -- 

### Document Rendering Helpers

### Plug-in-Based Application Frameworks

- __`Adobe Flash `__ -- 

- __`Microsoft Silverlight `__ -- 

- __`Sun Java`__ -- 

- __`XML Browser Applications (XBAP)`__ -- 

### ActiveX Controls

### Living with Other Plug-ins 

### Security Engineering Cheat Sheet

- __`When Serving Plug-in-Handled Files`__ -- 

- __`When Embedding Plug-in-Handled Files`__ -- 

- __`If You Want to Write a New Browser Plug-in or ActiveX Component .`__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 9: Content Isolation Logic

### Same-Origin Policy for the Document Object Model 

- __`document.domain`__ -- 

- __`postMessage(...)`__ -- 

- __`Interactions with Browser Credentials`__ -- 

### Same-Origin Policy for XMLHttpRequest 

### Same-Origin Policy for Web Storage

### Security Policy for Cookies

- __`Impact of Cookies on the Same-Origin Policy`__ -- 

- __`Problems with Domain Restrictions`__ -- 

- __`The Unusual Danger of “localhost”`__ -- 

- __`Cookies and “Legitimate” DNS Hijacking`__ -- 

### Plug-in Security Rules

- __`Adobe Flash`__ -- 

- __`Microsoft Silverlight`__ -- 

- __`Java`__ -- 

### Coping with Ambiguous or Unexpected Origins

- __`IP Addresses`__ -- 

- __`Hostnames with Extra Periods`__ -- 

- __`Non–Fully Qualified Hostnames`__ -- 

- __`Local Files`__ -- 

- __`Pseudo-URLs`__ -- 

- __`Browser Extensions and UI`__ -- 

### Other Uses of Origins

### Security Engineering Cheat Sheet

- __`Good Security Policy Hygiene for All Websites`__ -- 

- __`When Relying on HTTP Cookies for Authentication`__ -- 

- __`When Arranging Cross-Domain Communications in JavaScript`__ -- 

- __`When Embedding Plug-in-Handled Active Content from Third Parties `__ -- 

- __`When Hosting Your Own Plug-in-Executed Content.`__ -- 

- __`When Writing Browser Extensions`__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 10: Origin Inheritance

- __`Origin Inheritance for about:blank`__ -- 

- __`Inheritance for data: URLs`__ -- 

- __`Inheritance for javascript: and vbscript: URLs`__ -- 

- __`A Note on Restricted Pseudo-URLs`__ -- 

- __`Security Engineering Cheat Sheet.`__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 11: Life Outside Same-Origin Rules

### Window and Frame Interactions 

- __`Changing the Location of Existing Documents`__ -- 

- __`Unsolicited Framing`__ -- 

### Cross-Domain Content Inclusion

- __`A Note on Cross-Origin Subresources`__ -- 

### Privacy-Related Side Channels 

### Other SOP Loopholes and Their Uses

### Security Engineering Cheat Sheet.

- __`Good Security Hygiene for All Websites`__ -- 

- __`When Including Cross-Domain Resources`__ -- 

- __`When Arranging Cross-Domain Communications in JavaScript`__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 12: Other Security Boundaries

### Navigation to Sensitive Schemes.

### Access to Internal Networks

### Prohibited Ports

### Limitations on Third-Party Cookies.

### Security Engineering Cheat Sheet

- __`When Building Web Applications on Internal Networks`__ -- 

- __`When Launching Non-HTTP Services, Particularly on Nonstandard Ports`__ -- 

- __`When Using Third-Party Cookies for Gadgets or Sandboxed Content`__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 13: Content Recognition Mechanisms

### Document Type Detection Logic

- __`Malformed MIME Types `__ -- 

- __`Special Content-Type Values`__ -- 

- __`Unrecognized Content Type`__ -- 

- __`Defensive Uses of Content-Disposition`__ -- 

- __`Content Directives on Subresources `__ -- 

- __`Downloaded Files and Other Non-HTTP Content `__ -- 

### Character Set Handling 

- __`Byte Order Marks`__ -- 

- __`Character Set Inheritance and Override`__ -- 

- __`Markup-Controlled Charset on Subresources`__ -- 

- __`Detection for Non-HTTP Files`__ -- 

### Security Engineering Cheat Sheet.

- __`Good Security Practices for All Websites`__ -- 

- __`When Generating Documents with Partly Attacker-Controlled Contents`__ -- 

- __`When Hosting User-Generated Files`__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 14: Dealing with Rogue Scripts

### Denial-of-Service Attacks 

- __`Execution Time and Memory Use Restrictions`__ -- 

- __`Connection Limits`__ -- 

- __`Pop-Up Filtering`__ -- 

- __`Dialog Use Restrictions`__ -- 

### Window-Positioning and Appearance Problems

### Timing Attacks on User Interfaces 

### Security Engineering Cheat Sheet

- __`When Permitting User-Created <iframe> Gadgets on Your Site`__ -- 

- __`When Building Security-Sensitive UIs`__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 15: Extrinsic Site Privileges 

### Browser- and Plug-in-Managed Site Permissions 

- __`Hardcoded Domains `__ -- 

### Form-Based Password Managers

### Internet Explorer’s Zone Model

- __`Mark of the Web and Zone.Identifier`__ -- 

### Security Engineering Cheat Sheet.

- __`When Requesting Elevated Permissions from Within a Web Application`__ -- 

- __`When Writing Plug-ins or Extensions That Recognize Privileged Origins.`__ -- 

<br>
<br>

---

<br>
<br>
 
# Chapter 16: New and Upcoming Security Features

### Security Model Extension Frameworks 

- __`Cross-Domain Requests`__ -- 

- __`XDomainRequest `__ -- 

- __`Other Uses of the Origin Header`__ -- 

### Security Model Restriction Frameworks

- __`Content Security Policy`__ -- 

- __`Sandboxed Frames`__ -- 

- __`Strict Transport Security`__ -- 

- __`Private Browsing Modes`__ -- 

### Other Developments

- __`In-Browser HTML Sanitizers`__ -- 

- __`XSS Filtering`__ --

### Security Engineering Cheat Sheet

<br>
<br>

---

<br>
<br>

# Chapter 17: Other Browser Mechanisms of Note

- __`URL- and Protocol-Level Proposals`__ -- 

- __`Content-Level Features`__ -- 

- __`I/O Interfaces`__ --  

<br>
<br>

---

<br>
<br>

# Chapter 18: Common Web Vulnerabilities

- __`Vulnerabilities Specific to Web Applications`__ -- 

- __`Problems to Keep in Mind in Web Application Design`__ -- 

- __`Common Problems Unique to Server-Side Code `__ -- 
