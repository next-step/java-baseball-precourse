package baseball;

import baseball.model.BaseballService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputAnyNumberTest {

    BaseballService baseballService = new BaseballService();

    @Test
    void 입력받은_문자는_비어있으면_안된다() {
        String[] inputNotEmptyNumbers = {"empty", "1"};
        for (String inputNotEmptyNumber : inputNotEmptyNumbers) {
            assertEquals(baseballService.checkNotEmptyInputNumber(inputNotEmptyNumber), true);
        }

        String[] inputEmptyNumbers = {null, ""};
        for (String inputEmptyNumber : inputEmptyNumbers) {
            assertEquals(baseballService.checkNotEmptyInputNumber(inputEmptyNumber), false);
        }
    }

    @Test
    void 입력받은_문자는_숫자로만_이루어져야한다() {
        String[] inputAllNumbers = {"123", "1", "15000"};
        for (String inputAllNumber : inputAllNumbers) {
            assertEquals(baseballService.checkNumericInputNumber(inputAllNumber), true);
        }

        String[] inputNotAllNumbers = {"number", "num123ber", "12number3"};
        for (String inputNotAllNumber : inputNotAllNumbers) {
            assertEquals(baseballService.checkNumericInputNumber(inputNotAllNumber), false);
        }
    }

    @Test
    void 입력받은_숫자는_세글자여야한다() {
        String[] inputThreeLettersNumbers = {"123", "456", "789"};
        for (String inputThreeLettersNumber : inputThreeLettersNumbers) {
            assertEquals(baseballService.checkLengthInputNumber(inputThreeLettersNumber), true);
        }

        String[] inputNotThreeLettersNumbers = {"1", "12", "1234"};
        for (String inputNotThreeLettersNumber : inputNotThreeLettersNumbers) {
            assertEquals(baseballService.checkLengthInputNumber(inputNotThreeLettersNumber), false);
        }
    }

}
