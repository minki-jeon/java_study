package main.study.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class BinaryCadinality {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/quiz/BinaryCadinality.java

	public static void main(String[] args) {
		int[] numbers = {11, 12, 13, 14, 15, 16, 17};
		int[] result = cardinalitySort(numbers);
	}

	static int[] cardinalitySort(int[] nums) {
		Map<Integer, Integer> unsortMap = new HashMap<>();
		int size = nums.length;
		int[] arrays = new int[size];
		for (int i = 0; i < size; i++) {
			String binaryString = Integer.toBinaryString(nums[i]);
			char[] chars = binaryString.toCharArray();
			
			int count = 0;
			for (char c : chars) {
				if (c == '1') {
					count += Character.getNumericValue(c);
				}
			}
			unsortMap.put(nums[i], count);
		}
		
		Map<Integer, Integer> valueMap = new LinkedHashMap<>();
		Map<Integer, Integer> keyMap = new LinkedHashMap<>();
		unsortMap.entrySet().stream()
							.sorted(Map.Entry.<Integer, Integer>comparingByKey())
							.forEachOrdered(x -> valueMap.put(x.getKey(), x.getValue()));
		
		valueMap.entrySet().stream()
							.sorted(Map.Entry.<Integer, Integer>comparingByValue())
							.forEachOrdered(x -> keyMap.put(x.getKey(), x.getValue()));
		
		System.out.println("valueMap : " + valueMap);
		System.out.println("keyMap : " + keyMap);
		
		Iterator<Integer> iter = keyMap.keySet().iterator();
		
		int index = 0;
		while (iter.hasNext()) {
			arrays[index] = iter.next();
			index++;
		}
		return arrays;
	}

}
