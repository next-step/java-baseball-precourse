package baseball.domain;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.util.Lists;

public class Game {
    
    private final BaseballNumbers computerNumbers = generateBaseballNumbers();
    private final Judgment answerJudgment = new StrikeJudgment(computerNumbers, computerNumbers);

    private GameStatus gameStatus = GameStatus.IN_PROGRESS;

    public GameStatus getStatus() {
        return gameStatus;
    }

    public Hint getHint(BaseballNumbers playerNumbers) {
        Hint hint = Hint.of(computerNumbers, playerNumbers);
        checkAnswer(hint);
        return hint;
    }

    private void checkAnswer(Hint hint) {
        if (hint.contains(answerJudgment)) {
            gameStatus = GameStatus.FINISHED;
        }
    }

    private BaseballNumbers generateBaseballNumbers() {
        Set<BaseballNumber> result = new HashSet<>();

        while (!isEnoughSize(result)) {
            result.add(BaseballNumber.newRandomNumber());
        }
        
        return BaseballNumbers.of(Lists.newArrayList(result)); 
    }

    private boolean isEnoughSize(Set<BaseballNumber> baseballNumberList){
        return (baseballNumberList.size() >= BaseballNumbers.NUMBER_SIZE);
    }
}