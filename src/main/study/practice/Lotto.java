package main.study.practice;

public class Lotto {
	
	private int[] winNumbers;		// 당첨번호
	private int bonusNumber;		// 보너스번호
	
	private int totalCost;			// 복권 전체 판매 금액
	private int count;				// 복권 판매 수량
	private static final int cost = 10000;	// 복권 1장 비용
	
	private static final double amountRatio_1st = 0.3;	// 1등 당첨금액 비율
	private static final double amountRatio_2nd = 0.25;	// 2등 당첨금액 비율
	private static final double amountRatio_3rd = 0.2;	// 3등 당첨금액 비율
	private static final double amountRatio_4th = 0.15;	// 4등 당첨금액 비율
	private static final double amountRatio_5th = 0.1;	// 5등 당첨금액 비율
	
	private int count_1st;			// 1등 당첨 수
	private int count_2nd;			// 2등 당첨 수
	private int count_3rd;			// 3등 당첨 수
	private int count_4th;			// 4등 당첨 수
	private int count_5th;			// 5등 당첨 수
	
	/**
	 * @return the winNumbers
	 */
	public int[] getWinNumbers() {
		return winNumbers;
	}
	/**
	 * @param winNumbers the winNumbers to set
	 */
	public void setWinNumbers(int[] winNumbers) {
		this.winNumbers = winNumbers;
	}
	/**
	 * @return the bonusNumber
	 */
	public int getBonusNumber() {
		return bonusNumber;
	}
	/**
	 * @param bonusNumber the bonusNumber to set
	 */
	public void setBonusNumber(int bonusNumber) {
		this.bonusNumber = bonusNumber;
	}
	/**
	 * @return the totalCost
	 */
	public int getTotalCost() {
		return totalCost;
	}
	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
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
	 * @return the cost
	 */
	public static final int getCost() {
		return cost;
	}
	/**
	 * @return the amountratio1st
	 */
	public static final double getAmountratio1st() {
		return amountRatio_1st;
	}
	/**
	 * @return the amountratio2nd
	 */
	public static final double getAmountratio2nd() {
		return amountRatio_2nd;
	}
	/**
	 * @return the amountratio3rd
	 */
	public static final double getAmountratio3rd() {
		return amountRatio_3rd;
	}
	/**
	 * @return the amountratio4th
	 */
	public static final double getAmountratio4th() {
		return amountRatio_4th;
	}
	/**
	 * @return the amountratio5th
	 */
	public static final double getAmountratio5th() {
		return amountRatio_5th;
	}
	/**
	 * @return the count_1st
	 */
	public int getCount_1st() {
		return count_1st;
	}
	/**
	 * @param count_1st the count_1st to set
	 */
	public void setCount_1st(int count_1st) {
		this.count_1st = count_1st;
	}
	/**
	 * @return the count_2nd
	 */
	public int getCount_2nd() {
		return count_2nd;
	}
	/**
	 * @param count_2nd the count_2nd to set
	 */
	public void setCount_2nd(int count_2nd) {
		this.count_2nd = count_2nd;
	}
	/**
	 * @return the count_3rd
	 */
	public int getCount_3rd() {
		return count_3rd;
	}
	/**
	 * @param count_3rd the count_3rd to set
	 */
	public void setCount_3rd(int count_3rd) {
		this.count_3rd = count_3rd;
	}
	/**
	 * @return the count_4th
	 */
	public int getCount_4th() {
		return count_4th;
	}
	/**
	 * @param count_4th the count_4th to set
	 */
	public void setCount_4th(int count_4th) {
		this.count_4th = count_4th;
	}
	/**
	 * @return the count_5th
	 */
	public int getCount_5th() {
		return count_5th;
	}
	/**
	 * @param count_5th the count_5th to set
	 */
	public void setCount_5th(int count_5th) {
		this.count_5th = count_5th;
	}
	
}
