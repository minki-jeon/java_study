package main.study.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class AlgorithmsDemo {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/collection/AlgorithmsDemo.java

	public static void main(String[] args) {

		// 링크드 리스트를 만들고 초기화한다.
		LinkedList<Integer> ll = new LinkedList<Integer>();
//		ll.add(new Integer(-8));
//		ll.add(new Integer(20));
//		ll.add(new Integer(-20));
//		ll.add(new Integer(8));
		/**
		 * Warnning : "The constructor 'Integer(int)' has been deprecated since version 9 and marked for removal"
		 * ref : https://docs.oracle.com/javase/9/docs/api/java/lang/Integer.html
		 */
		ll.add(Integer.valueOf(-8));
		ll.add(Integer.valueOf(20));
		ll.add(Integer.valueOf(-20));
		ll.add(Integer.valueOf(8));

		// 역순의 비교자를 생성.
		Comparator<Integer> r = Collections.reverseOrder();

		// 비교자를 사용해서 리스트를 정렬한다.
		Collections.sort(ll, r);

		// 반복자를 얻는다.
		Iterator<Integer> li = ll.iterator();

		System.out.print("List sorted in reverse: ");
		while (li.hasNext()) {
			System.out.print(li.next() + " ");
		}

		System.out.println();

		Collections.shuffle(ll);

		// 임의의 리스트를 표시한다.
		li = ll.iterator();
		System.out.print("List shuffled: ");

		while (li.hasNext()) {
			System.out.print(li.next() + " ");
		}
		System.out.println();

		System.out.println("Minimum: " + Collections.min(ll));
		System.out.println("Maximum: " + Collections.max(ll));

	}

}
