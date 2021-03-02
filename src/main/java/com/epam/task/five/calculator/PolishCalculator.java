package com.epam.task.five.calculator;

import java.util.Stack;

public class PolishCalculator implements Calculator {
    private final int ZERO_ASCII=48;
    private final int NINE_ASCII=57;
    public double calculate(String input)
    {
        double result = 0;
        Stack<Double> stack = new Stack<Double>();
        int length=input.length();
        for (int i = 0; i < length; i++)
        {
            if (isDigit(input.charAt(i)))
            {
                StringBuilder nonTerminal = new StringBuilder();

                while (!isOperator(input.charAt(i))&&input.charAt(i)!=' ')
                {
                    nonTerminal.append(input.charAt(i));
                    i++;
                    if (i == length) break;
                }
                String stringResult=String.valueOf(nonTerminal);
                stack.push(Double.parseDouble(stringResult));
                i--;
            }
            else if (isOperator(input.charAt(i)))
            {
                double first = stack.pop();
                double second = stack.pop();

                switch (input.charAt(i))
                {
                    case '+': result = second + first; break;
                    case '-': result = second - first; break;
                    case '*': result = second * first; break;
                    case '/': result = second / first; break;
                }
                stack.push(result);
            }
        }
        return stack.peek();
    }
    private boolean isOperator(char сharacter)
    {
        return сharacter=='+'||сharacter=='-'||сharacter=='*'||сharacter=='/';
    }
    private boolean isDigit(char сharacter)
    {
        return сharacter>=ZERO_ASCII&&сharacter<=NINE_ASCII;
    }

}
