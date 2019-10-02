import java.util.Vector;

public class TestVector {
	
	public static void main(String[] args) {
		Vector<String> aVector = new Vector<String>();
		aVector.add("a");
		aVector.add("b");
		aVector.add("c");
		aVector.add("d");
		
		System.out.println(aVector.capacity());
	}
	

}
