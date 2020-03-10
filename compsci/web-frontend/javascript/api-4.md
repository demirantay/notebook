# Third party APIs

- The APIs we've covered so far are built into the browser, but not all APIs are. Many large websites and services such as Google Maps, Twitter, Facebook, PayPal, etc. provide APIs allowing developers to make use of their data (e.g. displaying your twitter stream on your blog) or services (e.g. using Facebook login to log in your users

<br>
<br>

# What are third party APIs?

- Third party APIs are APIs provided by third parties — generally companies such as Facebook, Twitter, or Google — to allow you to access their functionality via JavaScript and use it on your site. One of the most obvious examples is using mapping APIs to display custom maps on your pages.

### They are found on third-party servers

- Browser APIs are built into the browser — you can access them from JavaScript immediately. For example, the Web Audio API  is accessed using the native AudioContext object. For example:
  ```js
  const audioCtx = new AudioContext();
  ```
   Third party APIs, on the other hand, are located on third party servers. To access them from JavaScript you first need to connect to the API functionality and make it available on your page.
   
   This typically involves first linking to a JavaScript library available on the server via a <script> element, as seen in our Mapquest (an 3rd party API to give a example) example
   ```html
   <script src="https://api.mqcdn.com/sdk/mapquest-js/v1.3.2/mapquest.js"></script>
  <link type="text/css" rel="stylesheet" href="https://api.mqcdn.com/sdk/mapquest-js/v1.3.2/mapquest.css"/>
   ```

  > Note: Some APIs handle access to their functionality slightly differently, requiring the developer to make an HTTP request to a specific URL pattern to retrieve data. These are called RESTful APIs

### They usually require API keys

- Security for browser APIs tends to be handled by permission prompts, as discussed in our first article. The purpose of these is so that the user knows what is going on in the websites they visit and is less likely to fall victim to someone using an API in a malicious way.

  Third party APIs have a slightly different permissions system — they tend to use developer keys to allow developers access to the API functionality, which is more to protect the API vendor than the user.
  
  Other APIs may require that you include the key in a slightly different way, but the pattern is relatively similar for most of them.
  
<br>
<br>

# A RESTful API — NYTimes

- Now let's look at another API example — the New York Times API. This API allows you to retrieve New York Times news story information and display it on your site. This type of API is known as a RESTful API — instead of getting data using the features of a JavaScript library like we did with Mapquest, we get data by making HTTP requests to specific URLs, with data like search terms and other properties encoded in the URL (often as URL parameters). This is a common pattern you'll encounter with APIs.

<br>
<br>

# An approach for using third-party APIs

- General steps to follow on third party modern apis:
  - Find the documentation
  - Get a developer key
  - Connect the API to your app
  - Requesting data from the API
  - Displaying the data
