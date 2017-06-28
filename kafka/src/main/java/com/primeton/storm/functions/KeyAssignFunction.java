package com.primeton.storm.functions;

import org.apache.storm.trident.operation.BaseFunction;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.tuple.TridentTuple;
import org.apache.storm.tuple.Values;

import com.primeton.storm.events.DubboInvoke;

public class KeyAssignFunction extends BaseFunction{

	private static final long serialVersionUID = 6957198202132979017L;

	private long window;
	
	public KeyAssignFunction(long window){
		this.window = window;
	}
	
	
	@Override
	public void execute(TridentTuple tuple, TridentCollector collector) {
		DubboInvoke event = (DubboInvoke) tuple.getValueByField("event");
		String service = event.getService();
		long staticsTime = event.getInvokeTime() / window;
		String key = service + ":" + staticsTime;
		collector.emit(new Values(key));
		
	}

}
