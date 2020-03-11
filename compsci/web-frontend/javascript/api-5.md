> I am skipping graphics and audio media API's because they are too big to note down in a single summary note file.

<br>

# Client-side storage

- Modern web browsers support a number of ways for web sites to store data on the user's computer — with the user's permission — then retrieve it when necessary. This lets you persist data for long-term storage, save sites or documents for offline use, retain user-specific settings for your site, and mor

- Elsewhere in the MDN learning area we talked about the difference between static sites and dynamic sites. Most major modern web sites are dynamic — they store data on the server using some kind of database (server-side storage), then run server-side code to retrieve needed data, insert it into static page templates, and serve the resulting HTML to the client to be displayed by the user's browser.

  Client-side storage works on similar principles, but has different uses. It consists of JavaScript APIs that allow you to store data on the client (i.e. on the user's machine) and then retrieve it when needed. This has many distinct uses, such as:
  - Personalizing site preferences (e.g. showing a user's choice of custom widgets, color scheme, or font size).
  - Persisting previous site activity (e.g. storing the contents of a shopping cart from a previous session, remembering if a user was previously logged in).
  - Saving data and assets locally so a site will be quicker (and potentially less expensive) to download, or be usable without a network connection.
  - Saving web application generated documents locally for use offline

### Old fashioned: cookies

- The concept of client-side storage has been around for a long time. Since the early days of the web, sites have used cookies to store information to personalize user experience on websites. They're the earliest form of client-side storage commonly used on the web.

### New school: Web Storage and IndexedDB

- Modern browsers have much easier, more effective APIs for storing client-side data than by using cookies.
  - The Web Storage API provides a very simple syntax for storing and retrieving smaller, data items consisting of a name and a corresponding value. This is useful when you just need to store some simple data, like the user's name, whether they are logged in, what color to use for the background of the screen, etc.
  - The IndexedDB API provides the browser with a complete database system for storing complex data. This can be used for things from complete sets of customer records to even complex data types like audio or video files.

### The future: Cache API

- Some modern browsers support the new Cache API. This API is designed for storing HTTP responses to specific requests, and is very useful for doing things like storing website assets offline so the site can subsequently be used without a network connection. Cache is usually used in combination with the Service Worker API, although it doesn't have to be.

<br>
<br>

> There are much more to see in APIs these notes were just a taster ...
