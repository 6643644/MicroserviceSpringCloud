package com.pattern.composite.concreteCommand;

import com.pattern.composite.command.Test;
import com.pattern.composite.receiver.Calculator;

public class CalculatorMinusTest implements Test {

    @Override
    public void run() {
	Calculator calculator = new Calculator();
	int expected = 3;
	int result = calculator.minus(5, 2);
	if (expected == result) {
	    System.out.println("正確");
	} else {
	    System.out.println("不正確");
	}

    }

}
