package main.study.java.func.predicate;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class TshirtPredicateApp {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/functional/predicate/TshirtPredicateApp.java

	public static void main(String[] args) {
		List<Tshirt> myShirtList = asList(new Tshirt(100, "yellow"),
				new Tshirt(200, "red"),
				new Tshirt(400, "purple"),
				new Tshirt(600, "red"),
				new Tshirt(200, "green"),
				new Tshirt(300, "blue"),
				new Tshirt(400, "red"),
				new Tshirt(500, "white"));
		
		List<Tshirt> priceFilter = filter(myShirtList, new TshirtPricePredicate());
		List<Tshirt> colorFilter = filter(myShirtList, new TshirtColorPredicate());
        List<Tshirt> colorPriceFilter = filter(myShirtList, new TshirtColorPricePredicate());
		
		System.out.println("price filter = " + priceFilter);
		System.out.println("color filter = " + colorFilter);
        System.out.println("colorPrice filter = " + colorPriceFilter);
	}
	
	private static List<Tshirt> filter(List<Tshirt> myShirtList, TshirtPredicate predicate) {
		List<Tshirt> list = new ArrayList<>();
		for (Tshirt tshirt : myShirtList) {
			if (predicate.test(tshirt)) {
				list.add(tshirt);
			}
		}
		return list;
	}

}
