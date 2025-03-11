package main.study.quiz;

import java.util.Arrays;

public class EncodedString {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/quiz/EncodedString.java
	//* 1부터 26까지 숫자를 나타내는 (인코딩된) 문자열에서 (디코딩하여) 각 숫자 개수를 반환
	//* 한자리 숫자는 별도 기호 사용하지 않음
	//* 두자리 숫자는 #을 숫자 뒤에 덧붙인다.
	//* 연속된 숫자는 (n)과 같이 연속횟수를 작성한다.
	public static void main(String[] args) {
		String s = "23#(2)24#15#(3)36925#26#23#(3)";
		int[] result = frequency(s);
		System.out.println(Arrays.toString(result));
	}

	private static int[] frequency(String s) {
		int[] result = new int[26];
		
		int size = s.length();
		int i = 0;
		while (i < size) {
			int val = 0;
			if (i + 2 >= size || s.charAt(i + 2) != '#') {
				val = s.charAt(i) - '0';
				result[val - 1]++;
				i++;
			} else if (s.charAt(i + 2) == '#') {
				val = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
				result[val - 1]++;
				i = i + 3;
			}
			if (i < size) {
				if (s.charAt(i) == '(') {
					int frequen = s.charAt(i + 1) - '0';
					result[val - 1] += frequen - 1;
					i = i + 3;
				}
			}
		}
		
		return result;
	}
}
