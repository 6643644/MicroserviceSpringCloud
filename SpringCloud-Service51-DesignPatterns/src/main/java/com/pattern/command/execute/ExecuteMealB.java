package com.pattern.command.execute;

import com.pattern.command.action.Command;
import com.pattern.command.personnel.Cook;

/**
 * Command Pattern 設計模式(ConcreteCommand)
 * 具體 的命令類別，通常持有 Receiver 物件。
 */
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
