package main.study.algorithm.sort;

import java.util.Arrays;

public class ArraySort {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/algorithm/sort/ArraySort.java

	public static void main(String[] args) {
		String[] s = {"b", "A", "D", "C", "a", "F"};
		
		//대소문자 구분 정렬
		Arrays.sort(s);
		System.out.println("# 대소문자 구분");
		System.out.println(Arrays.toString(s));
		
		descArraySort(s);
		System.out.println("# 역정렬");
		System.out.println(Arrays.toString(s));
		
		// 대소문자 구분없이 정렬
		System.out.println("# 대소문자 구분없이");
		Arrays.sort(s, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(s));
	}

	private static void descArraySort(String[] arr) {
		String temp;
		
		for (int i = 0; i < arr.length / 2; i++) {
			temp = arr[i];
			arr[i] = arr[(arr.length - 1) - i];
			arr[(arr.length - 1) - i] = temp;
		}
	}

}
