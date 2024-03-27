package com.example.lab11a.Repository;

import com.example.lab11a.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserById(Integer id);

    User findUserByUsernameAndPassword(String username,String password);

    @Query("select u from User u where u.username=?1")
    User findbyusername(String username);





}
