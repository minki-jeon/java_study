package main.study.algorithm.sort;

import java.util.Arrays;

/**
 * @Author : CodeVillains
 * @Description : 구성 요소를 순회하면서 인접한 요소간의 값을 비교하여 정렬. 뒤에 값이 작으면 앞으로 위치를 바꿔줘야 하기 때문에 가변 공간이 하나 필요하다.
 * Performance : 비효율적이다. 최악의 경우 역순으로 정렬하려고 할 때 O(n^2)가 나오고 최선은 리스트가 이미 정렬이 되어있을 경우 O(N)의 성능이 나온다.
 */
public class BubbleSort {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/algorithm/sort/ArraySort.java

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis(); // 코드 시작시간 측정 (밀리초)
		long startTimeN = System.nanoTime();		 // 코드 시작시간 측정 (나노초)
		
		final int[] numbers = {4, 7, 1, 2, 5, 8, 6};
		System.out.println("Result = " + Arrays.toString(bubbleSort(numbers)));
		
		long endTime = System.currentTimeMillis(); // 코드 종료시간 측정 (밀리초)
		long durationTimeSec = endTime - startTime;
		long endTimeN = System.nanoTime();  		// 코드 종료시간 측정 (나노초)
		long durationTimeSecN = endTimeN - startTimeN;
	    
		System.out.println(durationTimeSec + "m/s"); // 밀리세컨드 출력
		System.out.println((durationTimeSec / 1000) + "sec"); // 초 단위 변환 출력
		System.out.println(durationTimeSecN + "n/s"); // 나노세컨드 출력
	}

	private static int[] bubbleSort(int[] numbers) {
		boolean switched;
		do {
			switched = false;
			for (int i = 0; i < numbers.length - 1; i++) {
				// 첫번째 원소와 현재 원소를 비교하여 현재 원소보다 작으면 swap
				if (numbers[i + 1] < numbers[i]) {	// 뒤에 값이 현재 값보다 작은 경우 swap
					int temp = numbers[i + 1];		// 기준값을 위한 임시 공간 생성
					numbers[i + 1] = numbers[i];
					numbers[i] = temp;
					switched = true;
				}
			}
		} while (switched);	// 모든 원소를 비교한 경우 반복 탈출 
		return numbers;
	}

}
