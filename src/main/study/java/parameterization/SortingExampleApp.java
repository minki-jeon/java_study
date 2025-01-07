package main.study.java.parameterization;

import java.util.Arrays;
import java.util.Comparator;

public class SortingExampleApp {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/parameterization/SortingExampleApp.java

	public static void main(String[] args) {
		Integer[] numbers = {10, 9, 2, 5, 7, 6};
		
		// 오름차순
		sort(numbers, (a, b) -> a.compareTo(b));
		System.out.println(Arrays.toString(numbers));
		
		// 내림차순
		sort(numbers, (a, b) -> b.compareTo(a));
		System.out.println(Arrays.toString(numbers));
		
		//* Test
		Arrays.sort(numbers, (a, b) -> a.compareTo(b));
		System.out.println(Arrays.toString(numbers));
	}
	
	public static <T> void sort(T[] array, Comparator<T> comparator) {
		Arrays.sort(array, comparator);
	}

}
