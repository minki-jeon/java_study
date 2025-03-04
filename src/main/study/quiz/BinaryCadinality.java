package main.study.quiz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class BinaryCadinality {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/quiz/BinaryCadinality.java

	public static void main(String[] args) {
		int[] numbers = {11, 12, 13, 14, 15, 16, 17};
		int[] result = cardinalitySort(numbers);
		
		System.out.println("결과 = ");
		System.out.println(Arrays.toString(result));
		//* 입력받은 숫자들을 통해 이진수로 변환했을 때, 1이 적은 숫자부터 많은 숫자로 정렬하는 프로그램이다.
	}

	static int[] cardinalitySort(int[] nums) {
		//* 이진수 변환 작업과 1의 개수를 카운트하는 과정
		Map<Integer, Integer> unsortMap = new HashMap<>();
		int size = nums.length;
		int[] arrays = new int[size];
		for (int i = 0; i < size; i++) {
			String binaryString = Integer.toBinaryString(nums[i]);		//* Integer -> 2진수 문자열 변환
			char[] chars = binaryString.toCharArray();					//* 2진수 문자열 -> char형 배열 변환
			
			int count = 0;
			for (char c : chars) {
				if (c == '1') {
					count += Character.getNumericValue(c);				//* char형 문자 -> int형 숫자 변환
				}
			}
			unsortMap.put(nums[i], count);
		}
		
		//* 위의 작업 과정을 거친 값들을 Map에 정렬시켜 저장한다.
		Map<Integer, Integer> valueMap = new LinkedHashMap<>();
		Map<Integer, Integer> keyMap = new LinkedHashMap<>();
		//* 10진수 정렬
		unsortMap.entrySet().stream()
							.sorted(Map.Entry.<Integer, Integer>comparingByKey())
							.forEachOrdered(x -> valueMap.put(x.getKey(), x.getValue()));
		//* 이진수 변환값에서 1의 개수에 따른 정렬
		valueMap.entrySet().stream()
							.sorted(Map.Entry.<Integer, Integer>comparingByValue())
							.forEachOrdered(x -> keyMap.put(x.getKey(), x.getValue()));
		
		System.out.println("valueMap : " + valueMap);
		System.out.println("keyMap : " + keyMap);
		
		//* 결과 출력을 위해 배열 생성
		Iterator<Integer> iter = keyMap.keySet().iterator();
		int index = 0;
		while (iter.hasNext()) {
			arrays[index] = iter.next();
			index++;
		}
		return arrays;
	}

}
