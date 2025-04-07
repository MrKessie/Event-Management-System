package com.kessie.EventManagementSystem.Service;

import com.kessie.EventManagementSystem.Enums.UserType;
import com.kessie.EventManagementSystem.Model.User;
import com.kessie.EventManagementSystem.Repository.UserRepository;
import com.kessie.EventManagementSystem.Enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(String firstName, String lastName, long phoneNumber, String address, String email, String username,
                        String password, Role roles, UserType userType){
        Long userId = randomNumbers();
        User user = new User();
        user.setUserId(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setRoles(roles);
        user.setUserType(userType);
        user.setDateCreated(LocalDateTime.now());
        user.setDateUpdated(LocalDateTime.now());
        userRepository.save(user);

        return user;
    }

    public List<User> allUsers(){
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    public boolean existByEmail(String userId) {
        return userRepository.existsByEmail(userId);
    }

    public boolean existsByUserId(long userId) {
        return userRepository.existsById(userId);
    }

    public boolean deleteUser(long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
    
    public User updateUser(long userId, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            if(updatedUser.getFirstName() != null) {
                existingUser.setFirstName(updatedUser.getFirstName());
            }
            if(updatedUser.getLastName() != null) {
                existingUser.setLastName(updatedUser.getLastName());
            }
            if(updatedUser.getPhoneNumber() != 0) {
                existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
            }
            if(updatedUser.getAddress() != null) {
                existingUser.setAddress(updatedUser.getAddress());
            }
            if(updatedUser.getEmail() != null) {
                existingUser.setEmail(updatedUser.getEmail());
            };
            if(updatedUser.getUsername() != null) {
                existingUser.setUsername(updatedUser.getUsername());
            }
            if(updatedUser.getUserType() != null) {
                existingUser.setUserType(updatedUser.getUserType());
            }
            if(updatedUser.getRoles() != null) {
                existingUser.setRoles(updatedUser.getRoles());
            }
            if(updatedUser.getDateUpdated() != null) {
                existingUser.setDateUpdated(LocalDateTime.now());
            }

            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
//                String encodedPassword = passwordEncoder.encode(updatedUser.getPassword());
                existingUser.setPassword(updatedUser.getPassword());
            }

            return userRepository.save(existingUser);
        }
        else {
            throw new RuntimeException("User not found.");
        }
    }

    public long randomNumbers(){
        Random random = new Random();
        long max = 99999;
        long min = 10000;
        return random.nextLong(max - min + 1) + min;
    }
}
