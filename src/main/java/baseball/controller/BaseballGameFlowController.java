package baseball.controller;

import baseball.model.AnswerNumbers;
import baseball.model.CheckResult;
import baseball.model.ComputerPlayer;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameFlowController {

    private ComputerPlayer computerPlayer;
    private boolean isFinished;

    public BaseballGameFlowController() {
        this.isFinished = false;
    }

    public void start() {
        computerPlayer = new ComputerPlayer(new AnswerNumbers());
        askAndCheckResult();
    }

    private void askAndCheckResult() {
        CheckResult checkResult = computerPlayer.checkAnswer(InputView.askAnswer());

        OutputView.printResult(checkResult);

        if(checkResult.getStrike() == 3){
            OutputView.printEndingMessage();
            return;
        }

        askAndCheckResult();
    }


    public void checkRestart(){
        String answer = InputView.askRegame();
        boolean isValid = validateAskRegameAnswer(answer);
        if(!isValid){
            InputView.askRegameErrorMessage();
            checkRestart();
            return;
        }
        isFinished = answer.equals("2")? true:false;
    }

    private boolean validateAskRegameAnswer(String answer){
        return answer.equals("1") || answer.equals("2")? true : false;
    }


    public boolean isFinished() {
        return isFinished;
    }
}
