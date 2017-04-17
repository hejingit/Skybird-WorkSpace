/**
 * Project Name:example.dubbo.restdemo
 * File Name:UserServiceImpl.java
 * Package Name:example.dubbo.restdemo.services
 * Date:2017年4月7日下午5:00:05
 * Copyright (c) 2017, Jin.He (mailto:hejin@primeton.com) All Rights Reserved.
 *
*/

package example.dubbo.restdemo.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * ClassName:UserServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年4月7日 下午5:00:05 <br/>
 * 
 * @author Jin.He (mailto:hejin@primeton.com)
 * @version
 * @since JDK 1.7
 * @see
 */
@Path("users")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class UserServiceImpl implements UserService {
	
	public void registerUser(User user) {
		System.out.println("USE Id========" + user.getUserId());
		System.out.println("USE Name======" + user.getUserName());
	}

	public User getUser(Long id) {
		User user=new User();
		user.setUserId(1);
		user.setUserName("userName");
		return user;
	}

}
