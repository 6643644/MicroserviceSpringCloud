package com.pattern.command02.invoker;

import java.util.ArrayList;
import java.util.List;

import com.pattern.command02.command.Test;

public class TestRunner {
    private List<Test> tests;

    public TestRunner() {
	tests = new ArrayList<Test>();
    }

    public void add(Test test) {
	tests.add(test);
    }

    public void run() {
	for (Test test : tests) {
	    test.run();
	}
    }
}





