package main.study.quiz;

import java.util.Arrays;

public class PlusMinusGroup {
	//* 주어진 배열의 음수, 양수, 0의 갯수를 파악하여 비율로 표시하라. 단, 소수점 6자리까지 표현한다.
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/quiz/PlusMinusGroup.java

	public static void main(String[] args) {
        int[] numbers = {-12, 33, -4, 0, 0, 9, 1, -2, 11, 0, 22, 21, -9, 0, -11, 4, -7, 19};
        
        float[] result = numbersCount(numbers);

//        System.out.println("양수 : " + result[0] + ", 0 : " + result[1] + ", 음수: " + result[2]);
        System.out.printf("양수 : %6f, 0: %6f 음수 : %6f\n", result[0], result[1], result[2]);
        
        // ## Reference #############################################
        float[] items = itemCount(numbers);
        System.out.printf("positive : %.6f\n", items[0]);
        System.out.printf("negative : %.6f\n", items[1]);
        System.out.printf("zero : %.6f\n", items[2]);
        
	}

	private static float[] numbersCount(int[] numbers) {
		int plus = 0;
		int zero = 0;
		int minus = 0;
		
		int len = numbers.length;
		for (int i = 0; i < len; i++) {
			if (numbers[i] > 0) {
				//* 양수
				plus++;
			} else if (numbers[i] < 0) {
				//* 음수
				minus++;
			} else {
				//* 0
				zero++;
			}
		}
		float plusPer = plus / (float) len;
		float zeroPer = zero / (float) len;
		float minusPer = minus / (float) len;
		
		return new float[] {plusPer, zeroPer, minusPer};
	}

	private static float[] itemCount(int[] numbers) {
		long positives = Arrays.stream(numbers).filter(num -> num > 0).count();
		long negatives = Arrays.stream(numbers).filter(num -> num < 0).count();
		long zeros = Arrays.stream(numbers).filter(num -> num == 0).count();
		
		float point = (float) numbers.length;
		float positive = positives / point;
		float negative = negatives / point;
		float zero = zeros / point;
		float[] results = {positive, negative, zero};
		
		return results;
	}

}
