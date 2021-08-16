package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	public int add(int a, int b) {
		return a + b;
	}
	
	public int sub(int a, int b) {
		return a- b;
	}
	
	@Test
	public void test1() {
		int ans = add(4, 5);
		assertNotEquals(ans, 11);
	}
	
	@Test
	public void test2() {
		int ans = sub(5, 5);
		assertEquals(ans, 0);
	}

}
