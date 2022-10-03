package baseball.domain;

import baseball.utils.io.IOUtils;

import java.util.List;

// 볼, 스트라이크, 낫싱 판단 로직은 여기서 처리한다.
public class Rule {
    private int strike = 0;
    private int ball = 0;

    public void initScore(){
        this.strike = 0;
        this.ball = 0;
    }
    public void checkStrikeCount(List<Integer> source, List<Integer> target){
        initScore();
        target.forEach(
                value  ->  matchingScore(value, target.indexOf(value), source)
        );
    }

    public void matchingScore(Integer value, int index, List<Integer> source) {
        if(!matchingStrike(value, index, source)) {
            matchingBall(value, source);
        }
    }

    public boolean matchingBall(Integer value, List<Integer> source) {
        if(source.contains(value)){
            this.ball++;
            return true;
        }
        return false;
    }

    public boolean matchingStrike(Integer value, int index, List<Integer> source) {
        if(value.equals(source.get(index))){
            this.strike++;
            return true;
        }
        return false;
    }

    public void printResult(){
        String delimiter = " ";
        String totalResult = getResult(ball, "볼") + delimiter + getResult(strike, "스트라이크");

        if(delimiter.length() == totalResult.length()){
            totalResult = "낫싱";
        }

        IOUtils.println(totalResult.trim());
    }

    public String getResult(int count, String base){
        if(count == 0){
            return "";
        }
        return count + base;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
