package baseball.controller;

import baseball.domain.*;
import baseball.service.GameNumberGeneratorService;
import baseball.view.Input;

public class BaseballGameController implements GameController {

    public static final int MAX_NUMBER = 3;
    private final GameNumberGeneratorService gameNumberGeneratorService;

    public BaseballGameController(GameNumberGeneratorService gameNumberGeneratorService) {
        this.gameNumberGeneratorService = gameNumberGeneratorService;
    }

    @Override
    public void process(GameCommand status) {
        AnswerNumbers answerNumbers = AnswerNumbers.from(gameNumberGeneratorService.process());
        boolean isSuccess = false;

        while (!isSuccess) {
            UserInputNumbers inputNumbers = getUserInputNumbers();
            AtBatResult atBatResult = calculateResult(answerNumbers, inputNumbers);
            System.out.println(atBatResult);
            isSuccess = atBatResult.isSuccess();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝!");
    }

    private UserInputNumbers getUserInputNumbers() {
        return Input.numbers();
    }

    private AtBatResult calculateResult(AnswerNumbers answers, UserInputNumbers userNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < MAX_NUMBER; i++) {
            AtBat result = answers.calculateAtBat(userNumbers.getGameNumbers().get(i), i);
            if (result == AtBat.STRIKE) {
                strike += 1;
            }
            if (result == AtBat.BALL) {
                ball += 1;
            }
        }
        return AtBatResult.of(strike, ball);
    }
}
