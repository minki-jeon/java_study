package main.study.quiz;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/quiz/Bracket.java

/**
 * input
3
{[()]}
{[(])}
{{[[(())]]}}

 * result
YES
NO
YES
 */
	//* 괄호 짝짓기 프로그램
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println((isBalaced(expression)) ? "YES" : "NO");
		}

	}

private static boolean isBalaced(String expression) {
	Stack<String> stack = new Stack<>();
	
	for (int i = 0; i < expression.length(); i++) {
		String ch = expression.substring(i, i + 1);
		if (ch.equals("[") || ch.equals("{") || ch.equals("(")) {
			stack.push(ch);
		} else {
			if (ch.equals(")")) {
				// 스택이 비어있다면, 밸런스가 맞지 않는 것이므로 false를 반환
				if (stack.empty()) {
					return false;
				}
				if (stack.peek().equals("(")) {
					//* 짝이 맞는 괄호
					stack.pop();
				}
			} else if (ch.equals("}")) {
				//* 다른 괄호와 동일한 방식
				if (stack.empty()) {
					return false;
				}
				if (stack.peek().equals("{")) {
					stack.pop();
				}
			} else if (ch.equals("]")) {
				if (stack.empty()) {
					return false;
				}
				if (stack.peek().equals("[")) {
					stack.pop();
				}
			}
			
			//* 다른 방식
			/*
			if (stack.empty()) {
				return false;
			}
			if (ch.equals(")") && stack.peek().equals("(") ||
				ch.equals("}") && stack.peek().equals("{") ||
				ch.equals("]") && stack.peek().equals("[")) {
				//* 짝이 맞는 괄호
				stack.pop();
			} else {
				return false;
			}
			*/
		}
	}
	//* 괄호의 짝을 모두 맞게 찾아서 empty 상태가 되면 true 반환
	return stack.empty();
}

}
