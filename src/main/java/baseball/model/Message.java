package baseball.model;

import baseball.constant.CommonConstant;

public class Message {
    private StringBuilder message;

    public Message(Baseball baseball) {
        message = new StringBuilder();
        appendBallResult(baseball);
        appendSpace(baseball);
        appendStrikeResult(baseball);
        appendNothing(baseball);
    }

    private void appendBallResult(Baseball baseball) {
        if (baseball.getBallCnt() > 0) {
            String ballResult = baseball.getBallCnt() + CommonConstant.BALL;
            message.append(ballResult);
        }
    }

    private void appendStrikeResult(Baseball baseball) {
        if (baseball.getStrikeCnt() > 0) {
            String strikeResult = baseball.getStrikeCnt() + CommonConstant.STRIKE;
            message.append(strikeResult);
        }
    }

    private void appendSpace(Baseball baseball) {
        if (baseball.getBallCnt() > 0 && baseball.getStrikeCnt() > 0) {
            message.append(CommonConstant.SPACE);
        }
    }

    private void appendNothing(Baseball baseball) {
        if (baseball.isNothing()) {
            message.append(CommonConstant.NOTHING);
        }
    }

    public String getResultMeesage() {
        return message.toString();
    }
}
