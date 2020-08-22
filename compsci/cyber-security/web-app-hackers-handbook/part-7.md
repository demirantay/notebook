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
 
- `UI Redress` --

### Capturing Data Cross-Domain

- `Capturing Data by Injecting HTML ` --

- `Capturing Data by Injecting CSS ` --

- `JavaScript Hijacking ` --
 
### The Same-Origin Policy Revisited

- `The Same-Origin Policy and Browser Extensions ` --

- `The Same-Origin Policy and HTML5` --

- `Crossing Domains with Proxy Service Applications` --

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

