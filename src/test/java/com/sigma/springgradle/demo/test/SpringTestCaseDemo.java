/**
 * 
 */
package com.sigma.springgradle.demo.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Omega
 *
 * @date 2016年5月2日 下午4:46:30
 *
 * @project SpringGradleDemo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(locations = "classpath*:spring-mvc-config.xml")
public class SpringTestCaseDemo extends AbstractJUnit4SpringContextTests{
    
    
    
    @Autowired
    private WebApplicationContext ctx;
    
    private MockMvc mockMvc;
    
    @Before
    public void setUp() throws Exception {
        logger.error("------into setUp------");
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).dispatchOptions(true).build();
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void test() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("index/home").accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        Assert.assertNotNull(mvcResult);
    }
    
}
