package com.epam.task.five.logic;

import com.epam.task.five.component.Component;
import com.epam.task.five.component.Composite;
import com.epam.task.five.component.leaf.Leaf;

import java.util.ArrayList;
import java.util.List;

public class TextLogic {

    public Composite sortParagraphs(Composite text) {

        List<Component> children =new ArrayList<>(text.getChildren());

        children.sort((first, second) -> {
            List<Component> firstChild = ((Composite) first).getChildren();
            List<Component> secondChild = ((Composite) second).getChildren();

            return firstChild.size() - secondChild.size();
        });

        return new Composite(children);
    }

    public Composite sortWords(Composite sentence) {

        List<Component> children = sentence.getChildren();

        List<Component> childrenToSort = new ArrayList<>(children);

        childrenToSort.sort((first, second) -> {
            String firstLexeme = ((Leaf) first).getChildren();
            String secondLexeme = ((Leaf) second).getChildren();

            return firstLexeme.length() - secondLexeme.length();
        });

        return new Composite(childrenToSort);
    }
}
