# ACID and Transactions

- In database systems, ACID (Atomicity, Consistency, Isolation, Durability) refers to a standard set of properties that guarantee database transactions are processed reliably. ACID is especially concerned with how a database recovers from any failure that might occur while processing a transaction. An ACID-compliant DBMS ensures that the data in the database remains accurate and consistent despite any such failures.

### ACID Definition

- ACID is an acronym that stands for Atomicity, Consistency, Isolation, Durability. These are explained below.

- `Atomicity` -- Atomicity means that you guarantee that either all of the transaction succeeds or none of it does. You don’t get part of it succeeding and part of it not. If one part of the transaction fails, the whole transaction fails. With atomicity, it’s either “all or nothing”.

- `Consistency` -- This ensures that you guarantee that all data will be consistent. All data will be valid according to all defined rules, including any constraints, cascades, and triggers that have been applied on the database.

- `Isolation` -- Guarantees that all transactions will occur in isolation. No transaction will be affected by any other transaction. So a transaction cannot read data from any other transaction that has not yet completed.

- `Durability` -- Durability means that, once a transaction is committed, it will remain in the system – even if there’s a system crash immediately following the transaction. Any changes from the transaction must be stored permanently. If the system tells the user that the transaction has succeeded, the transaction must have, in fact, succeeded.

### When is ACID Needed?

- A transaction is a single logical operation that may consist of one or many steps. For example, transferring money between bank accounts (i.e. debiting one account and crediting the other) is a transaction.

  If a transaction like this fails halfway through, it could have major consequences. Money could be debited from the first account but not credited to the other account.

  This is where the ACID principles should apply.

  According to the ACID definition, a database is consistent if and only if it contains the results of successful transactions. Any database that is ACID-compliant will ensure that only successful transactions are processed. If a failure occurs before a transaction completes, no data will be changed.
  
  So ACID-compliant DBMSs provide organisations with the confidence that their database will maintain data integrity, even if some type of failure occurs while transactions are in the middle of being processed.
  
### Types of Failures

- There are many types of failures while data is bieng transactioned. The most common ones are:
  - `Transaction Failure` -- A transaction failure could occur due to bad input or some other violation of consistency. It could also be due to a timeout or deadlock in the DBMS.
  - `System Failure` -- A system failure can be caused by a bug in the DBMS code, an operating system fault, or a hardware failure.
  - `Media Failure` -- Media failure refers to the condition of not being able to read from or write to a storage device (such as the hard disc). This could be caused by the media itself, or it could be due to bugs in the operating system

### ACID Compliance

- All of the major relational DBMSs adhere to the ACID principles. They all include features that ensure that the data maintains consistent throughout software and hardware crashes, as well as any failed transactions.

  NoSQL databases are a bit different. NoSQL databases are often designed to ensure high availability across a cluster, which usually means that consistency and/or durability is sacrificed to some degree. However, most NoSQL DBMSs can provide atomicity to some degree.
  
  Most NoSQL DBMS work on a eventually consistent basis, meaning that, data may be out of sync for a time, but it will eventually be in sync.
