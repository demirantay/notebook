# Fetching data from the server

- Another very common task in modern websites and applications is retrieving individual data items from the server to update sections of a webpage without having to load an entire new page. This seemingly small detail has had a huge impact on the performance and behavior of sites, so in this article, we'll explain the concept and look at technologies that make it possible, such as XMLHttpRequest and the Fetch API.

<br>
<br>

# What is the problem here?

- Originally page loading on the web was simple — you'd send a request for a website to a server, and as long as nothing went wrong, the assets that made the web page would be downloaded and displayed on your computer

  The trouble with this model is that whenever you want to update any part of the page, for example, to display a new set of products or load a new page, you've got to load the entire page again. This is extremely wasteful and results in a poor user experience, especially as pages get larger and more complex.

### Enter Ajax

- This led to the creation of technologies that allow web pages to request small chunks of data (such as HTML, XML, JSON, or plain text) and display them only when needed, helping to solve the problem described above

  This is achieved by using APIs like `XMLHttpRequest` or — more recently — the Fetch API. These technologies allow web pages to directly handle making HTTP requests for specific resources available on a server and formatting the resulting data as needed before it is displayed.

<br>
<br>

---

<br>
<br>

# A basic Ajax request

### XMLHttpRequest

### Serving your example from a server

### Fetch

### Aside on promises

### Which mechanism should you use?


<br>
<br>



