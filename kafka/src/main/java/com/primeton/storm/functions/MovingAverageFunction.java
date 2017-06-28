package com.primeton.storm.functions;

import org.apache.storm.trident.operation.BaseFunction;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.tuple.TridentTuple;
import org.apache.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.primeton.storm.common.EWMA;

/**
 * 移动平均负载计算.
 * @author sks
 *
 */
public class MovingAverageFunction extends BaseFunction {

	private static final long serialVersionUID = 7921419969923020977L;

	private static final Logger log = LoggerFactory.getLogger(MovingAverageFunction.class);
	
	private EWMA ewma;

	public MovingAverageFunction(EWMA ewma) {
		super();
		this.ewma = ewma;
	}

	@Override
	public void execute(TridentTuple tuple, TridentCollector collector) {
		String service = tuple.getStringByField("service");
		this.ewma.mark(service,tuple.getBooleanByField("suc") == null ? true : tuple.getBooleanByField("suc"),tuple.getLongByField("invokeTime"));
		log.info("Rate:{}", this.ewma.getAverageRatePer(service));
		collector.emit(new Values(this.ewma.getAverageRatePer(service)));
	}

}
