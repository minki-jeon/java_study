package main.study.collection;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/collection/LinkedHashSetDemo.java

	public static void main(String[] args) {
		Set<String> linkHashSet = new LinkedHashSet<String>();
		linkHashSet.add("B");
		linkHashSet.add("A");
		linkHashSet.add("D");
		linkHashSet.add("E");
		linkHashSet.add("C");
		linkHashSet.add("F");
		System.out.println(linkHashSet);
	}

}
