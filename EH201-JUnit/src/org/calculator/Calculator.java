package org.calculator;

public class Calculator {
	
	public int add(int x, int y) { return x + y; }
	public int sub(int x, int y) { return x - y; }
	public int mul(int x, int y) { return x * y; }
	public int div(int x, int y) { 
		if (y == 0) {
			return Integer.MAX_VALUE;
		} else {
			return x / y; 
		}
	}
}
