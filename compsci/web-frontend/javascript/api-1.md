# JSON API development with JavaScript

- For quick code snippet reference:
  ```js
 
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

### They have recognizable entry points

### They use events to handle changes in state

### They have additional security mechanisms where appropriate


---

[part 2]()


