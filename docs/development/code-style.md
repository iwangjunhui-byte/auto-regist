# Code Style

# Naming Rules

- Class names use PascalCase
- Method names use camelCase
- Constants use UPPER_CASE

---

# Package Structure

```text
runtime/
browser/
plugin/
queue/
trace/
ui/
```

---

# Runtime Rules

- No switch-case runtime dispatch
- Use ActionHandler SPI
- Use plugin architecture

---

# Workflow Rules

- DSL should not depend directly on Playwright
- Runtime must be isolated
- BrowserContext must be isolated
