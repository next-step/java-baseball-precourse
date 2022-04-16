package baseball.model;

import java.util.List;

public class Trial {
    private final List<Integer> trial;

    public Trial(List<Integer> trial) {
        if (trial.size() != 3)
            throw new IllegalArgumentException("Trial numbers should be three");
        if (trial.get(0).equals(trial.get(1)) ||
                trial.get(0).equals(trial.get(2)) ||
                trial.get(1).equals(trial.get(2)))
            throw new IllegalArgumentException("Trial numbers are different.");
        this.trial = trial;
    }

    int get(int idx) {
        if (idx < 0 || idx > 2)
            throw new IllegalArgumentException("Range should be 0~2.");
        return trial.get(idx);
    }
}
