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

- Implement caching if necessary, understand and use [HTTP caching](https://www.mnot.net/cache_docs/) properly as well as [HTML5 Manifest](https://www.w3.org/TR/2011/WD-html5-20110525/offline.html).

- Optimize images - don't use a 20 KB image for a repeating background.

- Compress content for speed, see [brotli](https://www.smashingmagazine.com/2016/10/next-generation-server-compression-with-brotli/), [gzip/deflate](https://developer.yahoo.com/performance/rules.html?guccounter=1#gzip) (deflate is better).

- Combine/concatenate multiple stylesheets or multiple script files to reduce the number of browser connections and improve gzip ability to compress duplications between files.

- Take a look at the [Yahoo Exceptional Performance site](https://developer.yahoo.com/), lots of great guidelines, including improving front-end performance and their [YSlow tool](http://yslow.org/) (requires Firefox, Safari, Chrome or Opera). Also, [Google page speed](https://developers.google.com/speed/docs/insights/rules) (use with browser extension) is another tool for performance profiling, and it optimizes your images too.

- Use [SVG image sprites](https://24ways.org/2014/an-overview-of-svg-sprite-creation-techniques/) for small related images like toolbars. SVG coloring is bit tricky. You can read about it [here](http://tympanus.net/codrops/2015/07/16/styling-svg-use-content-css/).

- Busy web sites should consider [splitting components across domains](https://developer.yahoo.com/performance/rules.html#split). Specifically...

- Static content (i.e. images, CSS, JavaScript, and generally content [that doesn't need access to cookies](https://stackoverflow.blog/2009/08/09/a-few-speed-improvements/)) should go in a separate domain that does not use cookies, because all cookies for a domain and its subdomains are sent with every request to the domain and its subdomains. One good option here is to use a Content Delivery Network (CDN), but consider the case where that CDN may fail by including alternative CDNs, or local copies that can be served instead.

- Minimize the total number of HTTP requests required for a browser to render the page.

- Choose a [template engine](http://garann.github.io/template-chooser/) and render/pre-compile it using task-runners like gulp or grunt

- Make sure there’s a `favicon.ico` file in the root of the site, i.e. `/favicon.ico`. [Browsers will automatically request it](https://mathiasbynens.be/notes/rel-shortcut-icon), even if the icon isn’t mentioned in the HTML at all. If you don’t have a `/favicon.ico`, this will result in a lot of 404s, draining your server’s bandwidth.

<br>

## SEO (Search Engine Optimization)

- Use "search engine friendly" URLs, i.e. use `example.com/pages/45-article-title` instead of `example.com/index.php?page=45`

- When using # for dynamic content change the # to #! and then on the server $_REQUEST["_escaped_fragment_"] is what googlebot uses instead of #!. In other words, ./#!page=1 becomes ./?_escaped_fragments_=page=1. Also, for users that may be using FF.b4 or Chromium, history.pushState({"foo":"bar"}, "About", "./?page=1"); Is a great command. So even though the address bar has changed the page does not reload. This allows you to use ? instead of #! to keep dynamic content and also tell the server when you email the link that we are after this page, and the AJAX does not need to make another extra request.

- Don't use links that say "[click here](https://ux.stackexchange.com/questions/12100/why-shouldnt-we-use-words-such-as-here-and-this-in-textlinks)". You're wasting an SEO opportunity and it makes things harder for people with screen readers.

- Have an [XML sitemap](https://www.sitemaps.org/index.html) preferably in the default location `/sitemap.xml`.

- Use [`<link rel="canonical" ... />`](https://webmasters.googleblog.com/2009/02/specify-your-canonical.html) when you have multiple URLs that point to the same content, this issue can also be addressed from [Google Webmaster Tools](https://www.google.com/webmasters/#?modal_active=none).

- Use [Google Webmaster Tools](https://www.google.com/webmasters/#?modal_active=none) and [Bing Webmaster Tools](https://www.bing.com/toolbox/webmaster).

- Install [Google Analytics](https://marketingplatform.google.com/about/analytics/) right at the start (or an open source analysis tool like [Piwik](https://matomo.org/)).

- Know how [robots.txt](https://en.wikipedia.org/wiki/Robots_exclusion_standard) and search engine spiders work.

- Redirect requests (using `301 Moved Permanently`) asking for `www.example.com` to `example.com` (or the other way round) to prevent splitting the google ranking between both sites.

- Know that there can be badly-behaved spiders out there.

- If you have non-text content look into Google's sitemap extensions for video etc. There is some good information about this in [Tim Farley's answer](https://softwareengineering.stackexchange.com/questions/46716/what-technical-details-should-a-programmer-of-a-web-application-consider-before#167608).


<br>

## Technology

- Understand HTTP and things like GET, POST, sessions, cookies, and what it means to be "stateless".

- Write your XHTML/HTML and CSS according to the [W3C specifications](https://www.w3.org/TR/) and make sure they [validate](http://validator.w3.org/). The goal here is to avoid browser quirks modes and as a bonus make it much easier to work with non-traditional browsers like screen readers and mobile devices.

- Understand how JavaScript is processed in the browser.

- Understand how JavaScript, style sheets, and other resources used by your page are loaded and consider their impact on perceived performance. It is now widely regarded as appropriate to move scripts to the bottom of your pages with exceptions typically being things like analytics apps or HTML5 shims.

- Understand how the JavaScript sandbox works, especially if you intend to use iframes.

- Be aware that JavaScript can and will be disabled, and that AJAX is therefore an extension, not a baseline. Even if most users leave it on now, remember that [NoScript](https://noscript.net/) is becoming more popular. Even though modern crawling bots support indexing JavaScript-generated content, consider using server-side rendering for other crawling bots or users who have disabled JavaScript.

- Learn the difference between [301 and 302 redirects](https://www.bigoakinc.com/blog/when-to-use-a-301-vs-302-redirect/) (this is also an SEO issue).

- Learn as much as you possibly can about your deployment platform.

- Consider using a [Reset Style Sheet](https://stackoverflow.com/questions/11578819/css-reset-what-exactly-does-it-do) or [normalize.css](http://necolas.github.io/normalize.css/).

- Consider JavaScript frameworks (such as jQuery, MooTools, Prototype, Dojo or YUI 3), which will hide a lot of the browser differences when using JavaScript for DOM manipulation.

- Taking perceived performance and JS frameworks together, consider using a service such as the [Google Libraries API](https://developers.google.com/speed/libraries) to load frameworks so that a browser can use a copy of the framework it has already cached rather than downloading a duplicate copy from your site.

- Don't reinvent the wheel. Before doing ANYTHING search for a component or example on how to do it. There is a 99% chance that someone has done it and released an OSS version of the code.

- On the flipside of that, don't start with 20 libraries before you've even decided what your needs are. Particularly on the client-side web where it's almost always ultimately more important to keep things lightweight, fast, and flexible.

<br>

## Bug fixing

- Understand you'll spend 20% of your time coding and 80% of it maintaining, so code accordingly.

- Set up a good error reporting solution.

- Have a system for people to contact you with suggestions and criticisms

- Document how the application works for future support staff and people performing maintenance.

- Make frequent backups! (And make sure those backups are functional) Have a restore strategy, not just a backup strategy.

- Use a version control system to store your files, such as Subversion, Mercurial or Git.

- Don't forget to do your Acceptance Testing. Frameworks like Selenium can help. Especially if you fully automate your testing, perhaps by using a Continuous Integration tool, such as Jenkins.

- Make sure you have sufficient logging in place using frameworks such as [log4j](https://logging.apache.org/log4j/2.x/), [log4net](http://logging.apache.org/log4net/) or [log4r](). If something goes wrong on your live site, you'll need a way of finding out what.

- When logging make sure you capture both handled exceptions, and unhandled exceptions. Report/analyse the log output, as it'll show you where the key issues are in your site.

<br>

## Other

- Implement both server-side and client-side monitoring and analytics (one should be proactive rather than reactive).

- Use services like UserVoice and Intercom (or any other similar tools) to constantly keep in touch with your users.

- Follow [Vincent Driessen](https://nvie.com/about/)'s [Git branching model](https://nvie.com/posts/a-successful-git-branching-model/)


----


Lots of stuff omitted not necessarily because they're not useful answers, but because they're either too detailed, out of scope, or go a bit too far for someone looking to get an overview of the things they should know

- Reference:
  - https://softwareengineering.stackexchange.com/questions/46716/what-technical-details-should-a-programmer-of-a-web-application-consider-before
