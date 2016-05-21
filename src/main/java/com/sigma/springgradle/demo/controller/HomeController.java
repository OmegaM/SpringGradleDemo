/**
 * 
 */
package com.sigma.springgradle.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Omega
 *
 * @date 2016年5月1日 下午11:43:02
 *
 * @project SpringGradleDemo
 */
@RestController
@RequestMapping("index")
public class HomeController
{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    
    /**
     * home方法
     * @return map
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public Map<String, String> home()
    {
        String string = null;
        string.toLowerCase();
        LOGGER.error("++++++ into HomeController ++++++");
        Map<String, String> map = new HashMap<>();
        map.put("message", "test jenkins hook!");
        return map;
    }
}
