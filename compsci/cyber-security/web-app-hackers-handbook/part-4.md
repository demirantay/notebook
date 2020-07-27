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

- Within the application’s core security mechanisms, access controls are logically built on authentication and session management. Access controls are a critical defense mechanism within the application because they are responsible for making these key decisions. When they are defective, an attacker can often compromise the entire application, taking control of adminis- trative functionality and accessing sensitive data belonging to every other user

  As noted in Chapter 1, broken access controls are among the most commonly encountered categories of web application vulnerability, affecting a massive 71 percent of the applications recently tested by the authors.
  
  One reason that these weaknesses are so prevalent is that access control checks need to be performed for every request and every operation on a resource that particular user attempts to perform, at a specific time. And unlike many other classes of control, this is a design decision that needs to be made by a human; it cannot be resolved by employing technology.

### Common Vulnerabilities 

- Access controls can be divided into three broad categories: vertical, horizontal, and context-dependent. Vertical access controls allow different types of users to access different parts of the application’s functionality. Horizontal access controls allow users to access a certain subset of a wider range of resources of the same type Context-dependent access controls ensure that users’ access is restricted to what is permitted given the current application state

  In many cases, vertical and horizontal access controls are intertwined. There are three main types of attacks against access controls, corresponding to the three categories of controls:
  - `Vertical privilege escalation` occurs when a user can perform functions that his assigned role does not permit him to
  - `Horizontal privilege escalation` occurs when a user can view or modify resources to which he is not entitled.
  - `Business logic exploitation` occurs when a user can exploit a flaw in the application’s state machine to gain access to a key resource.

- `Completely Unprotected Functionality ` -- In many cases of broken access controls, sensitive functionality and resources can be accessed by anyone who knows the relevant URL:
  ```
  https://wahh-app.com/admin/
  ```
  Sometimes, the URL that grants access to powerful functions may be less easy to guess, and may even be quite cryptic, Here, access to administrative functions is protected by the assumption that an attacker will not know or discover this URL:
  ```
  https://wahh-app.com/menus/secure/ff457/DoAdminMenu2.jsp
  ```
  Ofc these protections are not even close to being secure. A savy attacker can easily find these URL's if the Urls do not keep changing in intervals
  
- `Direct Access to Methods` -- A specific case of unprotected functionality can arise when applications expose URLs or parameters that are actually remote invocations of API methods, normally those exposed by a Java interface. This often occurs when server-side code is moved to a browser extension component and method stubs are created so that the code can still call the server-side methods it requires to function

- `Identifi er-Based Functions ` -- When a function of an application is used to gain access to a specific resource, it is common to see an identifier for the requested resource being passed to the server in a request parameter, within either the URL query string or the body of a POST request. When the user who owns the document is logged in, a link to this URL is displayed on the user’s My Documents page. Other users do not see the link. However, if access controls are broken, any user who requests the relevant URL may be able to view the document in exactly the same way as the authorized user.

  > Application logs are often a gold mine of information. They may contain numerous items of data that can be used as identifiers to probe functionality that is accessed in this way. Identifiers commonly found within application logs include usernames, user ID numbers, account numbers, document IDs, user groups and roles, and e-mail addresses.

- `Multistage Functions ` -- Many kinds of functions within an application are implemented across several stages, involving multiple requests being sent from the client to the server. For example, a function to add a new user may involve choosing this option from a user maintenance menu, selecting the department and user role from drop- down list and then entering the new username, initial password, and other information.

  It is common to encounter applications in which efforts have been made to protect this kind of sensitive functionality from unauthorized access but where the access controls employed are broken because of flawed assumptions about how the functionality will be used.
  
  if an attacker proceeds directly to the stage of specifying the user’s department and other details, there may be no effective access control. The developers unconsciously assumed that any user who reaches the later stages of the process must have the relevant privileges because this was verified at the earlier stages.

- `Static Files` -- However, in some cases, requests for protected resources are made directly to the static resources themselves, which are located within the server’s web root. As traditionally the resource is loaded from the server to cut load costs. However if the static resource needs access control and is important never serve it from the server because you cannot implement any access controls in the server alone. It is highly likely that no effective access controls are pro- tecting them and that anyone who knows the URL naming scheme can exploit this to access any resources he wants

- `Insecure Access Control Methods` -- Some applications employ a fundamentally insecure access control model in which access control decisions are made on the basis of request parameters submitted by the client, or other conditions that are within an attacker’s control.

  __Parameter-Based Access Control__ -- In some versions of this model, the application determines a user’s role or access level at the time of login and from this point onward transmits this information via the client in a hidden form field, cookie, or preset query string parameter
    ```
    https://wahh-app.com/login/home.jsp?admin=true
    ```
    Any user who is aware of the parameter assigned to administrators can simply set it in his own requests and thereby gain access to administrative functions.
  
  __Referer-Based Access Control__ -- In other unsafe access control models, the application uses the HTTP Referer header as the basis for making access control decisions. For example, an appli- cation may strictly control access to the main administrative menu based on a user’s privileges. But when a user makes a request for an individual admin- istrative function, the application may simply check whether this request was referred from the administrative menu page. It might assume that the user must have accessed that page and therefore has the required privileges. This model is fundamentally broken  Referer header is completely under the user’s control and can be set to any value.
  
  __Location-Based Access Control__ -- Many businesses have a regulatory or business requirement to restrict access to resources depending on the user’s geographic location. Location-based access controls are relatively easy for an attacker to circum- vent. Here are some common methods of bypassing them: Using a web proxy that is based in the required location, Using a VPN that terminates in the required location, Using a mobile device that supports data roaming

### Attacking Access Controls 

- `Testing with Different User Accounts ` -- The easiest and most effective way to test the effectiveness of an application’s access controls is to access the application using different accounts. That way you can determine whether resources and functionality that can be accessed legitimately by one account can be accessed illegitimately by another.

  Testing an application’s access controls thoroughly is a time-consuming process. Fortunately, some tools can help you automate some of the work involved, to make your testing quicker and more reliable. This will allow you to focus on the parts of the task that require human intelligence to perform effectively. Burp Suite lets you map the contents of an application using two different user contexts. Then you can compare the results to see exactly where the content accessed by each user is the same or different. Interpreting the results of the site map comparison requires human intelli- gence and an understanding of the meaning and context of specific application functions

- `Testing Multistage Processes ` -- Here, to perform an action, the user typically must make several requests in the correct sequence, with the application building some state about the user’s actions as he or she does so. In some cases, the application may protect access to the initial form but fail to protect the page that handles the form submission or the confirmation page. The overall process may involve numerous requests, including redirections, with parameters submitted at earlier stages being retransmitted later via the client side. Every step of this process needs to be tested individually, to confirm whether access controls are being applied correctly.

- `Testing with Limited Access ` -- When all accessible functionality has been enumerated, you need to test whether per-user segregation of access to resources is being correctly enforced. In every instance where the application grants users access to a subset of a wider range of resources of the same type (such as documents, orders, e-mails, and personal details), there may be opportunities for one user to gain unauthorized access to other resources.

  Where the application uses identifiers of any kind (document IDs, account numbers, order references) to specify which resource a user is requesting, attempt to discover the identifiers for resources to which you do not have authorized access.

- `Testing Direct Access to Methods` -- Where an application uses requests that give direct access to server-side API methods, any access control weaknesses within those methods normally are identified using the methodology already described. However, you should also test for the existence of additional APIs that may not be properly protected.

- `Testing Controls Over Static Resources ` -- In cases where static resources that the application is protecting are ultimately accessed directly via URLs to the resource files themselves, you should test whether it is possible for unauthorized users to simply request these URLs directly. Basically first get that static resource normally and once it is there check that URL without a logged in user to see if you can access it.

### Securing Access Controls 

- Access controls are one of the easiest areas of web application security to under- stand, although you must carefully apply a well-informed, thorough methodology when implementing them First, you should avoid several obvious pitfalls. These usually arise from ignorance about the essential requirements of effective access control or flawed assumptions about the kinds of requests that users will make and against which the application needs to defend itself:
  - Do not rely on users’ ignorance of application URLs or the identifiers used to specify application resources, such as account numbers and document IDs. Assume that users know every application URL and identifier, and ensure that the application’s access controls alone are sufficient to prevent unauthorized access
  - Do not trust any user-submitted parameters to signify access rights (such
as admin=true).
  - Do not assume that users will access application pages in the intended sequence.
  - Do not trust the user not to tamper with any data that is transmitted via the client. 
  
- The following represents a best-practice approach to implementing effective access controls within web applications:
  - Explicitly evaluate and document the access control requirements for every unit of application functionality. This needs to include both who can legitimately use the function and what resources individual users may access via the function.
  - Drive all access control decisions from the user’s session.
  - Use a central application component to check access controls.
  - Process every client request via this component to validate that the user making the request is permitted to access the functionality and resources being requested
  - If you force developers to explicitly code access control logic into every page, there can be no excuse for omissions. And we are humans we sometimes miss shit. So a single point of checking is better.
  - For particularly sensitive functionality, such as administrative pages, you can further restrict access by IP address to ensure that only users from a specific network range can access the functionality, regardless of their login status.
  - Dont serve private static content from the web server.
  - For security-critical application functions such as the creation of a new bill payee in a banking application, consider implementing per-transaction reauthentication and dual authorization to provide additional assurance that the function is not being used by an unauthorized party
  - Log every event where sensitive data is accessed or a sensitive action is performed. These logs will enable potential access control breaches to be detected and investigated.

- `A Multilayered Privilege Model ` -- Issues relating to access apply not only to the web application itself but also to the other infrastructure tiers that lie beneath it — in particular, the applica- tion server, the database, and the operating system. Taking a defense-in-depth approach to security entails implementing access controls at each of these layers. to create several layers of protection.

### Summary

- Access control defects can manifest themselves in various ways. In some cases, they may be uninteresting, allowing illegitimate access to a harmless function that cannot be leveraged to escalate privileges any further. In other cases, find- ing a weakness in access controls can quickly lead to a complete compromise of the application.

  In many cases, finding a break in access controls is almost trivial. You simply request a common administrative URL and gain direct access to the functional- ity. In other cases, it may be very hard, and subtle defects may lurk deep within application logic, particularly in complex, high-security applications. The most important lesson when attacking access controls is to look everywhere. If you are struggling to make progress, be patient, and test every step of every applica- tion function. A bug that allows you to own the entire application may be just around the corner.

<br>
<br>

---

<br>
<br>

