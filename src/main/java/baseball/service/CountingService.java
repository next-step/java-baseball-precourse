package baseball.service;

import baseball.domain.Counting;
import baseball.vo.GameResultVO;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CountingService {
    public List<Integer> answerNumList;
    public List<Integer> inputNumList;
    public int answerNum;

    private Counting counting;
    private GameResultVO gameResultVO;

    public CountingService() {
        this.answerNumList = new ArrayList<>();
        this.inputNumList = new ArrayList<>();
        this.answerNum = 0;

        this.counting = new Counting();
        this.gameResultVO = new GameResultVO();
    }

    public Boolean setCountingParams(Boolean newGame, String userInput) {
        if (newGame) {
            clearAnswerNumList();
            makeAnswerNumList();
            answerNumListToInt();
        }
        clearInputNumList();
        makeInputNumList(userInput);
        return false;
    }

    public Boolean isCorrectAnswer(String userInput) {
        return counting.isCorrectAnswer(userInput, answerNum);
    }

    public GameResultVO countingStart(String userInput) {
        counting.clearCnt();
        gameResultVO.setStrikeCnt(counting.strikeCounting(answerNumList, inputNumList));
        gameResultVO.setBallCnt(counting.ballCounting(answerNumList, inputNumList));
        return gameResultVO;
    }

    public void makeAnswerNumList() {
        int resultRandom;
        while(answerNumList.size() < 3) {
            resultRandom = Randoms.pickNumberInRange(1, 9);
            addAnswerNumList(resultRandom);
        }
    }

    public void addAnswerNumList(Integer resultRandom) {
        if(!answerNumList.contains(resultRandom)) {
            answerNumList.add(resultRandom);
        }
    }

    public void makeInputNumList(String inputVal) {
        for(int i = 0; i < 3; i++) {
            inputNumList.add(Integer.parseInt(inputVal.split("")[i]));
        }
    }

    public void answerNumListToInt() {
        clearInputNum();
        for (int i = answerNumList.size() - 1; i >= 0; i--) {
            answerNum += answerNumList.get(2 - i) * Math.pow(10 , i);
        }
    }

    public void clearAnswerNumList() {
        this.answerNumList = new ArrayList<>();
    }

    public void clearInputNumList() {
        this.inputNumList = new ArrayList<>();
    }

    public void clearInputNum() {
        this.answerNum = 0;
    }
}
