package baseball.service;

import nextstep.utils.Console;
import baseball.util.Constant;

public class Game {
    private static final Game GAME = new Game();

    private Game(){}

    public static Game getGameInstance() {
        return GAME;
    }

    // 사용자가 문제 맞추는 메소드
    public void play(String number) {
        Score score = Score.getInstance();
        do {
            // 입력 받기
            String input = getInputNumber();
            // 채점하기
            score.clearScore();
            score.checkScore(number, input);
        }
        while(getResult(score.getStrike(), score.getBall()));
    }

    // 3개다 맞을 때 false 반환
    private boolean getResult(int strike, int ball) {
        if (strike == Constant.NUMBER_SIZE) {
            System.out.println("3스트라이크");
            return false;
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return true;
        }
        if (strike > 0) System.out.printf("%d스트라이크 ", strike);
        if (ball > 0) System.out.printf("%d볼", ball);
        System.out.println();
        return true;
    }


    // 사용자 input - 숫자 입력
    private String getInputNumber() {
        System.out.print("숫자를 입력해주세요: ");

        String input = Console.readLine();
        // 예외처리

        return input;
    }

    // 사용자 input - 게임 계속할지 여부 (1이면 true 반환하여 계속 진행)
    public boolean isEndFromInput() {
        System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();
        // 예외처리 추가

        return input.charAt(0)-'0' == Constant.CONTINUE_GAME;
    }
}
