# Server, Browser and Site Caching

- What follows are details on each of these types of caches:

### What is a Site Cache (or Page Cache)?

- A site cache, or also known as an HTTP or page cache, is a system that temporarily stores data such as web pages, images, and similar media content when a web page is loaded for the first time. It remembers the content and is able to quickly load the content each time the web page is visited again.

  When a user visits a page for the first time, a site cache commits selected content to memory. When that same page is visited again, the site cache is able to recall the same content, then load it much quicker when compared to the first visit. Each visit to the same page is also loaded just as quickly from the cache.

  This means caching that’s completely taken care of, and controlled by the end user. A website has only a limited way of administering client-side caching. It can tell a cache how long to store saved data.
  
### What is a Browser Cache?

- A browser cache is a kind of client-side cache, which means it’s also a type of site caching. It works in the same way and it’s a cache system that’s built into a browser.

  Files and content that are saved are stored on your computer and are grouped with other files associated with the browser you use. A browser cache temporarily saves these kinds of content:
  - HTML pages
  - CSS stylesheets
  - JavaScript scripts
  - Images
  - Other types of multimedia content

  According to Google, every browser has some form of browser cache. Although, some have a more comprehensive system such as those found in major options such as Chrome, Safari, Firefox, and other similar browsers. The end user can also manually clear out their browser’s cache whenever they want.

### What is a Server Cache?

- A server cache is a type cache that’s related to site caching, except instead of temporarily saving content on the client side, it’s stored on a site’s server. Server caching is also fully handled and amistered on the server without any involvement of the end user, or a browser.

- Types of server caching include, but aren’t limited to:
  - `Object caching` – Storing database queries in a server-side cache for quick retrieval on subsequent page loads.
  - `CDN caching` – A Content Delivery Network (CDN) is a cluster of servers that are geographically located all around the world. They cache content that’s loaded using the server that’s closest to the end user for much faster loading times.
  - `Opcode caching` – PHP code is compiled between each request, then stored in a cache so it’s executable faster on repeated page loads.
  

### File Optimziation

- There are also advanced file optimization options that can significantly improve site performance including:
  - __Minify HTML__ – Minifying HTML removes whitespace and comments to reduce the size.
  - __Combine Google Fonts files__ – Combining Google Fonts will reduce the number of HTTP requests.
  - __Remove query strings from static resources__ – This removes the version query string from static files and encodes it into the filename instead, to help improve your GTMetrix score.
  - __Minify CSS files__ – Minifying CSS removes whitespace and comments to reduce the file size.
  - __Combine CSS files__ – This merges all your files into one, reducing HTTP requests.
  - __Optimize CSS delivery__ – Optimizing CSS delivery eliminates render-blocking CSS on your website for faster perceived load time.
  - __Minify JavaScript files__ – This setting removes whitespace and comments to reduce the file size.
  - __Combine JavaScript files__ – Similarly to combining CSS files, combing your JavaScript files helps reduce HTTP requests by combining your site’s internal, third party and inline JavaScript.
  - __Load JavaScript deferred__ – Loading JavaScript deferred eliminates render-blocking JavaScript on your site and can improve load time.
  
