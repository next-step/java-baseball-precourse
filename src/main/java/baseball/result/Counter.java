package baseball.result;

import baseball.constants.Condition;
import baseball.constants.Regex;
import baseball.input.bean.Player;
import baseball.result.bean.Computer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Counter {

    private List<Integer> playerNumbers;
    private List<Integer> computerNumbers;
    public Counter(Player player, Computer computer) {
        this.playerNumbers = new ArrayList<Integer>(player.getNumbers());
        this.computerNumbers = new ArrayList<Integer>(computer.getNumbers());
    }

    public int containsDigitNumberCount() {
        int containsCount = 0;
        for (int input: playerNumbers) {
            if(computerNumbers.contains(input)) {
                containsCount++;
            }
        }
        return containsCount;
    }

    public int equalDigitNumberCount() {
        int equalDigitNumberCount = 0;
        for (int index = 0; index < Condition.DIGIT_LENGTH; index++) {
            if(playerNumbers.get(index) == computerNumbers.get(index)) {
                equalDigitNumberCount++;
            }
        }
        return equalDigitNumberCount;
    }
}