package com.pattern.composite.main;

import com.pattern.composite.command.Test;
import com.pattern.composite.invoker.TestRunner;
import com.pattern.composite.suite.TestSuite;

public class CalculatorAllTest {
    public static Test suite() {
	TestSuite suite = new TestSuite();
	suite.add(CalculatorPlusMinusTest.suite());
	suite.add(CalculatorDivideMultiplyTest.suite());
	return suite;
    }

    public static void main(String[] args) {
	TestRunner.run(suite());
    }
}
