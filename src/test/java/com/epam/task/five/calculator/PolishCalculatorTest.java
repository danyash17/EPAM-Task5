package com.epam.task.five.calculator;

import com.epam.task.five.calculator.PolishCalculator;
import org.junit.Assert;
import org.junit.Test;

public class PolishCalculatorTest {
    private final String EXPRESSION ="[10 15 + 4 * 25 /]";
    private final double EXPECTED =4.0;
    private final double EPSILON = 0.01;;
    @Test
    public void testCalculate(){
        PolishCalculator polishCalculator=new PolishCalculator();
        double actual=polishCalculator.calculate(EXPRESSION);
        Assert.assertEquals(actual, EXPECTED,EPSILON);
    }
}
