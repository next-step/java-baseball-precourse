package baseball.console;

import baseball.score.ScoreBoard;

public interface ConsoleInterface {
    
    ScoreBoard input();
    
    boolean isContinue();
    
    void printCount(int strikeCount, int ballCount);
    
}
