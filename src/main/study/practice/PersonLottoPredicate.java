package main.study.practice;

import java.util.stream.IntStream;

@FunctionalInterface
interface PersonLottoPredicate {
	public boolean test(PersonLotto pl, int num);
}

class IsNumberPredicate implements PersonLottoPredicate {
	public boolean test(PersonLotto pl, int num) {
		return IntStream.of(pl.getNumbers()).anyMatch(n -> n == num);
	}
}

