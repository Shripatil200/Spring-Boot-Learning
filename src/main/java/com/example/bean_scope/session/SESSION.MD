# Session Scope

- new object is created for each HTTP session.
- beans lazily initialized.
- When user accesses any endpoint, session is created.
- remains active, till it does not expire.
- one object per session.
- bean object destroyed when session expire.

- It is a part of WebApplicationContext not ConfigurableBeanFactory 

## used as

```java
    import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession{
    UserSession(){
        
    }
}

```


## Use When

- Data must persist across multiple requests of the same user

- Data is user-specific

## Typical Use Cases

- Logged-in user details

- Shopping cart

- User preferences

## Do NOT Use When

- Data is large or frequently changing

- High-traffic or clustered systems

## One-Line Rule

- Use session for per-user state.
