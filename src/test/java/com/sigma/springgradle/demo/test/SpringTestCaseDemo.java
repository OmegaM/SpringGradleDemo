/**
 * 
 */
package com.sigma.springgradle.demo.test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Omega
 *
 * @date 2016年5月2日 下午4:46:30
 *
 * @project SpringGradleDemo
 */

public class SpringTestCaseDemo {
    
    @BeforeMethod
    public void setUp(){
        
    }
    
    @AfterMethod
    public void tearDown() throws Exception {
    }
    
    @Test
    public void test1() throws Exception {
        Assert.assertTrue(true);
    }
    
    @Test
    public void test2() throws Exception {
        Assert.assertTrue(true);
    }
    
    @Test
    public void test3() throws Exception {
        Assert.assertTrue(true);
    }
    
}
