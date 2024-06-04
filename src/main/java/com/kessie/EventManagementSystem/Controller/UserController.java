package com.kessie.EventManagementSystem.Controller;

import com.kessie.EventManagementSystem.Module.User;
import com.kessie.EventManagementSystem.Role;
import com.kessie.EventManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
//@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

//    public UserController(UserService userService){
//        this.userService = userService;
//    }

    @PostMapping("/add")
    @ResponseBody
    public User addUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Long phoneNumber,
                        @RequestParam String address, @RequestParam String email, @RequestParam String username,
                        @RequestParam String password, @RequestParam Set<Role> role /*@RequestParam Date dateCreated,
                        @RequestParam Date dateUpdated*/){
        User user = userService.addUser(firstName, lastName, phoneNumber, address, email, username, password, role
                    /*dateCreated, dateUpdated*/);
        return user;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<User> allUsers(){
        List<User> users = userService.allUsers();
        return users;
    }

    @DeleteMapping("/remove")
    @ResponseBody
    public User removeUser(@RequestParam int userId){
        User user = userService.removeUser(userId);
        return user;
    }
}
