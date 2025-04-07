package com.kessie.EventManagementSystem.Controller;

import com.kessie.EventManagementSystem.Enums.UserType;
import com.kessie.EventManagementSystem.Model.User;
import com.kessie.EventManagementSystem.Enums.Role;
import com.kessie.EventManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/setup/user")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> addUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Long phoneNumber,
                                  @RequestParam String address, @RequestParam String email, @RequestParam String username,
                                  @RequestParam String password, @RequestParam Role role, @RequestParam UserType userType){
        try{
            if (userService.existByEmail(email)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists.");
            }
            User user = userService.addUser(firstName, lastName, phoneNumber, address, email, username, password, role, userType);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Account created successfully. Proceed to Login.");
            response.put("data", user);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error creating account: " + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/all/users")
    @ResponseBody
    public List<User> allUsers(){
        List<User> users = userService.allUsers();
        return users;
    }

    @DeleteMapping("/delete/{userId}")
    @ResponseBody
    public ResponseEntity<?> deleteUser(@PathVariable long userId){
        try {
            if (userService.existsByUserId(userId)) {
                boolean deletedUser = userService.deleteUser(userId);
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("message", "User deleted successfully");
                response.put("data", deletedUser);
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID: " + userId + " not found.");
            }
        }
        catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error deleting account: " + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable long userId, @RequestBody User updatedUser) {
        try {
            User user = userService.updateUser(userId, updatedUser);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "User updated successfully");
            response.put("data", user);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error updating user: " + e.getMessage());
            return  ResponseEntity.ok(response);
        }
    }
}
