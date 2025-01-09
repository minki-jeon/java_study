package main.study.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class AlgorithmsDemoTest {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		Supplier<Integer> randomNumSupply = () -> new Random().nextInt(11);
		
		Stream.generate(randomNumSupply).limit(7).forEach(number -> ll.add(Integer.valueOf(number)));
		
		//* 리스트 출력
		Iterator<Integer> li = ll.iterator();
		li = ll.iterator();
		System.out.print("Random Number List: ");
		while (li.hasNext()) {
			System.out.print(li.next() + " ");
		}
		System.out.println();
		
		//* 역순 정렬
		Comparator<Integer> r = Collections.reverseOrder();
		Collections.sort(ll, r);
		li = ll.iterator();
		System.out.print("List sorted in reverse: ");
		while (li.hasNext()) {
			System.out.print(li.next() + " ");
		}
		System.out.println();
		
		//* 오름차순 정렬
		Collections.sort(ll);
		li = ll.iterator();
		System.out.print("List sorted: ");
		while (li.hasNext()) {
			System.out.print(li.next() + " ");
		}
		System.out.println();
		
		//* 셔플
		Collections.shuffle(ll);
		li = ll.iterator();
		System.out.print("List shuffled: ");
		while (li.hasNext()) {
			System.out.print(li.next() + " ");
		}
		System.out.println();

		//* 최소, 최댓값
		System.out.println("Minimum: " + Collections.min(ll));
		System.out.println("Maximum: " + Collections.max(ll));
		
		
	}

}
