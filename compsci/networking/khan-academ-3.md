# HTTP & HTML: Global document & data sharing

- When most of us talk about using the "internet", we're typically talking about a very specific part of the internet: the World Wide Web (WWW, or simply "web"). The web is a massive network of webpages and media, connected to each other through links, and accessible via URLs.

  We call it a web because of its vast interconnectedness. Starting from one URL, like wikipedia.org, we can follow links to eventually reach millions of webpages from across the globe.
  
  There are more than 2 billion websites on the internet today (2019). Every website is written in HTML, and our personal computers can view those websites thanks to HTTP.

### Hypertext Transfer Protocol (HTTP)

- Whenever you visit a page on the web, your computer uses the Hypertext Transfer Protocol (HTTP) to download that page from another computer somewhere on the internet.

- `Step 1: Direct browser to URL` -- The user either types a Uniform Resource Locator (URL) in the browser or follows a link from an already opened page, Notice something about that URL: it starts with "http". That's a signal to the browser that it needs to use HTTP to fetch the document for that URL.

- `Step 2: Browser looks up IP` -- We typically type nice human-friendly URLs into browsers, like "khanacademy.org" and "wikipedia.org". Those domain names map to IP addresses, the true location of the domain's computers. That's handled by the Domain Name System. The browser uses a DNS resolver to map the domain to an IP address:

- `Step 3: Browser sends HTTP request` -- Once the browser identifies the IP address of the computer hosting the requested URL, it sends an HTTP request. An HTTP request can be as short as two lines of text:
  ```
  GET /index.html HTTP/1.1
  Host: www.example.com
  ```

- `Step 4: Host sends back HTTP response` -- Once the host computer receives the HTTP request, it sends back a response with both the content and metadata about it. The response object has status code headers, cookies sessions ... etc. too many things to note in here but you get the idea in general.

- `Step 5: The browser renders the response` --  The browser now has all the information it needs to render the document requested.

- `HTTP and TCP/IP` -- HTTP is a protocol that's built on top of the TCP/IP protocols. Each HTTP request is inside an IP packet, and each HTTP response is inside another IP packet--or more typically, multiple packets, since the response data can be quite large. There are many other protocols built on top of TCP/IP, like protocols for sending email (SMTP, POP, IMAP) and uploading files (FTP).

  All of these protocols enable us to use the internet to connect with other computers in useful ways, and to communicate and collaborate across wide distances.

### HTTP Secure (HTTPS)

### Privacy on the Web

<br>
<br>

---

<br>
<br>

# Cybercrime and prevention
