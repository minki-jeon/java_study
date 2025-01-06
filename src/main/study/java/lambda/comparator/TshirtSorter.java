package main.study.java.lambda.comparator;

import java.util.Arrays;
import java.util.Comparator;

import main.study.java.func.predicate.Tshirt;

public class TshirtSorter {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/lambda/comparator/TshirtSorter.java

	public static void main(String[] args) {
		Tshirt[] tshirts = {new Tshirt(10000, "red"), new Tshirt(5000, "blue"), new Tshirt(8000, "green")};
		
		// 익명 클래스를 이용한 정렬
		Comparator<Tshirt> priceComparator = new Comparator<Tshirt>() {
			@Override
			public int compare(Tshirt o1, Tshirt o2) {
				return o1.getPrice() - o2.getPrice();
			}
		};
		
		Arrays.sort(tshirts, priceComparator);
		
		for (Tshirt tshirt : tshirts) {
			System.out.println(tshirt);
		}

	}

}
