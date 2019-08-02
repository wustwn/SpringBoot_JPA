package com.sprinboot.test.Service;

import com.sprinboot.test.Repository.UserRepository;
import com.sprinboot.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public void save(User user){
        userRepo.save(user);
    }
    public List<User> findAll(){
        List<User> urList=userRepo.findAll();
        return urList;
    }
    public void removeByTaskProperty(String email){
        userRepo.removeByTaskProperty(email);
    }
}
