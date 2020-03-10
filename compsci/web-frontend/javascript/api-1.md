# JSON API development with JavaScript

- For quick code snippet reference:
  ```js
  let requestURL = 'https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json';
  let request = new XMLHttpRequest();
  request.open('GET', requestURL);
  request.responseType = 'json';
  request.send();

  request.onload = function() {
    const superHeroes = request.response;
    populateHeader(superHeroes);
    showHeroes(superHeroes);
  }
  ```
  Also you can use Fetch API:
  ```js
  fetch(url).then(function(result) {
    return result.json();
  }).then(function(json) {
    displayResults(json);
  });
  ```
  
---
---

# What are APIs?

- Application Programming Interfaces (APIs) are constructs made available in programming languages to allow developers to create complex functionality more easily. They abstract more complex code away from you, providing some easier syntax to use in its place.

  As a real-world example, think about the electricity supply in your house, apartment, or other dwellings. If you want to use an appliance in your house, you simply plug it into a plug socket and it works. You don't try to wire it directly into the power supply — to do so would be really inefficient and, if you are not an electrician, difficult and dangerous to attempt.
  
  In the same way, if you want to say, program some 3D graphics, it is a lot easier to do it using an API written in a higher-level language such as JavaScript or Python, rather than try to directly write low level code (say C or C++) that directly controls the computer's GPU or other graphics functions.
  
### APIs in client-side JavaScript

- Client-side JavaScript, in particular, has many APIs available to it — these are not part of the JavaScript language itself. They generally fall into two categories:
  - 1 - `Browser APIs` --  are built into your web browser and are able to expose data from the browser and surrounding computer environment and do useful complex things with it. For example, the Web Audio API provides JavaScript constructs for manipulating audio in the browser — taking an audio track, altering its volume, applying effects to it, etc
  - 2 - `Third-party APIs` -- are not built into the browser by default, and you generally have to retrieve their code and information from somewhere on the Web. For example, the Twitter API

<br>
<br>

---

<br>
<br>

# What can APIs do?

### Common browser APIs

- In particular, the most common categories of browser APIs you'll use (and which we'll cover in this module in greater detail) are:
  - `APIs for manipulating documents ` -- loaded into the browser. The most obvious example is the DOM (Document Object Model) API, which allows you to manipulate HTML and CSS 
  - `APIs that fetch data from the server` --  to update small sections of a webpage on their own are very commonly used. This seemingly small detail has had a huge impact on the performance and behaviour of sites
  - `APIs for drawing and manipulating graphics` -- are now widely supported in browsers — the most popular ones are Canvas and WebGL, which allow you to programmatically update the pixel data contained in an HTML <canvas> element to create 2D and 3D scenes
  - `Audio and Video APIs` -- like HTMLMediaElement, the Web Audio API, and WebRTC allow you to do really interesting things with multimedia such as creating custom UI controls for playing audio and video, displaying text tracks like captions and subtitles along with your videos, grabbing video from your web camera to be manipulated via a canvas 
  - `Device APIs` -- are basically APIs for manipulating and retrieving data from modern device hardware in a way that is useful for web apps
  - `Client-side storage APIs` -- are becoming a lot more widespread in web browsers — the ability to store data on the client-side is very useful if you want to create an app that will save its state between page loads 

### Common third-party APIs

- Third-party APIs come in a large variety; some of the more popular ones that you are likely to make use of sooner or later are:
  - The Twitter API
  - Map APIs like Mapquest and the Google Maps API 
  - The Facebook suite of APIs enables you to use various parts of the Facebook ecosystem to benefit your app
  - The Telegram APIs allows you to embed content from Telegram channels on your website
  - The YouTube API, which allows you to embed YouTube videos on your site
  - The Pinterest API 
  - The Twilio API, which provides a framework for building voice and video call functionality into your app
  - The Mastodon API
  
  > There are much more

<br>
<br>

---

<br>
<br>

# How do APIs work?

- Different JavaScript APIs work in slightly different ways, but generally, they have common features and similar themes to how they work.

### They are based on objects

- Your code interacts with APIs using one or more JavaScript objects, which serve as containers for the data the API uses (contained in object properties), and the functionality the API makes available (contained in object methods).

  Let's return to the example of the Web Audio API — this is a fairly complex API, which consists of a number of objects. The most obvious ones are:
  - `AudioContext`, which represents an audio graph that can be used to manipulate audio playing inside the browser
  - `MediaElementAudioSourceNode`, which represents an <audio> element containing sound you want to play
  - `AudioDestinationNode`, which represents the destination of the audi

### They have recognizable entry points

- When using an API, you should make sure you know where the entry point is for the API. In The Web Audio API, this is pretty simple — it is the `AudioContext` object, which needs to be used to do any audio manipulation whatsoever.

  The Document Object Model (DOM) API also has a simple entry point — its features tend to be found hanging off the `Document `object, or an instance of an HTML element that you want to affect in some way.
  
  The Canvas API also relies on getting a context object to use to manipulate things, although in this case, it's a graphical context rather than an audio context. Its context object is created by getting a reference to the `<canvas>` element you want to draw on, and then calling its `HTMLCanvasElement.getContext()` method:

### They use events to handle changes in state

- Not every api uses event but nearly all of them is handled through either js events or their own provided event objects. To provide another example, instances of the `XMLHttpRequest` object (each one represents an HTTP request to the server to retrieve a new resource of some kind) has a number of events available on them, for example, the `load` event is fired when a response has been successfully returned containing the requested resource, and it is now available.

  The following code provides a simple example of how this would be used:
  ```js
  let requestURL = 'https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json';
  let request = new XMLHttpRequest();
  request.open('GET', requestURL);
  request.responseType = 'json';
  request.send();

  request.onload = function() {
    const superHeroes = request.response;
    populateHeader(superHeroes);
    showHeroes(superHeroes);
  }
  ```
  The first five lines specify the location of the resource we want to fetch, create a new instance of a request object using the `XMLHttpRequest()` constructor, open an HTTP GET request to retrieve the specified resource, specify that the response should be sent in JSON format, then send the request.
  
  The `onload` handler function then specifies what we do with the response. We know the response will be successfully returned and available after the load event has fired (unless an error occurred)

### They have additional security mechanisms where appropriate

- WebAPI features are subject to the same security considerations as JavaScript and other web technologies (for example same-origin policy), but they sometimes have additional security mechanisms in place. For example, some of the more modern WebAPIs will only work on pages served over HTTPS due to them transmitting potentially sensitive data (examples include Service Workers and Push).

  In addition, some WebAPIs request permission to be enabled from the user once calls to them are made in your code. As an example, the Notifications API asks for permission using a pop-up dialogue box:

---

[part 2]()


