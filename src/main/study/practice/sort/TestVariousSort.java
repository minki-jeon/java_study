package main.study.practice.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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
		int[] defaultNumbers = __NUMBERS__;

		//* 배열 유효성 검사
		if (valid(defaultNumbers)) {
			return;
		}
		
		//* 생성된 숫자 출력
		int[] numbers = defaultNumbers.clone();
		System.out.println("Default Numbers 1 : " + printArrays(numbers));
		//* 측정 시작
		long startTime = TIME_NANO_SUP.get();
		//* ArraySort 구현
		arraySort(numbers);									//TODO Consumer
		//* 측정 종료
		long endTime = TIME_NANO_SUP.get();
		long duration = endTime - startTime;		//TODO Function
		resultMap.put("ArraySort", duration);

		
		//* 생성된 숫자 출력
		numbers = defaultNumbers.clone();
		System.out.println("Default Numbers 2 : " + printArrays(numbers));
		//* 측정 시작
		startTime = TIME_NANO_SUP.get();
		//* BubbleSort 구현
		bubbleSort(numbers);
		//* 측정 종료
		endTime = TIME_NANO_SUP.get();
		duration = endTime - startTime;
		resultMap.put("BubbleSort", duration);


		//* 생성된 숫자 출력
		numbers = defaultNumbers.clone();
		System.out.println("Default Numbers 3 : " + printArrays(numbers));
		//* 측정 시작
		startTime = TIME_NANO_SUP.get();
		//* InsertionSort 구현
		insertionSort(numbers);
		//* 측정 종료
		endTime = TIME_NANO_SUP.get();
		duration = endTime - startTime;
		resultMap.put("InsertionSort", duration);

		//* 측정 시작
		numbers = defaultNumbers.clone();
		Integer[] numbersIntg = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
		System.out.println("Default Numbers 4 : " + Arrays.toString(numbersIntg));
		startTime = TIME_NANO_SUP.get();
		//* MergeSort 구현
		mergeSort(numbersIntg);
		System.out.println("MergerSort 결과 : " + Arrays.toString(numbersIntg));
		//* 측정 종료
		endTime = TIME_NANO_SUP.get();
		duration = endTime - startTime;
		resultMap.put("MergeSort", duration);

		//* 생성된 숫자 출력
//		numbers = defaultNumbers.clone();
//		System.out.println("Default Numbers 5 : " + printArrays(numbers));
		//* 측정 시작
//		startTime = TIME_NANO_SUP.get();
		//* QuickSort 구현
		//TODO 일부 정렬이 안됨. 확인 필요.
//		quickSort(numbers, 0, numbers.length - 1);
//		System.out.println("QuickSort 결과 : " + printArrays(numbers));
		//* 측정 종료
//		endTime = TIME_NANO_SUP.get();
//		duration = endTime - startTime;
//		resultMap.put("QuickSort", duration);

		//* 생성된 숫자 출력
		numbers = defaultNumbers.clone();
		System.out.println("Default Numbers 6 : " + printArrays(numbers));
		//* 측정 시작
		startTime = TIME_NANO_SUP.get();
		//* SelectionSort 구현
		selectionSort(numbers);
		//* 측정 종료
		endTime = TIME_NANO_SUP.get();
		duration = endTime - startTime;
		resultMap.put("SelectionSort", duration);
		
		//TODO 측정 결과에 따라 실행속도가 빠른 정렬부터 나열하여 출력
		result(resultMap);					//TODO Consumer
		
	}

	private static String printArrays(int[] numbers) {
		return Arrays.toString(numbers);
	}

	private static void selectionSort(int[] numbers) {

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
		System.out.println("SelectionSort 결과 : " + printArrays(numbers));
		
	}

	private static void quickSort(int[] numbers, int start, int end) {

		if (valid(numbers, start, end)) {
			//* 유효성검사
			return;
		}
		
		// 피봇지정
		int middle = start + (end - start) / 2;
		int pivot = numbers[middle];
		
		int low = start;
		int high = end;
		
		while (low <= high) {
			while (numbers[low] < pivot) {
				low++;
			}
			while (numbers[high] > pivot) {
				high--;
			}
			if (low <= high) {
				int temp = numbers[low];
				numbers[low] = numbers[high];
				numbers[high] = temp;
				low++;
				high++;
			}
		}
		if (start < high) {
			quickSort(numbers, start, high);
		}
		if (start > low) {
			quickSort(numbers, low, end);
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

	private static Comparable[] mergeSort(Comparable[] numbers) {
		// 리스트가 1 이하이면 연산한 필요 없음
		if (numbers.length <= 1) {
			return numbers;
		}
		
		// 리스트를 반으로 나누어 두 부분으로 분리
		Comparable[] first = new Comparable[numbers.length / 2];	// 5일 경우 2.5 (2)
		Comparable[] second = new Comparable[numbers.length - first.length];	// 3(5-2)개의 배열 요소 처리
		
		// 배열에서 원하는 요소를 부분을 복사
		// 원본, 원본 시작점, 복사본, 복사본 시작점, 길이
		System.arraycopy(numbers, 0, first, 0, first.length);	// 첫번째 파트 배열 카피	list, 0, first, 0, 2 
		System.arraycopy(numbers, first.length, second, 0, second.length);	// 두번째 파트 배열 카피	list, 2, second, 0, 3
		
		// 재귀 호출로 각 요소를 분리 (첫번째 배열 분해 후 두번째 배열 분해)
		mergeSort(first);
		mergeSort(second);
		
		// 각 배열을 병합하여 원래 배열에 덮어쓴다.
		merged(first, second, numbers);
		
		return numbers;
	}

	private static void merged(Comparable[] first, Comparable[] second, Comparable[] result) {
		// 첫번째 배열의 인덱스 위치 - 첫 요소부터 시작
		int firstIndex = 0;
		
		// 두번째 배열의 인덱스 위치 - 첫 요소부터 시작
		int secondIndex = 0;
		
		// 병합된 배의 인덱스 위치 - 첫번째 위치부터 시작
		int merged = 0;
		
		// 첫번째배열의 요소와 두번째 배열의 요소를 비교
		// 그 중 작은 요소를 배열 병합에 저장
		while (firstIndex < first.length && secondIndex < second.length) {
//			System.out.println(
//					"first[firstIndex] : " + first[firstIndex]
//					+ ", second[secondIndex] : " + second[secondIndex]
//					+ ", result = " + first[firstIndex].compareTo(second[secondIndex])
//					);
			
			if (first[firstIndex].compareTo(second[secondIndex]) < 0) {
				result[merged] = first[firstIndex];
				firstIndex++;
			} else {
				result[merged] = second[secondIndex];
				secondIndex++;
			}
			
			merged++;
		}
		System.arraycopy(first, firstIndex, result, merged, first.length - firstIndex);
		System.arraycopy(second, secondIndex, result, merged, second.length - secondIndex);
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

	private static void result(Map<String, Long> resultMap) {
//		for (Map.Entry<String, Long> entry : resultMap.entrySet()) {
//		    System.out.print(entry.getKey() + " : ");
//		    System.out.println(entry.getValue());
//		}
		Map<String, Long> resultSortMap = resultMap.entrySet()
								  .stream()
								  .sorted(Map.Entry.comparingByValue())
								  .collect(Collectors.toMap(
										    Map.Entry::getKey, 
										    Map.Entry::getValue, 
													    (a, b) -> { throw new AssertionError(); },
													                LinkedHashMap<String, Long>::new
								  ));
		System.out.println("============== Result Sort ===========");
		for (Map.Entry<String, Long> entry : resultSortMap.entrySet()) {
		    System.out.print(entry.getKey() + " : ");
		    System.out.println(entry.getValue());
		}
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

}
