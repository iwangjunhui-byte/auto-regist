# 插件体系设计

# 1. 为什么必须插件化

Workflow Action 会越来越多。

不能全部内置。

否则 Runtime 会越来越复杂。

---

# 2. 插件系统目标

支持：

- 自定义 Action
- 自定义 Keyword
- 自定义 Assertion
- 自定义 Runtime
- 自定义 Selector

---

# 3. 插件架构

```text
Plugin
   ↓
ActionHandler
   ↓
Runtime Registry
```

---

# 4. Action 插件

## 示例

```java
public class UploadFileHandler implements ActionHandler {

    @Override
    public String action() {
        return "upload";
    }

    @Override
    public void execute(ActionContext context) {
    }
}
```

---

# 5. Keyword 插件

```yaml
- keyword: Login
```

底层可扩展为：

- fill
- click
- assert

---

# 6. Selector 插件

支持：

- AI Selector
- Fuzzy Selector
- Smart Recovery

---

# 7. Runtime Registry

负责：

- 注册 Plugin
- 加载 Plugin
- 插件生命周期
- 插件隔离

---

# 8. SPI 设计

推荐基于：

```text
Java SPI
```

实现插件发现。

---

# 9. 插件生命周期

```text
LOAD
INIT
RUNNING
DESTROY
```

---

# 10. 未来扩展

后续支持：

- Remote Plugin Marketplace
- Plugin Sandbox
- Plugin Permission
- Plugin Hot Reload
