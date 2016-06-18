/**
 * 
 */
package com.sigma.springgradle.demo.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

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
    
}
