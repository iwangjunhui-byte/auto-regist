# Runtime API Spec

# Dispatcher API

```java
public interface ActionDispatcher {
    void dispatch(ActionContext context);
}
```

---

# ActionHandler API

```java
public interface ActionHandler {

    String action();

    void execute(ActionContext context);
}
```

---

# WorkflowContext API

```java
public class WorkflowContext {

    private Map<String, Object> variables;
}
```
