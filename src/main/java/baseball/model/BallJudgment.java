package baseball.model;

import java.util.HashSet;

public class BallJudgment {
    int ballSize = 3;

    public int countStrike(String[] computerBallString, String[] playerBallString) {
        int count = 0;

        for (int i = 0; i < ballSize; i++) {
            int ballResult = getStringEquals(computerBallString[i], playerBallString[i]);
            count += ballResult;
        }

        return count;
    }

    public int countBall(String[] computerBallNumber, String[] playerBallNumber) {
        HashSet<Integer> set = strikeNumberRemovedSet(computerBallNumber, playerBallNumber);
        int count = 0;

        for (int i = 0; i < ballSize; i++) {
            boolean ballResult = set.contains(Integer.parseInt(playerBallNumber[i]));
            count += boolToInt(ballResult);
        }

        return count;
    }

    public String[] convertIntToStringArray(int ballNumber) {
        String ballNumberString = Integer.toString(ballNumber);
        return ballNumberString.split("");
    }

    private int getStringEquals(String s, String s1) {
        if (s.equals(s1)) {
            return 1;
        }
        return 0;
    }

    private int boolToInt(Boolean b) {
        if (b) {
            return 1;
        }
        return 0;
    }


    private HashSet<Integer> strikeNumberRemovedSet(String[] computerBallNumber, String[] playerBallNumber) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < ballSize; i++) {
            int notStrikeComputerNumber = getNotStrikeComputerNumber(computerBallNumber[i], playerBallNumber[i]);
            set.add(notStrikeComputerNumber);
        }

        return set;
    }

    private int getNotStrikeComputerNumber(String computerBallNumber, String playerBallNumber) {
        if (!computerBallNumber.equals(playerBallNumber)) {
            return Integer.parseInt(computerBallNumber);
        }
        return 0;
    }
}
