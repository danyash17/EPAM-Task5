package com.epam.task.five.parser;
import com.epam.task.five.component.Component;
import com.epam.task.five.component.Composite;
import com.epam.task.five.component.leaf.Leaf;
import com.epam.task.five.component.leaf.LeafEnum;
import com.epam.task.five.parser.LexemeParser;
import com.epam.task.five.parser.Parser;
import com.epam.task.five.parser.SentenceParser;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class SentenceParserTest {
    private final String FIRST_LEXEME = "Lorem";
    private final String SECOND_LEXEME = "Ipsum";
    @Test
    public void testParse() {
        //given
        Parser lexemeParser = Mockito.mock(LexemeParser.class);
        Parser sentenceParser = new SentenceParser(lexemeParser);

        String text = FIRST_LEXEME + " " + SECOND_LEXEME;

        Component firstLexeme = new Leaf(LeafEnum.WORD, "Lorem");
        Component secondLexeme = new Leaf(LeafEnum.WORD, "Ipsum");

        Component expected = new Composite(Arrays.asList(firstLexeme, secondLexeme));

        when(lexemeParser.parse(FIRST_LEXEME)).thenReturn(firstLexeme);
        when(lexemeParser.parse(SECOND_LEXEME)).thenReturn(secondLexeme);

        //when
        Component actual = sentenceParser.parse(text);
        //then
        Assert.assertEquals(expected, actual);
    }
}