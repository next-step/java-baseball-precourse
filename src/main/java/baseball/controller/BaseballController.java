package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.domain.CompareResult;
import baseball.view.CompareResultShowView;
import baseball.view.InputView;

public class BaseballController {

    private final CompareResultShowView compareResultShowView;
    private final InputView inputView;

    public BaseballController(CompareResultShowView compareResultShowView, InputView inputView) {
        this.compareResultShowView = compareResultShowView;
        this.inputView = inputView;
    }

    public void play() {
        boolean isSuccess = false;
        BaseballNumber answer = BaseballNumber.generate();
        do {
            BaseballNumber inputNumber = inputView.inputAnswer();
            CompareResult compareResult = answer.compare(inputNumber);
            compareResultShowView.show(compareResult);
            isSuccess = compareResult.isSuccess();
        } while (!isSuccess);
    }
}
