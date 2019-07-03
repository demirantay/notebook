- [Part 1](./two_scoops.md)

---

<br>

# Queries and the Database Layer

- Most of the queries we write are simple. Django’s Object-Relational Model or ORM provides a great productivity shortcut: not only generating decent SQL queries for common use cases, but providing model access/update functionality that comes complete with validation and security. It allows us to trivially write code that works with different database engines

- The Django ORM, like any ORM, converts data from different types into objects that we can use
  pretty consistently across supported databases. Then it provides a set of methods for interacting with
  those objects. For the most part, Django’s does a pretty good job at what it’s designed to do. However,
  it does have quirks, and understanding those quirks is part of learning how to use Django. Let’s go
  over some of them, shall we?
  
### Use get_object_or_404() for Single Objects

- In views such as detail pages where you want to retrieve a single object and do something with it, use get_object_or_404() instead of get()

- **Warning** : get_object_or_404() Is for Views Only, Only use it in views. Don’t use it in helper functions, forms, model methods or anything that is not a view or directly view related


### Avoid Long Single Line Queries

- It is always unpleasant to work with code that exeecds the 79 char line right. Instead of writigin our long queries in a single line we can chain our querie like it is in javascript. See the example:
  ```python
  query = (ModelName
              .objects
              .filter(
                 ...
               )
              .exclude(status="foo")
           )
  ```
  The downside to this approach is that debugging isn’t as easy as using the lazy evaluation method of writing a query

- Dont drop raw SQL until it is necessary, Whenever we write raw SQL we lose elements of security and reusability. Also, in the rare event that the data has to be migrated from one database to another, any database-specific features that you use in your SQL queries will complicate the migration.

---

- ***I did not really read this chapter very much ... I was bored, self note: come back to this in the future***

















