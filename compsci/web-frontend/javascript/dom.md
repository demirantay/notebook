## DOM api

- When a web page is loaded the browser creates Document Object Model(DOM) of the page. You can accsess it via api with your javascript but luckily the api is built in so you do not have to download any package

- Lets first view a example where we change the inner html of a object with javascript:
  ```html
  <html>
    <body>
      <p id="foo"></p>
      
      <script>
         document.getElementById("foo").innerHTML = "Hello World!";
      </script>
    </body>
  </html>
  ```
  You can do many things such as `document.getElementByTagName()` or `document.getElementByClassName()` and there are many other things to do with those selections such as change the inner html, `attirbute` , `setAttiribute`, `style.property` there many other properties see the reference for it. [reference](https://www.w3schools.com/jS/js_htmldom.asp)
  
- Before you go to refernece there is one notable thing and it is event listeners: event listeners work when a event happens on the site which is like a element is cliked or the page has loaded or th einputs fields are changed:
  ```html
  <h1 id="id1">My Heading 1</h1>

  <button type="button" onclick="document.getElementById('id1').style.color = 'red'">Click Me!</button>
  ```

You can view more about DOM in the [REFERENCE HERE](https://www.w3schools.com/jS/js_htmldom.asp)
