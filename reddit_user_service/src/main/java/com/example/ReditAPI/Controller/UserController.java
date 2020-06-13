package com.example.ReditAPI.Controller;

import com.example.ReditAPI.DAO.UserDao;
import com.example.ReditAPI.Models.Link;
import com.example.ReditAPI.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users",produces = "application/hal+json")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userDao.save(user);
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable(value = "id") Long userId){
        User user = userDao.findById(userId).orElse(null);
        final String uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toString();

        Link link = new Link(uri,"self");

        user.setLink(link);

        return user;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return  userDao.findAll();
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable(value = "id") Long userId, @RequestBody User newuser){
        User user = userDao.findById(userId).orElse(null);

        if(user!=null){
            user.setAge(newuser.getAge());
            user.setEmail(newuser.getEmail());
            user.setGender(newuser.getGender());
            user.setName(newuser.getName());

            userDao.save(user);
        }else{
            userDao.save(newuser);
        }

        return user;
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean>  deleteUser(@PathVariable(value = "id") Long userId) throws Exception{
        User user = userDao.findById(userId)
                        .orElseThrow(() -> new Exception("User not found on :: " + userId));

        userDao.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("status", Boolean.TRUE);
        return response;
    }
}
