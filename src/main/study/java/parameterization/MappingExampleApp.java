package main.study.java.parameterization;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import main.study.java.func.predicate.Tshirt;

public class MappingExampleApp {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/parameterization/MappingExampleApp.java

	public static void main(String[] args) {
		List<String> words = Arrays.asList("green", "blue", "yellow", "red", "white", "bind", "ball", "boolean", "sky", "gray", "purple");
		
		List<Integer> wordLengths = map(words, String::length);
		System.out.println(wordLengths);
		
		//* Test1
		List<Tshirt> myShirtList = asList(new Tshirt(100, "yellow"),
				new Tshirt(200, "red"),
				new Tshirt(400, "purple"),
				new Tshirt(600, "red"),
				new Tshirt(200, "green"),
				new Tshirt(300, "blue"),
				new Tshirt(400, "red"),
				new Tshirt(500, "white"));
		List<String> colorList = map(myShirtList, Tshirt::getColor);
		System.out.println(colorList);
		
		//* Test2
		List<String> filterColorList = map(myShirtList, Tshirt::getColor, t -> t.getPrice() > 300);
		System.out.println(filterColorList);
	}

	public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
		return list.stream().map(mapper).collect(Collectors.toList());
	}

	public static <T, R> List<R> map(List<T> list, Function<T, R> mapper, Predicate<T> predicate) {
		return list.stream().filter(predicate).map(mapper).collect(Collectors.toList());
	}
}
