package com.pattern.command.execute;

import com.pattern.command.action.Command;
import com.pattern.command.personnel.Cook;

public class ExecuteMealB implements Command {

    private Cook cook;

    public ExecuteMealB(Cook cook) {
	this.cook = cook;
    }

    @Override
    public void execute() {
	cook.cookMealB();

    }

}
