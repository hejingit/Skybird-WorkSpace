package org.skybird.example.springboot;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;  
/**
 * 
 * ClassName: Ctl.java <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年9月18日下午1:52:44 <br/>
 *
 * @author Jin.He (mailto:hejin@primeton.com)
 * @version 
 * @since 
 */
@RestController  
@RequestMapping("/")
public class Ctl {
	@RequestMapping(value="/", method=RequestMethod.GET)  
    String home(){  
        return "Hello world";  
    }  
          
    @SuppressWarnings("deprecation")  
    @RequestMapping("/now")  
    String getTime(){  
        return "Current time: " + (new Date()).toLocaleString();  
    } 
}
