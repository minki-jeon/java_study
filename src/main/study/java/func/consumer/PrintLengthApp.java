package main.study.java.func.consumer;

import java.util.Arrays;
import java.util.List;

public class PrintLengthApp {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/functional/consumer/PrintLengthApp.java

	public static void main(String[] args) {
		List<String> colors = Arrays.asList("blue", "green", "white", "red", "yellow", "bluesky");
		PrintLength printLength = new PrintLength();
		colors.forEach(printLength);
	}

}
