package baseball.game;

import baseball.score.BaseBallScore;
import baseball.score.Score;
import baseball.ball.Baseball;

public class BaseballPlay implements Play {
    private final Baseball computer;
    private final Baseball person;
    private final BaseBallScore score;

    BaseballPlay(Baseball computer, Baseball person, BaseBallScore score) {
        this.computer = computer;
        this.person = person;
        this.score = score;
    }

    @Override
    public void start() {
        String computerBall = computer.getBall();
        String personBall = person.getBall();
        Score score = getScore(computerBall,personBall);
        score.toString();
    }

    public Score getScore(String integer, String integer2){
        if(integer == integer2) {
            score.addStrike();
        }
        return score;
    }

    public Score getScore(){
        return score;
    }

    @Override
    public void stop() {

    }
}
