package baseball.service;

import baseball.domain.Baseball;
import baseball.domain.Result;

import static baseball.domain.Baseball.VALID_BASEBALL_LENGTH;

public class JudgeService {
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";

    public Result judge(Baseball computerNumbers, Baseball userNumbers) {
        int strike = getStrikeCount(computerNumbers, userNumbers);
        int ball = getBallCount(computerNumbers, userNumbers);

        String resultMessage = buildResultMessage(strike, ball);

        return new Result(strike, ball, resultMessage);
    }

    private String buildResultMessage(int strike, int ball) {
        String resultMessage = "";
        if (strike > 0) {
            resultMessage = strike + STRIKE;
        }

        if (ball > 0) {
            if (strike > 0) {
                resultMessage += " ";
            }
            resultMessage += ball + BALL;
        }
        return resultMessage.isEmpty() ? NOTHING : resultMessage;
    }


    private int getStrikeCount(Baseball computerNumbers, Baseball userNumbers) {
        int strike = 0;
        for (int i = 0; i < VALID_BASEBALL_LENGTH; i++) {
            if (computerNumbers.getNumber(i) == userNumbers.getNumber(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int getBallCount(Baseball computerNumbers, Baseball userNumbers) {
        int ball = 0;
        for (int i = 0; i < VALID_BASEBALL_LENGTH; i++) {
            if (computerNumbers.contains(userNumbers.getNumber(i)) && computerNumbers.getNumber(i) != userNumbers.getNumber(i)) {
                ball++;
            }
        }
        return ball;
    }
}
