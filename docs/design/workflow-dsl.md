# Workflow DSL 详细设计

# 1. 设计目标

Workflow DSL 是整个 Browser Automation Platform 的核心。

DSL 必须具备：

- 可读性
- 可扩展性
- 插件化
- 可视化编排
- 条件控制
- Retry
- Timeout
- 变量传递
- 嵌套 Workflow

---

# 2. DSL 基础结构

```yaml
name: login-test

variables:
  username: admin
  password: 123456

steps:

  - action: goto
    url: https://example.com/login

  - action: fill
    selector: '#username'
    value: ${username}

  - action: fill
    selector: '#password'
    value: ${password}

  - action: click
    selector: '#submit'

  - action: assertText
    selector: '.welcome'
    expected: Welcome
```

---

# 3. DSL 核心组成

| 模块 | 说明 |
|---|---|
| variables | 全局变量 |
| steps | 执行步骤 |
| action | 动作类型 |
| selector | 元素定位 |
| retry | 重试策略 |
| timeout | 超时控制 |
| condition | 条件分支 |

---

# 4. Action 规范

## goto

```yaml
- action: goto
  url: https://example.com
```

## click

```yaml
- action: click
  selector: '#submit'
```

## fill

```yaml
- action: fill
  selector: '#username'
  value: admin
```

## wait

```yaml
- action: wait
  timeout: 3000
```

## screenshot

```yaml
- action: screenshot
  name: login-page
```

---

# 5. Retry 机制

```yaml
- action: click
  selector: '#submit'
  retry:
    count: 3
    interval: 1000
```

---

# 6. Timeout 机制

```yaml
- action: fill
  selector: '#username'
  timeout: 5000
```

---

# 7. 条件分支

```yaml
- if: ${loginSuccess} == true
  then:
    - action: click
      selector: '#dashboard'
```

---

# 8. 循环结构

```yaml
- foreach: ${users}
  steps:
    - action: fill
      selector: '#username'
      value: ${item.name}
```

---

# 9. 嵌套 Workflow

```yaml
- workflow: login-workflow
```

---

# 10. Keyword DSL（高级 DSL）

推荐使用：

```yaml
- keyword: Login
  args:
    username: admin
    password: 123456
```

底层再转换为：

- fill
- click
- assert

---

# 11. 变量系统

## 全局变量

```yaml
variables:
  baseUrl: https://example.com
```

## 引用变量

```yaml
${baseUrl}
```

---

# 12. Workflow 生命周期

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

# 13. DSL 未来扩展

后续支持：

- AI Selector
- Visual Workflow
- Parallel Steps
- Distributed Runtime
- AI Assertion

---

# 14. 当前设计原则

最重要原则：

不要让 DSL 与 Playwright API 强绑定。

正确架构：

```text
Workflow DSL
    ↓
Workflow Runtime
    ↓
Playwright Runtime
```

而不是：

```text
Workflow DSL
    ↓
直接 page.click()
```
