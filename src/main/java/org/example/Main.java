package org.example;

import org.example.controller.NumberBaseballController;
import org.example.model.NumberBaseball;

public class Main {
    public static void main(String[] args) {
        NumberBaseball numberBaseball = new NumberBaseball();
        NumberBaseballController numberBaseballController = new NumberBaseballController(numberBaseball);
        numberBaseballController.play();
    }
}