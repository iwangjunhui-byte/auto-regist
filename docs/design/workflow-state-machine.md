# Workflow 状态机设计

# 1. 为什么必须状态机

Workflow 不只是执行步骤。

它本质是：

```text
有生命周期的任务系统
```

因此必须有状态机。

---

# 2. Workflow 状态

```text
PENDING
RUNNING
SUCCESS
FAILED
TIMEOUT
CANCELLED
RETRYING
```

---

# 3. 状态流转

```text
PENDING
   ↓
RUNNING
   ↓
SUCCESS
```

失败：

```text
RUNNING
   ↓
FAILED
```

重试：

```text
FAILED
   ↓
RETRYING
   ↓
RUNNING
```

---

# 4. Timeout

Workflow 超时：

```text
RUNNING
   ↓
TIMEOUT
```

---

# 5. Cancel

用户主动取消：

```text
RUNNING
   ↓
CANCELLED
```

---

# 6. Step 状态

每个 Step 也有状态：

```text
PENDING
RUNNING
SUCCESS
FAILED
SKIPPED
```

---

# 7. Runtime 状态同步

Runtime 必须同步：

- Workflow 状态
- Step 状态
- Browser 状态
- Trace 状态

---

# 8. 状态机扩展目标

后续支持：

- Distributed State Machine
- Workflow Recovery
- Checkpoint Resume
- Saga Rollback
