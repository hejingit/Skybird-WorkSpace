package org.jinhe.example.dubbo.provider;
/**
 * Project Name:example.dubbo.provider
 * File Name:DemoService.java
 * Package Name:org.jinhe.example.dubbo.provider
 * Date:2017年4月6日下午11:07:24
 * Copyright (c) 2017, Jin.He (mailto:hejin@primeton.com) All Rights Reserved.
 *
*/


import java.util.List;

/**
 * ClassName:DemoService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年4月6日 下午11:07:24 <br/>
 * @author   Jin.He (mailto:hejin@primeton.com)
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface DemoService {

	String sayHello(String name);

	public List getUsers();

}

