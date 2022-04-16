package com.yeojiin.baseball;

import java.util.HashMap;
import java.util.Map;

public class Computer {

    private Number computerNumbers;
    private Map<String, Integer> result;

    public void generate() {
        computerNumbers = Number.generateRandomNumbers();
    }

    public void calculateResultCount(Number playerNumbers) {

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if ( computerNumbers.isStrike(playerNumbers.getNumByIdx(i), i) ) {
                strike++;
                continue;
            }

            if ( computerNumbers.isBall(playerNumbers.getNumByIdx(i)) ) {
                ball++;
            }
        }

        saveResult(strike,ball);
    }

    public String printResult() {

        int strike = result.get("STRIKE");
        int ball = result.get("BALL");

        if ( strike != 0 && ball != 0 ) {
            return "볼:  " + ball + "스트라이크: " + strike;
        }

        if (strike != 0) {
            return "스트라이크: " + strike;
        }

        if (ball != 0) {
            return "볼: " + ball;
        }

        return "Fail";
    }

    public boolean isCorrect() {
        return result.get("STRIKE") == 3;
    }

    private void saveResult (int strike, int ball) {
        result = new HashMap<>();
        result.put("STRIKE", strike);
        result.put("BALL", ball);
    }

}
