
# Request Scope

- new object is created for each **HTTP** request.
- One object per http request.
- Bean is lazily initialized.
- can fail application if not used carefully.


**Problem**

If dependency with *request* scope is injected in class with singleton class(Eagerly initialized means initialized at application start up time), then application may fail to start. because there will be no http request at the time of start up and request scope beans get created for http request. In this case spring will fail to inject dependencies.

To solve this problem we should use Proxy object.

- we use it as  
  - using string "request"
  @Scope(value= "request" , ProxyMode = ScopedProxyMode.TARGET_CLASS)

    ```java
    @Component
    @Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public class User_Request {

        public User_Request(){
            System.out.println("User_Request initialization");
        }
    }
    ```
  - using WebApplicationContext
       ```java
    import org.springframework.web.context.WebApplicationContext;     
    @Component
    @Scope(WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public class User_Request {

        public User_Request(){
            System.out.println("User_Request initialization");
        }
    }
    ```

this way spring will not create original object of a bean, instead it will create proxy (dummy) object and use that proxy object to fulfill the dependency.

And when in future http request made and respective bean get used spring will create original object and replace it with proxy object.



## Use When

- Data is valid only for one HTTP request

- Data must not be shared between requests

## Typical Use Cases

- Request metadata

- Validation context

- Request-level DTOs or flags

## Do NOT Use When

- Outside a web environment

- Injecting without proxy into singleton

## One-Line Rule

Use request for per-request data.