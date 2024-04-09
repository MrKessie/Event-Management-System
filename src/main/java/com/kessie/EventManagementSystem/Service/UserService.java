package com.kessie.EventManagementSystem.Service;

import com.kessie.EventManagementSystem.Module.User;
import com.kessie.EventManagementSystem.Repository.UserRepository;
import com.kessie.EventManagementSystem.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(String firstName, String lastName, Long phoneNumber, String address, String email, String username,
                        String password, Set<Role> roles /*Date dateCreated*/){
        long userId = randomNumbers();
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
        //user.setDateCreated(dateCreated);
        userRepository.save(user);

        return user;
    }

    public List<User> allUsers(){
        List<User> users = (List<User>) userRepository.findAll();
        return users;

    }

    public User removeUser(long userId){
        User user = userRepository.findById(userId);
        userRepository.delete(user);
        //userRepository.deleteById(userId);
        return user;
    }

    public long randomNumbers(){
        Random random = new Random();
        long max = 99999L;
        long min = 10000L;
        return random.nextLong(max - min + 1) + min;
    }
}
