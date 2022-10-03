package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class StrikeBalls extends Baseball {

    ArrayList<Integer> strikeBalls;

    public StrikeBalls() {
        strikeBalls = new ArrayList<>();
        setStrikeBalls();
    }

    private void setStrikeBalls() {
        while (strikeBalls.size() < NUM_BALL_LEN) {
            int num = Randoms.pickNumberInRange(MIN_BALL_VAL, MAX_BALL_VAL);
            addIfNotExists(num);
        }
    }

    private void addIfNotExists(int num) {
        if (!strikeBalls.contains(num)) {
            strikeBalls.add(num);
        }
    }

    public int getStrikeBall(int index) {
        return strikeBalls.get(index);
    }

    public boolean contains (int num) {
        if (strikeBalls.contains(num)) {
            return true;
        }
        return false;
    }

}
