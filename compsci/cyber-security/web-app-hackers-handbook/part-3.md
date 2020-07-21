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

- `User Impersonation Functionality` --

- `Incomplete Validation of Credentials` -- 

- `Nonunique Usernames` --

- `Predictable Usernames` -- 

- `Predictable Initial Passwords` -- 

- `Insecure Distribution of Credentials` -- 
 
### Implementation Flaws in Authentication

- `Fail-Open Login Mechanisms` --

- `Defects in Multistage Login Mechanisms` --

- `Insecure Storage of Credentials` -- 
 
### Securing Authentication 

- `Use Strong Credentials` -- 

- `Handle Credentials Secretively` --

- `Validate Credentials Properly` -- 

- `Prevent Information Leakage` --

- `Prevent Brute-Force Attacks` --

- `Prevent Misuse of the Password Change Function` --

- `Prevent Misuse of the Account Recovery Function` -- 

- `Log, Monitor, and Notify` -- 

### Summary

<br>
<br>

---

<br>
<br>


