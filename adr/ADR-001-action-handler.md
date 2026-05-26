# ADR-001 ActionHandler

## Status

Accepted

---

## Context

Workflow Runtime 需要支持插件化 Action。

如果采用：

```java
switch(action)
```

后续 Action 增加后：

- Runtime 会越来越复杂
- 无法插件化
- 无法扩展

---

## Decision

采用：

```text
ActionHandler SPI
```

替代：

```text
switch-case
```

---

## Consequences

优点：

- 可扩展
- 插件化
- Runtime 解耦
- 支持第三方 Action

缺点：

- 增加抽象层
- 调试复杂度增加
