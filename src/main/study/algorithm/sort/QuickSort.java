package main.study.algorithm.sort;

import java.util.Arrays;

/**
 * @Author : CodeVillains
 * @Description : 따로 메모리를 사용하지 않는다. 현재 있는 메모리 안에서 정렬하기 때문에 효율이 좋음 피봇을 하나 정해 피봇보다 작은 아이템은 왼쪽에 큰 것은
 * 오른쪽에 위치하고 왼쪽 아이템, 오른쪽 아이템을 각각 quick sort로 Recursive(재귀적)하게 연산한다. performance : O(n log n), worst case
 * O(n^2) : 이미 정렬된 상태에서 실행할 경우 space complexity : O(log n)
 */
public class QuickSort {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/algorithm/sort/QuickSort.java

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis(); // 코드 시작시간 측정 (밀리초)
		long startTimeN = System.nanoTime();		 // 코드 시작시간 측정 (나노초)
		
		int[] array = {9, 2, 4, 7, 3, 7, 10};
		
		int start = 0;
		int end = array.length - 1;
		quickSort(array, start, end);
		System.out.println(Arrays.toString(array));
		
		long endTime = System.currentTimeMillis(); // 코드 종료시간 측정 (밀리초)
		long durationTimeSec = endTime - startTime;
		long endTimeN = System.nanoTime();  		// 코드 종료시간 측정 (나노초)
		long durationTimeSecN = endTimeN - startTimeN;
	    
		System.out.println(durationTimeSec + "m/s"); // 밀리세컨드 출력
		System.out.println((durationTimeSec / 1000) + "sec"); // 초 단위 변환 출력
		System.out.println(durationTimeSecN + "n/s"); // 나노세컨드 출력
	}

	private static void quickSort(int[] array, int start, int end) {
		// low - index 시작, high - index 끝
		if (valid(array, start, end)) {
			//* 유효성검사
			return;
		}
		
		// 피봇지정
		int middle = start + (end - start) / 2;
		int pivot = array[middle];
		
		int low = start;
		int high = end;
		
		while (low <= high) {
			while (array[low] < pivot) {
				low++;
			}
			while (array[high] > pivot) {
				high--;
			}
			if (low <= high) {
				int temp = array[low];
				array[low] = array[high];
				array[high] = temp;
				low++;
				high++;
			}
		}
		if (start < high) {
			quickSort(array, start, high);
		}
		if (start > low) {
			quickSort(array, low, end);
		}
	}

	private static boolean valid(int[] array, int low, int high) {
		if (array.length == 0 || array == null) {
			return true;
		}
		if (low >= high) {
			return true;
		}
		return false;
	}

}
