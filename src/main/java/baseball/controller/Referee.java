package baseball.controller;

import baseball.messages.ConstMessage;
import baseball.model.ValueCall;
import baseball.model.ValueVerify;
import baseball.view.MatchOutput;
import baseball.view.ProgressInput;

public class Referee implements Rule {
    private final Pitcher pitcher;
    private final ProgressInput progressInput;

    public Referee() {
        pitcher= new Pitcher();
        progressInput= new ProgressInput();
    }

    public boolean playBall() {
        pitcher.generateRandomValue();
        return inPlay();
    }

    private boolean inPlay() {
        Hitter hitter = new Hitter();
        hitter.swing();

        ValueVerify valueVerify = new ValueVerify(LIMIT_NUMBER, START_NUMBER, END_NUMBER);
        valueVerify.verify(pitcher.getInputValue(), pitcher.getQuestionValue());
        valueVerify.verify(hitter.getInputValue(), hitter.getAnswerValue());

        ValueCall valueCall = new ValueCall();
        valueCall.strikeCall(hitter.getAnswerValue(), pitcher.getInputValue());
        if (valueCall.getStrikeCount() != LIMIT_NUMBER) {
            valueCall.ballCall(hitter.getAnswerValue(), pitcher.getInputValue());
        }

        return matchResult(valueCall);
    }

    private boolean matchResult(ValueCall valueCall) {
        boolean restart = false;

        String resultMsg = ConstMessage.NO_HIT_MSG;
        if (valueCall.getBallCount() > 0 || valueCall.getStrikeCount() > 0) {
            resultMsg = String.join(" ", valueCall.getCallMessage());
        }
        MatchOutput.matchResultOutput(resultMsg);

        if (valueCall.getStrikeCount() != LIMIT_NUMBER) {
            restart = inPlay();
        }

        if (valueCall.getStrikeCount() == LIMIT_NUMBER) {
            restart = strikeOut();
        }

        return restart;
    }

    private boolean strikeOut() {
        return RESTART_CODE.equals(progressInput.gameProgressInputValue(LIMIT_NUMBER, RESTART_CODE));
    }
}
