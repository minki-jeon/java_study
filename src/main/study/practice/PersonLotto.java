package main.study.practice;

import java.util.List;
import java.util.Map;

public class PersonLotto {
	
	private String name;		// 복권 구매자
	private int[] numbers;		// 복권 1장 등록번호
	private List<int[]> tickets;	// 소유 복권 목록 TODO Deprecated
	private int count;			// 복권 수량
	private int winCount;		// 당첨번호 일치 개수	TODO Deprecated
	private boolean isBonus;	// 보너스번호 일치 여부	TODO Deprecated
	private List<Map<String, Object>> winInfoList;	// 당첨정보 (index, winCount, isBouns)
	
	public PersonLotto(String name, int[] numbers, List<int[]> tickets) {
		this.name = name;
		this.numbers = numbers;
		this.tickets = tickets;
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
	 * @return the tickets
	 */
	public List<int[]> getTickets() {
		return tickets;
	}

	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<int[]> tickets) {
		this.tickets = tickets;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
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

	/**
	 * @return the winInfoList
	 */
	public List<Map<String, Object>> getWinInfoList() {
		return winInfoList;
	}

	/**
	 * @param winInfoList the winInfoList to set
	 */
	public void setWinInfoList(List<Map<String, Object>> winInfoList) {
		this.winInfoList = winInfoList;
	}
	
	
	
}
