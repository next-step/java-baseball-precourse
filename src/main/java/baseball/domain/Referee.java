package baseball.domain;

import baseball.view.Command;

import java.util.List;
import java.util.Objects;

public class Referee {

    public void atBat(List<Integer> comNumbers, List<Integer> playerNumbers, Count count) {
        strikeCheck(comNumbers, playerNumbers, count);
        ballCheck(comNumbers, playerNumbers, count);
    }

    private void ballCheck(List<Integer> comNumbers, List<Integer> playerNumbers, Count count) {
        for(Integer playerNum : playerNumbers) {
            containNumber(comNumbers, playerNum, count);
        }
        count.setBallCount();
    }

    private void containNumber(List<Integer> comNumbers, Integer playerNum, Count count) {
        if(comNumbers.contains(playerNum)) {
            count.ballPlus();
        }
    }

    private void strikeCheck(List<Integer> comNumbers, List<Integer> playerNumbers, Count count) {
        for(int i=0; i<3; i++) {
            plusStrike(comNumbers.get(i), playerNumbers.get(i), count);
        }
    }

    private void plusStrike(Integer comNum, Integer playerNum, Count count) {
        if(Objects.equals(comNum, playerNum)) {
            count.strikePlus();
        }
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
