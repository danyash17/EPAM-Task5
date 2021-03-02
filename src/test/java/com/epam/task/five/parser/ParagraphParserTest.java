package com.epam.task.five.parser;

import com.epam.task.five.component.Component;
import com.epam.task.five.component.Composite;
import com.epam.task.five.component.leaf.Leaf;
import com.epam.task.five.component.leaf.LeafEnum;
import com.epam.task.five.parser.ParagraphParser;
import com.epam.task.five.parser.SentenceParser;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.when;

public class ParagraphParserTest {
    private final String FIRST_SENTENCE = "Lorem Ipsum";
    private final String SECOND_SENTENCE = "Nullam lacus";
    private final String TEXT = FIRST_SENTENCE + "." + SECOND_SENTENCE+".";
    @Test
    public void testParse() throws IOException {
        //given
        SentenceParser sentenceParser= Mockito.mock(SentenceParser.class);
        ParagraphParser paragraphParser=new ParagraphParser(sentenceParser);
        Composite firstSentence=new Composite(
                Arrays.asList(
                        new Leaf(LeafEnum.WORD,"Lorem"),
                        new Leaf(LeafEnum.WORD,"Ipsum")
                        ));

        Composite secondSentence=new Composite(
                Arrays.asList(
                        new Leaf(LeafEnum.WORD,"Nullam"),
                        new Leaf(LeafEnum.WORD,"lacus")
                ));

        Component expected = new Composite(Arrays.asList(firstSentence, secondSentence));

        when(sentenceParser.parse(FIRST_SENTENCE)).thenReturn(firstSentence);
        when(sentenceParser.parse(SECOND_SENTENCE)).thenReturn(secondSentence);

        //when
        Component actual = paragraphParser.parse(TEXT);

        //then
        Assert.assertEquals(expected, actual);
    }
}
