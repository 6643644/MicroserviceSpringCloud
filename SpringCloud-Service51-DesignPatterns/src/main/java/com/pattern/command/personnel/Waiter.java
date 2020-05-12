package com.pattern.command.personnel;

import java.util.LinkedList;
import java.util.Queue;

import com.pattern.command.action.Command;

/**
 * Command Pattern 設計模式(Invoker)
 * 負責儲存與呼叫命令
 * 儲存 具體的命令物件 (ConcreteCommand)，
 * 並負責呼叫該命令 —— ConcreteCommand.Execute()，
 * 若該 Command 有實作 『復原』功能，則在執行之前，先儲存其狀態。
 * 
 */
public class Waiter {

    private Queue<Command> orders = new LinkedList<>();

    public void addOrder(Command command) {
	orders.offer(command);
    }

    public void cancelOrder(Command command) {
	orders.remove(command);
    }

    public void sendOrders() {
	while (!orders.isEmpty()) {
	    Command cmd = orders.poll();
	    cmd.execute();
	}
    }

}
