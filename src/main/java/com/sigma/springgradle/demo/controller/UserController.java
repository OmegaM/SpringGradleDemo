/**
 * 
 */
package com.sigma.springgradle.demo.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sigma.springgradle.demo.domain.User;

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
    
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public User create(@RequestBody @Valid User user) {
        User user2 = new User(user.getId(), user.getName(), user.getAge());
        return user2;
    }
}
