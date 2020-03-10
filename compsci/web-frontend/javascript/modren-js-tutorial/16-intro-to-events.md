## Introduction to browser events

- There are 3 ways to assign event handlers:
  - 1 - HTML attribute: `onclick="..."`.
  - 2 - DOM property: `elem.onclick = function`.
  - 3 - Methods: `elem.addEventListener(event, handler[, phase])` to add, `removeEventListener` to remove.
- HTML attributes are used sparingly, because JavaScript in the middle of an HTML tag looks a little bit odd and alien. Also can’t write lots of code in there.
  
  DOM properties are ok to use, but we can’t assign more than one handler of the particular event. In many cases that limitation is not pressing.
  
  The last way is the most flexible, but it is also the longest to write. There are few events that only work with it, for instance `transtionend` and `DOMContentLoaded` (to be covered). Also `addEventListener` supports objects as event handlers. In that case the method `handleEvent` is called in case of the event.
  
  No matter how you assign the handler – it gets an event object as the first argument. That object contains the details about what’s happened.
  
- Here’s a list of the most useful DOM events, just to take a look at:
  
  Mouse Events:
  - `click` – when the mouse clicks on an element (touchscreen devices generate it on a tap).
  - `contextmenu` – when the mouse right-clicks on an element.
  - `mouseover / mouseout` – when the mouse cursor comes over / leaves an element.
  - `mousedown / mouseup` – when the mouse button is pressed / released over an element.
  - `mousemove` – when the mouse is moved.
  
  Form element events:
  - `submit` – when the visitor submits a <form>.
  - `focus` – when the visitor focuses on an element, e.g. on an <input>.
  
  Keyboard events:
  - `keydown` and `keyup` – when the visitor presses and then releases the button.
  
  Document events:
  - `DOMContentLoaded` – when the HTML is loaded and processed, DOM is fully built.
  
  CSS events:
  - `transitionend` – when a CSS-animation finishes.

<Br>
<br>
  
## Bubbling and capturing

- When an event happens – the most nested element where it happens gets labeled as the “target element” (`event.target`).
  - Then the event moves down from the document root to `event.target`, calling handlers assigned with `addEventListener(...., true`) on the way (`true` is a shorthand for `{capture: true}`).
  - Then handlers are called on the target element itself.
  - Then the event bubbles up from `event.target` up to the root, calling handlers assigned using `on<event>` and `addEventListener` without the 3rd argument or with the 3rd argument `false/{capture:false}`.
  
- Each handler can access `event` object properties:
  - `event.target` – the deepest element that originated the event.
  - `event.currentTarget (=this)` – the current element that handles the event (the one that has the handler on it)
  - `event.eventPhase` – the current phase (capturing=1, target=2, bubbling=3).
  
  Any event handler can stop the event by calling event.stopPropagation(), but that’s not recommended, because we can’t really be sure we won’t need it above, maybe for completely different things.
  
  The capturing phase is used very rarely, usually we handle events on bubbling. And there’s a logic behind that. In real world, when an accident happens, local authorities react first. They know best the area where it happened. Then higher-level authorities if needed.
  
  The same for event handlers. The code that set the handler on a particular element knows maximum details about the element and what it does. A handler on a particular <td> may be suited for that exactly <td>, it knows everything about it, so it should get the chance first. Then its immediate parent also knows about the context, but a little bit less, and so on till the very top element that handles general concepts and runs the last
  
  Bubbling and capturing lay the foundation for “event delegation” – an extremely powerful event handling pattern.

<br>
<br>

## Event delegation

- Event delegation is really cool! It’s one of the most helpful patterns for DOM events.
  
  It’s often used to add the same handling for many similar elements, but not only for that.
  
  The algorithm:
  - 1 - Put a single handler on the container.
  - 2 - In the handler – check the source element `event.target`.
  - 3 - If the event happened inside an element that interests us, then handle the event.
  
  Benefits:
  - Simplifies initialization and saves memory: no need to add many handlers.
  - Less code: when adding or removing elements, no need to add/remove handlers.
  - DOM modifications: we can mass add/remove elements with innerHTML and the like.
  
  The delegation has its limitations of course:
  - First, the event must be bubbling. Some events do not bubble. Also, low-level handlers should not use event.stopPropagation().
  - Second, the delegation may add CPU load, because the container-level handler reacts on events in any place of the container, no matter whether they interest us or not. But usually the load is negligible, so we don’t take it into account.

<br>
<br>

## Browser default actions

- There are many default browser actions:
  - `mousedown` – starts the selection (move the mouse to select).
  - `click` on `<input type="checkbox">` – checks/unchecks the input.
  - `submit` – clicking an `<input type="submit">` or hitting Enter inside a form field causes this event to happen, and the browser submits the form after it.
  - `keydown` – pressing a key may lead to adding a character into a field, or other actions.
  - `contextmenu` – the event happens on a right-click, the action is to show the browser context menu.
  - …there are more…
  
  All the default actions can be prevented if we want to handle the event exclusively by JavaScript.
  
  To prevent a default action – use either `event.preventDefault()` or `return false`. The second method works only for handlers assigned with `on<event>`.
  
  The `passive: true` option of `addEventListener` tells the browser that the action is not going to be prevented. That’s useful for some mobile events, like `touchstart` and `touchmove`, to tell the browser that it should not wait for all handlers to finish before scrolling.
  
  If the default action was prevented, the value of `event.defaultPrevented` becomes `true`, otherwise it’s `false`.

<bR>
<br>
  
## Dispatching custom events

- We can not only assign handlers, but also generate events from JavaScript.
  
  To generate an event from code, we first need to create an event object.
  
  The generic `Event(name, options)` constructor accepts an arbitrary event name and the options object with two properties:
  - `bubbles: true` if the event should bubble.
  - `cancelable: true` if the `event.preventDefault()` should work.

  Other constructors of native events like `MouseEvent`, `KeyboardEvent` and so on accept properties specific to that event type. For instance, `clientX` for mouse events.
  
  For custom events we should use `CustomEvent` constructor. It has an additional option named `detail`, we should assign the event-specific data to it. Then all handlers can access it as `event.detail`.
  
  Despite the technical possibility to generate browser events like `click` or `keydown`, we should use with the great care.
  
  We shouldn’t generate browser events as it’s a hacky way to run handlers. That’s a bad architecture most of the time.
  
  Native events might be generated:
  - As a dirty hack to make 3rd-party libraries work the needed way, if they don’t provide other means of interaction.
  - For automated testing, to “click the button” in the script and see if the interface reacts correctly.

  Custom events with our own names are often generated for architectural purposes, to signal what happens inside our menus, sliders, carousels etc.
