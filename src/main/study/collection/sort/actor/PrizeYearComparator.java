package main.study.collection.sort.actor;

import java.util.Comparator;

public class PrizeYearComparator implements Comparator<Object> {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/collection/sort/actor/PrizeYearComparator.java

	public int compare(Object o1, Object o2) {
		int year1 = ((Actor) o1).prizeYear;
		int year2 = ((Actor) o2).prizeYear;
		return year1 > year2 ? -1 : (year1 == year2 ? 0 : 1);
	}
}
