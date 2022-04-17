package com.yeojiin.baseball;

import java.util.HashMap;
import java.util.Map;

public class Computer {

    private Number computerNumbers;
    private Map<String, Integer> result;

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

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

        int strike = result.get(STRIKE);
        int ball = result.get(BALL);

        if ( strike != 0 && ball != 0 ) {
            return ball + BALL + strike + STRIKE;
        }

        if (strike != 0) {
            return strike + STRIKE;
        }

        if (ball != 0) {
            return ball + BALL;
        }

        return NOTHING;
    }

    public boolean isCorrect() {
        return result.get(STRIKE) == 3;
    }

    private void saveResult (int strike, int ball) {
        result = new HashMap<>();
        result.put(STRIKE, strike);
        result.put(BALL, ball);
    }

}
