package com.epam.task.five.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.epam.task.five.component.Component;
import com.epam.task.five.component.Composite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser extends AbstractParser {
    private final static String SPLITTER = "\n";
    private final Logger LOGGER=LogManager.getLogger(TextParser.class);
    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String text) {
        LOGGER.info("Text parsing ");
        String[] paragraphs = text.split(SPLITTER);

        Parser successor = getSuccessor();

        List<Component> components = Arrays.stream(paragraphs)
                .map(successor::parse)
                .collect(Collectors.toList());
        return new Composite(components);
    }
}
