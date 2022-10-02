package baseball.game;

import baseball.console.ConsoleInterface;
import baseball.console.GameConsole;
import baseball.score.RandomScoreGenerator;
import baseball.score.ScoreBoard;
import baseball.score.ScoreGenerator;

public class BaseballGameLauncher implements GameLauncher {
    
    private final ConsoleInterface console;
    private final ScoreGenerator scoreGenerator;
    
    public BaseballGameLauncher() {
        this.console = new GameConsole();
        this.scoreGenerator = new RandomScoreGenerator();
    }
    
    @Override
    public void play() {
        boolean isContinue = true;
        while (isContinue) {
            this.playRound();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isContinue = console.isContinue();
        }
    }
    
    public void playRound() {
        ScoreBoard initScore = this.scoreGenerator.generate();
        
        boolean roundStatus = true;
        while (roundStatus) {
            ScoreBoard input = this.console.input();
            roundStatus = this.compare(initScore, input);
        }
    }
    
    public boolean compare(ScoreBoard initScore, ScoreBoard input) {
        if (initScore.equals(input)) {
            return false;
        }
        
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < input.size(); i++) {
            int number = input.get(i);
            if (initScore.contains(number)) {
                RoundResult roundResult = initScore.getRoundResult(number, i);
                strikeCount += roundResult.getStrikeCount();
                ballCount += roundResult.getBallCount();
            }
        }
        
        this.console.printCount(strikeCount, ballCount);
        
        return strikeCount != 3;
    }
}
