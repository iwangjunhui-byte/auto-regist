# Interface Contracts

# ActionDispatcher

Responsibilities:

- dispatch action handlers
- runtime retry
- timeout handling

---

# ActionHandler

Responsibilities:

- execute single action
- isolate business logic

Contract:

- stateless
- thread safe

---

# WorkflowContext

Responsibilities:

- variable storage
- page reference
- runtime metadata

Contract:

- isolated per workflow

---

# BrowserPool

Responsibilities:

- browser reuse
- browser recycle
- health check
