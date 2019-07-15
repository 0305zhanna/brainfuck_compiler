package com.epam.lab.compiler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OperationCode {

    private OperationType operationType;
    private Integer arg;
}
