package com.primeton.storm.events;

public class ServiceRateInfo {
	private String service;
	private double rate;
	
	public ServiceRateInfo(String service, double rate) {
		super();
		this.service = service;
		this.rate = rate;
	}
	public final String getService() {
		return service;
	}
	public final void setService(String service) {
		this.service = service;
	}
	public final double getRate() {
		return rate;
	}
	public final void setRate(double rate) {
		this.rate = rate;
	}
	
	
}
