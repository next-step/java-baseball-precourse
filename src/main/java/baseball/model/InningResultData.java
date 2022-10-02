package baseball.model;

import java.util.HashMap;
import java.util.Map;

public class InningResultData {
    private final Map<String, Integer> scoreBoard = new HashMap<>();

    public InningResultData() {
        initInningResult();
    }

    public void initInningResult() {
        scoreBoard.put("STRIKE", 0);
        scoreBoard.put("BALL", 0);
    }

    public int getStrike() {
        return scoreBoard.get(PitchingResult.STRIKE.name());
    }

    public int getBall() {
        return scoreBoard.get(PitchingResult.BALL.name());

    }

    public boolean isNothing() {
        return getBall() == 0 && getStrike() == 0;
    }

    public void setPitchingResult(PitchingResult pitchingResult) {
        checkPitchingCount();

        if (pitchingResult != PitchingResult.NOTHING) {
            scoreBoard.put(
                    pitchingResult.name(),
                    scoreBoard.get(pitchingResult.name()) + 1
            );
        }
    }

    public boolean isEndedInning() {
        return getStrike() == BaseballGameRule.PITCHING_COUNT;
    }

    private void checkPitchingCount() {
        if (getBall() + getStrike() >= BaseballGameRule.PITCHING_COUNT) {
            throw new IllegalStateException();
        }
    }
}

