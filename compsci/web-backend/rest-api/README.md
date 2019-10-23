# REST API

- Before we dive into rest api's lets first remember what are web services ?

### Web Services

- Web Services are client and server applications that communicate over the World Wide Web's (WWW) Hypertext Transfer Protocol (HTTP). Web Services can be looked as a code on demand. Just like we call functions and methods, web services can be looked upon as calling a function or method over the internet using some sort of protocols and some agreements.

  A web service is a function or method which we can call by sending an HTTP request to a URL, with arguments and the service   returns the result back as response.
  
  The biggest advantage of the web services is that it is platform independent. For example an .net program can talk to a java program and a java program can talk to a python program through web services without any problem.
  
- Now let us look at one of the most common use case where web services are being used extensively. Consider the figure below, suppose I have made a new cool application but I do not want to maintain the data of the users, who login to my application, but we want only authenticated users to use the application. So what should we do? One option is, we can use the web services exposed by some other third party application, to authenticate our incoming users. You must have seen this in many applications, in form of - Sign up using Facebook, Google or other third party apps. 

  Therefore, we do not have to maintain any data of the users to authenticate, rather we can now fully concentrate on the content of our application. The flow of the authentication process will be like this:
  
  - 1 - User logs into our Application.
  - 2 - We show them two options - either sign in using Facebook or Google.
  - 3 - Enter the Username and Password.
  - 4 - The application will now pass the Username and Password to Google or Facebook server using http request.
  - 5 - The request/response can be in any format. It could be a json/xml or any other media type.
  - 6 - Now if the request is ok, Google or Facebook server will send us the response and accordingly we will authenticate our users to login into the application.

  
<br>
<br>

---

<br>
<br>

# Types of Web Services: SOAP and REST

- There are two types of web services:
  - SOAP Web Services
  - REST Web Services

### SOAP Web Services

- SOAP is an XML-based protocol. The biggest advantage of using the SOAP Web Service is its own security. SOAP stands for `Simple Object Access Protocol`. The messages are generally in XML format.
  
  In simple words, SOAP is a technique to send an XML request over the Internet using HTTP protocol (hitting a URL), and in return getting an XML response.
  
- SOAP was intended to be a way to do remote procedure calls to remote objects by sending XML over HTTP. If we look at the current software industry, you will find that, SOAP is being used in the enterprise applications, generally in the legacy code. Today the world is moving fast towards the RESTful Web Services.

### REST Web Services

- The REST stands for Representational State Transfer. REST is not a set of standards or rules, rather it is a style of software architecture. The applications which follow this architecture are referred to as RESTful.

- Unlike SOAP which targets the actions, REST concerns more on the resources. REST locates the resources by using URL and it depends on the type of transport protocol(with HTTP - GET, POST, PUT, DELETE,...) for the actions to be performed on the resources
  
  For Example: in a RESTful architecture, this URL `http://{serverAddress}/students/studentRollno/07` can be used to:
    - To get student information by sending a REST call of GET type, and the service will return information of student with roll no as `07`
    - The same service can also be used to update the student data, by sending in the new values as Form data in a __POST__ request

### Difference between REST and SOAP

| REST | SOAP |
| -- | -- |
|REST can use SOAP because it is a concept and can use any protocol like HTTP, SOAP etc.|SOAP cannot use REST because it itself is a protocol.|
|REST does not define too much standards. REST is cool! | SOAP defines standards to be strictly followed. |
|REST inherits security measures from the underlying transport protocols.| SOAP defines its own security layer.|
|REST accepts different data formats like, Plain Text, HTML, JSON, XML etc.| SOAP only works with XML format. |

<br>
<br>

---

<br>
<br>

# Understanding HTTP: The Backbone of REST

- To understand the REST architecture, it is very important that we understand the HTTP clearly because all the http protocols are used while building a REST API.
  
  HTTP is all over the internet. Every time when we hit a URL in our browser, an HTTP request is sent to the webserver and we receive the HTML content in response. An important thing to note here is that, while the website is usually for the human consumption the REST Api is usually for application(program) consumption. 
  
  Therefore, while requesting the data from a website, the data should be in a browser readable format, which is HTML, while in case of the REST API, response can be anything like XML/JSON or any other media type.
  
- One very important point about REST is, that it is not connected to web, and will return no response when tried to access via a browser, although it is based on HTTP.

### Basic Features of the HTTP

- As we have already learnt HTTP is a protocol which allows us to send files back and forth on the web, which involves a client and a server. HTTP is text based, which makes it easier to monitor. The basic features of HTTP are:
  - HTTP is connectionless.
  - HTTP is media independent, which means any type of data can be sent through the http.
  - HTTP is stateless, neither the server nor the client keeps a track of the last request.

<br>
<br>

---

<br>
<br>

# Designing the REST API: Registration Application

- Now whenever we talk about the REST Web services, there are two terms that should always come to your mind - first is, either you are exposing the web service (acting as server) or you will be consuming the web service (acting as client).

  Exposing a web service means that you have made the web service and has deployed it on your server and this can be consumed by any client by using the URL to our service.
  
  Let us make a simple REST API and also understand the design aspects of making the REST API. In this tutorial we will build a simple Registration API. It will have students, classes and the information of students enrolled in different classes.
  
  So first, let's summarise what this registration app can do:
    - 1 -  
    - 2 -
    - 3 -
    - 4 -
    - 5 -
    - 6 -
    - 7 -


<br>
<br>

---

<br>
<br>

# Using HTTP Methods 
