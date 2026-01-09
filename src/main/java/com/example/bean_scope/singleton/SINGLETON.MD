# Singleton Scope

- It's a default scope of bean.
- Only one instance will be get created per bean.
- same instance will be used all over the application to fill dependencies.
- Eagerly initialized by **IOC** (means at the time of application startup, object get created).

every bean is singleton by default.
But we can specify it manually as well.

- using @Scope("singleton")
    ```java
   @Component
   @Scope(value= "singleton")
   public class User{
        public User(){
            System.out.println("User initialized");
        }    
   }
   ```
- using @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    ```java
    import org.springframework.beans.factory.config.ConfigurableBeanFactory;    
    @Component 
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
   public class User{
        public User(){ 
            System.out.println("User initialized");
        }    
   }
    ```

*note* : at the time of api call spring will not create another object it will use same object.


## Use When

- The bean is stateless

- The same instance can be shared safely across threads

- You want maximum performance and minimum memory usage

## Typical Use Cases

- @Service classes

- @Repository / DAO classes

- Business logic components

- Utility/helper classes

## Do NOT Use When

- The bean holds mutable or request-specific state

- Data differs per user or per request

## One-Line Rule

- Use singleton for stateless, reusable components.