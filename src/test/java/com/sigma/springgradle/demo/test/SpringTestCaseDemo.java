/**
 * 
 */
package com.sigma.springgradle.demo.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.testng.annotations.Test;

import com.sigma.springgradle.demo.controller.HomeController;

/**
 * @author Omega
 *
 * @date 2016年5月2日 下午4:46:30
 *
 * @project SpringGradleDemo
 */

public class SpringTestCaseDemo extends AbstractTestCase {
    
    @Autowired
    private HomeController homeController;
    
    @Test
    public void testController1() throws Exception {
        this.mockMvc.perform(get("/index/home/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(content().string("{\"message\":\"test jenkins hook!\"}"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
    public void testController2() throws Exception {
        this.mockMvc.perform(get("/index/home/2").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(content().string("{\"message\":\"none!\"}"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
    public void testController3() throws Exception {
        this.mockMvc.perform(get("/index/user/2").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(content().string("{\"message\":\"x bigger then one\"}"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
    public void testController4() throws Exception {
        this.mockMvc.perform(get("/index/user/-1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(content().string("{\"message\":\"x less then one\"}"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
    public void testController5() throws Exception {
        this.mockMvc.perform(get("/index/user/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(content().string("{\"message\":\"x equals to one\"}"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
    public void testController6() throws Exception {
        this.getWithoutParamMock("/index/user/1", "{\"message\":\"x equals to one\"}");
    }
    
    @Override
    protected Object getController() {
        return this.homeController;
    }
}
