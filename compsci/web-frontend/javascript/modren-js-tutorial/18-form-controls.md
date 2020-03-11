## Form properties and methods

- Forms and control elements, such as <input> have a lot of special properties and events.
  
  Form navigation:
  - `document.forms` -- A form is available as document.forms[name/index].
  - `form.elements` -- Form elements are available as form.elements[name/index], or can use just form[name/index]. The elements property also works for <fieldset>.
  - `element.form` -- Elements reference their form in the form property.
  - Value is available as `input.value`, `textarea.value`, `select.value` etc, or `input.checked` for checkboxes and radio buttons.
  - For `<select>` we can also get the value by the index `select.selectedIndex` or through the options collection `select.options`.
  - These are the basics to start working with forms, there are much mroe check the docs

<br>
<br>

## Focusing: focus/blur

- An element receives a focus when the user either clicks on it or uses the Tab key on the keyboard. There’s also an `autofocus` HTML attribute that puts the focus into an element by default when a page loads and other means of getting a focus.

  Focusing on an element generally means: “prepare to accept the data here”, so that’s the moment when we can run the code to initialize the required functionality.
  
  The moment of losing the focus (“blur”) can be even more important. That’s when a user clicks somewhere else or presses Tab to go to the next form field, or there are other means as well.
  
  Losing the focus generally means: “the data has been entered”, so we can run the code to check it or even to save it to the server and so on.
  
- To sum up:
  - Events `focus` and `blur` trigger on focusing/losing focus on the element.
    
    Their specials are:
    - They do not bubble. Can use capturing state instead or `focusin/focusout`.
    - Most elements do not support focus by default. Use `tabindex` to make anything focusable.
    - The current focused element is available as `document.activeElement`.

<br>
<br>

## Events: change, input, cut, copy, paste

- Let’s cover various events that accompany data updates.

  Data change events:
  - `change` -- desc: A value was changed. -- For text inputs triggers on focus loss.
  - `input` -- desc: 	For text inputs on every change. -- Triggers immediately unlike "change".
  - `cut/copy/paste	` -- desc: Cut/copy/paste actions. -- The action can be prevented. The event.clipboardData property gives read/write access to the clipboard.

<br>
<br>

## Forms: event and method submit

- The `submit` event triggers when the form is submitted, it is usually used to validate the form before sending it to the server or to abort the submission and process it in JavaScript.

  There are two main ways to submit a form:
  - The first – to click `<input type="submit">`">.
  - The second – press Enter on an input field.
  
  Both actions lead to `submit` event on the form. The handler can check the data, and if there are errors, show them and call `event.preventDefault()`, then the form won’t be sent to the server.
