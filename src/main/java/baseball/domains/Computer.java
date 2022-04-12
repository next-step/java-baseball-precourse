package baseball.domains;

import baseball.constants.GameOption;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer extends Character {
    @Override
    public void play() {
        final StringBuilder aimPositionsBuilder = new StringBuilder();
        for (int index = 0; index < GameOption.INPUT_LENGTH; index++) {
            aimPositionsBuilder.append(generateDeduplicatedRandomNumber(aimPositionsBuilder));
        }
        decideAimPositions(aimPositionsBuilder.toString());
    }

    private String generateDeduplicatedRandomNumber(StringBuilder stringBuilder) {
        String randomNumericString = Randoms.pickNumberInRange(1, 9) + "";
        while (stringBuilder.indexOf(randomNumericString) > -1) {
            randomNumericString = Randoms.pickNumberInRange(1, 9) + "";
        }
        return randomNumericString;
    }
}
