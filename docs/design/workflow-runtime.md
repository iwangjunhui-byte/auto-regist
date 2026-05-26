# Workflow Runtime 详细设计

# 1. Runtime 定位

Workflow Runtime 是整个系统的执行核心。

负责：

- 解析 DSL
- 生成 Execution Plan
- 调度 ActionHandler
- 生命周期管理
- Retry
- Timeout
- Context 管理

---

# 2. Runtime 架构

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

# 3. 为什么不能使用 switch-case

错误设计：

```java
switch(action)
```

问题：

- 不可扩展
- 不支持插件
- Action 增长后代码爆炸

---

# 4. ActionHandler 设计

## 接口定义

```java
public interface ActionHandler {

    String action();

    void execute(ActionContext context);
}
```

---

## Handler 示例

```text
GotoActionHandler
ClickActionHandler
FillActionHandler
AssertTextHandler
```

---

# 5. ActionDispatcher

负责：

- 查找 Handler
- 执行 Handler
- Retry
- Timeout
- Error Recovery

---

# 6. WorkflowContext

```java
public class WorkflowContext {

    private Map<String, Object> variables;

    private BrowserContext browserContext;

    private Page page;
}
```

---

# 7. Execution Plan

Workflow 不应该直接执行。

而应该：

```text
Workflow DSL
    ↓
Compile
    ↓
Execution Plan
```

Execution Plan 是 Runtime 内部结构。

---

# 8. Retry 机制

每个 Action：

- 可配置 Retry
- Retry Interval
- Retry Condition

---

# 9. Timeout 机制

必须支持：

- Workflow Timeout
- Step Timeout
- Browser Timeout

否则 Runtime 可能永久阻塞。

---

# 10. Error Recovery

失败后支持：

- Retry
- Screenshot
- Trace
- Rollback（后期）

---

# 11. Runtime 生命周期

```text
CREATE
  ↓
INIT
  ↓
RUNNING
  ↓
SUCCESS / FAILED
  ↓
DESTROY
```

---

# 12. Runtime 扩展目标

后续支持：

- Distributed Runtime
- Kubernetes Worker
- Remote Browser
- Browserless Runtime
- AI Runtime
