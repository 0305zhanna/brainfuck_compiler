package com.epam.lab.compiler;

public enum OperationType {
    SHIFT,  //сдвиг
    ADD,    //прибавление/вычитание
    ZERO,   //обнуление
    OUT,    //Вывести ячейку
    IN,     //Ввести ячейку arg раз
    WHILE,  //Начало цикла
    END     //Конец цикла
}
