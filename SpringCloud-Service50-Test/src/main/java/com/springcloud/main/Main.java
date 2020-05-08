package com.springcloud.main;

import java.math.BigDecimal;

import com.springcloud.testClass.CalculatorTest;

public class Main {

    public static void main(String[] args) {
//	System.out.println("測試~");
//	CalculatorTest.testPlus();
//	CalculatorTest.testMinus();
	
	String XchgPrice = "60";
	String MinBonusPt = "1000";
//	System.out.println(new BigDecimal(XchgPrice).divide(new BigDecimal(MinBonusPt)));
//	System.out.println(Double.parseDouble(XchgPrice) / Double.parseDouble(MinBonusPt));
	System.out.println((Integer.parseInt(XchgPrice) * 14000) / Integer.parseInt(MinBonusPt));
	
	
    }
}
