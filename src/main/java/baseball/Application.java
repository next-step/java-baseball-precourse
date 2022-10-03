package baseball;

import baseball.controller.Referee;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Referee referee = new Referee();
        while (referee.playBall());
    }
}
