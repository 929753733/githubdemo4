import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	
	final List<String> list = new ArrayList<String>();
	
	public void add() {
		list.add("aaaaa");
	}
	
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		final CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						countDownLatchTest.add();
						System.out.println("当前线程：" + Thread.currentThread().getName() + "添加一个元素。。。");
						Thread.sleep(500);
						if(countDownLatchTest.size() == 5) {
							System.out.println("已经发出通知。。。");
							countDownLatch.countDown();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				if(countDownLatchTest.size() != 5) {
					try {
						countDownLatch.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("当前线程：" + Thread.currentThread().getName() + "收到停止程序停止。。。");
			}
		}, "t2");
		
		t2.start();
		t1.start();
	}

}
