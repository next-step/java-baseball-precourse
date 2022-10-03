package baseball.model;

import baseball.messages.ConstMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ValueCall {
    private int strikeCount = 0;
    private int ballCount = 0;
    private final List<String> callMessage;

    public ValueCall() {
        callMessage = new ArrayList<>();
    }

    public void strikeCall(Set<Integer> answerValue, String questionValue) {
        int index = 0;
        for (Integer integer : answerValue) {
            checkStrike(index++, String.valueOf(integer), questionValue);
        }

        setStrike();
    }

    private void checkStrike(int index, String answerValue, String questionValue) {
        if (index == questionValue.indexOf(answerValue)) {
            setStrikeCount(getStrikeCount() + 1);
        }
    }

    private void setStrike() {
        if (getStrikeCount() > 0) {
            getCallMessage().add(String.format(ConstMessage.STRIKE_MSG, getStrikeCount()));
        }
    }

    public void ballCall(Set<Integer> answerValue, String questionValue) {
        int index = 0;
        for (Integer integer : answerValue) {
            checkBall(index++, String.valueOf(integer), questionValue);
        }

        setBall();
    }

    private void checkBall(int index, String answerValue, String questionValue) {
        int questionIndex = questionValue.indexOf(answerValue);
        if (questionIndex > -1 && index != questionIndex) {
            setBallCount(getBallCount() + 1);
        }
    }

    private void setBall() {
        if (getBallCount() > 0) {
            getCallMessage().add(0, String.format(ConstMessage.BALL_MSG, getBallCount()));
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public List<String> getCallMessage() {
        return callMessage;
    }
}
