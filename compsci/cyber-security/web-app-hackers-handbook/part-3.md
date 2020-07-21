# Chapter 5 Bypassing Client-Side Controls 

- Chapter 1 described how the core security problem with web applications arises because clients can submit arbitrary input. Despite this fact, a large proportion of web applications, nevertheless, rely on various measures implemented on the client side to control the data that they submit to the server. In general, this represents a fundamental security flaw: the user has full control over the client and the data it submits and can bypass any controls that are implemented on the client side

  This chapter looks at examples of each kind of client-side control and describes ways in which they can be bypassed.

### Transmitting Data Via the Client

- `Hidden Form Fields` -- Hidden HTML form fields are a common mechanism for transmitting data via the client in a superficially unmodifiable way. If a field is flagged as hidden, it is not displayed on-screen. However, the field’s name and value are stored within the form and are sent back to the application when the user submits the form.

  The classic example of this security flaw is a retailing application that stores the prices of products within hidden form fields. In the early days of web appli- cations, this vulnerability was extremely widespread, and by no means has it been eliminated today. Because everything on the client side is within the control of the client and remember you cannot trust anyone. 
  
  One way to achieve this is to save the source code for the HTML page, edit the field’s value, reload the source into a browser, and click the submit button. However, an easier and more elegant method is to use an intercepting proxy to modify the desired data on-the-fly.
  
  An intercepting proxy is tremendously useful when attacking a web applica- tion and is the one truly indispensable tool you need. Numerous such tools are available. But use industry standarats such as burpsuite ... etc.

- `HTTP Cookies` -- Another common mechanism for transmitting data via the client is HTTP cook- ies. As with hidden form fields, normally these are not displayed on-screen, and the user cannot modify them directly. They can, of course, be modified using an intercepting proxy, by changing either the server response that sets them or subsequent client requests that issue them.

- `URL Parameters ` -- Applications frequently transmit data via the client using preset URL param- eters. When a URL containing parameters is displayed in the browser’s location bar, any parameters can be modified easily by any user without the use of tools.

- `The Referer Header ` -- Browsers include the Referer header within most HTTP requests. It is used to indicate the URL of the page from which the current request originated — either because the user clicked a hyperlink or submitted a form, or because the page referenced other resources such as images. Hence, it can be leveraged as a mechanism for transmitting data via the client

### Capturing User Data: HTML Forms 

- HTML forms are the simplest and most common way to capture input from the user and submit it to the server. With the most basic uses of this method, users type data into named text fields, which are submitted to the server as name/value pairs. However, forms can be used in other ways; they can impose restrictions or perform validation checks on the user-supplied data. When an application employs these client-side controls as a security mechanism to defend itself against malicious input, the controls can usually be easily circumvented, leaving the application potentially vulnerable to attack.

- `Length Limits ` -- You can add client side length limit such as this: `<input type=”text” name=”quantity” maxlength=”1”>` however always remember this is so fucking easy to pass with tools such as burp you also need to set them in your server side. 

- `Script-Based Validation` -- The input validation mechanisms built into HTML forms themselves are extremely simple and are insufficiently fine-grained to perform relevant validation of many kinds of input. For example, a user registration form might contain fields for name, e-mail address, telephone number, and zip code, all of which expect different types of input. Therefore, it is common to see customized client-side input validation implemented within scripts (js, typescript .etc.)
  ```html
  <form method=”post” action=”Shop.aspx?prod=2” onsubmit=”return validateForm(this)”>
  ```
  Client-side controls of this kind are usually easy to circumvent. Usually it is sufficient to disable JavaScript within the browser. If this is done, the onsubmit attribute is ignored, and the form is submitted without any custom validation. Again controlling data on the client side is a extremly hard thing to do.
  
  However, disabling JavaScript may break the application if it depends on client-side scripting for its normal operation (such as constructing parts of the user interface). A neater approach is to enter a benign (known good) value into the input field in the browser, intercept the validated submission with your proxy, and modify the data to your desired value. This is often the easiest and most elegant way to defeat JavaScript-based validation.
  
  Client-side JavaScript routines to validate user input are common in web applications, but do not conclude that every such application is vulner- able. The application is exposed only if client-side validation is not replicated on the server, and even then only if crafted input that circumvents client-side validation can be used to cause some undesirable behavior by the application. In the majority of cases, client-side validation of user input has beneficial effects on the application’s performance and the quality of the user experience. Implementing basic validation checks on the client side makes the user’s experience much smoother and reduces the load on the server.

### Capturing User Data: Browser Extensions 

- Besides HTML forms, the other main method for capturing, validating, and submitting user data is to use a client-side component that runs in a browser extension.  When first employed in web applications, browser extensions were often used to perform simple and often cosmetic tasks. Now, companies are increasingly using browser extensions to create fully functional client-side components.

  In some cases, such as online trading applications, speed is so critical that much of the key application logic takes place on the client side. The application design may deliberately sacrifice security in favor of speed, perhaps in the mistaken belief that traders are trusted users, or that the browser exten- sion includes its own defenses. Recalling the core security problem discussed in Chapter 2, and the earlier sections of this chapter, we know that the concept of a client-side component defending its business logic is impossible.
  
    Browser extensions can capture data in various ways — via input forms and in some cases by interacting with the client operating system’s filesystem or registry. They can perform arbitrarily complex validation and manipula- tion of captured data before submission to the server

- `Intercepting Traffic from Browser Extensions` -- If your browser is already configured to use an intercepting proxy, and the application loads a client component using a browser extension, you may see requests from this component passing through your proxy. In the context of bypassing client-side input validation that is implemented in a browser extension, if the component submits the validated data to the server transparently, this data can be modified using an intercepting proxy in the same way as already described for HTML form data. For example, a browser exten- sion supporting an authentication mechanism might capture user credentials, perform some validation on these, and submit the values to the server as plain- text parameters within the request

- `Decompiling Browser Extensions ` -- By far the most thorough method of attacking a browser extension component is to decompile the object, perform a full review of the source code, and if nec- essary modify the code to change the object’s behavior, and recompile it

  Having obtained the source code for the component, or something resembling it, you can take various approaches to attacking it. The first step generally is to review the source code to understand how the component works and what functionality it contains or references
  - Input validation or other security-relevant logic and events that occur on the client side
  - Obfuscation or encryption routines being used to wrap user-supplied data before it is sent to the server
  - “Hidden” client-side functionality that is not visible in your user interface but that you might be able to unlock by modifying the component
  - References to server-side functionality that you have not previously identi- fied via your application mapping

- `Attaching a Debugger ` -- Decompilation is the most complete method of understanding and compromis- ing a browser extension. However, in large and complex components containing tens of thousands of lines of code, it is nearly always much quicker to observe the component during execution, correlating methods and classes with key actions within the interface. This approach also avoids difficulties that may arise with interpreting and recompiling obfuscated bytecode

  Because the debugger is working at the bytecode level, it can be easily used to control and understand the flow of execution. Although efficient debuggers are not fully matured for all the browser exten- sion technologies, debugging is well supported for Java applets and ... etc.

- `Native Client Components` -- Some applications need to perform actions within the user’s computer that cannot be conducted from inside a browser-based VM sandbox. In terms of client-side security controls, here are some examples of this functionality:
  - Verifying that a user has an up-to-date virus scanner
  - Verifying that proxy settings and other corporate configuration are in force
  - Integrating with a smartcard reader
  
  Typically, these kinds of actions require the use of native code components, which integrate local application functionality with web application functional- ity. Native client components are often delivered via ActiveX controls. These are custom browser extensions that run outside the browser sandbox. Native client components may be significantly harder to decipher than other browser extensions, because there is no equivalent to intermediate bytecode. However, the principles of bypassing client-side controls still apply, even if this requires a different toolset.

### Handling Client-Side Data Securely 

- As you have seen, the core security problem with web applications arises because client-side components and user input are outside the server’s direct control. The client, and all the data received from it, is inherently untrustworthy

- `Transmitting Data Via the Client` -- Many applications leave themselves exposed because they transmit critical data such as product prices and discount rates via the client in an unsafe manner.
If possible, applications should avoid transmitting this kind of data via the client. In virtually any conceivable scenario, it is possible to hold such data on the server and reference it directly from server-side logic when needed. Unless you are absolutely neccessary do not send a hidden input value because you won't have any control over it.

  If developers decide they have no alternative but to transmit critical data via the client, the data should be signed and/or encrypted to prevent user tamper- ing. But this has downsides or "warnings" too: Some ways of using signed or encrypted data may be vulnerable to replay attacks. If users know and/or control the plaintext value of encrypted strings that are sent to them, they may be able to mount various cryptographic attacks to discover the encryption key the server is using. 

- `Validating Client-Generated Data ` -- Data generated on the client and transmitted to the server cannot in principle be validated securely on the client: Lightweight client-side controls such as HTML form fields and JavaScript can be circumvented easily and provide no assurance about the input that the server receives. Controls implemented in browser extension components are sometimes more difficult to circumvent, but this may merely slow down an attacker for a short period.

  The only secure way to validate client-generated data is on the server side of the application. Every item of data received from the client should be regarded as tainted and potentially malicious. You can add controls to the client side but do not revail too much too. Make it basic to help with the server load and not ive out any details to the attackers.

- `Logging and Alerting ` -- When an application employs mechanisms such as length limits and JavaScript- based validation to enhance performance and usability, these should be inte- grated with server-side intrusion detection defenses. The server-side logic that performs validation of client-submitted data should be aware of the validation that has already occurred on the client side. If data that would have been blocked by client-side validation is received, the application may infer that a user is actively circumventing this validation and therefore is likely to be malicious. Anomalies should be logged and, if appropriate, application administrators should be alerted in real time so that they can monitor any attempted attack and take suitable action as required

### Summary

- Virtually all client/server applications must accept the fact that the client com- ponent, and all processing that occurs on it, cannot be trusted to behave as expected. As you have seen, the transparent communications methods gener- ally employed by web applications mean that an attacker equipped with simple tools and minimal skill can easily circumvent most controls implemented on the client

<br>
<br>

---

<br>
<br>

# Chapter 6 Attacking Authentication 

- On the face of it, authentication is conceptually among the simplest of all the security mechanisms employed within web applications. In the typical case, a user supplies her username and password, and the application must verify that these items are correct. If so, it lets the user in. If not, it does not.

  Authentication also lies at the heart of an application’s protection against malicious attack. It is the front line of defense against unauthorized access. If an attacker can defeat those defenses, he will often gain full control of the applica- tion’s functionality and unrestricted access to the data held within it. Without robust authentication to rely on, none of the other core security mechanisms (such as session management and access control) can be effective.
  
### Design Flaws in Authentication 

- Authentication functionality is subject to more design weaknesses than any other security mechanism commonly employed in web applications. Even in the apparently simple, standard model where an application authenticates users based on their username and password, shortcomings in the design of this model can leave the application highly vulnerable to unauthorized access.

- `Bad Passwords` -- Many web applications employ no or minimal controls over the quality of users’ passwords (short, blank, dictionary words)

- `Brute-Forcible Login` -- Login functionality presents an open invitation for an attacker to try to guess usernames and passwords and therefore gain unauthorized access to the appli- cation. If the application allows an attacker to make repeated login attempts with different passwords until he guesses the correct one, it is highly vulnerable even to an amateur attacke. Given today’s bandwidth and processing capabilities, it is possible to make thousands of login attempts per minute from a standard PC and DSL connection

- `Verbose Failure Messages` -- When a login attempt fails, you can of course infer that at least one piece of information was incorrect. However, if the application tells you which piece of information was invalid, you can exploit this behavior to considerably diminish the effectiveness of the login mechanism. Do not give out details.

- `Vulnerable Transmission of Credentials` -- If an application uses an unencrypted HTTP connection to transmit login cre- dentials, an eavesdropper who is suitably positioned on the network can, of course, intercept them. Even if login occurs over HTTPS, credentials may still be disclosed to unau- thorized parties if the application handles them in an unsafe manner

- `Password Change Functionality` -- Most apps dont have as much security in this form as they do in login but they should. Check whether the “new password” and “confirm new password” fields have the same value only after validating the existing password, thereby allowing an attack to succeed in discovering the existing password noninvasively.

- `Forgotten Password Functionality` -- Like password change functionality, mechanisms for recovering from a forgot- ten password situation often introduce problems. In addition to this range of defects, design weaknesses in forgotten pass- word functions frequently make this the weakest link at which to attack the application’s overall authentication logic. Do not use basic secruity questions like the city you grew up in, your mothers maiden name, they can be brute forced easily or dictionary attacked. And never send them over the app itself use email for transportation of the new password.

- `“Remember Me” Functionality` -- Applications often implement “remember me” functions as a convenience to users.  These functions are often insecure by design and leave the user exposed to attack both locally and by users on other computers. Even if the information stored for reidentifying users is suitably protected (encrypted) to prevent other users from determining or guessing it, the information may still be vulnerable to capture through a bug such as cross-site scripting

- `User Impersonation Functionality` -- Some applications implement the facility for a privileged user of the application to impersonate other users in order to access data and carry out actions within their user context. For example, some banking applications allow helpdesk opera- tors to verbally authenticate a telephone user and then switch their application session into that user’s context to assist him or her. It is a extremly tricky design to do: It may be implemented as a “hidden” function, which is not subject to proper access controls. If an application allows administrative users to be impersonated, any weak- ness in the impersonation logic may result in a vertical privilege escalation vulnerability. This also leaves a "backdoor" for the attacked to find and attack all of the users from a single point of entry. Again do not implement it unless you have to.

- `Incomplete Validation of Credentials` -- Well-designed authentication mechanisms enforce various requirements on passwords, such as a minimum length or the presence of both uppercase and lowercase characters. Correspondingly, some poorly designed authentication mechanisms not only do not enforce these good practices but also do not take into account users’ own attempts to comply with them

- `Nonunique Usernames` -- Some applications that support self-registration allow users to specify their own username and do not enforce a requirement that usernames be unique. Although this is rare, the authors have encountered more than one application with this behavior. Don't fucking do this (unless you have to). 

- `Predictable Usernames` -- Some applications automatically generate account usernames according to a predictable sequence (cust5331, cust5332, and so on). When an application behaves like this, an attacker who can discern the sequence can quickly arrive at a potentially exhaustive list of all valid usernames

- `Predictable Initial Passwords` -- In some applications, users are created all at once or in sizeable batches and are automatically assigned initial passwords, which are then distributed to them through some means. The means of generating passwords may enable an attacker to predict the passwords of other application users.

- `Insecure Distribution of Credentials` -- Many applications employ a process in which credentials for newly created accounts are distributed to users out-of-band of their normal interaction with the applica- tion (for example, via post, e-mail, or SMS text message). Sometimes, this is done for reasons motivated by security concerns, such as to provide assurance that the postal or e-mail address supplied by the user actually belongs to that person
 
### Implementation Flaws in Authentication

- `Defects in Multistage Login Mechanisms` -- It is often assumed that multistage login mechanisms are less prone to secu- rity bypasses than standard username/password authentication. This belief is mistaken. Performing several authentication checks may add considerable security to the mechanism. But counterbalancing this, the process is more prone to flaws in implementation. In several cases where a combination of flaws is present, it can even result in a solution that is less secure than a nor- mal login based on username and password.

- `Insecure Storage of Credentials` -- If an application stores login credentials insecurely, the security of the login mechanism is undermined, even though there may be no inherent flaw in the authentication process itself. This may involve passwords being stored in cleartext. But if passwords are being hashed using a standard algo- rithm such as MD5 or SHA-1, this still allows an attacker to simply look up observed hashes against a precomputed database of hash values.
 
### Securing Authentication 

- Implementing a secure authentication solution involves attempting to simultane- ously meet several key security objectives, and in many cases trade off against other objectives such as functionality, usability, and total cost.

- `Use Strong Credentials` -- 
  - 1 - Suitable minimum password quality requirements should be enforced. These may include rules regarding minimum length; the appearance of alphabetic, numeric, and typographic characters; the appearance of both uppercase and lowercase characters; the avoidance of dictionary words, names, and other common passwords; preventing a password from being set to the username;
  - 2 - Usernames should be unique. (this is an overkill for the most apps)
  - 3 - Any system-generated usernames and passwords should be created with sufficient entropy that they cannot feasibly be sequenced or pre- dicted.
  - 4 - Users should be permitted to set sufficiently strong passwords. For example, long passwords and a wide range of characters should be allowed.

- `Handle Credentials Secretively` --
  - 1 - All client-server communications should be protected using a well- established cryptographic technology, such as SSL
  - 2 - If it is considered preferable to use HTTP for the unauthenticated areas of the application, ensure that the login form itself is loaded using HTTPS
  - 3 - Only POST requests should be used to transmit credentials to the server. Credentials should never be placed in URL parameters or cookies, Credentials should never be transmitted back to the client, even in parameters to a redirect.
  - 4 - All server-side application components should store credentials in a man- ner that does not allow their original values to be easily recovered. use a strong hash function
  - 5 - Client-side “remember me” functionality should in general remember only nonsecret items such as usernames
  - 6 - Particular attention should be paid to eliminating cross-site scripting vulnerabilities within the application that may be used to steal stored credentials
  - 7 - A password change facility should be implemented and users should be required to change their password periodically.

- `Validate Credentials Properly` -- 
  - 1 - Passwords should be validated in full 
  - 2 - The application should be aggressive in defending itself against unex- pected events occurring during login processing.
  - 3 - All authentication logic should be closely code-reviewed, both as pseudo- code and as actual application source code, to identify logic errors
  - 4 - If functionality to support user impersonation is implemented, this should be strictly controlled to ensure that it cannot be misused to gain unau- thorized access.
  - 5 - Multistage logins should be strictly controlled to prevent an attacker from interfering with the transitions and relationships between the stages:

- `Prevent Information Leakage` --
  - 1 - An attacker should have no means of determining which piece of the various items submitted has caused a problem. Have a basic "invalid username or password" error messages.
  - 2 - If the application enforces some kind of account lockout to prevent brute- force attacks
  - 3 - be careful not to let this lead to any information leakage. For example, if an application discloses that a specific account has been suspended for X minutes due to Y failed logins, this behavior can easily be used to enumerate valid usernames. In addition, disclosing the precise metrics of the lockout policy enables an attacker to optimize any attempt to continue guessing passwords in spite of the policy  the application should respond to any series of failed login attempts from the same browser with a generic message advising that accounts are suspended if multiple failures occur and that the user should try again later.

- `Prevent Brute-Force Attacks` --
  - 1 - Some security-critical applications (such as online banks) simply disable an account after a small number of failed logins (such as three). They also require that the account owner take various out-of-band steps to reactivate the account, such as telephoning customer support and answering a series of security questions A more balanced policy, suitable for most security-aware applications, is to sus- pend accounts for a short period (such as 30 minutes) following a small number of failed login attempts (such as three)
  - 2 - If a policy of temporary account suspension is implemented, care should be taken to ensure its effectiveness: To prevent information leakage leading to username enumeration, the application should never indicate that any specific account has been suspended. The policy’s metrics should not be disclosed to users. Simply telling legitimate users to “try again later” does not seriously diminish their quality of service. Dont give the attacker any info! If an account is suspended, login attempts should be rejected without even checking the credentials.
  - 3 - The effectiveness of this kind of attack will, of course, be massively reduced if other areas of the authentication mechanism are designed securely. If usernames cannot be enumerated or reliably predicted, an attacker will be slowed down by the need to perform a brute-force exercise in guessing usernames. And if strong requirements are in place for password quality, it is far less likely that the attacker will choose a password for testing that even a single user of the application has chosen.
  - 4 - In addition to these controls, an application can specifically protect itself against this kind of attack through the use of CAPTCHA (Completely Automated Public Turing test to tell Computers and Humans Apart)

- `Prevent Misuse of the Password Change Function` --
  - 1 - A password change function should always be implemented, to allow periodic password expiration
  - 2 - As a key security mechanism, this needs to be well defended against misuse.
  - 3 - The function should be accessible only from within an authenticated session.
  - 4 - There should be no facility to provide a username, either explicitly or via a hidden form field or cookie.
  - 5 - As a defense-in-depth measure, the function should be protected from unauthorized access gained via some other security defect in the applica- tion
  - 6 - The new password should be entered twice to prevent mistakes. The appli- cation should compare the “new password” and “confirm new password” fields as its first step 
  - 7 -  single generic error message should be used to notify users of any error in existing credentials, and the function should be temporarily suspended following a small number of failed attempts to change the password.
  - 8 - Users should be notified out-of-band (such as via e-mail) that their pass- word has been changed, but the message should not contain either their old or new credentials.

- `Prevent Misuse of the Account Recovery Function` -- 
  - 1 - In the most security-critical applications, such as online banking, account recovery in the event of a forgotten password is handled out-of-band. A user must make a telephone call and answer a series of security questions The majority of applications do not want or need this level of security, so an automated recovery function may be appropriate.
  - 2 - Features such as password “hints” should never be used, because they mainly help an attacker
  - 3 - The best automated solution for enabling users to regain control of accounts is to e-mail the user a unique, time-limited, unguessable, single-use recov- ery URL. To prevent an attacker from denying service to users by continually requesting password reactivation e-mails, the user’s existing credentials should remain valid until they are changed.
  - 4 - To further protect against unauthorized access, applications may present users with a secondary challenge that they must complete before gain- ing access to the password reset function. Be sure that the design of this challenge does not introduce new vulnerabilitie

- `Log, Monitor, and Notify` -- 
  - 1 - The application should log all authentication-related events, including login, logout, password change, password reset, account suspension, and account recovery. Where applicable, both failed and successful attempts should be logged. The logs should contain all relevant details (such as username and IP address) but no security secrets (such as passwords). Logs should be strongly protected from unauthorized access, because they are a critical source of information leakage.
  - 2 - Anomalies in authentication events should be processed by the appli- cation’s real-time alerting and intrusion prevention functionality. For example, application administrators should be made aware of patterns indicating brute-force attacks
  - 3 - Users should be notified out-of-band of any critical security events.
  - 4 - Users should be notified in-band of frequently occurring security events on her attack.

### Summary

- Authentication functions are perhaps the most prominent target in a typical application’s attack surface. By definition, they can be reached by unprivileged, anonymous users. If broken, they grant access to protected functionality and sensitive data. They lie at the core of the security mechanisms that an application employs to defend itself and are the front line of defense against unauthorized access.

  The most important lesson when attacking authentication functionality is to look everywhere. In addition to the main login form, there may be functions to register new accounts, change passwords, remember passwords, recover forgotten passwords, and impersonate other users. Each of these presents a rich target of potential defects, and problems that have been consciously eliminated within one function often reemerge within others

<br>
<br>

---

<br>
<br>


