package baseball.model;

import java.util.List;

public class Referee {

    private int ballCount;
    private int strikeCount;

    public void judgeInning(Computer computer, User user) {
        initBallCount();
        judgeBallCount(computer, user);
    }

    private void initBallCount() {
        ballCount = 0;
        strikeCount = 0;
    }

    private void judgeBallCount(Computer computer, User user) {
        List<Integer> userNumbers = user.getNumbers();
        List<Integer> computerNumbers = computer.getNumbers();
        for (int userNumber : userNumbers) {
            increaseBallCount(userNumber, userNumbers.indexOf(userNumber), computerNumbers);
        }
    }

    private void increaseBallCount(int userNumber, int userNumberIndex, List<Integer> computerNumbers) {
        if (computerNumbers.indexOf(userNumber) == userNumberIndex) {
            strikeCount++;
            return;
        }
        if (computerNumbers.contains(userNumber)) {
            ballCount++;
        }
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean continuesGame() {
        return strikeCount != 3;
    }
}