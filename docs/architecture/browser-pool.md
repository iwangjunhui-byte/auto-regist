# Browser Pool 设计

# 1. 为什么必须 Browser Pool

如果每次 Workflow 都启动 Chromium：

- 性能极差
- 内存占用极高
- 启动耗时严重

因此必须 Browser Pool。

---

# 2. Pool 架构

```text
BrowserPool
  ↓
Browser
  ↓
BrowserContext
  ↓
Page
```

---

# 3. Browser 生命周期

```text
CREATE
  ↓
READY
  ↓
IN_USE
  ↓
RECYCLE
  ↓
DESTROY
```

---

# 4. Pool 必须支持的能力

| 能力 | 是否必须 |
|---|---|
| Browser复用 | 是 |
| Context隔离 | 是 |
| TTL回收 | 是 |
| 崩溃恢复 | 是 |
| Session回收 | 是 |
| 并发限制 | 是 |

---

# 5. Context Isolation

每个 Workflow：

必须：

```text
独立 BrowserContext
```

避免 Cookie 污染。

---

# 6. Browser Recycle

长期运行 Chromium：

可能：

- 内存泄漏
- Crash
- FD泄漏

因此必须：

- TTL 回收
- Idle 回收
- Health Check

---

# 7. Browser Health Check

定期检测：

- Browser 是否存活
- Memory Usage
- Context Count

---

# 8. Pool 扩展目标

后续支持：

- Distributed Browser Pool
- Remote Browser
- Browserless
- Kubernetes Browser Worker
