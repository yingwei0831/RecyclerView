package com.yw.testrecyclerview.test;

import com.yw.testrecyclerview.mytest.Calculator;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    //单元测试
    @Test
    public void testAdd(){
        Calculator c = new Calculator();
        int sum = c.add(9, 16);
        Assert.assertEquals(25, sum);
    }
}