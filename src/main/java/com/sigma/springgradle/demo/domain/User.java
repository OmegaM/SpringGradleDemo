/**
 * 
 */
package com.sigma.springgradle.demo.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Omega
 *
 * @date 2016年6月19日 下午5:33:39
 *
 * @project SpringGradleDemo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "id", "name", "age" })
public class User {
    
    public User() {
        
    }
    
    @JsonProperty(value = "id")
    @NotNull(message = "id param is null")
    @Min(value = 1, message = "id param must be great or equal than {{value}}")
    private long id;
    
    @NotNull(message = "name param is null")
    private String name;
    
    @NotNull(message = "age param is null")
    private int age;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
    
    public User(long id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
}
