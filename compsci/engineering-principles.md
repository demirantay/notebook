# Engineering Principles

- Table of contents:
  - [DRY](#DRY–Dont-Repeat-Yourself)
  - [KISS](#KISS–Keep-It-Simple-Stupid)
  - [YAGNI](#YAGNIYouArentGonnaNeedIt)
  - [TDD]()
  - [SOLID]()
  - [BDUF]()
  - [SOC]()
 

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

- Test Drive Development is the equivalent of eating all your veggies and exercising 3 times a week. Its good for you and everyone should be doing it. TDD can be summed in 4 steps:
  - 1 - Decide on the desired functionality
  - 2 - Create the test for that functionality first. The test fails since no code exists yet.
  - 3 - Write the code that implements the desired functionality. The test now passes.
  - 4 - Repeat
  
  There are many studies that show this way of writing code is much more effiecient than the other way. Writing tests first ensures near 100% test code coverage. You’ll spend more time coding and less time debugging future errors But like excercising regularly and eating veggies, few of us actually do it.

### SOLID Principles

- Principles
  - `S` : Single Responsibility Principle 
  - `O` : Open-Closed Principle
  - `L` : Liskov Substitution Principle
  - `I` : Interface Segregation Principle
  - `D` : Dependency Inversion Principle
  
- `Single Responsibility Principle ` -- Very similar to Unix’s “Do one thing and do it well”. This one is easy to comprehend but harder to implement. Every function you write should do exactly one thing. It should have one clearly defined goal.

  You’ll be surprised at the number of times you would like your function to do more than “one thing”. You’ll also struggle repeatedly with defining what the “one thing” you want to do is.

- `Open-Closed Principle` --  Meaning that if someone wants to extend our module’s behavior, they won’t need to modify existing code if they don’t want to.

- `Liskov Substitution Principle` --  A great example illustrating LSP (given by Uncle Bob in a podcast I heard recently) was how sometimes something that sounds right in natural language doesn't quite work in code. [to read more read this](https://stackoverflow.com/questions/56860/what-is-an-example-of-the-liskov-substitution-principle#answer-584732)

- `Interface Segregation Principle` -- Interface segregation actually means you shouldn’t create bloated interfaces. The lesson here is whenever you expose a module for outside use, make sure only the bare essentials are required and the rest are optional.

- `Dependency Inversion Principle` -- Didn't get it at this point. Search stackoverflow or something

### BDUF – Big Design Up Front

- This is a relic from the waterfall era before everyone became cool and Agile.

  This acronym is here to remind us not get over carried with super complex architecture. We shouldn’t spend 3 months designing our application before even writing the first line of code. Start small and iterate. BDUF is basically what happens when you don’t KISS and end up with a lot of stuff which YAGNI.

### SOC – Separation of Concerns
  
- Another something we need to keep reminder ourselves is to do just one thing. As developers we apparently want to “do all the things” with every function, class or object we create. In Unix, this is referred to in the mantra “do one thing well”. It’s also the first SOLID Principle – “Single Responsibility Principle.”

  Either way, it’s really important to remember that every construct you create will do just one thing.

  There’s a reason there are so many different ways of reminding you to do just one thing. A lot of times you believe you’re doing just the one thing, but you then realize you can divide that one thing into several other smaller thin
