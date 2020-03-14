There's a three step process that I first heard of from Kent Beck. Following these steps when implementing a new feature can help you remain focused on getting the work done, and can avoid falling into the trap of premature optimization.

### THE FIRST STEP: MAKE IT WORK

The first step is to make it work. Since we're talking about software, there is no cost of materials. You can make the code do what it's supposed to do in whatever ugly, messy manner you want, so long as it works. Don't waste time worrying about whether your approach is ideal, your code elegant, or your design patterns perfect. If you can see multiple ways to do something, and you're not sure which is best, pick one and go with it. You can leave a TODO comment or make a note in your notebook that you keep with you as you code if you think it's important enough to revisit. Otherwise, when you're done, be sure it works, and works repeatably. You should have some kind of automated tests that demonstrate that it works. I should probably also note that this process works best with small units of work. In fact, kanban demonstrates that your overall process will be improved if you work on the smallest scoped work items you can. You should be able to follow all three of these steps multiple times per day. If you're spending days or longer just trying to make it work, you need to come up with a smaller "it" and get the reduced scope item to work, first. Then move on to steps two and three before continuing on with the larger scoped work.

### THE SECOND STEP: MAKE IT RIGHT

Once you have a working solution, and an inexpensive way to ensure it remains working while you modify it, follow the refactoring fundamentals to improve your code's design. Look for code smells. Follow software principles. Make sure it's good enough that when you return to it, you'll be able to understand and change it without too much effort (or someone else will be able to do so). Tests serve as a great form of documentation, especially if you name them well. If you think you need more tests, or you need to better organize your tests, this is the time to do so. But stop when you have enough tests that when they're green, you're confident your code does what it should. Don't chase some arbitrary metric beyond this point, when you could be delivering more value in the form of more features or bug fixes.

### THE THIRD STEP: MAKE IT FAST

If it's not fast (in terms of performance) enough already, now is the time to measure and tune the application's performance. Performance characteristics of the system should be described just like other system requirements, and effort should be made on improving performance only until these measurable requirements are met (otherwise, how will you know when you're done?). For some applications, there is great ROI for every small bit of performance improvement. This is true of large, public ecommerce sites like Amazon.com, where they've measured customer cart abandonment levels increasing based on milliseconds of additional latency. However, most applications have less stringent requirements, and in many cases users who have no choice but to use the system for their job. In such cases, you want to provide the user with good enough performance, but remember that beyond good enough is waste. If users don't really notice the difference between 1 second page load times and 800ms page load times, you probably don't need to spend several hours trying to trim 200ms when that time could have been spent fixing a bug that's been plaguing users for weeks.

### SUMMARY

Your key takeaways from this episode should be:

- Work on small pieces of work. For each piece:
- Make it work
- Make it right
- Make it fast

Stop working on the code as soon as it work. Stop cleaning it up and adding tests as soon as you're confident it works and is clean enough to maintain next time someone needs to touch it. Stop tuning its performance as soon as it's good enough. If you follow these steps, you'll stay as productive as possible, you'll ship quality software, and you won't get mired in analysis paralysis or gold plating your code. Check the show notes at weeklydevtips.com/006 for a bunch of links to more information on many of the things I mentioned in this episode.
