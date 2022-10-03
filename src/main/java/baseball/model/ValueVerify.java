package baseball.model;

import baseball.messages.ConstMessage;

import java.util.Set;

public class ValueVerify {
    private int limitNumber = 0;
    private int startNumber = 0;
    private int endNumber = 0;
    private String errMessage = "";

    public ValueVerify(int limitNumber, int startNumber, int endNumber) {
        setLimitNumber(limitNumber);
        setStartNumber(startNumber);
        setEndNumber(endNumber);
        setErrMessage(String.format(ConstMessage.ERR_COMMON_MSG, getStartNumber(), getEndNumber(), getLimitNumber()));
    }

    public void verify(String stringValue, Set<Integer> setValue) {
        verifyLength(stringValue);
        verifyDigit(stringValue);
        verifyDuplication(setValue);
    }

    private void verifyLength(String stringValue) {
        if (getLimitNumber() != stringValue.length()) {
            throw new IllegalArgumentException(String.format(ConstMessage.ERR_LIMIT_MSG, getLimitNumber()) + getErrMessage());
        }
    }

    private void verifyDigit(String stringValue) {
        if (!stringValue.matches("^[" + getStartNumber() + "-" + getEndNumber() + "]+$")) {
            throw new IllegalArgumentException(ConstMessage.ERR_DIGIT_MSG + getErrMessage());
        }
    }

    private void verifyDuplication(Set<Integer> setValue) {
        if (setValue.size() < getLimitNumber()) {
            throw new IllegalArgumentException(ConstMessage.ERR_DUPLICATION_MSG + getErrMessage());
        }
    }

    public int getLimitNumber() {
        return limitNumber;
    }

    public void setLimitNumber(int limitNumber) {
        this.limitNumber = limitNumber;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    public int getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(int endNumber) {
        this.endNumber = endNumber;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
