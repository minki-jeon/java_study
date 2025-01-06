package main.study.java.lambda.comparator;

import java.util.Arrays;

import main.study.java.func.predicate.Tshirt;

public class TshirtSorterLambda {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/lambda/comparator/TshirtSorterLambda.java

	public static void main(String[] args) {
		Tshirt[] tshirts = {new Tshirt(10000, "red"), new Tshirt(5000, "blue"), new Tshirt(8000, "green")};
		
		Arrays.sort(tshirts, (o1, o2) -> o1.getPrice() - o2.getPrice());
		for (Tshirt tshirt : tshirts) {
			System.out.println(tshirt);
		}
		
		//* Test
		System.out.println("======= Test steam() ========");
		Arrays.stream(tshirts).sorted((o1, o2) -> o1.getPrice() - o2.getPrice()).forEach(System.out::println);
		
	}

}
