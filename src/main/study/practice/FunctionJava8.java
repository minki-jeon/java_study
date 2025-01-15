package main.study.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class FunctionJava8 {
	/**
	 * JAVA8 Functional Practice
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
	 * Practice Program Name: 로또복권 프로그램 
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
	 * 		가장 많은 숫자가 일치한 인원들의 이름을 반환, 출력
	 * 		로또번호 등수 계산, 출력
	 * 		예외처리 (Null 등)
	 * 		당첨+보너스번호 별도 객체 생성
	 */
	
	/** 생성할 숫자의 개수 **/
	private final static int __numberCount__ = 6;
	/** 랜덤으로 생성할 숫자의 최대값 **/
	private final static int __numberMax__ = 45;

	/** 랜덤한 숫자 배열 생성 **/
	private final static Supplier<int[]> randNumbersSup = () -> getNumbers();
	/** 랜덤한 숫자 1개 생성 **/
	private final static Supplier<Integer> randNumSup = () -> new Random().nextInt(__numberMax__ + 1);

	/** 숫자 포함 여부 체크 **/
	private final static PersonLottoPredicate plp = new IsNumberPredicate();
	
	/** 당첨번호 6개 + 보너스 1개 생성 **/
	private final static Supplier<Map<String, Object>> winNumbersSup = () -> getWinNumbers();
    /** 당첨번호+보너스번호 저장 **/
	private final static Map<String, Object> winNumsMap = winNumbersSup.get();
	/** 당첨번호 **/
	private static int[] __winNums__ = new int[__numberCount__];
	/** 보너스번호 **/
	private static int __bonusNum__ = 0;
	
	public static void main(String[] args) {
		/** 임의의 사람들 **/
		String[] persons = {"배대준", "고형주", "노주원", "추태훈", "송정주"
							, "서철희", "설희윤", "남윤주", "배종일", "손문옥"};
		int personsCount = persons.length;
		
		/** 숫자들을 제공받은 사람들 **/
		List<PersonLotto> personLottoList = new ArrayList<PersonLotto>();
		
		/** 사람들에게 각각 랜덤한 숫자들을 제공 **/
		IntStream.range(0, personsCount)
        		.forEach(idx -> personLottoList.add(new PersonLotto(persons[idx], randNumbersSup.get())));
		
//		System.out.println("숫자들을 제공받은 사람들 목록 출력:");
//        for (PersonLotto person : personLottoList) {
//            System.out.println(person.getName() + ": " + Arrays.toString(person.getNumbers()));
//        }
        
        /** 당첨번호 + 보너스번호 **/
        for (Map.Entry<String, Object> entry : winNumsMap.entrySet()) {
        	if ("winNums".equals(entry.getKey())) __winNums__ = (int[]) entry.getValue();
        	if ("bonusNum".equals(entry.getKey())) __bonusNum__ = (int) entry.getValue();
		}
        System.out.println("당첨번호: " + Arrays.toString(__winNums__));
        System.out.println("보너스번호: " + __bonusNum__);
        
        /** 일치한 당첨번호 개수 + 보너스번호 일치 여부 set **/
        Function<PersonLotto, Integer> matchNumberCount = pl -> isNumberCount(pl);
        int bonusNum = __bonusNum__;
        for (PersonLotto person : personLottoList) {
        	person.setWinCount(matchNumberCount.apply(person));
        	person.setBonus(isNumber(person, bonusNum, plp));
        }
        
        /** 당첨 결과 출력 **/
        System.out.println("당첨 개수 출력:");
        for (PersonLotto person : personLottoList) {
        	System.out.println(person.getName() + ": " + Arrays.toString(person.getNumbers()));
            System.out.println(person.getName() + " 당첨 개수: " + person.getWinCount() + ", 보너스 일치: " + person.isBonus());
        }
        
        /** TODO 당첨번호와 일치하는 개수가 많은 사람의 이름과 개수 출력 **/
        
        /** TODO 사람들의 로또복권 등수 출력 (보너스번호 포함 계산) **/
        
	}
	
	/**
	 * 최댓값 __numberMax__+1 인 랜덤한 정수 개수 __numberCount__ 를 배열로 반환한다.
	 * @return int[]
	 */
	private static int[] getNumbers() {
		int[] resultArr = new int[__numberCount__];
		Random random = new Random();
		
		resultArr = random.ints(1, __numberMax__ + 1)	// 랜덤 생성할 정수의 범위
		                .distinct()                 // 중복 제거
		                .limit(__numberCount__)     // 생성 개수
		                .sorted()					// 정렬
		                .toArray();                 // 생성한 숫자를 배열로 변환
		
		return resultArr;
	}
	
	/**
	 * 당첨번호와 보너스번호를 반환한다
	 * @return Map<String, Object>
	 */
	private static Map<String, Object> getWinNumbers() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		/** 당첨번호 **/
		int[] randNums = randNumbersSup.get();
		
		/** 보너스번호 **/
		int bonusNum = randNumSup.get();
		
		/** 보너스번호 중복 체크 **/
		PersonLotto pl = new PersonLotto("WIN-NUMBERS", randNums);
		boolean isNum = isNumber(pl, bonusNum, plp);
		while (isNum) {
			bonusNum = randNumSup.get();
			isNum = isNumber(pl, bonusNum, plp);
		}
		
		/** 당첨번호 반환 **/
		resultMap.put("winNums", randNums);
		resultMap.put("bonusNum", bonusNum);
		return resultMap;
	}
	
	/**
	 * 숫자배열에 number 값이 포함되어 있는지 체크한다.
	 * @param pl
	 * @param number
	 * @param predicate
	 * @return boolean
	 */
	private static boolean isNumber(PersonLotto pl, int number, PersonLottoPredicate predicate) {
		return predicate.test(pl, number);
	}

	/**
	 * 당첨번호와 일치하는 숫자의 개수를 반환한다.
	 * @param pl
	 * @return int
	 */
	private static int isNumberCount(PersonLotto pl) {
		int resultInt = 0;
		
		/** 당첨번호  **/
        int[] winNums = __winNums__;
        
        for (int num : winNums) {
        	if (isNumber(pl, num, plp)) resultInt++;
        }
		
		return resultInt;
	}
}
