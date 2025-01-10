package main.study.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class HashSetDemoTest {

	public static void main(String[] args) {
		LinkedList<Character> ll = new LinkedList<>();
		IntSupplier randomNumSupply = () -> (new Random().nextInt(26) + 65);
		
		IntStream.generate(randomNumSupply).limit(10).forEach(number -> ll.add((char) number));
		
		Iterator<Character> li = ll.iterator();
		li = ll.iterator();
		System.out.print("Random Char List: ");
		Set<String> hashSet = new HashSet<>();
		String c = "";
		while (li.hasNext()) {
			c = Character.toString(li.next());
			hashSet.add(c);
			System.out.print(c + " ");
		}
		System.out.println();
		
		System.out.println("Random Alphabet HashSet" + hashSet);

	}

}
