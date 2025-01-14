package main.study.java;

public class testFunctionJava8 {
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
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
