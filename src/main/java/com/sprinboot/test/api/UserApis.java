package com.sprinboot.test.api;

import com.google.gson.JsonArray;
import com.sprinboot.test.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sprinboot.test.pojo.User;
import com.google.gson.JsonObject;

import java.util.List;

@RestController
@RequestMapping(path="/")
public class UserApis {
    @Autowired
    private UserService userSrv;
    @RequestMapping(value = "/addUser")
    public String addNewUser(@RequestParam String name, @RequestParam String password) {
        try {
            User u = new User();
            u.setName("nick");
            u.setPwd("intel@123");
            JsonObject juserdetail = new JsonObject();
            juserdetail.addProperty("email","intel@123");
            u.setUserDetail(juserdetail.toString());
            userSrv.save(u);
            return "add user successful !";
        }catch (Exception e)
        {
            return e.toString();
        }

    }


    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getAllUsers() {
        List<User> userls=userSrv.findAll();
        JsonObject jResult=new JsonObject();
        JsonArray jUserAr = new JsonArray();
        for(User u : userls)
        {
            jUserAr.add(u.getName());
            jUserAr.add(u.getUserDetail());
        }
        jResult.add("user_list", jUserAr);

        return new ResponseEntity<String>(jResult.toString(), HttpStatus.OK);
    }



    @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> deleteUser() {
        //userSrv.removeByTaskProperty("intel@123");

        return new ResponseEntity<String>("delete successfully", HttpStatus.OK);
    }


}
