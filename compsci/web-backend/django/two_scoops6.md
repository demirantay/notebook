# Continuous Integration

- Continuous integration (CI) is one of those things where, to explain the concept, we quote one of its
originators:
  
  Continuous integration is a software development practice where members of a team
integrate their work frequently, usually each person integrates at least daily — leading
to multiple integrations per day. Each integration is verified by an automated build (including test) to detect integration errors as quickly as possible. Many teams find that
this approach leads to significantly reduced integration problems and allows a team to
develop cohesive software more rapidly.

- Here’s a typical development workflow when using continuous integration:
  - 1 Developer writes code, runs local tests against it, then pushes the code to an instance of a code
repository on GitHub or GitLab. This should happen at least once per day
  - 2 The code repository informs an automation tool that a new commit is ready for integration.
  - 3 Automation integrates the code into the project, building out the project. Any failures during
the build process and the commit are rejected.
  - 4 Automation runs developer-authored tests against the new build. Any failures of the tests and
the commit is rejected.
  - 5 The developer is notified of success or the details of failure. Based on the report, the developer
can mitigate the failures. If there are no failures, the developer celebrates and moves to the
next task.

### Principles of Continuous Integration

- `Write Lots of Tests!` --Without comprehensive tests, continuous integration simply
lacks that killer punch

- `Keeping the Build Fast` -- This is a tricky one. Your tests should arguably be running against the same database engine as your
production machine. However, under certain circumstances, tests can take a minute or ten. Once a
test suite takes that long, Continuous Integration stops being advantageous, and starts becoming a
burden.

<br>
<br>
<Br>
  
# Where and How to Ask Django Questions

### What to Do When You’re Stuck

- Follow these steps to increase your chances of success:
  - 1 - Troubleshoot on your own as much as possible.
  - 2 - Read through the documentation in detail, to make sure you didn’t miss something.
  - 3 - See if someone else has had the same issue. Check Google, mailing lists, and StackOverflow
  - 4 - Can’t find anything? Now ask on StackOverflow. Construct a tiny example that illustrates the
problem. Be as descriptive as possible about your environment, the package version that you
installed, and the steps that you took.
  - 5 - Still don’t get an answer after a couple of days? Try asking on the django-users mailing list or
in IRC

### How to Ask Great Django Questions in IRC

- A warning to those who are new to IRC: sometimes when you ask a question in a busy IRC channel,
you get ignored. Sometimes you even get trolled by cranky developers. Don’t get discouraged or take
it personally!

  The IRC #python and #django channels are run entirely by volunteers. You can and should help out
and answer questions there too, whenever you have a few free minutes.

- When you ask something in IRC, be sure that you’ve already done your homework. Use it as
a last resort for when StackOverflow doesn’t suffice

  Paste a relevant code snippet and traceback into gist.github.com (or another pastebin).
  
  Ask your question with as much detail and context as possible. Paste the link to your code snippet/traceback. Be friendly and honest.

### Feed Your Brain

### Insider Tip: Be Active in the Community

  
