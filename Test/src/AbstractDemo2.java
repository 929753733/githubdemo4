
public class AbstractDemo2 extends AbstractDemo1 {
	
	public static void main(String[] args) {
		AbstractDemo2 abstractDemo2 = new AbstractDemo2();
		System.out.println(abstractDemo2.aString);
//		abstractDemo2.e();
		AbstractDemo1 abstractDemo1 = new AbstractDemo2();
		abstractDemo1.c();
		
	}
	
	public void c() {
		System.out.println("cccccc");
	}

//	@Override
//	public void e() {
//		System.out.println("e");
//	}

}
