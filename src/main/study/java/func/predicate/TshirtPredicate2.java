package main.study.java.func.predicate;

import java.util.Objects;

@FunctionalInterface
interface TshirtPredicate2<Tshirt> {
	public boolean test(Tshirt t, int p, String c);

    // 다른 Predicate와 연결하는 역할 &&
    default TshirtPredicate2<Tshirt> and(TshirtPredicate2<? super Tshirt> other) {
        Objects.requireNonNull(other);
        return (t, p, c) -> test(t, p, c) && other.test(t, p, c);
    }

    // test()의 반대 결과 반환 (ex: true -> false)
    default TshirtPredicate2<Tshirt> negate() {
        return (t, p, c) -> !test(t, p, c);
    }

    // 다른 Predicate와 연결하는 역할 ||
    default TshirtPredicate2<Tshirt> or(TshirtPredicate2<? super Tshirt> other) {
        Objects.requireNonNull(other);
        return (t, p, c) -> test(t, p, c) || other.test(t, p, c);
    }

    // 동일한지 체크
    default <Tshirt> TshirtPredicate2<Tshirt> isEqual(Tshirt targetRef) {
        return (null == targetRef)
                ? TshirtInputPredicate::isNull
                : (object, price, color) -> targetRef.equals(object);
    }

    @SuppressWarnings("unchecked")
    default <Tshirt> TshirtPredicate2<Tshirt> not(TshirtPredicate2<? super Tshirt> target) {
        Objects.requireNonNull(target);
        return (TshirtPredicate2<Tshirt>)target.negate();
    }

}

class TshirtInputPredicate implements TshirtPredicate2<Tshirt> {
    public static boolean isNull(Object obj, int p, String c) {
        return obj == null;
    }
    
    public boolean test(Tshirt tshirt, int price, String color) {
    	return color.equals(tshirt.getColor()) && ((tshirt.getPrice()) > price);
    }
}
