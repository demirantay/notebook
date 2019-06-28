# Object Oriented Programming with Python

- With the basics out of the way, we'll now focus on object-oriented JavaScript (OOJS) — this article presents a basic view of object-oriented programming (OOP) theory, then explores how JavaScript emulates object classes via constructor functions, and how to create object instances.

<br>
<br>

# Basics 

- Let's explore creating classes via constructors and creating object instances from them in JavaScrip. JavaScript provides us with a handy shortcut, in the form of constructor functions — let's make one now! The syntax of creating classes in javascript is a bit off since instead of the keyword `class` the classes are defined insiede `function`s however the logic behind is the same:
  ```javascript
  function Person(param_name, param_age) {
  
    // object vars
    this.name = param_name;
    this.age = param_age;
    
    //object funcs
    this.str = function() {
      return "Name: " + this.name + ", age: " + this.age;
    };
  }
  ```
  And you can create this class with:
  ```javascript
  var person1 = new Person('bob', 18);
  var person2 = new Person('jess', 25);
  
  person1.str();
  person2.str();
  ```

- You can create object instances with a lot of different ways but I am not going to note them down since the one above is the most common and readable one.


### Inheritance

- So instead of expalining a lot with text lets just dive straight into the action. We will try to create a `techer` class that inheirts the `person` class we defined above:
  ```javascript
  function Teacher(name, age, teaching_subject) {
    
    Person.call(this, name, age)
  
    this.teaching_subject = teaching_sbuject;
  }
  ```
  This looks similar to the Person constructor in many ways, but there is something strange here that we've not seen before — the `call()` function. This function basically allows you to call a function defined somewhere else, but in the current context. The first parameter specifies the value of `this` that you want to use when running the function, and the other parameters are those that should be passed to the function when it is invoked.

- Note that if the constructor you are inheriting from doesn't take its property values from parameters, you don't need to specify them as additional arguments in call(). So, for example,  if you had something really simple like this:
  ```javascript
  function Brick() {
    this.width = 10;
    this.height = 10;
  }
  ```
  You could inherit the width and height properties by doing this (as well as the other steps described below, of course):
  ```javascript
  function BlueGlassBrick() {
    Brick.call(this);

    this.opacity = 0.5;
    this.color = 'blue';
  }
  ```

---

There are lots of things to learn about OOP with javascript. I didnt even touch polymorphism, the rest of inheritacne ... etc. However since I am not using javascript very ofter at the moment I will skip this section. If I need to use it I will edit this note file in the future








--- 

- Resource:
  - https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Objects/Object-oriented_JS
