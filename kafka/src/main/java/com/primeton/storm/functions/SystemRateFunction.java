package com.primeton.storm.functions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.storm.trident.operation.BaseFunction;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.tuple.TridentTuple;
import org.apache.storm.tuple.Values;

import com.primeton.storm.events.DubboInvoke;

/**
 * 计算系统级健康度.
 * @author sks
 *
 */
public class SystemRateFunction extends BaseFunction{

	private Map<String,Map<String,Double>> cache = new ConcurrentHashMap<String,Map<String,Double>>();
	
	private static final long serialVersionUID = -1053025110139790323L;

	public void execute(TridentTuple tuple, TridentCollector collector) {
		DubboInvoke event = (DubboInvoke)tuple.getValueByField("event");
		double rate = tuple.getDoubleByField("rate");
		String provider = event.getProviderAppName();
		Map<String,Double> serviceRateCache = cache.get("provider");
		if(serviceRateCache == null){
			serviceRateCache = new ConcurrentHashMap<String,Double>();
			cache.put(provider, serviceRateCache);
		}
		serviceRateCache.put(event.getService(), rate);
		
		collector.emit(new Values(calSysRate(provider)));
		
	}
	
	/**
	 * 计算系统平均健康度 = sum(已知的服务健康度) / 已知的服务个数
	 * @param provider
	 * @return
	 */
	private double calSysRate(String provider){
		Map<String,Double> serviceRateCahce = cache.get(provider);
		if(serviceRateCahce == null){
			return 0.0;
		}
		
		double sumValidRate = 0.0;
		int serviceValidNums = 0;
		for(Map.Entry<String, Double> serviceRateInfo : serviceRateCahce.entrySet()){
			double serviceRate = serviceRateInfo.getValue();
			if(serviceRate < 0.95){
				sumValidRate += serviceRateInfo.getValue();
				serviceValidNums++;
			}
			
		}
		
		if(serviceValidNums != 0){
			return sumValidRate / serviceValidNums;
		} else {
			return 1;
		}
	}

}
