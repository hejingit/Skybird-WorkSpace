package org.jinhe.example.dubbo.consumer;

import java.io.IOException;

import javax.annotation.Resource;

import org.jinhe.example.dubbo.provider.DemoService;
import org.jinhe.example.dubbo.provider.UnregistryUtil;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.registry.RegistryService;

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
		
		String provider = "dubbo://10.66.65.165:20880/org.jinhe.example.dubbo.provider.DemoService?anyhost=true&application=demo_provider&dubbo=2.8.4&generic=false&interface=org.jinhe.example.dubbo.provider.DemoService&methods=sayHello,getUsers&pid=7263&side=provider×tamp=1501652249601";
		URL providerUrl = URL.valueOf(provider);
		
		RegistryService registryService = (RegistryService) context.getBean("registry");
		registryService.unregister(providerUrl);
		
		
		//System.in.read();
    }
}
