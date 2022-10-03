package baseball.score;

import baseball.game.RoundResult;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ScoreBoard {
    private final List<Integer> score;
    
    public ScoreBoard(int a, int b, int c) {
        this.score = Arrays.asList(a, b, c);
    }
    
    public int size() {
        return this.score.size();
    }
    
    public boolean contains(int number) {
        return this.score.contains(number);
    }
    
    public int get(int index) {
        return this.score.get(index);
    }
    
    public boolean isStrike(int number, int index) {
        return this.score.get(index).equals(number);
    }
    
    public RoundResult getRoundResult(int number, int index) {
        RoundResult roundResult = new RoundResult();
        if (this.isStrike(number, index)) {
            roundResult.strike();
        }
        
        return roundResult;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreBoard that = (ScoreBoard) o;
        return score.equals(that.score);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
