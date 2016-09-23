package org.skybird.example.springboot.hellworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @author Jin.He
* @version 2016年9月23日 上午10:15:08
*/
@Controller
@EnableAutoConfiguration
public class SimpleController {
 
    @RequestMapping(value ="/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "hello world";
    }
 
    public static void main(String[] args) {
        SpringApplication.run(SimpleController.class, args);
    }
}
