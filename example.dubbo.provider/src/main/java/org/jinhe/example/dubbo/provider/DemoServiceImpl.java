/**
 * Project Name:example.dubbo.provider
 * File Name:DemoServiceImpl.java
 * Package Name:org.jinhe.example.dubbo.provider.impl
 * Date:2017年4月6日下午11:12:29
 * Copyright (c) 2017, Jin.He (mailto:hejin@primeton.com) All Rights Reserved.
 *
*/

package org.jinhe.example.dubbo.provider;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:DemoServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年4月6日 下午11:12:29 <br/>
 * @author   Jin.He (mailto:hejin@primeton.com)
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class DemoServiceImpl implements DemoService {

	public String sayHello(String name) {
		return "Hello " + name;
	}

	public List getUsers() {
		List list = new ArrayList();
		User u1 = new User();
		u1.setName("jack");
		u1.setAge(20);
		u1.setSex("m");

		User u2 = new User();
		u2.setName("tom");
		u2.setAge(21);
		u2.setSex("m");

		User u3 = new User();
		u3.setName("rose");
		u3.setAge(19);
		u3.setSex("w");

		list.add(u1);
		list.add(u2);
		list.add(u3);
		return list;
	}
}