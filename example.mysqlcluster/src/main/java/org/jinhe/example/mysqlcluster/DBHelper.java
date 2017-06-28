/**
 * Project Name:example.mysqlcluster
 * File Name:DBHelper.java
 * Package Name:org.jinhe.example.mysqlcluster
 * Date:2017年4月26日下午4:59:12
 * Copyright (c) 2017, Jin.He (mailto:hejin@primeton.com) All Rights Reserved.
 *
*/

package org.jinhe.example.mysqlcluster;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ClassName:DBHelper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年4月26日 下午4:59:12 <br/>
 * 
 * @author Jin.He (mailto:hejin@primeton.com)
 * @version
 * @since JDK 1.7
 * @see
 */
public class DBHelper {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

//	private static final String DATABASE_URL = "jdbc:mysql:loadbalance://172.16.66.131:3306,172.16.66.132:3306/testcls?roundRobinLoadBalance=true&useUnicode=true&characterEncoding=UTF-8";

	private static final String DATABASE_URL = "jdbc:mysql://172.16.66.100:3305/testcls?&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
	
	private static final String USER_NAME = "root";

	private static final String USER_PASSWORD = "root";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DATABASE_URL, USER_NAME, USER_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
