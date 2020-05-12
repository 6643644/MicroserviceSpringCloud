package com.pattern.composite.concreteCommand;

import com.pattern.composite.command.Test;
import com.pattern.composite.receiver.Calculator;

public class CalculatorDivideTest implements Test {

    @Override
    public void run() {
	Calculator calculator = new Calculator();
	double expected = 3;
	double result = calculator.divide(5, 2);
	if (expected == result) {
	    System.out.println("正確");
	} else {
	    System.out.println("不正確");
	}

    }

}
