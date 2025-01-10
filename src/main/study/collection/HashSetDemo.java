package main.study.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/collection/HashSetDemo.java

	public static void main(String[] args) {
		Set<String> hs = new HashSet<>();
		hs.add("B");
		hs.add("A");
		hs.add("D");
		hs.add("E");
		hs.add("C");
		hs.add("F");
		hs.toString();
		
		System.out.println(hs);
	}

}
