# module gay.floof.utils.slf4j
> :warning: Only available for Kotlin - JVM.
>
> Common utilities for **SLF4J**

- Comes with a read-only delegate property for constructing SLF4J loggers:

```kt
import gay.floof.utils.slf4j.*

object Something {
   val logger by logging<Something>() // => org.slf4j.Logger
}
```
