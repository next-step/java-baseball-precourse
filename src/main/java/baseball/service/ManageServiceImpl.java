package baseball.service;


import baseball.constant.CommonConstant;
import baseball.model.Baseball;

import java.util.HashSet;
import java.util.Set;

public class ManageServiceImpl implements ManageService {
    private final SystemService systemService;

    public ManageServiceImpl(SystemService systemService) {
        this.systemService = systemService;
    }


    @Override
    public void checkPlayerNum(String playerNum) {
        checkEmpty(playerNum);
        checkLength(playerNum);
        checkType(playerNum);
        checkZeroNum(playerNum);
        checkDuplicateNum(playerNum);
    }

    @Override
    public Baseball getAnswer(String playerNum, String randomNum) {
        int strikeCnt = answerStrike(playerNum, randomNum);
        int ballCnt = answerBall(playerNum, randomNum);

        return Baseball.setGameResultBaseBall(ballCnt, strikeCnt);
    }

    @Override
    public void checkRestartGameNumber(String str) {
        if (!(str.equals(CommonConstant.AGREE_RESTART) || str.equals(CommonConstant.DISAGREE_RESTART))) {
            throw new IllegalArgumentException(CommonConstant.COMMON_INVALID_ERROR);
        }
    }


    public int answerStrike(String playerNums, String randomNums) {
        int strikeCnt = 0;
        for (int i = 0; i < playerNums.length(); i++) {
            char playerNum = playerNums.charAt(i);
            char randomNum = randomNums.charAt(i);

            strikeCnt += playerNum == randomNum ? 1 : 0;
        }
        return strikeCnt;
    }

    public int answerBall(String playerNums, String randomNums) {
        int ballCnt = 0;
        for (int i = 0; i < playerNums.length(); i++) {
            char playerNum = playerNums.charAt(i);
            char randomNum = randomNums.charAt(i);

            ballCnt += randomNums.contains(String.valueOf(playerNum)) && randomNum != playerNum ? 1 : 0;
        }

        return ballCnt;
    }


    private void checkEmpty(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException(CommonConstant.NOT_AVAILABLE_EMPTY_NUM);
        }
    }

    private void checkLength(String str) {
        if (str.length() != CommonConstant.NUMBER_LENGTH) {
            throw new IllegalArgumentException(CommonConstant.WRONG_LENGTH);
        }
    }

    private void checkType(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(CommonConstant.WRONG_TYPE);
        }
    }

    private void checkZeroNum(String str) {
        if (str.contains(CommonConstant.ZERO)) {
            throw new IllegalArgumentException(CommonConstant.COMMON_INVALID_ERROR);
        }
    }

    private void checkDuplicateNum(String str) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            uniqueNumbers.add(Integer.parseInt(String.valueOf(str.charAt(i))));
        }

        if (str.length() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(CommonConstant.NOT_AVAILABLE_DUPLICATE_NUM);
        }
    }
}
