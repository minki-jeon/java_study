package main.study.practice.sort;

import java.util.Random;
import java.util.function.Supplier;

public class RandomNumbersSupplier implements Supplier<int[]> {

	@Override
	public int[] get() {
		CreateNumber createNumber = new CreateNumber();
		int numberCount = createNumber.getCount();
		int numberMax = createNumber.getMax();
		
		int[] resultArr = new int[numberCount];
		Random random = new Random();
		
		resultArr = random.ints(1, numberMax + 1)	// 랜덤 생성할 정수의 범위
		                .distinct()                 // 중복 제거
		                .limit(numberCount)     	// 생성 개수
//		                .sorted()					// 정렬
		                .toArray();                 // 생성한 숫자를 배열로 변환
		
		return resultArr;
	}
	
}
