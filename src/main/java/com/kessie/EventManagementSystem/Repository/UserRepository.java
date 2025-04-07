package com.kessie.EventManagementSystem.Repository;

import com.kessie.EventManagementSystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(int userId);

    boolean existsByEmail(String email);

    boolean findByUserId(long userId);
    //User deleteBy(int userId);
}
