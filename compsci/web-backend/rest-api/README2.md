# HATEOAS - Important Concept For REST API

- HATEOAS stands for Hypertext As The Engine Of Application State. Now what does it mean and why this is important. It's a well agreed belief that a good written software is the one which has a good documentation. But there is little deviation in this belief when it comes to the Rest API. A Rest API is said to be perfect if it doesn't need any documentation at all. It should be so crystal clear to the developer who is consuming the service that he/she should not even refer to the documentation

  Now the question is how to achieve this? The simple answer is providing as much related links as possible about the resource in the response. Lets take the case of our registration application.
  
  The typical response of the students resource /myApp/students/1:
  ```xml
  <Student>
      <rollno>10</rollno>
      <firstName>Amit</firstName >
      <lastName>Agarwal</lastName>
      <age>25</age>
  </Student>
  ```
  What if we give the additional information to the client, about how to check all the courses that this studen
  ```xml
  <Student>
      <rollno>10</rollno>
      <firstName>Amit</firstName >
      <lastName>Agarwal</lastName>
      <age>25</age>
      <link rel = “courses” href =”/myApp/students/1/registrations”>
  </Student>
  ```
  Now this will be very useful to the client as he will directly get the courses enrolled resource URI information from the students response itself. This is a HATEAOS concept.

  We can also include more options like, URI to Update student information, Delete the student data etc.
  
  So HATEOAS is a concept to provide links of the related sub resources to the resource which is requested by the client so that is becomes easier for the client to make further calls to the REST API. A GOOD REST API DOES NOT NEED ANY DOCUMENTATION

<br>
<br>

---

<br>
<br>

# Richardson Maturity Model 

- Since REST is just a specification or we can say a way of implementing web services, with no hard coded documentation. So how we know the API which we have developed is fully RESTful. For this, there is Richardson Maturity Model, which is usually referred to analyse how RESTful the API is.

  The Richardson Model is a way to grade your API according to the constraints of the REST. The more the API follows these constraints the more RESTful the API is.
  
### Level 0

- This will use only one URI to expose the whole API and generally uses only one HTTP method. If we take example of our registration API we see that that every resource has its own URI. The student resource has a different URI

  SOAP based web services are the example of this level. This level of API doesn't leverage the full concepts of the HTTP specification. For example: Every request will be POST request, so if someone wants to delete a student record they will have send the action also in the request. 
  
### Level 1

- In this level every resource has its own URI. This level uses multiple URI where every URI is an entry point to a specific resource. Still this level uses only POST method for operation

### Level 2

- - This level says that your API should use protocol properties as much as possible. You must not use single POST method for all the operations, but make use of GET when you are requesting a resource, use a DELETE method when you want to delete a resource.

### Level 3

- This level suggests to use the concept of HATEOAS. The response should contain the logical links of all the resources which the current resource is related to.

   For Example: In case of when the client request for the student information with the roll number 1, then in the response along with the response of the student, a link of all the URI of all the courses which that student has registered should also be sent.

  If an API is at the level 3 this will be known as fully RESTful. This Richardson Model should be used while designing the REST API to make sure the web services are fully RESTful.
  
  <br>
  <br>
  
  ---
  
  <br>
  <br>
  <br>
  
  This is where i left off: https://www.studytonight.com/rest-web-service/tools-and-technologies
