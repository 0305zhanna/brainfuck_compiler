package com.epam.lab.interpreter;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class BrainFuckInterpreterTest {

    BrainFuckInterpreter brainFuckInterpreter;
    InputStream inputStream;

    @Before
    public void setUp() throws Exception {
        brainFuckInterpreter = new BrainFuckInterpreter();
    }

    @Test
    public void interpret() {
        String code = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
        String expected = "Hello World!";
        String actual = brainFuckInterpreter.interpret(code);
        assertTrue(expected.equals(actual));
    }
}