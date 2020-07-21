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

- No matter how effective an application is at ensuring that the session tokens it generates do not contain any meaningful information and are not susceptible to analysis or prediction, its session mechanism will be wide open to attack if those tokens are not handled carefully after generation. For example, if tokens are disclosed to an attacker via some means, the attacker can hijack user ses- sions even if predicting the tokens is impossible.

  Proper use of SSL certainly helps protect session tokens from being cap- tured. But various mistakes can still result in tokens being transmitted in cleartext even when SSL is in place. And various direct attacks against end users can be used to obtain their tokens.

- `Disclosure of Tokens on the Network` -- This area of vulnerability arises when the session token is transmitted across the network in unencrypted form, enabling a suitably positioned eavesdropper to obtain the token and therefore masquerade as the legitimate user. In the simplest case, where an application uses an unencrypted HTTP connec- tion for communications, an attacker can capture all data transmitted between client and server, including login credentials, personal information, payment details, and so on. 

  In other cases, an application may use HTTPS to protect key client-server communications yet may still be vulnerable to interception of session tokens on the network. This weakness may occur in various ways, many of which can arise specifically when HTTP cookies are used as the transmission mechanism for session tokens

  Even if an application uses HTTPS for every page, including unauthenti- cated areas of the site and static content, there may still be circumstances in which users’ tokens are transmitted over HTTP

- `Disclosure of Tokens in Logs ` -- Aside from the clear-text transmission of session tokens in network communica- tions, the most common place where tokens are simply disclosed to unauthorized view is in system logs of various kinds. Although it is a rarer occurrence, the consequences of this kind of disclosure are usually more serious. Those logs may be viewed by a far wider range of potential attackers, not just by someone who is suitably positioned to eavesdrop on the network.

- `Vulnerable Mapping of Tokens to Sessions ` -- Various common vulnerabilities in session management mechanisms arise because of weaknesses in how the application maps the creation and processing of session tokens to individual users’ sessions themselves. The simplest weakness is to allow multiple valid tokens to be concurrently assigned to the same user account. In virtually every application, there is no legitimate reason why any user should have more than one session active at one time.

- `Vulnerable Session Termination ` -- Proper termination of sessions is important for two reasons. First, keeping the life span of a session as short as is necessary reduces the window of opportunity within which an attacker may capture, guess, or misuse a valid session token. Second, it provides users with a means of invalidating an existing session when they no longer require it. The main weaknesses in session termination functions involve failures to meet these two key objectives.

  Some applications that do not use authentication still contain functionality that enables users to build up sensitive data within their session (for example, a shopping application). Yet typically they do not provide any equivalent of a logout function for users to terminate their session.

- `Client Exposure to Token Hijacking ` -- An attacker can target other users of the application in an attempt to capture or misuse the victim’s session token in various ways
  - An obvious payload for cross-site scripting attacks is to query the user’s cookies to obtain her session token, which can then be transmitted to an arbitrary server controlled by the attacker.
  - Various other attacks against users can be used to hijack the user’s session in different ways. With session fixation vulnerabilities, an attacker feeds a known session token to a user, waits for her to log in, and then hijacks her session
  
### Securing Session Management 

- The defensive measures that web applications must take to prevent attacks on their session management mechanisms correspond to the two broad categories of vulnerability that affect those mechanisms. To perform session management in a secure manner, an application must generate its tokens in a robust way and must protect these tokens throughout their life cycle from creation to disposal.

- `Generate Strong Tokens` -- The tokens used to reidentify a user between successive requests should be generated in a manner that does not provide any scope for an attacker who obtains a large sample of tokens from the application in the usual way to predict or extrapolate the tokens issued to other users.

  In principle, any item of arbitrary length and complexity may be guessed using brute force given sufficient time and resources. The objective of designing a mechanism to generate strong tokens is that it should be extremely unlikely that a determined attacker with large amounts of bandwidth and processing resources should be successful in guessing a single valid token within the life span of its validity. In general, if an algorithm is not explicitly described as being cryptographically secure, it should be assumed to be predictable.

- `Protect Tokens Throughout Their Life Cycle` -- Now that you’ve created a robust token whose value cannot be predicted, this token needs to be protected throughout its life cycle from creation to disposal, to ensure that it is not disclosed to anyone other than the user to whom it is issued:

  The token should only be transmitted over HTTPS. Any token transmit- ted in cleartext should be regarded as tainted — that is, as not providing assurance of the user’s identity. If HTTP cookies are being used to transmit tokens, these should be flagged as secure to prevent the user’s browser from ever transmitting them over HTTP
  
  Session tokens should never be transmitted in the URL, because this pro- vides a simple vehicle for session fixation attacks and results in tokens appearing in numerous logging mechanisms. 
  
  Logout functionality should be implemented. This should dispose of all session resources held on the server and invalidate the session token.
  
  Session expiration should be implemented after a suitable period of inac- tivity (such as 10 minutes). This should result in the same behavior as if the user had explicitly logged out.
  
  Concurrent logins should be prevented. Each time a user logs in, a differ- ent session token should be issued, and any existing session belonging to the user should be disposed of as if she had logged out from it.
  
  If the application contains any administrative or diagnostic functional- ity that enables session tokens to be viewed, this functionality should be robustly defended against unauthorized access. In most cases, there is no need for this functionality to display the actual session token.

- `Log, Monitor, and Alert ` -- The application’s session management functionality should be closely integrated with its mechanisms for logging, monitoring, and alerting to provide suitable records of anomalous activity and to enable administrators to take defensive actions where necessary:

  Brute-force attacks against session tokens are difficult to block altogether, because no particular user account or session can be disabled to stop the attack. One possible action is to block source IP addresses for an amount of time when a number of requests containing invalid tokens have been received. 
  
  Wherever possible, users should be alerted to anomalous events relating to their session, such as concurrent logins or apparent hijacking (detected using per-page tokens).

### Summary

- The session management mechanism provides a rich source of potential vulner- abilities for you to target when formulating your attack against an application. Because of its fundamental role in enabling the application to identify the same user across multiple requests, a broken session management function usually provides the keys to the kingdom. Jumping into other users’ sessions is good. Hijacking an administrator’s session is even better; typically this enables you to compromise the entire application

  You can expect to encounter a wide range of defects in real-world session management functionality. When bespoke mechanisms are employed, the possible weaknesses and avenues of attack may appear to be endless. The most important lesson to draw from this topic is to be patient and determined. Quite a few session management mechanisms that appear to be robust on first inspec- tion can be found wanting when analyzed closely. Deciphering the method an application uses to generate its sequence of seemingly random tokens may take time and ingenuity. But given the reward, this is usually an investment well worth making.


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

