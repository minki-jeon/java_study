package main.study.algorithm.sort;

import java.util.Arrays;

/**
 * @Author : CodeVillains
 * @Description : 구현하기 쉬움 주어진 리스트에서 최소값을 찾아 맨 앞에 위치값과 비교하여 교체한다. 목록의 각 위치에 대해서 이러한 과정을 계속한다.
 * Performance :  O(n^2)
 */
public class SelectionSort {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/algorithm/sort/SelectionSort.java

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis(); // 코드 시작시간 측정 (밀리초)
		long startTimeN = System.nanoTime();		 // 코드 시작시간 측정 (나노초)
		
		final int[] numbers = {11, 2, 6, 3, 9, 8};
		
		System.out.println("Result = " + Arrays.toString(selectSort(numbers)));
		
		long endTime = System.currentTimeMillis(); // 코드 종료시간 측정 (밀리초)
		long durationTimeSec = endTime - startTime;
		long endTimeN = System.nanoTime();  		// 코드 종료시간 측정 (나노초)
		long durationTimeSecN = endTimeN - startTimeN;
	    
		System.out.println(durationTimeSec + "m/s"); // 밀리세컨드 출력
		System.out.println((durationTimeSec / 1000) + "sec"); // 초 단위 변환 출력
		System.out.println(durationTimeSecN + "n/s"); // 나노세컨드 출력
	}

	private static int[] selectSort(int[] numbers) {
		// 전체 요소 순회. 마지막 공간은 자동으로 위치 교환을 통해 정렬
		for (int index = 0; index < numbers.length - 1; index++) {
			int min = index;
			
			// 다음 요소를 현재 요소와 비교. 다음 요소가 현재의 요소보다 작을 경우 요소의 index를 바꾼다.
			for (int scan = index + 1; scan < numbers.length; scan++) {
				if (numbers[scan] < numbers[min]) {
					min =  scan;						// 최소값의 index
				}
			}
			int smaller = numbers[min];		// 최소값
			numbers[min] = numbers[index];
			numbers[index] = smaller;
		}
		
		return numbers;
	}

}
