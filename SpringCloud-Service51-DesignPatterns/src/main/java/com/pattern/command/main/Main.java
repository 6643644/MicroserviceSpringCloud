package com.pattern.command.main;

import com.pattern.command.action.Command;
import com.pattern.command.execute.ExecuteMealA;
import com.pattern.command.execute.ExecuteMealB;
import com.pattern.command.personnel.Cook;
import com.pattern.command.personnel.Waiter;

/**
 * Command Pattern 設計模式(Client)
 * 負責建立 具體命令 並組裝 接收者
 * 建立 具體的命令物件 (ConcreteCommand)，並設定其接收者 (Receiver)，此處的 Client 是站在『命令模式』的立場，而非泛指的『客戶』！
 * 
 */
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
