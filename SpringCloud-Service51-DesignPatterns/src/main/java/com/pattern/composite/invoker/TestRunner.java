package com.pattern.composite.invoker;

import com.pattern.composite.command.Test;

public class TestRunner {
    public static void run(Test test) {
	test.run();
    }
}
