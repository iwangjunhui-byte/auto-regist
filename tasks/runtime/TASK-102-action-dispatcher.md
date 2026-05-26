# TASK-102 ActionDispatcher

## Module

runtime

---

## Goal

实现 ActionDispatcher。

---

## Input

ExecutionPlan

---

## Output

ActionHandler 执行结果

---

## Dependencies

- workflow-runtime.md
- ADR-001-action-handler.md

---

## TODO

- [ ] Handler Registry
- [ ] Action Routing
- [ ] Retry Support
- [ ] Timeout Support
- [ ] Error Recovery
- [ ] 单元测试

---

## Acceptance Criteria

- 能正确路由 Action
- 支持插件化 Handler
- 支持 Retry
- 支持 Timeout

---

## Related Files

- ActionDispatcher.java
- ActionRegistry.java
