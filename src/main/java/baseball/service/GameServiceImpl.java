package baseball.service;

import baseball.domain.GameConfig;
import baseball.domain.PickNumberMatchResultView;
import baseball.exception.NotMatchPickNumberSizeException;

import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static baseball.domain.PickNumbers.getPickNumbersSet;

public class GameServiceImpl implements GameService {

    @Override
    public PickNumberMatchResultView comparePickNumber(String readPickNumber) {
        String[] ballNumberArr = readPickNumber.split("");
        PickNumberMatchResultView pickNumberMatchResultView = getPickNumberMatchResult(ballNumberArr);

        return pickNumberMatchResultView;
    }

    private PickNumberMatchResultView getPickNumberMatchResult(String[] ballNumberArr) {
        LinkedHashSet<Integer> set = getPickNumbersSet();
        PickNumberMatchResultView pickNumberMatchResultView = matchResultCounter(set, ballNumberArr);

        return pickNumberMatchResultView;
    }

    private PickNumberMatchResultView matchResultCounter(LinkedHashSet<Integer> set, String[] ballNumberArr) {
        int idx = 0;
        PickNumberMatchResultView pickNumberMatchResult = new PickNumberMatchResultView();
        for (int computerPickNumber : set) {
            int ballNumber = Integer.parseInt(ballNumberArr[idx]);
            pickNumberMatchResult = addCount(pickNumberMatchResult, set, computerPickNumber, ballNumber);
            idx++;
        }
        return pickNumberMatchResult;
    }

    private PickNumberMatchResultView addCount(PickNumberMatchResultView pickNumberMatchResult, LinkedHashSet<Integer> set, int computerPickNumber, int ballNumber) {
        if (computerPickNumber == ballNumber) {
            pickNumberMatchResult.addStrikeCount();
        } else if (set.contains(ballNumber)) {
            pickNumberMatchResult.addBallCount();
        }
        return pickNumberMatchResult;
    }

    @Override
    public boolean isValidReadPickNumber(String readPickNumber) {
        if (isValidOnlyNumber(readPickNumber) && isValidPickNumberSize(readPickNumber)) {
            return true;
        }
        return false;
    }

    private boolean isValidOnlyNumber(String readPickNumber) {
        Pattern pattern = Pattern.compile("^[1-9]*$");
        Matcher matcher = pattern.matcher(readPickNumber);
        boolean isFind = matcher.find();
        if (!isFind) {
            printErrorMessage();
            return false;
        }
        return true;
    }

    private boolean isValidPickNumberSize(String readPickNumber) {
        try {
            if (readPickNumber.split("").length != GameConfig.PICK_NUMBER_SIZE.getValue()) {
                throw new NotMatchPickNumberSizeException("입력한 값의 사이즈가 일치하지 않습니다");
            }
        } catch (NotMatchPickNumberSizeException e) {
            printErrorMessage();
            return false;
        }
        return true;
    }

    private void printErrorMessage() {
        System.out.printf("[ERROR] : %d~%d까지의 %d자리 숫자를 입력해주세요 %n"
                , GameConfig.MIN_NUMBER.getValue()
                , GameConfig.MAX_NUMBER.getValue()
                , GameConfig.PICK_NUMBER_SIZE.getValue());
    }

}
