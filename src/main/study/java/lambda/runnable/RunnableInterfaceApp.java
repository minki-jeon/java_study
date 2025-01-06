package main.study.java.lambda.runnable;

public class RunnableInterfaceApp {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/lambda/runnable/RunnableInterfaceApp.java

	public static void main(String[] args) {
		RunnableThread runnableThread = new RunnableThread();
		
		//람다 표현식을 이용한 스레드 생성
		Thread thread1 = new Thread(() -> System.out.println("람다 포현식 " + Thread.currentThread().getName()));
		
		//Runnable 메서드 참조를 사용한 스레드 생성
		Thread thread2 = new Thread(runnableThread::run);

		thread1.start();
		thread2.start();
	}

}
