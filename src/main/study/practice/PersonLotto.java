package main.study.practice;

public class PersonLotto {
	
	private String name;		// 복권 구매자
	private int[] numbers;		// 복권 등록번호
	private int winCount;		// 당첨번호 일치 개수
	private boolean isBonus;	// 보너스번호 일치 여부
	
	public PersonLotto(String name, int[] numbers) {
		this.name = name;
		this.numbers = numbers;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the numbers
	 */
	public int[] getNumbers() {
		return numbers;
	}

	/**
	 * @param numbers the numbers to set
	 */
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	/**
	 * @return the winCount
	 */
	public int getWinCount() {
		return winCount;
	}

	/**
	 * @param winCount the winCount to set
	 */
	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}

	/**
	 * @return the isBonus
	 */
	public boolean isBonus() {
		return isBonus;
	}

	/**
	 * @param isBonus the isBonus to set
	 */
	public void setBonus(boolean isBonus) {
		this.isBonus = isBonus;
	}
	
	
	
}
