package main.study.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class TestFunctionJava8 {
	/**
	 * JAVA8 Functional Test
	 * reference: https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/functional/
	 * functional: Consumer, Function, Predicate, Supplier
	 */
	/**
	 * Consumer: 전달받은 입력에 대한 작업을 수행하나 결과를 반환하지 않는다. (데이터 처리 및 소비)
	 * Function: 전달받은 입력에 대한 작업을 수행하고 결과를 반환한다. (데이터 변환 및 매핑)
	 * Predicate: 전달받은 입력에 대한 작업을 수행하고 결과의 Bool(True/False) 값 반환한다. (필터링 및 조건 확인)
	 * Supplier: 입력을 전달받지않고 구현된 작업을 수행하여 값을 반환(공급)한다. (객체 생성 및 값 생성, 지연 초기화)
	 */
	/**
	 * Test Program Name: 로또복권 프로그램 
	 * Description:
	 *  	1. 임의의 인원들에게 랜덤한 숫자들을 제공한다. (로또복권 제공)
	 * 		2. 별도로 랜덤한 숫자들을 생성한다. (로또복권 당첨번호 반환)
	 * 		3. 제공받은 인원들의 숫자들을 비교하여 일치하는 숫자의 개수를 반환한다. (당첨번호 맞춘 숫자의 개수 확인)
	 * 		4. 가장 많은 숫자가 일치한 인원들의 이름을 출력한다.
	 * Use:
	 * 		1. Supplier: 임의의 인원들에게 랜덤한 숫자 생성하여 제공, 별도 랜덤 숫자 생성
	 * 		2. Predicate: 숫자를 제공받은 인원들의 숫자들과 별도 생성한 랜덤 숫자들과 비교하여 일치 여부 확인
	 * 		3. Function: 각 인원들의 일치한 숫자의 개수를 반환
	 * 		4. Consumer: 일치한 숫자의 개수가 가장 많은 인원의 이름을 출력
	 * TODO
	 * 		당첨번호를 제공받은 인원들의 숫자들을 각각 비교하여 일치되는 숫자의 개수 반환
	 * 		가장 많은 숫자가 일치한 인원들의 이름을 반환, 출력
	 * 		예외처리 (Null 등)
	 */
	
	/** 생성할 숫자의 개수 **/
	private final static int __numberCount__ = 6;
	/** 랜덤으로 생성할 숫자의 최대값 **/
	private final static int __numberMax__ = 45;
	
	public static void main(String[] args) {
		/** 임의의 사람들 **/
		String[] persons = {"배대준", "고형주", "노주원", "추태훈", "송정주"
							, "서철희", "설희윤", "남윤주", "배종일", "손문옥"};
		int personsCount = persons.length;

		/** 랜덤한 숫자 배열 생성 **/
		Supplier<int[]> randNumsSup = () -> getNumbers();
		
		/** 숫자들을 제공받은 사람들 **/
		List<PersonLotto> personLottoList = new ArrayList<PersonLotto>();
		
		/** 사람들에게 각각 랜덤한 숫자들을 제공 **/
		IntStream.range(0, personsCount)
        		.forEach(idx -> personLottoList.add(new PersonLotto(persons[idx], randNumsSup.get())));
		
		System.out.println("숫자들을 제공받은 사람들 목록 출력:");
        for (PersonLotto person : personLottoList) {
            System.out.println(person.getName() + ": " + Arrays.toString(person.getNumbers()));
        }
        
        int[] winNums = randNumsSup.get();
        System.out.println("당첨번호: " + Arrays.toString(winNums));
		
	}
	
	/**
	 * 최댓값 __numberMax__+1 인 랜덤한 정수 개수 __numberCount__ 를 배열로 반환한다.
	 * @return int[]
	 */
	public static int[] getNumbers() {
		int[] numbers = new int[__numberCount__];
		Random random = new Random();
		
		numbers = random.ints(1, __numberMax__ + 1)	// 랜덤 생성할 정수의 범위
		                .distinct()                 // 중복 제거
		                .limit(__numberCount__)     // 생성 개수
		                .sorted()					// 정렬
		                .toArray();                 // 생성한 숫자를 배열로 변환
		
		return numbers;
	}
	

}
