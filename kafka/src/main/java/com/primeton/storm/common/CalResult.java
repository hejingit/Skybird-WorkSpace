package com.primeton.storm.common;

public class CalResult {
	private long lastInvokeTime;
	private double average;
	private double sucRate;
	private long sumInvokeTimes;
	private long sumInvokeTimesInWindow;
	
	public long getLastInvokeTime() {
		return lastInvokeTime;
	}
	public void setLastInvokeTime(long lastInvokeTime) {
		this.lastInvokeTime = lastInvokeTime;
	}
	
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public double getSucRate() {
		return sucRate;
	}
	public void setSucRate(double sucRate) {
		this.sucRate = sucRate;
	}
	public long getSumInvokeTimes() {
		return sumInvokeTimes;
	}
	public void setSumInvokeTimes(long sumInvokeTimes) {
		this.sumInvokeTimes = sumInvokeTimes;
	}
	
	public long getSumInvokeTimesInWindow() {
		return sumInvokeTimesInWindow;
	}
	public void setSumInvokeTimesInWindow(long sumInvokeTimesInWindow) {
		this.sumInvokeTimesInWindow = sumInvokeTimesInWindow;
	}
	
	
}
