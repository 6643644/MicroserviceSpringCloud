package com.junit.test;

import org.junit.Test;

import com.common.utils.StringUtils;

public class TestMain {

    @Test
    public void TestSpringUtilsToFullChar() {
        System.out.println(StringUtils.toFullChar("aaaaa"));
    }

}
