package com.primeton.storm.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EWMA implements Serializable{

	private static final long serialVersionUID = -1714160878576098460L;
	private long window;
	private double alpha = -1D; //0~1,越接近0平滑度越低，移动平均数越趋近当前值，aplpah越接近1，越平滑
	private boolean sliding = false;
	private Map<String,CalResult> serviceCalResultMap = new HashMap<String,CalResult>();
	
	//Unix计算负载常数
	public static final double ONE_MINUTE_ALPHA = 1 - Math.exp(-5d / 60d / 1d); //最大 0.079
	public static final double FIVE_MINUTE_ALPHA = 1 - Math.exp(-5d / 60d / 5d); //中小 0.016
	public static final double FIFTEEN_MINUTE_ALPHA = 1 - Math.exp(-5d / 60d / 15d); //最小 0.0005

	//当前时间窗口内所有服务调用的统计次数
	private Map<String,Counter> counterMap = new ConcurrentHashMap<String,Counter>();

	public EWMA(){}
	
	/**
	 * 设置滑动窗口区间.
	 * @param count
	 * @param time
	 * @return
	 */
	public EWMA sliding(double count, Time time){
		return this.sliding((long)(time.getTime() * count));
	}
	
	/**
	 * 设置滑动窗口区间.
	 * @param window 毫秒数
	 * @return
	 */
	public EWMA sliding(long window){
		this.sliding = true;
		this.window = window;
		return this;
	}
	
	/**
	 * 设置计算因子.
	 * @param alpha
	 * @return
	 */
	public EWMA withAlpha(double alpha){
		if(!(alpha > 0.0D && alpha < 1.0D)){
			throw new IllegalArgumentException("Alpha must be between 0.0 and 1.0");
		}
		this.alpha = alpha;
		return this;
	}


	/**
	 * 根据传入的服务和调用时间，计算结果.
	 * @param service
	 * @param time
	 */
	public synchronized void mark(String service,boolean isSuc,long time){
		CalResult result = serviceCalResultMap.get(service);
		if(result == null){
			result = new CalResult();
			result.setLastInvokeTime(time);
			result.setAverage(0d);
			serviceCalResultMap.put(service, result);
			counterMap.put(service, new Counter());
		} else{
			
			//统计每分钟调用次数
			if(this.sliding){
				if(time - result.getLastInvokeTime() > this.window){
					result.setLastInvokeTime(time);
				} 
			}
			long diff = time - result.getLastInvokeTime();
			double alpha = this.alpha != -1.0 ? this.alpha : Math.exp(-1.0 * ((double) diff / this.window));
			result.setAverage((1.0 - alpha) * diff + alpha *  result.getAverage());
			result.setLastInvokeTime(time);
			
		}
		
	}
	
	/**
	 * 获取某服务的统计计算结果.
	 * @param service
	 * @return
	 */
	public CalResult getCalResult(String service){
		return this.serviceCalResultMap.get(service);
	}
	
	
	/**
	 * 获取某服务的滑动窗口内的平均调用次数.
	 * @param service
	 * @return
	 */
	public double getAverageRatePer(String service){
		CalResult result = getCalResult(service);
		if(result == null || result.getAverage() == 0d){
			return 0.0;
		} else {
			return this.window / result.getAverage();
		}
	}
	
	/**
	 * 获取本服务的当前调用成功率.
	 * @param service
	 * @return
	 */
	public double getSucRate(String service){
		return getCalResult(service).getSucRate();
	}

	public long getWindow() {
		return window;
	}

	public void setWindow(long window) {
		this.window = window;
	}
	
}
