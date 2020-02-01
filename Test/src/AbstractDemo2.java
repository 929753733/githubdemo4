
public class AbstractDemo2 extends AbstractDemo1 {
	
	public static void main(String[] args) {
		AbstractDemo2 abstractDemo2 = new AbstractDemo2();
		System.out.println(abstractDemo2.aString);
		abstractDemo2.e();
	}

	@Override
	public void e() {
		System.out.println("e");
	}

}
