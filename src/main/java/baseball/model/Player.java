package baseball.model;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    Ball ball;
    int ballNumber;

    public Player(Ball ball) {
        this.ball = ball;
    }

    public int input() {
        String readLine = Console.readLine();
        try {
            return Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 정수여야합니다. 입력값 : " + readLine);
        }
    }

    public void validateInputBallNumber(int inputNumber) {
        if (!ball.validateBallNumber(inputNumber)) {
            throw new IllegalArgumentException("자릿수마다 중복되지않는 세자리정수를 입력해주세요 입력값 : " + ballNumber);
        }
        ballNumber = inputNumber;
    }

    public int getBallNumber() {
        return ballNumber;
    }
}