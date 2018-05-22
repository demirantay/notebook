# Testing in Django

Testing can be a time consuming task. Weather it is automated or manual when your site grows the code you have written will be connected and each addition, update, deletion to your codebase will effect some parts you didnt even think about. In order to eliminate that we run tests and as you can imageine it is really time consuming to test everything by hand so thats why we need to learn automated testing.

### Types of testing

There ar enumerous ways of approaching testing but thgese are the most important three:

- `Unit tests` : Verify functional behavior of individual components, often to class and function level

- `Regression tests` : Tests that reproduce historic bugs. Each test is intially run to verify that the bug has been fixed,
and the re-run to ensure that it has not been reintroudced following later changes to the code.

- `Integration tests` : Verify how grouping of compononents work together. Integration tests are aware of the required interactions between compononents, but not necessarily of the internal operations of each component. They may cover the simple groupings of comoponents through the whole website.
