package baseball.domain;

import java.util.List;

public class Swing {

    private int strike;
    private int ball;

    public void swinged(List<Integer> randomNumbers, List<Integer> player) {
        this.strike = strike(randomNumbers, player);
        this.ball = ball(randomNumbers, player);
    }

    private int strike(List<Integer> randomNumbers, List<Integer> player) {
        int strike = 0;
        for (int i = 0; i < player.size(); i++) {
            strike += isStrike(randomNumbers, player, i);
        }
        return strike;
    }

    private int isStrike(List<Integer> randomNumbers, List<Integer> player, int i) {
        return randomNumbers.get(i).equals(player.get(i)) ? 1 : 0;
    }

    private int ball(List<Integer> randomNumbers, List<Integer> player) {
        int ball = 0;
        for (int i = 0; i < player.size(); i++) {
            ball += isBall(randomNumbers, player, i);
        }
        return ball;
    }

    private int isBall(List<Integer> randomNumbers, List<Integer> player, int i) {
        return randomNumbers.contains(player.get(i)) && !randomNumbers.get(i).equals(player.get(i)) ? 1 : 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

}
