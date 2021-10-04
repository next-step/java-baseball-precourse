package baseball.service;

import baseball.util.Constant;

public class Score {
    private static final Score SCORE = new Score();
    private int strike;
    private int ball;

    private Score() {
        clearScore();
    }

    public static Score getInstance() {
        return SCORE;
    }

    // 초기화
    private void clearScore() {
        this.strike = 0;
        this.ball = 0;
    }

    // 점수 확인을 위해 외부에서 접근하는 함수
    public boolean checkScore(String number, String input) {
        clearScore();
        for (int i = 0; i < Constant.NUMBER_SIZE; i++) {
            checkStrikeBall(number, input.charAt(i), i);
        }
        return getResult();
    }

    private void checkStrikeBall(String number, char c, int index) {
        // number의 해당 인덱스가 c와 같으면 스트라이크
        if (number.charAt(index) == c) {
            strike++;
            return;
        }

        // number에 c가 포함되어 있으면 ball
        if (number.indexOf(c) >= 0) {
            ball++;
        }
    }

    // 입력에 대한 결과 출력 및 경기 종료 여부 반환
    private boolean getResult() {
        if (strike == Constant.NUMBER_SIZE) {
            System.out.println("3스트라이크");
            return true;
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return false;
        }
        if (strike > 0) System.out.printf("%d스트라이크 ", strike);
        if (ball > 0) System.out.printf("%d볼", ball);
        System.out.println();
        return false;
    }
}
