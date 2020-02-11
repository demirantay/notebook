# Engineering Principles

- Table of contents:
  - [DRY](#DRY–Don’t-Repeat-Yourself)
  - [KISS](#KISS–Keep-It-Simple-Stupid)
  - [YAGNI](#YAGNI–YouAren’tGonnaNeedIt)
 

### DRY – Don’t Repeat Yourself

- DRY refers to code writing methodology. DRY usually refers to code duplication. If we write the same logic more than once, we should “DRY up our code.”

  A common way to DRY up code is to wrap our duplicated logic with a function and replace all places it appears with function calls.

### KISS – Keep It Simple Stupid

- Keeping it simple surpsingly hard. Usually when someone tries to over-engineer a soluiton to a problem. For example an Architect suggests creating a Microservice framework for a simple website. The Engineer will then say: “Let’s KISS it and do something simpler”.

  Another rule of thumb is whenever you think to yourself “Finally I’m going to use something from my Computer Science degree,” you should probably KISS it.

### YAGNI – You Aren’t Gonna Need It

- A step brother of KISS. Part of keeping it simple is not adding modules, frameworks and dependencies we don’t actually need.

  Let’s Imagine you’re working on a simple prototype to show to a client.

  You decide to develop it in React because you read a cool blog post about it. You then find yourself comparing flux implementations, and deciding to go with Redux. You also need webpack to process JSX for React, naturally.
  
  You decide to setup a small nodejs server to serve your files. You add Socket.IO just in case you’ll need real-time notifications for whatever reason.

  You finish your prototype, which is essentially turned out to be a glorified web page to show a concept for your product manager. You later find out your product manager took a screenshot of the page and put it on a slide.

  We didn’t really need React + Redux + Socket.IO for a screenshot now did we?

### TDD – Test Driven Development

### SOLID Principles

### BDUF – Big Design Up Front

### SOC – Separation of Concerns
  
