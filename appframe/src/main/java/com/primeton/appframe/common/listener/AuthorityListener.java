package com.primeton.appframe.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.primeton.appframe.service.OperationService;


/**
 * 
 * ClassName: AuthorityListener <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年10月17日 下午12:29:37 <br/>
 * 权限监听器
 * @author Jin.He (mailto:hejin@primeton.com)
 * @version
 */
//@WebListener(与ServletComponentScan注解一起使用;现在用另一种方式,交由WebConfig统一管理配置)
public class AuthorityListener implements ServletContextListener {
	@Autowired  
    ApplicationContext context;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		//加载自动注入Autowired
		WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext()).getAutowireCapableBeanFactory().autowireBean(this);
		OperationService operationService = context.getBean(OperationService.class);
		operationService.initAuthority();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("销毁监听器.....");
	}
}
