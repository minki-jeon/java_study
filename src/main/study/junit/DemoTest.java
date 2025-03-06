package main.study.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class DemoTest {
	//* ref: https://dev-test-hqsw.tistory.com/13
	
	@Test
	public void test_is_triangle_1() {
		assertTrue(Demo.isTriangle(3, 4, 5));
	}
	
	@Test
	public void test_is_triangle_2() {
		assertTrue(Demo.isTriangle(5, 12, 13));
	}
	
	@Test
	public void test_is_triangle_3() {
		assertTrue(Demo.isTriangle(5, 13, 12));
	}
	
	@Test
	public void test_is_triangle_4() {
		assertTrue(Demo.isTriangle(12, 5, 13));
	}
	
	@Test
	public void test_is_triangle_5() {
		assertTrue(Demo.isTriangle(12, 13, 5));
	}
	
	@Test
	public void test_is_NOT_triangle_1() {
		assertFalse(Demo.isTriangle(5, 7, 13));
	}
	
	@Test
	public void test_is_NOT_triangle_2() {
		assertFalse(Demo.isTriangle(5, 13, 7));
	}
	
	@Test
	public void test_is_NOT_triangle_3() {
		assertFalse(Demo.isTriangle(13, 5, 7));
	}
	
	@Test
	public void test_is_NOT_triangle_4() {
		assertFalse(Demo.isTriangle(13, 7, 5));
	}
	
	@Test
	public void test_main_1() {
		ByteArrayInputStream in = new ByteArrayInputStream("5\n12\n13\n".getBytes());
		System.setIn(in);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		Demo.main(new String[] {});
		
		String consoleOutput = "Enter number 1: 5" +  System.lineSeparator();
		consoleOutput += "Enter number 2: 12" +  System.lineSeparator();
		consoleOutput += "Enter number 3: 13" +  System.lineSeparator();
		consoleOutput += "This is a Triangle." +  System.lineSeparator();
		
		assertEquals(consoleOutput, out.toString());
	}

}
