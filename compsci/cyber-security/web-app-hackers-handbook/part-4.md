# Chapter 7 Attacking Session Management 

- The session management mechanism is a fundamental security component in the majority of web applications. It is what enables the application to uniquely identify a given user across a number of different requests and to handle the data that it accumulates about the state of that user’s interaction with the application. Because of the key role played by session management mechanisms, they are a prime target for malicious attacks against the application. If an attacker can break an application’s session management, she can effectively bypass its authentication controls and masquerade as other application users without knowing their credentials. If an attacker compromises an administrative user in this way, the attacker can own the entire application.

### The Need for State 

- The HTTP protocol is essentially stateless. It is based on a simple request-response model, in which each pair of messages represents an independent transaction. The protocol itself contains no mechanism for linking the series of requests made by a particular user and distinguishing these from all the other requests received by the web server he majority of web “sites” are in fact web applications. They allow you to register and log in. They let you buy and sell goods. They remember your pref- erences the next time you visit. They deliver rich multimedia experiences with content created dynamically based on what you click and type. To implement any of this functionality, web applications need to use the concept of a session.

  Applications that do not have a login function also typically need to use ses- sions. Many sites selling merchandise do not require customers to create accounts. However, they allow users to browse the catalog, add items to a shopping basket, provide delivery details, and make a payment.
 
  This standard session management mechanism is inherently vulnerable to various categories of attack. An attacker’s primary objective in targeting the mechanism is to somehow hijack the session of a legitimate user and thereby masquerade as that person. The vulnerabilities that exist in session management mechanisms largely fall into two categories:
    - Weaknesses in the generation of session tokens
    - Weaknesses in the handling of session tokens throughout their life cycle

- `Alternatives to Sessions ` -- Not every web application employs sessions, and some security-critical applica- tions containing authentication mechanisms and complex functionality opt to use other techniques to manage state. You are likely to encounter two possible alternatives:
  - 1 - HTTP authentication — Applications using the various HTTP-based authentication technologies (basic, digest, NTLM) sometimes avoid the need to use sessions  However, HTTP authentication is rarely used on Internet- based applications of any complexity
  - 2 - Sessionless state mechanisms — Some applications do not issue session tokens to manage the state of a user’s interaction with the application. Instead, they transmit all data required to manage that state via the client, usually in a cookie or a hidden form field. This usually involves constructing a binary blob containing all the state information and encrypting or signing this using a recognized algorithm.
 
### Weaknesses in Token Generation 

- Session management mechanisms are often vulnerable to attack because tokens are generated in an unsafe manner that enables an attacker to identify the values of tokens that have been issued to other users.

- `Meaningful Tokens` -- Some session tokens are created using a transformation of the user’s username or e-mail address, or other information associated with that person. This infor- mation may be encoded or obfuscated in some way and may be combined with other data. Tokens that contain meaningful data often exhibit a structure. In other words, they contain several components, often separated by a delimiter, that can be extracted and analyzed separately to allow an attacker to understand their function and means of generation. Here are some components that may be encountered within structured tokens:
  - The account username
  - The numeric identifier that the application uses to distinguish between
accounts
  - The user’s e-mail address
  - The client IP address

- `Predictable Tokens` -- Some session tokens do not contain any meaningful data associating them with a particular user. Nevertheless, they can be guessed because they contain sequences or patterns that allow an attacker to extrapolate from a sample of tokens to find other valid tokens recently issued by the application. Even if the extrapolation involves some trial and error (for example, one valid guess per 1,000 attempts), this would still enable an automated attack to identify large numbers of valid tokens in a relatively short period of time.

- `Encrypted Tokens ` -- Some applications use tokens that contain meaningful information about the user and seek to avoid the obvious problems that this entails by encrypting the tokens before they are issued to users. Since the tokens are encrypted using a secret key that is unknown to users, this appears to be a robust approach, because users will be unable to decrypt the tokens and tamper with their contents. However, in some situations, depending on the encryption algorithm used and the manner in which the application processes the tokens, it may nonetheless be possible for users to tamper with the tokens’ meaningful contents without actu- ally decrypting them

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

