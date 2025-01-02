package main.study.java.func.consumer;

import java.util.function.Consumer;

public class PrintLength implements Consumer<String> {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/functional/consumer/PrintLength.java

	public void accept(String color) {
		System.out.println("단어 '" + color + "'의 길이는 " + color.length());
	}

}
