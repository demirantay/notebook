
# Chapter 3: Hypertext Transfer Protocol

- The next essential concept we need to discuss is the Hypertext Transfer Protocol (HTTP): the core trans- fer mechanism of the Web and the preferred method for exchanging URL-referenced documents between servers and clients. Despite having hypertext in its name, HTTP and the actual hypertext content (the HTML language) often exist independent of each other.

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


