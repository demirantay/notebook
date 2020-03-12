## Mutation observer

- `MutationObserver` is a built-in object that observes a DOM element and fires a callback in case of changes. `MutationObserver` can react on changes in DOM: attributes, added/removed elements, text content.

  We can use it to track changes introduced by other parts of our code, as well as to integrate with third-party scripts.
  
  `MutationObserver` can track any changes. The config “what to observe” options are used for optimizations, not to spend resources on unneeded callback invocations

<br>
<br>

## Selection and Range

- https://javascript.info/selection-range

<br>
<br>

## Event loop: microtasks and macrotasks

- Browser JavaScript execution flow, as well as in Node.js, is based on an event loop. Understanding how event loop works is important for optimizations, and sometimes for the right architecture. In this chapter we first cover theoretical details about how things work, and then see practical applications of that knowledge.

- To sum up:
  
  The more detailed algorithm of the event loop (though still simplified compare to the specification):
  - 1 - Dequeue and run the oldest task from the macrotask queue (e.g. “script”).
  - 2 - Execute all microtasks:
    - While the microtask queue is not empty:
    - Dequeue and run the oldest microtask.
  - 3 - Render changes if any.
  - 4 - If the macrotask queue is empty, wait till a macrotask appears
  - 5 - Go to step 1.
  
  To schedule a new macrotask:
  - Use zero delayed `setTimeout(f)`.
  
  That may be used to split a big calculation-heavy task into pieces, for the browser to be able to react on user events and show progress between them.
  
  Also, used in event handlers to schedule an action after the event is fully handled (bubbling done).
  
  To schedule a new microtask
  - Use `queueMicrotask(f)`.
  - Also promise handlers go through the microtask queue.
  
  There’s no UI or network event handling between microtasks: they run immediately one after another.
  
  So one may want to queueMicrotask to execute a function asynchronously, but within the environment state.


  
