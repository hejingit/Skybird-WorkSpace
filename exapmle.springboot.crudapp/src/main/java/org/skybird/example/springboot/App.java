package org.skybird.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * ClassName: App.java <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年9月15日下午4:29:17 <br/>
 *
 * @author Jin.He (mailto:hejin@primeton.com)
 * @version 
 * @since 
 */
@SpringBootApplication
//@ComponentScan(basePackages={"org.skybird.example.springboot","org.skybird.example.springboot.service"})  
//@ComponentScan(basePackages={"org.skybird.example.springboot"}) 
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(HomePageController.class, args);
    }
}
