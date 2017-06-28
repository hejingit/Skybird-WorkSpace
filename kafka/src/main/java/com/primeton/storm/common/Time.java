package com.primeton.storm.common;

public enum Time {
	MILLISECONDS(1), SECONDS(1000),MINUTES(SECONDS.getTime() * 60), HOURS(MINUTES.getTime() * 60), DAYS(HOURS.getTime() * 24),
	WEEKS(DAYS.getTime() * 7);
	
	private long millis;
	
	private Time(long millis){
		this.millis = millis;
	}
	
	public long getTime(){
		return this.millis;
	}
}
