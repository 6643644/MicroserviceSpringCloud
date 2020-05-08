package com.pattern.command.personnel;

import java.util.LinkedList;
import java.util.Queue;

import com.pattern.command.action.Command;

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
