package com.primeton.storm.common;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 计数器.
 * @author sks
 *
 */
public class Counter {
	/**
	 * 当前窗口期内总次数
	 */
	private AtomicLong invokeTimesInWindow;
	
	/**
	 * 当前窗口期内成功调用次数
	 */
	private AtomicLong sucInvokeTimesInWindow;

	
	public Counter(){
		init();
	}

	public void incrementInvokeTimesInWindow(){
		invokeTimesInWindow.incrementAndGet();
	}
	
	public void incrementSucInvokeTimesInWindow(){
		sucInvokeTimesInWindow.incrementAndGet();
	}
	
	public void decrementInvokeTimesInWindow(){
		invokeTimesInWindow.decrementAndGet();
	}
	
	public void decrementSucInvokeTimesInWindow(){
		sucInvokeTimesInWindow.decrementAndGet();
	}
	
	public double getSucRate(){
		if(invokeTimesInWindow.longValue() == 0l){
			return 0;
		}
		return sucInvokeTimesInWindow.doubleValue() / invokeTimesInWindow.doubleValue();
	}
	
	public AtomicLong getInvokeTimesInWindow() {
		return invokeTimesInWindow;
	}
	public void setInvokeTimesInWindow(AtomicLong invokeTimesInWindow) {
		this.invokeTimesInWindow = invokeTimesInWindow;
	}
	public void init(){
		this.invokeTimesInWindow = new AtomicLong(0l);
		this.sucInvokeTimesInWindow = new AtomicLong(0l);
	}
}
