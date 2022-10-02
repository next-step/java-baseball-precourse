package baseball.score;

import baseball.game.RoundResult;

import java.util.List;

public class ScoreBoard {
    private final List<Integer> score;
    
    public ScoreBoard(List<Integer> score) {
        if (score.size() != 3) {
            throw new IllegalArgumentException("잘못 입력된 배열입니다.");
        }
        this.score = score;
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
}
