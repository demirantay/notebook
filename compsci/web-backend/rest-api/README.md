# REST API

- Before we dive into rest api's lets first remember what are web services ?

### Web Services

- Web Services are client and server applications that communicate over the World Wide Web's (WWW) Hypertext Transfer Protocol (HTTP). Web Services can be looked as a code on demand. Just like we call functions and methods, web services can be looked upon as calling a function or method over the internet using some sort of protocols and some agreements.

  A web service is a function or method which we can call by sending an HTTP request to a URL, with arguments and the service   returns the result back as response.
  
  The biggest advantage of the web services is that it is platform independent. For example an .net program can talk to a java program and a java program can talk to a python program through web services without any problem. Therefore, a web service is a language independent way of communication
  
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
  
  HTTP makes use of the Uniform Resource Identifier (URI) to identify any given resource and establish a connection. HTTP request and response, use a generic message format of RFC 822 for transferring the data. The generic message of any HTTP request and response, consists of the following four items:
  - 1 - A start line
  - 2 - Zero or more `Headers`
  - 3 - Empty line indicating the end of the header fields
  - 4 - and, Optional message `Body`.
  
  HTTP header holds the metadata and information about the HTTP method, while the body contains the data that we want to send to the server.
  
- HTTP Methods/Verbs:(The most important part of a request is the HTTP Method (verbs). These methods tells the server what to do with the data received in the request. ) --
  - `GET` -- The GET method is used to get the information from the server. This is equivalent to the SELECT statement in SQL. There is no message body in the GET request as it is meant to only fetch the data from the server
  - `POST` -- This is used to send the data to the server. This can be students information, some XML file or some JPG file. The message body contains the data. POST requests are generally used to create but it can be used to update the existing data as well.
  - `PUT` -- This should be used when we have to replace/update/create the data, which is already present/not present on the server with the data that we pass in the message body.
  - `DELETE` -- This should be used to delete the data on the server.
  
  You must notice that, with every method, we have mentioned should be used, as we can only advice to follow the standards. Just saying, but DELETE can be used to create a new entry, but we must follow the standards to avoid any confusion.
  
  > There are many more HTTP methods however I cannot note all of them down here. Read the docs.
 

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
    - 1 - It can insert a new record of the student.
    - 2 - It can get the record of the student.
    - 3 - It can list all the courses which are available.
    - 4 - It can get the information of all the courses.
    - 5 - It can be used to enroll for a course by a particular student.
    - 6 - It can be used to get all the courses enrolled by any particular student.
    - 7 - It can be used to get all the students who have enrolled for any particular course.

  Now lets put the DB diagram of the registration app: The basic entities are:
    - Students Table: This is responsible for storing the data of all the students. Student ID will be the primary key.
    - Courses: This table will have the information of all the courses taught in the school. Course ID will be the primary key.
    - Registrations: This table will maintain the registration information of all the registrations. Student ID along with the Course ID will be the primary key for this table. and also their connnection.
    
- Now let's define the URI for our application's various services:
  ```
  /Myapp/students/
  ```
  This will give information about all the students.
  ```
  /Myapp/courses/ 
  ```
  This will give information about all the courses.
  ```
  /Myapp/registrations/
  ```
  This will give information about all the registrations data.
  ```
  /Myapp/students/1/registrations
  ```
  This will give information about the registration of student with roll no 1.

<br>
<br>

---

<br>
<br>

# Using HTTP Methods: CRUD Operations

- Now we will see how to use the HTTP methods to perform the basic crud operations in the registration app. Suppose we want to `GET` the data of the student with student id 10. The resource URI for this operation will be `/myApp/students/10`.

  Now how will the server identify that which request is for the GET operation and which request is for the DELETE operation for the same URI. The answer is, by checking the HTTP method parameter. When we talk about REST application, you do not name methods like, getStudents. You make a GET request for the /myApp/students/ URI. You will see what I am talking about in the future.
  
### Use Cases for our Registration Application

- Getting the Student/Course Information:
  ```
  GET   /myApp/students/      // This will give the list of all the students in the system.
  GET  /myApp/students/1     // This will give the student with the roll number 1.
  ```
  
- Deleting the Student/Course Information:
  ```
  DELETE /myApp/students/1      // This will delete the student record with the roll number 1.
  DELETE /myApp/couses/10      // This will delete the course with course id 10.
  ```
  
- Updating the Student/Course Information:
  ```
  PUT /myApp/students/1   //This will update the student record with the roll number 1.
  PUT /myApp/courses/10  //This will update the course record with course id 10.
  ```
  
- Inserting the Student/Course Information:
  ```
  POST /myApp/students/      //This is correct
  POST  /myApp/students/20    //This is incorrect because it should create something not update it
  ```
  
<br>
<br>

---

<br>
<br>

# REST API Response

- As the REST API's response is consumed by some application and not the browser, so we don't have to worry about styling it to make it look good. In case of API response, it can be simple `XML` or `JSON` or any other media type. There is a Media-Type attribute in the header which can be used in such cases and the response can be sent accordingly. We will learn how to do this in coming tutorials but for now lets concentrate on the design aspects of the REST API.

  If we talk about the Student record, in our Student-Courses Application, the response will be something like this, The Student class (Data Model/Object) will look something like this (using Java):
  ```java
  public class Student{
      private int rollno;
      private String firstName;
      private String LastName;
      private int age;
      private String contactNumber;
      ...
  }
  ```
  The XML response will be something like this:
  ```xml
  <Student>
      <rollno>10</rollno>
      <firstName>Amit</firstName >
      <lastName>Agarwal</lastName>
      <age>25</age>
  </Student>
  ```
  The JSON response will be something like this:
  ```js
  {
      "rollno":"10",
      "firstName":"Amit",
      "lastName":"Agarwal",
      "age":"25"
      "contactNumber":"98877271127"
  }
  ```
  
  As we have already discussed that same REST API can return both XML or JSON as response message, depending upon the Media-Type attribute in the HTTP request.
  
  The question here is, how will the client know, what type of response to expect from the API. This is again managed by the response headers. There is a Content Type attribute in the headers which informs about the type of response body format.
  
### Response(Status) Codes

- Till now, we have discussed about the situations where everything is good but this doesn't happen in the real world scenario . There can be many scenarios, like:
  - The server on which you have deployed the Rest API is down.
  - The client request is incorrect
  - The resource which the client is requesting doesn't exist.
  - Some error occured on the server side while processing the request.
  
  So the REST API must always return an appropriate status code to the client so that the client can know the actual issue and process accordingly.
  
- `1XX Codes`: Informational Codes
  - These are the acknowledgement responses, used to pass on information. This status code is not used commonly.
  - More on [1xx code statuses](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes#2xx_Success)

- `2XX Codes`: Success Codes
  - These are the success codes which means that the server has received the request from the client and processed it successfully.
  - 200 OK: This informs the client about the successful response.
  - 201 Created: This should be returned for POST requests, stating that the resource is created successfully on the server
  - 202 Accepted: This informs the client that the request has been successfully received, but the processing is not yet finished.
  - 204 No Content: This informs the client that the request has been successfully processed, but no content will be returned.
  - More on [2xx code statuses](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes#2xx_Success)

- `3XX Codes`: 
  - These codes are generally used in case of URL Redirection.
  - More on [3xx code statuses](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes#2xx_Success)

- `4XX Codes`: 
  - This class of status codes are returned if the client's request has error.
  - 400 Bad Request: There is something wrong in the request from the client, hence the server cannot or will not process it.
  - 401 Unauthorized: The client needs to authorize themselves to make this request.
  - 403 Forbidden: This status code is used when the client request is correct but the server refuses to process the request. 
  - 404 Not Found: The resource which the client is requesting for doesn't exist.
  - More on [4xx code statuses](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes#2xx_Success)
  
- `5XX Codes`: Server error
  - The 5XX status codes are when server fails to process the request and cannot send the correct response
  - 500 Internal Server Error: This is a generic status code returned when an unexpected condition is encountered on the server, while processing the request.
  - 503 Service Unavailable: When server is not available due to excessive load or may be down for maintainence,
