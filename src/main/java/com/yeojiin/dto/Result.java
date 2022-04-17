package com.yeojiin.dto;

public class Result {

    private static final int ANSWER_COUNT = 3;

    private final int strike;
    private final int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isAnswer() {
        return strike == ANSWER_COUNT;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

}
