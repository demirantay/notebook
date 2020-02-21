# The technical details a programmer of a web application should consider before making the site public

> What things should a programmer implementing the technical details of a web application consider before making the site public? If Jeff Atwood can forget about HttpOnly cookies, sitemaps, and cross-site request forgeries all in the same site, what important thing could I be forgetting as well?

<bR>
<br>

## Interface and User Experience

- Be aware that browsers implement standards inconsistently and make sure your site works reasonably well across all major browsers. At a minimum test against a recent [Gecko](https://en.wikipedia.org/wiki/Gecko_%28layout_engine%29) engine ([Firefox](https://www.mozilla.org/en-US/firefox/new/?redirect_source=firefox-com)), a WebKit engine ([Safari](https://www.apple.com/safari/) and some mobile browsers), [Chrome](https://www.google.com/chrome/), your supported IE browsers (take advantage of the Application Compatibility VPC Images), and Opera. Also consider how browsers [render your site in different operating systems](http://browsershots.org/).

- Consider how people might use the site other than from the major browsers: cell phones, screen readers and search engines, for example. — Some accessibility info: [WAI](https://www.w3.org/WAI/) and [Section508](), Mobile development: [MobiForge](https://mobiforge.com/).

- Staging: How to deploy updates without affecting your users. Have one or more test or staging environments available to implement changes to architecture, code or sweeping content and ensure that they can be deployed in a controlled way without breaking anything. Have an automated way of then deploying approved changes to the live site. This is most effectively implemented in conjunction with the use of a version control system (git, Subversion, etc.) and an automated build mechanism (Ant, NAnt, etc.).

- Don't display unfriendly errors directly to the user.

- Don't put users' email addresses in plain text as they will get spammed to death.

- Add the attribute rel="nofollow" to user-generated links to avoid spam.

- [Build well-considered limits into your site](https://blog.codinghorror.com/rate-limiting-and-velocity-checking/) - This also belongs under Security.

- Learn how to do [progressive enhancement](https://en.wikipedia.org/wiki/Progressive_enhancement).

- Redirect after a POST if that POST was successful, to prevent a refresh from submitting again.

- Don't forget to take accessibility into account. It's always a good idea and in certain circumstances it's a [legal requirement](). [WAI-ARIA](https://www.w3.org/WAI/standards-guidelines/aria/) and [WCAG 2](https://www.w3.org/TR/WCAG20/) are good resources in this area.

- Read [Don't Make Me Think](http://www.sensible.com/dmmt.html)

<br>

## Security

- It's a lot to digest but the [OWASP development guide](https://wiki.owasp.org/index.php/OWASP_Guide_Project) covers Web Site security from top to bottom.

- Know about Injection especially [SQL injection](https://en.wikipedia.org/wiki/SQL_injection) and how to prevent it.

- Never trust user input, nor anything else that comes in the request (which includes cookies and hidden form field values!).

- Hash passwords using [salt](https://security.stackexchange.com/questions/21263/how-to-apply-a-pepper-correctly-to-bcrypt) and use different salts for your rows to prevent rainbow attacks. Use a slow hashing algorithm, such as bcrypt (time tested) or scrypt (even stronger, but newer) ([1](https://it.slashdot.org/comments.pl?sid=1987632&cid=35149842), [2](http://www.tarsnap.com/scrypt.html)), for storing passwords. ([How To Safely Store A Password](https://codahale.com/how-to-safely-store-a-password/)). T[he NIST also approves of PBKDF2 to hash passwords](https://security.stackexchange.com/questions/7689/clarification-needed-for-nists-whitepaper-recommendation-for-password-based-ke) ", and it's [FIPS approved in .NET](https://security.stackexchange.com/questions/2131/reference-implementation-of-c-password-hashing-and-verification/2136#2136) (more info here). Avoid using MD5 or SHA family directly.

- [Don't try to come up with your own fancy authentication system](https://stackoverflow.com/questions/1581610/how-can-i-store-my-users-passwords-safely/1581919#1581919). It's such an easy thing to get wrong in subtle and untestable ways and you wouldn't even know it until after you're hacked.

- Know the [rules for processing credit cards](https://www.pcisecuritystandards.org/). ([See this question as well](https://stackoverflow.com/questions/51094/payment-processors-what-do-i-need-to-know-if-i-want-to-accept-credit-cards-on))

- Use [SSL](https://developer.mozilla.org/en-US/docs/Mozilla/Projects/NSS)/[TLS](https://developer.mozilla.org/en-US/docs/Mozilla/Projects/NSS)/[HTTPS](https://en.wikipedia.org/wiki/Session_hijacking#Prevention) for any sites where sensitive data is entered (like credentials, Personally Identifiable Information, credit card info). [Let's Encrypt](https://letsencrypt.org/) is a free certificate authority which can help.

- [Prevent session hijacking](https://en.wikipedia.org/wiki/Session_hijacking#Prevention).

- Avoid [cross site scripting](https://en.wikipedia.org/wiki/Cross-site_scripting) (XSS).

- Avoid [cross site request forgeries](https://en.wikipedia.org/wiki/Cross-site_request_forgery) (CSRF).

- Avoid [Clickjacking](https://en.wikipedia.org/wiki/Clickjacking).

- Keep your system(s) up to date with the latest patches.

- Make sure your database connection information is secured.

- Keep yourself informed about the latest attack techniques and vulnerabilities affecting your platform.

- Read The [Google Browser Security Handbook](https://code.google.com/archive/p/browsersec/).

- Read The [Web Application Hacker's Handbook](https://www.amazon.com/dp/0470170778/).

- Consider [The principle of least privilege](https://en.wikipedia.org/wiki/Principle_of_least_privilege). Try to run your app server as [non-root](https://security.stackexchange.com/questions/47576/do-simple-linux-servers-really-need-a-non-root-user-for-security-reasons). (tomcat example)

- Put `rel="noopener noreferrer"` on all user-provided links with `target="_blank"` to prevent JavaScript on the destination page from redirecting your page to somewhere else, such as a fake login page. (phising)

- Consider using a strict [Content Security Policy](https://csp.withgoogle.com/docs/index.html).

<br>

## Performance

<br>

## SEO (Search Engine Optimization)


<br>

## Technology

<br>

## Bug fixing

<br>

## Other
