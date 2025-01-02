package main.study.java.func.function;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringLengthExample2 {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/functional/function/StringLengthExample.java
	
	public static void main(String[] args) {
		Function<String, Integer> stringLength = s -> s.length();
		
		String str = "Function of String Length";
		int length = stringLength.apply(str);
		System.out.println("'"+str+"' 문자의 길이는 "+length+" 입니다.");
		
		List<String> words = Arrays.asList("function", "of", "string", "length", "coffee", "cookie", "notebook", "windows", "human", "community", "game");
		List<Integer> lengths = words.stream()
		                             .map(stringLength)
		                             .collect(Collectors.toList());
		
		System.out.println("문자들의 길이는 " + lengths);
		
		// list to map
		Map<String, Integer> wordLen = words.stream().collect(Collectors.toMap(Function.identity(), s -> s.length()));
		Map<String, Integer> wordLen2 = words.stream().collect(Collectors.toMap(Function.identity(), stringLength));
		Map<String, Integer> wordLen3 = IntStream.range(0, words.size()).boxed().collect(Collectors.toMap(words::get, lengths::get));
		
		System.out.println("1) 문자와 갈이는 " + wordLen);
		System.out.println("2) 문자와 갈이는 " + wordLen2);
		System.out.println("3) 문자와 갈이는 " + wordLen3);
	}
}
