## Mouse events basics

- Mouse events have the following properties:
  - Button: `which`.
  - Modifier keys (`true` if pressed): `altKey`, `ctrlKey`, `shiftKey` and `metaKey` (Mac).
    - If you want to handle Ctrl, then don’t forget Mac users, they usually use Cmd, so it’s better to check `if (e.metaKey || e.ctrlKey)`.
  - Window-relative coordinates: `clientX/clientY`.
  - Document-relative coordinates: `pageX/pageY`.
  
  The default browser action of `mousedown` is text selection, if it’s not good for the interface, then it should be prevented.
  

<br>
<Br>

## Moving the mouse: mouseover/out, mouseenter/leave

- We covered events `mouseover`, `mouseout`, `mousemove`, `mouseenter` and `mouseleave`.

  These things are good to note:
  - A fast mouse move may skip intermediate elements.
  - Events `mouseover/out` and `mouseenter/leave` have an additional property: `relatedTarget`. That’s the element that we are coming from/to, complementary to `target`.
  
  Events `mouseover/out` trigger even when we go from the parent element to a child element. The browser assumes that the mouse can be only over one element at one time – the deepest one.
  
  Events `mouseenter/leave` are different in that aspect: they only trigger when the mouse comes in and out the element as a whole. Also they do not bubble.

<br>
<Br>

## Drag'n'Drop with mouse events

- Drag’n’Drop is a great interface solution. Taking something and dragging and dropping it is a clear and simple way to do many things, from copying and moving documents (as in file managers) to ordering (dropping items into a cart).

  In the modern HTML standard there’s a section about Drag and Drop with special events such as `dragstart`, `dragend`, and so on.
  
- To sum up:

  We considered a basic Drag’n’Drop algorithm.
   - 1 - Events flow: `ball.mousedown` → `document.mousemove` → `ball.mouseup` (don’t forget to cancel native `ondragstart`).
   - 2 - At the drag start – remember the initial shift of the pointer relative to the element: `shiftX/shiftY` and keep it during the dragging.
   - 3 - Detect droppable elements under the pointer using `document.elementFromPoint`.
   
   We can lay a lot on this foundation.
   - On `mouseup` we can intellectually finalize the drop: change data, move elements around.
   - We can highlight the elements we’re flying over.
   - We can limit dragging by a certain area or direction.
   - We can use event delegation for `mousedown/up`. A large-area event handler that checks `event.target` can manage Drag’n’Drop for hundreds of elements.
   - And so on. ... check the docs (start reading from here: https://javascript.info/mouse-drag-and-drop)

<bR>
<br>

## Keyboard: keydown and keyup

- Pressing a key always generates a keyboard event, be it symbol keys or special keys like Shift or Ctrl and so on. The only exception is Fn key that sometimes presents on a laptop keyboard. There’s no keyboard event for it, because it’s often implemented on lower level than OS.

  Keyboard events:
  - `keydown` – on pressing the key (auto-repeats if the key is pressed for long),
  - `keyup` – on releasing the key.
  
  Main keyboard event properties:
  - `code` – the “key code” (`"KeyA"`, `"ArrowLeft"` and so on), specific to the physical location of the key on keyboard.
  - `key` – the character (`"A"`, `"a"` and so on), for non-character keys, such as Esc, usually has the same value as `code`.
  
  In the past, keyboard events were sometimes used to track user input in form fields. That’s not reliable, because the input can come from various sources. We have input and change events to handle any input (covered later in the chapter Events: change, input, cut, copy, paste). They trigger after any kind of input, including copy-pasting or speech recognition.
  
  We should use keyboard events when we really want keyboard. For example, to react on hotkeys or special keys.

<br>
<br>

## Scrolling

- The `scroll` event allows to react on a page or element scrolling. There are quite a few good things we can do here.

  For instance:
  - Show/hide additional controls or information depending on where in the document the user is.
  - Load more data when the user scrolls down till the end of the page.
  
  Here’s a small function to show the current scroll:
  ```js
  window.addEventListener('scroll', function() {
    document.getElementById('showScroll').innerHTML = window.pageYOffset + 'px';
  });
  ```
