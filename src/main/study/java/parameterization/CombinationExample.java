package main.study.java.parameterization;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import main.study.java.func.predicate.Tshirt;

public class CombinationExample {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/parameterization/CombinationExample.java

	public static void main(String[] args) {
		List<String> words = Arrays.asList("green", "blue", "yellow", "red", "white", "bind", "ball", "boolean", "sky", "gray", "purple");
		
		//* startWithB -> parameterization(매개변수화) : 변동이 잦은 값
		//* lengthMapper -> combination(조합) : 조건에 해당되는 값을 정렬되지 않은 채 반환
		Predicate<String> startsWithB = s -> s.startsWith("b");
		Function<String, Integer> lengthMapper = String::length;
		
		List<Integer> filteredWordLengths = words.stream()
												.filter(startsWithB)
												.map(lengthMapper)
												.collect(Collectors.toList());
		System.out.println(filteredWordLengths);
		
		//* Test
		List<Tshirt> myShirtList = asList(new Tshirt(100, "yellow"),
				new Tshirt(200, "red"),
				new Tshirt(400, "purple"),
				new Tshirt(600, "red"),
				new Tshirt(200, "green"),
				new Tshirt(300, "blue"),
				new Tshirt(400, "red"),
				new Tshirt(500, "white"));
		Predicate<Tshirt> priceFilter = t -> t.getPrice() > 300;
		Function<Tshirt, String> colorMapper = Tshirt::getColor;
		
		List<String> filterColors = myShirtList.stream()
											.filter(priceFilter)
											.map(colorMapper)
											.collect(Collectors.toList());
		System.out.println(filterColors);
		
	}

}
