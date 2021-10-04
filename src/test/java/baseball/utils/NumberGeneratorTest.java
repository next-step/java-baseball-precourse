package baseball.utils;

import baseball.game.constant.GameRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    private static NumberGenerator numberGenerator;

    @BeforeAll
    public static void onlyOnce() {
        numberGenerator = new NumberGenerator(GameRule.START_INCLUSIVE, GameRule.END_INCLUSIVE);
    }

    @Test
    void testGenerateNumbers() {
        int count = GameRule.PICK_NUMBER_COUNT;
        String numbers = numberGenerator.generateNumbers(count);
        assertThat(numbers.length() == count).isTrue();
        assertThat(numbers.matches("[0-9]+")).isTrue();
        assertThat(containSameNumber(numbers)).isFalse();
    }

    private boolean containSameNumber(String numbers) {
        Set<String> numberSet = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            String number = String.valueOf(numbers.charAt(i));
            numberSet.add(number);
        }
        return numberSet.size() != GameRule.PICK_NUMBER_COUNT;
    }
}