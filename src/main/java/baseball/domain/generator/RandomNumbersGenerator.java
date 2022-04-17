package baseball.domain.generator;

import baseball.domain.game.GameRule;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RandomNumbersGenerator implements Generator {
    GameRule gameRule;

    public RandomNumbersGenerator(GameRule gameRule) {
        this.gameRule = gameRule;
    }

    @Override
    public List<Integer> generateNumbers() {
        return getUniqueNumberList();
    }

    private List<Integer> getUniqueNumberList() {
        HashSet<Integer> checkNumbers = new HashSet<>();
        while (checkNumbers.size() < gameRule.SIZE) {
            checkNumbers.add(Randoms.pickNumberInRange(gameRule.MIN_NUM, gameRule.MAX_NUM));
        }
        return new ArrayList<>(checkNumbers);
    }
}
