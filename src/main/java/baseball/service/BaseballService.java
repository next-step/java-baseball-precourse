package baseball.service;

import static java.lang.System.*;

import baseball.model.PlayBase;
import baseball.model.UserAnswerRequest;
import baseball.model.PlayResult;
import baseball.model.UserPlayRequest;

public class BaseballService {
    private final PlayBase base;

    public BaseballService(PlayBase base) {
        this.base = base;
    }

    /**
     * The main logic of the baseball game, After receiving the user's answer, checking the answer and matching with a
     * random number, the matching result is returned.
     *
     * @param request the user's answer
     * @return play result
     * @throws IllegalArgumentException when there is a problem with the user's answer.
     */
    public PlayResult play(UserAnswerRequest request) throws IllegalArgumentException {
        if (!request.isValidNumber()) {
            throw new IllegalArgumentException();
        }
        base.clearCounts();
        matchCount(Integer.parseInt(request.getAnswer()));
        out.println(base.getCounts());
        return PlayResult.valueOf(base.getCounts(), base.getMatchResult());
    }

    /**
     * After the baseball game is over, the response of the user is checked whether the user proceeds with an additional
     * game.
     *
     * @param request the response of the user
     * @return check result
     */
    public boolean playAgain(UserPlayRequest request) {
        if (request.isValidNumber()) {
            base.initializeInning();
            return true;
        }
        return false;
    }

    /**
     * Matches the user's number with a random number and counts balls and strikes.
     *
     * @param userNumber the user's number
     */
    private void matchCount(int userNumber) {
        int count = 10;
        int temp = userNumber;
        for (int i = 2; i >= 0; i--) {
            if (!(checkStrike(temp % count, i))) {
                checkBall(temp % count, i);
            }
            temp /= count;
        }
    }

    /**
     * Checks whether the user's number with a certain number of digits matches the random number.
     *
     * @param userNumber the user's number with a certain number of digits
     * @param digit      digits
     * @return check result
     */
    private boolean checkStrike(int userNumber, int digit) {
        int fakeNumber = base.getNumberArr()[digit];
        if (userNumber == fakeNumber) {
            base.addStrikeCounts();
            return true;
        }
        return false;
    }

    /**
     * Check if a certain digit of the user's number is included in the random number and increment the ball count.
     *
     * @param userNumber the user's number with a certain number of digits
     * @param digit      digits
     */
    private void checkBall(int userNumber, int digit) {
        for (int i = 2; i >= 0; i--) {
            if (base.getNumberArr()[i] == userNumber && i != digit) {
                base.addBallCounts();
            }
        }
    }

}
