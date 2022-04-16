package baseball.model;

import java.util.List;

public class Result {
    private Strike strike;
    private Ball ball;

    public Result() {
    }

    public void createResult(List<Integer> userNumbers, List<Integer> computerNumbers){
        for(int i=0; i<userNumbers.size(); i++){
            this.strike.computeCount(userNumbers.get(i), computerNumbers.get(i));
        }

        if(strike.getCount() == 3){
            return;
        }

        ball.computeCount(userNumbers, computerNumbers);
    }

    public Strike getStrike() {
        return this.strike;
    }

    public Ball getBall() {
        return this.ball;
    }

    public Boolean isNothing(){
        if(!this.strike.isStrikeExisted() && !this.ball.isBallExisted()){
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

}
