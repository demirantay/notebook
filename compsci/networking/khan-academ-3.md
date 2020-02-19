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

- When we browse the web, who can see what we're reading? Who can see the text we type into forms? With standard HTTP, many people can: cybercriminals intercepting packets, ISPs monitoring traffic, government agencies tapping into the fiber cables that make up the backbone of the internet. Using well-known exploits, they can read the contents of every website and even inject their own contents.

  That's why websites increasingly use HTTPS (Hypertext Transfer Protocol Secure) to protect the privacy of their users and prevent tampering. HTTPS is also known as HTTP over TLS, because it's implemented by encrypting HTTP requests and responses with the TLS protocol.
  
- `HTTPS URLs` -- An HTTPS connection starts with the URL in the address bar. Standard HTTP connections have URLs that start with "http://". Secure HTTP connections have URLs that start with "https://".

- `HTTPS connections` -- When the browser loads a URL that starts with "https", it begins the process of setting up a secure connection over TLS. Early in that process, the browser must verify the digital certificate of the domain If the certificate is valid and everything else goes smoothly in the TLS setup, most browsers will display a lock in the address bar. That lock indicates a secured connection over HTTPS.

- `The benefits of HTTPS` -- An HTTPS connection ensures that only the browser and the secured domain see the data in HTTP requests and responses. Onlookers can still see that a particular IP address is communicating with another domain/IP, and they can see how long that connection lasts. But those onlookers cannot see the content of the communication: the pages they're viewing, the text they're submitting.

### Privacy on the Web

- The web is not private by default. Websites can use cookies to track user actions on their site and even across other sites. Browsers can track the browsing history of a user, their search queries, and even their form inputs.

- `Cookies` -- An HTTP cookie is a small amount of text that helps a website track information about a user across multiple pages of the website, and personalize the user's experience on the website. If you've ever logged into a website, a cookie kept you logged in across multiple pages. If you ever added items to an online shopping cart, a cookie remembered the cart contents during your shopping session.

  __Third-party cookies__ == Each cookie stored by a browser is associated with a domain and path. When you visit a website and its server sends back an HTTP response with a cookie, the browser associates that cookie with the domain of the server. That's called a "first-party cookie".
  
    However, a website can also include resources from other domains, like an image, iframe, or script. When the browser requests those resources, their servers can also send back cookies, which will now be associated with their domain. These are "third-party cookies".
    
    What are they doing with all those cookies? Most third-party cookies are used for advertising. Imagine a user that visits a food blog with a recipe for gluten-free cookies. That blog includes a Facebook ad with a cookie. The user then visits facebook.com and notices a sudden uptick in ads about gluten-free products. That's not a coincidence, that's cookies!

- `Geolocation` -- The internet is global, but it can help us find services, products, and events near us. Where's the nearest bank? What restaurants will deliver to me? Which of my friends live in the area? What bus will get me to my destination? To answer those questions, websites need to know our geolocation: an approximate latitude and longitude describing our geographic location There are a few ways they can figure that out:
  - The browser can typically make a good approximation of a user's location using GPS (when available), WiFi/mobile network positioning (most commonly), or as a last resort, IP-based location.
  - Websites can't see a user's GPS or WiFi network information. However, websites do see the IP addresses of the HTTP request coming to their server. There are databases that attempt to identify the approximate location of IP addresses, and websites can lookup an IP address in those databases. This method is often inaccurate, however.
  - Websites can also detect the geolocation of our uploaded photos by looking at the metadata of the photo file. Many phones automatically record location inside photo files.
  
- `Browsing history` -- However, our browsing history really isn't very private at all. As we just learned, websites can use third-party cookies to track our browsing history across the web, as long as all the sites load cookies from the same domain. 

  Even if we've disabled third-party cookies, browsers store our browsing history, a feature that makes it easier to re-find websites we visited in the past and autocomplete URLs for us. Anyone with access to our computer, like a parent, roommate, or classmate, can see what websites we've been visiting
  
  Ultimately, our ISP can see every HTTP request that goes over their network. We can hide the contents of those requests by using HTTPS-secured websites, but we can't hide the destination of the requests. ISPs can use that information to find customers that are engaged in illegal activities, like downloading movies illegally. Privacy-savvy users can obscure their activity by using a Virtual Private Network (VPN), but most do not, since VPNs cost money and slow down the internet experience.
  
  By using the web, we give up some amount of privacy to gain access to a wide range of resources (like free online education!). Fortunately, we can also use the web to learn more about ways to retain more of our privacy. (But there is also  other web browsers such as TOR ...etc. that even makes the ISP unable to see the requests but that is for another times topic)

<br>
<br>

---

<br>
<br>

# Cybercrime and prevention

- Computers can be attacked in many ways, and the internet makes attacks much easier. Cyber criminals can find ways to install malware into machines, and if that malware is a virus or worm, it can quickly spread to many more files or machines. Once malware is on a machine, it can steal data or use up valuable resources.

### Computer Malware and Attacks

### Phishing and Password Attacks 
