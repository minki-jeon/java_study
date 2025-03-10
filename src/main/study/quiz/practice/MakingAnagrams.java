package main.study.quiz.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakingAnagrams {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/quiz/practice/MakingAnagrams.java

	public static void main(String[] args) {
		//* 두 문자열이 애너그램을 이루는지 유무 확인
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		System.out.println(numberNeeded(a, b));
	}

	private static boolean numberNeeded(String a, String b) {
		char[] one = a.toCharArray();
		char[] two = b.toCharArray();
		
		Map<Character, Integer> letter = new HashMap<Character, Integer>();
		int count;
		
		for (char c : one) {
			count = letter.containsKey(c) ? letter.get(c) : 0;
			letter.put(c, count + 1);
		}
		for (char c : two) {
			count = letter.containsKey(c) ? letter.get(c) : 0;
			letter.put(c, count - 1);
		}
		
		int result = 0;
		for (char c : letter.keySet()) {
			result += Math.abs(letter.get(c));		// 절대값(양수) 처리
		}
		
		return result == 0;
	}

}
