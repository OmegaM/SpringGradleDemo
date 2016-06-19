/**
 * 
 */
package com.sigma.springgradle.demo.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;

/**
 * @author Omega
 *
 * @date 2016年6月18日 下午5:32:31
 *
 * @project SpringGradleDemo
 */
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring-mvc-config.xml" })
@WebAppConfiguration
public abstract class AbstractTestCase extends AbstractTestNGSpringContextTests {
    
    protected MockMvc mockMvc;
    
    /**
     * abstract method
     * 
     * @return 'this' testcase controller
     */
    protected abstract Object getController();
    
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.getController()).build();
    }
    
    protected void getWithoutParamMock(String url, String expectedContent) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(url);
        this.jsonRequestMock(builder, expectedContent);
    }
    
    protected void postMock(String url, String jsonParams, String expectedContent) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(url).content(jsonParams);
        this.jsonRequestMock(builder, expectedContent);
    }
    
    protected void jsonRequestMock(MockHttpServletRequestBuilder builder, String expectedContent) throws Exception {
        builder.contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8");
        
        this.mockMvc.perform(builder).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedContent)).andDo(MockMvcResultHandlers.print());
        
    }
}
