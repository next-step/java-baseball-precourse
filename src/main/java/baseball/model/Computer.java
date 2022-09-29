package baseball.model;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Computer {

    private List<Integer> baseballNumber;
    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    private Set<Integer> generateBaseballNumber(){
        Set<Integer> digitSet = new LinkedHashSet<>();

        while (digitSet.size() < 3) {
            digitSet.add(getRandomNumber());
        }

        return digitSet;
    }

    public void initBaseballNumber() {
        baseballNumber = new ArrayList<>(generateBaseballNumber());
    }

    public void calculateScore(List<Integer> answer) {
        strike = 0;
        ball = 0;

        for (int i = 0; i < 3; i++) {
            int currentAnswer = answer.get(i);

            if (!baseballNumber.contains((currentAnswer))) continue;
            if (currentAnswer == baseballNumber.get(i)) {
                strike++;
                continue;
            }
            ball++;
        }
    }

    public boolean isWrong() {
        return strike != 3;
    }

}
