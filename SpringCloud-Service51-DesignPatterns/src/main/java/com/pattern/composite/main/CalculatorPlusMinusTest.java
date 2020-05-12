package com.pattern.composite.main;

import com.pattern.composite.command.Test;
import com.pattern.composite.concreteCommand.CalculatorMinusTest;
import com.pattern.composite.concreteCommand.CalculatorPlusTest;
import com.pattern.composite.invoker.TestRunner;
import com.pattern.composite.suite.TestSuite;

public class CalculatorPlusMinusTest {
    public static Test suite() {
	TestSuite suite = new TestSuite();
	suite.add(new CalculatorPlusTest());
	suite.add(new CalculatorMinusTest());
	return suite;
    }

    public static void main(String[] args) {
	TestRunner.run(suite());
    }
}
