package baseball.player;

import baseball.constants.Adjudgment;
import baseball.rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class Umpire implements Rule {

    private int ball;
    private int strike;

    public void init(){
        this.ball = 0;
        this.strike = 0;
    }

    public boolean judge(List<Integer> zones, List<Integer> balls){
        init();
        count(zones, balls);
        announce();

        if(strike == 3)
            return true;

        return false;
    }

    public void count(List<Integer> zones, List<Integer> balls){
        int match = 0;
        for(int i=0, length=zones.size(); i<length; i++){
            strike = countStrike(zones.get(i), balls.get(i));
            match = countMatch(zones, balls.get(i), match);
        }
        countBall(match);
    }

    public Integer countStrike(Integer zone, Integer ball){
        return strike(zone, ball) ? strike + 1 : strike;
    }

    public Integer countMatch(List<Integer> zones, Integer ball, Integer match){
        return ball(zones, ball) ? match + 1 : match;
    }

    public Integer countBall(Integer match){
        return ball = match - strike;
    }

    public void announce(){
        System.out.println(String.join(" ", makeAdjudgment()));
    }

    public List<String> makeAdjudgment(){
        List<String> adjudgmentText = new ArrayList<>();

        ballAdjudgment(adjudgmentText);
        strikeAdjudgment(adjudgmentText);
        nothingAdjudgment(adjudgmentText);

        return adjudgmentText;
    }

    public void ballAdjudgment(List<String> adjudgmentText){
        if(ball > 0)
            adjudgmentText.add(ball + Adjudgment.BALL.word);
    }

    public void strikeAdjudgment(List<String> adjudgmentText){
        if(strike > 0)
            adjudgmentText.add(strike + Adjudgment.STRIKE.word);
    }

    public void nothingAdjudgment(List<String> adjudgmentText){
        if(ball == 0 && strike == 0)
            adjudgmentText.add(Adjudgment.NOTHING.word);
    }
}
