*"How do I get started with Node?"* is a commonly heard question in #Node.js. This gist is an attempt to compile some of the answers to that question. It's a perpetual [work-in-progress](https://gist.github.com/joepie91/95ed77b71790442b7e61#future-additions-to-this-list).

And if this list didn't quite answer your questions, I'm available for [tutoring and code review](http://cryto.net/~joepie91/code-review.html)! A [donation](http://cryto.net/~joepie91/donate.html) is also welcome :)

## Setting expectations

Before you get started learning about JavaScript and Node.js, there's one very important article you need to read: [Teach Yourself Programming in Ten Years](https://web.archive.org/web/20161125182601/http://www.norvig.com/21-days.html).

Understand that __it's going to take time__ to learn Node.js, just like it would take time to learn any other specialized topic - and that you're not going to learn effectively just by reading things, or following tutorials or courses. __Get out there and build things!__ Experience is by far the most important part of learning, and shortcuts to this simply *do not exist*.

Avoid "bootcamps", courses, extensive books, and basically anything else that claims to teach you programming (or Node.js) in a single run. They all lie, and what they promise you simply isn't possible. That's also the reason this post is a *list of resources*, rather than a single book - they're references for when you need to learn about a certain topic at a certain point in time. Nothing more, nothing less.

There's also no such thing as a "definitive guide to Node.js", or a "perfect stack". Every project is going to have different requirements, that are best solved by different tools. There's no point in trying to learn everything upfront, because *you can't know what you need to learn, until you actually need it*.

In conclusion, the best way to get started with Node.js is to simply __decide on a project you want to build, and start working on it__. Start with the simplest possible implementation of it, and over time add bits and pieces to it, learning about those bits and pieces as you go. The links in this post will help you with that.

## Table of contents

* [Javascript refresher](https://gist.github.com/joepie91/95ed77b71790442b7e61#javascript-refresher)
* [The Node.js platform](https://gist.github.com/joepie91/95ed77b71790442b7e61#the-nodejs-platform)
* [Setting up your environment](https://gist.github.com/joepie91/95ed77b71790442b7e61#setting-up-your-environment)
* [Functional programming](https://gist.github.com/joepie91/95ed77b71790442b7e61#functional-programming)
* [Module patterns](https://gist.github.com/joepie91/95ed77b71790442b7e61#module-patterns)
* [Code architecture](https://gist.github.com/joepie91/95ed77b71790442b7e61#code-architecture)
* [Express](https://gist.github.com/joepie91/95ed77b71790442b7e61#express)
* [Coming from other languages or platforms](https://gist.github.com/joepie91/95ed77b71790442b7e61#coming-from-other-languages-or-platforms)
* [Security](https://gist.github.com/joepie91/95ed77b71790442b7e61#security)
* [Useful modules](https://gist.github.com/joepie91/95ed77b71790442b7e61#useful-modules)
* [Deployment](https://gist.github.com/joepie91/95ed77b71790442b7e61#deployment)
* [Distribution](https://gist.github.com/joepie91/95ed77b71790442b7e61#distribution)
* [Scalability](https://gist.github.com/joepie91/95ed77b71790442b7e61#scalability)
* [Troubleshooting](https://gist.github.com/joepie91/95ed77b71790442b7e61#troubleshooting)
* [Optimization](https://gist.github.com/joepie91/95ed77b71790442b7e61#optimization)
* [Writing C++ addons](https://gist.github.com/joepie91/95ed77b71790442b7e61#writing-c-addons)
* [Writing Rust addons](https://gist.github.com/joepie91/95ed77b71790442b7e61#writing-rust-addons)
* [Odds and ends](https://gist.github.com/joepie91/95ed77b71790442b7e61#odds-and-ends)
* [Future additions to this list](https://gist.github.com/joepie91/95ed77b71790442b7e61#future-additions-to-this-list)

## Javascript refresher

Especially if you normally use a different language, or you only use Javascript occasionally, it's easy to misunderstand some of the aspects of the language.

These links will help you refresh your knowledge of JS, and make sure that you understand the OOP model correctly.

* __A whirlwind tour of the language:__ http://learnxinyminutes.com/docs/javascript/
* __Javascript does automatic typecasting ("type conversion") in some cases.__ [This](https://gist.github.com/joepie91/5fd8c58345998d4dec5b) shows how various values cast to a boolean, and [this](https://gist.github.com/joepie91/b207efcfc6ace64f0f41) shows how `null` and `undefined` relate to each other.
* __In Javascript, braces are optional for single-line statements - however, you should *always* use them.__ [This gist](https://gist.github.com/joepie91/203aaa8e36e1eb958fe7) demonstrates why.
* __Asynchronous execution in Javascript is normally implemented using CPS.__ This stands for "continuation-passing style", and [this](https://gist.github.com/joepie91/977c966cb0d6c15690b0) shows an example of how that works.
* __However, in practice, you shouldn't use that, and you should use Promises instead.__ Whereas it is very easy to mess up CPS code, that is not an issue with Promises - error handling is much more reliable, for example. [This guide](https://gist.github.com/joepie91/791640557e3e5fd80861) should give you a decent introduction.
* __A callback should be either consistently synchronous, or consistently asynchronous.__ You don't really have to worry about this when you're using Promises (as they ensure that this is consistent), but [this article](http://blog.izs.me/post/59142742143/designing-apis-for-asynchrony) still has a good explanation of the reasons for this. A simpler example can be found [here](https://gist.github.com/joepie91/98576de0fab7badec167).
* __Javascript does not have classes, and constructor functions are a bad idea.__ [This short article](https://hughfdjackson.com/javascript/prototypes-the-short(est-possible)-story/) will help you understand the prototypical OOP model that Javascript uses. [This gist](https://gist.github.com/joepie91/22fb5cd443517566412b) shows a brief example of what the `this` variable refers to. Often you don't need inheritance at all - [this gist](https://gist.github.com/joepie91/657f2b4b054d90aa0c87) shows an example of creating an object in the simplest possible way.
* __In Javascript, closures are everywhere, by default.__ [This gist](https://gist.github.com/joepie91/cb0e42c3562bc94e4491) shows an example.

## The Node.js platform

Node.js is not a language. Rather, it's a "runtime" that lets you run Javascript without a browser. It comes with some basic additions such as a TCP library - or rather, in Node.js-speak, a "TCP module" - that you need to write server applications.

* __The easiest way to install Node.js on Linux and OS X, is to use `nvm`.__ The instructions for that can be found [here](https://github.com/creationix/nvm/blob/master/README.markdown). Make sure you create a `default` alias (as explained in the documentation), if you want it to work like a 'normal' installation.
* __If you are using Windows:__ You can download an installer from [the Node.js website](https://nodejs.org/en/). You should consider using a different operating system, though - Windows is generally rather poorly suited for software development outside of .NET. Things will be a lot easier if you use Linux or OS X.
* __The package manager you'll use for Node.js, is called NPM.__ While it's very simple to use, it's not particularly well-documented. [This article](https://gist.github.com/joepie91/9b9dbd8c9ac3b55a65b2) will give you an introduction to it.
* __Don't hesitate to add dependencies, even small ones!__ Node.js and NPM are specifically designed to make this possible without running into issues, and you will get big benefits from doing so. [This post](https://github.com/sindresorhus/ama/issues/10#issuecomment-117766328) explains more about that.
* __The module system is very simple.__ [The Node.js documentation explains this further.](https://nodejs.org/api/modules.html)
* __MongoDB is commonly recommended and used with Node.js. It is, however, extremely poorly designed - and you shouldn't use it.__ [This article](http://cryto.net/~joepie91/blog/2015/07/19/why-you-should-never-ever-ever-use-mongodb/) goes into more detail about *why* you shouldn't use it. If you're not sure what to use, use [PostgreSQL](http://www.postgresql.org/).
* The rest of the documentation for all the modules included with Node.js, can be found [here](https://nodejs.org/api/).

## Setting up your environment

* __To be able to install "native addons" (compiled C++ modules), you need to take some additional steps.__ If you are on Linux or OS X, you likely already have everything you need - however, on Windows you'll have to install a few additional pieces of software. The instructions for all of these platforms can be found [here](https://github.com/nodejs/node-gyp#installation). __Do not skip this step.__ Installing pure-Javascript modules is not always a viable solution, especially where it concerns cryptography-related modules such as `scrypt` or `bcrypt`.
* __If you're running into issues on Windows,__ try [these instructions](https://github.com/Microsoft/nodejs-guidelines/blob/master/windows-environment.md#compiling-native-addon-modules) from Microsoft.

## Functional programming

Javascript has part of its roots in functional programming languages, which means that you can use some of those concepts in your own projects. They can be greatly beneficial to the readability and maintainability of your code.

* [This article](http://cryto.net/~joepie91/blog/2015/05/04/functional-programming-in-javascript-map-filter-reduce/) gives an introduction to `map`, `filter` and `reduce` - three functional programming operations that help a *lot* in writing maintainable and predictable code.
* [This gist](https://gist.github.com/joepie91/34742045a40f7c48430e) shows an example of using those with Bluebird, the Promises library that I recommended in the Promises Reading Guide.
* [This slide deck](http://slides.com/gsklee/functional-programming-in-5-minutes) demonstrates currying in Javascript, another functional programming technique - think of them as "partially executed functions".

## Module patterns

To build "configurable" modules, you can use a pattern known as "parametric modules". [This gist](https://gist.github.com/joepie91/83a8e03ad931e696df22) shows an example of that. [This](https://gist.github.com/joepie91/9b1ca2392a72e82b44fb) is another example.

A commonly used pattern is the `EventEmitter` - this is exactly what it sounds like; an object that emits events. It's a very simple abstraction, but helps greatly in writing [loosely coupled](https://en.wikipedia.org/wiki/Loose_coupling) code. [This gist](https://gist.github.com/joepie91/82df4eff6956089e3fbf) illustrates the object, and the full documentation can be found [here](https://nodejs.org/api/events.html).

## Code architecture

The 'design' of your codebase matters a lot. Certain approaches for solving a problem work better than other approaches, and each approach has its own set of benefits and drawbacks. Picking the right approach is important - it will save you hours (or days!) of time down the line, when you are maintaining your code.

I'm still in the process of writing more about this, but so far, I've already written an article that explains the difference between monolithic and modular code and why it matters. You can read it [here](https://gist.github.com/joepie91/7f03a733a3a72d2396d6).

## Express

If you want to build a website or web application, you'll probably find [Express](http://expressjs.com/) to be a good framework to start with. As a framework, it is *very* small. It only provides you with the basic necessities - everything else is a plugin.

If this sounds complicated, don't worry - things almost always work "out of the box". Simply follow the `README` for whichever "middleware" (Express plugin) you want to add.

To get started with Express, simply follow the below articles. Whatever you do, don't use the Express Generator - it generates confusing and bloated code. Just start from scratch and follow the guides!

* [Installing Express](http://expressjs.com/en/starter/installing.html) (some of this was already covered in the NPM guide above)
* [A Hello World example](http://expressjs.com/en/starter/hello-world.html)
* [Routing](http://expressjs.com/en/guide/routing.html)
* [Using template engines](http://expressjs.com/en/guide/using-template-engines.html)
* [Writing Middleware](http://expressjs.com/en/guide/writing-middleware.html)
* [Using Middleware](http://expressjs.com/en/guide/using-middleware.html)
* [Static File Handling](http://expressjs.com/en/starter/static-files.html) (this is middleware, too!)
* [Error Handling](http://expressjs.com/en/guide/error-handling.html)
* [Debugging](http://expressjs.com/en/guide/debugging.html)

To get a better handle on how to render pages server-side with Express:

* [Rendering pages server-side with Express (and Pug)](https://gist.github.com/joepie91/c0069ab0e0da40cc7b54b8c2203befe1) (a step-by-step walkthrough, work in progress)

Some more odds and ends regarding about Express:

* [Some FAQs](http://expressjs.com/en/starter/faq.html) (don't use MVC, however - [this is why](http://aredridel.dinhe.net/2015/01/30/why-mvc-does-not-fit-the-web/).)
* [Express Behind Proxies](http://expressjs.com/en/guide/behind-proxies.html)
* [The full Express API documentation](http://expressjs.com/en/4x/api.html)

Some examples:

* [Making something "globally available" in an Express application](https://gist.github.com/joepie91/a8270b0b7a1a433032a2)
* [Writing configurable middleware](https://gist.github.com/joepie91/7f531cc7fa7245e68cc8) (using the same technique as the parametric modules I showed earlier)

Combining Express and Promises:

* [A short article explaining how to use `express-promise-router`](http://cryto.net/~joepie91/blog/2015/05/14/using-promises-bluebird-with-express/)
* [An example](https://gist.github.com/joepie91/e4cd0f2c84ea2f303bb2), also explaining what would happen if you didn't handle errors.

Some common Express middleware that you might want to use:

* __Sessions:__ [express-session](https://www.npmjs.com/package/express-session), with [connect-session-knex](https://www.npmjs.com/package/connect-session-knex) if you are using Knex.
* __Message flashing:__ [connect-flash](https://www.npmjs.com/package/connect-flash)
* __Handling request payloads ("form/POST data"):__ [body-parser](https://www.npmjs.com/package/body-parser)
* __Handling uploads and other multipart data:__ [multer](https://www.npmjs.com/package/multer) if you want it written to disk like PHP would do, or [connect-busboy](https://www.npmjs.com/package/connect-busboy) if you want to interact with the upload stream directly.
* __Access logs:__ [morgan](https://www.npmjs.com/package/morgan)
* __OAuth/OpenID integration:__ [Passport](http://passportjs.org/)

## Coming from other languages or platforms

* __If you are used to PHP or similar:__ Contrary to PHP, Node.js does *not* use a CGI-like model (ie. "one pageload is one script"). Instead, it is a persistent process - your code *is* the webserver, and it handles many incoming requests at the same time, for as long as the process keeps running. This means you can have persistent state - [this gist](https://gist.github.com/joepie91/bf0813626e6568e8633b) shows an example of that.
* __If you are used to synchronous platforms:__ [This gist](https://gist.github.com/joepie91/dc67316d2a22f321d1a1) illustrates the differences between a (synchronous) PHP script and an (asynchronous) Node.js application.

## Security

Note that this advice isn't necessarily complete. It answers some of the most common questions, but your project might have special requirements or caveats. When in doubt, you can always ask in the #Node.js channel!

Also, keep in mind the golden rule of security: humans *suck* at repetition, regardless of their level of competence. __If a mistake *can* be made, then it *will* be made.__ Design your systems such that they are hard to use incorrectly.

* __Sessions:__ Use something that implements session cookies. If you're using Express, [express-session](https://www.npmjs.com/package/express-session) will take care of this for you. Whatever you do, __don't use JWT for sessions__, even if many blog posts recommend it - it will cause security problems. [This article](http://cryto.net/~joepie91/blog/2016/06/13/stop-using-jwt-for-sessions/) goes into more detail.
* __Password hashing:__ Use `scrypt`. [This wrapper module](https://www.npmjs.com/package/scrypt-for-humans) will make it easier to use.
* __CSRF protection:__ You need this if you are building a website. Use [csurf](https://www.npmjs.com/package/csurf).
* __XSS:__ Every good templater will escape output by default. __Only__ use templaters that do this (such as [Jade](http://jade-lang.com/) or [Nunjucks](https://mozilla.github.io/nunjucks/))! If you need to explicitly escape things, you should consider it insecure - it's too easy to forget to do this, and is practically guaranteed to result in vulnerabilities.
* __SQL injection:__ Always use parameterized queries. When using MySQL, use the `node-mysql2` module instead of the `node-mysql` module - the latter doesn't use real parameterized queries. Ideally, use something like [Knex](http://knexjs.org/), which will also prevent many other issues, and make your queries much more readable and maintainable.
* __Random numbers and values:__ Generating unpredictable random numbers is a lot harder than it seems. `Math.random()` will generate numbers that may *seem* random, but are actually quite predictable to an attacker. If you need random values, read [this article](https://gist.github.com/joepie91/7105003c3b26e65efcea63f3db82dfba) for recommendations. It also goes into more detail about the types of "randomness" that exist.
* __Cryptography:__ Follow the suggestions in [this gist](https://gist.github.com/tqbf/be58d2d39690c3b366ad). Whatever you do, __do not use the `crypto` module directly__, unless you really have no other choice. Never use pure-Javascript reimplementations - always use bindings to the original implementation, where possible (in the form of native addons).
* __Vulnerability advisories:__ The Node Security Project keeps track of [known vulnerabilities](https://nodesecurity.io/advisories) in Node.js modules. Services like [VersionEye](https://www.versioneye.com/) will e-mail you, if your project uses a module that is found vulnerable.

## Useful modules:

This is an incomplete list, and I'll probably be adding stuff to it in the future.

* __Determining the type of a value:__ [type-of-is](https://www.npmjs.com/package/type-of-is)
* __Date/time handling:__ [Moment.js](http://momentjs.com/)
* __Making HTTP requests:__ [bhttp](https://www.npmjs.com/package/bhttp)
* __Clean debugging logs:__ [debug](https://www.npmjs.com/package/debug)
* __Cleaner stacktraces and errors:__ [pretty-error](https://www.npmjs.com/package/pretty-error)
* __Markdown parsing:__ [marked](https://www.npmjs.com/package/marked)
* __HTML parsing:__ [cheerio](https://www.npmjs.com/package/cheerio) (has a jQuery-like API)
* __WebSockets:__ [ws](https://www.npmjs.com/package/ws)

## Deployment

* __Don't run Node.js as root, ever!__ If you want to expose your service at a privileged port (eg. port 80), and you probably do, then you can use [authbind](https://thomashunter.name/blog/using-authbind-with-node-js/) to accomplish that safely.

## Distribution

* __Your project is ready for release!__ But... you should still pick a license. [This article](http://cryto.net/~joepie91/blog/2013/03/21/licensing-for-beginners/) will give you a very basic introduction to copyright, and the different kind of (common) licenses you can use.

## Scalability

__Scalability is a result of your application architecture, not the technologies you pick.__ Be wary of anything that claims to be "scalable" - it's much more important to write loosely coupled code with small components, so that you can split out responsibilities across multiple processes and servers.

## Troubleshooting

Is something not working properly? Here are some resources that might help:

* Is `npm install` causing an error? Use [this error explaining tool](http://cryto.net/why-is-npm-broken/) to find out what's wrong.
* `DeprecationWarning: Using Buffer without `new` will soon stop working.` - the solution for this can be found [here](https://gist.github.com/joepie91/a0848a06b4733d8c95c95236d16765aa).

## Optimization

The first rule of optimization is: __do not optimize.__

The correct order of concerns is security first, then maintainability/readability, and *then* performance. Optimizing performance is something that you shouldn't care about, until you have *hard metrics* showing you that it is needed. If you can't show a performance problem in numbers, it doesn't exist; while it is easy to optimize readable code, it's much harder to make optimized core more readable.

There is one exception to this rule: *never* use any methods that end with `Sync` - these are blocking, synchronous methods, and will block your event loop (ie. your entire application) until they have completed. They may look convenient, but they are not worth the performance penalty.

Now let's say that you *are* having performance issues. Here are some articles and videos to learn more about how optimization and profiling works in Node.js / V8 - they are going to be fairly in-depth, so you may want to hold off on reading these until you've gotten some practice with Node.js:

* [Common causes of deoptimization](https://github.com/petkaantonov/bluebird/wiki/Optimization-killers)
* [Monomorphism, and why it is important](http://mrale.ph/blog/2015/01/11/whats-up-with-monomorphism.html)
* [Tuning Node.js](https://www.youtube.com/watch?v=FXyM1yrtloc)
* [A tour of V8: object representation](http://jayconrod.com/posts/52/a-tour-of-v8-object-representation)
* [Node.js in flames](http://techblog.netflix.com/2014/11/nodejs-in-flames.html)
* [Realtime Node.js App: A Stress Testing Story (using Socket.IO)](https://bocoup.com/weblog/node-stress-test-analysis)
* A bigger list of resources about V8 optimization and internals can be found [here](http://mrale.ph/v8/resources.html).

These are some modules that you may find useful for profiling your application:

* __[node-inspector](https://www.npmjs.com/package/node-inspector):__ Based on Chrome Developer Tools, this tool gives you many features, including CPU and heap profiling. Also useful for debugging in general. __Since Node.js v6.3.0, you can also [connect directly](https://www.reddit.com/r/node/comments/4yoane/in_case_you_have_missed_it_node_v630_came_out/) using Chrome Developer Tools.__
* __[heapdump](https://www.npmjs.com/package/heapdump):__ On-demand heap dumps, for later analysis. Usable from application code *in production*, so very useful for making a heap dump the moment your application goes over a certain heap size.
* __[memwatch-next](https://www.npmjs.com/package/memwatch-next):__ Provides memory leak detection, and heap diffing.

## Writing C++ addons

You'll usually want to avoid this - C++ is not a memory-safe language, so it's much safer to just write your code in Javascript. V8 is rather well-optimized, so in most cases, performance isn't a problem either. That said, sometimes - eg. when writing bindings to something else - you just *have* to write a native module.

These are some resources on that:

* [The addon documentation](https://nodejs.org/api/addons.html)
* [`nan`, an abstraction layer for making your module work across Node.js versions](https://www.npmjs.com/package/nan) (you should absolutely use this)
* [`node-gyp`, the build tool you will need for this purpose](https://github.com/nodejs/node-gyp)
* [V8 API documentation for every supported Node.js version](http://v8dox.com/)

## Writing Rust addons

Neon is a new project that lets you write __memory-safe compiled extensions__ for Node.js, using Rust. It's still pretty new, but quite promising - an introduction can be found [here](http://calculist.org/blog/2015/12/23/neon-node-rust/).

## Odds and ends

Some miscellaneous code snippets and examples, that I haven't written a section or article for yet.

* __Named logging in Gulp:__ https://gist.github.com/joepie91/e7d66ffdb17d1ea69c56
* __Cached image:__ https://gist.github.com/joepie91/cee42198b6bc6a24ea44
* __Combining Gulp and Electron:__ https://gist.github.com/joepie91/f81cdbc1b45d52ab4b87

## Future additions to this list

There are a few things that I'm currently working on documenting, that will be added to this list in the future. I write new documentation as I find the time to do so.

* __Node.js for PHP developers__ (a migration guide) - In progress.
* __A comprehensive guide to Promises__ - Planned.
* __A comprehensive guide to streams__ - Planned.
* __Error handling mechanisms and strategies__ - Planned.
* __Introduction to HTTP__ - Planned.
* __Writing a secure authentication system__ - Planned.
* __Writing abstractions__ - Planned.
