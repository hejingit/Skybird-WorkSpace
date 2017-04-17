package org.jinhe.example.dubbo.provider;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * ClassName: StartPorviderMain <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年4月7日 下午2:46:06 <br/>
 *
 * @author Jin.He (mailto:hejin@primeton.com)
 * @version 
 * @since JDK 1.7
 */
public class StartPorviderMain 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello Dubbo Provider!" );
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		context.start();
		System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }
}
