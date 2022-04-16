package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int NUMBER_SIZE = 3;
    List<Integer> number = new ArrayList<>();

    public Computer() {
        generateRandomNumber();
    }

    public Computer(List<Integer> number) {
        this.number = number;
    }

    public void generateRandomNumber() {
        number.clear();
        Set<Integer> randomSet = new LinkedHashSet<>();
        while (randomSet.size() < NUMBER_SIZE) {
            randomSet.add(Randoms.pickNumberInRange(START_RANGE, END_RANGE));
        }
        number = new ArrayList<>(randomSet);
    }

    public List<Integer> getNumber() {
        return number;
    }

    public int countStrike(List<Integer> input) {
        int strike = 0;

        for(int i=0; i<NUMBER_SIZE; i++) {
            Integer computerNumber = number.get(i);
            Integer playerNumber = input.get(i);
            if(computerNumber.equals(playerNumber)) {
                strike++;
            }
        }

        return strike;
    }

    public int countBall(int strikeCount, List<Integer> input) {
        int ball = 0;

        for (Integer playerNumber : input) {
            if(number.contains(playerNumber)) {
                ball++;
            }
        }

        return ball-strikeCount;
    }
}
