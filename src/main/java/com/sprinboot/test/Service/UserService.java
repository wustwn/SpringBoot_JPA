package com.sprinboot.test.Service;

import com.sprinboot.test.Repository.UserRepository;
import com.sprinboot.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void removeByuserDetail(String email){
        //userRepo.removeByTaskProperty(email);
        Optional.ofNullable(userRepo.findByuserDetailLike("%"+email+"%"))
                .ifPresent(userRepo::delete);
    }
}
