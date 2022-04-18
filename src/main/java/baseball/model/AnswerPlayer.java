package baseball.model;

import baseball.common.Constants;

public class AnswerPlayer extends GameNumbers {

    public void thinkGoodAnswerGameNumbers(AnswerRandomNumberGenerator answerRandomNumberGenerator) {
        this.setGameNumbers(answerRandomNumberGenerator.generateAnswerRandomNumbers());
    }

    public ResponseHint thinkAnswerRoundHintOrResult(RequestHint requestHint) {
        ResponseHint responseHint = new ResponseHint();
        int ballCount = this.countingBall(requestHint);
        int strikeCount = this.countingStrike(requestHint);
        responseHint.setBall(ballCount - strikeCount);
        responseHint.setStrike(strikeCount);
        if (strikeCount == Constants.INQUIRE_PLAYER_WIN_STRIKE_VALUE) {
            responseHint.setGameEndFlag(true);
        }
        return responseHint;
    }

    public int countingBall(RequestHint requestHint) {
        int ballCount = 0;
        String answerGameNumbers = this.getGameNumbers();
        String inquireGameNumbers = requestHint.getGameNumbers();

        for (int i = 0; i < inquireGameNumbers.length(); i++) {
            ballCount += addIfBall(answerGameNumbers, inquireGameNumbers.charAt(i));
        }

        return ballCount;
    }

    public int addIfBall(String answerGameNumbers, char inquireGameNumber) {
        if (answerGameNumbers.contains(Character.toString(inquireGameNumber))) {
            return 1;
        }

        return 0;
    }

    public int countingStrike(RequestHint requestHint) {
        int strikeCount = 0;
        String answerGameNumbers = this.getGameNumbers();
        String inquireGameNumbers = requestHint.getGameNumbers();

        for (char inquireGameNumber : inquireGameNumbers.toCharArray()) {
            strikeCount += addIfStrike(answerGameNumbers, inquireGameNumbers, inquireGameNumber);
        }

        return strikeCount;
    }

    public int addIfStrike(String answerGameNumbers, String inquireGameNumbers, char inquireGameNumber) {
        if (answerGameNumbers.indexOf(inquireGameNumber) == inquireGameNumbers.indexOf(inquireGameNumber)) {
            return 1;
        }

        return 0;
    }
}
