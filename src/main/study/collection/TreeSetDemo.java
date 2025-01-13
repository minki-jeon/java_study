package main.study.collection;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/collection/TreeSetDemo.java

	public static void main(String[] args) {
		Set<String> ts = new TreeSet<String>();
		ts.add("C");
		ts.add("A");
		ts.add("B");
		ts.add("E");
		ts.add("F");
		ts.add("D");
		System.out.println(ts);
	}

}
