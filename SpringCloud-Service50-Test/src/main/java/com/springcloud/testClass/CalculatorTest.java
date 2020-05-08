package com.springcloud.testClass;

import com.springcloud.expClass.Calculator;
import com.springcloud.util.Assert;

public class CalculatorTest {

    public static void testPlus() {
	Calculator calculator = new Calculator();
	int expected = 3;
	int result = calculator.plus(1, 2);
	Assert.assertEquals(expected, result);
	//	if (expected == result) {
	//	    System.out.println("成功！");
	//	} else {
	//	    System.out.printf("失敗，預期為 %d，但是傳回 %d！%n", expected, result);
	//	}
    }

    public static void testMinus() {
	Calculator calculator = new Calculator();
	int expected = 1;
	int result = calculator.minus(3, 2);
	Assert.assertEquals(expected, result);
	//	if (expected == result) {
	//	    System.out.println("正確！");
	//	} else {
	//	    System.out.printf("錯誤，傳回 %d，但應該是 %d！%n", result, expected);
	//	}
    }
}
