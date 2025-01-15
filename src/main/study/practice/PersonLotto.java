package main.study.practice;

public class PersonLotto {
	
	private String name;
	private int[] numbers;
	private int winCount;
	private boolean isBonus;
	
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
