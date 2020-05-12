# Software Architecture Patterns

- Ever wondered how large enterprise scale systems are designed? Before major software development starts, we have to choose a suitable architecture that will provide us with the desired functionality and quality attributes. Hence, we should understand different architectures, before applying them to our design.
  
  This is just an introductiory note, check out speficific architectures within this directory. These following architectures will be beriefly mentinoed ont his readme:
  - Layered pattern
  - Client-server pattern
  - Master-slave pattern
  - Pipe-filter pattern
  - Broker pattern
  - Peer-to-peer pattern
  - Event-bus pattern
  - Model-view-controller pattern
  - Blackboard pattern
  - Interpreter pattern
  
### Layered pattern
  
- This pattern can be used to structure programs that can be decomposed into groups of subtasks, each of which is at a particular level of abstraction. Each layer provides services to the next higher layer.

  Usage:
  - General desktop applications.
  - E commerce web applications.
  
### Client-server pattern

- This pattern consists of two parties; a server and multiple clients. The server component will provide services to multiple client components. Clients request services from the server and the server provides relevant services to those clients. Furthermore, the server continues to listen to client requests.

  Usage:
    - Online applications such as email, document sharing and banking.
  
### Master-slave pattern

- This pattern consists of two parties; master and slaves. The master component distributes the work among identical slave components, and computes a final result from the results which the slaves return.

  Usage:
    - In database replication, the master database is regarded as the authoritative source, and the slave databases are synchronized to it
    - Peripherals connected to a bus in a computer system (master and slave drives).
   
### Pipe-filter pattern

- This pattern can be used to structure systems which produce and process a stream of data. Each processing step is enclosed within a filter component. Data to be processed is passed through pipes. These pipes can be used for buffering or for synchronization purposes.

  Usage:
    - Compilers. The consecutive filters perform lexical analysis, parsing, semantic analysis, and code generation.
    - Workflows in bioinformatics.
  
### Broker pattern

- This pattern is used to structure distributed systems with decoupled components. These components can interact with each other by remote service invocations. A broker component is responsible for the coordination of communication among components.
  
  Usage:
  - Message broker software such as Apache ActiveMQ, Apache Kafka, RabbitMQ and JBoss Messaging.
  
### Peer-to-peer pattern

- In this pattern, individual components are known as peers. Peers may function both as a client, requesting services from other peers, and as a server, providing services to other peers

  Usage:
    - File-sharing networks such as Gnutella and G2)
    - Multimedia protocols such as P2PTV and PDTP.
  
### Event-bus pattern

- This pattern primarily deals with events and has 4 major components; event source, event listener, channel and event bus. Sources publish messages to particular channels on an event bus. Listeners subscribe to particular channels. Listeners are notified of messages that are published to a channel to which they have subscribed before.
  
  Usage:
    - Android development
    - Notification services
  
### Model-view-controller pattern

- This pattern, also known as MVC pattern, divides an interactive application in to 3 parts as:
  - model — contains the core functionality and data
  - view — displays the information to the user (more than one view may be defined)
  - controller — handles the input from the user

  Usage:
  - Architecture for World Wide Web applications in major programming languages.
  - Web frameworks such as Django and Rails.
  
### Blackboard pattern

- This pattern is useful for problems for which no deterministic solution strategies are known. The blackboard pattern consists of 3 main components.
  - blackboard — a structured global memory containing objects from the solution space
  - knowledge source — specialized modules with their own representation
  - control component — selects, configures and executes modules.
  
  All the components have access to the blackboard. Components may produce new data objects that are added to the blackboard. Components look for particular kinds of data on the blackboard, and may find these by pattern matching with the existing knowledge source.
  
   Usaege:
   - Speech recognition
   - Vehicle identification and tracking
   - Protein structure identification
   - Sonar signals interpretation.
    
  
### Interpreter pattern

- This pattern is used for designing a component that interprets programs written in a dedicated language. It mainly specifies how to evaluate lines of programs, known as sentences or expressions written in a particular language. The basic idea is to have a class for each symbol of the language.
  
  Usage:
  - Database query languages such as SQL.
  - Languages used to describe communication protocols.
