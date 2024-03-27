package com.example.lab11a.Service;

import com.example.lab11a.ApiResponce.ApiExeption;
import com.example.lab11a.Model.User;
import com.example.lab11a.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public void addUser(User user){
         user.setRegistrationDate(LocalDate.now());
        userRepository.save(user);
    }

    public void updateUser(Integer id,User user){

        User u=userRepository.findUserById(id);

        if(u==null){
            throw new ApiExeption("wrong id");

        }
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        u.setRegistrationDate(user.getRegistrationDate());

        userRepository.save(u);
    }

    public void deleteUser(Integer id){
        User u=userRepository.findUserById(id);
        if(u==null){
            throw new ApiExeption("wrong id");

        }
        userRepository.delete(u);

    }
    public User searchByusernameandpassword(String username,String password){
        User u=userRepository.findUserByUsernameAndPassword(username,password);
        if(u==null){
            throw new ApiExeption("not found");
        }
        return u;
    }

    public User searchByusername(String username){
        User u=userRepository.findbyusername(username);
        if(u==null){
            throw new ApiExeption("not found");
        }
        return u;
    }



}
