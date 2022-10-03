package baseball;

import java.util.List;
import java.util.Objects;

public class BallAndStrike {
    public static Answer check(List<Integer> answer, List<Integer> input) {
        Answer score = new Answer(0,0);
        int strike  = countStrike(answer,input);
        int ball    = countBall(answer,input);
        score.setStrike(strike);
        score.setBall(ball-strike);
        return score;
    }

    private static int countStrike(List<Integer> answer, List<Integer> input) {
        int strike = 0;
        for(int i =0; i<answer.size();i++){
            if(Objects.equals(answer.get(i), input.get(i))){
                strike++;
            }
        }
        return strike;
    }

    private static int countBall(List<Integer> answer, List<Integer> input) {
        int ball = 0;
        for(int no : input){
            if(answer.contains(no)){
                ball++;
            }
        }
        return ball;
    }


    public static String printScore(Answer answer) {
        StringBuffer printValue = new StringBuffer();

        if(answer.getBall()==0 && answer.getStrike()==0){
            printValue.append("낫싱");
        }
        if(answer.getBall()>0){
            printValue.append(answer.getBall()+"볼 ");
        }
        if(answer.getStrike()>0){
            printValue.append(answer.getStrike()+"스트라이크");
        }
        return printValue.toString();
    }
}
