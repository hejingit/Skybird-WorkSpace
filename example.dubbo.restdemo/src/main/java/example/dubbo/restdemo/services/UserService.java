/**
 * Project Name:example.dubbo.restdemo
 * File Name:UserService.java
 * Package Name:example.dubbo.restdemo.services
 * Date:2017年4月7日下午4:58:45
 * Copyright (c) 2017, Jin.He (mailto:hejin@primeton.com) All Rights Reserved.
 *
*/

package example.dubbo.restdemo.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * ClassName:UserService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年4月7日 下午4:58:45 <br/>
 * @author   Jin.He (mailto:hejin@primeton.com)
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Path("users")
public interface UserService {
	@POST
	@Path("register")
	void registerUser(User user);
	
	@GET
	@Path("{id : \\d+}")
	User getUser(@PathParam("id") Long id) ;
}

