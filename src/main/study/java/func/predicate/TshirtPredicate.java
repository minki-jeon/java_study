package main.study.java.func.predicate;

@FunctionalInterface
interface TshirtPredicate {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/functional/predicate/TshirtPredicate.java
	public boolean test(Tshirt t);
}

class TshirtColorPredicate implements TshirtPredicate {
	public boolean test(Tshirt tshirt) {
		return "red".equals(tshirt.getColor());
	}
}

class TshirtPricePredicate implements TshirtPredicate {
	public boolean test(Tshirt tshirt) {
		return tshirt.getPrice() > 300;
	}
}

class TshirtColorPricePredicate implements TshirtPredicate {
    public boolean test(Tshirt tshirt) {
        return "red".equals(tshirt.getColor()) && tshirt.getPrice() > 300;
    }
}
