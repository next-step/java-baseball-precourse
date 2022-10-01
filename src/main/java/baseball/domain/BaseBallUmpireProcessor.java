package baseball.domain;

import java.util.List;
import java.util.Objects;

public class BaseBallUmpireProcessor {

    public BaseBallUmpire process(BaseBallNumbers computer, BaseBallNumbers user) {
        List<Integer> computerNumbers = computer.getThreeDigits();
        List<Integer> userNumbers = user.getThreeDigits();
        return getCalculatedUmpire(computerNumbers, userNumbers);
    }

    private BaseBallUmpire getCalculatedUmpire(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikesOrBalls = getStrikesOrBalls(computerNumbers, userNumbers);
        int strikes = getStrikes(computerNumbers, userNumbers);
        int balls = strikesOrBalls - strikes;
        return new BaseBallUmpire(strikes, balls);
    }

    private int getStrikes(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            strikes += getOneIfEquals(computerNumbers.get(i), userNumbers.get(i));
        }
        return strikes;
    }

    private int getStrikesOrBalls(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikeOrBall = 0;
        for (Integer computerNumber : computerNumbers) {
            strikeOrBall += getOneIfContains(computerNumber, userNumbers);
        }
        return strikeOrBall;
    }

    private int getOneIfEquals(Integer computer, Integer user) {
        return Objects.equals(computer, user) ? 1 : 0;
    }

    private int getOneIfContains(Integer computerNumber, List<Integer> userNumbers) {
        return userNumbers.contains(computerNumber) ? 1 : 0;
    }
}
