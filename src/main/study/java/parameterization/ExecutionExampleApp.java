package main.study.java.parameterization;

public class ExecutionExampleApp {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/parameterization/ExecutionExampleApp.java

	public static void main(String[] args) {
		run(() -> System.out.println("Hello, world!!"));
	}
	
	public static void run(Runnable runnable) {
		runnable.run();
	}
	
	/**
	 * 	Thread thread = new Thread(() -> System.out.println("Hello, world!!"));
	 * 	thread.start();
	 */

}
