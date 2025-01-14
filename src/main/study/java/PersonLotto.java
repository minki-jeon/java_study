package main.study.java;

public class PersonLotto {
	
	private String name;
	private int[] numbers;
	
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
	
	
	
}
