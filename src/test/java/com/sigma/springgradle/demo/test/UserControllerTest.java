/**
 * 
 */
package com.sigma.springgradle.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sigma.springgradle.demo.controller.UserController;
import com.sigma.springgradle.demo.domain.User;

/**
 * @author Omega
 *
 * @date 2016年6月19日 下午5:37:10
 *
 * @project SpringGradleDemo
 */
public class UserControllerTest extends AbstractTestCase {
    
    @Autowired
    private UserController userController;
    
    @Test
    public void testController6() throws Exception {
        this.postMock("/users", "{\"id\":1,\"name\":\"Bert Lee\",\"age\":26}",
                "{\"id\":1,\"name\":\"Bert Lee\",\"age\":26}");
    }
    
    @Test
    public void testUser2String() {
        User user = new User(1L, "google", 22);
        Assert.assertEquals(user.toString(), "User [id=1, name=google, age=22]");
    }
    
    @Override
    protected Object getController() {
        return this.userController;
    }
    
}
