package com.epam.task.five.parser;

import com.epam.task.five.component.Component;
import com.epam.task.five.component.leaf.Leaf;
import com.epam.task.five.component.leaf.LeafEnum;

public class LexemeParser implements Parser {

    private static final String CALCULATED_MATH_REGEX = "\\d+\\.\\d+";

    @Override
    public Component parse(String text) {
        if (text.matches(CALCULATED_MATH_REGEX)) {
            return new Leaf(LeafEnum.MATH, text);
        }
        return new Leaf(LeafEnum.WORD, text);
    }
}
