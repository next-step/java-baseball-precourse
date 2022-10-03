package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputNumbersTest {

    private String input = "123";
    private List<Integer> inputList = Arrays.asList(1,2,3);

    @Test
    void getNumbersEqualsInput() {
        InputNumbers inputNumbers = new InputNumbers(input);
        assertThat(inputNumbers.getNumbers()).isEqualTo(inputList);
    }
}
