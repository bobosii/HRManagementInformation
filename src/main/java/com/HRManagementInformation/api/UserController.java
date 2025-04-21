package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IUserService;
import com.HRManagementInformation.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user),HttpStatus.CREATED);
    }

    @PostMapping()
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return new ResponseEntity<>(userService.update(user),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") int id){
        return new ResponseEntity<>(userService.delete(id),HttpStatus.OK);
    }
}
