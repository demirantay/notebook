# Https

- First lets see what wikipedia says "The Hypertext Transfer Protocol (HTTP) is an application protocol for distributed, collaborative, and hypermedia information systems.[1] HTTP is the foundation of data communication for the World Wide Web.

- The definition of wikipedia has lots of fancy words luckily I found a explanation that explains like I'm five:
  > "HTTP is essentially two people talking, and luckily enough, in plain(ish) text.

  > HTTP comes down to a very simple conversation, one person (the client) makes a request, and based on that request the other person (the server) makes a response back.

  > For example if I want to see http://www.google.com/ my client (the web browser I'm using) makes an HTTP request to the www.google.com server that looks like this:

  > GET / HTTP/1.1

  > There is also some optional data passed (do I accept cookies, what browser I am, etc.), but the request is basically just the command above. It can broken down into the following format:

  > ACTION LOCATION HTTPVERSION

  > ACTION is what I want the server to do. In this case of our example we are saying GET, as in, GET me this file I'm asking for. There are also other verbs such as POST (submit data), PUT (similar to POST), DELETE (not widely supported), and OPTIONS (retrieves server options).

  > LOCATION is what data I want to work with. In the case of our example we say we want to work with / which means "home directory of the web site", since you can't really "see" directories, the server translates this to mean "the default page in the home directory of the website". In our example we said GET, so as part of the response, the server would return the text of the default page in the home directory of the web site.

  > HTTPVERSION is just a code to let the server know what version of HTTP I can communicate with. HTTP has different version with some different features, and this lets the server know which features I'm comfortable with. It's not really important.

  > Then the response comes back. It looks something like this:

  > HTTP/1.1 200 OK
    HEADERS
    RETURNDATA

  > The first line is broken down like so:

  > HTTPVERSION STATUSCODE STATUS

  > HTTPVERSION is just the server stating out of the box what HTTP version it's using to format this response.

  > STATUSCODE tells us what the result was. 200 means "I found it, hear ya go!" Here's a list of ther status codes.

  > STATUS is just a simple text version of STATUSCODE. So 200 is computer speak for "OK"

  > The HEADERS piece just feeds some data back to the browser for its use such as what language this is in, how the data might be encoded, etc. This does not get displayed to the user.

  > RETURNDATA is the actual HTML of the page itself.
  
  Lets see some real world examples of the explanation above:
  ```
  # client request
  GET /index.html HTTP/1.1
  Host: www.example.com
  ```
  And now lets see what a example server response would look like:
  ```
  HTTP/1.1 200 OK
  Date: Mon, 23 May 2005 22:36:23 GMT
  Content-Type: text/html; charset=UTF-8
  Content-Length: 138
  Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
  Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
  Connection: close

  <html>
  <head>
    <title>An Example Page</title>
  </head>
  <body>
    Hello World, this is a very simple HTML document.
  </body>
  </html>
  ```
  
- But ofcourse even though this explanation is very well written the reailty is that http has a LOT more to offer and learn.
 The reason http was created is that the packages that wandered through the internet on the early days were not always safe so engineers needed a safety protocol to filter out the dangerous packages.
 
 
 
 ## Http Session & Authentication
 
 A http session is a sequence of network - request-response transactions and there are many ways to secure the session with authentication schemes there are many ways to do it I will take notes on this subject later on.
 
 ## Request Methods
 
 As it is explained above the client `request` needs a method to manipulate the data it wants from the server. There are tons of methods and a list of it in wikipedia but the following are the most commonly used ones:
 
 - `GET`: this method as it is described in it is name it simply gets the data from the server.
 - `HEAD`: The HEAD method asks for a response identical to that of a GET request, but without the response body. This is useful for retrieving meta-information written in response headers, without having to transport the entire content.
 - `POST`: a block of data that is the result of submitting a web form to a data-handling process; or an item to add to a database.
 - `PUT`: haha I dont get it ...
 - `DELETE`: The DELETE method deletes the specified resource.
 - `TRACE`: The TRACE method echoes the received request so that a client can see what (if any) changes or additions have been made by intermediate servers. most of the time used for tracing errors
 - `OPTIONS`: The OPTIONS method returns the HTTP methods that the server supports for the specified URL. This can be used to check the functionality of a web server by requesting '*' instead of a specific resource.
 - `CONNECT`: The CONNECT method converts the request connection to a transparent TCP/IP tunnel, usually to facilitate SSL-encrypted communication (HTTPS) through an unencrypted HTTP proxy.
 - `PATCH`: The PATCH method applies partial modifications to a resource.
 
 There are a lot more request methods I couldnt write them all.
 
 Methods such as POST, PUT, DELETE and PATCH are intended for actions that may cause side effects either on the server, you may do something that you did not intednt or some malicious hacker can cross side script your site with the forms and steal infromation from your server. There are csrf_token encryptions that are provided by web frameworks but if you really want to be sure to secure your methods you need to learn a lot more about security on web.
 
 ## Status Codes

In HTTP/1.0 and since, the first line of the HTTP response is called the status line and includes a numeric status code (such as "404") and a textual reason phrase (such as "Not Found"). HTTP status code is primarily divided into five groups for better explanation of request and responses between client and server as named:

 - Informational : `1XX`
 - Succesfull: `2XX`
 - Redirection: `3XX`
 - Client Error: `4XX`
 - Server Error: `5XX`
 
 

