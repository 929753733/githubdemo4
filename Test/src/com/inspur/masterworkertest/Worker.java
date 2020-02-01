package com.inspur.masterworkertest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
	
	private ConcurrentLinkedQueue<Task> workQueue;
	private ConcurrentHashMap<String, Object> resultMap;
	
	public void setWorkerQueue(ConcurrentLinkedQueue<Task> workQueue) {
		this.workQueue = workQueue;
		
	}

	public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	@Override
	public void run() {
		System.out.println("Worker的run()方法");
		while(true) {
			Task input = this.workQueue.poll();
			if(input == null) {
				break;
			}
			// 真正的去做业务处理
			Object output = handle(input);
			this.resultMap.put(Integer.toString(input.getId()), output);
		}
	}

	private Object handle(Task input) {
		Object output = null;
		try {
			Thread.sleep(500);
			output = input.getPrice();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return output;
	}

}
