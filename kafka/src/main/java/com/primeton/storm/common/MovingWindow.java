package com.primeton.storm.common;

import java.util.LinkedList;
import java.util.Queue;
import com.primeton.storm.events.DubboInvoke;
/**
 * 滑动窗口.
 * @author sks
 *
 */
public class MovingWindow{
	private long window;
	
	private Queue<DubboInvoke> queue = new LinkedList<DubboInvoke>();
	
	private Counter counter = new Counter();
	
	public MovingWindow(long window){
		this.window = window;
	}
	
	public void offer(DubboInvoke dubboInvoke){
		DubboInvoke head = queue.peek();
		if(head == null){
			queue.offer(dubboInvoke);
			counter.incrementInvokeTimesInWindow();
			if(dubboInvoke.isSuc()){
				counter.incrementSucInvokeTimesInWindow();
			}
		} else {
			while(head != null && (dubboInvoke.getInvokeTime() - head.getInvokeTime()) > window){
				queue.poll();
				counter.decrementInvokeTimesInWindow();
				if(head.isSuc()){
					counter.decrementSucInvokeTimesInWindow();
				}
				head = queue.peek();
			}
			queue.offer(dubboInvoke);
			counter.incrementInvokeTimesInWindow();
			if(dubboInvoke.isSuc()){
				counter.incrementSucInvokeTimesInWindow();
			}
			
		}
	}
	
	public int size(){
		return queue.size();
	}
	
	public double getSucRate(){
		return counter.getSucRate();
	}
	
}
