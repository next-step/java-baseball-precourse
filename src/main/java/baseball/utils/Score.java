/*
 * Score.java
 * java-baseball-precourse
 *
 * Version 0.1
 *
 * Created by 강래민 on 01/10/2021.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */

package baseball.utils;

import baseball.commons.Constant;
import baseball.exception.IncorrectInputException;

public class Score {
    private Integer strike;
    private Integer ball;

    public Score(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    /**
     * strike 증가 로직
     *
     * @throws IncorrectInputException 제한된 스트라이크의 개수를 초과한 경우 발생한다.
     */
    public void addStrike() {
        if (Constant.GAME_PITCHING_COUNT <= getStrike() || Constant.GAME_PITCHING_COUNT <= getStrike() + getBall()) {
            throw new IncorrectInputException("strike 범위를 초과하였습니다.");
        }
        this.strike++;
    }

    /**
     * ball 증가 로직
     *
     * @throws IncorrectInputException 제한된 볼의 개수를 초과한 경우 발생한다.
     */
    public void addBall() {
        if (Constant.GAME_PITCHING_COUNT <= getBall() || Constant.GAME_PITCHING_COUNT <= getStrike() + getBall()) {
            throw new IncorrectInputException("ball 범위를 초과하였습니다.");
        }
        this.ball++;
    }

    @Override
    public String toString() {
        String print = "";
        if (getStrike() > 0) {
            print += getStrike() + "스트라이크";
        }
        if (getBall() > 0) {
            print += " " + getBall() + "볼";
        }
        return print.trim();
    }

    /**
     * Strike, Ball 판독 점수 계산 로직
     *
     * @param pitcherNumber 생성된 상대방(컴퓨터) 난수
     * @param inputNumber   사용자 입력
     */
    public void scoreCalculation(String pitcherNumber, String inputNumber) {
        for (int i = 0; i < Constant.GAME_PITCHING_COUNT; i++) {
            if (pitcherNumber.charAt(i) == inputNumber.charAt(i)) {
                addStrike();
            }
            if (pitcherNumber.charAt(i) != inputNumber.charAt(i) && pitcherNumber.indexOf(inputNumber.charAt(i)) != -1) {
                addBall();
            }
        }
    }

    /**
     * 낫싱(0스트라이크 0볼) 판단 로직
     *
     * @return 낫싱 여부 반환
     */
    public Boolean isNothing() {
        if (getStrike() == 0 && getBall() == 0) {
            System.out.println("낫싱");
            return true;
        }
        return false;
    }

    /**
     * 라운드 종료(3스트라이크) 판단 로직
     *
     * @return 라운드 종료 여부 반환
     */
    public Boolean isThreeStrike() {
        if (getStrike() == Constant.GAME_PITCHING_COUNT) {
            System.out.println(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 끝", Constant.GAME_PITCHING_COUNT));
            return true;
        }
        return false;
    }
}
