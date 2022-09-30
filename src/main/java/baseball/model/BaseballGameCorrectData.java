package baseball.model;

import java.util.List;

public class BaseballGameCorrectData {
    private final List<Integer> numberList;

    public BaseballGameCorrectData(List<Integer> numberList) {
        GameDataValidator.validateNumberList(numberList);
        this.numberList = numberList;
    }

    public PitchingResult pitch(PitchingInput PitchingInput) {

        if (checkStrike(PitchingInput)) {
            return PitchingResult.STRIKE;
        }

        if (checkBall(PitchingInput)) {
            return PitchingResult.BALL;
        }

        return PitchingResult.NOTHING;
    }

    private boolean checkStrike(PitchingInput PitchingInput) {
        return numberList.get(
                PitchingInput.getOrder()
        ).equals(
                PitchingInput.getNumber()
        );
    }

    private boolean checkBall(PitchingInput PitchingInput) {
        return numberList.contains(
                PitchingInput.getNumber()
        ) && !numberList.get(
                PitchingInput.getOrder()
        ).equals(
                PitchingInput.getNumber()
        );
    }
}
