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

- __`Scheme Name`__ -- 

- __`Indicator of a Hierarchical URL`__ -- 

- __`Credentials to Access the Resource`__ -- 

- __`Server Address`__ -- 

- __`Server Port`__ -- 

- __`Hierarchical File Path`__ -- 

- __`Query String`__ -- 

- __`Fragment ID`__ -- 

- __`Putting It All Together Again`__ --

### Reserved Characters and Percent Encoding

- __`Handling of Non-US-ASCII Text`__ -- 

### Common URL Schemes and Their Function

- __`Browser-Supported, Document-Fetching Protocols`__ -- 

- __`Protocols Claimed by Third-Party Applications and Plug-ins`__ -- 

- __`Nonencapsulating Pseudo-Protocols`__ -- 

- __`Encapsulating Pseudo-Protocols`__ -- 

- __`Closing Note on Scheme Detection`__ -- 

### Resolution of Relative URLs

### Security Engineering Cheat Sheet.

- __`When Constructing Brand-New URLs Based on User Input`__ -- 

- __`When Designing URL Input Filters`__ -- 

- __`When Decoding Parameters Received Through URLs`__ -- 


<br>
<br>

---

<br>
<br>
