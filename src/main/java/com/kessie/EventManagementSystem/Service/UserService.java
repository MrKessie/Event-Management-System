package com.kessie.EventManagementSystem.Service;

import com.kessie.EventManagementSystem.Module.User;
import com.kessie.EventManagementSystem.Repository.UserRepository;
import com.kessie.EventManagementSystem.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(String firstName, String lastName, long phoneNumber, String address, String email, String username,
                        String password, Set<Role> roles /*Date dateCreated, Date dateUpdated*/){
        int userId = randomNumbers();
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
        user.setDateCreated(LocalDateTime.now());
        user.setDateUpdated(LocalDateTime.now());
        userRepository.save(user);

        return user;
    }

    public List<User> allUsers(){
        List<User> users = (List<User>) userRepository.findAll();
        return users;

    }

    public User removeUser(int userId){
        User user = userRepository.findById(userId);
        userRepository.delete(user);
        //userRepository.deleteById(userId);
        return user;
    }

    public int randomNumbers(){
        Random random = new Random();
        int max = 99999;
        int min = 10000;
        return random.nextInt(max - min + 1) + min;
    }
}
