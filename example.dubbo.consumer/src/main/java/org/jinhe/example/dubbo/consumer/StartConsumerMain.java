package org.jinhe.example.dubbo.consumer;

import java.io.IOException;

import org.jinhe.example.dubbo.provider.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * ClassName: StartConsumerMain <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年4月7日 下午2:46:40 <br/>
 *
 * @author Jin.He (mailto:hejin@primeton.com)
 * @version 
 * @since JDK 1.7
 */
public class StartConsumerMain 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello consumer!" );
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		context.start();

		DemoService demoService = (DemoService) context.getBean("demoService");
		String hello = demoService.sayHello("====s===tom====s===");
		System.out.println(hello);

		System.in.read();
    }
}
