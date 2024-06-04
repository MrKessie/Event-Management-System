package com.kessie.EventManagementSystem.Repository;

import com.kessie.EventManagementSystem.Module.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findById(int userId);
    User deleteBy(int userId);
}
