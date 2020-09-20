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

- __`Tales of the Stone Age: 1945 to 1994`__ -- 

- __`The First Browser Wars: 1995 to 1999`__ -- 

- __`The Boring Period: 2000 to 2003`__ -- 

- __`Web 2.0 and the Second Browser Wars: 2004 and Beyond`__ -- 
 
### The Evolution of a Threat

- __`The User as a Security Flaw`__ -- 

- __`The Cloud, or the Joys of Communal Living`__ -- 

- __`Nonconvergence of Visions`__ -- 

- __`Cross-Browser Interactions: Synergy in Failure`__ -- 

- __`The Breakdown of the Client-Server Divide`__ -- 


<br>
<br>

---

<br>
<br>

# Chapter 2: It Starts with a URL

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
