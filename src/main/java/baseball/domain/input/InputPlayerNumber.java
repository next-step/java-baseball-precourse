package baseball.domain.input;

import static baseball.type.ErrorMessageType.INPUT_ALLOW_JUST_3_DIGIT_NUMBERS;
import static baseball.type.ErrorMessageType.INPUT_NOT_ALLOW_DUPLICATE;
import static baseball.type.GameSettingType.NUMBER_SIZE;
import static baseball.type.NumberRangeType.isNumberRangeType;
import static baseball.util.StringUtils.parseInt;

import baseball.domain.number.PlayerNumber;
import java.util.LinkedHashSet;
import java.util.Set;

public class InputPlayerNumber implements Input<PlayerNumber> {

    private final String input;

    public InputPlayerNumber(String input) {
        this.input = input;
    }

    @Override
    public void validate() {
        validateBlank(this.input);
        validateLength(this.input);
        validateNumber(this.input);
        validateDuplicate(this.input);
        validateRange(this.input);
    }

    @Override
    public PlayerNumber create() {
        return new PlayerNumber(this.input);
    }

    private void validateLength(String input) {
        if (input.length() != NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException(INPUT_ALLOW_JUST_3_DIGIT_NUMBERS.getMessage());
        }
    }

    private void validateNumber(String input) {
        parseInt(input);
    }

    private void validateDuplicate(String input) {
        Set<Character> characters = toCharacters(input);
        if (characters.size() != NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException(INPUT_NOT_ALLOW_DUPLICATE.getMessage());
        }
    }

    private Set<Character> toCharacters(String input) {
        Set<Character> characters = new LinkedHashSet<>();
        for (char character : input.toCharArray()) {
            characters.add(character);
        }
        return characters;
    }

    private void validateRange(String input) {
        for (char charAt : input.toCharArray()) {
            isNumberRangeType(Character.getNumericValue(charAt));
        }
    }
}
