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
	 * 		1. 복권 수를 기준으로 등수별 복권 당첨 금액을 설정
	 * 		2. personLottoList 객체 리스트를 반복 구현한 기능들을 통합
	 * 		3. 출력 기능 포함한 main 내의 각각의 기능들을 별도 메소드로 분리
	 * 		4. PersonLotto 객체에 당첨 순위(rank) 추가
	 * 		5. 당첨+보너스번호 별도 객체 생성 + 전체 판매금액 + 전체 당첨금액 + 등수별 당첨 인원수
	 * TODO 예외처리
	 * 		1. 상수 NUMBER_COUNT, NUMBER_MAX 최소&최대값 설정
	 * 		2. 기본 로직 예외처리 (Null 등)
	 * 		3. 사람의 이름이 동일한 경우(동명이인) : 객체에 고유값 추가 (시퀀스번호)
	 * TODO 추후 추가하면 좋을 기능
	 * 		1. 사람 1명 당 복권 1개에서 복권 여러개 매핑 (복권의 수량도 각각 랜덤으로 설정)
	 * 		2. 통계: 복권에서 입력된 숫자들의 통계 (가장 많이 입력된 숫자부터 정렬) + 사람 1인당 평균 복권의 수량에 대한 통계
	 * 		3. 복권 수동 입력: 기존 자동(랜덤) 뿐만 아닌 숫자들을 입력 받아서 복권 등록하는 기능
	 * 		4. 사람+복권 또는 기존 사람의 복권 추가 등록: 사람과 복권을 추가로 입력 받아 등록하는 기능과 기존에 등록된 사람의 복권을 추가 등록하는 기능
	 * 		5. 생성할 숫자의 개수와 생성할 숫자의 최대값을 별도로 입력받고서 작업을 수행하는 기능
	 */
	
	/** 생성할 숫자의 개수 **/
//	private final static int NUMBER_COUNT = 6;
	private final static int NUMBER_COUNT = 5;	//test
	/** 랜덤으로 생성할 숫자의 최대값 **/
//	private final static int NUMBER_MAX = 45;
	private final static int NUMBER_MAX = 8;	//test
	/** 복권 1장 기준 가격 **/
	private final static int COST = 10000;

	/** 랜덤한 숫자 배열 생성 **/
	private final static Supplier<int[]> RAND_NUMBERS_SUP = () -> getNumbers();
	/** 랜덤한 숫자 1개 생성 **/
	private final static Supplier<Integer> RAND_NUM_SUP = () -> new Random().nextInt(1, NUMBER_MAX + 1);

	/** 숫자 포함 여부 체크 **/
	private final static PersonLottoPredicate PL_PRED = new IsNumberPredicate();
	
	/** 당첨번호 6개 + 보너스 1개 생성 **/
	private final static Supplier<Map<String, Object>> WIN_NUMBERS_SUP = () -> getWinNumbers();
    /** 당첨번호+보너스번호 저장 **/
	private final static Map<String, Object> WIN_NUMS_MAP = WIN_NUMBERS_SUP.get();
	/** 당첨번호 **/
	private static int[] __winNums__ = new int[NUMBER_COUNT];
	/** 보너스번호 **/
	private static int __bonusNum__ = 0;
	
	public static void main(String[] args) {
		/** 임의의 사람들 **/
		String[] persons = {"배대준", "고형주", "노주원", "추태훈", "송정주"
							, "서철희", "설희윤", "남윤주", "배종일", "손문옥"
							, "고기웅", "배은영", "류창민", "권지수", "고정재"
							, "임용욱", "풍만옥", "오시하", "심인태", "권진환"
							, "정예숙", "손효민", "성하훈", "남궁종희", "류남혁"};
		int personsCount = persons.length;
		
		/** 숫자들을 제공받은 사람들 **/
		List<PersonLotto> personLottoList = new ArrayList<PersonLotto>();
		
		/** 사람들에게 각각 랜덤한 숫자들을 제공 **/
		IntStream.range(0, personsCount)
        		.forEach(idx -> personLottoList.add(new PersonLotto(persons[idx], RAND_NUMBERS_SUP.get())));
		
//		System.out.println("숫자들을 제공받은 사람들 목록 출력:");
//        for (PersonLotto person : personLottoList) {
//            System.out.println(person.getName() + ": " + Arrays.toString(person.getNumbers()));
//        }
        
        /** 당첨번호 + 보너스번호 **/
        for (Map.Entry<String, Object> entry : WIN_NUMS_MAP.entrySet()) {
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
        	person.setBonus(isNumber(person, bonusNum, PL_PRED));
        }
        
        /** 당첨 결과 출력 **/
        System.out.println("당첨 개수 출력:");
        for (PersonLotto person : personLottoList) {
        	System.out.println(person.getName() + ": " + Arrays.toString(person.getNumbers()));
            System.out.println(person.getName() + " 당첨 개수: " + person.getWinCount() + ", 보너스 일치: " + person.isBonus());
        }
        
        
        /** 당첨번호와 일치하는 개수가 많은 사람의 이름과 개수 출력 (보너스 제외) **/
        PersonLottoConsumer plConsumer = new PersonLottoConsumer();
        plConsumer.accept(personLottoList);
//        int maxWinCount = 0;
//        List<String> maxCntPersons = new ArrayList<String>();
//        int winCount = 0;
//        for (PersonLotto person : personLottoList) {
//        	winCount = person.getWinCount();
//        	
//        	if (winCount < 1 || winCount < maxWinCount)	continue;
//        	
//        	if (winCount > maxWinCount) {
//        		/** 당첨번호 개수가 이전 사람보다 많은 경우 **/
//        		if (maxWinCount != 0) maxCntPersons.clear();        		
//    			maxWinCount = winCount;
//        		maxCntPersons.add(person.getName());
//        	} else {
//        		/** 당첨번호 개수가 동일한 경우 **/
//        		maxCntPersons.add(person.getName());
//        	}
//        }
//        //* 출력
//        if (maxWinCount != 0) {
//        	System.out.println("당첨번호를 " + maxWinCount + "개로 가장 많은 숫자를 맞춘 사람: " + maxCntPersons);
//        } else {
//        	System.out.println("당첨번호를 맞춘 사람이 존재하지 않습니다.");
//        }
        
        /** 
         * 사람들의 로또복권 등수 출력 (보너스번호 포함 계산)
         * 1등(6개 일치), 2등(5개 일치 + 보너스 일치), 3등(5개 일치), 4등(4개 일치), 5등(3개 일치)
         **/
        int numberCount = NUMBER_COUNT;
        int winCount = 0;
        /** 당첨등수별 당첨인원 **/
        int numA = 0;
        int numB = 0;
        int numC = 0;
        int numD = 0;
        int numE = 0;
        
        for (PersonLotto person : personLottoList) {
        	winCount = person.getWinCount();
        	if (winCount < numberCount - 3) {
        		//* Un-Rank
        		System.out.println(person.getName() + "님은 " + winCount + "개를 맞추셔서, 당첨이 되지 못하였습니다.");
        	} else if (winCount == numberCount - 3) {
        		//* 5등
        		numE++;
        		System.out.println(person.getName() + "님은 " + winCount + "개를 맞추셔서, 5등에 당첨되셨습니다.");
        	} else if (winCount == numberCount - 2) {
        		//* 4등
        		numD++;
        		System.out.println(person.getName() + "님은 " + winCount + "개를 맞추셔서, 4등에 당첨되셨습니다.");
        	} else if (winCount == numberCount - 1 && ! person.isBonus()) {
        		//* 3등
        		numC++;
        		System.out.println(person.getName() + "님은 " + winCount + "개를 맞추셔서, 3등에 당첨되셨습니다.");
        	} else if (winCount == numberCount - 1 && person.isBonus()) {
        		//* 2등
        		numB++;
        		System.out.println(person.getName() + "님은 " + winCount + "개와 보너스 번호를 맞추셔서, 2등에 당첨되셨습니다.");
        	} else if (winCount == numberCount) {
        		//* 1등
        		numA++;
        		System.out.println(person.getName() + "님은 " + winCount + "개 모두 맞추셔서, 1등에 당첨되셨습니다.");
        		
        	} else {
        		//* Error
        		System.out.println("Error Rank Check");
        	}
        }
        
        
        /** 
         * 복권 수를 기준으로 등수별 복권 당첨 금액을 설정
         * 1등(30%), 2등(10%), 3등(10%), 4등(15%), 5등(20%) 
         **/
        int cost = COST;	// 1장당 가격
        int count = 0;		// 수량
        int totalCost = 0;	// 전체 가격
        
        //* TODO 사람의 수가 아닌 복권의 수량으로 카운트를 할 수 있도록 로직 수정
        count = personsCount;
        totalCost = cost * count;
        //* TODO 등수별 당첨금액 비율 상수로 설정
        long moneyA = (long) (totalCost * 0.3);
        long moneyB = (long) (totalCost * 0.25);
        long moneyC = (long) (totalCost * 0.2);
        long moneyD = (long) (totalCost * 0.15);
        long moneyE = (long) (totalCost * 0.1);
        //* 계산 로직 변경 (리스트+반복문)
        long amountA = numA != 0 ? moneyA / numA : 0;
        long amountB = numB != 0 ? moneyB / numB : 0;
        long amountC = numC != 0 ? moneyC / numC : 0;
        long amountD = numD != 0 ? moneyD / numD : 0;
        long amountE = numE != 0 ? moneyE / numE : 0;
        
        System.out.println("1위 전체 당첨금액: " + moneyA);
        System.out.println("1위인 사람의 수: " + numA + ", 1위 당첨금액: " + amountA);
        System.out.println("2위 전체 당첨금액: " + moneyB);
        System.out.println("2위인 사람의 수: " + numB + ", 2위 당첨금액: " + amountB);
        System.out.println("3위 전체 당첨금액: " + moneyC);
        System.out.println("3위인 사람의 수: " + numC + ", 3위 당첨금액: " + amountC);
        System.out.println("4위 전체 당첨금액: " + moneyD);
        System.out.println("4위인 사람의 수: " + numD + ", 4위 당첨금액: " + amountD);
        System.out.println("5위 전체 당첨금액: " + moneyE);
        System.out.println("5위인 사람의 수: " + numE + ", 5위 당첨금액: " + amountE);
        
        
        
	}
	
	/**
	 * 최댓값 __numberMax__+1 인 랜덤한 정수 개수 __numberCount__ 를 배열로 반환한다.
	 * @return int[]
	 */
	private static int[] getNumbers() {
		int[] resultArr = new int[NUMBER_COUNT];
		Random random = new Random();
		
		resultArr = random.ints(1, NUMBER_MAX + 1)	// 랜덤 생성할 정수의 범위
		                .distinct()                 // 중복 제거
		                .limit(NUMBER_COUNT)     // 생성 개수
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
		int[] randNums = RAND_NUMBERS_SUP.get();
		
		/** 보너스번호 **/
		int bonusNum = RAND_NUM_SUP.get();
		
		/** 보너스번호 중복 체크 **/
		PersonLotto pl = new PersonLotto("WIN-NUMBERS", randNums);
		boolean isNum = isNumber(pl, bonusNum, PL_PRED);
		while (isNum) {
			bonusNum = RAND_NUM_SUP.get();
			isNum = isNumber(pl, bonusNum, PL_PRED);
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
        	if (isNumber(pl, num, PL_PRED)) resultInt++;
        }
		
		return resultInt;
	}
}
