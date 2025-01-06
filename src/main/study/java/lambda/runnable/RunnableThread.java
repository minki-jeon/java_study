package main.study.java.lambda.runnable;

public class RunnableThread implements Runnable {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/lambda/runnable/RunnableThread.java
	
	@Override
	public void run() {
		System.out.println("Runnable 구현 " + Thread.currentThread().getName());
	}
}
