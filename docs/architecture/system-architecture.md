# System Architecture

# Core Architecture

```text
Workflow DSL
    ↓
Workflow Parser
    ↓
AST
    ↓
ExecutionPlan
    ↓
Runtime Dispatcher
    ↓
ActionHandler
    ↓
Playwright Runtime
```

---

# Core Modules

| Module | Responsibility |
|---|---|
| runtime | workflow execution |
| browser | browser lifecycle |
| plugin | plugin management |
| queue | async task queue |
| trace | tracing and debugging |
| ui | web platform |

---

# Runtime Lifecycle

```text
CREATE
INIT
RUNNING
SUCCESS
FAILED
DESTROY
```
