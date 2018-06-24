## Testing Python Code

- Testing your code is very important and testing can be a time consuming task. Weather it is automated or manual when your site grows the code you have written will be connected and each addition, update, deletion to your codebase will effect some parts you didnt even think about. In order to eliminate that we run tests and as you can imageine it is really time consuming to test everything by hand so thats why we need to learn automated testing

- There ar enumerous ways of approaching testing but thgese are the most important three:
  - `Unit tests`: Verify functional behavior of individual components, often to class and function level
  - `Regression tests`: Tests that reproduce historic bugs. Each test is intially run to verify that the bug has been fixed, and the re-run to ensure that it has not been reintroudced following later changes to the code.
  - `Integration tests`:  Verify how grouping of compononents work together. Integration tests are aware of the required interactions between compononents, but not necessarily of the internal operations of each component. They may cover the simple groupings of comoponents through the whole website
  
  *Note: Other common types of tests include black box, white box, manual, automated, canary, smoke, conformance, acceptance, functional, system, performance, load, and stress tests. Look them up for more information.*
  
- Some general rules about testing:
  - A testing unit should focus on one tiny bit of functionality and prove it correct.
  - Each test unit must be fully independent. Each test must be able to run alone, and also within the test suite, regardless of the order that they are called. The implication of this rule is that each test must be loaded with a fresh dataset and may have to do some cleanup afterwards. This is usually handled by `setUp()` and `tearDown()` methods.
  - Try hard to make tests that run fast. If one single test needs more than a few milliseconds to run, development will be slowed down or the tests will not be run as often as is desirable
  - Always run the full test suite before a coding session, and run it again after. This will give you more confidence that you did not break anything in the rest of the code.
