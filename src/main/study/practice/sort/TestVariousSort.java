package main.study.practice.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestVariousSort {
	/**
	 * JAVA Sort Practice
	 * reference: https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/algorithm/sort/
	 * sort: ArraySort, BubbleSort, InsertionSort, MergeSort, QuickSort, SelectionSort
	 * Description: 구현한 각각의 정렬 알고리즘들을 실행시간 측정하여 가장 빠른 정렬부터 느린 정렬까지 나열
	 */
	public static void main(String[] args) {
		Map<String, Integer> resultMap = new HashMap<String, Integer>();	//* 정렬:소요시간
		
		//TODO 랜덤으로 50개의 숫자 배열을 생성 (중복X)
		//TODO 생성한 숫자 배열을 기본 배열으로 한다.
		int[] numbers = createNumbers();
		
		//TODO 배열 유효성 검사
		while (valid(numbers)) {							//TODO Predicate
			numbers = createNumbers();
		}
		
		//TODO 측정 시작
		Supplier<Integer> startTime = startTime();			//TODO Supplier
		//TODO ArraySort 구현
		arraySort(numbers);									//TODO Consumer
		//TODO 측정 종료
		Integer duration = durationTime(startTime);		//TODO Function
		resultMap.put("ArraySort", duration);
		
		//TODO 측정 시작
		startTime = startTime();
		//TODO BubbleSort 구현
		bubbleSort(numbers);
		//TODO 측정 종료
		duration = durationTime(startTime);
		resultMap.put("BubbleSort", duration);

		//TODO 측정 시작
		startTime = startTime();
		//TODO InsertionSort 구현
		insertionSort(numbers);
		//TODO 측정 종료
		duration = durationTime(startTime);
		resultMap.put("InsertionSort", duration);
		
		//TODO 측정 시작
		startTime = startTime();
		//TODO MergeSort 구현
		mergeSort(numbers);
		//TODO 측정 종료
		duration = durationTime(startTime);
		resultMap.put("MergeSort", duration);

		//TODO 측정 시작
		startTime = startTime();
		//TODO QuickSort 구현
		quickSort(numbers);
		//TODO 측정 종료
		duration = durationTime(startTime);
		resultMap.put("QuickSort", duration);
		
		//TODO 측정 시작
		startTime = startTime();
		//TODO SelectionSort 구현
		selectionSort(numbers);
		//TODO 측정 종료
		duration = durationTime(startTime);
		resultMap.put("SelectionSort", duration);
		
		//TODO 측정 결과에 따라 실행속도가 빠른 정렬부터 나열하여 출력
		result(resultMap);					//TODO Consumer
		
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
		// TODO Auto-generated method stub
		
	}

	private static void result(Map<String, Integer> resultMap) {
		// TODO Auto-generated method stub
		
	}

	private static boolean valid(int[] numbers) {
		// TODO Auto-generated method stub
		return false;
	}

	private static void bubbleSort(int[] numbers) {
		// TODO Auto-generated method stub
		
	}

	private static Integer durationTime(Supplier<Integer> startTime) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static void arraySort(int[] numbers) {
		// TODO Auto-generated method stub
		
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
