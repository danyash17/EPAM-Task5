package com.epam.task.five.parser;

import com.epam.task.five.component.Component;
import com.epam.task.five.component.Composite;
import com.epam.task.five.calculator.PolishCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SentenceParser extends AbstractParser {
    private final String SPLITTER = " +";
    private final String MATH = "\\[.*]";
    private final Pattern MATH_PATTERN = Pattern.compile(MATH);
    private final PolishCalculator CALCULATOR = new PolishCalculator();
    private final Logger LOGGER = LogManager.getLogger(TextParser.class);

    public SentenceParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String text) {
        LOGGER.info("Sentence parsing ");
        String[] lexemes = getLexemes(text);

        Parser successor = getSuccessor();

        List<Component> components = Arrays.stream(lexemes)
                .map(successor::parse)
                .collect(Collectors.toList());

        return new Composite(components);
    }

    private String[] getLexemes(String text) {
        StringBuilder dynamicText = new StringBuilder(text);
        Matcher matcher = MATH_PATTERN.matcher(dynamicText);
        while (matcher.find()) {
            String mathExpression = matcher.group();
            double calcValue = CALCULATOR.calculate(mathExpression);
            String calcString = Double.toString(calcValue);
            dynamicText.replace(matcher.start(), matcher.end(), calcString);
        }
        String noMathText = dynamicText.toString();
        String[] result = noMathText.split(SPLITTER);
        return result;
    }
}
