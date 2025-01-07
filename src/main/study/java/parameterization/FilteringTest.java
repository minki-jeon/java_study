package main.study.java.parameterization;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import main.study.java.func.predicate.Tshirt;

public class FilteringTest {

	public static void main(String[] args) {
		List<Tshirt> myShirtList = asList(new Tshirt(100, "yellow"),
				new Tshirt(200, "red"),
				new Tshirt(400, "purple"),
				new Tshirt(600, "red"),
				new Tshirt(200, "green"),
				new Tshirt(300, "blue"),
				new Tshirt(400, "red"),
				new Tshirt(500, "white"));
		Predicate<Tshirt> priceFilter = t -> t.getPrice() > 300;
		List<Tshirt> filterColors = filter(myShirtList, priceFilter);
		System.out.println(filterColors);

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
