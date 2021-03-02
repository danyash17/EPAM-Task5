package com.epam.task.five.chain;

import com.epam.task.five.parser.*;

public class ChainBuilder {
    public AbstractParser build() {
        return new TextParser(
                new ParagraphParser(
                        new SentenceParser(
                                new LexemeParser()
                        )
                )
        );
    }
}
