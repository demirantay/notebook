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

- `Common Browser Extension Technologies` --

- `Approaches to Browser Extensions ` --

- `Intercepting Traffi c from Browser Extensions` --

- `Decompiling Browser Extensions ` --

- `Attaching a Debugger ` --

- `Native Client Components` --

### Handling Client-Side Data Securely 

- `Transmitting Data Via the Client` --

- `Validating Client-Generated Data ` --

- `Logging and Alerting ` --

<br>
<br>

---

<br>
<br>

# Chapter 6 Attacking Authentication 

### Authentication Technologies 

- `Mechanisms` --

### Design Flaws in Authentication 
 
### Implementation Flaws in Authentication
 
### Securing Authentication 

### Summary

<br>
<br>

---

<br>
<br>


