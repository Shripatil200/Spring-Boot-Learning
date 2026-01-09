# Prototype Scope

- Create new instance of a bean each time.
- It's lazily initialized, means object is created only if needed.
- We can create bean with prototype scope using two ways.

1) by using string "prototype".
    ```java
   @Component
   @Scope(value= "prototype")
   public class User{
        public User(){
            System.out.println("User initialized");
        }    
   }
   ```
2) by using ENUM  (ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    ```java
    import org.springframework.beans.factory.config.ConfigurableBeanFactory;    
    @Component 
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
   public class User{
        public User(){ 
            System.out.println("User initialized");
        }    
   }
    ```

## Use When

- Each usage requires a new independent instance

- The bean is stateful

- Lifecycle is short and manually controlled

## Typical Use Cases

- Command or task objects

- Workflow/state machine steps

- Temporary processing objects

## Do NOT Use When

- Object creation is expensive

- You cannot manage cleanup manually

## One-Line Rule

Use prototype for stateful, short-lived objects.