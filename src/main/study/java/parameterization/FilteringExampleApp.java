package main.study.java.parameterization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilteringExampleApp {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/parameterization/FilteringExampleApp.java

	public static void main(String[] args) {
		List<String> words = Arrays.asList("green", "blue", "yellow", "red", "white", "bind", "ball", "boolean", "sky", "gray", "purple");
		
		List<String> filteredWords = filter(words, s -> s.startsWith("b"));
		System.out.println(filteredWords);
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
		List<T> result = new ArrayList<>();
		for (T t : list) {
			if (predicate.test(t)) {
				result.add(t);
			}
		}
		return result;
	}

}
