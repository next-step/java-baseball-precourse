package baseball.controller;

import baseball.domain.number.BaseballNumbers;
import baseball.domain.number.BaseballNumbersGenerator;
import baseball.domain.referee.Referee;
import baseball.view.BaseballUserInput;
import baseball.view.BaseballView;

public class BaseballController {
    private BaseballNumbersGenerator baseballNumbersGenerator;
    private BaseballUserInput baseballUserInput;
    private BaseballView baseballView;

    public BaseballController(BaseballNumbersGenerator baseballNumbersGenerator,
                              BaseballUserInput baseballUserInput,
                              BaseballView baseballView) {
        this.baseballNumbersGenerator = baseballNumbersGenerator;
        this.baseballUserInput = baseballUserInput;
        this.baseballView = baseballView;
    }

    public void play() {
        BaseballNumbers computerNumbers = BaseballNumbers.from(baseballNumbersGenerator.generate());
        Referee referee = Referee.create();

        while (referee.onPlay()) {
            BaseballNumbers userNumbers = baseballUserInput.getUserNumbers();
            referee.judge(computerNumbers, userNumbers);
            baseballView.printJudgement(referee.getHint());
        }
        continueGame();
    }

    private void continueGame() {
        baseballView.printContinue();
        boolean isContinue = baseballUserInput.getContinue();
        if (isContinue) {
            this.play();
        }
    }
}
