
public class TestThread {

	public static void main(String[] args) {
		
		Runnable runner = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("foo");
			}
		};
		
		Thread t = new Thread(runner);
		t.run();
		System.out.println("bar");

	}

}
