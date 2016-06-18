/**
 * 
 */
package com.sigma.springgradle.demo.service;

import org.springframework.stereotype.Service;

/**
 * @author Omega
 *
 * @date 2016年6月18日 下午9:52:49
 *
 * @project SpringGradleDemo
 */
@Service
public class HomeService {
    
    public String hello(int x) {
        if (x < 1) {
            return "x less then one";
        } else if (x == 1) {
            return "x equals to one";
        } else {
            return "x bigger then one";
        }
    }
}
