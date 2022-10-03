package baseball.game;

import baseball.member.Computer;
import baseball.member.User;

import java.util.ArrayList;
import java.util.List;

public class Score {

    private static final int ZERO = 0;
    private static final int LEN_NUMBERS = 3;
    private static final String EMPTY = "";
    private static final String BLANK = " ";
    private static final String STRIKE = "스트라이크" + BLANK;
    private static final String BALL = "볼" + BLANK;
    private static final String NOTHING = "낫싱";

    private static final List<Integer> strikes = new ArrayList<>();
    private static final List<Integer> balls = new ArrayList<>();

    public void clearScore() {
        strikes.clear();
        balls.clear();
    }

    public void judgeScore(Computer computer, User user) {
        clearScore();
        judgeStrike(computer, user);
        judgeBall(computer, user);
    }

    private void judgeStrike(Computer computer, User user) {
        for(int index = ZERO; index < LEN_NUMBERS; index++) {
            addStrikeOrBall(index, computer.getNumber(index), user.getNumber(index));
        }
    }

    private void addStrikeOrBall(int index, Integer comNum, Integer userNum) {
        if(isStrike(comNum, userNum)) {
            strikes.add(index);
            return;
        }
        balls.add(index);
    }

    private boolean isStrike(Integer comNum, Integer userNum) {
        return comNum.equals(userNum);
    }

    private void judgeBall(Computer computer, User user) {
        List<Integer> removeBalls = new ArrayList<>();
        for (Integer ball : balls) {
            removeBall(removeBalls, ball, computer, user);
        }
        balls.removeAll(removeBalls);
    }

    private void removeBall(List<Integer> removeBalls, Integer ball, Computer computer, User user) {
        if(!computer.containsNum(user.getNumber(ball))) {
            removeBalls.add(ball);
        }
    }

    public int getBall() { return balls.size(); }

    public int getStrike() {
        return strikes.size();
    }

    public void printScore() {
        String output = EMPTY;
        output += balls.size() > ZERO ? balls.size() + BALL : EMPTY;
        output += strikes.size() > ZERO ? strikes.size() + STRIKE : EMPTY;
        output += balls.size() + strikes.size() == ZERO ? NOTHING : EMPTY;
        System.out.println(output);
    }
}