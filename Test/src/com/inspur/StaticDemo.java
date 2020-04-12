package com.inspur;

public class StaticDemo {
	String a = "aaa";
	static String b = "aaa";
	
	public static void aaa() {
		System.out.println("aaaaa");
	}
	
	public void bbb() {
		System.out.println(a);
		System.out.println(b);
		ccc();
		ggg();
		System.out.println("bbbbb");
	}
	
	public static void ccc() {
		System.out.println(b);
		StaticDemo staticDemo = new StaticDemo();
		staticDemo.bbb();
		System.out.println("ccccc");
		
		class eee {
			
			final String aString = "aaaa";
		}
	}
	
	class fff {
		StaticDemo staticDemo2 = new StaticDemo();
		public void ggg() {
			System.out.println();
		}
	}
	
	public void ggg() {
		System.out.println("gggg");
	}
	
	public static void main(String[] args) {
		ccc();
		System.out.println(Integer.MAX_VALUE);
		System.out.println();
	}

}
