# Module Map

# Runtime Module

Responsibilities:

- workflow execution
- execution lifecycle
- action dispatch
- retry and timeout

Owns:

- WorkflowRuntime
- ExecutionPlan
- ActionDispatcher
- WorkflowContext

---

# Browser Module

Responsibilities:

- browser lifecycle
- browser pool
- browser isolation
- browser recycle

Owns:

- BrowserPool
- BrowserManager
- BrowserContextFactory

---

# Plugin Module

Responsibilities:

- plugin loading
- plugin lifecycle
- SPI registry

Owns:

- PluginLoader
- PluginRegistry
- ActionHandler SPI

---

# Queue Module

Responsibilities:

- task queue
- worker scheduling
- async execution

---

# Trace Module

Responsibilities:

- runtime tracing
- screenshots
- logs
- video
