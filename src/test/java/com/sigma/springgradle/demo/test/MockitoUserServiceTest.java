/**
 * 
 */
package com.sigma.springgradle.demo.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Test;

import com.sigma.springgradle.demo.controller.UserController;
import com.sigma.springgradle.demo.service.UserService;

/**
 * @author Omega
 *
 * @date 2016年6月19日 下午10:48:54
 *
 * @project SpringGradleDemo
 */
public class MockitoUserServiceTest extends AbstractTestCase {
    
    @Mock
    private UserService userService;
    
    @InjectMocks
    private UserController userController;
    
    @Test
    public void test() throws Exception {
        when(userService.send("google")).thenReturn("kafka");
        // invoke controll inside invoke userService
        this.getWithoutParamsMock("/users/service", "{\"msg\":\"kafka\"}");
        verify(userService).send("google");
    }
    
    @Override
    protected Object getController() {
        
        return userController;
    }
    
}
