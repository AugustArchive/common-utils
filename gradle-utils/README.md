# module gay.floof.utils.gradle
> Gradle plugin for Noel's common utilities

- Provides an extension for **noel()** in a `repositories` block.
- Provides a Version class that I repeat in all of my Kotlin projects
- Provides the following groups below as a function in `dependencies` to import from the Noel Maven repository.
    - The following groups are available: **floof**, **floofy**, **nino**, and **arisu**.
    - **floof** will return: `gay.floof.{group}:{package}:{version}`
    - **floofy** will return: `dev.floofy.{group}:{package}:{version}`
    - **nino** will return: `sh.nino.{group}:{package}:{version}`
    - **arisu** will return: `land.arisu.{group}:{package}:{version}`
