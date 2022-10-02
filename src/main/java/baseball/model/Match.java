package baseball.model;

import static baseball.utils.Constants.CONTINUE_FLAG;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private Player inputPlayer;
    private Player guessPlayer;
    private String continueFlag;

    public Match(Player inputPlayer, Player guessPlayer) {
        this.setPlayers(inputPlayer, guessPlayer);
        this.continueFlag = CONTINUE_FLAG;
    }

    public void setContinueFlag(String continueFlag) {
        this.continueFlag = continueFlag;
    }

    public String getContinueFlag() {
        return this.continueFlag;
    }

    private void setPlayers(Player inputPlayer, Player guessPlayer) {
        this.inputPlayer = inputPlayer;
        this.guessPlayer = guessPlayer;
    }

    public void setInputPlayerNumber(List<Integer> numbers) {
        this.inputPlayer.setNumbers(numbers);
    }

    public int getPlayerBallCount() {
        int ballCount = 0;

        for(int i=0; i<this.inputPlayer.getNumbers().size(); i++) {
            ballCount += guessBall(this.guessPlayer.getNumbers(), i, this.inputPlayer.getNumbers().get(i));
        }

        return ballCount;
    }

    public int getPlayerStrikeCount() {
        int strikeCount = 0;

        for(int i=0; i<this.inputPlayer.getNumbers().size(); i++) {
            strikeCount += guessStrike(this.guessPlayer.getNumbers(), i, this.inputPlayer.getNumbers().get(i));
        }

        return strikeCount;
    }

    private int guessStrike(List<Integer> targetNumbers, int index, int guessNum) {
        if(targetNumbers.contains(guessNum)
        && targetNumbers.get(index).equals(guessNum)) {
            return 1;
        }

        return 0;
    }

    private int guessBall(List<Integer> targetNumbers,int index, int guessNum) {
        if(targetNumbers.contains(guessNum)
        && !targetNumbers.get(index).equals(guessNum)) {
            return 1;
        }

        return 0;
    }
}
