package com.sulistyan.mutabaahku.repository;

import com.sulistyan.mutabaahku.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT user from User user where user.username = ?1 and user.password = ?2")
    User findUserByUsernamePassword(String username, String password);

}
