package com.epam.lab.compiler;

import com.epam.lab.exceptions.NotSupportedOperationException;

import java.util.ArrayList;
import java.util.List;

import static com.epam.lab.compiler.OperationType.*;

public class LexicalAnalyzer {

    public List<OperationCode> analyze(String brainfuckCode) {

        List<OperationCode> tokens = new ArrayList<>();
        int i = 0;
        while (i < brainfuckCode.length()) {
            switch (brainfuckCode.charAt(i++)) {
                case '>':
                    tokens.add(new OperationCode(SHIFT, 1));
                    break;
                case '<':
                    tokens.add(new OperationCode(SHIFT, -1));
                    break;
                case '+':
                    tokens.add(new OperationCode(ADD, 1));
                    break;
                case '-':
                    tokens.add(new OperationCode(ADD, -1));
                    break;
                case '.':
                    tokens.add(new OperationCode(OUT, 1));
                    break;
                case ',':
                    tokens.add(new OperationCode(IN, 1));
                    break;
                case '[':
                    char next = brainfuckCode.charAt(i);
                    if ((next == '+' || next == '-') && brainfuckCode.charAt(i + 1) == ']') {
                        tokens.add(new OperationCode(ZERO, 1));
                        i += 2;
                    } else
                        tokens.add(new OperationCode(WHILE, 1));
                    break;
                case ']':
                    tokens.add(new OperationCode(END, 1));
                    break;
                default:
                    throw new NotSupportedOperationException("Not supported operation was found!");
            }
        }
        return tokens;
    }
}
