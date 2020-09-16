# The Tangled Web

### Preface

<br>
<br>

---

<br>
<br>

# Chapter 1: Security in the World of Web Applications 

### Information Security in a Nutshell 

- __`Flirting with Formal Solutions `__ -- 

- __`Enter Risk Management`__ -- 

- __`Enlightenment Through Taxonomy`__ -- 

- __`Toward Practical Approaches `__ -- 

### A Brief History of the Web

- __`Tales of the Stone Age: 1945 to 1994`__ -- 

- __`The First Browser Wars: 1995 to 1999`__ -- 

- __`The Boring Period: 2000 to 2003`__ -- 

- __`Web 2.0 and the Second Browser Wars: 2004 and Beyond`__ -- 
 
### The Evolution of a Threat

- __`The User as a Security Flaw`__ -- 

- __`The Cloud, or the Joys of Communal Living`__ -- 

- __`Nonconvergence of Visions`__ -- 

- __`Cross-Browser Interactions: Synergy in Failure`__ -- 

- __`The Breakdown of the Client-Server Divide`__ -- 


<br>
<br>

---

<br>
<br>

# Chapter 2: It Starts with a URL

### Uniform Resource Locator Structure

- __`Scheme Name`__ -- 

- __`Indicator of a Hierarchical URL`__ -- 

- __`Credentials to Access the Resource`__ -- 

- __`Server Address`__ -- 

- __`Server Port`__ -- 

- __`Hierarchical File Path`__ -- 

- __`Query String`__ -- 

- __`Fragment ID`__ -- 

- __`Putting It All Together Again`__ --

### Reserved Characters and Percent Encoding

- __`Handling of Non-US-ASCII Text`__ -- 

### Common URL Schemes and Their Function

- __`Browser-Supported, Document-Fetching Protocols`__ -- 

- __`Protocols Claimed by Third-Party Applications and Plug-ins`__ -- 

- __`Nonencapsulating Pseudo-Protocols`__ -- 

- __`Encapsulating Pseudo-Protocols`__ -- 

- __`Closing Note on Scheme Detection`__ -- 

### Resolution of Relative URLs

### Security Engineering Cheat Sheet.

- __`When Constructing Brand-New URLs Based on User Input`__ -- 

- __`When Designing URL Input Filters`__ -- 

- __`When Decoding Parameters Received Through URLs`__ -- 


<br>
<br>

---

<br>
<br>

# Chapter 3: Hypertext Transfer Protocol

### Basic Syntax of HTTP Traffic

- __`The Consequences of Supporting HTTP/0.9`__ -- 

- __`Newline Handling Quirks`__ -- 

- __`Proxy Requests`__ -- 

- __`Resolution of Duplicate or Conflicting Headers`__ -- 

- __`Semicolon-Delimited Header Values`__ -- 

- __`Header Character Set and Encoding Schemes`__ -- 

- __`Referer Header Behavior`__ -- 

### HTTP Request Types

- __`GET`__ -- 

- __`POST`__ -- 

- __`HEAD`__ -- 

- __`OPTIONS`__ -- 

- __`PUT`__ -- 

- __`DELETE`__ -- 

- __`TRACE`__ --

- __`CONNECT`__ -- 

- __`Other HTTP Methods`__ -- 

### Server Response Codes

- __`200–299: Success `__ -- 

- __`300–399: Redirection and Other Status Messages`__ -- 

- __`400–499: Client-Side Error`__ -- 

- __`500–599: Server-Side Error`__ -- 

- __`Consistency of HTTP Code Signaling `__ -- 

### Keepalive Sessions

### Chunked Data Transfers 

### Caching Behavior 

### HTTP Cookie Semantics.

### HTTP Authentication

### Protocol-Level Encryption and Client Certificates

- __`Extended Validation Certificates`__ -- 

- __`Error-Handling Rules`__ -- 

### Security Engineering Cheat Sheet

- __`When Handling User-Controlled Filenames in Content-Disposition Headers`__ -- 

- __`When Putting User Data in HTTP Cookies`__ -- 

- __`When Sending User-Controlled Location Headers`__ -- 

- __`When Sending User-Controlled Redirect Headers`__ -- 

- __`When Constructing Other Types of User-Controlled Requests or Responses`__ -- 


<br>
<br>

---

<br>
<br>

# Chapter 4: Hypertext Markup Language 

### Basic Concepts Behind HTML Documents

- __`Document Parsing Modes`__ -- 

- __`The Battle over Semantics`__ -- 

### Understanding HTML Parser Behavior

- __`Interactions Between Multiple Tags`__ -- 

- __`Explicit and Implicit Conditionals`__ -- 

- __`HTML Parsing Survival Tips`__ -- 

### Entity Encoding 

### HTTP/HTML Integration Semantics

### Hyperlinking and Content Inclusion

- __`Plain Links `__ -- 

- __`Forms and Form-Triggered Requests`__ -- 

- __`Frames`__ -- 

- __`Type-Specific Content Inclusion`__ -- 

- __`A Note on Cross-Site Request Forgery`__ -- 

### Security Engineering Cheat Sheet

- __`Good Engineering Hygiene for All HTML Documents`__ -- 

- __`When Generating HTML Documents with Attacker-Controlled Bits`__ -- 

- __`When Converting HTML to Plaintext`__ -- 

- __`When Writing a Markup Filter for User Content`__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 5: Cascading Style Sheets

###

- __``__ -- 

- __``__ -- 

###

- __``__ -- 

- __``__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 6: Browser-Side Scripts

###

- __``__ -- 

- __``__ -- 

###

- __``__ -- 

- __``__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 7: Non-HTML Document Types

###

- __``__ -- 

- __``__ -- 

###

- __``__ -- 

- __``__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 8: Content Rendering with Browser Plug-ins

###

- __``__ -- 

- __``__ -- 

###

- __``__ -- 

- __``__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 9: Content Isolation Logic

###

- __``__ -- 

- __``__ -- 

###

- __``__ -- 

- __``__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 10: Origin Inheritance

<br>
<br>

---

<br>
<br>

# Chapter 11: Life Outside Same-Origin Rules

###

- __``__ -- 

- __``__ -- 

###

- __``__ -- 

- __``__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 12: Other Security Boundaries

###

- __``__ -- 

- __``__ -- 

###

- __``__ -- 

- __``__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 13: Content Recognition Mechanisms

###

- __``__ -- 

- __``__ -- 

###

- __``__ -- 

- __``__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 14: Dealing with Rogue Scripts

###

- __``__ -- 

- __``__ -- 

###

- __``__ -- 

- __``__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 15: Extrinsic Site Privileges 

###

- __``__ -- 

- __``__ -- 

###

- __``__ -- 

- __``__ -- 

<br>
<br>

---

<br>
<br>
 
# Chapter 16: New and Upcoming Security Features

###

- __``__ -- 

- __``__ -- 

###

- __``__ -- 

- __``__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 17: Other Browser Mechanisms of Note

###

- __``__ -- 

- __``__ -- 

###

- __``__ -- 

- __``__ -- 

<br>
<br>

---

<br>
<br>

# Chapter 18: Common Web Vulnerabilities

###

- __``__ -- 

- __``__ -- 

###

- __``__ -- 

- __``__ -- 

