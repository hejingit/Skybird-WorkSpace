/**
 * Project Name:appframe
 * File Name:App.java
 * Package Name:com.primeton.appframe
 * Date:2017年10月17日上午11:51:27
 * Copyright (c) 2017, Jin.He (mailto:hejin@primeton.com) All Rights Reserved.
 *
*/

package com.primeton.appframe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primeton.appframe.common.datasource.DynamicDataSourceRegister;

/**
 * ClassName:App <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年10月17日 上午11:51:27 <br/>
 * @author   Jin.He (mailto:hejin@primeton.com)
 * @version  
 * @see 	 
 */
@Controller
//开启缓存
//@EnableCaching
@MapperScan(basePackages = "com.primeton.appframe.mapper")
@Import(DynamicDataSourceRegister.class)
@SpringBootApplication
public class App extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@RequestMapping("/")
	String home() {
		return "login";
	}
	
	@RequestMapping("/404")
	String notFound() {
		return "common/404";
	}
	
	@RequestMapping("/500")
	String error() {
		return "common/500";
	}
}
