package com.pattern.command02.concreteCommand;

import com.pattern.command02.command.Test;
import com.pattern.command02.receiver.Calculator;

public class CalculatorPlusTest implements Test {

    @Override
    public void run() {
	Calculator calculator = new Calculator();
	int expected = 3;
	int result = calculator.plus(1, 2);
	if (expected == result) {
	    System.out.println("正確");
	} else {
	    System.out.println("不正確");
	}

    }

}






