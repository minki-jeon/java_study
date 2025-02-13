package main.study.practice.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class TestVariousSort {
	/**
	 * JAVA Sort Practice
	 * reference: https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/algorithm/sort/
	 * sort: ArraySort, BubbleSort, InsertionSort, MergeSort, QuickSort, SelectionSort
	 * Description: 구현한 각각의 정렬 알고리즘들을 실행시간 측정하여 가장 빠른 정렬부터 느린 정렬까지 나열
	 */

	/** 랜덤한 숫자 배열 생성 **/
	private final static Supplier<int[]> RAND_NUMBERS_SUP = () -> new RandomNumbersSupplier().get();
	/** 측정 시작 설정 (m/s) **/
	private final static Supplier<Long> TIME_MILLIS_SUP = () -> new SetTimeMillisSupplier().get();
	/** 측정 시작 설정 (m/s) **/
	private final static Supplier<Long> TIME_NANO_SUP = () -> new SetTimeNanoSupplier().get();
	
	private final static int[] __NUMBERS__ = RAND_NUMBERS_SUP.get();
	
	public static void main(String[] args) {
		Map<String, Long> resultMap = new HashMap<String, Long>();	//* 정렬:소요시간
		
		//* 랜덤으로 50개의 숫자 배열을 생성 (중복X)
		//* 생성한 숫자 배열을 기본 배열으로 한다.
//		int[] numbers = __NUMBERS__;
//		int[] numbers1 = __NUMBERS__;
//		int[] numbers2 = numbers1;
//		int[] numbers3 = __NUMBERS__;

		int[] numbers = {85, 93, 77, 74, 8, 21, 13, 92, 79, 16, 26, 96, 20, 51, 60, 38, 5, 47};
		int[] numbers1 = {85, 93, 77, 74, 8, 21, 13, 92, 79, 16, 26, 96, 20, 51, 60, 38, 5, 47};
		int[] numbers2 = {85, 93, 77, 74, 8, 21, 13, 92, 79, 16, 26, 96, 20, 51, 60, 38, 5, 47};
		int[] numbers3 = {85, 93, 77, 74, 8, 21, 13, 92, 79, 16, 26, 96, 20, 51, 60, 38, 5, 47};
		
		//* 배열 유효성 검사
		if (valid(numbers1)) {
			return;
		}
		
		//* 생성된 숫자 출력
		System.out.println("Default Numbers : " + printArrays(numbers1));
		
		//* 측정 시작
		long startTime = TIME_MILLIS_SUP.get();
		//* ArraySort 구현
//		arraySort(numbers1);									//TODO Consumer
		//* 측정 종료
		long endTime = TIME_MILLIS_SUP.get();
		long duration = endTime - startTime;		//TODO Function
		resultMap.put("ArraySort", duration);

		
//		int[] numbers2 = __NUMBERS__;
		//* 생성된 숫자 출력
		System.out.println("Default Numbers 2 : " + printArrays(numbers2));
		System.out.println("Default Numbers 3 : " + printArrays(numbers1));
		System.out.println("Default Numbers 4 : " + printArrays(numbers));
		
		//* 측정 시작
		startTime = TIME_MILLIS_SUP.get();
		//TODO BubbleSort 구현
		bubbleSort(numbers2);
		//TODO 측정 종료
		endTime = TIME_MILLIS_SUP.get();
		duration = endTime - startTime;
		resultMap.put("BubbleSort", duration);


		System.out.println("Default Numbers 5 : " + printArrays(numbers3));
		System.out.println("Default Numbers 2 : " + printArrays(numbers2));
		System.out.println("Default Numbers 3 : " + printArrays(numbers1));
		System.out.println("Default Numbers 4 : " + printArrays(numbers));
		//* 측정 시작
		startTime = TIME_MILLIS_SUP.get();
		//* InsertionSort 구현
		insertionSort(numbers3);
		//* 측정 종료
		endTime = TIME_MILLIS_SUP.get();
		duration = endTime - startTime;
		resultMap.put("InsertionSort", duration);

		//* 측정 시작
		startTime = TIME_MILLIS_SUP.get();
		//TODO MergeSort 구현
		mergeSort(numbers);
		//TODO 측정 종료
		endTime = TIME_MILLIS_SUP.get();
		duration = endTime - startTime;
		resultMap.put("MergeSort", duration);

		//* 측정 시작
		startTime = TIME_MILLIS_SUP.get();
		//TODO QuickSort 구현
		quickSort(numbers);
		//TODO 측정 종료
		endTime = TIME_MILLIS_SUP.get();
		duration = endTime - startTime;
		resultMap.put("QuickSort", duration);

		//* 측정 시작
		startTime = TIME_MILLIS_SUP.get();
		//TODO SelectionSort 구현
		selectionSort(numbers);
		//TODO 측정 종료
		endTime = TIME_MILLIS_SUP.get();
		duration = endTime - startTime;
		resultMap.put("SelectionSort", duration);
		
		//TODO 측정 결과에 따라 실행속도가 빠른 정렬부터 나열하여 출력
//		result(resultMap);					//TODO Consumer
		
	}

	private static String printArrays(int[] numbers) {
		return Arrays.toString(numbers);
	}

	private static void selectionSort(int[] numbers) {
		// TODO Auto-generated method stub
		
	}

	private static void quickSort(int[] numbers) {
		// TODO Auto-generated method stub
		
	}

	private static void mergeSort(int[] numbers) {
		// TODO Auto-generated method stub
		
	}

	private static void insertionSort(int[] numbers) {
		for (int i = 1; i < numbers.length; i++) {
			int standard = numbers[i];	// 기준값 (제일 처음 비교시 배열의 index 1 (2번째요소) 기준점으로 왼쪽을 비교
			int compare = i - 1;		// 비교대상 (기준값의 왼쪽 요소를 비교)
			
			// 비교대상이 0보다 크고 기준값이 비교대상보다 작은 경우 swap
			while (compare >= 0 && standard < numbers[compare]) {	// 0 >= 0 && 10 < 9
				numbers[compare + 1] = numbers[compare];	// 비교 대상을 오른쪽으로 밀어냄
				compare--;		// -1이 되면 조건밖으로 이동
			}
			numbers[compare + 1] = standard;	// 기준값을 저장한다.
		}
		System.out.println("InsertionSort 결과 : " + printArrays(numbers));
	}

	private static void result(Map<String, Integer> resultMap) {
		// TODO Auto-generated method stub
		
	}

	private static boolean valid(int[] numbers) {
		return (numbers.length == 0 || numbers == null);
	}

	private static void bubbleSort(int[] numbers) {
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
		
		System.out.println("BubbleSort 결과 : " + printArrays(numbers));
		
	}

	private static Integer durationTime(Supplier<Long> startTime) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static void arraySort(int[] numbers) {
		Arrays.sort(numbers);
		System.out.println("ArraySort 결과 : " + printArrays(numbers));
	}

	private static Supplier<Integer> startTime() {
		// TODO Auto-generated method stub
		return null;
	}

	private static int[] createNumbers() {
		// TODO Auto-generated method stub
		return null;
	}

}
