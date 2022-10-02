package baseball.domain.number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputNumberTest {


    @ParameterizedTest
    @ValueSource(strings = {"123", "467", "589"})
    void 입력길이_사이즈_3_체크(String input){
        InputNumber inputNumber = new InputNumber(input);

        int number = inputNumber.getInputNumber();
        String actualNum = String.valueOf(number);

        assertThat(actualNum).hasSize(3);

    }


}