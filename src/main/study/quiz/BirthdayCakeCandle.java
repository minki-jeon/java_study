package main.study.quiz;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BirthdayCakeCandle {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/quiz/BirthdayCakeCandle.java

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//* size input : 4
		//* value input : 3 2 1 3

		//* 입력값들을 배열에 저장
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int ar_i = 0; ar_i < n; ar_i++) {
			ar[ar_i] = in.nextInt();
		}
		//* 입력받은 값 중에 중복된 숫자를 카운트하고 최대 카운트를 result 반환
		int result = birthdayCakeCandles(n, ar);
		System.out.println(result);
	}

	private static int birthdayCakeCandles(int n, int[] ar) {
		Map<Integer, Integer> map = new HashMap<>();
		
		// 목록을 돌면서 key가 존재할 경우 +1, 그렇지 않으면 1을 value에 저장
		for (int i = 0; i < ar.length; i++) {
			if (map.containsKey(ar[i])) {	//* key 존재 여부 확인
				map.put(ar[i], map.get(ar[i]) + 1);
			} else {
				map.put(ar[i], 1);
			}
		}
		map.forEach((k, v) -> System.out.println("Item : " + k + " count : " + v));
		
		// map의 value 중 최대값 추출
		int max = (Collections.max(map.values()));
		
		return max;
	}

}
