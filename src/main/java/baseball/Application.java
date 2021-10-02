package baseball;

import baseball.service.GameMachine;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        GameMachine machine = new GameMachine();
        machine.runningBaseBallGame();
    }
}
