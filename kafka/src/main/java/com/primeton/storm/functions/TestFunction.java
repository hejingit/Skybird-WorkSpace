package com.primeton.storm.functions;

import org.apache.storm.trident.operation.BaseFunction;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.tuple.TridentTuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 打印，调试用.
 * @author sks
 *
 */
public class TestFunction extends BaseFunction {

	private static final long serialVersionUID = 8346153037194254605L;
	private static final Logger log = LoggerFactory.getLogger(TestFunction.class);

	public void execute(TridentTuple tuple, TridentCollector collector) {
		log.info(tuple.toString());
	}

}
