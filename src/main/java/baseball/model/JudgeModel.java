package baseball.model;

import baseball.code.JudgeStatus;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JudgeModel {

    private final Integer[] inputNumbers;
    private final Integer[] ballNumbers;
    private JudgeStatus judgeStatus;

    private int strikeCount = 0;
    private int ballCount = 0;

    public JudgeModel(Integer[] inpuptNumbers, Integer[] ballNumbers) {
        this.inputNumbers = inpuptNumbers;
        this.ballNumbers = ballNumbers;
        judge();
    }

    private void judge(){
        isAllStrike();
        if(judgeStatus == JudgeStatus.STRIKE){
            return;
        }
        checkStrike();
        checkBall();
        checkNothing();
    }

    private void isAllStrike(){
        if(Arrays.deepEquals(inputNumbers, ballNumbers)){
            this.strikeCount = 3;
            this.judgeStatus = JudgeStatus.STRIKE;
        }
    }

    private void checkStrike(){
        for(int i = 0; i < inputNumbers.length; i++){
            addStrikeCount(inputNumbers[i], ballNumbers[i]);
        }
    }

    private void addStrikeCount(int input, int ball){
        if(input == ball){
            strikeCount += 1;
        }
    }

    private void checkBall(){
        Set<Integer> ballSet = new HashSet<>(Arrays.asList(ballNumbers));
        ballSet.addAll(Arrays.asList(inputNumbers));
        ballCount = ballNumbers.length + inputNumbers.length - ballSet.size() - strikeCount;

        if(ballCount > 0){
            this.judgeStatus = JudgeStatus.BALL;
        }
    }

    private void checkNothing(){
        if(strikeCount == 0 && ballCount == 0){
            this.judgeStatus = JudgeStatus.NOTHING;
        }
    }

    public JudgeStatus getJudgeStatus() {
        return judgeStatus;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
