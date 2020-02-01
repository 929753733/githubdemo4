import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTest {
	
	public static void main(String[] args) {
		LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>();
		linkedBlockingQueue.add("a");
		linkedBlockingQueue.add("b");
		linkedBlockingQueue.add("c");
		linkedBlockingQueue.add("d");
		linkedBlockingQueue.add("e");
		linkedBlockingQueue.add("f");
		
		List<String> list = new ArrayList<String>();
		
		System.out.println(linkedBlockingQueue.drainTo(list, 3));
		
		for (String string : list) {
			System.out.println(string);
		}
	}

}
