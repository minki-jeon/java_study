package main.study.java.func.supplier;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class RandomNumberSupplier {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/functional/supplier/RandomNumberSupplier.java

	public static void main(String[] args) {
		Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(11);
		
		int randomNumber1 = randomNumberSupplier.get();
		int randomNumber2 = randomNumberSupplier.get();
		
		System.out.println("Random Supplier Number 1: " + randomNumber1);
		System.out.println("Random Supplier Number 2: " + randomNumber2);
		
		//* Test
		int randomNum1 = new Random().nextInt(11);		
		int randomNum2 = new Random().nextInt(11);
		System.out.println("Random() Num 1: " + randomNum1);
		System.out.println("Random() Num 2: " + randomNum2);
		
//		Stream.generate(randomNumberSupplier).limit(3).forEach(System.out::println);
		AtomicInteger seq = new AtomicInteger(1); // 시퀀스
		Stream.generate(randomNumberSupplier).limit(5).forEach(number -> System.out.println(seq.getAndIncrement() + ". Random No: " + number));
		
		
		System.out.println("Example with Lazy Evaluation:");

        Stream<Integer> numberStream = Stream.of(1, 2, 3, 4, 5, 6)
            .filter(n -> {
                System.out.println("Filtering: " + n);
                return n % 2 == 0; // Keep only even numbers
            })
            .map(n -> {
                System.out.println("Mapping: " + n);
                return n * n; // Square the number
            });

        // Lazy evaluation means nothing is executed until terminal operation
        System.out.println("Terminal operation:");
        numberStream.forEach(result -> System.out.println("Result: " + result));
	}

}
