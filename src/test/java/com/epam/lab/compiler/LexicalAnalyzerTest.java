package com.epam.lab.compiler;

import com.epam.lab.exceptions.NotSupportedOperationException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.lab.compiler.OperationType.ADD;
import static org.junit.Assert.assertEquals;

public class LexicalAnalyzerTest {

    private LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();

    @Test
    public void analyze() {

        String brainfuckExpression = "-+";
        List<OperationCode> expected = Arrays.asList(new OperationCode(ADD, -1), new OperationCode(ADD, 1));

        List<OperationCode> actual = lexicalAnalyzer.analyze(brainfuckExpression);

        assertEquals(expected, actual);
    }

    @Test(expected = NotSupportedOperationException.class)
    public void analyze_CodeHasNotSupportedOperation() {

        String brainfuckExpression = "-+; ";

        List<OperationCode> actual = lexicalAnalyzer.analyze(brainfuckExpression);
    }
}