/**
 * 
 */
package com.sigma.springgradle.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sigma.springgradle.demo.domain.User;
import com.sigma.springgradle.demo.service.UserService;

/**
 * @author Omega
 *
 * @date 2016年6月19日 下午5:33:51
 *
 * @project SpringGradleDemo
 */
@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public User create(@RequestBody @Valid User user) {
        User user2 = new User(user.getId(), user.getName(), user.getAge());
        return user2;
    }
    
    @RequestMapping(value = "/query", method = RequestMethod.GET, produces = "application/json")
    public User queryByName(@RequestParam("name") String name, @RequestParam("fav") String fav) {
        System.err.println(fav);
        User user = new User(99L, name, 99);
        return user;
    }
    
    @RequestMapping(value = "/service", method = RequestMethod.GET, produces = "application/json")
    public Map<String, String> queryByName() {
        Map<String, String> map = new HashMap<>();
        String result = userService.send("google");
        map.put("msg", result);
        return map;
    }
}
