package baseball.domain;

import java.util.List;
import java.util.Objects;

public class Referee {

    public int correctCount(List<Integer> comNumbers, List<Integer> playerNumbers) {
        int count = 0;
        for(Integer playerNum : playerNumbers) {
            if(comNumbers.contains(playerNum)) {
                count++;
            };
        }
        return count;
    }

    public int getStrike(List<Integer> comNumbers, List<Integer> playerNumbers) {
        int count = 0;
        for(int i=0; i<3; i++) {
            if(Objects.equals(comNumbers.get(i), playerNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }
}
