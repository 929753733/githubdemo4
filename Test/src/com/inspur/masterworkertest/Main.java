package com.inspur.masterworkertest;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		Master master = new Master(new Worker(), 10);
		System.out.println("1.=============");
		Random random = new Random();
		
		for(int i = 1; i <= 100; i++) {
			Task t = new Task();
			t.setId(i);
			t.setName("任务"+i);
			t.setPrice(random.nextInt(1000));
			master.submit(t);
		}
		master.execute();
		
		long start = System.currentTimeMillis();
		
		while(true) {
			if(master.isComplete()) {
				long end = System.currentTimeMillis() - start;
				// 为什么worker的resultMap被赋值，master会获取到？？？
				int ret = master.getResult();
				System.out.println("最终结果"+ret+"，执行耗时"+end);
				break;
			}
		}
		
	}
	
	

}
