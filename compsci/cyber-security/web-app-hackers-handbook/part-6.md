# Chapter 11 Attacking Application Logic 

- All web applications employ logic to deliver their functionality. Writing code in a programming language involves at its root nothing more than breaking a complex process into simple and discrete logical steps. Translating a piece of functionality that is meaningful to human beings into a sequence of small operations that can be executed by a computer involves a great deal of skill and discretion

  This logic presents an intricate attack surface that is always present but often overlooked. Many code reviews and penetration tests focus exclusively on common “headline” vulnerabilities such as SQL injection and cross-site scripting, because these have an easily recognizable signature and well-researched exploitation vector. By contrast, flaws in an application’s logic are harder to characterize: each instance may appear to be a unique one-off occurrence, and they usually are not identified by any automated vulnerability scanners. As a result, they generally are not as well appreciated or understood, and therefore they are of great interest to an attacker.

### The Nature of Logic Flaws

- Logic flaws in web applications are extremely varied. They range from simple bugs manifested in a handful of lines of code, to complex vulnerabilities arising from the interoperation of several core components of the application

  Unlike other coding flaws such as SQL injection or cross-site scripting, no common “signature” is associated with logic flaws. In many cases, the defect can be represented in terms of a specific assumption that the designer or developer made, either explicitly or implicitly, that turns out to be flawed. In general terms, a programmer may have reasoned something like “If A happens, then B must be the case, so I will do C.” The programmer did not ask the entirely different question “But what if X occurs?” and therefore failed to consider a scenario that violates the assumption.

### Real-World Logic Flaws

- The best way to learn about logic flaws is not by theorizing, but by becoming acquainted with some actual examples. Although individual instances of logic flaws differ hugely, they share many common themes, and they demonstrate the kinds of mistake

- `Example 2: Fooling a Password Change Function ` --
  - __The Functionality__ -- The application implemented a password change function for end users. It required the user to fill out fields for username, existing password, new pass- word, and confirm new password.
  - __The Assumption__ -- The client-side interface presented to users and administrators differed in one respect: the administrator’s interface did not contain a field for the existing password. When the server-side application processed a password change request, it used the presence or absence of the existing password parameter to indicate whether the request was from an administrator or an ordinary user. In other words, it assumed that ordinary users would always supply an existing password parameter.
  - __The Attack__ -- When the assumption is explicitly stated in this way, the logic flaw becomes obvious. Of course, an ordinary user could issue a request that did not contain an existing password parameter, because users controlled every aspect of the requests they issued. This logic flaw was devastating for the application. It enabled an attacker to
reset the password of any other user and take full control of that person’s account.

- `Example 3: Proceeding to Checkout ` --
  - __The Functionality__ -- The process of placing an order involved the following stages: 1. Browse the product catalog, and add items to the shopping basket. 2. Return to the shopping basket, and finalize the order. 3. Enter payment information. 4. Enter delivery information.
  - __The Assumption__ -- The developers assumed that users would always access the stages in the intended sequence, because this was the order in which the stages are delivered to the user by the navigational links and forms presented to the user’s browser
  - __The Attack__ -- The developers’ assumption was flawed for fairly obvious reasons. Users con- trolled every request they made to the application and therefore could access any stage of the ordering process in any sequence. By proceeding directly from stage 2 to stage 4, an attacker could generate an order that was finalized for delivery but that had not actually been paid for.

### Avoiding Logic Flaws

- Just as there is no unique signature by which logic flaws in web applications can be identified, there is also no silver bullet that will protect you. For example, there is no equivalent to the straightforward advice of using a safe alternative to a dangerous API. Nevertheless, a range of good practices can be applied to significantly reduce the risk of logical flaws appearing within your applications:
  - Ensure that every aspect of the application’s design is clearly documented in sufficient detail for an outsider to understand every assumption the designer made
  - Mandate that all source code is clearly commented to include the follow- ing information throughout: The purpose and intended uses of each code component. References to all client code that uses the component. Clear documenta- tion to this effect could have prevented the logic flaw
  - During security-focused reviews of the application design, reflect on every assumption made within the design, and try to imagine circumstances under which each assumption might be violated
  - During security-focused code reviews, think laterally about two key areas: the ways in which the application will handle unexpected user behavior, and the potential side effects of any dependencies and interoperation between different code components and different application functions.

### Summary

- Attacking an application’s logic involves a mixture of systematic probing and lateral thinking. We have described various key checks that you should always carry out to test the application’s behavior in response to unexpected input. These include removing parameters from requests, using forced browsing to access functions out of sequence, and submitting parameters to different loca- tions within the application. Often, how an application responds to these actions points toward some defective assumption that you can violate, to malicious effect.
In addition to these basic tests, the most important challenge when probing for logic flaws is to try to get inside the developers’ minds.

<br>
<br>

---

<br>
<br>

# Chapter 12 Attacking Users: Cross-Site Scripting 

- All the attacks we have considered so far involve directly targeting the server- side application. Many of these attacks do, of course, impinge upon other users, such as a SQL injection attack that steals other users’ data. But the attacker’s essential methodology was to interact with the server in unexpected ways to perform unauthorized actions and access unauthorized data.

  The attacks described in this chapter and the next are in a different category, because the attacker’s primary target is the application’s other users. All the relevant vulnerabilities still exist within the application itself. However, the attacker leverages some aspect of the application’s behavior to carry out malicious actions against another end user. 
  
  A key focus of research in the past decade has been client-side vulnerabilities, with defects such as session fixation and cross-site request forgery first being discussed many years after most categories of server-side bugs were widely known. Media focus on web security is predominantly concerned with client- side attacks, with such terms as spyware, phishing, and Trojans being common currency to many journalists who have never heard of SQL injection or path traversal.
  
  Attacks against other application users come in many forms and manifest a variety of subtleties and nuances that are frequently overlooked. They are also less well understood in general than the primary server-side attacks, with dif- ferent flaws being conflated or neglected even by some seasoned penetration testers. This chapter focuses on cross-site scripting (XSS). This category of vulner- ability is the Godfather of attacks against other users. It is by some measure the most prevalent web application vulnerability found in the wild.

### Varieties of XSS 

- XSS vulnerabilities come in various forms and may be divided into three vari- eties: reflected, stored, and DOM-based. Although these have several features in common, they also have important differences in how they can be identified and exploited

- `Reflected XSS Vulnerabilities ` -- This type of simple XSS bug accounts for approximately 75% of the XSS vulnerabilities that exist in real-world web applications. It is called reflected XSS because exploiting the vulnerability involves crafting a request containing embedded JavaScript that is reflected to any user who makes the request. The attack payload is delivered and executed via a single request and response. For this reason, it is also sometimes called first-order XSS.

- `Stored XSS Vulnerabilities ` -- A different category of XSS vulnerability is often called stored cross-site scripting. This version arises when data submitted by one user is stored in the application (typically in a back-end database) and then is displayed to other users without being filtered or sanitized appropriately.

  Stored XSS vulnerabilities are common in applications that support interac- tion between end users, or where administrative staff access user records and data within the same application Attacks against stored XSS vulnerabilities typically involve at least two requests to the application. In the first, the attacker posts some crafted data containing malicious code that the application stores. In the second, a victim views a page containing the attacker’s data, and the malicious code is executed when the script is executed in the victim’s browser. For this reason, the vulnerability is also sometimes called second-order cross-site scripting
  
  First, in the case of reflected XSS, to exploit a vulnerability, the attacker must induce victims to visit his crafted URL. In the case of stored XSS, this require- ment is avoided. Having deployed his attack within the application, the attacker simply needs to wait for victims to browse to the page or function that has been compromised. Usually this is a regular page of the application that normal users will access of their own accord.
  
  These differences between reflected and stored XSS mean that stored XSS flaws are often critical to an application’s security. In most cases, an attacker can submit some crafted data to the application and then wait for victims to be hit. If one of those victims is an administrator, the attacker will have compromised the entire application.

- `DOM-Based XSS Vulnerabilities ` -- Both reflected and stored XSS vulnerabilities involve a specific pattern of behavior, in which the application takes user-controllable data and displays this back to users in an unsafe way. A third category of XSS vulnerabilities does not share this characteristic. In DOM XSS. The server’s response does not contain the attacker’s script in any form. When the user’s browser processes this response, the script is executed
nonetheless.

  DOM-based XSS vulnerabilities are more similar to reflected XSS bugs than to stored XSS bugs. Their exploitation typically involves an attacker’s inducing a user to access a crafted URL containing malicious code. The server’s response to that specific request causes the malicious code to be executed. However, in terms of the exploitation details, there are important differences between reflected and DOM-based XSS

### XSS Attacks in Action 

- `Payloads for XSS Attacks ` -- So far, we have focused on the classic XSS attack payload. It involves capturing a victim’s session token, hijacking her session, and thereby making use of the application “as” the victim, performing arbitrary actions and potentially taking ownership of that user’s account. In fact, numerous other attack payloads may be delivered via any type of XSS vulnerability.
  - Virtual Defacement
  - Injecting Trojan Functionality
  - Inducing User Actions

- `Delivery Mechanisms for XSS Attacks ` -- Having identified an XSS vulnerability and formulated a suitable payload to exploit it, an attacker needs to find some means of delivering the attack to other users of the application. 

  __Delivering Reflected and DOM-Based XSS Attacks__ -- In addition to the obvious phishing vector of bulk e-mailing a crafted URL to random users, an attacker may attempt to deliver a reflected or DOM-based XSS attack via the following mechanisms:
  - In a targeted attack, a forged e-mail may be sent to a single target user or a small number of users.
  - A URL can be fed to a target user in an instant message.
  - Content and code on third-party websites can be used to generate requests that trigger XSS flaws
  - In a variation on the third-party website attack, some attackers have been known to pay for banner advertisements that link to a URL containing an XSS payload for a vulnerable application
  
  __Chaining XSS and Other Attacks__ -- XSS flaws can sometimes be chained with other vulnerabilities to devastating effect.

- Finding and Exploiting XSS Vulnerabilities (skipped this part cause im bored out of my mind, plus i am not going to learn about exploiting xss in just a fucking chapter.)

### Preventing XSS Attacks 

- Despite the various manifestations of XSS, and the different possibilities for exploitation, preventing the vulnerability itself is in fact conceptually straightfor- ward. What makes it problematic in practice is the difficulty of identifying every instance in which user-controllable data is handled in a potentially dangerous way. Any given page of an application may process and display dozens of items of user data. In addition to the core functionality, vulnerabilities may arise in error messages and other locations. It is hardly surprising, therefore, that XSS flaws are so hugely prevalent, even in the most security-critical application. 

- `Preventing Reflected and Stored XSS ` -- The root cause of both reflected and stored XSS is that user-controllable data is copied into application responses without adequate validation and sanitization. Because the data is being inserted into the raw source code of an HTML page, malicious data can interfere with that page, modifying not only its content but also its structure — breaking out of quoted strings, opening and closing tags, injecting scripts, and so on.

  Having identified all the operations that are potentially at risk of XSS and that need to be suitably defended, you should follow a threefold approach to prevent any actual vulnerabilities from arising: validate input, validate output, eliminate dangeorus insertion points.

  __Validate Input__ -- At the point where the application receives user-supplied data that may be cop- ied into one of its responses at any future point, the application should perform context-dependent validation of this data, in as strict a manner as possible. Different validation rules should be applied as restrictively as possible to names, e-mail addresses, account numbers, and so on,
  
  __Validate Output__ -- At the point where the application copies into its responses any item of data that originated from some user or third party, this data should be HTML-encoded to sanitize potentially malicious characters. HTML encoding involves replacing literal characters with their corresponding HTML entities. This ensures that browsers will handle potentially malicious characters in a safe way, treating them as part of the content of the HTML document and not part of its structure.
  
  __Eliminate Dangerous Insertion Points__ -- There are some locations within the application page where it is just too inher- ently dangerous to insert user-supplied input, and developers should look for an alternative means of implementing the desired functionality. A further pitfall to avoid is situations where an attacker can manipulate the character set of the application’s response, either by injecting into a relevant directive or because the application uses a request parameter to specify the preferred character set. In this situation, input and output filters that are well designed in other respects may fail because the attacker’s input is encoded in an unusual form that the filters do not recognize as potentially malicious. Wherever possible, the application should explicitly specify an encoding type in its response headers, disallow any means of modifying this
  
  __Allowing Limited HTML__ -- Some applications need to let users submit data in HTML format that will be inserted into application responses. For example, a blogging application may. allow users to write comments using HTML, to apply formatting to their com- ments, embed links or images, and so on. In this situation, applying the preceding measures across the board will break the application. Users’ HTML markup will itself be HTML-encoded in responses and therefore will be displayed on-screen as actual markup, rather than as the formatted content that is required.
  
  For an application to support this functionality securely, it needs to be robust in allowing only a limited subset of HTML, which does not provide any means of introducing script code. This must involve a whitelist approach in which only specific tags and attributes are permitted. Doing this successfully is a nontrivial task because, as you have seen, there are numerous ways to use seemingly harmless tags to execute code.

- `Preventing DOM-Based XSS` -- The defenses described so far obviously do not apply directly to DOM-based XSS, because the vulnerability does not involve user-controlled data being copied into server responses. Wherever possible, applications should avoid using client-side scripts to process DOM data and insert it into the page. Because the data being processed is outside of the server’s direct control, and in some cases even outside of its visibility, this behavior is inherently risky.

  If it is considered unavoidable to use client-side scripts in this way, DOM-based XSS flaws can be prevented through two types of defenses,
  
  __validate input__ -- In many situations, applications can perform rigorous validation on the data being processed. Indeed, this is one area where client-side validation can be more effec- tive than server-side validation
  
  __validate output__ -- As with reflected XSS flaws, applications can perform HTML encoding of user- controllable DOM data before it is inserted into the document. This enables all kinds of potentially dangerous characters and expressions to be displayed within the page in a safe way

### Summary

- This chapter has examined the various ways in which XSS vulnerabilities can arise and ways in which common filter-based defenses can be circumvented. Because XSS vulnerabilities are so prevalent, it is often straightforward to find several bugs within an application that are easy to exploit. XSS becomes more interesting, from a research perspective at least, when various defenses are in place that force you to devise some highly crafted input, or leverage some little- known feature of HTML, JavaScript, or VBScript, to deliver a working exploit.

<br>



