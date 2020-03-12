## Page: DOMContentLoaded, load, beforeunload, unload

- The lifecycle of an HTML page has three important events:
  - `DOMContentLoaded` – the browser fully loaded HTML, and the DOM tree is built, but external resources like pictures <img> and stylesheets may be not yet loaded.
  - `load` – not only HTML is loaded, but also all the external resources: images, styles etc.
  - `beforeunload/unload` – the user is leaving the page.
  
  Each event may be useful:
  - `DOMContentLoaded event` – DOM is ready, so the handler can lookup DOM nodes, initialize the interface.
  - `load event` – external resources are loaded, so styles are applied, image sizes are known etc.
  - `beforeunload` event – the user is leaving: we can check if the user saved the changes and ask them whether they really want to leave.
  - `unload` – the user almost left, but we still can initiate some operations, such as sending out statistics.


- To sum up: Page load events:
  - The `DOMContentLoaded` event triggers on `document` when the DOM is ready. We can apply JavaScript to elements at this stage.
    - Script such as `<script>...</script>` or `<script src="..."></script>` block DOMContentLoaded, the browser waits for them to execute.
    - Images and other resources may also still continue loading.
  - The `load` event on `window` triggers when the page and all resources are loaded. We rarely use it, because there’s usually no need to wait for so long.
  - The `beforeunload` event on `window` triggers when the user wants to leave the page. If we cancel the event, browser asks whether the user really wants to leave (e.g we have unsaved changes).
  - The `unload event` on `window` triggers when the user is finally leaving, in the handler we can only do simple things that do not involve delays or asking a user. Because of that limitation, it’s rarely used. We can send out a network request with `navigator.sendBeacon`.
  - `document.readyState` is the current state of the document, changes can be tracked in the `readystatechange` event:
    - `loading` – the document is loading.
    - `interactive` – the document is parsed, happens at about the same time as `DOMContentLoaded`, but before it.
    - `complete` – the document and resources are loaded, happens at about the same time as `window.onload`, but before it.

<br>
<br>

## Scripts: async, defer

- Both `async` and `defer` have one common thing: downloading of such scripts doesn’t block page rendering. So the user can read page content and get acquainted with the page immediately.

  But there are also essential differences between them:
  
  - `async` -- order: Load-first order. Their document order doesn’t matter – which loads first -- DOMContentLoaded: Irrelevant. May load and execute while the document has not yet been fully downloaded. That happens if scripts are small or cached, and the document is long enough.
  
  - `defer` -- order: Document order (as they go in the document). -- DOMContentLoaded: Execute after the document is loaded and parsed (they wait if needed), right before DOMContentLoaded.

<br>
<Br>

## Resource loading: onload and onerror

- mages `<img>`, external styles, scripts and other resources provide `load` and `error` events to track their loading:
  - `load` triggers on a successful load,
  - `error` triggers on a failed load.
  
  The only exception is `<iframe>`: for historical reasons it always triggers `load`, for any load completion, even if the page is not found.
  
  The `readystatechange` event also works for resources, but is rarely used, because `load/error` events are simpler.
