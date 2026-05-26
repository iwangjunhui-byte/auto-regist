# TASK-101 ExecutionPlan

## Module

runtime

---

## Goal

实现 Workflow ExecutionPlan。

---

## Input

Workflow DSL AST

---

## Output

ExecutionPlan

---

## Dependencies

- workflow-dsl.md
- TASK-001 Workflow AST

---

## TODO

- [ ] 定义 ExecutionNode
- [ ] 定义 ExecutionStep
- [ ] 定义 RuntimeMetadata
- [ ] 实现 Compiler
- [ ] 单元测试

---

## Acceptance Criteria

- 能正确生成 ExecutionPlan
- 支持 Step 顺序执行
- 支持 Runtime Metadata

---

## Related Files

- ExecutionPlan.java
- ExecutionNode.java
- WorkflowCompiler.java
