/**
 * Project Name:example.dubbo.restdemo
 * File Name:TestApp.java
 * Package Name:example.dubbo.restdemo.services
 * Date:2017年4月7日下午5:36:17
 * Copyright (c) 2017, Jin.He (mailto:hejin@primeton.com) All Rights Reserved.
 *
*/

package example.dubbo.restdemo.services;

import java.io.IOException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:TestApp <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年4月7日 下午5:36:17 <br/>
 * @author   Jin.He (mailto:hejin@primeton.com)
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class TestApp {
	 public static void main( String[] args ) throws IOException
	    {
	        System.out.println( "Hello Dubbo Provider!" );
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext.xml" });
			context.start();
			System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
	    }
}

