package domain;

import java.util.List;

public class EvaluatedResult {
    private Result result = new Result();

    public EvaluatedResult(GeneratedNumbers generatedNumbers, InputNumbers inputNumbers){
        this.result = getEvaluation(generatedNumbers, inputNumbers);
    }

    public Result getEvaluation(GeneratedNumbers generatedNumbers, InputNumbers inputNumbers) {
        int strike = 0, ball = 0;
        int currentIndex = 0;
        List<Integer> inputNumbersList = inputNumbers.getNumbers();
        for(int number : inputNumbersList) {
            if(isStrike(number, currentIndex, generatedNumbers)){
                strike++;
                currentIndex++;
                continue;
            }
            if(isBall(number, generatedNumbers)) ball++;
            currentIndex++;
        }
        result.setStrike(strike);
        result.setBall(ball);
        return result;
    }

    private boolean isStrike(int number, int currentIndex, GeneratedNumbers generatedNumbers) {
        return currentIndex == generatedNumbers.getIndex(number);
    }
    private boolean isBall(int number, GeneratedNumbers generatedNumbers) {
        return generatedNumbers.find(number);
    }

    public Result getResult() {
        return result;
    }
}
