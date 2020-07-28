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


