package com.yeojiin.baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Player {
    private Number numbers;

    public void inputNumbers() {
        String inputNumbers = Console.readLine();
        numbers = Number.generatePlayerNumbers(inputNumbers);
    }

    public Number getNumbers() {
        return numbers;
    }
}
