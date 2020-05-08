package com.springcloud.util;

public class Assert {
    public static void assertEquals(int expected, int result) {
	if (expected == result) {
	    System.out.println("正確！");
	} else {
	    System.out.printf("失敗，預期為 %d，但是傳回 %d！%n", expected, result);
	}
    }
}
