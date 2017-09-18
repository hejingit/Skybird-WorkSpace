package org.jinhe.example.dubbo.provider;

import javax.annotation.Resource;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.registry.RegistryService;

/**
 * 
 * ClassName: UnregistryUtil.java <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年8月2日上午9:34:11 <br/>
 *
 * @author Jin.He (mailto:hejin@primeton.com)
 * @version
 * @since
 */
public class UnregistryUtil {
	@Reference
	RegistryService registry;

	public void unregitryServers(String provider) {
		provider = "dubbo://10.66.65.165:20880/org.jinhe.example.dubbo.provider.DemoService?anyhost=true&application=demo_provider&dubbo=2.8.4&generic=false&interface=org.jinhe.example.dubbo.provider.DemoService&methods=sayHello,getUsers&pid=7263&side=provider×tamp=1501652249601";

		URL providerUrl = URL.valueOf(provider);
		registry.unregister(providerUrl);
	}

	public void regitryServers(String provider) {
		URL providerUrl = URL.valueOf(provider);
		registry.register(providerUrl);
	}
}
