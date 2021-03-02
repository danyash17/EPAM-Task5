package com.epam.task.five.logic;

import com.epam.task.five.component.Component;
import com.epam.task.five.component.Composite;
import com.epam.task.five.component.leaf.Leaf;
import com.epam.task.five.component.leaf.LeafEnum;
import com.epam.task.five.logic.TextLogic;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class TextLogicTest {

    private final TextLogic LOGIC = new TextLogic();
    private final Component FIRST_PARAGRAPH = new Composite(
            Arrays.asList(
                    new Composite(
                            Collections.singletonList(
                                    new Leaf(LeafEnum.WORD, "Ipsum")
                            )
                    ),
                    new Composite(
                            Arrays.asList(
                                    new Leaf(LeafEnum.WORD, "L"),
                                    new Leaf(LeafEnum.WORD, "Lorem")
                            )
                    )

            )
    );
    private final Component SECOND_PARAGRAPH = new Composite(
            Collections.singletonList(
                    new Composite(
                            Arrays.asList(
                                    new Leaf(LeafEnum.WORD, "Lipsum"),
                                    new Leaf(LeafEnum.WORD, "[2+3]")
                            )
                    )
            )
    );
    private final Component FIRST_LEXEME = new Leaf(LeafEnum.WORD, "Looooorem");
    private final Component SECOND_LEXEME = new Leaf(LeafEnum.WORD, "Lorem");

    @Test
    public void testSortWords() {
        //given

        Composite expected = new Composite(Arrays.asList(SECOND_LEXEME, FIRST_LEXEME));

        Composite unsortedLexemes = new Composite(Arrays.asList(FIRST_LEXEME, SECOND_LEXEME));

        //when
        Composite actual = LOGIC.sortWords(unsortedLexemes);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testSortParagraphs() {
        //given
        Composite expected = new Composite(Arrays.asList(SECOND_PARAGRAPH, FIRST_PARAGRAPH));

        Composite paragraphsToSort = new Composite(Arrays.asList(FIRST_PARAGRAPH, SECOND_PARAGRAPH));

        //when
        Composite actual = LOGIC.sortParagraphs(paragraphsToSort);
        //then
        Assert.assertEquals(expected, actual);
    }

}
