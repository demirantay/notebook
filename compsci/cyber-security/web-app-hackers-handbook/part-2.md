# Chapter 3 Web Application Technologies

- Web applications employ a myriad of technologies to implement their functionality. This chapter is a short primer on the key technologies that you are likely
to encounter when attacking web applications. These
technologies are in general easy to understand, and a grasp of their relevant
features is key to performing effective attacks against web applications

### The HTTP Protocol 

- Hypertext transfer protocol (HTTP) is the core communications protocol used to
access the World Wide Web and is used by all of today’s web applications. HTTP uses a message-based model in which a client sends a request message and the server returns a response message. All HTTP messages (requests and responses) consist of one or more headers,
each on a separate line, followed by a mandatory blank line, followed by an
optional message body

- `HTTP Requests ` -- The first line of every HTTP request consists of three items, separated by spaces:
 - A verb indicating the HTTP method.
 - The requested URL
 - The HTTP version being used. The only HTTP versions in common use on the Internet are 1.0 and 1.1
 - The Referer header is used to indicate the URL from which the request originated'
 - The User-Agent header is used to provide information about the browser
or other client software that generated the request.
 - The Host header specifi es the hostname that appeared in the full URL
being accessed.
 - The Cookie header is used to submit additional parameters that the server
has issued to the client

- `HTTP Responses` -- The fi rst line of every HTTP response consists of three items, separated by
spaces:
 - The HTTP version being used.
 - A numeric status code indicating the result of the request
 - A textual “reason phrase” further describing the status of the response
 - The Server header contains a banner indicating the web server software
being used
 - The Set-Cookie header issues the browser a further cooki
 - The Pragma header instructs the browser not to store the response in its
cache.
 - Almost all HTTP responses contain a message body following the blank
line after the headers
 
- `HTTP Methods` -- When you are attacking web applications, you will be dealing almost exclusively
with the most commonly used methods: GET and POST. The GET method is designed to retrieve resources. It can be used to send
parameters to the requested resource in the URL query string

 Because the POST method is designed for
performing actions, if a user clicks the browser’s Back button to return to a
page that was accessed using this method, the browser does not automatically
reissue the request. Instead, it warns the user of what it is about to do  This prevents users from unwittingly performing an action more
than once. For this reason, POST requests should always be used when an action
is being performed

 In addition to the GET and POST methods, the HTTP protocol supports numerous other methods that have been created for specifi c purposes.
 - HEAD functions in the same way as a GET request
 - TRACE is designed for diagnostic purposes.
 - OPTIONS asks the server to report the HTTP methods that are available for
a particular resource
 - PUT attempts to upload the specifi ed resource to the server

- `URLs` -- A uniform resource locator (URL) is a unique identifi er for a web resource through
which that resource can be retrieved. The format of most URLs is as follows:
 ```
 protocol://hostname[:port]/[path/]file[?param=value]
 ```
 You may encounter the term URI (or uniform resource identifi er)
being used instead of URL, but it is really only used in formal specifi cations
and by those who want to exhibit their pedantry.

- `REST` --

- `HTTP Headers` --

- `Cookies` --

- `Status Codes` --

- `HTTPS` --

- `HTTP Proxies` --

- `HTTP Authentication` --

### Web Functionality 

- `Server-Side Functionality ` --

- `Client-Side Functionality ` --

- `State and Sessions ` --

### Encoding Schemes 

- `URL Encoding` --

- `Unicode Encoding` --

- `HTML Encoding ` --

- `Base64 Encoding ` --

- `Hex Encoding ` --

- `Remoting and Serialization` --

### Next Steps 

<br>
<br>

---

<br>
<br>

# Chapter 4 Mapping the Application 

### Enumerating Content and Functionality 

- `Web Spidering` --

- `User-Directed Spidering ` --

- `Discovering Hidden Content ` --

- `Application Pages Versus ` --

- `Discovering Hidden Parameters` --

### Analyzing the Application

- `Identifying Entry Points for User Input ` --

- `Identifying Server-Side Technologies ` --

- `Identifying Server-Side Functionality ` --

- `Mapping the Attack Surface ` --

### Summary

<br>
<br>

---

<br>
<br>

# Chapter 5 Bypassing Client-Side Controls 

### Transmitting Data Via the Client

- Hidden Form Fields ` --

- `HTTP Cookies` --

- `URL Parameters ` --

- `The Referer Header ` --

- `Opaque Data` --

- `The ASP.NET ViewState ` --

### Capturing User Data: HTML Forms 

- `Length Limits ` --

- `Script-Based Validation` --

- `Disabled Elements` --
 
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


