package com.epam.lab.compiler;

import java.util.EnumMap;
import java.util.List;
import java.util.Stack;
import java.util.function.BiConsumer;

import static com.epam.lab.compiler.OperationType.ZERO;

public class Optimizer {

    private EnumMap<OperationType, BiConsumer<Stack<OperationCode>, OperationCode>> optimizationMatrix;

    public Optimizer() {
        optimizationMatrix = new EnumMap<>(OperationType.class);

        optimizationMatrix.put(ZERO, (Stack<OperationCode> tokens, OperationCode token) -> {

            if (tokens.isEmpty()) {
                tokens.push(token);
                return;
            }

            if (tokens.peek().getOperationType() != token.getOperationType()) {
                if (tokens.peek().getArg() == 0)
                    tokens.pop();

                if (tokens.peek().getOperationType() == ZERO)
                    tokens.peek().setArg(1);

                tokens.push(token);
                return;
            }

            OperationCode currentOperation = tokens.peek();
            currentOperation.setArg(currentOperation.getArg() + token.getArg());
        });
    }

    public List<OperationCode> optimize(List<OperationCode> tokens) {

        Stack<OperationCode> result = new Stack<>();

        for (OperationCode opCode : tokens) {
            optimizationMatrix.get(opCode.getOperationType()).accept(result, opCode);
        }

        return result;
    }
}
