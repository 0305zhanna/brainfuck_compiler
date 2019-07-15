package com.epam.lab.interpreter;

import com.epam.lab.exceptions.NotSupportedOperationException;
import lombok.Setter;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.logging.Level;

@Log
public class BrainFuckInterpreter {
    @Setter
    private int cellCount = 3000;
    private int pointer = 0;
    private byte[] memory = new byte[cellCount];

    public String interpret(String code) throws IOException {
        int c = 0;
        String result = "";
        for (int i = 0; i < code.length(); i++) {
            switch (code.charAt(i)) {
                case '>': {
                    pointer = (pointer == cellCount - 1) ? 0 : pointer + 1;
                    break;
                }
                case '<': {
                    pointer = (pointer == 0) ? cellCount - 1 : pointer - 1;
                    break;
                }
                case '+': {
                    memory[pointer]++;
                    break;
                }
                case '-': {
                    memory[pointer]--;
                    break;
                }
                case '.': {
                    result += (char) memory[pointer];
                    System.out.print((char) (memory[pointer]));
                    break;
                }
                case ',': {
                    memory[pointer] = (byte) (System.in.read());
                    break;
                }
                case '[': {
                    if (memory[pointer] == 0) {
                        i++;
                        while (c > 0 || code.charAt(i) != ']') {
                            if (code.charAt(i) == '[') c++;
                            if (code.charAt(i) == ']') c--;
                            i++;
                        }
                    }
                    break;
                }
                case ']': {
                    if (memory[pointer] != 0) {
                        i--;
                        while (c > 0 || code.charAt(i) != '[') {
                            if (code.charAt(i) == ']') c++;
                            if (code.charAt(i) == '[') c--;
                            i--;
                        }
                        i--;
                    }
                    break;
                }
                default:
                    log.log(Level.ALL, "Not supported operation was found");
                    throw new NotSupportedOperationException("Not supported operation");
            }
        }
        return result;
    }
}
