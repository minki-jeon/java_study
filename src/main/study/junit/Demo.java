package main.study.junit;

import java.util.Scanner;

public class Demo {
	//* ref: https://dev-test-hqsw.tistory.com/13
	//* 숫자 3개를 입력받고 삼각형이 성립하는지 확인하는 프로그램
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//* input 숫자
		System.out.print("Enter number 1: ");
		int input_1 = sc.nextInt();
		System.out.println(input_1);

		System.out.print("Enter number 2: ");
		int input_2 = sc.nextInt();
		System.out.println(input_2);

		System.out.print("Enter number 3: ");
		int input_3 = sc.nextInt();
		System.out.println(input_3);
		
		if(isTriangle(input_1, input_2, input_3)) {
			System.out.println("This is a Triangle.");
		} else {
			System.out.println("This is not a Triangle");
		}
		sc.close();
	}

	public static boolean isTriangle(int a, int b, int c) {
		if ((a + b > c) && (a + c > b) && (b + c > a)) return true;
		return false;
	}

}
