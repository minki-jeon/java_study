package main.study.java.func.function;

import java.util.Scanner;
import java.util.function.Function;

public class StringLengthExample {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/functional/function/StringLengthExample.java
	
	public static void main(String[] args) {
		Function<String, Integer> stringLength = s -> s.length();
		// 매개변수타입: String, 반환타입: Integer
		
		String str = "Function of String Length";
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			//input
			System.out.println("길이를 체크할 문자를 입력하세요. 종료하시려면 '종료'를 입력하세요.");
			str = sc.nextLine();
			
			//break
			if ("종료".equals(str)) {
				sc.close(); break;
			}
			
			//result
			int length = stringLength.apply(str);
			System.out.println("'"+str+"' 문자의 길이는 "+length+" 입니다.");
		}
	}
}
