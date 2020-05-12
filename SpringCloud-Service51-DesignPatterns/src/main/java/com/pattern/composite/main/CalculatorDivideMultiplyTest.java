package com.pattern.composite.main;

import com.pattern.composite.command.Test;
import com.pattern.composite.concreteCommand.CalculatorDivideTest;
import com.pattern.composite.invoker.TestRunner;
import com.pattern.composite.suite.TestSuite;

public class CalculatorDivideMultiplyTest {
    public static Test suite() {
	TestSuite suite = new TestSuite();
	suite.add(new CalculatorDivideTest());
	//	suite.add(new CalculatorMultiplyTest());
	return suite;
    }

    public static void main(String[] args) {
	TestRunner.run(suite());
    }
}
