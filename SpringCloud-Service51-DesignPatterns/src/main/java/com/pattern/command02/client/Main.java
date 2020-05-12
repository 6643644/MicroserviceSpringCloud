package com.pattern.command02.client;

import com.pattern.command02.command.Test;
import com.pattern.command02.concreteCommand.CalculatorPlusTest;
import com.pattern.command02.invoker.TestRunner;

public class Main {

    public static void main(String[] args) {
	TestRunner runner = new TestRunner();

	Test testPlus = new CalculatorPlusTest();
	//... 如果有多個請求可以一直產生新的請求並且將此請求放入陣列中

	runner.add(testPlus);
	
	runner.run();

    }

}






