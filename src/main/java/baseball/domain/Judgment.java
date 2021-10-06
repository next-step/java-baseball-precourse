package baseball.domain;

import java.util.List;

public class Judgment {

    public BaseBall compareNumber(List<Integer> computer, List<Integer> player) {
        int ball = this.containNumberCount(computer, player);
        int strike = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (this.samePlace(computer, i, player.get(i))) {
                strike++;
            }
        }
        return new BaseBall(strike, ball - strike);
    }

    private int containNumberCount(List<Integer> computer, List<Integer> player) {
        int result = 0;
        for (int i = 0; i < player.size(); i++) {
            result += containNumber(computer, player.get(i));
        }
        return result;
    }

    private boolean samePlace(List<Integer> computer, int location, int number) {
        return computer.get(location) == number;
    }

    private int containNumber(List<Integer> computer, int playerNumber) {
        if (computer.contains(playerNumber)) {
            return 1;
        }
        return 0;
    }
}
