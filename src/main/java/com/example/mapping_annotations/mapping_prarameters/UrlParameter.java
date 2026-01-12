package com.example.mapping_annotations.mapping_prarameters;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlParameter {

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, "firstName", new FirstNameEditor());
    }

    @GetMapping("/displayParameters")
    public ResponseEntity<String> displayParameters(@RequestParam(name="firstName" , required=false) String firstName){
        return ResponseEntity.ok(firstName);
    }

    @GetMapping("/usePathVariable/{lastName}")
    public ResponseEntity<String> displayMessage(@PathVariable(value="lastName") String lastName){
        return ResponseEntity.ok(lastName);
    }

    @PostMapping(path="/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        //save user
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
