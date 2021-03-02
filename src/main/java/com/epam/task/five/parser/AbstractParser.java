package com.epam.task.five.parser;

public abstract class AbstractParser implements Parser {
    private Parser successor;

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    protected Parser getSuccessor() {
        return successor;
    }
}
