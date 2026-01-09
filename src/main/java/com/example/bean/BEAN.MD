# Spring Bean

**What is Bean ?**
- Bean is a java object, which is managed by Spring Container (also known as IOC container).

**IOC container**
- contains all the beans which get created and also manage them.

**How to create a Bean ?**
1) Using @Component Annotation
2) @Bean Annotation

- other annotations like @RestController, @Controller, @Repository, @Service are internally annotate  with @Component annotation.


## @Component Annotation

- @Component annotation follows "convention over configuration" approach.
- Means spring boot will try to autoconfigure based on conventions reducing the need for explicit configuration.
- @Controller, @Service etc. all are internally tells spring to create bean and manage it.
- It uses default constructor to create its object (java will create default constructor automatically if no constructor present).

example:

```java
import org.springframework.stereotype.Component;

@Component
public class User {
    String name;
    int age;
    
}
```

Note:- if you have any parameterized constructor then you must also include default constructor or the application will fail to start.
because java will not create default constructor automatically.

```java
    @Component
    public class User {
        private String name;
        private int age;
        
        public User(){ }
    
        public User(String name, int age){
            this.name = name;
            this.age = age;
        }
        
        // getters and setters
    
    }
```


-------------------------------------------------
- In above case where application will fail to startup if default constructor is not present.

## Bean Annotation

- In above case @Bean come into picture, where we provide configuration details and tell spring boot to use it while creating bean.
- we should not mark class as component here.

```java
    import org.springframework.context.annotation.Bean;

public class User {
    private string name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //getters and setters.

}


@Configuration
 class AppConfig {
    @Bean
    public User createUser(){
        return new User("shri", 25);
    }
}

```

------------------------------------------------

**How Spring finds beans ?**
- using @ComponentScan Annotation
- using @Configuration Annotation

**At what time these beans get created ?**

1) Eager Initialization
    - Some Beans get created when we start up an application.
    - for example : Beans with singleton scope are eagerly initialized.
   
2) Lazy initialization
    - created when they are actually needed.
    - For example: Beans with scope like Prototype, request etc. are lazily created. OR Beans with @Lazy annotation.


-------------------------------------------------------------------------------

# Bean lifecycle

1) Application strat up :
    - You run the Spring Boot application (typically via main()).
    - Spring Boot bootstraps the application and prepares the environment.
    - Auto-configuration, component scanning, and configuration loading begin.

   At this point, no beans are created yet.


2) IOC container created:
    - Configurations loaded.
    - Spring scans packages and registers bean definition (Meta-data only).
   Beans are defined, but not yet initialized.


3) Construct Beans:
    - Spring creates Bean object using default constructor or Constructor injection.
    - object exist but dependency not injected.
    - Beans are initialized either Eagerly or Lazily.


4) Inject Dependency :
    - Dependencies get injected into constructed beans.
    - either field injection , method injection or constructor injection.
    - Bean is still not fully initialized


5) @PostConstruct :
    - Before Beans are ready to use, if we want to perform any task we use @PostConstruct.
    - Used for initialization logic that depends on injected beans
    - Best use cases: 
      - Validate injected dependencies
      - Initialize resources
      - Preload cache
      - Perform setup logic.
    - All dependencies are available at this stage.
    - Runs once per bean


6) Bean Is Used
    - The bean is now fully initialized
    - It can be: 
      - Injected into other beans
      - Used to handle requests
      - Participate in business logic.
    - This is the steady state of the application.

7) @PreDestroy Is Executed
    - Triggered when: 
      - Application shuts down
      - ApplicationContext is closed.
    - Used for cleanup logic
    - Typical use cases: 
         - Close connections 
         - Flush buffers 
         - Stop background threads.
    - Runs only on graceful shutdown
    - Not called for prototype beans


8) Bean Is Destroyed: 
    - After @PreDestroy completes:
        - Bean is removed from the container
        - Object becomes eligible for garbage collection

    - Important note:
        - This step applies to singleton beans
        - Prototype beans are not destroyed by Spring
   