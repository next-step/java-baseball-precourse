package baseball;

import java.util.List;

public class Judge {

    public int countBall(List<Integer> computer, List<Integer> player) {
        int ball = 0;
        for(int i = 0; i < player.size(); i++) {
            ball += checkBall(computer, player, i);
        }
        return ball;
    }

    private int checkBall(List<Integer> computer, List<Integer> player, int i) {
        return computer.contains(player.get(i)) && computer.get(i) !=  player.get(i) ? 1 : 0;
    }

    public int countStrike(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        for(int i = 0; i < player.size(); i++) {
            strike += checkStrike(computer, player, i);
        }
        return strike;
    }

    private int checkStrike(List<Integer> computer, List<Integer> player, int i) {
        return computer.get(i) == player.get(i) ? 1 : 0;
    }

}
