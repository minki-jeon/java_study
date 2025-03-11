package main.study.quiz;

public class PlusMinusGroup {
	//* 주어진 배열의 음수, 양수, 0의 갯수를 파악하여 비율로 표시하라. 단, 소수점 6자리까지 표현한다.

	public static void main(String[] args) {
        int[] numbers = {-12, 33, -4, 0, 0, 9, 1, -2, 11, 0 };
        
        float[] result = numbersCount(numbers);

//        System.out.println("양수 : " + result[0] + ", 0 : " + result[1] + ", 음수: " + result[2]);
        System.out.printf("양수 : %6f, 0: %6f 음수 : %6f", result[0], result[1], result[2]);
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

}
