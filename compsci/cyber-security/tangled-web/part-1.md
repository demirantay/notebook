# The Tangled Web

### Preface

- Just fifteen years ago, the Web was as simple as it
was unimportant: a quirky mechanism that allowed a handful of students, plus a bunch of asocial, basement- dwelling geeks, to visit each other’s home pages dedi- cated to science, pets, or poetry. Today, it is the platform of choice for writing complex, interactive applications (from mail clients to image editors to computer games) and a medium reaching hundreds of millions of casual users around the globe.

  As it turns out, the protocol design standards one would apply to a black-on-gray home page full of dancing hamsters are not necessarily the same for an online shop that processes millions of credit card transactions every year.

<br>
<br>

---

<br>
<br>

# Chapter 1: Security in the World of Web Applications 

- To provide proper context for the technical discus- sions later in the book, it seems prudent to first of all explain what the field of security engineering tries to achieve and then to outline

### Information Security in a Nutshell 

- for several decades, we have in essence completely failed to come up with even the most rudimentary usable frameworks for understanding and assessing the security of modern software. Save for several brilliant treatises and limited-scale experiments, we do not even have any real-world success stories to share. The focus is almost exclusively on reactive, secondary secu- rity measures (such as vulnerability management, malware and attack detec- tion, sandboxing, and so forth)

- __`Flirting with Formal Solutions `__ -- In the end, regardless of the number of elegant, competing models intro- duced, all attempts to understand and evaluate the security of real-world soft- ware using algorithmic foundations seem bound to fail. This leaves developers and security experts with no method to make authoritative, future-looking statements about the quality of produced code. So, what other options are on the table?

- __`Enter Risk Management`__ -- In the absence of formal assurances and provable metrics, and given the frightening prevalence of security flaws in key software relied upon by mod- ern societies, businesses flock to another catchy concept: risk management. The idea of risk management, applied successfully to the insurance business (with perhaps a bit less success in the financial world), simply states that system owners should learn to live with vulnerabilities that cannot be addressed in a cost-effective way and, in general, should scale efforts accord- ing to the following formula:
  ```
  risk = probability of an event x maximum loss
  ```
  Naturally, it’s prudent to prioritize security efforts. The problem is that when risk management is done strictly by the numbers, it does little to help us to understand, contain, and manage real-world problems. Instead, it intro- duces a dangerous fallacy: that structured inadequacy is almost as good as adequacy and that underfunded security efforts plus risk management are about as good as properly funded security work. Guess what? This is a terrible way to do security. 

- __`Enlightenment Through Taxonomy`__ -- the Department of Home- land Security–funded Common Weakness Enumeration (CWE), the goal of which, in the organization’s own words, is to develop a unified “Vulnerability Theory”; “improve the research, modeling, and classification of software flaws”; and “provide a common language of discourse for discussing, finding and dealing with the causes of software security vulnerabilities.” Today, there are about 800 names in the CWE dictionary, most of which are as discourse-enabling as the one quoted here.

  CWE, CVSS, and related projects serve noble goals, such as bringing a more manageable dimension to certain security pro- cesses implemented by large organizations. Still, none has yielded a grand theory of secure software, and I doubt such a framework is within sight.

- __`Toward Practical Approaches `__ -- All signs point to security being largely a nonalgorithmic problem for now. The industry is understandably reluctant to openly embrace this notion, because it implies that there are no silver bullet solutions to preach
  - Learning from (preferably other people’s) mistakes.
  - Developing tools to detect and correct problems.
  - Planning to have everything compromised.
  
  In all cases, a substantial dose of patience, creativity, and real technical expertise is required from all the information security staff.

### A Brief History of the Web

- __`Tales of the Stone Age: 1945 to 1994`__ -- Computer historians frequently cite a hypothetical desk-sized device called the Memex as one of the earliest fossil records, postulated in 1945 by Vannevar Bush.3 Memex was meant to make it possible to create, annotate, and follow cross-document links in microfilm, using a technique that vaguely resembled modern-day bookmarks and hyperlinks.

  The next tangible milestone, in the 1960s, was the arrival of IBM’s Generalized Markup Language (GML), which allowed for the annotation of documents with machine-readable directives indicating the function of each block of text, effectively saying “this is a header,” “this is a numbered list of items,” and so on
  
  By the end of the decade, two researchers, Tim Berners-Lee and Dan Connolly, had begun working on a new approach to the cross-domain refer- ence challenge—one that focused on simplicity. They kicked off the project by drafting HyperText Markup Language (HTML), a bare-bones descendant of SGML, designed specifically for annotating documents with hyperlinks and basic formatting. They followed their work on HTML with the develop- ment of HyperText Transfer Protocol (HTTP) sometime between 1991 and 1993, was Tim Berners- Lee’s World Wide Web (Figure 1-1), a rudimentary browser that parsed HTML and allowed users to render the resulting data on the screen, and then navigate from one page to another with a mouse click.
  
  By 1993, HTTP traffic accounted for 0.1 percent of all bandwidth in the National Science Foundation backbone network. The same year also witnessed the arrival of Mosaic, the first reasonably popular and sophisti- cated web browser, developed at the University of Illinois.

- __`The First Browser Wars: 1995 to 1999`__ -- By the mid-1990s, it was clear that the Web was here to stay and that users were willing to ditch many older technologies in favor of the new contender.

  The resulting arms race among browser vendors was characterized by the remarkably rapid development and deployment of new features in the compet- ing products, a trend that often defied all attempts to standardize or even prop- erly document all the newly added code. Core HTML tweaks ranged from the silly (the ability to make text blink, a Netscape invention that became the butt of jokes and a telltale sign of misguided web design) to notable ones, such as the ability to change typefaces or embed external documents in so-called frames. Vendors released their products with embedded programming languages such as JavaScript and Visual Basic or Flash applets on the user’s machine, and useful but tricky HTTP extensions such as cookies 
  
    Other efforts to standardize or improve already implemented mecha- nisms, most notably HTTP and JavaScript, were driven by other auspices such as the European Computer Manufacturers Association (ECMA), the Interna- tional Organization for Standardization (ISO), and the Internet Engineering Task Force (IETF).

- __`The Boring Period: 2000 to 2003`__ -- As the efforts to wrangle the Web floundered, Microsoft’s dominance grew as a result of its operating system–bundling strategy. By the beginning of the new decade, Netscape Navigator was on the way out, and Internet Explorer. held an impressive 80 percent market share—a number roughly comparable to what Netscape had held just five years before. On both sides of the fence, security and interoperability were the two most notable casualties of the fea- ture war, but one could hope now that the fighting was over, developers could put differences aside and work together to fix the mess.

  On the upside, the slowdown in browser development allowed the W3C to catch up and to carefully explore some new concepts for the future of the Web. New initiatives finalized around the year 2000 included HTML 4 (a cleaned-up language that deprecated or banned many of the redundant or politically incorrect features embraced by earlier versions)
  
  But soon, something interesting happened: Microsoft gave the world a seemingly unimportant, proprietary API, confusingly named XMLHttpRequest. This trivial mechanism was meant to be of little significance, merely an attempt to scratch an itch in the web-based version of Microsoft Outlook. But XMLHttpRequest turned out to be far more, as it allowed for largely unconstrained asynchronous HTTP communications between client-side JavaScript and the server without the need for time-consuming and disrup- tive page transitions. In doing so, the API contributed to the emergence of what would later be dubbed web 2.0

- __`Web 2.0 and the Second Browser Wars: 2004 and Beyond`__ --  XMLHttpRequest, in conjunction with the popularity of the Internet and the broad availability of web browsers, pushed the Web to some new, exciting frontiers. By about 2002, worms and browser vulnerabili- ties had emerged as a frequently revisited theme in the media. In 2004, a new contender in the browser wars emerged: Mozilla Firefox
 
### The Evolution of a Threat

- Clearly, web browsers, and their associated document formats and communi- cation protocols, evolved in an unusual manner. This evolution may explain the high number of security problems we see, but by itself it hardly proves that these problems are unique or noteworthy

- __`The User as a Security Flaw`__ -- Perhaps the most striking (and entirely nontechnical) property of web browsers is that most people who use them are overwhelmingly unskilled. Sure, nonproficient users have been an amusing, fringe problem since the dawn of computing. But the popularity of the Web, combined with its remark- ably low barrier to entry, means we are facing a new foe: Most users simply don’t know enough to stay safe. The computing industry as a whole has no robust answers in this area, and very little research is available on how to design comparably complex user interfaces (UIs) in a bulletproof way. After all, we barely get it right for ATMs.

- __`The Cloud, or the Joys of Communal Living`__ -- In the traditional model followed by virtually all personal computers over the last 15 years or so, there are very clear boundaries between high- level data objects (documents), user-level code (applications), and the oper- ating system kernel that arbitrates all cross-application communications and hardware input/output (I/O) and enforces configurable security rules should an application go rogue. In the browser world, this separation is virtually nonexistent: Documents and code live as parts of the same intermingled blobs of HTML. In the end, the seemingly unlikely scenario of a text file stealing your email is, in fact, a frustratingly common pattern on the Web. Virtually all web applications must heavily compensate for unsolicited, malicious cross-domain access and take cumbersome steps to maintain at least some separation of code and the displayed data.

- __`Nonconvergence of Visions`__ -- There is no shared, holistic security model to grasp and live by. We are not looking for a grand vision for world peace, mind you, but simply a common set of flexible paradigms that would apply to most, if not all, of the relevant security logic. In the Unix world, for example, the rwx user/group per- mission model is one such strong unifying theme. But in the browser realm? In the browser realm, a mechanism called same-origin policy could be considered a candidate for a core security paradigm, As it turns out, hundreds of small, clever hacks do not necessarily add up to a competent security opus

- __`The Breakdown of the Client-Server Divide`__ -- The Web began as a classical example of a proper client-server architec- ture, but the functional boundaries between client and server responsibilities were quickly eroded. The culprit is JavaScript, a language that offers the HTTP servers a way to delegate application logic to the browser (“client”) side and gives them two very compelling reasons to do so. First, such a shift often results in more responsive user interfaces, as servers do not need to synchro- nously participate in each tiny UI state change imaginable. Second, server- side CPU and memory requirements (and hence service-provisioning costs) can decrease drastically when individual workstations across the globe chip in to help with the bulk of the work

  The unexpected failure of standardized security modeling and testing protocols is yet another problem that earns the Web a very special—and scary—place in the universe of information security.


<br>
<br>

---

<br>
<br>

# Chapter 2: It Starts with a URL

- The first part of this book focuses on the principal concepts that govern the operation of web browsers, namely, the protocols, document formats, and pro- gramming languages that make it all tick. Because all the familiar, user-visible security mechanisms employed in modern browsers are profoundly intertwined with these inner workings, the bare internals deserve a fair bit of attention before we wander off deeper into the woods.

### Uniform Resource Locator Structure

- __`Scheme Name`__ -- The scheme name is a case-insensitive string that ends with a single colon, indicating the protocol to be used to retrieve the resource. The official registry of valid URL schemes is maintained by the Internet Assigned Numbers Authority (IANA). current list of valid scheme names includes several dozen entries such as http:, https:, and ftp: ... etc.

- __`Indicator of a Hierarchical URL`__ -- In order to comply with the generic syntax rules laid out in RFC 1738, every absolute, hierarchical URL is required to contain the fixed string “//” right before the authority section. If the string is missing, the format and function of the remainder of the URL is undefined for the purpose of that specifica- tion
  
  An example of a nonhierarchical URL is the mailto: protocol, used to specify
email addresses and possibly a subject line `(mailto:user@example.com?subject= Hello+world)`

- __`Credentials to Access the Resource`__ -- The credentials portion of the URL is optional. This location can specify a username, and perhaps a password, that may be required to retrieve the data from the server. The method through which these credentials are exchanged is not specified as a part of the abstract URL syntax, and it is always protocol specific.

- __`Server Address`__ -- For all fully qualified hierarchical URLs, the server address section must spec- ify a case-insensitive DNS name (such as example.com), a raw IPv4 address (such as 127.0.0.1), or an IPv6 address in square brackets (such as [0:0:0:0:0:0:0:1]), indicating the location of a server hosting the requested resource.

- __`Server Port`__ -- This server port is an optional section that describes a nonstandard network port to connect to on the previously specified server. Virtually all application- level protocols supported by browsers and third-party applications use TCP or UDP as the underlying transport method, and both TCP and UDP rely on 16-bit port numbers to separate traffic between unrelated services running on a single machine. Each scheme is associated with a default port on which servers for that protocol are customarily run (80 for HTTP, 21 for FTP, and so on), but the default can be overridden at the URL level.

- __`Hierarchical File Path`__ -- The next portion of the URL, the hierarchical file path, is envisioned as a way to identify a specific resource to be retrieved from the server, such as /documents/2009/my_diary.txt. The specification quite openly builds on top of the Unix directory semantics, mandating the resolution of “/../” and “/./” segments in the path and providing a directory-based method for sorting out relative references in non–fully qualified URLs.

- __`Query String`__ -- The query string is an optional section used to pass arbitrary, nonhierarchi- cal parameters to the resource earlier identified by the path. 

- __`Fragment ID`__ -- The fragment ID is an opaque value with a role similar to the query string but that provides optional instructions for the client application rather than the server. In practice, fragment identifiers have only a single sanctioned use in
the browser: that of specifying the name of an anchor HTML element for in-document navigation. The logic is simple. If an anchor name is supplied in the URL and a matching HTML tag can be located, the document will be scrolled to that location for viewing; otherwise, nothing happens. 

- __`Putting It All Together Again`__ -- Each of the aforementioned URL segments is delimited by certain reserved characters: slashes, colons, question marks, and so on. To make the whole approach usable, these delimiting characters should not appear anywhere in the URL for any other purpose.

### Reserved Characters and Percent Encoding

- The URL-parsing algorithm outlined in the previous section relies on the assumption that certain reserved, syntax-delimiting characters will not appear literally in the URL in any other capacity (that is, they won’t be a part of the user- name, request path, and so on). These generic, syntax-disrupting delimiters are
  ```
  : / ? # [ ] @
  ```
  All of the above characters are in principle off-limits, but there are legiti- mate cases where one would want to include them in the URL (for example, to accommodate arbitrary search terms entered by the user and passed to the server in the query string). Therefore, rather than ban them, the standard provides a method to encode all spurious occurrences of these values. The method, simply called percent encoding or URL encoding

### Common URL Schemes and Their Function

- Let’s leave the bizarre world of URL parsing behind us and go back to the basics. Earlier in this chapter, we implied that certain schemes may have unexpected security consequences and that because of this, any web applica- tion handling user-supplied URLs must be cautious. To explain this point a bit better, it is useful to review all the URL schemes commonly supported in a typical browser environment.

- __`Browser-Supported, Document-Fetching Protocols`__ -- These schemes, handled internally by the browser, offer a way to retrieve arbitrary content using a particular transport protocol and then display it using common, browser-level rendering logic. The list of commonly supported schemes in this category is surprisingly short: http, https, ftp, file

- __`Protocols Claimed by Third-Party Applications and Plug-ins`__ -- For these schemes, matching URLs are simply dispatched to external, spe- cialized applications that implement functionality such as media playback, document viewing, or IP telephony. Scores of external protocol handlers exist today, and it would take another thick book to cover them all. Some of the most common examples include the acrobat: scheme, predictably routed to Adobe Acrobat Reader; callto: and sip: schemes claimed by all sorts of instant messengers and telephony soft- ware; daap:, itpc:, and itms: schemes used by Apple iTunes; mailto:

- __`Nonencapsulating Pseudo-Protocols`__ -- An array of protocols is reserved to provide convenient access to the browser’s scripting engine and other internal functions, without actually retrieving any remote content and perhaps without establishing an isolated document context to display the result. Many of these pseudo-protocols are highly browser-specific and are either not directly accessible from the Inter- net or are incapable of doing harm

- __`Encapsulating Pseudo-Protocols`__ -- This special class of pseudo-protocols may be used to prefix any other URL in order to force a special decoding or rendering mode for the retrieved resource. Perhaps the best-known example is the view-source: scheme sup- ported by Firefox and Chrome, used to display the pretty-printed source of an HTML page.

- __`Closing Note on Scheme Detection`__ -- The sheer number of pseudo-protocols is the primary reason why web appli- cations need to carefully screen user-supplied URLs. The wonky and browser- specific URL-parsing patterns, coupled with the open-ended nature of the list of supported schemes, means that it is unsafe to simply blacklist known bad scheme

<br>
<br>
