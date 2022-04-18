package baseball.core.model.refree;

import java.util.HashMap;

public interface Refree {

    boolean getDecision();

    void makeDecision();

    void makeDecision(HashMap<Integer, Integer> pitchs, String hits);
}
