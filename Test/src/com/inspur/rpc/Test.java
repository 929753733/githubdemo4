package com.inspur.rpc;

public class Test {
	
	public static void main(String[] args) {
		new Thread( () ->  {
	        try {
	            Server server = new Server(12000);
	            server.start();
	        } catch (IOException e){
	            System.out.println(e.getMessage());
	        }
	    } ).start();

	    SocketClientProxy proxy = new SocketClientProxy();
	    StudentService studentService = proxy.getProxy(StudentService.class);
	    Student student = studentService.getInfo();
	    System.out.println(student.getName());
	}

}
