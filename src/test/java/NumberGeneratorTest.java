import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {
    NumberGenerator numberGenerator = new NumberGenerator();
    final int LENGTH = 10;
    final int EPOCH = 10000;
    final int LO = 10;
    final int HI = 100;

    @Test
    @DisplayName("중복되지 않는지 확인")
    void generateMultipleNumberDistinct() {
        int[] numbers = numberGenerator.generateNumbersBetween(LENGTH, LO, HI);

        assertThat(numbers.length == LENGTH);
        Set<Integer> numberSet = new HashSet<>();
        for(int number : numbers){
            assertThat(!numberSet.contains(number));
            assertThat(number >= LO && number <= HI);

            numberSet.add(number);
        }
    }
}
