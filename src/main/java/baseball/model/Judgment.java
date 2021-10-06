package baseball.model;

import baseball.comm.Constant;
import baseball.view.BaseballGame;

public class Judgment {

    private static final Judgment JUDGMENT = new Judgment();

    private Judgment() {}

    public static Judgment getInstance() {
        return JUDGMENT;
    }

    public void judgment(String oppnentNumbers, String playerNumbers) {
        for(int i = 0; i < Constant.NUM_SIZE; i++){
            char checkChar = playerNumbers.charAt(i);
            judgmentNumbers(oppnentNumbers,checkChar, i);
        }
    }

    private void judgmentNumbers(String oppnentNumbers, char checkChar, int checkIndex) {
        if(oppnentNumbers.charAt(checkIndex) == checkChar){
            ++BaseballGame.strike;
            return;
        }


        if(oppnentNumbers.indexOf(checkChar) > -1){
            ++BaseballGame.ball;
            return;
        }

    }

}
