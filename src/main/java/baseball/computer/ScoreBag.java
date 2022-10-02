package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ScoreBag {

    private final List<Score> scores;

    private final int MIN = 1;
    private final int MAX = 9;
    private final int MAX_SIZE = 3;

    public ScoreBag() {
        scores = new ArrayList<>();
        List<Integer> randomScores = makeDefaultScores();
        for (int i = 0; i < MAX_SIZE; i++) {
            this.scores.add(new Score(randomScores.get(i), i));
        }
    }

    private List<Integer> makeDefaultScores() {
        List<Integer> initScores = new ArrayList<>();
        while (initScores.size() < 3) {
            containsOrAdd(initScores);
        }
        return initScores;
    }

    private void containsOrAdd(List<Integer> initScores) {
        int randomScore = Randoms.pickNumberInRange(MIN, MAX);
        if (!initScores.contains(randomScore)) {
            initScores.add(randomScore);
        }
    }

    public ScoreBag(List<Score> scores) {
        this.scores = scores;
    }

    public List<Score> getScores() {
        return this.scores;
    }

    public static ScoreBag makeScoreBag(int[] inputs) {
        List<Score> scores = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            scores.add(new Score(inputs[i], i));
        }
        return new ScoreBag(scores);
    }
}
