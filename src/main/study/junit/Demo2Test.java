package main.study.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class Demo2Test {
	//* ref: https://dev-test-hqsw.tistory.com/15
	
	@Test
	public void test_main_1() {
		String input = "1\n";
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Demo2.main(new String[] {});
		
		String consoleOutput = "Enter the radius: " + System.getProperty("line.separator");
		consoleOutput += "For a circle with radius 1.0," + System.getProperty("line.separator");
		consoleOutput += " the circumference is 6.283185307179586"  + System.getProperty("line.separator");
		consoleOutput += " and the area is 3.141592653589793" + System.getProperty("line.separator");
		
		assertEquals(consoleOutput, out.toString());
	}
	
	@Test
	public void test_main_2() {
		String input = "3\n";
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Demo2.main(new String[] {});
		
		String consoleOutput = "Enter the radius: " + System.getProperty("line.separator");
		consoleOutput += "For a circle with radius 3.0," + System.getProperty("line.separator");
		consoleOutput += " the circumference is 18.84955592153876"  + System.getProperty("line.separator");
		consoleOutput += " and the area is 28.274333882308138" + System.getProperty("line.separator");
		
		assertEquals(consoleOutput, out.toString());
	}

}
