package baseball.domain;

import baseball.view.Command;

import java.util.List;
import java.util.Objects;

public class Referee {

    public Count atBat(List<Integer> comNumbers, List<Integer> playerNumbers) {
        int strike = getStrike(comNumbers, playerNumbers);
        int ball = correctCount(comNumbers, playerNumbers) - strike;
        return new Count(ball, strike);
    }

    private int correctCount(List<Integer> comNumbers, List<Integer> playerNumbers) {
        int count = 0;
        for(Integer playerNum : playerNumbers) {
            if(comNumbers.contains(playerNum)) {
                count++;
            };
        }
        return count;
    }

    private int getStrike(List<Integer> comNumbers, List<Integer> playerNumbers) {
        int count = 0;
        for(int i=0; i<3; i++) {
            if(Objects.equals(comNumbers.get(i), playerNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean isStruckOut(int strike) {
        boolean result = false;
        if(strike == 3) {
            result = true;
        }
        return result;
    }

    public void callCount(Command command, int strike, int ball){
        if(strike == 0 && ball == 0) {
            command.printNoting();
        }
        if(strike != 0) {
            command.getStrikeMessage(strike);
        }
        if(ball != 0) {
            command.getBallMessage(ball);
        }
        command.println();
    }
}
