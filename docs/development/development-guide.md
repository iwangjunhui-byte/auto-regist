# Development Guide

# Development Workflow

```text
Spec
 ↓
ADR
 ↓
Roadmap
 ↓
Task
 ↓
TODO
 ↓
Code
```

---

# Rules

- One task at a time
- Every task must have TODOs
- Every module must have specs
- Runtime changes require ADR

---

# Recommended Development Order

1. Workflow AST
2. Workflow Parser
3. ExecutionPlan
4. ActionDispatcher
5. WorkflowContext
6. BrowserPool

---

# AI Development Rules

- AI should implement one task only
- AI must follow specs
- AI must follow ADR
