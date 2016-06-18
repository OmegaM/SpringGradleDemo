/**
 * 
 */
package com.sigma.springgradle.demo.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sigma.springgradle.demo.controller.HomeController;

/**
 * @author Omega
 *
 * @date 2016年5月2日 下午4:46:30
 *
 * @project SpringGradleDemo
 */
// @RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring-mvc-config.xml" })
@WebAppConfiguration
public class SpringTestCaseDemo extends AbstractTestNGSpringContextTests {
    private MockMvc mockMvc;
    
    @Autowired
    private HomeController homeController;
    
    @BeforeMethod
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }
    
    @Test
    public void testController() throws Exception {
        this.mockMvc.perform(get("/index/home").contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
                .andExpect(content().string("{\"message\":\"test jenkins hook!\"}"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
