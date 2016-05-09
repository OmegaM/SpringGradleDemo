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
public class HomeController {
    
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/home", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public Map<String, String> home(){
        logger.error("++++++ into HomeController ++++++");
        Map<String, String> map = new HashMap<>();
        map.put("message", "this is my first gradle springmvc project!");
        return map;
    }
}
