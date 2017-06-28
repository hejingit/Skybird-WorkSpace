package com.primeton.storm.functions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.storm.trident.operation.BaseFunction;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.tuple.TridentTuple;
import org.apache.storm.tuple.Values;

import com.primeton.storm.common.MovingWindow;
import com.primeton.storm.events.DubboInvoke;

/**
 * 移动成功率计算.
 * @author sks
 *
 */
public class ServiceRateFunction extends BaseFunction {

	private static final long serialVersionUID = 2266221921494077292L;

	//当前时间窗口内所有服务调用的统计次数
	private Map<String,MovingWindow> cache = new ConcurrentHashMap<String,MovingWindow>();
	
	private long window;
	
	public ServiceRateFunction(long window){
		this.window = window;
	}
	
	
	/**
	 * 统计成功率.
	 * @param event
	 * @return
	 */
	public double calSucRate(DubboInvoke event){
		String service = event.getService();
		MovingWindow queue = cache.get(service);
		if(queue == null){
			queue = new MovingWindow(window);
			cache.put(service, queue);
		} 	
		queue.offer(event);
		return queue.getSucRate();
	}
	
	@Override
	public void execute(TridentTuple tuple, TridentCollector collector) {
		DubboInvoke event = (DubboInvoke) tuple.getValueByField("event");
		collector.emit(new Values(calSucRate(event)));
		
	}

}
