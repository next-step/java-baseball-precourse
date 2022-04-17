package baseball.core.model.refree;

import java.util.HashMap;
import java.util.Map;

public class TestRefreeReository implements RefreeRepository {

    public boolean decision;
    public int strike;
    public int ball;

    private void init() {
        decision = false;
        strike = 0;
        ball = 0;
    }

    public void makeDecision(HashMap<Integer, Integer> pitchs, String hits) {
        init();
        for (Map.Entry<Integer, Integer> entry : pitchs.entrySet()) {

            if (hits.contains(Integer.toString(entry.getValue()))) {
                ball += 1;
                if (Integer.toString(entry.getValue()).charAt(0) == hits.charAt(entry.getKey())) {
                    strike++;
                }
            }

            System.out.println(Integer.toString(entry.getValue()).charAt(0) + " : " + hits.charAt(entry.getKey()));
        }

        ball = ball - strike;
        decision = (strike == 3) ? true : false;

    }

    @Override
    public boolean getDecision() {
        if (strike != 0 || ball != 0) {
            System.out.println("[" + strike + " STRIKE," + ball + " ball" + "]");
            return decision;
        }

        System.out.println("[NOTHING]");
        return decision;
    }
}
