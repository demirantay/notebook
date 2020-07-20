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

### Web Functionality 

- In addition to the core communications protocol used to send messages between
client and server, web applications employ numerous technologies to deliver
their functionality

- `State and Sessions ` -- The technologies described so far enable the server and client components of
a web application to exchange and process data in numerous ways. To implement most kinds of useful functionality, however, applications need to track the
state of each user’s interaction with the application across multiple requests

### Encoding Schemes 

- Web applications employ several different encoding schemes for their data. Both
the HTTP protocol and the HTML language are historically text-based, and different encoding schemes have been devised to ensure that these mechanisms
can safely handle unusual characters and binary data  When you are attacking
a web application, you will frequently need to encode data using a relevant scheme to ensure that it is handled in the way you intend

- `URL Encoding` -- URLs are permitted to contain only the printable characters in the US-ASCII
character set. The URL-encoding scheme is used to encode any problematic characters
within the extended ASCII character set so that they can be safely transported
over HTTP.

- `Unicode Encoding` -- UTF-8 is a variable-length encoding standard that employs one or more bytes
to express each character. For transmission over HTTP, the UTF-8-encoded form
of a multibyte character simply uses each byte expressed in hexadecimal and
preceded by the % prefi x. For the purpose of attacking web applications, Unicode encoding is primarily
of interest because it can sometimes be used to defeat input validation mechanisms

- `HTML Encoding ` -- HTML encoding is used to represent problematic characters so that they can be
safely incorporated into an HTML document.  When you are attacking a web application, your main interest in HTML
encoding is likely to be when probing for cross-site scripting vulnerabilities. If
an application returns user input unmodifi ed within its responses, it is probably vulnerable, whereas if dangerous characters are HTML-encoded, it may
be safe

- `Base64 Encoding ` -- Base64 encoding allows any binary data to be safely represented using only
printable ASCII characters. It is commonly used to encode e-mail attachments
for safe transmission over SMTP. It is also used to encode user credentials in
basic HTTP authentication

- `Hex Encoding ` -- Many applications use straightforward hexadecimal encoding when transmitting binary data, using ASCII characters to represent the hexadecimal block.  hex-encoded data is usually easy to spot. You should always
attempt to decode any such data that the server sends to the client to understand
its function

### Next Steps 

- So far, we have described the current state of web application (in)security, examined the core mechanisms by which web applications can defend themselves,
and taken a brief look at the key technologies employed in today’s applications.
With this groundwork in place, we are now in a position to start looking at the
actual practicalities of attacking web applications

   In any attack, your fi rst task is to map the target application’s content and
functionality to establish how it functions, how it attempts to defend itself, and
what technologies it uses  The next chapter examines this mapping process
in detail and shows how you can use it to obtain a deep understanding of an
application’s attack surface

<br>
<br>

---

<br>
<br>

# Chapter 4 Mapping the Application 

- The fi rst step in the process of attacking an application is gathering and examining some key information about it to gain a better understanding of what you
are up against The mapping exercise begins by enumerating the application’s content and
functionality in order to understand what the application does and how it
behaves.

   This will enable you to identify the key attack surface that the application
exposes and hence the most interesting areas where you should target subsequent probing to fi nd exploitable vulnerabilities

### Enumerating Content and Functionality 

- In a typical application, the majority of the content and functionality can be
identifi ed via manual browsing. The basic approach is to walk through the
application starting from the main initial page, following every link, and navigating through all multistage functions (such as user registration or password
resetting)

- `Web Spidering` -- Various tools can perform automated spidering of websites. These tools work
by requesting a web page, parsing it for links to other content, requesting these
links, and continuing recursively until no new content is discovered.

   Numerous free tools are available that do a decent job of enumerating application content and functionality, including Burp Suite, WebScarab, Zed Attack
Proxy, and CAT

   > Many web servers contain a fi le named robots.txt in the web root that
contains a list of URLs that the site does not want web spiders to visit or search
engines to index. Sometimes, this fi le contains references to sensitive functionality, which you are certainly interested in spidering. Some spidering tools
designed for attacking web applications check for the robots.txt fi le and use
all URLs within it as seeds in the spidering process. In this case, the robots.txt
fi le may be counterproductive to the security of the web application.

   Although it can often be effective, this kind of fully automated approach to
content enumeration has some signifi cant limitations:
   - Unusual navigation mechanisms (such as menus dynamically created
and handled using complicated JavaScript code) often are not handled
properly by these tools, so they may miss whole areas of an application.
   - Multistage functionality often implements fi ne-grained input validation
checks, which do not accept the values that may be submitted by an automated tool. For example, a user registration form may contain fi elds for
name, e-mail address, telephone number, and zip code. An automated Multistage functionality often implements fi ne-grained input validation
checks, which do not accept the values that may be submitted by an automated tool. For example, a user registration form may contain fi elds for
name, e-mail address, telephone number, and zip code. An automated

- `User-Directed Spidering ` -- This is a more sophisticated and controlled technique that is usually preferable to automated spidering. Here, the user walks through the application in
the normal way using a standard browser, attempting to navigate through all
the application’s functionality. As he does so, the resulting traffi c is passed
through a tool combining an intercepting proxy and spider, which monitors
all requests and responses. The tool builds a map of the application, incorporating all the URLs visited by the browser. It also parses all the application’s
responses in the same way as a normal application-aware spider and updates
the site map with the content and functionality it discovers. The spiders
within Burp Suite and WebScarab can be used in this way Where the application uses unusual or complex mechanisms for navigation,
the user can follow these using a browser in the normal way. Any functions
and content accessed by the user are processed by the proxy/spider tool. This gets a better picture.

- `Hack Steps` -- 
   - 1 - Configure your browser to use either Burp or WebScarab as a local proxy
   - 2 - Browse the entire application normally, attempting to visit every link/URL
you discover, submitting every form, and proceeding through all multistep functions to completion. Try browsing with JavaScript enabled and
disabled, and with cookies enabled and disabled. Many applications can
handle various browser configurations, and you may reach different content and code paths within the application
   - 3 - Review the site map generated by the proxy/spider tool, and identify
any application content or functions that you did not browse manually.
Establish how the spider enumerated each item
   - 4 - Optionally, tell the tool to actively spider the site using all of the already
enumerated content as a starting point. To do this, first identify any URLs
that are dangerous or likely to break the application session, and configure the spider to exclude these from its scope. Run the spider and review
the results for any additional content it discovers

- `Discovering Hidden Content ` -- It is common for applications to contain content and functionality that is not
directly linked to or reachable from the main visible content. A common example
is functionality that has been implemented for testing or debugging purposes
and has never been removed. Another example arises when the application presents different functionality
to different categories of users (for example, anonymous users, authenticated
regular users, and administrators). Users at one privilege level who perform
exhaustive spidering of the application may miss functionality that is visible to
users at other levels

  Effective discovery of hidden content requires a combination of automated and
manual techniques and often relies on a degree of luck.

   Inference from Published Content -- Most applications employ some kind of naming scheme for their content and
functionality. By inferring from the resources already identifi ed within the
application, it is possible to fi ne-tune your automated enumeration exercise to
increase the likelihood of discovering further hidden content.

   Review all client-side code such as HTML and JavaScript to identify any
clues about hidden server-side content. These may include HTML comments related to protected or unlinked functions, HTML forms with disabled SUBMIT elements, and the like. Often, comments are automatically
generated by the software that has been used to generate web content,
or by the platform on which the application is running. References to
items such as server-side include files are of particular interest. These
files may actually be publicly downloadable and may contain highly sensitive information such as database connection strings and passwords. In
other cases, developers’ comments may contain all kinds of useful tidbits,
such as database names, references to back-end components, SQL query
strings, and so on. 

   Search for temporary files that may have been created inadvertently by
developer tools and file editors. Examples include the .DS_Store file,
which contains a directory index under OS X, file.php~1, which is a
temporary file created when file.php is edited, and the .tmp file extension that is used by numerous software tools.

   E You can use the Content Discovery feature of Burp Suite Pro to automate most of the tasks described so far. After you have manually mapped an
application’s visible content using your browser, you can select one or more
branches of Burp’s site map and initiate a content discovery session on those
branches with hidden links, ... etc..

- `Discovering Hidden Parameters` -- A variation on the situation where an application uses request parameters to specify which function should be performed arises where other parameters are used to control the application’s logic in significant ways. For example, an application may behave differently if the parameter debug=true is added to the query string of any URL. It might turn off certain input validation checks, allow the user to bypass certain access controls, or display verbose debug informa- tion in its response

   Depending on the time available, target a number of different pages or functions for hidden parameter discovery. Choose functions where it is most likely that developers have implemented debug logic, such as login, search, and file uploading and downloading.

### Analyzing the Application

- Enumerating as much of the application’s content as possible is only one ele- ment of the mapping process. Equally important is the task of analyzing the application’s functionality, behavior, and technologies employed to identify the key attack surfaces it exposes and to begin formulating an approach to probing the application for exploitable vulnerabilities.

   The core security mechanisms and how they function — in particular, management of session state, access controls, and authentication mecha- nisms and supporting logic (user registration, password change, and account recovery

- `Identifying Entry Points for User Input ` --
   - URL File Paths -- The parts of the URL that precede the query string are often overlooked as entry points, since they are assumed to be simply the names of directories and files on the server file system. However, in applications that use REST-style URLs, the parts of the URL that precede the query string can in fact function as data parameters and are just as important as entry points for user input as the query string itself.
   - HTTP Headers -- Many applications perform custom logging functions and may log the contents of HTTP headers such as Referer and User-Agent. These headers should always be considered as possible entry points for input-based attacks.
   -  and much more ... etc.

- `Identifying Server-Side Technologies ` -- Normally it is possible to fingerprint the technologies employed on the server via various clues and indicators. for example Many web servers disclose fine-grained version information, both about the web server software itself and about other components that have been installed
   - File Extensions -- File extensions used within URLs often disclose the platform or programming language used to implement the relevant functionality. For example: aspx — Microsoft ASP.NET, php — The PHP languag ... etc.
   - Directory Names -- It is common to encounter subdirectory names that indicate the presence of an associated technology. For example: servlet — Java servlets, pls — Oracle Application Server PL/SQL gateway
   - Session Tokens -- JSESSIONID — The Java Platform, PHPSESSID — PHP

- `Identifying Server-Side Functionality ` -- It is often possible to infer a great deal about server-side functionality and struc- ture, or at least make an educated guess, by observing clues that the application discloses to the client.

   Consider the following URL, which is used to access a search function:
   ```txt
   https://wahh-app.com/calendar.jsp?name=new%20applicants&isExpired=
   0&startDate=22%2F09%2F2010&endDate=22%2F03%2F2011&OrderBy=name
   ```
   As you have seen, the .jsp file extension indicates that Java Server Pages are in use. You may guess that a search function will retrieve its information from either an indexing system or a database. The presence of the OrderBy parameter suggests that a back-end database is being used and that the value you submit maybeusedastheORDER BYclauseofaSQLquery.Thisparametermaywell be vulnerable to SQL injection ... etc.
   
   - Isolating Unique Application Behavior -- Sometimes the situation is the opposite of that just described. In many well- secured or mature applications, a consistent framework is employed that pre- vents numerous types of attacks, such as cross-site scripting, SQL injection, and unauthorized access. In these cases, the most fruitful areas for hunting vulnerabilities generally are the portions of the application that have been added retrospectively, or “bolted on,” and hence are not handled by the application’s general security framework.

- `Mapping the Attack Surface ` -- The final stage of the mapping process is to identify the various attack surfaces exposed by the application and the potential vulnerabilities that are commonly associated with each one:
   - 1 - Client-side validation — Checks may not be replicated on the server
   - 2 - Database interaction — SQL injection
   - 3 - File uploading and downloading — Path traversal vulnerabilities, stored cross-site scripting
   - 4 - Display of user-supplied data — Cross-site scripting
   - 5 - Dynamic redirects — Redirection and header injection attacks
   - 6 - Social networking features — username enumeration, stored cross-site scripting
   - 7 - Login — Username enumeration, weak passwords, ability to use brute force
   - 8 - Multistage login — Logic flaws
   - 9 - Session state — Predictable tokens, insecure handling of tokens
   - 10 - Access controls — Horizontal and vertical privilege escalation
   - 11 - User impersonation functions — Privilege escalation
   - 12 - Use of cleartext communications — Session hijacking, capture of creden- tials and other sensitive data
   - 13 - Off-site links — Leakage of query string parameters in the Referer header
   - 14 - Interfaces to external systems — Shortcuts in the handling of sessions and/or access controls
   - 15 - Error messages — Information leakage
   - 16 - E-mail interaction — E-mail and/or command injection
   - 17 - Native code components or interaction — Buffer overflows
   - 18 - Use of third-party application components — Known vulnerabilities
   - 19 - Identifiable web server software — Common configuration weaknesses, known software bug
   
### Summary

- Mapping the application is a key prerequisite to attacking it. It may be tempting to dive in and start probing for bugs, but taking time to gain a sound under- standing of the application’s functionality, technologies, and attack surface will pay dividends down the line.

   As with almost all of web application hacking, the most effective approach is to use manual techniques supplemented where appropriate by controlled automation. No fully automated tool can carry out a thorough mapping of the application in a safe way. The core methodology we have outlined involves the following:
  - 1 - Manual browsing and user-directed spidering to enumerate the applica- tion’s visible content and functionality
  - 2 - Use of brute force combined with human inference and intuition to dis- cover as much hidden content as possible
  - 3 - An intelligent analysis of the application to identify its key functionality, behavior, security mechanisms, and technologies
  - 4 - An assessment of the application’s attack surface, highlighting the most promising functions and behavior for more focused probing into exploit- able vulnerabilities




