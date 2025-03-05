package main.study.quiz;

public class BinaryGap {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/quiz/BinaryGap.java

	public static void main(String[] args) {
		int x = 25;
		
		// decimal to binary
		String binaryString = Integer.toBinaryString(x);
		// decimal to hexadecimal
		String hexString = Integer.toHexString(x);
		// ASCII Code to hexadecimal
		String charAscII = Character.toString((char) x);
		
		System.out.println("binary : " + binaryString);
		System.out.println("hex : " + hexString);
		System.out.println("ASCII : " + charAscII);
		
		String str = "1226#24#";
		//* 문자열 내에 n번째 문자 추출
		int val = str.charAt(0) - '0';
		System.out.println(val);
		
		System.out.println(str.charAt(3) - str.charAt(str.length() - 2));
	}

}
