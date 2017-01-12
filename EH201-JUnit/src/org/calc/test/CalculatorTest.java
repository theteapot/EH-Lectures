package org.calc.test;

import org.calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;


public class CalculatorTest {
	@Test
	public void add() {
		Calculator calc = new Calculator();
		Assert.assertEquals(calc.add(2, 3), 5);
	}
	@Test
	public void mult() {
		Calculator calc = new Calculator();
		Assert.assertEquals(calc.mul(2, 3), 6);
	}
	@Test
	public void div() {
		Calculator calc = new Calculator();
		Assert.assertEquals(calc.div(6, 3), 2);
		Assert.assertEquals(calc.div(3, 0), Integer.MAX_VALUE);
	}
	@Test
	public void sub() {
		Calculator calc = new Calculator();
		Assert.assertEquals(calc.sub(6, 2), 4);
	}
}
