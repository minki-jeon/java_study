package main.study.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSort {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/algorithm/sort/ArraySort.java

	public static void main(String[] args) {
		List<String> listObject = new ArrayList<String>();
		listObject.add("z");
		listObject.add("a");
		listObject.add("f");
		listObject.add("c");
		
		System.out.println("## 기본출력 : " + listObject);
		// 문자열 순으로 정렬
		Collections.sort(listObject, String.CASE_INSENSITIVE_ORDER);
		System.out.println("## 순차정렬 : " + listObject);
		
		// 역순 정렬
		Collections.sort(listObject, Collections.reverseOrder());
		System.out.println("## 역순정렬 : " + listObject);
	}

}
