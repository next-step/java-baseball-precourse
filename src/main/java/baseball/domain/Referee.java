package baseball.domain;

import java.util.List;

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

}
