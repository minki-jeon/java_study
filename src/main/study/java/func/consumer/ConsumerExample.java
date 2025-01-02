package main.study.java.func.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/functional/consumer/ConsumerExample.java

	public static void main(String[] args) {
		List<String> colors = Arrays.asList("blue", "green", "white", "red", "yellow", "bluesky");

		Consumer<String> printLength = (color) -> System.out.println(color + "의 길이는 " + color.length());
		colors.forEach(printLength);
		
	}

}
