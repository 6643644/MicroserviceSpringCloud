package com.pattern.command.main;

import com.pattern.command.action.Command;
import com.pattern.command.execute.ExecuteMealA;
import com.pattern.command.execute.ExecuteMealB;
import com.pattern.command.personnel.Cook;
import com.pattern.command.personnel.Waiter;

public class Main {

    public static void main(String[] args) {
	Cook cook = new Cook();
	
	Waiter waiter = new Waiter();
	
	Command commandA = new ExecuteMealA(cook);
	Command commandB = new ExecuteMealB(cook);
	
	waiter.addOrder(commandA);
	waiter.addOrder(commandB);
	
	waiter.sendOrders();

    }

}
