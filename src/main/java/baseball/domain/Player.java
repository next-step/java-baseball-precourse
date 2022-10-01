package baseball.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private final int INPUT_SIZE = 3;

    private List<Integer> numberList;

    public Player(String playerInput) {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();

        for (char charAsInteger : playerInput.toCharArray()) {
            uniqueNumbers.add(StringToInteger(String.valueOf(charAsInteger)));
        }

        validateSize(playerInput);
        validateDuplicated(uniqueNumbers);
        validateZero(uniqueNumbers);

        this.numberList = new ArrayList<>(uniqueNumbers);
    }

    private Integer StringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private void validateSize(String input) {
        if (input.length() > INPUT_SIZE) {
            throw new IllegalArgumentException(String.format("입력 숫자은 %s자리를 넘을 수 없습니다. ", INPUT_SIZE));
        }
    }

    private void validateDuplicated(Set<Integer> uniqueNumbers) {
        if (uniqueNumbers.size() != INPUT_SIZE) {
            throw new IllegalArgumentException("같은 숫자는 입력하실 수 없습니다.");
        }
    }

    private void validateZero(Set<Integer> uniqueNumbers) {
        if (uniqueNumbers.contains(0)) {
            throw new IllegalArgumentException("숫자 0은 포함할 수 없습니다.");
        }
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
