# Semantic Versioning

- Summary = Given a version number MAJOR.MINOR.PATCH, increment the:
  - `MAJOR` version when you make incompatible API changes,
  - `MINOR` version when you add backward compatible new features
  - `PATCH` version when you make backwards-compatible bug fixes.
  Additional labels for pre-release and build metadata are available as extensions to the MAJOR.MINOR.PATCH format.
  
- Lets create a table for visualization:

  |Code Status| Stage | Rule | Example Version |
  |---|---|---|---|
  |Backward compatible bug fixes| Patch release	| Increment the third digit	 | 	0.0.1 |
  |Backward compatible new features	| Minor release |	Increment the middle digit and reset last digit to zero| 0.1.0 |
  |Change in the API| Major release	| Increment the first digit and reset middle and last digits to zero | 1.0.0
  
<br>
<br>

## Introduction

- In the world of software management there exists a dreaded place called “dependency hell.” The bigger your system grows and the more packages you integrate into your software, the more likely you are to find yourself, one day, in this pit of despair.

- In systems with many dependencies, releasing new package versions can quickly become a nightmare. Dependency hell is where you are when version lock and/or version promiscuity prevent you from easily and safely moving your project forward.

- As a solution to this problem, the open soruce community propose a simple set of rules and requirements that dictate how version numbers are assigned and incremented. These rules are based on but not necessarily limited to pre-existing widespread common practices in use in both closed and open-source software

<br>
<br>

## Specification

- Software using Semantic Versioning MUST declare a public API. This API could be declared in the code itself or exist strictly in documentation. However it is done, it should be precise and comprehensive.

- A normal version number MUST take the form X.Y.Z where X, Y, and Z are non-negative integers, and MUST NOT contain leading zeroes. X is the major version, Y is the minor version, and Z is the patch version. Each element MUST increase numerically. For instance: 1.9.0 -> 1.10.0 -> 1.11.0.

- Once a versioned package has been released, the contents of that version MUST NOT be modified. Any modifications MUST be released as a new version.

- Major version zero (0.y.z) is for initial development. Anything may change at any time. The public API should not be considered stable.

- Version 1.0.0 defines the public API. The way in which the version number is incremented after this release is dependent on this public API and how it changes.

- Patch version Z (x.y.Z | x > 0) MUST be incremented if only backwards compatible bug fixes are introduced. A bug fix is defined as an internal change that fixes incorrect behavior.

- Minor version Y (x.Y.z | x > 0) MUST be incremented if new, backwards compatible functionality is introduced to the public API. It MUST be incremented if any public API functionality is marked as deprecated. It MAY be incremented if substantial new functionality or improvements are introduced within the private code. It MAY include patch level changes. Patch version MUST be reset to 0 when minor version is incremented.

- Major version X (X.y.z | X > 0) MUST be incremented if any backwards incompatible changes are introduced to the public API. It MAY include minor and patch level changes. Patch and minor version MUST be reset to 0 when major version is incremented.

