package com.epam.task.five.parser;

import com.epam.task.five.component.Component;
import com.epam.task.five.component.Composite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphParser extends AbstractParser {
    private final static String SPLITTER = "((\\.{3})|\\.|!|\\?)";
    private final Logger LOGGER= LogManager.getLogger(TextParser.class);
    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String text) {
        LOGGER.info("Paragraph parsing ");
        String[] sentences = text.split(SPLITTER);

        Parser successor = getSuccessor();

        List<Component> components = Arrays.stream(sentences)
                .map(successor::parse)
                .collect(Collectors.toList());

        return new Composite(components);
    }
}
