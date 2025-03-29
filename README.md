# Difference Between @Primary and @Qualifier in Spring

## 1. Introduction
In Spring, `@Primary` and `@Qualifier` annotations are used for **dependency injection** to resolve the issue of multiple bean definitions of the same type. However, they work differently:

- `@Primary` gives **higher preference** to a specific bean when multiple beans are of the same type.
- `@Qualifier` explicitly **specifies** which bean to inject when ambiguity exists.

## 2. Using @Primary
The `@Primary` annotation marks a bean as the default choice when multiple beans of the same type exist.  ( Something like we use like default option )

### Example:
```java
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

interface NotificationService {
    void sendNotification();
}

@Component
@Primary  // This bean will be injected by default
class EmailNotificationService implements NotificationService {
    public void sendNotification() {
        System.out.println("Sending Email Notification");
    }
}

@Component
class SMSNotificationService implements NotificationService {
    public void sendNotification() {
        System.out.println("Sending SMS Notification");
    }
}

@Component
class NotificationClient {
    private final NotificationService notificationService;

    public NotificationClient(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyUser() {
        notificationService.sendNotification();
    }
}
```

### Output:
```
Sending Email Notification
```
- Since `EmailNotificationService` is marked with `@Primary`, it gets injected by default.

## 3. Using @Qualifier
When `@Primary` is not sufficient or when multiple beans need to be injected, `@Qualifier` is used to specify the exact bean to inject.

### Example:
```java
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class NotificationClient {
    private final NotificationService notificationService;

    public NotificationClient(@Qualifier("SMSNotificationService") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyUser() {
        notificationService.sendNotification();
    }
}
```

### Output:
```
Sending SMS Notification
```
- The `@Qualifier("SMSNotificationService")` explicitly specifies that the **SMSNotificationService** should be injected.

## 4. When to Use Which?
| Annotation | When to Use |
|------------|-------------|
| `@Primary` | When a default bean should be injected unless explicitly overridden. |
| `@Qualifier` | When a specific bean needs to be injected among multiple candidates. |

## 5. Conclusion
- Use `@Primary` when one bean should be the default choice.
- Use `@Qualifier` when you need to differentiate and explicitly specify which bean to use.
- `@Qualifier` takes precedence over `@Primary` if both are used together.

This ensures proper dependency resolution and avoids ambiguity in Spring applications.

- Reference [Code Snippet ](https://www.youtube.com/watch?v=E1YnBDEgaEw&list=PL-bgVzzRdaPhNeXyQBtp8hMlUc14J2kRK&index=10)
