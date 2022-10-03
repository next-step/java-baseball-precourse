package baseball.model;

import baseball.code.JudgeStatus;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BaseballGameModel {

    private Integer[] ballNumbers;
    private boolean notYetCollectAnswer = true;
    private boolean wantNewGame = true;

    public BaseballGameModel() {
        setNewGame();
        System.out.println(Arrays.deepToString(ballNumbers));
    }

    public void setNewGame(){
        this.notYetCollectAnswer = true;
        this.wantNewGame = true;
        this.ballNumbers = pickNewBallNumbers();
    }

    private Integer[] pickNewBallNumbers() {
        Set<Integer> ballNumberSet = new HashSet<>();
        while (ballNumberSet.size() < 3) {
            ballNumberSet.add(Randoms.pickNumberInRange(1, 9));
        }
        return ballNumberSet.toArray(new Integer[3]);
    }

    public JudgeModel judge(Integer[] inpuptNumbers){
        JudgeModel judgeModel = new JudgeModel(inpuptNumbers, ballNumbers);
        if(judgeModel.getJudgeStatus() == JudgeStatus.STRIKE){
            this.notYetCollectAnswer = false;
        }
        return judgeModel;
    }

    public Integer[] getBallNumbers() {
        return ballNumbers;
    }

    public boolean getNotYetCollectAnswer(){
        return notYetCollectAnswer;
    }

    public boolean getWantNewGame(){
        return wantNewGame;
    }

    public void setWantNewGame(String playersCommand, String newGameCommand) {
        if (playersCommand.equals(newGameCommand)){
            setNewGame();
            return;
        }
        wantNewGame = false;
    }
}
