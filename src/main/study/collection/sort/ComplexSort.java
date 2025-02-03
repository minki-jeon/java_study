package main.study.collection.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.collections4.comparators.ComparatorChain;

public class ComplexSort {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/collection/sort/ComplexSort.java

	private static List<Product> products = new ArrayList<>();

	public static void main(String[] args) {
		prepareData();
		
		//* Java Build Path -> Libraries -> Classpath -> Add External JARs -> "commons-collections4-4.4.jar"
		ComparatorChain chain = new ComparatorChain();
		//비교할 대상을 각 Comparator로 작성
		chain.addComparator(comparatorPrdId);
		chain.addComparator(comparatorPrdSize);
		
		Collections.sort(products, chain);
		
	}
	
	/**
	 * 상품 아이디를 정렬
	 */
	public static Comparator<Product> comparatorPrdId = (o1, o2) ->
			o1.getPrdId().compareToIgnoreCase(o2.getPrdId());

	/**
	 * 상품 사이즈를 정렬
	 */
	public static Comparator<Product> comparatorPrdSize = Comparator.comparing(Product::getPrdSize);
			
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
