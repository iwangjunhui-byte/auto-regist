# Browser Automation Platform 文档体系（重构版）

# 1. 项目定位

## 1.1 项目名称

Browser Automation Platform

## 1.2 项目目标

构建一个：

- 企业级
- DSL驱动
- Workflow编排
- Playwright Runtime
- 分布式执行

的浏览器自动化平台。

平台支持：

- E2E 自动化测试
- 页面巡检
- RPA 自动化
- 工作流编排
- 浏览器自动化
- 自动化回归测试
- CI/CD 集成

---

# 2. 软件开发生命周期（SDLC）

当前阶段：

Architecture + DSL Design

当前最核心工作：

- Workflow DSL 设计
- Workflow Runtime 设计
- 插件体系设计
- 状态机设计

---

# 3. 项目文档体系（企业级）

```text
docs/
├── prd/
├── architecture/
├── design/
├── api/
├── database/
├── deployment/
├── testing/
├── operation/
└── roadmap/
```

---

# 4. Workflow DSL 设计

路径：

```text
docs/design/workflow-dsl.md
```

这是整个系统最核心文档。

## DSL 基础结构

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

  - action: click
    selector: '#submit'
```

## DSL 必须支持的能力

| 能力 | 是否必须 |
|---|---|
| Retry | 是 |
| Timeout | 是 |
| Variables | 是 |
| Condition | 是 |
| Loop | 是 |
| Nested Workflow | 是 |
| Plugin Action | 是 |

---

# 5. Workflow Runtime 设计

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

## ActionHandler 模式

错误设计：

```java
switch(action)
```

正确设计：

```text
GotoActionHandler
ClickActionHandler
FillActionHandler
AssertTextHandler
```

---

# 6. Workflow 状态机

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

# 7. Workflow Context

```java
public class WorkflowContext {

    private Map<String, Object> variables;

    private BrowserContext browserContext;

    private Page page;
}
```

---

# 8. Browser Pool

```text
BrowserPool
  ↓
Browser
  ↓
BrowserContext
  ↓
Page
```

必须支持：

- Browser复用
- Context隔离
- TTL回收
- 崩溃恢复
- Session回收
- 并发限制

---

# 9. Selector Engine

Selector 优先级：

1. data-testid
2. id
3. name
4. aria-label
5. placeholder
6. css
7. xpath

---

# 10. 插件体系

支持：

- 自定义 Action
- 自定义 Keyword
- 自定义 Assertion
- 自定义 Runtime

---

# 11. API 设计

## 创建 Workflow

```http
POST /api/workflow
```

## 执行 Workflow

```http
POST /api/workflow/{id}/run
```

## 查询 Task

```http
GET /api/task/{id}
```

---

# 12. 数据库设计

## workflow

| 字段 | 类型 |
|---|---|
| id | bigint |
| name | varchar |
| version | int |
| content | json |

## task

| 字段 | 类型 |
|---|---|
| id | bigint |
| workflow_id | bigint |
| status | varchar |

---

# 13. 当前开发优先级（重新规划）

## 第一阶段（必须先完成）

最重要：

- DSL 设计
- Runtime 设计
- 状态机
- 插件体系
- Context机制

不要继续疯狂写 Playwright API。

---

# 14. 最终项目形态

最终会演进为：

Playwright + Browserless + RobotFramework + n8n + Cypress

的融合体。

---

# 15. 当前项目最大风险

不是代码。

而是：

DSL设计错误。

因为 DSL 一旦上线，后续修改成本极高。
