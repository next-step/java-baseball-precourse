package baseball.game;

import baseball.game.ui.Joystick;
import baseball.game.ui.Screen;

public class BaseballGame {

    private static final String CONTINUE_GAME = "1";

    private Baseball baseball;

    private Screen screen;

    private Joystick joystick;

    private boolean availableGame;

    public void doGame() {
        initGame();        
        while (availableGame) {
            startBaseballGame();
        }
    }
    private void initGame() {
        this.baseball = new Baseball();
        this.screen = new Screen();
        this.joystick = new Joystick();
        this.availableGame = true;
        // 목표 숫자 생성
        baseball.generateGoalNumbers();
    }

    private void startBaseballGame() {
        // 사용자 숫자 입력
        String userInput = doUserInputProcess();

        // 숫자 검증
        baseball.validateInputNumbers(userInput);

        // 결과 판독
        baseball.judgeResult(userInput);

        // 결과 출력
        screen.printGameResultMessage(baseball.getResult());
        
        baseball.clearResult();

        // 게임 종료 여부 체크
        if (baseball.isGameOver()) {
            doGameOverProcess();
        }
    }

    private String doUserInputProcess() {
        screen.printInputNumberMessage();
        return joystick.inputNumbers();
    }

    private void doGameOverProcess() {
        screen.printGameOverMessage();
        availableGame = CONTINUE_GAME.equals(joystick.inputNumbers());
        if (availableGame) {
            initGame();
        }
    }

}
