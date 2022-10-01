package baseball.domain;

import java.util.LinkedList;

public class Judgement {

    public int getStrikeCount(int strikeCount, LinkedList<Integer> answer, LinkedList<Integer> input, int index) {
        if (answer.contains(input.get(index)) && answer.get(index).equals(input.get(index))) {
            strikeCount++;
        }
        return strikeCount;
    }

    public int getBallCount(int ballCount, LinkedList<Integer> answer, LinkedList<Integer> input, int index) {
        if (answer.contains(input.get(index)) && !answer.get(index).equals(input.get(index))) {
            ballCount++;
        }
        return ballCount;
    }

}
