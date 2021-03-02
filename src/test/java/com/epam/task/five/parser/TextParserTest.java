package com.epam.task.five.parser;

import com.epam.task.five.component.Component;
import com.epam.task.five.component.Composite;
import com.epam.task.five.component.leaf.Leaf;
import com.epam.task.five.component.leaf.LeafEnum;
import com.epam.task.five.parser.ParagraphParser;
import com.epam.task.five.parser.TextParser;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.when;
public class TextParserTest {
    private final String FIRST_PARAGRAPH = "Lorem Ipsum";
    private final String SECOND_PARAGRAPH = "Nullam lacus";
    private final String TEXT = FIRST_PARAGRAPH + "\n" + SECOND_PARAGRAPH;
    @Test
    public void testParse() throws IOException {
        //given
        ParagraphParser paragraphParser= Mockito.mock(ParagraphParser.class);
        TextParser textParser = new TextParser(paragraphParser);
        Component firstParagraph = new Composite(
                Arrays.asList(
                        new Composite(
                                Arrays.asList(
                                        new Leaf(LeafEnum.WORD, "Lorem"),
                                        new Leaf(LeafEnum.WORD, "Ipsum")
                                )
                        )
                )
        );

        Component secondParagraph = new Composite(
                Arrays.asList(
                        new Composite(
                                Arrays.asList(
                                        new Leaf(LeafEnum.WORD, "Nullam"),
                                        new Leaf(LeafEnum.WORD, "lacus")
                                )
                        )
                )
        );

        Component expected = new Composite(Arrays.asList(firstParagraph, secondParagraph));

        when(paragraphParser.parse(FIRST_PARAGRAPH)).thenReturn(firstParagraph);
        when(paragraphParser.parse(SECOND_PARAGRAPH)).thenReturn(secondParagraph);

        //when
        Component actual = textParser.parse(TEXT);

        //then
        Assert.assertEquals(expected, actual);
    }
}
