package main.study.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListToArrayDemo {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/collection/ArrayListToArrayDemo.java

	public static void main(String[] args) {
		// 배열 리스트 생성
		List<Integer> al = new ArrayList<>();
		// 배열 리스트 요소 추가
//        al.add(new Integer(1));
//        al.add(new Integer(2));
//        al.add(new Integer(3));
//        al.add(new Integer(4));
        al.add(Integer.valueOf(1));
        al.add(Integer.valueOf(2));
        al.add(Integer.valueOf(3));
        al.add(Integer.valueOf(4));
		System.out.println("Contents of al: " + al);
        
		// 리스트를 배열로 변환
		Object ia[] = al.toArray();
		int sum = 0;
		
		// 배열 요소 합계
		for (int i = 0; i < ia.length; i++) {
			sum += ((Integer) ia[i]).intValue();
		}
		System.out.println("Sum is: " + sum);
	}

}
