package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseBallController {

    private boolean exit = true;
    private static final String EXIT = "2";
    private static final String WINNER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";

    public void play() {
        Computer computer = new Computer();
        Player player = new Player();
        while (exit) {
            String input = InputView.inputNumber();
            player.setNumber(convertToList(input));
            int strike = computer.countStrike(player.getNumber());
            int ball = computer.countBall(strike, player.getNumber());
            System.out.println(getResultMessage(strike, ball));
            boolean isThreeStrike = is3Strike(strike);
            if (isThreeStrike && isDone(computer)) {
                break;
            }
        }
    }

    private boolean isDone(Computer computer) {
        if(isExit(InputView.inputExit())) {
            return true;
        }
        computer.generateRandomNumber();
        return false;
    }

    public List<Integer> convertToList(String input) {
        return Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public boolean isExit(String input) {
        return input.equals(EXIT);
    }

    public boolean is3Strike(int strike) {
        if(strike == 3) {
            System.out.println(WINNER_MESSAGE);
            return true;
        }
        return false;
    }

    public String getResultMessage(int strike, int ball) {
        if(strike == 0 && ball == 0) {
            return NOTHING_MESSAGE;
        }

        return getBaseBallResultMessage(strike, ball);
    }

    private String getBaseBallResultMessage(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append(BALL_MESSAGE).append(" ");
        }
        if (strike > 0) {
            sb.append(strike).append(STRIKE_MESSAGE);
        }
        return sb.toString();
    }
}
