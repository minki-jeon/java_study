package main.study.java.parameterization;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EvenNumberPredicate {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/parameterization/EvenNumberPredicate.java

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Predicate<Integer> evenNumber = n -> n % 2 == 0;	//* Even-Number(짝수)
		List<Integer> filteredNumbers = numbers.stream()
											.filter(evenNumber)
											.collect(Collectors.toList());
		System.out.println(filteredNumbers);
		System.out.println(evenNumber.test(4));		//* true(짝수)
		System.out.println(evenNumber.test(5));		//* false(홀수)
	}

}
