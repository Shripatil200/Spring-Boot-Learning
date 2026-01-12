# Mapping Annotations

1) @Controller
    - It indicated that the class is responsible for handling incoming http requests.
    - example :
    ```java 
    import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.ResponseBody;    @Controller
    public class SampleController{ 
        @RequestMapping(path="/fetchUser", method=RequestMethod.GET)
        @ResponseBody
        public String getUserDetails(){ 
            return "home";
        }    
   }
   ```
   
    Here we need to add @ResponseBody externally, if we don't spring will think it is returning view so he will try to find *home.jsp* file. If it's not exist then it will show us error.

2) @RestController
    - it is a combination of @Controller + @ResponseBody
    - used to build restfull services.
    - Tells Spring to return data directly in the HTTP response body (JSON/XML), not a view (JSP/HTML).

    ```java 
    import org.springframework.web.bind.annotation.RequestMapping;
   
    import org.springframework.web.bind.annotation.RestController;   
    @RestController
    public class SampleController{ 
        @RequestMapping(path="/fetchUser", method=RequestMethod.GET)
        public String getUserDetails(){ 
            return "home";
        }    
   }
   ```
   

3) @ResponseBody 
    - Denotes that return value of thr controller method should be serialized to HTTP response body.
    - If we do not provide ResponseBody, spring will consider response as a name for view and tries to resolve and render it (in case we are not using @Controller annotation).
   

4) @RequestMapping
    - used to map http request to appropriate java method.
    - Key attributes
      - (value / path) : defines url path.
      - method : specifies the http method (method = RequestMethod.GET)
      - Consumes : Request content type (@RequestMapping(consumes = "application/json")).
      - Produces : Response content type (@RequestMapping(produces = "application/json")).
    - can be used over method as well as on top of class.
    - example : 
    ```java
   @RestController
    @RequestMapping("/api/users")
    public class UserController {

        @RequestMapping(
        value = "/{id}",
        method = RequestMethod.GET,
        produces = "application/json"
        )
        public User getUser(@PathVariable int id) {
            return userService.findById(id);
        }
    }
    ```


5) @RequestParam :
    - Used to bind, request parameters ti controller method parameter.
    - url example : http://localhost:8080/api/fetchUser?firstName=Shri&lastName=Patil&age=25

   url explanation:
    - http://localhost:8080  : host
    - /api/fetchUser  : path
    - firstName=Shri&lastName=Patil&age=25    : request parameters.

    ```java 
    import org.springframework.web.bind.annotation.*;    
    @ RestController
    @RequestMapping("/api")
    public class SampleController{
        
        @GetMapping("/fetchUser")
        public String getUserDetails(@RequestParam(name = "firstName") String name){ 
            return "hello "+ name;
        }    
    }    
    ```
   @RequestParam has one more method required, by default it is true. means if our url doesn't contain matching parameter then method will not be called.
    we can change this value to false as **(@RequestParam(name="firstName", required=false) String firstName)** so eve url doesn't have this field it will work fine. and parameter will be assigned as null.  
    
    The framework automatically perform type conversion from the request parameter's String representation to the specified type.
        - Primitive types: int, long, boolean, float, double, etc.
        - Wrapper classes : Integer, Long, Boolean, Float, Double, etc.
        - String : Request parameter inherently treated as String only.
        - Enum : You can bind request parameters to Enum type.
        - Custom Object types : We do it using a registered PropertyEditor.
    
**Note**: Property Editor are used to apply custom logic on required parameters before it get to RequestParam variable (Method parameters).
example: everything came with request is an string if we are passing date 23-06-2025 this is also a string. to convert it into date we need to apply custom logic. this can be done using PropertyEditor.
    

6) @PathVariable:
    - Used to extract values from the path of the URL and help to bind it to controller method parameters.
    - Used for urls such as  /fetchUser/{id}
    - here we are passing some value in path itself not through request parameters.
    - to access these we can use @PathVariables.

   Example:
    ```java 
    import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.RequestMapping;    
    @ Controller 
    @RequestMapping(value="/api")
    public class SampleController{
        @GetMapping(path="/fetchUser/{firstName}")
        public String getUserDetails(@PathVariable(value="firstName") string firstName){
            return firstName;
        }    
    }
   ```
   

7) @RequestBody :
    - Bind the body of HTTP request(typical JSON) to controller method parameter(Java Object).
    - used to bind json object to DTO (java object)

    example of DTO:
        
    ```java
    public class User{
        String userName;
        String password;
   
        //constructor
        // getters and setters
   }
    ```
   
    Example of @RequestBody

    ```java
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    @RestController
    @RequestMapping(value="/api")
    public class SampleController{
        
        @PostMapping(path="/saveUser")
        public String saveUser(@RequestBody User user){
            // saving logic
            return "User created with Username : "+ user.userName + "& password :" + user.password;
        }    
    }

    ```
   
8) @ResponseEntity
    
    - It represents the entire HTTP response like Header, Status, response body etc.

    example : 
    return ResponseEntity.status(HttpStatus.ok).body("Some Body");
    
   
    
   
    



    
    