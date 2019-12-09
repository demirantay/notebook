# The Iportant Elements of UI Engineering

- These notes are from the article : [click here to read](https://overreacted.io/the-elements-of-ui-engineering/) written by dan abramov.

- Whenever you are trying to build a UI application try to code these check points as good and easy to use as possible. Regardless of the tech stack used for the building the checkpoint elements are the important thing to note on this file.

- **Remember these problems are common even in billion dollar companies to small freelance work. Try to have a go to solution for each of them. Even if it does not solve the problem you will have a starter template instead of a blank code file**

<br>

---

- ***Authors Note:*** *If you worked a user interface, you’ve likely dealt with at least some of these challenges — either directly or using a library. In either case, I encourage you to create a tiny app with no libraries, and play with reproducing and solving these problems. There’s no one right solution to any of them. Learning comes from exploring the problem space and trying different possible tradeoffs.*
  
  *Project checkboxes:*
  - [ ] Consistency
  - [ ] Responsivness
  - [ ] Latency
  - [ ] Navigation
  - [ ] Staleness
  - [ ] Entropy
  - [ ] Priority
  - [ ] Accessibility
  - [ ] Internationalization
  - [ ] Delivery
  - [ ] Resilence 
  - [ ] Abstraction

---

<br>

# Consistency

- You click on a “Like” button and the text updates: “You and 3 other friends liked this post.” You click it again, and the text flips back. Sounds easy. But maybe a label like this exists in several places on the screen. Maybe there is some other visual indication (such as the button background) that needs to change. The list of “likers” that was previously fetched from the server and is visible on hover should now include your name. If you navigate to another screen and go back, the post shouldn’t “forget” it was liked. Even local consistency alone creates a set of challenges. But other users might also modify the data we display (e.g. by liking a post we’re viewing). How do we keep the same data in sync on different parts of the screen? How and when do we make the local data consistent with the server, and the other way around?

<br>
<br>
<br>

# Responsiveness

- People can only tolerate a lack of visual feedback to their actions for a limited time. For continuous actions like gestures and scroll, this limit is low. I mean responsiveness is one of the most important featueres of UI development because if your site looks shitty on phones, no one will even spend more than a minute on it. And worlds 70% traffic of web comes through phones.

<br>
<br>
<br>

# Latency

- Both computations and network access take time. Sometimes we can ignore the computational cost if it doesn’t hurt the responsiveness on our target devices (make sure to test your app on the low-end device spectrum). But handling network latency is unavoidable — it can take seconds! Our app can’t just freeze waiting for the data or code to load. This means any action that depends on new data, code, or assets is potentially asynchronous and needs to handle the “loading” case. But that can happen for almost every screen. How do we gracefully handle latency without displaying a “cascade” of spinners or empty “holes”? How do we avoid “jumpy” layout? And how do we change async dependencies without “rewiring” our code every time?

<br>
<br>
<br>

# Navigation

- We expect that the UI remains “stable” as we interact with it. Things shouldn’t disappear from right under our noses. Navigation, whether started within the app (e.g. clicking a link) or due to an external event (e.g. clicking the “back” button), should also respect this principle. For example, switching between /profile/likes and /profile/follows tabs on a profile screen shouldn’t clear a search input outside the tabbed view. Even navigating to another screen is like walking into a room. People expect to go back later and find things as they left them (with, perhaps, some new items). If you’re in the middle of a feed, click on a profile, and go back, it’s frustrating to lose your position in the feed — or wait for it to load again. How do we architect our app to handle arbitrary navigation without losing important context?

<br>
<br>
<br>

# Staleness

- We can make the “back” button navigation instant by introducing a local cache. In that cache, we can “remember” some data for quick access even if we could theoretically refetch it. But caching brings its own problems. Caches can get stale. If I change an avatar, it should update in the cache too. If I make a new post, it needs to appear in the cache immediately, or the cache needs to be invalidated. This can become difficult and error-prone. What if the posting fails? How long does the cache stay in memory? When we refetch the feed, do we “stitch” the newly fetched feed with the cached one, or throw the cache away? How is pagination or sorting represented in the cache?

<br>
<br>
<br>

# Entropy

- The second law of thermodynamics says something like “with time, things turn into a mess” (well, not exactly). This applies to user interfaces too. We can’t predict the exact user interactions and their order. At any point in time, our app may be in one of a mind-boggling number of possible states. We do our best to make the result predictable and limited by our design. We don’t want to look at a bug screenshot and wonder “how did that happen”. For N possible states, there are N×(N–1) possible transitions between them. For example, if a button can be in one of 5 different states (normal, active, hover, danger, disabled), the code updating the button must be correct for 5×4=20 possible transitions — or forbid some of them. How do we tame the combinatorial explosion of possible states and make visual output predictable?

<br>
<br>
<br>

# Priority

- Some things are more important than others. A dialog might need to appear physically “above” the button that spawned it and “break out” of its container’s clip boundaries. A newly scheduled task (e.g. responding to a click) might be more important than a long-running task that already started (e.g. rendering next posts below the screen fold). As our app grows, parts of its code written by different people and teams compete for limited resources like processor, network, screen estate, and the bundle size budget. Sometimes you can rank the contenders on a shared scale of “importance”, like the CSS z-index property. But it rarely ends well. Every developer is biased to think their code is important. And if everything is important, then nothing is! How do we get independent widgets to cooperate instead of fighting for resources?

<br>
<br>
<br>

# Accessibilty

- Inaccessible websites are not a niche problem. For example, in UK disability affects 1 in 5 people. (Here’s a nice infographic.) I’ve felt this personally too. Though I’m only 26, I struggle to read websites with thin fonts and low contrast. I try to use the trackpad less often, and I dread the day I’ll have to navigate poorly implemented websites by keyboard. We need to make our apps not horrible to people with difficulties — and the good news is that there’s a lot of low-hanging fruit. It starts with education and tooling. But we also need to make it easy for product developers to do the right thing. What can we do to make accessibility a default rather than an afterthought?

<br>
<br>
<br>

# Internationalization

- Our app needs to work all over the world. Not only do people speak different languages, but we also need to support right-to-left layouts with the least amount of effort from product engineers. How do we support different languages without sacrificing latency and responsiveness?

<br>
<br>
<br>

# Delivery

- We need to get our application code to the user’s computer. What transport and format do we use? This might sound straightforward but there are many tradeoffs here. For example, native apps tend to load all code in advance at the cost of a huge app size. Web apps tend to have smaller initial payload at the cost of more latency during use. How do we choose at which point to introduce latency? How do we optimize our delivery based on the usage patterns? What kind of data would we need for an optimal solution?

<br>
<br>
<br>

# Resilience

- You might like bugs if you’re an entomologist, but you probably don’t enjoy seeing them in your programs. However, some of your bugs will inevitably get to production. What happens then? Some bugs cause wrong but well-defined behavior. For example, maybe your code displays incorrect visual output under some condition. But what if the rendering code crashes? Then we can’t meaningfully continue because the visual output would be inconsistent. A crash rendering a single post shouldn’t “bring down” an entire feed or get it into a semi-broken state that causes further crashes. How do we write code in a way that isolates rendering and fetching failures and keeps the rest of the app running? What does fault tolerance mean for user interfaces?

<br>
<br>
<br>

# Abstraction

- In a tiny app, we can hardcode a lot of special cases to account for the above problems. But apps tend to grow. We want to be able to reuse, fork, and join parts of our code, and work on it collectively. We want to define clear boundaries between the pieces familiar to different people, and avoid making often-changing logic too rigid. How do we create abstractions that hide implementation details of a particular UI part? How do we avoid re-introducing the same problems that we just solved as our app grows?

