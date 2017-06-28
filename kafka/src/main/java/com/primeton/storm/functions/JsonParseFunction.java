package com.primeton.storm.functions;

import org.apache.storm.trident.operation.BaseFunction;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.tuple.TridentTuple;
import org.apache.storm.tuple.Values;

import com.alibaba.fastjson.JSON;
import com.primeton.storm.events.DubboInvoke;

/**
 * 从kafka获取的字符串转换为对象.
 * @author sks
 *
 */
public class JsonParseFunction extends BaseFunction {

	private static final long serialVersionUID = 2510503475886955746L;
	
	public void execute(TridentTuple tuple, TridentCollector collector) {
		String json = new String((byte[])tuple.getValue(0));
		Values values = new Values();
		values.add(JSON.parseObject(json,DubboInvoke.class));
		collector.emit(values);
	}

}
