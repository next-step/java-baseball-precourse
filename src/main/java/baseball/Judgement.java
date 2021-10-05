package baseball;

import java.util.List;

public class Judgement {
    private int strikeCnt = 0;
    private int ballCnt = 0;

    Judgement(List<Integer> comNums, List<Integer> playerNums) {
        for (int i=0; i < GameRule.MAX_LENGTH; i++) {
            checkBall(i, playerNums.get(i), comNums);
            checkStrike(comNums.get(i), playerNums.get(i));
        }
    }

    public boolean judge() {
        return (strikeCnt == GameRule.MAX_LENGTH);
    }

    public String printJudgeResult() {
        String result = "";
        result += printStrikeCnt() + printBallCnt();
        if (result.length() == 0) {
            return OutputView.NOTHING;
        }
        return result;
    }

    private String printStrikeCnt() {
        String resultStr = "";
        if (strikeCnt > 0) {
            resultStr += strikeCnt + OutputView.STRIKE + " ";
        }

        return resultStr;
    }

    private String printBallCnt() {
        String resultStr = "";
        if (ballCnt > 0) {
            resultStr += ballCnt + OutputView.BALL;
        }
        return resultStr;
    }

    private void checkStrike(Integer computerNum, Integer playerNum) {
        if (computerNum.intValue() == playerNum.intValue()) {
            strikeCnt++;
        }
    }

    private void checkBall(int computerNumIndex, Integer playerNum, List<Integer> computerNums) {
        if ((computerNums.get(computerNumIndex).intValue() != playerNum.intValue()) && computerNums.contains(playerNum)) {
            ballCnt++;
        }


    }

}
