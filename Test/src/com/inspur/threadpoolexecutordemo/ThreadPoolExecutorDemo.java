package com.inspur.threadpoolexecutordemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(3), new MyRejected());
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		MyTask myTask1 = new MyTask(1, "任务1");
		MyTask myTask2 = new MyTask(2, "任务2");
		MyTask myTask3 = new MyTask(3, "任务3");
		MyTask myTask4 = new MyTask(4, "任务4");
		MyTask myTask5 = new MyTask(5, "任务5");
		MyTask myTask6 = new MyTask(6, "任务6");

		threadPoolExecutor.execute(myTask1);
		threadPoolExecutor.execute(myTask2);
		threadPoolExecutor.execute(myTask3);
		threadPoolExecutor.execute(myTask4);
		threadPoolExecutor.execute(myTask5);
		threadPoolExecutor.execute(myTask6);

		threadPoolExecutor.shutdown();
	}

}
