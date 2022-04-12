package baseball.domains;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;

public class Player extends Character {
    @Override
    public void play() {
        final String aimPositions = Console.readLine();
        validateIsNumericString(aimPositions);
        validateLength(aimPositions);
        validateDeduplicatedRandomString(aimPositions);
        decideAimPositions(aimPositions);
    }

    private void validateIsNumericString(String aimPositions) {
        try {
            Integer.parseInt(aimPositions);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("1~9사이 숫자만 입력해주세요");
        }
    }

    private void validateLength(String aimPositions) {
        if (aimPositions.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자를 입력해주세요.");
        }
    }
    private void validateDeduplicatedRandomString(String aimPositions) {
        final HashSet<String> validator = new HashSet<>();
        final String[] aimPositionsArray = aimPositions.split("");
        for (int index = 0; index < aimPositions.length(); index++) {
            validator.add(aimPositionsArray[index]);
        }
        if (aimPositionsArray.length != validator.size()) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
        }
    }
}
