package com.pattern.command.personnel;

/**
 * Command Pattern 設計模式(Receiver)
 * 負責執行命令的內容，任何能實現命令請求的類別，都有可能當作 Receiver。
 * 
 */
public class Cook {
    
    public void cookMealA() {
	System.out.println("餐點A");
    }
    
    public void cookMealB() {
	System.out.println("餐點B");
    }
}
