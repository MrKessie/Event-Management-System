package com.kessie.EventManagementSystem.Repository;

import com.kessie.EventManagementSystem.Module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(int userId);

    boolean existsByEmail(String email);

    boolean findByUserId(long userId);
    //User deleteBy(int userId);
}
