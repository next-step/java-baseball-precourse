package baseball.game;

public class RoundResult {
    private int strikeCount = 0;
    private int ballCount = 1;
    
    
    public void strike() {
        this.strikeCount = 1;
        this.ballCount = 0;
    }
    
    
    public int getStrikeCount() {
        return this.strikeCount;
    }
    
    public int getBallCount() {
        return this.ballCount;
    }
    
    
}
