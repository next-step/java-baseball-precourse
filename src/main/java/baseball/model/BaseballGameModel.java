package baseball.model;

import java.util.List;

public class BaseballGameModel {
    private final BaseballGameCorrectData correctData;
    InningResultData result;

    public BaseballGameModel(List<Integer> correctNumberList) {
        this.correctData = new BaseballGameCorrectData(correctNumberList);
        result = new InningResultData();
    }

    public InningResultData playOneInning(List<Integer> answerNumberList) {
        GameDataValidator.validateNumberList(answerNumberList);

        result.initInningResult();

        for (int i = 0; i < answerNumberList.size(); i++) {
            result.setPitchingResult(
                    correctData.pitch(new PitchingInput(
                            answerNumberList.get(i),
                            i
                    ))
            );
        }

        return result;
    }

    public boolean isEndedInning() {
        return result.isEndedInning();
    }
}
