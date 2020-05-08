package com.pattern.command.execute;

import com.pattern.command.action.Command;
import com.pattern.command.personnel.Cook;

public class ExecuteMealA implements Command {

    private Cook cook;

    public ExecuteMealA(Cook cook) {
	this.cook = cook;
    }

    @Override
    public void execute() {
	cook.cookMealA();

    }

}
