# Workflow Runtime Spec

## Runtime Goal

Workflow Runtime is the execution core of the platform.

Responsibilities:

- Parse workflow DSL
- Execute execution plan
- Dispatch action handlers
- Manage retry and timeout
- Manage workflow context

---

## Runtime Architecture

```text
Workflow DSL
    ↓
Workflow Parser
    ↓
Execution Plan
    ↓
Action Dispatcher
    ↓
Action Handler
    ↓
Playwright Runtime
```

---

## Runtime Principles

- Plugin based runtime
- Retry support
- Timeout support
- Context isolation
- Runtime extensibility

---

## Runtime Lifecycle

```text
CREATE
INIT
RUNNING
SUCCESS
FAILED
DESTROY
```
