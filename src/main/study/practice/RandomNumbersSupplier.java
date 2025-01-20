package main.study.practice;

import java.util.Random;
import java.util.function.Supplier;

public class RandomNumbersSupplier implements Supplier<int[]> {
	// TODO 별도 객체 추가 (생성숫자 개수+최대값+복권 관련..)
	
	/** 생성할 숫자의 개수 **/
//	private final static int NUMBER_COUNT = 6;
	private final static int NUMBER_COUNT = 5;	//test
	/** 랜덤으로 생성할 숫자의 최대값 **/
//	private final static int NUMBER_MAX = 45;
	private final static int NUMBER_MAX = 8;	//test
	
	/**
	 * 최댓값 __numberMax__+1 인 랜덤한 정수 개수 __numberCount__ 를 배열로 반환한다.
	 * @return int[]
	 */

	public int[] getNumbers() {
		int[] resultArr = new int[NUMBER_COUNT];
		Random random = new Random();
		
		resultArr = random.ints(1, NUMBER_MAX + 1)	// 랜덤 생성할 정수의 범위
		                .distinct()                 // 중복 제거
		                .limit(NUMBER_COUNT)     	// 생성 개수
		                .sorted()					// 정렬
		                .toArray();                 // 생성한 숫자를 배열로 변환
		
		return resultArr;
	}

	@Override
	public int[] get() {
		// TODO Auto-generated method stub
		return null;
	}
}
