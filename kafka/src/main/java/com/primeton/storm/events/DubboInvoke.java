package com.primeton.storm.events;

import java.io.Serializable;

public class DubboInvoke implements Serializable {

	private static final long serialVersionUID = -6171886916270041104L;
	private String consumerAppName;
	private String consumerIP;
	private String service;
	private String providerIP;
	private String providerAppName;
	private long invokeTime;
	private String time;
	private boolean isSuc;
	private double timeCost;
	private boolean isTimeOut;

	public String getConsumerAppName() {
		return consumerAppName;
	}
	public void setConsumerAppName(String consumerAppName) {
		this.consumerAppName = consumerAppName;
	}
	public String getConsumerIP() {
		return consumerIP;
	}
	public void setConsumerIP(String consumerIP) {
		this.consumerIP = consumerIP;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getProviderIP() {
		return providerIP;
	}
	public void setProviderIP(String providerIP) {
		this.providerIP = providerIP;
	}
	public String getProviderAppName() {
		return providerAppName;
	}
	public void setProviderAppName(String providerAppName) {
		this.providerAppName = providerAppName;
	}
	public long getInvokeTime() {
		return invokeTime;
	}
	public void setInvokeTime(long invokeTime) {
		this.invokeTime = invokeTime;
	}

	public boolean isSuc() {
		return isSuc;
	}
	public void setSuc(boolean isSuc) {
		this.isSuc = isSuc;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public double getTimeCost() {
		return timeCost;
	}
	public void setTimeCost(double timeCost) {
		this.timeCost = timeCost;
	}
	public boolean isTimeOut() {
		return isTimeOut;
	}
	public void setTimeOut(boolean isTimeOut) {
		this.isTimeOut = isTimeOut;
	}
	public String toString(){
		return "[ ConsumerName:"+this.consumerAppName+", ConsumerIP:"+this.consumerIP
				+ ", Service:"+this.service + ", ProviderName:"+this.providerAppName
				+ ", ProviderIP:"+this.providerIP+"]";
	}
	
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		} else if(obj.getClass() != this.getClass()){
			return false;
		} else if(this.toString().equals(obj.toString())){
			return true;
		} else {
			return false;
		}
	}
	
	public int hashCode(){
		return this.toString().hashCode();
	}
	

}
