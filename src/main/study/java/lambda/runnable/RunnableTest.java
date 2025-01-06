package main.study.java.lambda.runnable;

public class RunnableTest {
	//* ref. chatGPT
	
	public static void main(String[] args) {
        // Runnable 생성 (thread 확장 작업 구현)
        Runnable runnable = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("thread 작업 진행: " + i);
                try {
                    Thread.sleep(500); // 0.5초
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        
        Runnable runnable2 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("thread2 작업 진행: " + i);
                try {
                    Thread.sleep(700); // 0.7초
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        
        Runnable runnable3 = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("thread3 작업 진행: " + i);
                try {
                    Thread.sleep(1000); // 0.7초
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // thread 생성
        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);

        // thread 실행
        thread.start();
        thread2.start();

        System.out.println("Main thread continues...");
        
        
        //* Runnable 단일 thread 실행 (ex. 기능 테스트)
        runnable3.run();
        
        //* Runnable에 구현한 동일한 기능을 다중 Thread로 실행
        Thread thread3 = new Thread(runnable3);
        Thread thread4 = new Thread(runnable3);
        Thread thread5 = new Thread(runnable3);
        
        // runnable3 의 동작이 종료된 이후에 실행
        thread3.start();
        thread4.start();
        thread5.start();
        
	}
	

}
