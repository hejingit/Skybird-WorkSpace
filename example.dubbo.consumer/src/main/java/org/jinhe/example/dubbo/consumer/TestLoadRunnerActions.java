package org.jinhe.example.dubbo.consumer;


import org.jinhe.example.dubbo.provider.DemoService;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;

/**
 * 
 * ClassName: Actions <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年4月7日 下午2:21:56 <br/>
 *
 * @author Jin.He (mailto:hejin@primeton.com)
 * @version 
 * @since JDK 1.7
 */
public class TestLoadRunnerActions
{

    private  final String ID = "ID";

    private final String URL = "dubbo://127.0.0.1:20880";

    private final String VERSION = "1.0.0";

    private final String SERVICE_NAME = "org.jinhe.example.dubbo.provider.DemoService";   

    private Object object;

	@Before
	public void init() {
		ApplicationConfig application = new ApplicationConfig();
		application.setName("demo_consumer");

		ReferenceConfig  reference = new ReferenceConfig(); 
		reference.setApplication(application);
		reference.setId(ID);
		//reference.setVersion(VERSION);
		reference.setInterface(SERVICE_NAME);
		

		reference.setUrl(URL);

	    object = reference.get();
		
	}
	
	@Test
    public void action() throws Throwable {
        DemoService demoService = (DemoService)object;
        String hello = demoService.sayHello("tom");
        System.out.println(hello);
    }

}
