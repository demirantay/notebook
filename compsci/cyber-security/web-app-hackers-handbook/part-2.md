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

- `REST` -- Representational state transfer (REST) is a style of architecture for distributed
systems in which requests and responses contain representations of the current
state of the system’s resources. The core technologies employed in the World
Wide Web, including the HTTP protocol and the format of URLs, conform to
the REST architectural style.

  Although URLs containing parameters within the query string do themselves
conform to REST constraints, the term “REST-style URL” is often used to signify
a URL that contains its parameters within the URL fi le path, rather than the
query string. For example, the following URL containing a query string:
  ```
  http://ww38.wahh-app.com/search?make=ford&model=pinto
  ```
  corresponds to the following URL containing “REST-style” parameters:
  ```
  http://ww38.wahh-app.com/search/ford/pinto
  ```

- `Cookies` -- Cookies are a key part of the HTTP protocol that most web applications rely
on. Frequently they can be used as a vehicle for exploiting vulnerabilities. In addition to the cookie’s actual value, the Set-Cookie header can include
any of the following optional attributes, which can be used to control how the
browser handles the cookie:
  - expires -- sets a date until which the cookie is valid. 
  - domain -- specifi es the domain for which the cookie is valid
  - path -- specifi es the URL path for which the cookie is valid
  - secure —- If this attribute is set, the cookie will be submitted only in HTTPS
requests.
  - HttpOnly — If this attribute is set, the cookie cannot be directly accessed
via client-side JavaScript.

  Each of these cookie attributes can impact the application’s security

- `Status Codes` -- Each HTTP response message must contain a status code in its fi rst line, indicating the result of the request. The status codes fall into fi ve groups, according
to the code’s fi rst digit:
  - 1xx — Informational.
  - 2xx — The request was successful.
  - 3xx — The client is redirected to a different resource
  - 4xx — The request contains an client side error
  - 5xx — The request, response contains a server side error

- `HTTPS` -- The HTTP protocol uses plain TCP as its transport mechanism, which is unencrypted and therefore can be intercepted by an attacker who is suitably positioned on the network. HTTPS is essentially the same application-layer protocol
as HTTP but is tunneled over the secure transport mechanism, Secure Sockets
Layer (SSL). This protects the privacy and integrity of data passing over the
network SSL has strictly been superseded by transport layer security (TLS), but
the latter usually still is referred to using the older name.

- `HTTP Proxies` -- An HTTP proxy is a server that mediates access between the client browser and
the destination web server. When a browser has been confi gured to use a proxy server, it makes all its requests to that server. The proxy relays the requests to
the relevant web servers and forwards their responses back to the browser. 

  By some measure, the most useful item in your toolkit when attacking web
applications is a specialized kind of proxy server that sits between your browser
and the target website and allows you to intercept and modify all requests and
responses, even those using HTTPS

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


