package baseball.core.model.refree;

import java.util.HashMap;
import java.util.Map;

public class TestRefree implements Refree {

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
        }

        ball = ball - strike;
        decision = (strike == 3);

    }

    @Override
    public void makeDecision() {
        //noting
    }

    @Override
    public boolean getDecision() {
        if (strike != 0 || ball != 0) {
            StringBuilder sb = new StringBuilder();
            if(ball != 0){
                sb.append(ball).append("볼").append(" ");
            }
            if(strike != 0){
                sb.append(strike).append("스트라이크");
            }

            System.out.println(sb.toString());
            return decision;
        }

        System.out.println("낫싱");
        return decision;
    }

}
