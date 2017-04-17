/**
 * Project Name:example.dubbo.restdemo
 * File Name:User.java
 * Package Name:example.dubbo.restdemo.services
 * Date:2017年4月7日下午4:56:48
 * Copyright (c) 2017, Jin.He (mailto:hejin@primeton.com) All Rights Reserved.
 *
*/

package example.dubbo.restdemo.services;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * ClassName:User <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年4月7日 下午4:56:48 <br/>
 * @author   Jin.He (mailto:hejin@primeton.com)
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 @JsonProperty("userid")
	private int userId;
	 @JsonProperty("username")
	private String userName;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}

