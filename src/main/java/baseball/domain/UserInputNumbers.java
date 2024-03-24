package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserInputNumbers {

    private final List<GameNumber> gameNumbers;

    private UserInputNumbers(List<GameNumber> gameNumbers) {
        validate(gameNumbers);
        this.gameNumbers = gameNumbers;
    }

    public List<GameNumber> getGameNumbers() {
        return gameNumbers;
    }

    public static UserInputNumbers from(String input) {
        List<String> rawInputList = List.of(input.trim().split(""));

        List<GameNumber> response = new ArrayList<>();
        for (String string : rawInputList) {
            response.add(GameNumber.create(Integer.valueOf(string)));
        }

        return new UserInputNumbers(response);
    }

    private void validate(List<GameNumber> gameNumbers) {
        if (gameNumbers.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
        if (hasDuplication(gameNumbers)) {
            throw new IllegalArgumentException("입력 숫자에 중복된 숫자가 존재해선 안됩니다.");
        }
    }

    private static boolean hasDuplication(List<GameNumber> gameNumbers) {
        return new HashSet<>(gameNumbers).size() != gameNumbers.size();
    }
}
