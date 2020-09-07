# Chapter 13 Attacking Users: Other Techniques 

- The preceding chapter examined the grandfather of attacks against other appli- cation users—cross-site scripting (XSS). This chapter describes a wide range of other attacks against users. Some of these have important similarities to XSS attacks. In many cases, the attacks are more complex or subtle than XSS attacks and can succeed in situations where plain XSS is not possible.

### Inducing User Actions 

- 
The preceding chapter described how XSS attacks can be used to induce a user to unwittingly perform actions within the application. Where the victim user has administrative privileges, this technique can quickly lead to complete compromise of the application.

- `Request Forgery ` -- This category of attack (also known as session riding) is closely related to ses- sion hijacking attacks, in which an attacker captures a user’s session token and therefore can use the application “as” that user.
  
  __Cross site request forgery__ -- In cross-site request forgery (CSRF) attacks, the attacker creates an innocuous- looking website that causes the user’s browser to submit a request directly to the vulnerable application to perform some unintended action that is beneficial to the attacker.
  
  __Exploiting CSRF Flaws__ -- CSRF vulnerabilities arise primarily in cases where applications rely solely on HTTP cookies for tracking sessions. Once an application has set a cookie in a user’s browser, the browser automatically submits that cookie to the application in every subsequent request.
 
  __Authentication and CSRF__ -- Since CSRF attacks involve performing some privileged action within the context of the victim user’s session, they normally require the user to be logged in to the application at the time of the attack.
One location where numerous dangerous CSRF vulnerabilities have arisen is in the web interfaces used by home DSL routers. These devices often contain sensitive functions, such as the ability to open all ports on the Internet-facing firewall. Since these functions are often not protected against CSRF, and since most users do not modify the device’s default internal IP address, they are vulnerable to CSRF attacks delivered by malicious external sites.

  __Preventing CSRF Flaws__ -- CSRF vulnerabilities arise because of how browsers automatically submit cookies back to the issuing web server with each subsequent request. If a web applica- tion relies solely on HTTP cookies as its mechanism for tracking sessions, it is inherently at risk from this type of attack. The standard defense against CSRF attacks is to supplement HTTP cookies with additional methods of tracking sessions. This typically takes the form of additional tokens that are transmitted via hidden fields in HTML forms. When each request is submitted, in addition to validating session cookies, the application verifies that the correct token was received in the form submission. Assuming that the attacker has no way to determine the value of this token, he cannot construct a cross-domain request that succeeds in performing the desired action.
 
  When anti-CSRF tokens are used in this way, they must be subjected to the same safeguards as normal session tokens. If an attacker can predict the values of tokens that are issued to other users, he may be able to determine all the parameters required for a CSRF request and therefore still deliver an attack.
 
  __Defeating Anti-CSRF Defenses Via XSS__ -- It is often claimed that anti-CSRF defenses can be defeated if the application contains any XSS vulnerabilities. But this is only partly true. The thought behind the claim is correct—that because XSS payloads execute on-site, they can perform two-way interaction with the application and therefore can retrieve tokens from the application’s responses and submit them in subsequent requests.
 
- `UI Redress` -- Fundamentally, anti-CSRF defenses involving tokens within the page aim to ensure that requests made by a user originate from that user’s actions within the application itself and are not induced by some third-party domain. UI redress attacks are designed to allow a third-party site to induce user actions on another domain even if anti-CSRF tokens are being used. These attacks work because, in the relevant sense, the resulting requests actually do originate within the application being targeted. UI redress techniques are also often referred to as “clickjacking,” “strokejacking,” and other buzzwords. 
In its basic form, a UI redress attack involves the attacker’s web page load- ing the target application within an iframe on the attacker’s page.

  __Framebusting defenses__ -- When UI redress attacks were first widely discussed, many high-profile web applications sought to defend against them using a defensive technique known as framebusting. Framebusting can take various forms, but it essentially involves each relevant page of an application running a script to detect if it is being loaded within an iframe. If so, an attempt is made to “bust” out of the iframe, or some other defensive action is performed, such as redirecting to an error page or refusing to display the application’s own interface. It found that in every instance these could be circumvented in one way or another.
  
  __Preventing UI Redress__ -- The current consensus is that although some kinds of framebusting code may hinder UI redress attacks in some situations, this technique should not be relied on as a surefire defense against these attacks. A more robust method for an application to prevent an attacker from fram- ing its pages is to use the X-Frame-Options response header. It was introduced with Internet Explorer 8 and has since been implemented in most other popular browsers. The X-Frame-Options header can take two values. The value deny instructs the browser to prevent the page from being framed, and sameorigin instructs the browser to prevent framing by third-party domains.

### Capturing Data Cross-Domain

- `Capturing Data by Injecting HTML ` -- Many applications contain functionality that allows an attacker to inject some limited HTML into a response that is received by a different user in a way that falls short of a full XSS vulnerability. For example, a web mail application may display e-mails containing some HTML markup but block any tags and attributes that can be used to execute script code. Or a dynamically generated error mes- sage may filter a range of expressions but still allow some limited use of HTML.
In these situations, it may be possible to leverage the HTML-injection condi- tion to cause sensitive data within the page to be sent to the attacker’s domain. For example, in a web mail application, the attacker may be able to capture the contents of a private e-mail message

- `JavaScript Hijacking ` -- JavaScript hijacking provides a further method of capturing data cross-domain, turning CSRF into a limited “two-way” attack. As described in Chapter 3, the same-origin policy allows one domain to include script code from another domain, and this code executes in the context of the invoking domain, not the issuing domain

  many of today’s applications use JavaScript to transmit sensitive data, in a way that was not foreseen when the same-origin policy was devised. Furthermore, developments in browsers mean that an increasing range of syntax is becoming executable as valid JavaScript, with new opportunities for capturing data cross-domain.
  
  __Preventing javascript hijacking__ -- Several preconditions must be in place before a JavaScript hijacking attack can be performed. To prevent such attacks, it is necessary to violate at least one of these preconditions.
    - As for requests that perform sensitive actions, the application should use standard anti-CSRF defenses to prevent cross-domain requests from returning any responses containing sensitive data.
    -  Because the application can use XMLHttpRequest to retrieve dynamic script code, it can use POST requests to do so. If the application accepts only POST requests for potentially vulnerable script code, it prevents third-party sites from including them using <script> tags.

### Other Client-Side Injection Attacks

- `HTTP Header Injection ` --

- `Cookie Injection ` --

- `Open Redirection Vulnerabilities ` --

- `Client-Side SQL Injection ` --

- `Client-Side HTTP Parameter Pollution` --

### Local Privacy Attacks 

- `Persistent Cookies` --

- `Cached Web Content` --

- `Browsing History ` --

- `Autocomplete` --

- `Flash Local Shared Objects ` --

- `Silverlight Isolated Storage` --

- `Internet Explorer userData ` --

- `HTML5 Local Storage Mechanisms` --

- `Preventing Local Privacy Attacks ` --

### Attacking ActiveX Controls

- `Finding ActiveX Vulnerabilities` --

- `Preventing ActiveX Vulnerabilities ` --

### Attacking the Browser 

- `Logging Keystrokes` --

- `Stealing Browser History and Search Queries ` --

- `Enumerating Currently Used Applications ` --

- `Port Scanning ` --

- `Attacking Other Network Hosts ` --

- `Exploiting Non-HTTP Services ` --

- `Exploiting Browser Bugs ` --

- `DNS Rebinding` --

- `Browser Exploitation Frameworks ` --

- `Man-in-the-Middle Attacks ` --

### Summary

<br>
<br>

---

<br>
<br>

# Chapter 14 Automating Customized Attacks 

### Uses for Customized Automation 

- `The Basic Approach ` --

- `Detecting Hits ` --

- `Scripting the Attack ` --

- `JAttack` --

### Enumerating Valid Identifi ers 

### Harvesting Useful Data

### Fuzzing for Common Vulnerabilities 

### Putting It All Together: Burp Intruder

### Barriers to Automation 

- `Session-Handling Mechanisms` --

- `CAPTCHA Controls ` --

### Summary


<br>
<br>

---

<br>
<br>

