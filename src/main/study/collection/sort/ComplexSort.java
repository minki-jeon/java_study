package main.study.collection.sort;

import java.util.ArrayList;
import java.util.List;

public class ComplexSort {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/collection/sort/ComplexSort.java

	private static List<Product> products = new ArrayList<>();

	public static void main(String[] args) {
		prepareData();
	}

	/**
	 * 미리 데이터를 생성
	 */
	private static void prepareData() {
		products.add(new Product("tshirt", 110));
		products.add(new Product("tshirt", 110));
		products.add(new Product("tshirt", 110));
		products.add(new Product("tshirt", 110));
		products.add(new Product("tshirt", 110));
	}

}
