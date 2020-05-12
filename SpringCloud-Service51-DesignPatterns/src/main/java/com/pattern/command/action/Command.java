package com.pattern.command.action;

/**
 * Command Pattern 設計模式(Command)
 * 負責制定命令使用介面
 * 『至少』會含有一個 Execute() 的抽象操作 (方法) (abstract operation) 。
 */
public interface Command {
    void execute();
}
