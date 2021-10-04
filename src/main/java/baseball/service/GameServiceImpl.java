package baseball.service;

import baseball.domain.PickNumberMatchResultView;

import java.util.LinkedHashSet;

import static baseball.domain.PickNumbers.getPickNumbersSet;

public class GameServiceImpl implements GameService {

    @Override
    public PickNumberMatchResultView compareBallNumber(String readPickNumber) {
        String[] ballNumberArr = readPickNumber.split("");
        PickNumberMatchResultView pickNumberMatchResult = new PickNumberMatchResultView();

        int idx = 0;
        LinkedHashSet<Integer> set = getPickNumbersSet();

        for (int computerPickNumber : set) {
            int ballNumber = Integer.parseInt(ballNumberArr[idx]);

            if (computerPickNumber == ballNumber) {
                pickNumberMatchResult.addStrikeCount();
            } else if (set.contains(ballNumber)) {
                pickNumberMatchResult.addBallCount();
            }
            idx++;
        }

        return pickNumberMatchResult;
    }
}
