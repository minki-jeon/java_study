package main.study.junit;

import java.util.Scanner;

public class Demo2 {
	//* ref: https://dev-test-hqsw.tistory.com/15
	//* 원의 반지름을 입력받으면 해당 원의 둘레와 넓이(면적)을 반환하는 프로그램
	public static void main(String[] args) {
		double r, area, circum;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the radius: ");
		r = sc.nextDouble();
		
		circum = 2 * Math.PI * r;
		area = Math.PI * Math.pow(r, 2);
		
		System.out.println("For a circle with radius " + r + ",");
		System.out.println(" the circumference is " + circum);
		System.out.println(" and the area is " + area);
		
		sc.close();
	}

}
