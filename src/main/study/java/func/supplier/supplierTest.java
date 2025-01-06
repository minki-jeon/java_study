package main.study.java.func.supplier;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class supplierTest {
	//* https://m.blog.naver.com/zzang9ha/222087025042

	public static void main(String[] args) {
		Boolean supplier = true;	// Supplier 적용 유무
		
		long sec = System.currentTimeMillis();

		if (! supplier) {
			// getText() 항상 실행
			printText(true, getText());
			printText(false, getText());
			printText(false, getText());
		} else {
			// getText()에서 값을 get() 할 때만 실행 
			printText(true, () -> getText());
			printText(false, () -> getText());
			printText(false, () -> getText());
		}
		
		long time = (System.currentTimeMillis() - sec) / 1000;
		System.out.println("실행 시간 : " + time + "초");
	}

	public static String getText() {
		try {
			TimeUnit.SECONDS.sleep(2);	// 2초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Supplier Test";
	}
	
	public static void printText(Boolean bol, String txt) {
		if (bol) {
			System.out.println("get Text: " + txt);
		} else {
			System.out.println("false !");
		}
	}
	
	public static void printText(Boolean bol, Supplier<String> txt) {
		if (bol) {
			System.out.println("get Text: " + txt.get());
		} else {
			System.out.println("false !");
		}
	}
}
